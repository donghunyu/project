/*-------------------------------------------------------------------
* NAME   : Aprj10030Controller
* DESC   : 설정_결제
* Author : 
* DATE   : 2018-11-08
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
import project.spring.app.aprj.constants.GrpCdConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj10030Model;
import project.spring.app.aprj.service.Aprj10030Service;
import project.spring.app.aprj.service.Aprj10031Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.FileUtil;


@Controller
public class Aprj10030Controller extends AprjController {

    @Autowired
    Aprj10030Service serviceAprj10030;

    @Autowired
    Aprj10031Service serviceAprj10031;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultStmList                  = "resultStmList"               ;  // 리스트결과
    
    private String stmClCdList                    = "stmClCdList"                 ;  // 결제 구분 코드리스트          
    private String stmAuthCdList                  = "stmAuthCdList"               ;  // 결제 권한 코드리스트          
    /**
     * 설정_결제리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10030_40)
    public @ResponseBody Object srchAprj10030List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj10030Model param = new Aprj10030Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        // 결제 구분 코드
        modelAndView.addObject(stmClCdList                   , getGrpCdList(GrpCdConstants_Aprj.STM_CL_CD                     ));

        // 결제 권한 코드
        modelAndView.addObject(stmAuthCdList                 , getGrpCdList(GrpCdConstants_Aprj.STM_AUTH_CD                   ));
        
        modelAndView.addObject(resultList   , serviceAprj10030.srchAprj10030List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10030.srchAprj10030Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10030_40);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_결제조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10030_41)
    public @ResponseBody Object srchAprj10030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10030Model param = new Aprj10030Model();
        getParameter(request, param);

        // 결제 구분 코드
        modelAndView.addObject(stmClCdList                   , getGrpCdList(GrpCdConstants_Aprj.STM_CL_CD                     ));

        // 결제 권한 코드
        modelAndView.addObject(stmAuthCdList                 , getGrpCdList(GrpCdConstants_Aprj.STM_AUTH_CD                   ));
        
        modelAndView.addObject(resultObject , serviceAprj10030.srchAprj10030(param));

        modelAndView.addObject(resultStmList, serviceAprj10031.srchAprj10031List(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10030_41);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_결제리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10030_70)
    public @ResponseBody Object srchAprj10030ExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10030Model param = new Aprj10030Model();
        getParameter(request, param);

        
        List<Aprj10030Model> list = serviceAprj10030.srchAprj10030ExcelList(param);
        
        
		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
		FileUtil.mkdir(realUploadPath);
        
        String fileName = "결제라인_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
        File file = FileUtil.getSerNumFile(realUploadPath + fileName, "xlsx");


        LinkedHashMap<String, String> titleMap  = new LinkedHashMap<String, String>();
        titleMap.put("coId        ".trim(), "업체 ID                        ".trim());
        titleMap.put("coNm        ".trim(), "업체 명                        ".trim());
        titleMap.put("stmId       ".trim(), "결제 ID                        ".trim());
        titleMap.put("stmNm       ".trim(), "결제 명                        ".trim());
        titleMap.put("stmCtt      ".trim(), "결제 내용                      ".trim());
        
        titleMap.put("stmSerNum   ".trim(), "결제 일련번호                  ".trim());
        titleMap.put("stmClCd     ".trim(), "결제 구분 코드((결제:1000, 합의:2000, 참조:3000)".trim());
        titleMap.put("stmClNm     ".trim(), "결제 구분 명                   ".trim());
        titleMap.put("stmAuthCd   ".trim(), "결제 권한 코드(상위권자:1000, 업무담당:2000)".trim());
        titleMap.put("stmAuthNm   ".trim(), "결제 권한 명                   ".trim());
        titleMap.put("stmOpChrgId ".trim(), "결제 업무 담당 ID((복수 ID 등록은 쉼표로 구분))".trim());
//        titleMap.put("opChrgNm    ".trim(), "업무 담당 명                   ".trim());

        
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
        
        Aprj10030Model temp = new Aprj10030Model();
	    boolean lastPrint = false;
	    
        while (keyData.hasNext()) {
            key = (String) keyData.next();
            name = titleMap.get(key) == null ? "" : titleMap.get(key).toString();
            
            cell = row.createCell(j++);
            cell.setCellValue(name);
        }
        
        int rowCnt = 1;
        for ( int i = 0; i < list.size(); i++ ) {
        	temp = list.get(i);
        		
        	if ( i == 0 ) {
        		param = temp;
        		continue;
        	}

        	if ( temp.getCoId     ().equals(param.getCoId     ()) 
        	  && temp.getStmId    ().equals(param.getStmId    ()) 
        	  && temp.getStmClCd  ().equals(param.getStmClCd  ()) 
        	  && temp.getStmAuthCd().equals(param.getStmAuthCd()) 
        	  && temp.getStmAuthCd().equals("2000") 
        	  ) {
        		param.setStmOpChrgId(param.getStmOpChrgId() + ", " + temp.getStmOpChrgId());
        		
        		if ( i < (list.size() - 1) ) {
            		continue;
        		}
        	} else {
        		if ( i == (list.size() - 1) ) {
        			lastPrint = true;
        		}
        	}
        	
        	row = sheet.createRow(rowCnt++);
    		keyData = titleMap.keySet().iterator();
    		j = 0;
            while (keyData.hasNext()) {
                key = (String) keyData.next();
                name = titleMap.get(key) == null ? "" : titleMap.get(key).toString();
                
	    		try {
	                method = param.getClass().getMethod("get" + key.substring(0,1).toUpperCase() + key.substring(1));
	                value = (String) method.invoke(param);

	                cell = row.createCell(j++);
	                cell.setCellValue(value);
				} catch ( Exception e ) {
					e.printStackTrace();
				}
            }

            param = temp;
        
            if ( lastPrint ) {
	        	row = sheet.createRow(rowCnt++);
	    		keyData = titleMap.keySet().iterator();
	    		j = 0;
	            while (keyData.hasNext()) {
	                key = (String) keyData.next();
	                name = titleMap.get(key) == null ? "" : titleMap.get(key).toString();
	                
		    		try {
		                method = param.getClass().getMethod("get" + key.substring(0,1).toUpperCase() + key.substring(1));
		                value = (String) method.invoke(param);
	
		                cell = row.createCell(j++);
		                cell.setCellValue(value);
					} catch ( Exception e ) {
						e.printStackTrace();
					}
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
        
//        File file = serviceAprj10030.srchAprj10030ExcelList(param);
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    public void createRow(Iterator<String> keyData, AprjModel param) {
    	
    }
    
    
    /**
     * 설정_결제리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10030_90)
    public @ResponseBody Object srchAprj10030PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10030Model param = new Aprj10030Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        // 결제 구분 코드
        modelAndView.addObject(stmClCdList                   , getGrpCdList(GrpCdConstants_Aprj.STM_CL_CD                     ));

        // 결제 권한 코드
        modelAndView.addObject(stmAuthCdList                 , getGrpCdList(GrpCdConstants_Aprj.STM_AUTH_CD                   ));
        
        modelAndView.addObject(resultList   , serviceAprj10030.srchAprj10030List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10030.srchAprj10030Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10030_90);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_결제조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10030_91)
    public @ResponseBody Object srchAprj10030Popup(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10030Model param = new Aprj10030Model();
        getParameter(request, param);

        // 결제 구분 코드
        modelAndView.addObject(stmClCdList                   , getGrpCdList(GrpCdConstants_Aprj.STM_CL_CD                     ));

        // 결제 권한 코드
        modelAndView.addObject(stmAuthCdList                 , getGrpCdList(GrpCdConstants_Aprj.STM_AUTH_CD                   ));
        
        modelAndView.addObject(resultObject , serviceAprj10030.srchAprj10030(param));

        modelAndView.addObject(resultStmList, serviceAprj10031.srchAprj10031List(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10030_91);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_결제저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10030_00)
    public @ResponseBody Object saveAprj10030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10030Model param = new Aprj10030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj10030.saveAprj10030(param);

        // 결제 구분 코드
        param.setStmClCd(null);
        serviceAprj10031.deleteAprj10031(param);

        String[] stmClCds  = request.getParameterValues("stmClCd" );
        if ( stmClCds != null ) {
	        for ( int i = 0; i < stmClCds.length; i++ ) {
	            param.setStmClCd(stmClCds[i]);
	
	            serviceAprj10031.insertAprj10031(param);
	        }
        }
        
        modelAndView = (ModelAndView) srchAprj10030List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 설정_결제삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10030_80)
    public @ResponseBody Object deleteAprj10030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj10030Model param = new Aprj10030Model();
        
        String[] temp = new String[2];
        for ( int i = 0; i < delKeys.length; i++ ) {
        	temp = StringUtils.split(delKeys[i], "_");
        	
            param.setCoId (temp[0]);
            param.setStmId(temp[1]);

            cnt =+ serviceAprj10031.deleteAprj10031(param);
            cnt =+ serviceAprj10030.deleteAprj10030(param);
        }

        modelAndView = (ModelAndView) srchAprj10030List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}