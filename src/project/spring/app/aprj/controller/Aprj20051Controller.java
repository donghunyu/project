/*-------------------------------------------------------------------
* NAME   : Aprj20051Controller
* DESC   : 프로젝트_응답
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.aprj.constants.GrpCdConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.aprj.service.Aprj20034Service;
import project.spring.app.aprj.service.Aprj20036Service;
import project.spring.app.aprj.service.Aprj20040Service;
import project.spring.app.aprj.service.Aprj20050Service;
import project.spring.app.aprj.service.Aprj20051Service;
import project.spring.app.aprj.service.Aprj20052Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.FileUpload;
import project.spring.app.zcom.lib.util.FileUtil;
import project.spring.app.zcom.lib.util.StringUtil;


@Controller
public class Aprj20051Controller extends AprjController {

    @Autowired
    Aprj20030Service serviceAprj20030;

    @Autowired
    Aprj20036Service serviceAprj20036;

    @Autowired
    Aprj20034Service serviceAprj20034;

    @Autowired
    Aprj20040Service serviceAprj20040;

    @Autowired
    Aprj20050Service serviceAprj20050;

    @Autowired
    Aprj20051Service serviceAprj20051;

    @Autowired
    Aprj20052Service serviceAprj20052;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    private String resultFileList                 = "resultFileList"              ;  // 리스트결과
    
    private String resStCdList                    = "resStCdList"                 ;  // 처리 상태 코드리스트          
    /**
     * 프로젝트_응답리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20051_40)
    public @ResponseBody Object srchAprj20051List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 응답 상태 코드
        modelAndView.addObject(resStCdList                  , getGrpCdList(GrpCdConstants_Aprj.RES_ST_CD                    ));

        // 업무
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        setDate(request, modelAndView, param);

        modelAndView.addObject(resultHeader  , serviceAprj20050.srchAprj20050(param));
        
        
        modelAndView.addObject(resultList    , serviceAprj20051.srchAprj20051List(param));
        modelAndView.addObject(resultCnt     , serviceAprj20040.srchAprj20040Cnt (param));

        modelAndView.addObject(resultFileList, serviceAprj20052.srchAprj20052List(param));
        
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20051_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20051_41)
    public @ResponseBody Object srchAprj20051(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20051.srchAprj20051(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20051_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20051_70)
    public @ResponseBody Object srchAprj20051ExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        param.setPageRowCnt("999999999");
        
        List<Aprj20030Model> list = serviceAprj20051.srchAprj20051ExcelList(param);
        
        
		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
		FileUtil.mkdir(realUploadPath);
        
        String fileName = "요청내용_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
        File file = FileUtil.getSerNumFile(realUploadPath + fileName, "xlsx");


        LinkedHashMap<String, String> titleMap  = new LinkedHashMap<String, String>();
        titleMap.put("coId         ".trim(), "업체 ID                      ".trim());
        titleMap.put("coNm         ".trim(), "업체 명                      ".trim());
        titleMap.put("opId         ".trim(), "업무 ID                      ".trim());
        titleMap.put("opSerNum     ".trim(), "업무 버전                    ".trim());
        titleMap.put("opNm         ".trim(), "업무 명                      ".trim());
        titleMap.put("opCtt        ".trim(), "업무 내용                    ".trim());

        titleMap.put("prdCnt       ".trim(), "기간 수                      ".trim());
        titleMap.put("cyclClNm     ".trim(), "주기 구분 명                 ".trim());
        titleMap.put("stdDt        ".trim(), "기준 일자                    ".trim());
        
        titleMap.put("reqSerNum    ".trim(), "요청 일련번호                ".trim());
        titleMap.put("reqSeqNum    ".trim(), "요청 순번                    ".trim());
        titleMap.put("reqTypCd     ".trim(), "요청 종류 코드(일반:1000, 1001:텍스트, 단일선택:2000, 단일입력:2001, 다중선택:3000, 일자:5000, 과거일자:5001, 6000:사용자, 6001:결제자, 6002:기안자, 7000:부서, 8000:업무자산, 8001:업무자산결제자, 8003:자산, 9000:양식추가)".trim());
        titleMap.put("reqTypNm     ".trim(), "요청 종류 명                 ".trim());
        titleMap.put("reqCtt       ".trim(), "요청 내용                    ".trim());
        
        titleMap.put("itmSerNum    ".trim(), "항목 일련번호                ".trim());
        titleMap.put("itmVal       ".trim(), "항목 값                      ".trim());
        
        titleMap.put("opChrgId     ".trim(), "업무 담당 ID                 ".trim());
        titleMap.put("opChrgNm     ".trim(), "업무 담당 명                 ".trim());
        titleMap.put("userId       ".trim(), "사용자 ID                    ".trim());
        titleMap.put("userNm       ".trim(), "사용자 명                    ".trim());
        titleMap.put("resSerNum    ".trim(), "응답 일련번호                ".trim());
        
        titleMap.put("resItmSerNum ".trim(), "응답 항목 일련번호           ".trim());
        titleMap.put("rgstClCd     ".trim(), "등록 구분 코드(요청:1000, 추가:2000)".trim());
        titleMap.put("rgstClNm     ".trim(), "등록 구분 명                 ".trim());
        titleMap.put("resId        ".trim(), "응답 ID                      ".trim());
        titleMap.put("resCtt       ".trim(), "응답 내용                    ".trim());
        
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

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    /**
     * 프로젝트_응답저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20051_00)
    public @ResponseBody Object saveAprj20051(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 처리 상태 코드
        modelAndView.addObject(resStCdList                  , getGrpCdList(GrpCdConstants_Aprj.RES_ST_CD                    ));

        
        // 응답등록
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        // 응답상태 저장
        param.setResDt(DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD));
        serviceAprj20050.saveAprj20050(param);

        // 
        serviceAprj20034.updateAprj20034(param);
        // 
        if ( !ApplicationConstants_Aprj.RES_ST_CD_4000.equals(param.getResStCd()) ) {

            List<Aprj20030Model> headerList = serviceAprj20040.srchAprj20040List(param);
        	serviceAprj20051.deleteAprj20051(param);
        	serviceAprj20036.deleteAprj20036Add(param);

            String reqSerNum = "";
            Aprj20030Model insert = new Aprj20030Model();
    		String[]  paramItmSerNum;
    		String[]  paramResCtt   ;

    		String[]  stmOpChrg;
    		String[]  stmUser;
    		
            if ( !(headerList == null || headerList.size() == 0) ) {
            	
            	for ( int i = 0; i < headerList.size(); i++ ) {
            		insert = headerList.get(i);
            		insert.setResSerNum(param.getResSerNum());
            		
            		reqSerNum = insert.getReqSerNum();
    				insert.setOpChrgId(param.getOpChrgId());
    				insert.setUserId  (param.getUserId  ());
                	
    				paramItmSerNum = request.getParameterValues("itm_" + reqSerNum);
    				paramResCtt    = request.getParameterValues("ctt_" + reqSerNum);
    				
    				if ( paramItmSerNum == null || paramItmSerNum.length == 0 ) continue;
    				
    				for ( int j = 0; j < paramItmSerNum.length; j++ ) {
    					
    				    switch (insert.getReqTypCd()) {
        					case ApplicationConstants_Aprj.REQ_TYP_CD_1000 :  // 일반
        						insert.setResCtt(paramItmSerNum   [j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_1001 :  // 텍스트
        						insert.setResCtt(paramItmSerNum   [j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_2000 :  // 단일선택
        						insert.setItmSerNum(paramItmSerNum[j]);
        						insert.setResCtt(paramResCtt   [Integer.parseInt(paramItmSerNum[j]) - 1]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_2001 :  // 단일입력
        						insert.setItmSerNum(paramItmSerNum[j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_3000 :  // 다중선택
        						insert.setItmSerNum(paramItmSerNum[j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_5000 :  // 일자
        						insert.setResCtt(paramItmSerNum   [j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_5001 :  // 과거일자
        						insert.setResCtt(paramItmSerNum   [j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_6000 :  // 사용자
        						insert.setResId (paramItmSerNum   [j]);
        						insert.setResCtt(paramResCtt      [j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_6001 :  // 결제자
        						insert.setResId (paramItmSerNum   [j]);
        						insert.setResCtt(paramResCtt      [j]);
        						
        						if ( serviceAprj20036.srchAprj20036Exist(param) == null ) {
        							param.setStmAuthCd("3000");
        							param.setStmClCd  ("1000");
        							param.setStmUserId(paramItmSerNum   [j]);
        							param.setStmUserNm(paramResCtt      [j]);
        							
        							serviceAprj20036.insertAprj20036(param);
        						}
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_6002 :  // 기안자
        						insert.setResId (paramItmSerNum   [j]);
        						insert.setResCtt(paramResCtt      [j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_7000 :  // 부서
        						insert.setResId (paramItmSerNum   [j]);
        						insert.setResCtt(paramResCtt      [j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_8000 :  // 업무자산
        						insert.setResId (paramItmSerNum   [j]);
        						insert.setResCtt(paramResCtt      [j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_8001 :  // 업무자산결제자
        						if ( StringUtil.isNull(paramResCtt      [j])) {
        							break;
        						}
        						
        						stmOpChrg = paramItmSerNum   [j].split("/");
        						stmUser   = paramResCtt      [j].split("/");
        						
        						param.setStmOpChrgId(stmOpChrg[0]);
        						param.setStmOpChrgNm(stmOpChrg[1]);
        						
        						param.setStmUserId  (stmUser  [0]);
        						param.setStmUserNm  (stmUser  [1]);
        						
        						if ( serviceAprj20036.srchAprj20036Exist(param) == null ) {
        							param.setStmAuthCd("3000");
        							param.setStmClCd  ("1000");
        							
        							serviceAprj20036.insertAprj20036(param);
        						}
        						
        						insert.setResId (paramItmSerNum   [j]);
        						insert.setResCtt(paramResCtt      [j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_8002 :  // 자산
        						insert.setResId (paramItmSerNum   [j]);
        						insert.setResCtt(paramResCtt      [j]);
        						break;
        					case ApplicationConstants_Aprj.REQ_TYP_CD_9000 :  // 추가
        						insert.setResId (paramItmSerNum   [j]);
        						insert.setResCtt(paramResCtt      [j]);
        						break;
        					default :
        						insert.setResId (paramItmSerNum   [j]);
        						insert.setResCtt(paramResCtt      [j]);
        						break;
    					}
    					
    				    insert.setRgstClCd("1000");
    					serviceAprj20051.insertAprj20051(insert);
    				}
            	}
            	
            	String[] addIds  = request.getParameterValues("addId");
            	String[] addCtts = request.getParameterValues("addCtt");

            	reqSerNum = serviceAprj20051.srchAprj20051ReqSerNum(param);
            	if ( addIds != null && addCtts != null ) {
                	for ( int i = 0; i < addIds.length; i++ ) {
                		param.setItmSerNum("1");
                		
                		param.setReqSerNum(reqSerNum);
                		reqSerNum = (Integer.parseInt(reqSerNum) + 1) + "";

                		param.setRgstClCd("2000");
                		param.setResId (addIds [i]);
                		param.setResCtt(addCtts[i]);

                		serviceAprj20051.insertAprj20051(param);
                		
                	}
            	}
            }
            
        }
        
        
        
        // 파일 작업
        MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;
        Iterator<String> fileNameIterator = mpRequest.getFileNames();

		String realUploadPath = ApplicationConstants_Aprj.UPLOAD_DIR_PATH + "/" + param.getCoId() + "/" + param.getOpId() + "/" + param.getOpSerNum() + "/" + param.getReqSerNum() + "/" + param.getResSerNum() + "/";
		FileUtil.mkdir(realUploadPath);
    	
		try {
			while (fileNameIterator.hasNext()) {
	            List<MultipartFile> multiFiles = mpRequest.getFiles(fileNameIterator.next());
	
	            for ( int i = 0; i < multiFiles.size(); i++ ) {
	            	MultipartFile multiFile = multiFiles.get(i);
	            	
		            if (multiFile.getSize() < 0) {
		                throw new Exception();
		            }
		            
	                String fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
	                if ( fileName == null ) {
	                	continue;
	                }
	                
	                param.setPscFileNm (fileName);
	                param.setLgcFileNm (multiFile.getOriginalFilename());
	                param.setFilePath  (realUploadPath + fileName);
	                param.setFileSize  (multiFile.getSize() + "");
	                param.setDloadCnt  ("0");
		            
		            serviceAprj20052.insertAprj20052(param);
	            }
	        }
			
			AprjMessage.setMsg(modelAndView, "info.common.create.success");
			
		} catch ( Exception e ) {
			AprjMessage.setMsg(modelAndView, "error.common.create.fail");
		}
        
        
        
        
        
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
		
        modelAndView.addObject(resultHeader  , serviceAprj20050.srchAprj20050(param));
        modelAndView.addObject(resultList    , serviceAprj20051.srchAprj20051List(param));
        modelAndView.addObject(resultFileList, serviceAprj20052.srchAprj20052List(param));
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20051_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20051_80)
    public @ResponseBody Object deleteAprj20051(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceAprj20051.deleteAprj20051(param);
        }

        modelAndView = (ModelAndView) srchAprj20051List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}