/*-------------------------------------------------------------------
* NAME   : Aprj10020Controller
* DESC   : 설정_업무담당
* Author : 
* DATE   : 2018-11-07
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
import project.spring.app.aprj.model.Aprj10020Model;
import project.spring.app.aprj.service.Aprj10020Service;
import project.spring.app.aprj.service.Aprj10021Service;
import project.spring.app.aprj.service.Aprj10022Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.FileUtil;


@Controller
public class Aprj10020Controller extends AprjController {

    @Autowired
    Aprj10020Service serviceAprj10020;

    @Autowired
    Aprj10021Service serviceAprj10021;

    @Autowired
    Aprj10022Service serviceAprj10022;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultUserList                 = "resultUserList"              ;  // 리스트결과
    private String resultAstList                  = "resultAstList"               ;  // 리스트결과
    /**
     * 설정_업무담당리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10020_40)
    public @ResponseBody Object srchAprj10020List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj10020.srchAprj10020List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10020.srchAprj10020Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10020_40);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무담당조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10020_41)
    public @ResponseBody Object srchAprj10020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj10020.srchAprj10020(param));

        modelAndView.addObject(resultUserList, serviceAprj10021.srchAprj10021List(param));
        modelAndView.addObject(resultAstList , serviceAprj10022.srchAprj10022List(param));
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10020_41);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무담당리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10020_70)
    public @ResponseBody Object srchAprj10020ExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);

        
        param.setPageRowCnt("99999");
        List<Aprj10020Model> list = serviceAprj10020.srchAprj10020List(param);
        
        
		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
		FileUtil.mkdir(realUploadPath);
        
        String fileName = "업무담당_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
        File file = FileUtil.getSerNumFile(realUploadPath + fileName, "xlsx");


        LinkedHashMap<String, String> titleMap  = new LinkedHashMap<String, String>();
        titleMap.put("coId        ".trim(), "업체 ID                     ".trim());
        titleMap.put("coNm        ".trim(), "업체 명                     ".trim());
        titleMap.put("opChrgId    ".trim(), "업무 담당 ID                ".trim());
        titleMap.put("opChrgNm    ".trim(), "업무 담당 명                ".trim());
        titleMap.put("opChrgCtt   ".trim(), "업무 담당 내용              ".trim());
        
        titleMap.put("astClId     ".trim(), "자산구분 ID(복수 ID 등록은 쉼표로 구분)".trim());
//        titleMap.put("userId      ".trim(), "사용자 ID                   ".trim());
//        titleMap.put("astClNm     ".trim(), "자산구분 명                 ".trim());
        
        
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
        
        Aprj10020Model temp = new Aprj10020Model();
        List<Aprj10020Model> tempList;
	    
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

	                if ( "astClId".equals(key) ) {
	                	param.setPageRowCnt("99999");
	                	tempList = serviceAprj10022.srchAprj10022List(param);
	                	value = "";
	                	
	                	if ( tempList != null ) {
	                		for ( int k = 0; k < tempList.size(); k++ ) {
	                			temp = tempList.get(k);
	                			
	                			if ( k != 0 ) {
	                				value = value + ", ";
	                			}
                				value = value + temp.getAstClId();
	                		}
	                	}
	                	
	                }
	                
	                if ( "userId".equals(key) ) {
	                	param.setPageRowCnt("99999");
	                	tempList = serviceAprj10021.srchAprj10021List(param);
	                	value = "";
	                	
	                	if ( tempList != null ) {
	                		for ( int k = 0; k < tempList.size(); k++ ) {
	                			temp = tempList.get(k);
	                			
	                			if ( k != 0 ) {
	                				value = value + ", ";
	                			}
                				value = value + temp.getUserId();
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
        
        
//        File file = serviceAprj10020.srchAprj10020ExcelList(param);
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    /**
     * 설정_업무담당리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10020_90)
    public @ResponseBody Object srchAprj10020PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj10020.srchAprj10020List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10020.srchAprj10020Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10020_90);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무담당저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10020_00)
    public @ResponseBody Object saveAprj10020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj10020.saveAprj10020(param);

        // 담당자
        param.setUserId(null);
        serviceAprj10021.deleteAprj10021(param);

        String[] userIds  = request.getParameterValues("userId" );
        if ( userIds != null ) {
	        for ( int i = 0; i < userIds.length; i++ ) {
	            param.setUserId(userIds[i]);
	
	            serviceAprj10021.insertAprj10021(param);
	        }
        }

        // 자산구분
        param.setAstClId(null);
        serviceAprj10022.deleteAprj10022(param);

        String[] astClIds  = request.getParameterValues("astClId" );
        if ( astClIds != null ) {
	        for ( int i = 0; i < astClIds.length; i++ ) {
	            param.setAstClId(astClIds[i]);
	
	            serviceAprj10022.insertAprj10022(param);
	        }
        }

        modelAndView = (ModelAndView) srchAprj10020List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무담당삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10020_80)
    public @ResponseBody Object deleteAprj10020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj10020Model param = new Aprj10020Model();
        
        String[] temp = new String[2];
        for ( int i = 0; i < delKeys.length; i++ ) {
        	temp = StringUtils.split(delKeys[i], "_");
        	
            param.setCoId    (temp[0]);
            param.setOpChrgId(temp[1]);

            cnt =+ serviceAprj10022.deleteAprj10022(param);
            cnt =+ serviceAprj10021.deleteAprj10021(param);
            cnt =+ serviceAprj10020.deleteAprj10020(param);
        }

        modelAndView = (ModelAndView) srchAprj10020List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}