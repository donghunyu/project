package project.spring.app.aprj.lib.object;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

import project.spring.app.zcom.lib.object.CommonDao;
import project.spring.app.zcom.lib.util.BigExcelResultHandler;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.FileUtil;
import project.spring.app.zcom.lib.util.SpreadsheetWriter;
import project.spring.app.zcom.lib.util.StringUtil;

public class AprjDao extends CommonDao {

	protected Log logger = LogFactory.getLog(getClass());

   
    /**
     * SqlSessionTemplate Bean 객체를 가져온다.
     * @param beanNm
     * @return
     */
    public SqlSessionTemplate getSqlSessionTemplate(String beanNm) {
        ApplicationContext appContext = ContextLoaderListener.getCurrentWebApplicationContext();
        SqlSessionTemplate sessionTemplate =  (SqlSessionTemplate) appContext.getBean(beanNm);
        return sessionTemplate;
    }
    
    
	/**
     * 대용량 엑셀파일을 서버에 특정파일(targetSheetFilePath)로 생성한다.
     * 
     * @param session
     *            db session
     * @param queryId
     *            ibatis에 명시한 쿼리 id
     * @param parameterObject
     *            sql parameter object
     * @param sheetMap
     *            엑셀 header명과 query column을 순서대로 정의해 놓은 map 객체
     * @param targetSheetFilePath
     *            최종 생성 엑셀파일 path+파일명
     * @param templeteSheetFilePath
     *            엘셀파일 생성을 위한 templete 엑셀파일 path+파일명
     * @param isTitle
     *            컬럼타이틀 출력여부.
     * @return int
     *            1 : 정상, 0 : 결과없음(엑셀 미작성).
     * @throws RuntimeException
     */
    protected File createExcelFile(SqlSession session, String queryId, Object parameterObject, LinkedHashMap<String, String> sheetMap, String filePath, String fileName, boolean isTitle) throws Exception {
        
        File file = getSerNumFile(filePath + fileName, "xlsx");
        
        String tempFilePath = filePath + UUID.randomUUID().toString().replaceAll("-", "")+ ".xml";
        
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            String       currDt   = DateUtil.getCurrentDate("yyyyMMdd");
            XSSFSheet    sheet    = workbook.createSheet(currDt);
            
            Map<String, XSSFCellStyle> wbStyle = null;
            
            // name of the zip entry holding sheet data, e.g.
            // /xl/worksheets/sheet1.xml
            String sheetRef = sheet.getPackagePart().getPartName().getName();
            
            // -----------------------------------------------
            // Step 1. save the template
            FileOutputStream os = null;
            try {
                os = new FileOutputStream(tempFilePath);
                workbook.write(os);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            } finally {
                os.close();
            }
            
            // -----------------------------------------------
            // Step 2. Generate XML file.
            File tmepXmlFile = File.createTempFile("sheet", ".xml");
            Writer fw = new OutputStreamWriter(new FileOutputStream(tmepXmlFile), "UTF-8");
            SpreadsheetWriter sw = new SpreadsheetWriter(fw);
            
            BigExcelResultHandler resultHandler = null;
            try {
                sw.beginSheet();
                
//                wbStyle = sw.createStyles(workbook);
                
                // ++++ db query 영역 ++++
                if (sheetMap != null) {
                	resultHandler = new BigExcelResultHandler(workbook, wbStyle, sw, sheetMap, isTitle);
                } else {
                	resultHandler = new BigExcelResultHandler(workbook, wbStyle, sw);
                }
                
                if (parameterObject == null) {
                    session.select(queryId, resultHandler);
                } else {
                    session.select(queryId, parameterObject, resultHandler);
                }
                // ++++ db query 영역 종료 ++++
                
                sw.endSheet();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            } finally {
                fw.close();
            }
            
            // -----------------------------------------------
            // Step 3. Substitute the template entry with the generated data
            FileOutputStream out = null;
            
            try {
                out = new FileOutputStream(file);
                sw.substitute(new File(tempFilePath), tmepXmlFile, sheetRef.substring(1), out);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            } finally {
                out.close();
            }
            
            FileUtil.deleteFile(new File(tempFilePath));
            FileUtil.deleteFile(tmepXmlFile  );
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
        return file;
    }
    
    
    public File getSerNumFile(String absoluteFileNm, String extension) {
    	int serNum = 1;
    	String s_serNum = "";
    	
		s_serNum = StringUtil.getLpad(Integer.toString(serNum), "0", 3);
    	File file = new File(absoluteFileNm + "_" + s_serNum + "." + extension);
    	if ( !file.exists() ) {
    		return file;
    	}
    	
    	do {
    		serNum++;
    		s_serNum = StringUtil.getLpad(Integer.toString(serNum), "0", 3);
    		file = new File(absoluteFileNm + "_" + s_serNum + "." + extension);
    	} while (file.exists());
    	
    	return file;
    }
    

}
