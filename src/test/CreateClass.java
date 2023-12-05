package test;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;

import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.FileUtil;
import project.spring.app.zcom.lib.util.StringUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CreateClass {
	
	public static void main(String[] args) {
		String filePath = "D:/Project/workspace/project/WebContent/doc/class.txt";

        File file = new File(filePath);
        
        if ( file.exists() == false ) {
            return;
        }
        

		CreateClass work = new CreateClass();
		work.connect();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String oneLine = null;
            
            while ( (oneLine = reader.readLine()) != null ) {

                if ( oneLine.trim().length() == 0 ) {
                    continue;
                }

                System.out.println(oneLine);
                String[] temp = oneLine.split("/");
        		String classId = temp[0];
        		String tableNm = temp[1];
        		String classNm = temp[2];
            	
        		System.out.println(classId);
        		System.out.println(tableNm);
        		System.out.println(classNm);
        		
        		work.makeClassFiles(classId, classNm, tableNm);
            }
            
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                if ( reader != null ) {
                    reader.close();
                }
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
	}

	public void makeClassFiles(String classId, String classNm, String tableNm) throws Exception {
		getTableInfo(tableNm);
		
//		makeTempFile      (classId, classNm, tableNm);

		
		
		
		makeControllerFile(classId, classNm, tableNm);
		makeServiceFile   (classId, classNm, tableNm);
		makeDaoFile       (classId, classNm, tableNm);
		makeSqlMapFile    (classId, classNm, tableNm);
		makeWebFile       (classId, classNm, tableNm);
	}
	
	public void makeTempFile(String classId, String classNm, String tableNm) throws Exception {
		
		String realUploadPath = ApplicationConstants_Aprj.TEMP_DIR_PATH + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/SERVICE/";
		FileUtil.mkdir(realUploadPath);
		
		String fileNm = realUploadPath + "Service.java";
        System.out.println("SERVICE NAME : " + fileNm);
        
        StringBuffer buffer = new StringBuffer();
		

		buffer.append("\n");
		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "삭제");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "삭제수");
		buffer.append("\n     */");
		buffer.append("\n    public int delete" + classId + "Co(AprjModel param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return dao" + classId + ".delete" + classId + "Co(param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");
		buffer.append("\n");

		buffer.append("\n}");
		
		writeFileContinue(fileNm, buffer);
	}
	
	
	

	
    public Connection  con      = null;
	public void connect() {
//		String  sUrl      = "jdbc:oracle:thin:@220.85.176.110:1521:RFIDTEST";
//		String  sUrl      = "jdbc:oracle:thin:@222.107.91.39:1521:BDDEV1";

//		String  sUrl      = "jdbc:oracle:thin:@222.107.91.39:1521:BDPRD1";
//		String  sUser     = "urfid";
//		String  sPassword = "urfid_bigdata";

		String  sUrl      = "jdbc:oracle:thin:@220.85.176.116:1521:RFID1"; 
		String  sUser     = "tandy";
		String  sPassword = "tandy_hanmi";

		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection( sUrl, sUser, sPassword);
        } catch ( Exception e ) {
            System.out.println("getConnection ERROR : " + e);
        }
	}

	
	public List<Column> columns;
	public void getTableInfo(String tableNm) {
		
        StringBuffer buffer = new StringBuffer();

        PreparedStatement pst = null;
        ResultSet         rs  = null;    
        
        buffer.append("            SELECT                                                        ");
        buffer.append("                     COL.TABLE_NAME                            tblNm      ");
        buffer.append("                   , COL.COLUMN_NAME                           colNm      ");
        buffer.append("                   , COL.COLUMN_ID                             colId      ");
        buffer.append("                   , DECODE(IDX.COLUMN_NAME, '', ' ', 'PK')    pkYn       ");
        buffer.append("                   , COL.DATA_TYPE                             dataTyp    ");
        buffer.append("                   , COL.DATA_LENGTH                           dataLen    ");
        buffer.append("                   , COL.NULLABLE                              nullYn     ");
        buffer.append("                   , COM.COMMENTS                              cmnt       ");
        buffer.append("            FROM     USER_TAB_COLUMNS  COL                                ");
        buffer.append("                                                                          ");
        buffer.append("                     LEFT OUTER JOIN ALL_IND_COLUMNS   IDX                ");
        buffer.append("                     ON     COL.TABLE_NAME  = IDX.TABLE_NAME              ");
        buffer.append("                     AND    COL.COLUMN_NAME = IDX.COLUMN_NAME             ");
        buffer.append("                     AND    IDX.INDEX_NAME LIKE '%_PK'                    ");
        buffer.append("                                                                          ");
        buffer.append("                     LEFT OUTER JOIN USER_COL_COMMENTS COM                ");
        buffer.append("                     ON     COL.TABLE_NAME  = COM.TABLE_NAME              ");
        buffer.append("                     AND    COL.COLUMN_NAME = COM.COLUMN_NAME             ");
        buffer.append("                                                                          ");
        buffer.append("            WHERE  1 = 1                                                  ");
        buffer.append("            AND    COL.TABLE_NAME  = '" + tableNm + "'");
        buffer.append("            ORDER BY                                                      ");
        buffer.append("                     COL.TABLE_NAME                                       ");
        buffer.append("                   , COL.COLUMN_ID                                        ");

        try {
            pst = con.prepareStatement(buffer.toString());
            rs = pst.executeQuery();

            
            columns = new ArrayList<Column>();
            
            while (rs.next()) {
                
                Column column = new Column();

                column.setTblNm     ( (String)     rs.getObject("TBLNM"   ));
                column.setColNm     ( (String)     rs.getObject("COLNM"   ));
                column.setColId     (((BigDecimal) rs.getObject("COLID"   )).toString());
                column.setPkYn      ( (String)     rs.getObject("PKYN"    ));
                column.setDataTyp   ( (String)     rs.getObject("DATATYP" ));
                column.setDataLen   (((BigDecimal) rs.getObject("DATALEN" )).toString());
                column.setNullYn    ( (String)     rs.getObject("NULLYN"  ));
                column.setCmnt      ( (String)     rs.getObject("CMNT"    ));
                columns.add(column);
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                if ( pst != null ) {
                    pst.close();
                }
                if ( rs != null ) {
                    rs.close();
                }
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
	}

	
	
	public void makeControllerFile(String classId, String classNm, String tableNm) throws Exception {
		
		String precessId = classId.toUpperCase();

		String realUploadPath = ApplicationConstants_Aprj.TEMP_DIR_PATH + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/CONTROLLER/";
		FileUtil.mkdir(realUploadPath);
		
		String fileNm = realUploadPath + classId + "Controller.java";
        System.out.println("CONTROLLER NAME : " + fileNm);

        
        StringBuffer buffer = new StringBuffer();
		
		
		buffer.append("/*-------------------------------------------------------------------");
		buffer.append("\n* NAME   : " + classId + "Controller"   );
		buffer.append("\n* DESC   : " + classNm);
		buffer.append("\n* Author : "                            );
		buffer.append("\n* DATE   : " + DateUtil.getCurrentDate());
		buffer.append("\n*--------------------------------------------------------------------");
		buffer.append("\n* 변 경 사 항                                                        ");
		buffer.append("\n*--------------------------------------------------------------------");
		buffer.append("\n* DATE       AUTHOR DESCRIPTION                                      ");
		buffer.append("\n* ---------- ------ -------------------------------------------------");
		buffer.append("\n*                                                                    ");
		buffer.append("\n*------------------------------------------------------------------*/");
		buffer.append("\n");
		buffer.append("\npackage project.spring.app.controller;");
		buffer.append("\n");

		buffer.append("\nimport javax.servlet.http.HttpServletRequest;");
		buffer.append("\n");
		buffer.append("\nimport org.springframework.beans.factory.annotation.Autowired;");
		buffer.append("\nimport org.springframework.stereotype.Controller;");
		buffer.append("\nimport org.springframework.web.bind.annotation.RequestMapping;");
		buffer.append("\nimport org.springframework.web.bind.annotation.ResponseBody;");
		buffer.append("\nimport org.springframework.web.servlet.ModelAndView;");
		buffer.append("\n");
		buffer.append("\nimport project.spring.app.a.lib.object.CommonException;");
		buffer.append("\nimport project.spring.app.constants.ActionConstants_Aprj;");
		buffer.append("\nimport project.spring.app.constants.ViewConstants_Aprj;");
		buffer.append("\nimport project.spring.app.constants.GrpCdConstants;");
		buffer.append("\nimport project.spring.app.service." + classId + "Service;");
		buffer.append("\nimport project.spring.app.service.lib.model." + classId + "Model;");
		buffer.append("\nimport project.spring.app.service.lib.object.AprjController;");
		buffer.append("\n");
		
		buffer.append("\n");
		buffer.append("\n@Controller");
		buffer.append("\npublic class " + classId + "Controller extends AprjController {");
		buffer.append("\n");
		buffer.append("\n    @Autowired");
		buffer.append("\n    " + classId +"Service service" + classId + ";");
		buffer.append("\n");
		buffer.append("\n    private String resultList                     = \"resultList\"                  ;  // 리스트결과");
		buffer.append("\n    private String resultListCnt                  = \"resultListCnt\"               ;  // 리스트결과수");
		buffer.append("\n    private String resultCnt                      = \"resultCnt\"                   ;  // 결과수");
		buffer.append("\n    private String resultObject                   = \"resultObject\"                ;  // 검색결과");
		buffer.append("\n");
		
        for ( int i = 0; i < columns.size(); i++ ) {
			if ( columns.get(i).getColNm().endsWith("_CD") ) {
				buffer.append("\n    private String " + makeDocString(columns.get(i).getAliasNm() + "List", 30) + " = " + makeDocString("\"" + columns.get(i).getAliasNm() + "List\"", 30) + ";  // " + makeDocString(columns.get(i).getCmnt() + "리스트", 30));
        	}
		}
		
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "리스트조회");
		buffer.append("\n     *");
		buffer.append("\n     * @param request HttpServletRequest");
		buffer.append("\n     * @param response HttpServletResponse");
		buffer.append("\n     * @return ModelAndView ModelAndView객체");
		buffer.append("\n     * @exception Exception 처리 에러발생.");
		buffer.append("\n     */");
		buffer.append("\n    @RequestMapping(ActionConstants_Aprj.ACTION_" + precessId + "_40)");
		buffer.append("\n    public @ResponseBody Object srch" + classId + "List(HttpServletRequest request) throws CommonException {");
		buffer.append("\n        ModelAndView modelAndView = new ModelAndView();");
		buffer.append("\n        this.init(request, modelAndView);");
		buffer.append("\n");
		buffer.append("\n        // 사용자 로그인여부");
		buffer.append("\n        if ( !this.isLogin(request, modelAndView, true, true) ) {");
		buffer.append("\n            return returnResponse(modelAndView);");
		buffer.append("\n        }");
		buffer.append("\n");
		buffer.append("\n        " + classId +"Model param = new " + classId +"Model();");
		buffer.append("\n        getParameter(request, param);");
		buffer.append("\n        setCoInfo(request, modelAndView, param);");
		buffer.append("\n");
		
        for ( int i = 0; i < columns.size(); i++ ) {
			if ( columns.get(i).getColNm().endsWith("_CD") ) {
				buffer.append("\n        // " + columns.get(i).getCmnt());
				buffer.append("\n        modelAndView.addObject(" + makeDocString(columns.get(i).getAliasNm() + "List", 30) + ", getGrpCdList(GrpCdConstants." + makeDocString(columns.get(i).getColNm(), 30) + "));");
				buffer.append("\n");
        	}
		}
		
		buffer.append("\n        modelAndView.addObject(resultList   , service" + classId + ".srch" + classId +"List(param));");
		buffer.append("\n        modelAndView.addObject(resultListCnt, service" + classId + ".srch" + classId +"Cnt (param));");
		buffer.append("\n");
		buffer.append("\n        modelAndView.setViewName(ViewConstants_Aprj.VIEW_" + precessId + "_40);");
		buffer.append("\n        return returnResponse(modelAndView);");
		buffer.append("\n    }");
		buffer.append("\n");
		buffer.append("\n");
		
		
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "조회");
		buffer.append("\n     *");
		buffer.append("\n     * @param request HttpServletRequest");
		buffer.append("\n     * @param response HttpServletResponse");
		buffer.append("\n     * @return ModelAndView ModelAndView객체");
		buffer.append("\n     * @exception Exception 처리 에러발생.");
		buffer.append("\n     */");
		buffer.append("\n    @RequestMapping(ActionConstants_Aprj.ACTION_" + precessId + "_41)");
		buffer.append("\n    public @ResponseBody Object srch" + classId + "(HttpServletRequest request) throws CommonException {");
		buffer.append("\n        ModelAndView modelAndView = new ModelAndView();");
		buffer.append("\n        this.init(request, modelAndView);");
		buffer.append("\n");
		buffer.append("\n        // 사용자 로그인여부");
		buffer.append("\n        if ( !this.isLogin(request, modelAndView) ) {");
		buffer.append("\n            return returnResponse(modelAndView);");
		buffer.append("\n        }");
		buffer.append("\n");
		buffer.append("\n        " + classId +"Model param = new " + classId +"Model();");
		buffer.append("\n        getParameter(request, param);");
		buffer.append("\n");
		buffer.append("\n        modelAndView.addObject(resultObject , service" + classId + ".srch" + classId +"(param));");
		buffer.append("\n");
		buffer.append("\n        modelAndView.setViewName(ViewConstants_Aprj.VIEW_" + precessId + "_41);");
		buffer.append("\n        return returnResponse(modelAndView);");
		buffer.append("\n    }");
		buffer.append("\n");
		buffer.append("\n");
		
		
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "저장");
		buffer.append("\n     *");
		buffer.append("\n     * @param request HttpServletRequest");
		buffer.append("\n     * @param response HttpServletResponse");
		buffer.append("\n     * @return ModelAndView ModelAndView객체");
		buffer.append("\n     * @exception Exception 처리 에러발생.");
		buffer.append("\n     */");
		buffer.append("\n    @RequestMapping(ActionConstants_Aprj.ACTION_" + precessId + "_00)");
		buffer.append("\n    public @ResponseBody Object save" + classId + "(HttpServletRequest request) throws CommonException {");
		buffer.append("\n        ModelAndView modelAndView = new ModelAndView();");
		buffer.append("\n        this.init(request, modelAndView);");
		buffer.append("\n");
		buffer.append("\n        // 사용자 로그인여부");
		buffer.append("\n        if ( !this.isLogin(request, modelAndView) ) {");
		buffer.append("\n            return returnResponse(modelAndView);");
		buffer.append("\n        }");
		buffer.append("\n");
		buffer.append("\n        " + classId +"Model param = new " + classId +"Model();");
		buffer.append("\n        getParameter(request, param);");
		buffer.append("\n");
		buffer.append("\n        int cnt = 0;");
		buffer.append("\n        cnt = service" + classId + ".save" + classId +"(param);");
		buffer.append("\n");
		buffer.append("\n        modelAndView = (ModelAndView) srch" + classId +"List(request);");
		buffer.append("\n        modelAndView.addObject(resultCnt    , cnt);");
		buffer.append("\n        return returnResponse(modelAndView);");
		buffer.append("\n    }");
		buffer.append("\n");
		buffer.append("\n");
		
		
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "삭제");
		buffer.append("\n     *");
		buffer.append("\n     * @param request HttpServletRequest");
		buffer.append("\n     * @param response HttpServletResponse");
		buffer.append("\n     * @return ModelAndView ModelAndView객체");
		buffer.append("\n     * @exception Exception 처리 에러발생.");
		buffer.append("\n     */");
		buffer.append("\n    @RequestMapping(ActionConstants_Aprj.ACTION_" + precessId + "_80)");
		buffer.append("\n    public @ResponseBody Object delete" + classId + "(HttpServletRequest request) throws CommonException {");
		buffer.append("\n        ModelAndView modelAndView = new ModelAndView();");
		buffer.append("\n        this.init(request, modelAndView);");
		buffer.append("\n");
		buffer.append("\n        // 사용자 로그인여부");
		buffer.append("\n        if ( !this.isLogin(request, modelAndView) ) {");
		buffer.append("\n            return returnResponse(modelAndView);");
		buffer.append("\n        }");
		buffer.append("\n");
		buffer.append("\n        int cnt = 0;");
		buffer.append("\n        String[] delKeys = request.getParameterValues(\"delKey\");");
		buffer.append("\n        " + classId +"Model param = new " + classId +"Model();");
		buffer.append("\n        for ( int i = 0; i < delKeys.length; i++ ) {");

		for ( int i = 0; i < columns.size(); i++ ) {
			if ( !"PK".equals(columns.get(i).getPkYn()) ) {
				continue;
			}
			
			String srchColumn = columns.get(i).getAliasNm();
			srchColumn = "set" + srchColumn.substring(0, 1).toUpperCase() + srchColumn.substring(1);
			buffer.append("\n            param." + srchColumn + "(delKeys[i]);");
		}

		buffer.append("\n");
		buffer.append("\n            cnt =+ service" + classId + ".delete" + classId +"(param);");
		buffer.append("\n        }");
		buffer.append("\n");
		buffer.append("\n        modelAndView = (ModelAndView) srch" + classId +"List(request);");
		buffer.append("\n        modelAndView.addObject(resultCnt    , cnt);");
		buffer.append("\n        return returnResponse(modelAndView);");
		buffer.append("\n    }");
		buffer.append("\n}");
		
		writeFile(fileNm, buffer);

	
	
		
		fileNm = realUploadPath + "ActionConstants_Aprj.java";
        System.out.println("CONTROLLER NAME : " + fileNm);
        
        buffer.delete(0, buffer.length());
	
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "리스트조회");
		buffer.append("\n     */");
		buffer.append("\n    public static final String ACTION_" + classId.toUpperCase() + "_40 = \"" + classId.toLowerCase() + "_40.do\";");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "상세조회");
		buffer.append("\n     */");
		buffer.append("\n    public static final String ACTION_" + classId.toUpperCase() + "_41 = \"" + classId.toLowerCase() + "_41.do\";");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "저장");
		buffer.append("\n     */");
		buffer.append("\n    public static final String ACTION_" + classId.toUpperCase() + "_00 = \"" + classId.toLowerCase() + "_00.do\";");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "삭제");
		buffer.append("\n     */");
		buffer.append("\n    public static final String ACTION_" + classId.toUpperCase() + "_80 = \"" + classId.toLowerCase() + "_80.do\";");
		buffer.append("\n");
		buffer.append("\n");

		writeFileContinue(fileNm, buffer);
	
		
		
		
		fileNm = realUploadPath + "ViewConstants_Aprj.java";
        System.out.println("CONTROLLER NAME : " + fileNm);

        
        buffer.delete(0, buffer.length());
	
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "리스트조회");
		buffer.append("\n     */");
		buffer.append("\n    public static final String VIEW_" + classId.toUpperCase() + "_40 = \"" + classId.substring(0, classId.length() - 3).toLowerCase() + "/" + classId.substring(classId.length() - 3, classId.length() - 3 + 2).toLowerCase() + "0/" + classId.toLowerCase() + "_40\";");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "상세조회");
		buffer.append("\n     */");
		buffer.append("\n    public static final String VIEW_" + classId.toUpperCase() + "_41 = \"" + classId.substring(0, classId.length() - 3).toLowerCase() + "/" + classId.substring(classId.length() - 3, classId.length() - 3 + 2).toLowerCase() + "0/" + classId.toLowerCase() + "_41\";");
		buffer.append("\n");
		buffer.append("\n");

		writeFileContinue(fileNm, buffer);

		
		
		
		
		fileNm = realUploadPath + "GrpCdConstants.java";
        System.out.println("CONTROLLER NAME : " + fileNm);
        
        buffer.delete(0, buffer.length());
	
        for ( int i = 0; i < columns.size(); i++ ) {
			if ( columns.get(i).getColNm().endsWith("_CD") ) {
				buffer.append("\n        public static final String " + makeDocString(columns.get(i).getColNm(), 30) + " = \"APRJ000001\";    // "+ columns.get(i).getCmnt());
				buffer.append("\n");
        	}
		}

		writeFileContinue(fileNm, buffer);

	
	

		
		fileNm = realUploadPath + "sqlMapConfig1.xml";
        System.out.println("CONTROLLER NAME : " + fileNm);

        
        buffer.delete(0, buffer.length());
	
        

        buffer.append("\n        <typeAlias alias=\"" + classId + "Model\" type=\"project.spring.app.service.lib.model." + classId + "Model\" />     " + makeDocString("<!-- " + classNm, 30) + " -->");

		writeFileContinue(fileNm, buffer);
	
		
		
		
		fileNm = realUploadPath + "sqlMapConfig2.xml";
        System.out.println("CONTROLLER NAME : " + fileNm);

        
        buffer.delete(0, buffer.length());
	
		buffer.append("\n        <mapper resource=\"resource/sql/map/" + classId.substring(0, classId.length() - 3).toLowerCase() + "/sqlMap-" + classId + ".xml\" />     " + makeDocString("<!-- " + classNm, 30) + " -->");

		writeFileContinue(fileNm, buffer);
	
	}
	

	
	
	
	public void makeServiceFile(String classId, String classNm, String tableNm) throws Exception {
		
		String realUploadPath = ApplicationConstants_Aprj.TEMP_DIR_PATH + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/SERVICE/";
		FileUtil.mkdir(realUploadPath);
		
		String fileNm = realUploadPath + classId + "Service.java";
        System.out.println("SERVICE NAME : " + fileNm);
        
        StringBuffer buffer = new StringBuffer();
		
		buffer.append("/*-------------------------------------------------------------------");
		buffer.append("\n* NAME   : " + classId + "Service");
		buffer.append("\n* DESC   : " + classNm);
		buffer.append("\n* Author : ");
		buffer.append("\n* DATE   : " + DateUtil.getCurrentDate());
		buffer.append("\n*--------------------------------------------------------------------");
		buffer.append("\n* 변 경 사 항                                                        ");
		buffer.append("\n*--------------------------------------------------------------------");
		buffer.append("\n* DATE       AUTHOR DESCRIPTION                                      ");
		buffer.append("\n* ---------- ------ -------------------------------------------------");
		buffer.append("\n*                                                                    ");
		buffer.append("\n*------------------------------------------------------------------*/");
		buffer.append("\n");
		buffer.append("\npackage project.spring.app.service;");
		buffer.append("\n");
		buffer.append("\nimport java.util.List;");
		buffer.append("\n");
		buffer.append("\nimport org.springframework.beans.factory.annotation.Autowired;");
		buffer.append("\nimport org.springframework.stereotype.Service;");

		buffer.append("\n");
		buffer.append("\nimport project.spring.app.a.lib.object.CommonException;");
		buffer.append("\nimport project.spring.app.service.lib.dao." + classId + "Dao;");
		buffer.append("\nimport project.spring.app.service.lib.model." + classId + "Model;");
		buffer.append("\nimport project.spring.app.service.lib.object.AprjModel;");
		buffer.append("\nimport project.spring.app.service.lib.object.AprjService;");
		buffer.append("\n");
		
		buffer.append("\n@Service");
		buffer.append("\npublic class " + classId + "Service extends AprjService {");
		buffer.append("\n");
		buffer.append("\n    @Autowired");
		buffer.append("\n    private " + classId + "Dao dao" + classId + ";");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "검색리스트");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return List<" + classId + "Model> " + classNm + "리스트");
		buffer.append("\n     */");
		buffer.append("\n    public List<" + classId + "Model> srch" + classId + "List(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return dao" + classId + ".srch" + classId + "List(param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "검색리스트수");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return String " + classNm + "리스트수");
		buffer.append("\n     */");
		buffer.append("\n    public String srch" + classId + "Cnt(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return dao" + classId + ".srch" + classId + "Cnt(param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "검색");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return " + classId + "Model " + classNm);
		buffer.append("\n     */");
		buffer.append("\n    public " + classId + "Model srch" + classId + "(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return dao" + classId + ".srch" + classId + "(param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "저장");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "저장수");
		buffer.append("\n     */");
		buffer.append("\n    public int save" + classId + "(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            int nCount = update" + classId + "(param);");
		buffer.append("\n            if ( nCount == 0 ) {");
		buffer.append("\n                nCount = insert" + classId + "(param);");
		buffer.append("\n            }");
		buffer.append("\n            return nCount;");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "입력");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "입력수");
		buffer.append("\n     */");
		buffer.append("\n    public int insert" + classId + "(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return dao" + classId + ".insert" + classId + "(param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "수정");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "수정수");
		buffer.append("\n     */");
		buffer.append("\n    public int update" + classId + "(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return dao" + classId + ".update" + classId + "(param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "삭제");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "삭제수");
		buffer.append("\n     */");
		buffer.append("\n    public int delete" + classId + "(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return dao" + classId + ".delete" + classId + "(param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "삭제");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "삭제수");
		buffer.append("\n     */");
		buffer.append("\n    public int delete" + classId + "All() throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return dao" + classId + ".delete" + classId + "All();");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");
		
		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "삭제");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "삭제수");
		buffer.append("\n     */");
		buffer.append("\n    public int delete" + classId + "Co(AprjModel param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return dao" + classId + ".delete" + classId + "Co(param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");
		
		buffer.append("\n}");
		
		writeFile(fileNm, buffer);
	}
	
	
	public void makeDaoFile(String classId, String classNm, String tableNm) throws Exception {
		
		String realUploadPath = ApplicationConstants_Aprj.TEMP_DIR_PATH + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/DAO/";
		FileUtil.mkdir(realUploadPath);
		
		String fileNm = realUploadPath + classId + "Dao.java";
        System.out.println("DAO NAME : " + fileNm);
        
        StringBuffer buffer = new StringBuffer();
		
		buffer.append("/*-------------------------------------------------------------------");
		buffer.append("\n* NAME   : " + classId + "Dao");
		buffer.append("\n* DESC   : " + classNm);
		buffer.append("\n* Author : ");
		buffer.append("\n* DATE   : " + DateUtil.getCurrentDate());
		buffer.append("\n*--------------------------------------------------------------------");
		buffer.append("\n* 변 경 사 항                                                        ");
		buffer.append("\n*--------------------------------------------------------------------");
		buffer.append("\n* DATE       AUTHOR DESCRIPTION                                      ");
		buffer.append("\n* ---------- ------ -------------------------------------------------");
		buffer.append("\n*                                                                    ");
		buffer.append("\n*------------------------------------------------------------------*/");
		buffer.append("\n");
		buffer.append("\npackage project.spring.app.service.lib.dao;");
		buffer.append("\n");
		buffer.append("\nimport project.spring.app.a.lib.object.CommonException;");
		buffer.append("\nimport project.spring.app.service.lib.model." + classId + "Model;");
		buffer.append("\nimport project.spring.app.service.lib.object.AprjDao;");
		buffer.append("\nimport project.spring.app.service.lib.object.AprjModel;");
		buffer.append("\n");
		buffer.append("\nimport java.util.List;");
		buffer.append("\n");
		buffer.append("\nimport org.springframework.stereotype.Repository;");
		buffer.append("\nimport org.springframework.transaction.annotation.Transactional;");
		buffer.append("\n");
		
		buffer.append("\n@Repository");
		buffer.append("\n@Transactional");
		buffer.append("\npublic class " + classId + "Dao extends AprjDao {");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "검색리스트");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return List<" + classId + "Model> " + classNm + "리스트");
		buffer.append("\n     */");
		buffer.append("\n    public List<" + classId + "Model> srch" + classId + "List(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return sessionConn.selectList(\"" + classId + "Query.select" + tableNm + "_00\", param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "검색리스트수");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return String " + classNm + "리스트수");
		buffer.append("\n     */");
		buffer.append("\n    public String srch" + classId + "Cnt(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return ((" + classId + "Model) sessionConn.selectOne(\"" + classId + "Query.select" + tableNm + "_01\", param)).getTotCnt();");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "검색");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return " + classId + "Model " + classNm);
		buffer.append("\n     */");
		buffer.append("\n    public " + classId + "Model srch" + classId + "(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return (" + classId + "Model) sessionConn.selectOne(\"" + classId + "Query.select" + tableNm + "_02\", param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "입력");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "입력수");
		buffer.append("\n     */");
		buffer.append("\n    public int insert" + classId + "(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return sessionConn.update(\"" + classId + "Query.insert" + tableNm + "_00\", param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "수정");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "수정수");
		buffer.append("\n     */");
		buffer.append("\n    public int update" + classId + "(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return sessionConn.update(\"" + classId + "Query.update" + tableNm + "_00\", param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "삭제");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "삭제수");
		buffer.append("\n     */");
		buffer.append("\n    public int delete" + classId + "(" + classId + "Model param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return sessionConn.update(\"" + classId + "Query.delete" + tableNm + "_00\", param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "삭제");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "삭제수");
		buffer.append("\n     */");
		buffer.append("\n    public int delete" + classId + "All() throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return sessionConn.update(\"" + classId + "Query.delete" + tableNm + "_01\", param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n");
		buffer.append("\n    /**");
		buffer.append("\n     * " + classNm + "삭제");
		buffer.append("\n     * @param " + classId + "Model " + classNm);
		buffer.append("\n     * @return int " + classNm + "삭제수");
		buffer.append("\n     */");
		buffer.append("\n    public int delete" + classId + "Co(AprjModel param) throws CommonException {");
		buffer.append("\n        try {");
		buffer.append("\n            return sessionConn.update(\"" + classId + "Query.delete" + tableNm + "_02\", param);");
		buffer.append("\n        } catch ( Exception e) {");
		buffer.append("\n            throw new CommonException(e);");
		buffer.append("\n        }");
		buffer.append("\n    }");
		buffer.append("\n");

		buffer.append("\n}");
		
		writeFile(fileNm, buffer);
	}

	public void makeSqlMapFile(String classId, String classNm, String tableNm) throws Exception {
		
		HashMap<String, String> exceptList = new HashMap<String, String>();
		exceptList.put("EFF_STA_DT"   , "");
		exceptList.put("EFF_END_DT"   , "");
		exceptList.put("RGST_DTM"     , "");
		exceptList.put("RGST_IP"      , "");
		exceptList.put("RGST_ID"      , "");
		exceptList.put("UPDT_DTM"     , "");
		exceptList.put("UPDT_IP"      , "");
		exceptList.put("UPDT_ID"      , "");
		exceptList.put("DEL_YN"       , "");
		
		HashMap<String, String> rgstList = new HashMap<String, String>();
		rgstList.put("RGST_DTM"     , "");
		rgstList.put("RGST_IP"      , "");
		rgstList.put("RGST_ID"      , "");
		rgstList.put("UPDT_DTM"     , "");
		rgstList.put("UPDT_IP"      , "");
		rgstList.put("UPDT_ID"      , "");
		
		String realUploadPath = ApplicationConstants_Aprj.TEMP_DIR_PATH + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/MODEL/";
		FileUtil.mkdir(realUploadPath);
		
		String fileNm = realUploadPath + classId + "Model.java";
        System.out.println("MODEL NAME : " + fileNm);
        
        StringBuffer buffer = new StringBuffer();
		
		buffer.append("/*-------------------------------------------------------------------");
		buffer.append("\n* NAME   : " + classId + "Model");
		buffer.append("\n* DESC   : " + classNm);
//		buffer.append("\n* Author : " + sessionUser.getUserNm());
		buffer.append("\n* DATE   : " + DateUtil.getCurrentDate());
		buffer.append("\n*--------------------------------------------------------------------");
		buffer.append("\n* 변 경 사 항                                                        ");
		buffer.append("\n*--------------------------------------------------------------------");
		buffer.append("\n* DATE       AUTHOR DESCRIPTION                                      ");
		buffer.append("\n* ---------- ------ -------------------------------------------------");
		buffer.append("\n*                                                                    ");
		buffer.append("\n*------------------------------------------------------------------*/");
		buffer.append("\n");
		buffer.append("\npackage project.spring.app.service.lib.model;");
		buffer.append("\n");

		buffer.append("\nimport project.spring.app.service.lib.object.AprjModel;");
		buffer.append("\n");
		buffer.append("\npublic class " + classId + "Model extends AprjModel {");
		buffer.append("\n");
		
		for ( int i = 0; i < columns.size(); i++ ) {
			if ( exceptList.get(columns.get(i).getColNm()) != null ) {
				continue;
			}
			
			String srchColumn = columns.get(i).getAliasNm();
			srchColumn = "srch" + srchColumn.substring(0, 1).toUpperCase() + srchColumn.substring(1);
	
			buffer.append("\n    private String " + makeDocString(srchColumn, 30) + ";");
			buffer.append("    /* 검색" + makeDocString(columns.get(i).getCmnt(), 30) + " */");
		}
		buffer.append("\n");

		for ( int i = 0; i < columns.size(); i++ ) {
			if ( exceptList.get(columns.get(i).getColNm()) != null ) {
				continue;
			}
			
			buffer.append("\n    private String " + makeDocString(columns.get(i).getAliasNm(), 30) + ";");
			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
		}
		buffer.append("\n");
		buffer.append("\n");
		
		
		for ( int i = 0; i < columns.size(); i++ ) {
			if ( exceptList.get(columns.get(i).getColNm()) != null ) {
				continue;
			}
			
			String column   = "srch" + columns.get(i).getAliasNm().substring(0, 1).toUpperCase() + columns.get(i).getAliasNm().substring(1);
			String function = column.substring(0, 1).toUpperCase() + column.substring(1);
	        buffer.append("\n    public String get" + function + "() {");
	        buffer.append("\n        return " + column + ";");
	        buffer.append("\n    }");
			buffer.append("\n");
	        buffer.append("\n    public void set" + function + "(String " + column + ") {");
	        buffer.append("\n        this." + column + " = " + column + ";");
	        buffer.append("\n    }");
			buffer.append("\n");
		}
		
		for ( int i = 0; i < columns.size(); i++ ) {
			if ( exceptList.get(columns.get(i).getColNm()) != null ) {
				continue;
			}
			
			String column   = columns.get(i).getAliasNm();
			String function = column.substring(0, 1).toUpperCase() + column.substring(1);
	        buffer.append("\n    public String get" + function + "() {");
	        buffer.append("\n        return " + column + ";");
	        buffer.append("\n    }");
			buffer.append("\n");
	        buffer.append("\n    public void set" + function + "(String " + column + ") {");
	        buffer.append("\n        this." + column + " = " + column + ";");
	        buffer.append("\n    }");
			buffer.append("\n");
		}
		
		buffer.append("\n}");
		
		writeFile(fileNm, buffer);
		
		
		
		
		
		fileNm = realUploadPath + "sqlMap-" + classId + ".xml";
        System.out.println("SQL MAP NAME : " + fileNm);
        
        buffer.delete(0, buffer.length());
		
        buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        buffer.append("\n<!DOCTYPE mapper");
        buffer.append("\n    PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"");
        buffer.append("\n    \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
        buffer.append("\n<mapper namespace=\"" + classId + "Query\">");
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("\n    <sql id=\"WhereQuery\" >");
        
		for ( int i = 0; i < columns.size(); i++ ) {
			if ( exceptList.get(columns.get(i).getColNm()) != null ) {
				continue;
			}
			
			String srchColumn = columns.get(i).getAliasNm();
			srchColumn = "srch" + srchColumn.substring(0, 1).toUpperCase() + srchColumn.substring(1);
	        buffer.append("\n        <if test=\"@project.spring.app.a.lib.object.CommonMyBatis@isNotEmpty(" + srchColumn + ")\">");
	        buffer.append("\n            AND    " + tableNm + "." + makeDocString(columns.get(i).getColNm(), 30) + " = #{" + srchColumn + "}");
	        buffer.append("\n        </if>");
		}

        buffer.append("\n    </sql>");
        buffer.append("\n");
        buffer.append("\n");

        buffer.append("\n    <sql id=\"InlineViewQuery\" >");
        buffer.append("\n        <![CDATA[");
        buffer.append("\n            SELECT");

        for ( int i = 0; i < columns.size(); i++ ) {
			if ( rgstList.get(columns.get(i).getColNm()) != null ) {
				continue;
			}
        	if ( i == 0 ) {
            	buffer.append("\n                     " + tableNm + "." + makeDocString(columns.get(i).getColNm(), 30) + makeDocString(columns.get(i).getAliasNm(), 30));
    			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
        		continue;
        	} 
        	buffer.append("\n                   , " + tableNm + "." + makeDocString(columns.get(i).getColNm(), 30) + makeDocString(columns.get(i).getAliasNm(), 30));
			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
        }
        
        buffer.append("\n");
		buffer.append("\n                   , " + tableNm + ".RGST_ID                       rgstId                            /* 등록 ID                        */");
        buffer.append("\n                   , RGST     .USER_NM                       rgstNm                            /* 등록 명                        */");
		buffer.append("\n                   , " + tableNm + ".RGST_IP                       rgstIp                            /* 등록 IP                        */");
		buffer.append("\n                   , " + tableNm + ".RGST_DTM                      rgstDtm                           /* 등록 일시                      */");
		buffer.append("\n                   , " + tableNm + ".UPDT_ID                       updtId                            /* 수정 ID                        */");
        buffer.append("\n                   , UPDT     .USER_NM                       updtNm                            /* 수정 명                        */");
		buffer.append("\n                   , " + tableNm + ".UPDT_IP                       updtIp                            /* 수정 IP                        */");
		buffer.append("\n                   , " + tableNm + ".UPDT_DTM                      updtDtm                           /* 수정 일시                      */");
        buffer.append("\n");
        
        
        buffer.append("\n            FROM   " + tableNm);

        buffer.append("\n");
		buffer.append("\n                   LEFT OUTER JOIN ZCOM99030 RGST");
		buffer.append("\n                   ON     RGST.USER_ID = " + tableNm + ".RGST_ID");
        buffer.append("\n");
		buffer.append("\n                   LEFT OUTER JOIN ZCOM99030 UPDT");
		buffer.append("\n                   ON     UPDT.USER_ID = " + tableNm + ".UPDT_ID");
        buffer.append("\n");

		buffer.append("\n            WHERE  1 = 1");
		buffer.append("\n        ]]>");
		buffer.append("\n    </sql>");
		buffer.append("\n");
        buffer.append("\n");

		buffer.append("\n    <!-- " + classNm + "리스트조회 -->");
		buffer.append("\n    <select id=\"select" + tableNm + "_00\" parameterType=\"" + classId + "Model\" resultType=\"" + classId + "Model\" >");
		buffer.append("\n        <include refid=\"Zcom99000Query.PagingTop\" />");
		buffer.append("\n        <include refid=\"InlineViewQuery\" />");
		buffer.append("\n        <include refid=\"WhereQuery\" />");
		buffer.append("\n        <![CDATA[");
		buffer.append("\n            ORDER BY ");
		
        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( !"PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}
        	
        	if ( i == 0 ) {
            	buffer.append("\n                     " + tableNm + "." + makeDocString(columns.get(i).getColNm(), 30));
        		continue;
        	} 
        	buffer.append("\n                   , " + tableNm + "." + makeDocString(columns.get(i).getColNm(), 30));
		}

		buffer.append("\n        ]]>");
		buffer.append("\n        <include refid=\"Zcom99000Query.PagingBottom\" />");
		buffer.append("\n    </select>");
		buffer.append("\n");

		buffer.append("\n    <!-- " + classNm + "리스트수조회 -->");
		buffer.append("\n    <select id=\"select" + tableNm + "_01\" parameterType=\"" + classId + "Model\" resultType=\"" + classId + "Model\" >");
		buffer.append("\n        <![CDATA[");
		buffer.append("\n            SELECT");
		buffer.append("\n                     COUNT(*) totCnt");
		buffer.append("\n            FROM   (");
		buffer.append("\n        ]]>");
		buffer.append("\n        <include refid=\"InlineViewQuery\"/>");
		buffer.append("\n        <include refid=\"WhereQuery\" />");
		buffer.append("\n        <![CDATA[");
		buffer.append("\n                   ) TOT");
		buffer.append("\n        ]]>");
		buffer.append("\n    </select>");
		buffer.append("\n");
        buffer.append("\n");
		
		buffer.append("\n    <!-- " + classNm + "조회 -->");
		buffer.append("\n    <select id=\"select" + tableNm + "_02\" parameterType=\"" + classId + "Model\" resultType=\"" + classId + "Model\" >");
		buffer.append("\n        <include refid=\"InlineViewQuery\" />");
		buffer.append("\n        <![CDATA[");
        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( !"PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}
        	
        	buffer.append("\n            AND    " + tableNm + "." + makeDocString(columns.get(i).getColNm(), 30) + " = " + makeDocString("#{" + columns.get(i).getAliasNm() + "}", 30));
			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
		}
		buffer.append("\n        ]]>");
		buffer.append("\n    </select>");
		buffer.append("\n");
        buffer.append("\n");

		buffer.append("\n    <!-- " + classNm + "등록 -->");
		buffer.append("\n    <insert id=\"insert" + tableNm + "_00\" parameterType=\"" + classId + "Model\" >");
		buffer.append("\n        <![CDATA[");
		buffer.append("\n            INSERT INTO " + tableNm);
		buffer.append("\n            (");
		
        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( i == 0 ) {
            	buffer.append("\n                     " + makeDocString(columns.get(i).getColNm(), 30));
    			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
        		continue;
        	} 
        	buffer.append("\n                   , " + makeDocString(columns.get(i).getColNm(), 30));
			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
		}

		buffer.append("\n            ) VALUES (");

        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( i == 0 ) {
            	buffer.append("\n                     " + makeDocString("#{" + columns.get(i).getAliasNm() + "}", 30));
    			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
        		continue;
        	} 
        	buffer.append("\n                   , " + makeDocString("#{" + columns.get(i).getAliasNm() + "}", 30));
			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
		}

		buffer.append("\n            )");
		buffer.append("\n        ]]>");
		buffer.append("\n    </insert>");
		buffer.append("\n");
        buffer.append("\n");

		buffer.append("\n    <!-- " + classNm + "수정 -->");
		buffer.append("\n    <update id=\"update" + tableNm + "_00\" parameterType=\"" + classId + "Model\" >");
		buffer.append("\n        <![CDATA[");
		buffer.append("\n            UPDATE " + tableNm + " SET");


		
		int count = 0;
        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( "PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}
        	
			if ( rgstList.get(columns.get(i).getColNm()) != null ) {
				continue;
			}
			
        	if ( count == 0 ) {
            	buffer.append("\n                     " + makeDocString(columns.get(i).getColNm(), 30) + " = " + makeDocString("#{" + columns.get(i).getAliasNm() + "}", 30));
    			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
    			count++;
        		continue;
        	} 
        	buffer.append("\n                   , " + makeDocString(columns.get(i).getColNm(), 30) + " = " + makeDocString("#{" + columns.get(i).getAliasNm() + "}", 30));
			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
			count++;
		}
		
		buffer.append("\n                   , UPDT_ID                        = #{updtId}                         /* 수정 ID                        */");
		buffer.append("\n                   , UPDT_IP                        = #{updtIp}                         /* 수정 IP                        */");
		buffer.append("\n                   , UPDT_DTM                       = #{updtDtm}                        /* 수정 일시                      */");
        
        
		buffer.append("\n            WHERE  1 = 1");

        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( !"PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}
        	
        	buffer.append("\n            AND    " + makeDocString(columns.get(i).getColNm(), 30) + " = " + makeDocString("#{" + columns.get(i).getAliasNm() + "}", 30));
			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
		}
		
		buffer.append("\n        ]]>");
		buffer.append("\n    </update>");
		buffer.append("\n");
        buffer.append("\n");

		buffer.append("\n    <!-- " + classNm + "삭제 -->");
		buffer.append("\n    <delete id=\"delete" + tableNm + "_00\" parameterType=\"" + classId + "Model\" >");
		buffer.append("\n        <![CDATA[");
		buffer.append("\n            DELETE FROM " + tableNm);
		buffer.append("\n            WHERE  1 = 1");
        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( !"PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}
        	
        	buffer.append("\n            AND    " + makeDocString(columns.get(i).getColNm(), 30) + " = " + makeDocString("#{" + columns.get(i).getAliasNm() + "}", 30));
			buffer.append("    /* " + makeDocString(columns.get(i).getCmnt(), 30) + " */");
		}

		buffer.append("\n        ]]>");
		buffer.append("\n    </delete>");
		buffer.append("\n");
		buffer.append("\n");

		buffer.append("\n    <!-- " + classNm + "삭제 -->");
		buffer.append("\n    <delete id=\"delete" + tableNm + "_01\" parameterType=\"" + classId + "Model\" >");
		buffer.append("\n        <![CDATA[");
		buffer.append("\n            TRUNCATE TABLE " + tableNm);
		buffer.append("\n        ]]>");
		buffer.append("\n    </delete>");
		buffer.append("\n");
		buffer.append("\n");

		buffer.append("\n    <!-- " + classNm + "삭제 -->");
		buffer.append("\n    <delete id=\"delete" + tableNm + "_02\" parameterType=\"" + classId + "Model\" >");
		buffer.append("\n        <![CDATA[");
		buffer.append("\n            DELETE FROM " + tableNm);
		buffer.append("\n            WHERE  1 = 1");
        buffer.append("\n            AND    CO_ID = " + "#{coId}");

		buffer.append("\n        ]]>");
		buffer.append("\n    </delete>");
		buffer.append("\n");
		buffer.append("\n</mapper>");

		
		writeFile(fileNm, buffer);
	}
    

	
	
	public void makeWebFile(String classId, String classNm, String tableNm) throws Exception {
		
		HashMap<String, String> exceptList = new HashMap<String, String>();
		exceptList.put("EFF_STA_DT"   , "");
		exceptList.put("EFF_END_DT"   , "");
		exceptList.put("RGST_DTM"     , "");
		exceptList.put("RGST_IP"      , "");
		exceptList.put("RGST_ID"      , "");
		exceptList.put("UPDT_DTM"     , "");
		exceptList.put("UPDT_IP"      , "");
		exceptList.put("UPDT_ID"      , "");
		exceptList.put("DEL_YN"       , "");

		
		String realUploadPath = ApplicationConstants_Aprj.TEMP_DIR_PATH + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/JSP/";
		realUploadPath = realUploadPath + "/" + classId.toLowerCase().substring(0, 6) + "/" + classId.toLowerCase().substring(6, 8) + "0/";
		FileUtil.mkdir(realUploadPath);
		
		String fileNm = realUploadPath + classId.toLowerCase() + "_40.jsp";
        System.out.println("JSP NAME : " + fileNm);
        
        StringBuffer buffer = new StringBuffer();

        buffer.append("<%@ page");
        buffer.append("\n  info         = \"Project Management\"");
        buffer.append("\n  language     = \"java\"");
        buffer.append("\n  session      = \"true\"");
        buffer.append("\n  buffer       = \"16kb\"");
        buffer.append("\n  autoFlush    = \"true\"");
        buffer.append("\n  isThreadSafe = \"true\"");
        buffer.append("\n  isErrorPage  = \"false\"");
        buffer.append("\n  contentType  = \"text/html; charset=utf-8\"");
        buffer.append("\n%>");
        buffer.append("\n");
        buffer.append("\n<%@ taglib prefix=\"fn\"     uri=\"http://java.sun.com/jsp/jstl/functions\" %>");
        buffer.append("\n<%@ taglib prefix=\"c\"      uri=\"http://java.sun.com/jsp/jstl/core\" %>");
        buffer.append("\n<%@ taglib prefix=\"fmt\"    uri=\"http://java.sun.com/jsp/jstl/fmt\" %>");
        buffer.append("\n<%@ taglib prefix=\"spring\" uri=\"http://www.springframework.org/tags\" %>");
        buffer.append("\n");
        buffer.append("\n<%@ include file=\"/include/include_header.jsp\" %>");
        buffer.append("\n");
        buffer.append("\n<script type=\"text/javascript\">");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  검색");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function requestSrch() {");
        buffer.append("\n        requestPage(1);");
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  검색 요청");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function requestPage(pageNo) {");
        buffer.append("\n        if ( !chkPage() ) {");
        buffer.append("\n            return false;");
        buffer.append("\n        }");
        buffer.append("\n");
        buffer.append("\n        document.getElementById(\"pageNo\").value = pageNo;");
        buffer.append("\n");
        buffer.append("\n        var action = \"<%= baseLoc %>/\" + \"<%= ActionConstants_Aprj.ACTION_" + classId.toUpperCase() + "_40 %>\";");
        buffer.append("\n");
        buffer.append("\n        document.form1.target = \"\";");
        buffer.append("\n        document.form1.method = \"post\";");
        buffer.append("\n        document.form1.action = action + getParam();");
        buffer.append("\n        document.form1.submit();");
        buffer.append("\n");
        buffer.append("\n        loading();");
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  check 검색 요청");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function chkPage() {");
        buffer.append("\n");
        buffer.append("\n        return true;");
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  초기화");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function requestInit() {");

        
        int j = 0;
        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( !"PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}

        	buffer.append("\n        var " + columns.get(i).getAliasNm() + " = \"\";");
        	j++;
		}
    	buffer.append("\n");

        buffer.append("\n        requestDtl(");
        j = 0;
        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( !"PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}
        	
        	if ( j > 0 ) {
            	buffer.append(", ");
        	}

        	buffer.append(columns.get(i).getAliasNm());
        	j++;
		}
        buffer.append(");");
        
        
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  상세검색");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function requestDtl(");
        j = 0;
        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( !"PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}
        	
        	if ( j > 0 ) {
            	buffer.append(", ");
        	}

        	buffer.append(columns.get(i).getAliasNm());
        	j++;
		}
        buffer.append(") {");

        buffer.append("\n        if ( !chkDtl() ) {");
        buffer.append("\n            return false;");
        buffer.append("\n        }");
        buffer.append("\n");
        
        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( !"PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}
        	
            buffer.append("\n        document.getElementById(\""+ columns.get(i).getAliasNm() + "\").value = "+ columns.get(i).getAliasNm() + ";");
		}

        
        buffer.append("\n        var action = \"<%= baseLoc %>/\" + \"<%= ActionConstants_Aprj.ACTION_" + classId.toUpperCase() + "_41 %>\" + getParam();");
        buffer.append("\n");
        buffer.append("\n        document.getElementById(\"targetLayer\").value = \"detailLayer\";");
        buffer.append("\n        requestPostAjax(action, setTable, document.getElementById(\"targetLayer\").value);");
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  check 검색 요청");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function chkDtl() {");
        buffer.append("\n");
        buffer.append("\n        return true;");
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  입력 요청");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function requestSave() {");
        buffer.append("\n        if ( !chkSave() ) {");
        buffer.append("\n            return false;");
        buffer.append("\n        }");
        buffer.append("\n");
        buffer.append("\n        var action = \"<%= baseLoc %>/\" + \"<%= ActionConstants_Aprj.ACTION_" + classId.toUpperCase() + "_00 %>\";");
        buffer.append("\n");
        buffer.append("\n        document.form1.target = \"\";");
        buffer.append("\n        document.form1.method = \"post\";");
        buffer.append("\n        document.form1.action = action + getParam();");
        buffer.append("\n        document.form1.submit();");
        buffer.append("\n");
        buffer.append("\n        loading();");
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  check 입력 요청");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function chkSave() {");

        
        for ( int i = 0; i < columns.size(); i++ ) {
			if ( exceptList.get(columns.get(i).getColNm()) != null ) {
				if ( !("EFF_STA_DT".equals(columns.get(i).getColNm()) || "EFF_END_DT".equals(columns.get(i).getColNm())) ) {
					continue;
				}
			}
        	
            buffer.append("\n        if ( isEmptyObject(document.getElementById(Trim(\""+ makeDocString(columns.get(i).getAliasNm(), 30) + "\")), Trim(\"" + makeDocString(columns.get(i).getCmnt(), 30) + "\")) ) return false;");
		}
        
        buffer.append("\n");
        buffer.append("\n        return true;");
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  삭제 요청");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function requestDel() {");
        buffer.append("\n        if ( !chkDel() ) {");
        buffer.append("\n            alert(\"삭제 대상이 없습니다. 삭제 대상을 선택하십시요.\");");
        buffer.append("\n            return false;");
        buffer.append("\n        }");
        buffer.append("\n");
        buffer.append("\n        var action = \"<%= baseLoc %>/\" + \"<%= ActionConstants_Aprj.ACTION_" + classId.toUpperCase() + "_80 %>\";");
        buffer.append("\n");
        buffer.append("\n        document.form1.target = \"\";");
        buffer.append("\n        document.form1.method = \"post\";");
        buffer.append("\n        document.form1.action = action + getParam();");
        buffer.append("\n        document.form1.submit();");
        buffer.append("\n");
        buffer.append("\n        loading();");
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  check 검색 요청");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function chkDel() {");
        buffer.append("\n        del = document.getElementsByName(\"delKey\");");
        buffer.append("\n        if ( del.length > 0 ) {");
        buffer.append("\n            for ( var i = 0; i < del.length; i++ ) {");
        buffer.append("\n                if ( del[i].checked == true ) {");
        buffer.append("\n                    return true;");
        buffer.append("\n                }");
        buffer.append("\n            }");
        buffer.append("\n        } else {");
        buffer.append("\n            return false;");
        buffer.append("\n        }");
        buffer.append("\n");
        buffer.append("\n        return false;");
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  화면 로드시");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function loadPage() {");
        buffer.append("\n        DisabledBackColor();");
        buffer.append("\n        fncInitControl();");
        buffer.append("\n");
        buffer.append("\n        try {");
        buffer.append("\n        	setPaging();");
        buffer.append("\n        } catch (e) {");
        buffer.append("\n");
        buffer.append("\n        }");
        buffer.append("\n        try {");
        buffer.append("\n        	$.setDatePickerRange($(\"#srchStaDt\"), $(\"#srchEndDt\"));");
        buffer.append("\n        } catch (e) {");
        buffer.append("\n");
        buffer.append("\n        }");
        buffer.append("\n        try {");
        buffer.append("\n        	message();");
        buffer.append("\n        } catch (e) {");
        buffer.append("\n");
        buffer.append("\n        }");
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    /***************************************************************************");
        buffer.append("\n     *  EnterKey 입력시 저장작업");
        buffer.append("\n     ***************************************************************************/");
        buffer.append("\n    function keyPress() {");
        buffer.append("\n        // Enter key");
        buffer.append("\n        if ( getKeyCode(event) == 13 )");
        buffer.append("\n        {");
        buffer.append("\n            if ( event.srcElement.name.indexOf(\"srch\") == 0 ) {");
        buffer.append("\n                requestSrch();");
        buffer.append("\n            }");
        buffer.append("\n        }");
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    window.onload      = loadPage;");
        buffer.append("\n    document.onkeydown = keyPress;");
        buffer.append("\n");
        buffer.append("\n</script>");
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("\n<body>");
        buffer.append("\n<form id=\"form1\" name=\"form1\" class=\"form-inline\">");
        buffer.append("\n<div class=\"wrap\">");
        buffer.append("\n");
        buffer.append("\n    <!-- top menu -->");
        buffer.append("\n    <jsp:include page=\"/include/menu/topMenu.jsp\" />");
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("\n    <div class=\"container\">");
        buffer.append("\n        <div class=\"inner\">");
        buffer.append("\n");
        buffer.append("\n	    <!-- top menu -->");
        buffer.append("\n	    <jsp:include page=\"/include/menu/leftMenu.jsp\" />");
        buffer.append("\n");
        buffer.append("\n            <div class=\"content\">");
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("\n            <!-- navi Menu -->");
        buffer.append("\n            <jsp:include page=\"/include/menu/naviMenu.jsp\" />");
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("\n                <!-- bodyarea -->");
        buffer.append("\n                <div class=\"bodyarea\">");
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("\n                    <div class=\"filter\">");
        buffer.append("\n                        <div class=\"form-group\">");

        buffer.append("\n");
        buffer.append("\n                            <jsp:include page=\"/include/com/include_co_search.jsp\" />");
        buffer.append("\n");
        buffer.append("\n                            <div class=\"input-group\">");
        buffer.append("\n                                <strong>조회 일자</strong>");
        buffer.append("\n                                <p>");
        buffer.append("\n                                    <span class=\"date_box\"><input type=\"text\" name=\"srchStaDt\" id=\"srchStaDt\" value=\"${srchStaDt}\" title=\"조회 시작 일자\" format=\"date\"/></span>");
        buffer.append("\n                                    <span class=\"t-txt\">~</span>");
        buffer.append("\n                                    <span class=\"date_box\"><input type=\"text\" name=\"srchEndDt\" id=\"srchEndDt\" value=\"${srchEndDt}\" title=\"조회 종료 일자\" format=\"date\"/></span>");
        buffer.append("\n                                </p>");
        buffer.append("\n                            </div>");
        buffer.append("\n");

        for ( int i = 0; i < columns.size(); i++ ) {
			if ( exceptList.get(columns.get(i).getColNm()) != null ) {
				continue;
			}
			
			if ( "CO_ID".equals(columns.get(i).getColNm()) ) {
				continue;
			}
			
	        buffer.append("\n                            <div class=\"input-group\">");

            String srchColumn = columns.get(i).getAliasNm();
			srchColumn = "srch" + srchColumn.substring(0, 1).toUpperCase() + srchColumn.substring(1);

	        buffer.append("\n                                <strong>" + columns.get(i).getCmnt() + "</strong>");
	        buffer.append("\n                                <p>");
			if ( columns.get(i).getColNm().endsWith("_CD") ) {
        		
		        buffer.append("\n                                <span class=\"select-box w-full\">");
    			buffer.append("\n                                <select name=" + makeDocString("\"" + srchColumn + "\"", 30) + " id=" + makeDocString("\"" + srchColumn + "\"", 30) + " class=\"form-control input-sm\">");
                buffer.append("\n                                    <option value=\"\">전체</option>");
                buffer.append("\n                                    <c:forEach var=\"code\" items=\"${" + columns.get(i).getAliasNm() + "List}\" varStatus=\"status\">");
                buffer.append("\n                                    <option value=\"${code.cd}\" <c:if test=\"${code.cd == " + srchColumn + "}\">selected</c:if>>${code.cdNm}</option>");
                buffer.append("\n                                    </c:forEach>");
                buffer.append("\n                                </select>");
		        buffer.append("\n                                </span>");
        	} else {
                buffer.append("\n                                <input type=\"text\" name=" + makeDocString("\"" + srchColumn + "\"", 30) + " id=" + makeDocString("\"" + srchColumn + "\"", 30) + " value=\"<c:out value=\"${" + makeDocString(srchColumn, 30) + "}\"/>\" class=\"w-full\" title=\""+ columns.get(i).getCmnt() + "\" />");
        	}
			
	        buffer.append("\n                                </p>");
	        buffer.append("\n                            </div>");
		}
        
        buffer.append("\n");
        buffer.append("\n                        </div>");
        buffer.append("\n                        <!-- form-group -->");
        buffer.append("\n");
        buffer.append("\n                        <div class=\"btnarea\">");
        buffer.append("\n                            <button class=\"btn point-b\" title=\"검색\" onclick=\"requestSrch(); return false;\"><i class=\"i-search\"></i>검색</button>");
        buffer.append("\n                        </div>");
        buffer.append("\n");
        buffer.append("\n                    </div>");
        buffer.append("\n                    <!-- filter area -->");
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("\n                    <div class=\"list-top\">");
        buffer.append("\n                        <div class=\"select-box\">");
        buffer.append("\n                            <select title=\"정렬방법\">");
        buffer.append("\n                                <option>10개씩 보기</option>");
        buffer.append("\n                                <option>20개씩 보기</option>");
        buffer.append("\n                                <option>30개씩 보기</option>");
        buffer.append("\n                            </select>");
        buffer.append("\n                        </div>");
        buffer.append("\n                        <div class=\"btnarea\">");
        buffer.append("\n                            <button class=\"btn default\" title=\"삭제\" onclick=\"requestDel();return false;\">삭제</button>");
        buffer.append("\n                        </div>");
        buffer.append("\n                    </div>");
        buffer.append("\n");
        buffer.append("\n                    <table class=\"table list\">");
        buffer.append("\n                        <caption class=\"blind\">검색 목록</caption>");
        buffer.append("\n                        <colgroup>");
        
        buffer.append("\n                            <col style=\"width:30px\">");
        buffer.append("\n                            <col style=\"width:60px\">");
        for ( int i = 0; i < columns.size() - 1; i++ ) {
			if ( exceptList.get(columns.get(i).getColNm()) != null ) {
				if ( !("EFF_STA_DT".equals(columns.get(i).getColNm()) || "EFF_END_DT".equals(columns.get(i).getColNm())) ) {
					continue;
				}
    		}
            
            buffer.append("\n                            <col width=\"10%\" />");
		}
        buffer.append("\n                            <col width=\"*\" />");
        
        buffer.append("\n                        </colgroup>");
        buffer.append("\n                        <tr>");
        buffer.append("\n                            <th><input type=\"checkbox\" name=\"delKeyAll\" id=\"delKeyAll\" title=\"모두 선택\" onclick=\"selectAll(event);\"></th>");
        buffer.append("\n                            <th>번호</th>");
        for ( int i = 0; i < columns.size(); i++ ) {
			if ( exceptList.get(columns.get(i).getColNm()) != null ) {
				if ( !("EFF_STA_DT".equals(columns.get(i).getColNm()) || "EFF_END_DT".equals(columns.get(i).getColNm())) ) {
					continue;
				}
    		}
            buffer.append("\n                            <th>" + columns.get(i).getCmnt() + "</th>");
		}
        buffer.append("\n                        </tr>");
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("\n                        <!-- 리스트 -->");
        buffer.append("\n                        <c:forEach var=\"row\" items=\"${resultList}\" varStatus=\"status\">");
        buffer.append("\n                        <tr style=\"cursor:pointer;\" onclick=\"requestDtl(");
        
        
        j = 0;
        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( !"PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}
        	
        	if ( j > 0 ) {
            	buffer.append(", ");
        	}

            buffer.append("'<c:out value=\"${row." + columns.get(i).getAliasNm() + "}\"/>'");
        	j++;
		}
        buffer.append(");\">");

        
        buffer.append("\n                            <td class=\"tx-center\"><input type=\"checkbox\" name=\"delKey\" id=\"delKey\" title=\"선택\" onclick=\"selectAll(event);\" value=\"");
        j = 0;
        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( !"PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}
        	
        	if ( j > 0 ) {
            	buffer.append("_");
        	}

            buffer.append("<c:out value=\"${row." + columns.get(i).getAliasNm() + "}\"/>");
        	j++;
		}
        buffer.append("\"></td>");

        
        
        
        
        buffer.append("\n                            <td class=\"tx-center\"><c:out value=\"${row." + makeDocString("rowNum", 30)  + "}\"/></td>");
        for ( int i = 0; i < columns.size(); i++ ) {
        	
			if ( exceptList.get(columns.get(i).getColNm()) != null ) {
				if ( !("EFF_STA_DT".equals(columns.get(i).getColNm()) || "EFF_END_DT".equals(columns.get(i).getColNm())) ) {
					continue;
				}
    		}
			
			if ( "CO_ID".equals(columns.get(i).getColNm()) ) {
				continue;
			}
			
        	if ( "NUMERIC".equals(columns.get(i).getDataTyp()) ) {
                buffer.append("\n                            <td class=\"tx-right\" ><c:out value=\"${row." + makeDocString(columns.get(i).getAliasNm(), 30)  + "}\"/></td>");
        	} else {
                buffer.append("\n                            <td class=\"tx-left\"  ><c:out value=\"${row." + makeDocString(columns.get(i).getAliasNm(), 30)  + "}\"/></td>");
        	}
		}
        buffer.append("\n                        </tr>");
        buffer.append("\n                        </c:forEach>");
        buffer.append("\n                        </tbody>");
        buffer.append("\n                    </table>");
        buffer.append("\n                    <!-- table list -->");
        buffer.append("\n");
        buffer.append("\n                    <div id=\"gridPaging\" class=\"list-btm\"></div>");
        buffer.append("\n                </div>");
        buffer.append("\n                <!-- bodyarea -->");
        buffer.append("\n");
        buffer.append("\n                <!-- bodyarea -->");
        buffer.append("\n                <div class=\"bodyarea\">");
        buffer.append("\n                    <h4><c:out value=\"${naviMenu.menuNm}\"/> 상세정보</h4>");
        buffer.append("\n		            <div id=\"detailLayer\">");
        buffer.append("\n		                <jsp:include page=\"./" + classId.toLowerCase() + "_41.jsp\" />");
        buffer.append("\n		            </div>");
        buffer.append("\n                    <div class=\"btnarea_bottom\">");
        buffer.append("\n                        <button class=\"btn default\" title=\"코드등록\" onclick=\"openCd()     ;return false;\">코드등록</button>");
        buffer.append("\n                        <button class=\"btn default\" title=\"저장\"     onclick=\"requestSave();return false;\">저장</button>");
        buffer.append("\n                        <button class=\"btn default\" title=\"초기화\"   onclick=\"requestInit();return false;\">초기화</button>");
        buffer.append("\n                    </div>");
        buffer.append("\n                </div>");
        buffer.append("\n                <!--//bodyarea-->");
        buffer.append("\n            </div>");
        buffer.append("\n            <!--//content-->");
        buffer.append("\n        </div>");
        buffer.append("\n        <!--//inner -->");
        buffer.append("\n    </div>");
        buffer.append("\n    <!--//container -->");
        buffer.append("\n");
        buffer.append("\n    <!-- footer -->");
        buffer.append("\n    <jsp:include page=\"/include/include_footer.jsp\" />");
        buffer.append("\n    <!--//footer -->");
        buffer.append("\n</div>");
        buffer.append("\n<!--//wrap -->");
        buffer.append("\n");
        buffer.append("\n</form>");
        buffer.append("\n</body>");
        buffer.append("\n</html>");
		
		writeFile(fileNm, buffer);
		
		
		
		
		
		
		fileNm = realUploadPath + classId.toLowerCase() + "_41.jsp";
        System.out.println("JSP NAME : " + fileNm);
        
        
        buffer.delete(0, buffer.length());
        buffer.append("<%@ page");
        buffer.append("\n  info         = \"Project Management\"");
        buffer.append("\n  language     = \"java\"");
        buffer.append("\n  session      = \"true\"");
        buffer.append("\n  buffer       = \"16kb\"");
        buffer.append("\n  autoFlush    = \"true\"");
        buffer.append("\n  isThreadSafe = \"true\"");
        buffer.append("\n  isErrorPage  = \"false\"");
        buffer.append("\n  contentType  = \"text/html; charset=utf-8\"");
        buffer.append("\n%>");
        buffer.append("\n<%@ taglib prefix=\"fn\"     uri=\"http://java.sun.com/jsp/jstl/functions\" %>");
        buffer.append("\n<%@ taglib prefix=\"c\"      uri=\"http://java.sun.com/jsp/jstl/core\" %>");
        buffer.append("\n<%@ taglib prefix=\"fmt\"    uri=\"http://java.sun.com/jsp/jstl/fmt\" %>");
        buffer.append("\n<%@ taglib prefix=\"spring\" uri=\"http://www.springframework.org/tags\" %>");
        buffer.append("\n");
		

        buffer.append("\n                    <table class=\"table form\">");
        buffer.append("\n                        <caption class=\"blind\">상세정보</caption>");
        buffer.append("\n                        <colgroup>");
        buffer.append("\n                            <col style=\"width:15%\">");
        buffer.append("\n                            <col style=\"width:35%\">");
        buffer.append("\n                            <col style=\"width:15%\">");
        buffer.append("\n                            <col style=\"width:35%\">");
        buffer.append("\n                        </colgroup>");
        buffer.append("\n                        <tbody>");

        buffer.append("\n                            <jsp:include page=\"/include/com/include_co_detail.jsp\" />");
        buffer.append("\n");
        for ( int i = 0; i < columns.size(); i++ ) {
			if ( exceptList.get(columns.get(i).getColNm()) != null ) {
				continue;
			}
			
        	if ( (i % 2) == 0 ) {
                buffer.append("\n                            <tr>");
        	}

            String srchColumn = columns.get(i).getAliasNm();
			srchColumn = "srch" + srchColumn.substring(0, 1).toUpperCase() + srchColumn.substring(1);

	        buffer.append("\n                                <th>" + columns.get(i).getCmnt() + "</th>");
	        buffer.append("\n                                <td>");
			if ( columns.get(i).getColNm().endsWith("_CD") ) {
		        buffer.append("\n                                    <span class=\"select-box w-full\">");
    			buffer.append("\n                                    <select name=" + makeDocString("\"" + columns.get(i).getAliasNm() + "\"", 30) + " id=" + makeDocString("\"" + columns.get(i).getAliasNm() + "\"", 30) + " class=\"w-full\">");
                buffer.append("\n                                    <c:forEach var=\"code\" items=\"${" + columns.get(i).getAliasNm() + "List}\" varStatus=\"status\">");
                buffer.append("\n                                        <option value=\"${code.cd}\" <c:if test=\"${code.cd == resultObject." + columns.get(i).getAliasNm() + "}\">selected</c:if>>${code.cdNm}</option>");
                buffer.append("\n                                    </c:forEach>");
                buffer.append("\n                                    </select>");
		        buffer.append("\n                                    </span>");
        	} else if ( columns.get(i).getColNm().endsWith("_DT") ) {
                buffer.append("\n                                    <span class=\"date_box\"><input type=\"text\" name=" + makeDocString("\"" + columns.get(i).getAliasNm() + "\"", 30) + " id=" + makeDocString("\"" + columns.get(i).getAliasNm() + "\"", 30) + " value=\"<c:out value=\"${resultObject." + makeDocString(columns.get(i).getAliasNm() + "Format", 30) + "}\"/>\" title=" + makeDocString("\"" + columns.get(i).getCmnt() + "\"", 30) + " maxlength=" + makeDocString("\"" + columns.get(i).getDataLen() + "\"", 6) + " class=\"w-full\"/></span>");
        	} else if ( Integer.parseInt(columns.get(i).getDataLen()) >= 200 ) {
                buffer.append("\n                                    <textarea          name=" + makeDocString("\"" + columns.get(i).getAliasNm() + "\"", 30) + " id=" + makeDocString("\"" + columns.get(i).getAliasNm() + "\"", 30) + "                                                                         title=" + makeDocString("\"" + columns.get(i).getCmnt() + "\"", 30) + " maxlength=" + makeDocString("\"" + columns.get(i).getDataLen() + "\"", 6) + " class=\"w-full\" onKeyUp=\"setMaxLength();\" ><c:out value=\"${resultObject." + columns.get(i).getAliasNm() +"}\"/></textarea>");
            } else {
                buffer.append("\n                                    <input type=\"text\" name=" + makeDocString("\"" + columns.get(i).getAliasNm() + "\"", 30) + " id=" + makeDocString("\"" + columns.get(i).getAliasNm() + "\"", 30) + " value=\"<c:out value=\"${resultObject." + makeDocString(columns.get(i).getAliasNm(), 30) + "}\"/>\" title=" + makeDocString("\"" + columns.get(i).getCmnt() + "\"", 30) + " maxlength=" + makeDocString("\"" + columns.get(i).getDataLen() + "\"", 6) + " class=\"w-full\" />");
        	}
			
            buffer.append("\n                                </td>");
        	if ( (i % 2) == 1 || i == columns.size() - 1 ) {
                buffer.append("\n                            </tr>");
        	}
		}
        
        
        buffer.append("\n                            <tr>");
        buffer.append("\n                                <th>유효 일자</th>");
        buffer.append("\n                                <td colspan=\"3\">");
        buffer.append("\n                                    <span class=\"date_box\"><input type=\"text\" name=\"effStaDt\"                     id=\"effStaDt\"                     value=\"<c:out value=\"${resultObject.effStaDtFormat                }\"/>\" title=\"시작일 선택\" format=\"date\"></span>");
        buffer.append("\n                                    <span class=\"t-txt\">~</span>");
        buffer.append("\n                                    <span class=\"date_box\"><input type=\"text\" name=\"effEndDt\"                     id=\"effEndDt\"                     value=\"<c:out value=\"${resultObject.effEndDtFormat                }\"/>\" title=\"종료일 선택\" format=\"date\"></span>");
        buffer.append("\n                                </td>");
        buffer.append("\n                            </tr>");
        buffer.append("\n                            <jsp:include page=\"/include/com/include_rgst_detail.jsp\" />");
        buffer.append("\n                        </tbody>");
        buffer.append("\n                    </table>");
	
        buffer.append("\n");
        buffer.append("\n");
        buffer.append("\n<script type=\"text/javascript\">");
        buffer.append("\n");
        buffer.append("\n    $.setDatePickerRange($(\"#effStaDt\"), $(\"#effEndDt\"));");
        buffer.append("\n");
        buffer.append("\n    /**************************************************************************");
        buffer.append("\n     *  Key 설정");
        buffer.append("\n     **************************************************************************/");
        buffer.append("\n    function setKeyReadonly() {");

        for ( int i = 0; i < columns.size(); i++ ) {
        	if ( !"PK".equals(columns.get(i).getPkYn()) ) {
        		continue;
        	}
        	
            buffer.append("\n        setKeyDisabled(document.getElementById(Trim(\""+ makeDocString(columns.get(i).getAliasNm(), 30) + "\")));");
		}
        
        buffer.append("\n    }");
        buffer.append("\n");
        buffer.append("\n    setKeyReadonly();");
        buffer.append("\n");
        buffer.append("\n</script>");
        buffer.append("\n");

        
        writeFile(fileNm, buffer);
	}

	
	
	/*
	 * 문자 전문 생성
	 */
   public String makeDocString(String value, int length) throws Exception  {
    	String result;
    	if ( StringUtil.isNull(value) ) {
    		value = "";
    	}

    	result = value;
        int    nCount     = 0;  // 문장 길이

    	for ( int i = 0; i < value.length(); i++ ) {
    		if ( value.substring(i, i + 1).getBytes("UTF-8").length > 1 ) {
        		nCount++;
    		}
    		nCount++;
    	}
    	
    	for ( int i = nCount; i < length; i++ ) {
    		result += " ";
    	}
        
       return result;
   }

      
    /*
    * 숫자전문생성
    */
    public String makeDocNumber(String value, int length) {
      	String result = value;
      	if ( value == null ) {
      		result = "";
      	} else {
      		result = value;
      	}
      	
    	if ( value.getBytes().length > length ) {
    		byte[] arrayByte = new byte[length];
    		System.arraycopy(value.getBytes(), value.getBytes().length - length, arrayByte, 0, length);
    		return new String(arrayByte);
    	}
    	
    	int start = value.getBytes().length;
      	for ( int i = start; i < length; i++ ) {
      		result = "0" + result;
      	}
          
       return result;
    }

   
    public void writeFile(String fileNm, StringBuffer buffer) throws Exception {
		File file = new File(fileNm);
		file.delete();
	   
		FileWriter fw = new FileWriter(fileNm);
		BufferedWriter bw = new BufferedWriter(fw); // 버퍼를 사용한 객체 bw 생성
		
		bw.write(buffer.toString()); // 문자 배열의 내용을 파일에 출력
		bw.close();

	}

   
    public void writeFileContinue(String fileNm, StringBuffer buffer) throws Exception {
	   
		FileWriter fw = new FileWriter(fileNm, true);
		BufferedWriter bw = new BufferedWriter(fw); // 버퍼를 사용한 객체 bw 생성
		
		bw.write(buffer.toString()); // 문자 배열의 내용을 파일에 출력
		bw.close();

	}
    
    
    

}
