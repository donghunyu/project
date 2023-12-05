/*-------------------------------------------------------------------
* NAME   : Aprj10010Controller
* DESC   : 설정_자산구분
* Author : 
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj10010Model;
import project.spring.app.aprj.service.Aprj10010Service;
import project.spring.app.aprj.service.Aprj10011Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.FileUtil;


@Controller
public class Aprj10010Controller extends AprjController {

    @Autowired
    Aprj10010Service serviceAprj10010;

    @Autowired
    Aprj10011Service serviceAprj10011;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 설정_자산구분리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10010_40)
    public @ResponseBody Object srchAprj10010List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj10010.srchAprj10010List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10010.srchAprj10010Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10010_40);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_자산구분리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10010_90)
    public @ResponseBody Object srchAprj10010PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj10010.srchAprj10010List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10010.srchAprj10010Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10010_90);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_자산구분조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10010_41)
    public @ResponseBody Object srchAprj10010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj10010.srchAprj10010(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10010_41);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_자산구분리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10010_70)
    public @ResponseBody Object srchAprj10010ExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);

        param.setPageRowCnt("99999");
        List<Aprj10010Model> list = serviceAprj10010.srchAprj10010List(param);
        
        
		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
		FileUtil.mkdir(realUploadPath);
        
        String fileName = "자산구분_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
        File file = FileUtil.getSerNumFile(realUploadPath + fileName, "xlsx");


        LinkedHashMap<String, String> titleMap  = new LinkedHashMap<String, String>();
        titleMap.put("coId        ".trim(), "업체 ID                     ".trim());
        titleMap.put("coNm        ".trim(), "업체 명                     ".trim());
        titleMap.put("astClId     ".trim(), "자산구분 ID                 ".trim());
        titleMap.put("astClNm     ".trim(), "자산구분 명                 ".trim());
        titleMap.put("astClCtt    ".trim(), "자산구분 내용               ".trim());
        
//        titleMap.put("astId       ".trim(), "자산 ID                     ".trim());
//        titleMap.put("astNm       ".trim(), "자산 명                     ".trim());
//        titleMap.put("astCtt      ".trim(), "자산 내용                   ".trim());

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet    sheet = workbook.createSheet();
        
        XSSFRow row = null;
        XSSFCell cell = null;
        
        Iterator<String> keyData = titleMap.keySet().iterator();
        row = sheet.createRow(0);
        int j = 0;
        String key;
        String name;
        String value;
	    Method method;
        
        Aprj10010Model temp = new Aprj10010Model();
        List<Aprj10010Model> tempList;
	    
        while (keyData.hasNext()) {
            key = (String) keyData.next();
            name = titleMap.get(key) == null ? "" : titleMap.get(key).toString();
            
            cell = row.createCell(j++);
            cell.setCellValue(name);
        }
        
        for ( int i = 0; i < list.size(); i++ ) {
        	row = sheet.createRow(i + 1);
        	param = list.get(i);
        	
        	j = 0;

        	keyData = titleMap.keySet().iterator();
            while (keyData.hasNext()) {
                key = (String) keyData.next();
                name = titleMap.get(key) == null ? "" : titleMap.get(key).toString();
                
	    		try {
	                method = param.getClass().getMethod("get" + key.substring(0,1).toUpperCase() + key.substring(1));
	                value = (String) method.invoke(param);

	                if ( "astId".equals(key) ) {
	                	param.setPageRowCnt("99999");
	                	tempList = serviceAprj10011.srchAprj10011List(param);
	                	value = "";
	                	
	                	if ( tempList != null ) {
	                		for ( int k = 0; k < tempList.size(); k++ ) {
	                			temp = tempList.get(k);
	                			
	                			if ( k != 0 ) {
	                				value = value + ", ";
	                			}
                				value = value + temp.getAstId();
	                		}
	                	}
	                	
	                }
	                
	                cell = row.createCell(j++);
	                cell.setCellValue(value);
				} catch ( Exception e ) {
					e.printStackTrace();
				}
            }
        }
        
        try {
        	FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
        	workbook.write(fos);
        	fos.close();
        } catch ( Exception e ) {
			e.printStackTrace();
        }
        
//        File file = serviceAprj10010.srchAprj10010ExcelList(param);
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    /**
     * 설정_자산구분저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10010_00)
    public @ResponseBody Object saveAprj10010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj10010.saveAprj10010(param);

        modelAndView = (ModelAndView) srchAprj10010List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 설정_자산구분삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10010_80)
    public @ResponseBody Object deleteAprj10010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj10010Model param = new Aprj10010Model();

        String[] temp = new String[2];
        for ( int i = 0; i < delKeys.length; i++ ) {
        	temp = StringUtils.split(delKeys[i], "_");
        	
            param.setCoId   (temp[0]);
            param.setAstClId(temp[1]);

            cnt =+ serviceAprj10010.deleteAprj10010(param);
        }

        modelAndView = (ModelAndView) srchAprj10010List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}