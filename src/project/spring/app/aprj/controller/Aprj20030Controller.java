/*-------------------------------------------------------------------
* NAME   : Aprj20030Controller
* DESC   : 프로젝트_업무버전
* Author : 
* DATE   : 2018-11-20
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.aprj.constants.GrpCdConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.aprj.service.Aprj20031Service;
import project.spring.app.aprj.service.Aprj20032Service;
import project.spring.app.aprj.service.Aprj20033Service;
import project.spring.app.aprj.service.Aprj20034Service;
import project.spring.app.aprj.service.Aprj20035Service;
import project.spring.app.aprj.service.Aprj20036Service;
import project.spring.app.aprj.service.Aprj20038Service;
import project.spring.app.aprj.service.Aprj20039Service;
import project.spring.app.aprj.service.Aprj20040Service;
import project.spring.app.aprj.service.Aprj20041Service;
import project.spring.app.aprj.service.Aprj20050Service;
import project.spring.app.aprj.service.Aprj20051Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.FileUtil;


@Controller
public class Aprj20030Controller extends AprjController {

    @Autowired
    Aprj20030Service serviceAprj20030;

    @Autowired
    Aprj20031Service serviceAprj20031;

    @Autowired
    Aprj20032Service serviceAprj20032;

    @Autowired
    Aprj20033Service serviceAprj20033;

    @Autowired
    Aprj20034Service serviceAprj20034;

    @Autowired
    Aprj20035Service serviceAprj20035;

    @Autowired
    Aprj20036Service serviceAprj20036;

    @Autowired
    Aprj20038Service serviceAprj20038;

    @Autowired
    Aprj20039Service serviceAprj20039;

    @Autowired
    Aprj20040Service serviceAprj20040;

    @Autowired
    Aprj20041Service serviceAprj20041;

    @Autowired
    Aprj20050Service serviceAprj20050;

    @Autowired
    Aprj20051Service serviceAprj20051;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String cyclClCdList                   = "cyclClCdList"                ;  // 주기 구분 코드리스트          
    
    private String resStCdList                    = "resStCdList"                 ;  // 응답 상태 코드리스트          
    private String signClCdList                   = "signClCdList"                ;  // 서명 구분 코드리스트          
    private String autoClCdList                   = "autoClCdList"                ;  // 자동 구분 코드리스트          
    private String tranStCdList                   = "tranStCdList"                ;  // 처리 상태 코드리스트          
    /**
     * 프로젝트_업무버전리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_40)
    public @ResponseBody Object srchAprj20030List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

//        // 프로젝트
//        Aprj20010Model paramAprj20010 = new Aprj20010Model();
//        getParameter(request, paramAprj20010);
//        modelAndView.addObject(resultPrj    , serviceAprj20010.srchAprj20010(paramAprj20010));
//        
//        // 통제
//        Aprj20020Model paramAprj20020 = new Aprj20020Model();
//        getParameter(request, paramAprj20020);
//        modelAndView.addObject(resultCtrl   , serviceAprj20020.srchAprj20020(paramAprj20020));

        // 자동 구분 코드
        modelAndView.addObject(autoClCdList                  , getGrpCdList(GrpCdConstants_Aprj.AUTO_CL_CD                    ));
        
        // 처리 상태 코드
        modelAndView.addObject(tranStCdList                  , getGrpCdList(GrpCdConstants_Aprj.TRAN_ST_CD                    ));
        
        // 주기 구분 코드
        modelAndView.addObject(cyclClCdList                  , getGrpCdList(GrpCdConstants_Aprj.CYCL_CL_CD                    ));
        
        // 업무
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj20030.srchAprj20030List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20030.srchAprj20030Cnt (param));

//        modelAndView.addObject(resultObject , serviceAprj20030.srchAprj20030(param));
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20030_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무버전조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_41)
    public @ResponseBody Object srchAprj20030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 자동 구분 코드
        modelAndView.addObject(autoClCdList                  , getGrpCdList(GrpCdConstants_Aprj.AUTO_CL_CD                    ));
        
        // 처리 상태 코드
        modelAndView.addObject(tranStCdList                  , getGrpCdList(GrpCdConstants_Aprj.TRAN_ST_CD                    ));
        
        // 주기 구분 코드
        modelAndView.addObject(cyclClCdList                  , getGrpCdList(GrpCdConstants_Aprj.CYCL_CL_CD                    ));
        
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20030.srchAprj20030(param));

//        modelAndView.addObject(resultStmList, serviceAprj20032.srchAprj20032List(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20030_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무버전리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_50)
    public @ResponseBody Object srchAprj20030UserList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        // 응답 상태 코드
        modelAndView.addObject(resStCdList                  , getGrpCdList(GrpCdConstants_Aprj.RES_ST_CD                    ));

        // 처리 상태 코드
        modelAndView.addObject(tranStCdList                 , getGrpCdList(GrpCdConstants_Aprj.TRAN_ST_CD                    ));
        
        // 서명 구분 코드
        modelAndView.addObject(signClCdList                 , getGrpCdList(GrpCdConstants_Aprj.SRCH_SIGN_CL_CD             ));
        
        // 업무
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        setDate(request, modelAndView, param);
        setCoInfo(request, modelAndView, param);
        
        if ( !ApplicationConstants_Aprj.USER_AUTH_ADMIN.equals(sessionUser.getUserAuthCd()) ) {
	    	setObject(request, modelAndView, param,"srchUserId", sessionUser.getUserId());
	    	setObject(request, modelAndView, param,"srchUserNm", sessionUser.getUserNm());
        } 
        

        modelAndView.addObject(resultList   , serviceAprj20030.srchAprj20030UserList(param));
        modelAndView.addObject(resultListCnt, serviceAprj20030.srchAprj20030UserCnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20030_50);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무버전리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_51)
    public @ResponseBody Object srchAprj20030User(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 자동 구분 코드
        modelAndView.addObject(autoClCdList                  , getGrpCdList(GrpCdConstants_Aprj.AUTO_CL_CD                    ));
        
        // 처리 상태 코드
        modelAndView.addObject(tranStCdList                  , getGrpCdList(GrpCdConstants_Aprj.TRAN_ST_CD                    ));
        
        // 주기 구분 코드
        modelAndView.addObject(cyclClCdList                  , getGrpCdList(GrpCdConstants_Aprj.CYCL_CL_CD                    ));
        
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20030.srchAprj20030User(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20030_51);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무버전리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_60)
    public @ResponseBody Object srchAprj20030UserRpt(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        // 응답 상태 코드
        modelAndView.addObject(resStCdList                  , getGrpCdList(GrpCdConstants_Aprj.RES_ST_CD                    ));

        // 처리 상태 코드
        modelAndView.addObject(tranStCdList                 , getGrpCdList(GrpCdConstants_Aprj.TRAN_ST_CD                    ));
        
        // 서명 구분 코드
        modelAndView.addObject(signClCdList                 , getGrpCdList(GrpCdConstants_Aprj.SRCH_SIGN_CL_CD             ));
        
        // 업무
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        setDate(request, modelAndView, param);
        setCoInfo(request, modelAndView, param);
        
        if ( !ApplicationConstants_Aprj.USER_AUTH_ADMIN.equals(sessionUser.getUserAuthCd()) ) {
	    	setObject(request, modelAndView, param,"srchUserId", sessionUser.getUserId());
	    	setObject(request, modelAndView, param,"srchUserNm", sessionUser.getUserNm());
        } 
        

        modelAndView.addObject(resultList   , serviceAprj20030.srchAprj20030UserList(param));
        modelAndView.addObject(resultListCnt, serviceAprj20030.srchAprj20030UserCnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20030_60);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무버전리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_61)
    public @ResponseBody Object srchAprj20030UserRptStm(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 자동 구분 코드
        modelAndView.addObject(autoClCdList                  , getGrpCdList(GrpCdConstants_Aprj.AUTO_CL_CD                    ));
        
        // 처리 상태 코드
        modelAndView.addObject(tranStCdList                  , getGrpCdList(GrpCdConstants_Aprj.TRAN_ST_CD                    ));
        
        // 주기 구분 코드
        modelAndView.addObject(cyclClCdList                  , getGrpCdList(GrpCdConstants_Aprj.CYCL_CL_CD                    ));
        
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20030.srchAprj20030User(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20030_61);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무버전리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_70)
    public @ResponseBody Object srchAprj20030ExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        param.setPageRowCnt("999999999");
        
        List<Aprj20030Model> list = serviceAprj20030.srchAprj20030ExcelList(param);
        
        
		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
		FileUtil.mkdir(realUploadPath);
        
        String fileName = "업무_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
        File file = FileUtil.getSerNumFile(realUploadPath + fileName, "xlsx");


        LinkedHashMap<String, String> titleMap  = new LinkedHashMap<String, String>();
        titleMap.put("coId         ".trim(), "업체 ID                      ".trim());
        titleMap.put("coNm         ".trim(), "업체 명                      ".trim());
        
        titleMap.put("prjId        ".trim(), "프로젝트 ID                  ".trim());
        titleMap.put("prjNm        ".trim(), "프로젝트 명                  ".trim());
        titleMap.put("ctrlNum      ".trim(), "통제 번호                    ".trim());

        titleMap.put("opId         ".trim(), "업무 ID                      ".trim());
        titleMap.put("opSerNum     ".trim(), "업무 버전                    ".trim());
        titleMap.put("opNm         ".trim(), "업무 명                      ".trim());
        titleMap.put("opCtt        ".trim(), "업무 내용                    ".trim());

        titleMap.put("drftUserId   ".trim(), "기안 사용자 ID               ".trim());
        titleMap.put("drftUserNm   ".trim(), "기안 사용자 명               ".trim());

        titleMap.put("prdCnt       ".trim(), "기간 수                      ".trim());
        titleMap.put("cyclClCd     ".trim(), "주기 구분 코드(년:1000, 월:2000, 주:3000, 일:4000, 시:5000)".trim());
        titleMap.put("cyclClNm     ".trim(), "주기 구분 명                 ".trim());
        titleMap.put("stdDt        ".trim(), "기준 일자                    ".trim());
        titleMap.put("autoClCd     ".trim(), "자동 구분 코드(1000:자동, 2000:수동)".trim());
        titleMap.put("autoClNm     ".trim(), "자동 구분 명                 ".trim());

        titleMap.put("stmId        ".trim(), "결제 ID                      ".trim());
        titleMap.put("stmNm        ".trim(), "결제 명                      ".trim());
        
        titleMap.put("reqSerNum    ".trim(), "요청 일련번호                ".trim());
        titleMap.put("reqSeqNum    ".trim(), "요청 순번                    ".trim());
        titleMap.put("reqTypCd     ".trim(), "요청 종류 코드(일반:1000, 단일:2000, 다중:3000)".trim());
        titleMap.put("reqTypNm     ".trim(), "요청 종류 명                 ".trim());
        titleMap.put("reqCtt       ".trim(), "요청 내용                    ".trim());
        
        titleMap.put("itmSerNum    ".trim(), "항목 일련번호                ".trim());
        titleMap.put("itmVal       ".trim(), "항목 값                      ".trim());
        
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
	    
        List<Aprj20030Model> tempList;
        Aprj20030Model temp = new Aprj20030Model();
        
	    String prjId   = "";
	    String prjNm   = "";
	    String ctrlNum = "";
        
        
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

	                if ( "prjNm".equals(key) || "ctrlNum".equals(key) || "ctrlNm".equals(key) ) {
	                	continue;
	                }
	                
	                if ( "prjId".equals(key) ) {
	                	tempList = serviceAprj20031.srchAprj20031ExcelList(param);
	                	
	                	if ( tempList != null ) {
	                		
	                		if ( tempList.size() == 1 ) {
	                			temp = tempList.get(0);
	                			
                			    prjId   = temp.getPrjId();
                			    prjNm   = temp.getPrjNm();
                			    ctrlNum = temp.getCtrlNum();
	                		} else {
		                		for ( int k = 0; k < tempList.size(); k++ ) {
		                			temp = tempList.get(k);
		                			if ( k == 0 ) {
		                			    prjId   = temp.getPrjId();
		                			    prjNm   = temp.getPrjNm();
		                			    ctrlNum = temp.getCtrlNum();
		                			} else {
		                				ctrlNum = ctrlNum + ", " + temp.getCtrlNum();
		                			}
		                		}
	                		}
	                	}
	                	
    	                cell = row.createCell(j++);
    	                cell.setCellValue(prjId);

    	                cell = row.createCell(j++);
    	                cell.setCellValue(prjNm);

    	                cell = row.createCell(j++);
    	                cell.setCellValue(ctrlNum);

	                	continue;
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
        
        //File file = serviceAprj10030.srchAprj10030ExcelList(param);
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    /**
     * 프로젝트_업무버전리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_71)
    public @ResponseBody Object srchAprj20030StmExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        param.setPageRowCnt("999999999");
        
        List<Aprj20030Model> list = serviceAprj20032.srchAprj20032ExcelList(param);
        
        
		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
		FileUtil.mkdir(realUploadPath);
        
        String fileName = "업무결제라인_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
        File file = FileUtil.getSerNumFile(realUploadPath + fileName, "xlsx");


        LinkedHashMap<String, String> titleMap  = new LinkedHashMap<String, String>();
        titleMap.put("coId         ".trim(), "업체 ID                      ".trim());
        titleMap.put("coNm         ".trim(), "업체 명                      ".trim());

        titleMap.put("opId         ".trim(), "업무 ID                      ".trim());
        titleMap.put("opSerNum     ".trim(), "업무 버전                    ".trim());
        titleMap.put("opNm         ".trim(), "업무 명                      ".trim());

        titleMap.put("stmSerNum    ".trim(), "결제 일련번호                  ".trim());
        titleMap.put("stmClCd      ".trim(), "결제 구분 코드(결제:1000, 합의:2000, 참조:3000)".trim());
        titleMap.put("stmClNm      ".trim(), "결제 구분 명                   ".trim());
        titleMap.put("stmAuthCd    ".trim(), "결제 권한 코드                 ".trim());
        titleMap.put("stmAuthNm    ".trim(), "결제 권한 명                   ".trim());
        titleMap.put("stmOpChrgId  ".trim(), "업무 담당 ID(복수 ID 등록은 쉼표로 구분)".trim());

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
        
        Aprj20030Model temp = new Aprj20030Model();
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
        
        //File file = serviceAprj10030.srchAprj10030ExcelList(param);
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    /**
     * 프로젝트_업무버전리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_72)
    public @ResponseBody Object srchAprj20030UserExcel(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        param.setPageRowCnt("999999999");
        
        List<Aprj20030Model> list = serviceAprj20032.srchAprj20032ExcelList(param);
        
        
		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
		FileUtil.mkdir(realUploadPath);
        
        String fileName = "사용자업무_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
        File file = FileUtil.getSerNumFile(realUploadPath + fileName, "xlsx");


        LinkedHashMap<String, String> titleMap  = new LinkedHashMap<String, String>();
        titleMap.put("coId         ".trim(), "업체 ID                      ".trim());
        titleMap.put("coNm         ".trim(), "업체 명                      ".trim());
        
        titleMap.put("prjId        ".trim(), "프로젝트 ID                  ".trim());
        titleMap.put("prjNm        ".trim(), "프로젝트 명                  ".trim());

        titleMap.put("ctrlNum      ".trim(), "통제 번호                    ".trim());
//        titleMap.put("ctrlNm       ".trim(), "통제 명                      ".trim());

        titleMap.put("opId         ".trim(), "업무 ID                      ".trim());
        titleMap.put("opSerNum     ".trim(), "업무 버전                    ".trim());
        titleMap.put("opNm         ".trim(), "업무 명                      ".trim());
        titleMap.put("opCtt        ".trim(), "업무 내용                    ".trim());

        titleMap.put("drftUserId   ".trim(), "기안자 ID                    ".trim());
        titleMap.put("drftUserNm   ".trim(), "기안자 명                    ".trim());
        
        titleMap.put("prdCnt       ".trim(), "기간 수                      ".trim());
        titleMap.put("cyclClCd     ".trim(), "주기 구분 코드(년:1000, 월:2000, 주:3000, 일:4000, 시:5000)".trim());
        titleMap.put("cyclClNm     ".trim(), "주기 구분 명                 ".trim());
        titleMap.put("stdDt        ".trim(), "기준 일자                    ".trim());
        titleMap.put("autoClCd     ".trim(), "자동 구분 코드(1000:자동, 2000:수동)".trim());
        titleMap.put("autoClNm     ".trim(), "자동 구분 명                 ".trim());

        titleMap.put("stmId        ".trim(), "결제 ID                      ".trim());
        titleMap.put("stmNm        ".trim(), "결제 명                      ".trim());
        
        titleMap.put("reqSerNum    ".trim(), "요청 일련번호                ".trim());
        titleMap.put("reqSeqNum    ".trim(), "요청 순번                    ".trim());
        titleMap.put("reqTypCd     ".trim(), "요청 종류 코드(일반:1000, 단일:2000, 다중:3000)".trim());
        titleMap.put("reqTypNm     ".trim(), "요청 종류 명                 ".trim());
        titleMap.put("reqCtt       ".trim(), "요청 내용                    ".trim());
        
        titleMap.put("itmSerNum    ".trim(), "항목 일련번호                ".trim());
        titleMap.put("itmVal       ".trim(), "항목 값                      ".trim());

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
        
        Aprj20030Model temp = new Aprj20030Model();
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
        
        //File file = serviceAprj10030.srchAprj10030ExcelList(param);
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    /**
     * 프로젝트_업무버전저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_00)
    public @ResponseBody Object saveAprj20030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20030.saveAprj20030(param);

        param.println();
        
//        serviceAprj20033.deleteAprj20033(param);
//        serviceAprj20033.insertAprj20033(param);
        
        modelAndView = (ModelAndView) srchAprj20030List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무버전저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_01)
    public @ResponseBody Object copyAprj20030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        String toDay = DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
		// 신규 버전
		param.setStdDt   (toDay);
		param.setTranStCd("1000");
		param.setTranDt  (toDay);
		
		param.setDrftUserId(sessionUser.getUserId());
		param.setDrftUserId(sessionUser.getUserNm());
		
		serviceAprj20030.insertAprj20030VerUp(param);
		
        Aprj20030Model temp = new Aprj20030Model();
        temp.setCoId    (param.getCoId         ());
        temp.setOpId    (param.getOpId         ());
        temp.setOpSerNum(param.getVerUpOpSerNum());
        
        serviceAprj20031.deleteAprj20031(temp);
        serviceAprj20032.deleteAprj20032(temp);
        serviceAprj20033.deleteAprj20033(temp);
        serviceAprj20034.deleteAprj20034(temp);
//        serviceAprj20035.deleteAprj20035(temp);
        serviceAprj20036.deleteAprj20036(temp);
        serviceAprj20038.deleteAprj20038(temp);
        serviceAprj20039.deleteAprj20039(temp);
        serviceAprj20040.deleteAprj20040(temp);
        serviceAprj20041.deleteAprj20041(temp);


        serviceAprj20031.insertAprj20031VerUp(param);
        serviceAprj20032.insertAprj20032VerUp(param);
        serviceAprj20033.insertAprj20033VerUp(param);
        serviceAprj20034.insertAprj20034VerUp(param);
//        serviceAprj20035.insertAprj20035VerUp(param);
        serviceAprj20036.insertAprj20036VerUp(param);
        serviceAprj20038.insertAprj20038VerUp(param);
        serviceAprj20039.insertAprj20039VerUp(param);
        serviceAprj20040.insertAprj20040VerUp(param);
        serviceAprj20041.insertAprj20041VerUp(param);

        modelAndView = (ModelAndView) srchAprj20030List(request);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무버전삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20030_80)
    public @ResponseBody Object deleteAprj20030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj20030Model param  = new Aprj20030Model();
        
        String[] temp = new String[3];
        boolean del = true;
        for ( int i = 0; i < delKeys.length; i++ ) {
        	temp = delKeys[i].split("_");
        	
            param.setCoId    (temp[0]);
            param.setOpId    (temp[1]);
            param.setOpSerNum(temp[2]);

            if ( Integer.parseInt(serviceAprj20050.srchAprj20050ResCnt(param)) > 0 ) {
            	del = false;
            	continue;
            }
            
            cnt =+ serviceAprj20031.deleteAprj20031(param);
            cnt =+ serviceAprj20032.deleteAprj20032(param);
            cnt =+ serviceAprj20033.deleteAprj20033(param);
            cnt =+ serviceAprj20034.deleteAprj20034(param);
            cnt =+ serviceAprj20035.deleteAprj20035(param);
            cnt =+ serviceAprj20036.deleteAprj20036(param);
            cnt =+ serviceAprj20038.deleteAprj20038(param);
            cnt =+ serviceAprj20039.deleteAprj20039(param);
            cnt =+ serviceAprj20040.deleteAprj20040(param);
            cnt =+ serviceAprj20041.deleteAprj20041(param);
//            cnt =+ serviceAprj20050.deleteAprj20050(param);
//            cnt =+ serviceAprj20051.deleteAprj20051(param);
            cnt =+ serviceAprj20030.deleteAprj20030(param);
        }

        modelAndView = (ModelAndView) srchAprj20030List(request);
        modelAndView.addObject(resultCnt    , cnt);
        if ( del == true ) {
        	AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        } else {
    		AprjMessage.setMsg(modelAndView, "info.common.delete.fail.res");
        }
        return returnResponse(modelAndView);
    }
}