/*-------------------------------------------------------------------
* NAME   : Aprj00000Controller
* DESC   : 관리자_로그인관리
* DATE   : 2013-11-21
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/
package project.spring.app.aprj.controller;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj00090Model;
import project.spring.app.aprj.model.Aprj10010Model;
import project.spring.app.aprj.model.Aprj10020Model;
import project.spring.app.aprj.model.Aprj10030Model;
import project.spring.app.aprj.model.Aprj10040Model;
import project.spring.app.aprj.model.Aprj20010Model;
import project.spring.app.aprj.model.Aprj20020Model;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj00090Service;
import project.spring.app.aprj.service.Aprj10010Service;
import project.spring.app.aprj.service.Aprj10011Service;
import project.spring.app.aprj.service.Aprj10012Service;
import project.spring.app.aprj.service.Aprj10020Service;
import project.spring.app.aprj.service.Aprj10021Service;
import project.spring.app.aprj.service.Aprj10022Service;
import project.spring.app.aprj.service.Aprj10030Service;
import project.spring.app.aprj.service.Aprj10031Service;
import project.spring.app.aprj.service.Aprj10040Service;
import project.spring.app.aprj.service.Aprj20010Service;
import project.spring.app.aprj.service.Aprj20020Service;
import project.spring.app.aprj.service.Aprj20021Service;
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
import project.spring.app.zcom.lib.util.ExcelFileUtil;
import project.spring.app.zcom.lib.util.FileUpload;
import project.spring.app.zcom.lib.util.FileUtil;
import project.spring.app.zcom.lib.util.StringUtil;
import project.spring.app.zcom.model.Zcom99030Model;
import project.spring.app.zcom.model.Zcom99032Model;
import project.spring.app.zcom.service.Zcom99020Service;
import project.spring.app.zcom.service.Zcom99030Service;
import project.spring.app.zcom.service.Zcom99031Service;
import project.spring.app.zcom.service.Zcom99032Service;

@Controller
public class Aprj00090Controller extends AprjController {

    // 엑셀 업로드
	@Autowired
    Aprj00090Service serviceAprj00090;
	
	
    // 자산구분
	@Autowired
    Aprj10010Service serviceAprj10010;

    @Autowired
    Aprj10011Service serviceAprj10011;

    @Autowired
    Aprj10012Service serviceAprj10012;

    
    
    
    // 프로젝트
    @Autowired
    Aprj20010Service serviceAprj20010;

    @Autowired
    Aprj20020Service serviceAprj20020;

    @Autowired
    Aprj20021Service serviceAprj20021;

    
    
    
    // 업무담당
    @Autowired
    Aprj10020Service serviceAprj10020;

    @Autowired
    Aprj10021Service serviceAprj10021;

    @Autowired
    Aprj10022Service serviceAprj10022;


    
    
    // 업무주기
    @Autowired
    Aprj10040Service serviceAprj10040;


    
    
    // 결제라인
    @Autowired
    Aprj10030Service serviceAprj10030;

    @Autowired
    Aprj10031Service serviceAprj10031;

    
    
    
    // 업무
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

    
    
    
    // 사용자
    @Autowired
    Zcom99030Service serviceZcom99030;


    
    
    // 업체
    @Autowired
    Zcom99031Service serviceZcom99031;


    
    
    // 부서
    @Autowired
    Zcom99032Service serviceZcom99032;


    // 부서
    @Autowired
    Zcom99020Service serviceZcom99020;

    
//    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultObject                   = "resultObject"                ;  // 리스트결과

    
    /**
     * 공통_EXCEL UPLOAD
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return returnResponse(modelAndView) ModelAndView객체
     * @CommonException CommonException 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_EXCEL_UPLOAD)
    public @ResponseBody Object srchAprj00090ExcelFileList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

		Aprj00090Model param = new Aprj00090Model();
	    getParameter(request, param);
	    
		switch (param.getWorkId()) {
		
		    // 자산구분
			case "AST_CL" :
				param.setWorkNm("자산구분");
	        	break;
	        	
	        // 자산	
			case "AST" :
				param.setWorkNm("자산");
	        	break;
	        	
		    // 프로젝트	
			case "PRJ" :
				param.setWorkNm("프로젝트");
	        	break;
	        	
		    // 업무 담당  	
			case "OP_CHRG" :
				param.setWorkNm("업무 담당");
	        	break;
	        	
		    // 주기
			case "CYCL" :
				param.setWorkNm("업무 주기");
	        	break;
	        	
		    // 결제라인	
			case "STM" :
				param.setWorkNm("결제 라인");
	        	break;
	        	
		    // 업무	
			case "OP" :
				param.setWorkNm("업무");
	        	break;
	        	
			    // 업무	
			case "OP_USER" :
				param.setWorkNm("담당자 업무");
	        	break;
	        	
		    // 업무	결제
			case "OP_STM" :
				param.setWorkNm("업무 결제");
	        	break;
	        	
			// 부서
			case "DEPT" :
				param.setWorkNm("부서");
	        	break;
	        	
			// 사용자
			case "USER" :
				param.setWorkNm("사용자");
	        	break;
	        	
				// 응답
			case "RES" :
				param.setWorkNm("응답");
	        	break;
		}

		/*
		Zcom99020Model param = new Zcom99020Model();
        setCoInfo(request, modelAndView, param);
        param.setSrchFileUploadYn("Y");
        param.setPageRowCnt("99999");
        
        modelAndView.addObject(resultList   , serviceAprj00090.srchZcom99020List(param));
        */
        modelAndView.addObject(resultObject , param);
		
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_EXCEL_UPLOAD);
        return returnResponse(modelAndView);
    }


    /**
     * 공통_EXCEL UPLOAD
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return returnResponse(modelAndView) ModelAndView객체
     * @CommonException CommonException 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_DATA_DELETE_ALL)
    public @ResponseBody Object delAprj00090DataDeleteAll(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }
        
        serviceAprj10010.deleteAprj10010All();
        serviceAprj10011.deleteAprj10011All();
        serviceAprj10012.deleteAprj10012All();
        
        serviceAprj10020.deleteAprj10020All();
        serviceAprj10021.deleteAprj10021All();
        serviceAprj10022.deleteAprj10022All();
        
        serviceAprj10030.deleteAprj10030All();
        serviceAprj10031.deleteAprj10031All();
        
        serviceAprj10040.deleteAprj10040All();
        
        serviceAprj20010.deleteAprj20010All();
        serviceAprj20020.deleteAprj20020All();
        serviceAprj20021.deleteAprj20021All();
        
        serviceAprj20030.deleteAprj20030All();
        serviceAprj20031.deleteAprj20031All();
        serviceAprj20032.deleteAprj20032All();
        serviceAprj20033.deleteAprj20033All();
        serviceAprj20034.deleteAprj20034All();
        serviceAprj20035.deleteAprj20035All();
        serviceAprj20038.deleteAprj20038All();
        serviceAprj20039.deleteAprj20039All();
        
        serviceAprj20040.deleteAprj20040All();
        serviceAprj20041.deleteAprj20041All();
        serviceAprj20051.deleteAprj20051All();
        
        serviceZcom99030.deleteZcom99030All();
        serviceZcom99031.deleteZcom99031All();
        serviceZcom99032.deleteZcom99032All();
        
        modelAndView = (ModelAndView) srchAprj00090ExcelFileList(request);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }


    /**
     * 공통_EXCEL UPLOAD EXECUTE
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return returnResponse(modelAndView) ModelAndView객체
     * @CommonException CommonException 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_EXCEL_EXECUTE)
    public @ResponseBody Object srchAprj00090ExcelFileExecute(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자ID 오류
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }
        
		Aprj00090Model param = new Aprj00090Model();
	    getParameter(request, param);
	    
		
        // 파일 작업
        MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;

		String realUploadPath = ApplicationConstants_Aprj.UPLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
		FileUtil.mkdir(realUploadPath);

		String fileName = mpRequest.getFileMap().get("uploadFile").getOriginalFilename();
		MultipartFile multiFile = mpRequest.getFileMap().get("uploadFile");
        fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);

	
		switch (param.getWorkId()) {
		
		    // 자산구분
			case "AST_CL" :
	        	saveAprj10010(realUploadPath, fileName);
	        	break;
	        	
	        // 자산	
			case "AST" :
	        	saveAprj10012(realUploadPath, fileName);
	        	break;
	        	
		    // 프로젝트	
			case "PRJ" :
	            saveAprj20010(realUploadPath, fileName);
	        	break;
	        	
		    // 업무 담당	
			case "OP_CHRG" :
				saveAprj10020(realUploadPath, fileName);
	        	break;
	        	
		    // 주기
			case "CYCL" :
	            saveAprj10040(realUploadPath, fileName);
	        	break;
	        	
		    // 결제	
			case "STM" :
	            saveAprj10030(realUploadPath, fileName);
	        	break;
	        	
		    // 업무	
			case "OP" :
	            saveAprj20030(realUploadPath, fileName);
	        	break;
	        	
			    // 업무	
			case "OP_USER" :
	            saveAprj20030User(realUploadPath, fileName);
	        	break;
	        	
			// 업무	결제
			case "OP_STM" :
	            saveAprj20032(realUploadPath, fileName);
	        	break;
	        	
			// 부서
			case "DEPT" :
				saveZcom99032(realUploadPath, fileName);
	        	break;
        	
			// 사용자
			case "USER" :
				saveZcom99030(realUploadPath, fileName);
	        	break;
	        	
				// 응답
			case "RES" :
				saveAprj20051(realUploadPath, fileName);
	        	break;
		}
	    
        modelAndView = (ModelAndView) srchAprj00090ExcelFileList(request);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }
        
    /**
     * 공통_EXCEL UPLOAD EXECUTE
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return returnResponse(modelAndView) ModelAndView객체
     * @CommonException CommonException 처리 에러발생.
     */
//    @RequestMapping(ActionConstants_Aprj.ACTION_EXCEL_EXECUTE)
    public @ResponseBody Object srchAprj00090ExcelFileExecute_(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자ID 오류
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }
        
        // 파일 작업
        MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;

		String realUploadPath = ApplicationConstants_Aprj.UPLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
		FileUtil.mkdir(realUploadPath);
    	
		String workId = "";
		String fileName = "";
		MultipartFile multiFile = null;
		
		
        // 자산구분
		workId = "uploadFile_10010010";
		fileName = mpRequest.getFileMap().get(workId).getOriginalFilename();
		System.out.println(fileName);
        if ( !StringUtil.isNull(fileName) ) {
        	multiFile = mpRequest.getFileMap().get(workId);
            fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
            
        	saveAprj10010(realUploadPath, fileName);
    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        }
        
        
        
		
        // 자산
		workId = "uploadFile_10010012";
		fileName = mpRequest.getFileMap().get(workId).getOriginalFilename();
		System.out.println(fileName);
        if ( !StringUtil.isNull(fileName) ) {
        	multiFile = mpRequest.getFileMap().get(workId);
            fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
            
        	saveAprj10012(realUploadPath, fileName);
    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        }
        
        
        
		
        // 프로젝트
		workId = "uploadFile_10020010";
		fileName = mpRequest.getFileMap().get(workId).getOriginalFilename();
		System.out.println(fileName);
        if ( !StringUtil.isNull(fileName) ) {
        	multiFile = mpRequest.getFileMap().get(workId);
            fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
            
            saveAprj20010(realUploadPath, fileName);
    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        }

        
        
        
        // 업무담당
		workId = "uploadFile_10030010";
		fileName = mpRequest.getFileMap().get(workId).getOriginalFilename();
		System.out.println(fileName);
        if ( !StringUtil.isNull(fileName) ) {
        	multiFile = mpRequest.getFileMap().get(workId);
            fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
            
        	saveAprj10020(realUploadPath, fileName);
    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        }
        
		
        
        
        // 업무주기
		workId = "uploadFile_10040010";
		fileName = mpRequest.getFileMap().get(workId).getOriginalFilename();
		System.out.println(fileName);
        if ( !StringUtil.isNull(fileName) ) {
        	multiFile = mpRequest.getFileMap().get(workId);
            fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
            
            saveAprj10040(realUploadPath, fileName);
    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        }
        
        
        

        // 결제라인
		workId = "uploadFile_10050010";
		fileName = mpRequest.getFileMap().get(workId).getOriginalFilename();
		System.out.println(fileName);
        if ( !StringUtil.isNull(fileName) ) {
        	multiFile = mpRequest.getFileMap().get(workId);
            fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
            
            saveAprj10030(realUploadPath, fileName);
    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        }
        		
        
		
        // 업무
		workId = "uploadFile_20031010";
		fileName = mpRequest.getFileMap().get(workId).getOriginalFilename();
		System.out.println(fileName);
        if ( !StringUtil.isNull(fileName) ) {
        	multiFile = mpRequest.getFileMap().get(workId);
            fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
            
            saveAprj20030(realUploadPath, fileName);
    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        }
        		
        
		
        // 업무 결제라인
		workId = "uploadFile_20032010";
		fileName = mpRequest.getFileMap().get(workId).getOriginalFilename();
		System.out.println(fileName);
        if ( !StringUtil.isNull(fileName) ) {
        	multiFile = mpRequest.getFileMap().get(workId);
            fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
            
            saveAprj20032(realUploadPath, fileName);
    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        }
        		
        
		
        // 부서
		workId = "uploadFile_20040010";
		fileName = mpRequest.getFileMap().get(workId).getOriginalFilename();
		System.out.println(fileName);
        if ( !StringUtil.isNull(fileName) ) {
        	multiFile = mpRequest.getFileMap().get(workId);
            fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
            
            saveZcom99032(realUploadPath, fileName);
    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        }
        
		
		
        
        // 사용자
		workId = "uploadFile_20050010";
		fileName = mpRequest.getFileMap().get(workId).getOriginalFilename();
		System.out.println(fileName);
        if ( !StringUtil.isNull(fileName) ) {
        	multiFile = mpRequest.getFileMap().get(workId);
            fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
            
            saveZcom99030(realUploadPath, fileName);
    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        }
        
				
        modelAndView = (ModelAndView) srchAprj00090ExcelFileList(request);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }
    
    
   
    
    
    
    // 자산구분
	public void saveAprj10010(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Aprj10010Model param = new Aprj10010Model();
        param.setUser(sessionUser);
        
        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
                break;
            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

            // 자산구분등록
            //param.setCoId           (sessionUser.getCoId());
            param.setCoId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
            param.setAstClId        (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
            param.setAstClNm        (getMaxLength(ExcelFileUtil.getCell(row.getCell(3)), 40));
            param.setAstClCtt       (getMaxLength(ExcelFileUtil.getCell(row.getCell(4)), 200));
            
            if ( !StringUtil.isNull(param.getAstClId()) ) {
            	try {
                    serviceAprj10010.saveAprj10010(param);
            	} catch ( Exception e ) {
            		e.printStackTrace();
            	}
            }
            
            
            // 자산구분자산등록
            //param.setCoId           (sessionUser.getCoId());
            param.setCoId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
            param.setAstClId        (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
//            param.setAstId          (             ExcelFileUtil.getCell(row.getCell(5))     );
            
            String[] temp = ExcelFileUtil.getCell(row.getCell(5)).split(",");
            if ( temp != null ) {
            	
	            for ( int i = 0; i < temp.length; i++ ) {
	            	if ( StringUtil.isNull(getMaxLength(temp[i].trim(), 10)) ) {
	            		continue;
	            	}
	                param.setAstId(temp[i].trim());

	            	try {
	                	serviceAprj10011.saveAprj10011(param);
	            	} catch ( Exception e ) {
	            		e.printStackTrace();
	            	}
	            }
            }
        }
        
		System.out.println("saveAprj10010");
	}
    
	
    // 자산
	public void saveAprj10012(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Aprj10010Model param = new Aprj10010Model();
        param.setUser(sessionUser);
        
        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
                break;
            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

            // 자산등록
            //param.setCoId           (sessionUser.getCoId());
            param.setCoId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
            param.setAstId          (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
            param.setAstNm          (getMaxLength(ExcelFileUtil.getCell(row.getCell(3)), 40));
            param.setAstCtt         (getMaxLength(ExcelFileUtil.getCell(row.getCell(4)), 200));
            
            if ( !StringUtil.isNull(param.getAstId()) ) {
            	try {
                	serviceAprj10012.saveAprj10012(param);
            	} catch ( Exception e ) {
            		e.printStackTrace();
            	}
            }
            
        }
        
		System.out.println("saveAprj10010");
	}
    
	
	// 프로젝트
	public void saveAprj20010(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
		
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Aprj20010Model param = new Aprj20010Model();
        param.setUser(sessionUser);
        
        Aprj20020Model param2 = new Aprj20020Model();
        param2.setUser(sessionUser);

        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
                break;
            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

            // 프로젝트
            param.setCoId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
            param.setPrjId          (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
            param.setPrjNm          (getMaxLength(ExcelFileUtil.getCell(row.getCell(3)), 40));
            param.setPrjCtt         (getMaxLength(ExcelFileUtil.getCell(row.getCell(4)), 200));
            
            if ( StringUtil.isNull(param.getPrjId()) ) {
                continue;
            }
        	try {
                serviceAprj20010.saveAprj20010(param);
        	} catch ( Exception e ) {
        		e.printStackTrace();
        	}
            
            
            // 통제
            param2.setCoId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
            param2.setPrjId          (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
            param2.setCtrlNum        (getMaxLength(ExcelFileUtil.getCell(row.getCell(5)), 20));
            param2.setCtrlNm         (getMaxLength(ExcelFileUtil.getCell(row.getCell(6)), 40));
            param2.setCtrlCtt        (getMaxLength(ExcelFileUtil.getCell(row.getCell(7)), 200));
            
            if ( StringUtil.isNull(param2.getCtrlNum()) ) {
                continue;
            }
        	try {
                serviceAprj20020.saveAprj20020(param2);
        	} catch ( Exception e ) {
        		e.printStackTrace();
        	}
            
            
            // 자산
            param2.setCoId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
            param2.setPrjId          (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
            param2.setCtrlNum        (getMaxLength(ExcelFileUtil.getCell(row.getCell(5)), 20));
//            param2.setAstClId        (             ExcelFileUtil.getCell(row.getCell(8))     );
            
            String[] temp = ExcelFileUtil.getCell(row.getCell(8)).split(",");
            if ( temp != null ) {
            	
	            for ( int i = 0; i < temp.length; i++ ) {
	            	if ( StringUtil.isNull(getMaxLength(temp[i].trim(), 10)) ) {
	            		continue;
	            	}
	                param2.setAstClId(temp[i].trim());

	            	try {
		                serviceAprj20021.saveAprj20021(param2);
	            	} catch ( Exception e ) {
	            		e.printStackTrace();
	            	}
	            }
            }
        }
        
		System.out.println("saveAprj20010");
	}


	// 업무 담당
	public void saveAprj10020(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
		
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Aprj10020Model param = new Aprj10020Model();
        param.setUser(sessionUser);
        
        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
                break;
            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

            param.setCoId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
            param.setOpChrgId       (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
            param.setOpChrgNm       (getMaxLength(ExcelFileUtil.getCell(row.getCell(3)), 40));
            param.setOpChrgCtt      (getMaxLength(ExcelFileUtil.getCell(row.getCell(4)), 200));
            
            if ( StringUtil.isNull(param.getOpChrgId()) ) {
            	continue;
            }
        	try {
                serviceAprj10020.saveAprj10020(param);
        	} catch ( Exception e ) {
        		e.printStackTrace();
        	}
            
//            param.setAstClId(null);
//            serviceAprj10022.deleteAprj10022(param);
            String[] temp = ExcelFileUtil.getCell(row.getCell(5)).split(",");
            if ( temp != null ) {
	            for ( int i = 0; i < temp.length; i++ ) {
	            	if ( StringUtil.isNull(temp[i].trim()) ) {
	            		continue;
	            	}
	                param.setAstClId(getMaxLength(temp[i].trim(), 10));
	                
	            	try {
		                serviceAprj10022.saveAprj10022(param);
	            	} catch ( Exception e ) {
	            		e.printStackTrace();
	            	}
	            }
            }
            
//          param.setUserId(null);
//          serviceAprj10021.deleteAprj10021(param);
          String[] user = ExcelFileUtil.getCell(row.getCell(6)).split(",");
          if ( user != null ) {
	            for ( int i = 0; i < user.length; i++ ) {
	            	if ( StringUtil.isNull(user[i].trim()) ) {
	            		continue;
	            	}
	                param.setUserId(getMaxLength(user[i].trim(), 10));
	                
	            	try {
		                serviceAprj10021.saveAprj10021(param);
	            	} catch ( Exception e ) {
	            		e.printStackTrace();
	            	}
	            }
          }
          
        }
        
		System.out.println("saveAprj10020");
	}
    
	
	// 결제 라인
	public void saveAprj10030(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
		
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Aprj10030Model param = new Aprj10030Model();
        param.setUser(sessionUser);
        
        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
                break;
            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

            param.setCoId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
            param.setStmId          (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
            param.setStmNm          (getMaxLength(ExcelFileUtil.getCell(row.getCell(3)), 40));
            param.setStmCtt         (getMaxLength(ExcelFileUtil.getCell(row.getCell(4)), 200));
            
            if ( StringUtil.isNull(param.getStmId()) ) {
                continue;
            }
            
        	try {
                serviceAprj10030.saveAprj10030(param);
        	} catch ( Exception e ) {
        		e.printStackTrace();
        	}
            
            
//            param.setStmSerNum(null);
//            serviceAprj10031.deleteAprj10031(param);
            
            
            param.setCoId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
            param.setStmId          (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
//            param.setStmSerNum      (getNumeric  (ExcelFileUtil.getCell(row.getCell(5)), 99999));
            param.setStmClCd        (getMaxLength(ExcelFileUtil.getCell(row.getCell(6)), 4));
            param.setStmAuthCd      (getMaxLength(ExcelFileUtil.getCell(row.getCell(8)), 4));
            
            if ( "1000".equals(param.getStmAuthCd()) ) {
            	param.setStmOpChrgId(null);
            	try {
                    serviceAprj10031.insertAprj10031(param);
            	} catch ( Exception e ) {
            		
            	}
            } else if ( "2000".equals(param.getStmAuthCd()) ) {
            	
            	String[] temp = ExcelFileUtil.getCell(row.getCell(10)).split(",");

	            if ( temp != null ) {
		            for ( int i = 0; i < temp.length; i++ ) {
		            	if ( StringUtil.isNull(temp[i].trim()) ) {
		            		continue;
		            	}
		                param.setStmOpChrgId(getMaxLength(temp[i].trim(), 10));
		            	try {
			                serviceAprj10031.insertAprj10031(param);
		            	} catch ( Exception e ) {
		            		e.printStackTrace();
		            	}
		            }
	            }
            }
        }
        
		System.out.println("saveAprj10030");
	}
    
	
	// 업무주기
	public void saveAprj10040(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
		
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Aprj10040Model param = new Aprj10040Model();
        param.setUser(sessionUser);
        
        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
                break;
            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

            param.setCoId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
            param.setCyclId         (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
            param.setCyclNm         (getMaxLength(ExcelFileUtil.getCell(row.getCell(3)), 40));
            
            param.setPrdCnt         (getNumeric  (ExcelFileUtil.getCell(row.getCell(4)), 99999));
            param.setCyclClCd       (getMaxLength(ExcelFileUtil.getCell(row.getCell(5)),  4));
            param.setStdDt          (getDate     (ExcelFileUtil.getCell(row.getCell(7)),  8));
            
            if ( StringUtil.isNull(param.getCyclId()) ) {
                continue;
            }
        	try {
                serviceAprj10040.saveAprj10040(param);
        	} catch ( Exception e ) {
        		e.printStackTrace();
        	}
        }
        
		System.out.println("saveAprj10040");
	}

	
	// 업무
	public void saveAprj20030(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
		
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Aprj20030Model param  = new Aprj20030Model();
        param.setUser(sessionUser);
        
        LinkedHashMap<String, String> titleMap  = new LinkedHashMap<String, String>();
        titleMap.put("coId         ".trim(), "업체 ID                      ".trim());
//        titleMap.put("coNm         ".trim(), "업체 명                      ".trim());
        
//        titleMap.put("prjId        ".trim(), "프로젝트 ID                  ".trim());
//        titleMap.put("prjNm        ".trim(), "프로젝트 명                  ".trim());
//        titleMap.put("ctrlNum      ".trim(), "통제 번호                    ".trim());

        titleMap.put("opId         ".trim(), "업무 ID                      ".trim());
        titleMap.put("opSerNum     ".trim(), "업무 버전                    ".trim());
//        titleMap.put("opNm         ".trim(), "업무 명                      ".trim());
//        titleMap.put("opCtt        ".trim(), "업무 내용                    ".trim());
//
//        titleMap.put("prdCnt       ".trim(), "기간 수                      ".trim());
//        titleMap.put("cyclClCd     ".trim(), "주기 구분 코드(년:1000, 월:2000, 주:3000, 일:4000, 시:5000)".trim());
//        titleMap.put("cyclClNm     ".trim(), "주기 구분 명                 ".trim());
//        titleMap.put("stdDt        ".trim(), "기준 일자                    ".trim());
//        titleMap.put("autoClCd     ".trim(), "자동 구분 코드(1000:자동, 2000:수동)".trim());
//        titleMap.put("autoClNm     ".trim(), "자동 구분 명                 ".trim());
//
//        titleMap.put("stmId        ".trim(), "결제 ID                      ".trim());
//        titleMap.put("stmNm        ".trim(), "결제 명                      ".trim());
        
        titleMap.put("reqSerNum    ".trim(), "요청 일련번호                ".trim());
//        titleMap.put("reqSeqNum    ".trim(), "요청 순번                    ".trim());
//        titleMap.put("reqTypCd     ".trim(), "요청 종류 코드(일반:1000, 단일:2000, 다중:3000)".trim());
//        titleMap.put("reqTypNm     ".trim(), "요청 종류 명                 ".trim());
//        titleMap.put("reqCtt       ".trim(), "요청 내용                    ".trim());
        
//        titleMap.put("itmSerNum    ".trim(), "항목 일련번호                ".trim());
//        titleMap.put("itmVal       ".trim(), "항목 값                      ".trim());
        
        
        Aprj20010Model prjParam  = new Aprj20010Model();
        
        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

//            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
//                break;
//            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

            param = setRowData(titleMap, row, param);
            
            System.out.println("-----------------------------------------------------ROWNUM : " + rownum);
            param.println();

            
            // 업무 등록
            if ( !StringUtil.isNull(param.getOpNm()) ) {
                param.setUser(sessionUser);
                
                if ( StringUtil.isNull(param.getDrftUserId()) ) {
                	param.setDrftUserId(sessionUser.getUserId());
                	param.setDrftUserNm(sessionUser.getUserNm());
                }
                
                serviceAprj20030.saveAprj20030(param);
            }
            
            // 프로젝트 등록
            if ( !StringUtil.isNull(param.getPrjId()) ) {
	            prjParam.setCoId (param.getCoId ());
	    		prjParam.setPrjId(param.getPrjId());
	    		prjParam = serviceAprj20010.srchAprj20010(prjParam);
	    		param.setPrjNm(prjParam.getPrjNm());
	    		
	            serviceAprj20030.updateAprj20030Prj(param);
            }            

            
            // 통제 등록
            if ( !StringUtil.isNull(param.getCtrlNum()) ) {
                String[] temp = param.getCtrlNum().split(",");

	            for ( int i = 0; i < temp.length; i++ ) {
	            	if ( StringUtil.isNull(temp[i].trim()) ) {
	            		continue;
	            	}
	                param.setCtrlNum(getMaxLength(temp[i].trim(), 10));
	                
	            	try {
		                serviceAprj20031.saveAprj20031(param);
		                
		                serviceAprj20033.selectInsertAprj20033(param);
		                serviceAprj20034.selectInsertAprj20034(param);
		                serviceAprj20038.selectInsertAprj20038(param);
		                serviceAprj20039.selectInsertAprj20039(param);
	            	} catch ( Exception e ) {
	            		e.printStackTrace();
	            	}
	            }
            }

            
            // 결제 등록
            if ( !StringUtil.isNull(param.getStmId()) ) {
            	param.setStmSerNum(null);
            	serviceAprj20032.deleteAprj20032(param);
            	
            	param.setStmSerNum("0");
            	serviceAprj20032.insertAprj20032Pool(param);
            	
                serviceAprj20036.saveAprj20036StmUser(param);
            }

            
            // 요청 등록
            if ( !StringUtil.isNull(param.getReqTypCd()) ) {
            	serviceAprj20040.saveAprj20040(param);
            }
            
            // 요청항목
            serviceAprj20041.saveAprj20041(param);
        }
        
		System.out.println("saveAprj10040");
	}

	
	public Aprj20030Model setRowData(LinkedHashMap<String, String> titleMap, Row row, Aprj20030Model bfRaram) {
        
        Aprj20030Model param = new Aprj20030Model();
        
        // 업무등록
        int i = 0;
        // 업체
        param.setCoId            (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setCoNm            (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
        
        // 통제
        param.setPrjId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setPrjNm           (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
        param.setCtrlNum         (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 2000));
        
        // 업무
        param.setOpId            (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setOpSerNum        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 5));
        param.setOpNm            (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
        param.setOpCtt           (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 200));
        param.setDrftUserId      (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 20));
        param.setDrftUserNm      (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 40));
        param.setPrdCnt          (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 5));
        param.setCyclClCd        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setCyclClNm        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
        param.setStdDt           (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setAutoClCd        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setAutoClNm        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
      
        // 결제
        param.setStmId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setStmNm           (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
        
        // 요청
        param.setReqSerNum       (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 5));
        param.setReqSeqNum       (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 5));
        param.setReqTypCd        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setReqTypNm        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
        param.setReqCtt          (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 200));
        
        // 요청항목
        param.setItmSerNum       (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 5));
        param.setItmVal          (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
        

        if ( !StringUtil.isNull(param.getPrdCnt()) ) {
        	param.setPrdCnt(String.valueOf(Math.round(Double.parseDouble(param.getPrdCnt()))));
        }
        
        setBfData(titleMap, param, bfRaram);
        
        return param;
	}
	
	
	public void setBfData(LinkedHashMap<String, String> titleMap, Object param, Object bfRaram) {
		
        Iterator<String> keyData = titleMap.keySet().iterator();
        String key;
        String value;
	    Method method;
	    
        while (keyData.hasNext()) {
            key = (String) keyData.next();
            
    		try {
                method = param.getClass().getMethod("get" + key.substring(0,1).toUpperCase() + key.substring(1));
                value = (String) method.invoke(param);
                
    			if ( StringUtil.isNull(value) ) {
                    method = bfRaram.getClass().getMethod("get" + key.substring(0,1).toUpperCase() + key.substring(1));
                    value = (String) method.invoke(bfRaram);
    				
    				
	    			method = param.getClass().getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class);
	    			method.invoke(param, value);
    			}
    		} catch ( Exception e ) {
    			
    		}
    	}
	}
	
	
	// 업무 사용자
	public void saveAprj20030User(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
		
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Aprj20030Model param  = new Aprj20030Model();
//        param.setCoId(sessionUser.getCoId());
        param.setOpId(serviceAprj20030.srchAprj20030UserOpId(param));
        param.setOpSerNum("1");
        param.setUser(sessionUser);

        param.setDrftUserNm(sessionUser.getUserId());
        param.setDrftUserNm(sessionUser.getUserNm());
        
        
        LinkedHashMap<String, String> titleMap  = new LinkedHashMap<String, String>();
        titleMap.put("coId         ".trim(), "업체 ID                      ".trim());

        titleMap.put("opId         ".trim(), "업무 ID                      ".trim());
        titleMap.put("opSerNum     ".trim(), "업무 버전                    ".trim());
        
        titleMap.put("reqSerNum    ".trim(), "요청 일련번호                ".trim());
        
        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

//            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
//                break;
//            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

            
            // 업무
            param.setOpNm            (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 100));
            param.setOpCtt           (getMaxLength(ExcelFileUtil.getCell(row.getCell(1)), 200));
            param.setPrdCnt          ("0");
            param.setCyclClCd        ("1000");
            param.setStdDt           (DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD));
            param.setAutoClCd        ("2000");
            param.setTranStCd        ("2000");
          
            // 요청
            param.setReqSerNum       ((rownum - 1) + "");
            param.setReqSeqNum       ((rownum - 1) + "");
            param.setReqTypCd        ("4000");
            param.setReqCtt          (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 200));
            
            // 요청항목
            param.setItmSerNum       ("1");
            param.setItmVal          ("");

            param.setOpChrgId        (getMaxLength(ExcelFileUtil.getCell(row.getCell(3)), 10));
            param.setOpChrgNm        (getMaxLength(ExcelFileUtil.getCell(row.getCell(4)), 40));
            param.setUserId          (getMaxLength(ExcelFileUtil.getCell(row.getCell(5)), 20));
            param.setUserNm          (getMaxLength(ExcelFileUtil.getCell(row.getCell(6)), 40));
            param.setResSerNum       ("1");
            param.setResCtt          (getMaxLength(ExcelFileUtil.getCell(row.getCell(7)), 200));
            param.setResStCd         ("3000");
            param.setResDt           (DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD));
            
            // 업무 등록
            if ( !StringUtil.isNull(param.getOpNm()) ) {
                serviceAprj20030.saveAprj20030(param);
            }
            
            // 요청 등록
            if ( !StringUtil.isNull(param.getReqTypCd()) ) {
            	serviceAprj20040.saveAprj20040(param);
                serviceAprj20041.saveAprj20041(param);
            }
            
//            // 업무 담당
//            if ( !StringUtil.isNull(param.getReqTypCd()) ) {
//            	serviceAprj20033.saveAprj20033(param);
//            }
            
            // 업무 담당자
            if ( !StringUtil.isNull(param.getReqTypCd()) ) {
            	serviceAprj20034.saveAprj20034(param);
            }
            
            // 응답 등록
            if ( !StringUtil.isNull(param.getReqTypCd()) ) {
            	serviceAprj20050.saveAprj20050(param);
                serviceAprj20051.saveAprj20051(param);
            }
            
            param.setStmSerNum      (getNumeric  (ExcelFileUtil.getCell(row.getCell(8)), 99999));
            param.setStmClCd        (getMaxLength(ExcelFileUtil.getCell(row.getCell(9)), 4));
            param.setStmAuthCd      (getMaxLength(ExcelFileUtil.getCell(row.getCell(11)), 4));
            
            if ( "1000".equals(param.getStmAuthCd()) ) {
            	param.setStmOpChrgId(null);
            	try {
                    serviceAprj20032.saveAprj20032(param);
            	} catch ( Exception e ) {
            		e.printStackTrace();
            	}
            } else {
            	String[] temp = ExcelFileUtil.getCell(row.getCell(13)).split(",");
	            if ( temp != null ) {
		            for ( int i = 0; i < temp.length; i++ ) {
		            	if ( StringUtil.isNull(temp[i].trim()) ) {
		            		continue;
		            	}
		                param.setStmOpChrgId(getMaxLength(temp[i].trim(), 10));
		                
		            	try {
			                serviceAprj20032.saveAprj20032(param);
		            	} catch ( Exception e ) {
		            		e.printStackTrace();
		            	}
		            }
	            }
            }
            
            serviceAprj20036.saveAprj20036StmUser(param);

        }
        
		System.out.println("saveAprj10040");
	}

	
	// 업무 결제라인
	public void saveAprj20032(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
		
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Aprj20030Model param  = new Aprj20030Model();
        param.setUser(sessionUser);
        
        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
                break;
            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

            // 업무 조회
            param.setCoId            (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
            param.setOpId            (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
            param.setOpSerNum        (getMaxLength(ExcelFileUtil.getCell(row.getCell(3)), 5));
            
            Aprj20030Model model  = new Aprj20030Model();
            model = serviceAprj20030.srchAprj20030(param);
            
        	if ( model == null ) {
        		continue;
        	}
            
//            param.setStmSerNum      (getNumeric  (ExcelFileUtil.getCell(row.getCell(5)), 99999));
            param.setStmClCd        (getMaxLength(ExcelFileUtil.getCell(row.getCell(6)), 4));
            param.setStmAuthCd      (getMaxLength(ExcelFileUtil.getCell(row.getCell(8)), 4));
            
            if ( "1000".equals(param.getStmAuthCd()) ) {
            	param.setStmOpChrgId(null);
            	try {
                    serviceAprj20032.insertAprj20032(param);
            	} catch ( Exception e ) {
            		e.printStackTrace();
            	}
            } else {
            	String[] temp = ExcelFileUtil.getCell(row.getCell(10)).split(",");
	            if ( temp != null ) {
		            for ( int i = 0; i < temp.length; i++ ) {
		            	if ( StringUtil.isNull(temp[i].trim()) ) {
		            		continue;
		            	}
		                param.setStmOpChrgId(getMaxLength(temp[i].trim(), 10));
		                
		            	try {
			                serviceAprj20032.insertAprj20032(param);
		            	} catch ( Exception e ) {
		            		e.printStackTrace();
		            	}
		            }
	            }
            }
            
            serviceAprj20036.saveAprj20036StmUser(param);
        }
        
		System.out.println("saveAprj20032");
	}

	
	// 부서
	public void saveZcom99032(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
		
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Zcom99032Model param = new Zcom99032Model();
        param.setUser(sessionUser);
        
        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
                break;
            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

            param.setCoId            (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
//            param.setCoNm            (getMaxLength(ExcelFileUtil.getCell(row.getCell(1)), 40));
            param.setDeptId          (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
            param.setDeptNm          (getMaxLength(ExcelFileUtil.getCell(row.getCell(3)), 40));
            param.setDeptCtt         (getMaxLength(ExcelFileUtil.getCell(row.getCell(4)), 200));
            
            param.setSupDeptId       (getMaxLength(ExcelFileUtil.getCell(row.getCell(5)),  10));
//            param.setSupDeptNm       (getMaxLength(ExcelFileUtil.getCell(row.getCell(6)),  40));

	        if ( StringUtil.isNull(param.getDeptId()) ) {
                continue;
            }
        	try {
                serviceZcom99032.saveZcom99032(param);
        	} catch ( Exception e ) {
        		e.printStackTrace();
        	}
        }
        
		System.out.println("saveAprj10040");
	}
    
	
	// 사용자
	public void saveZcom99030(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
		
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Zcom99030Model param = new Zcom99030Model();
//        param.setUser(sessionUser);
        
        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
                break;
            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

//            param.setCoId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(0)), 10));
//            param.setCoNm           (getMaxLength(ExcelFileUtil.getCell(row.getCell(1)), 10));
            param.setUserId         (getMaxLength(ExcelFileUtil.getCell(row.getCell(2)), 10));
            param.setUserNm         (getMaxLength(ExcelFileUtil.getCell(row.getCell(3)), 40));
            param.setUserAuthCd     (getMaxLength(ExcelFileUtil.getCell(row.getCell(4)), 4));
//            param.setUserAuthNm     (getMaxLength(ExcelFileUtil.getCell(row.getCell(5)), 10));

            param.setDeptId         (getMaxLength(ExcelFileUtil.getCell(row.getCell(6)),  10));
//            param.setDeptNm         (getMaxLength(ExcelFileUtil.getCell(row.getCell(7)),  4));
//            param.setOpChrgId       (getMaxLength(ExcelFileUtil.getCell(row.getCell(8)), 10));
//            param.setOpChrgNm       (getMaxLength(ExcelFileUtil.getCell(row.getCell(9)), 10));
//            param.setOfcLvlClCd     (getMaxLength(ExcelFileUtil.getCell(row.getCell(10)), 4));
//            param.setOfcLvlClNm     (getMaxLength(ExcelFileUtil.getCell(row.getCell(11)), 40));

            param.setPhonNum        (getMaxLength(ExcelFileUtil.getCell(row.getCell(12)), 20));
            param.setMailAddr       (getMaxLength(ExcelFileUtil.getCell(row.getCell(13)), 100));
            param.setEffStaDt       (getDate     (ExcelFileUtil.getCell(row.getCell(14)), 8));
            param.setEffEndDt       (getDate     (ExcelFileUtil.getCell(row.getCell(15)), 8));
            
            if ( StringUtil.isNull(param.getUserId()) ) {
                continue;
            }
        	try {
                serviceZcom99030.saveZcom99030(param);
        	} catch ( Exception e ) {
        		e.printStackTrace();
        	}
        }
        
		System.out.println("saveAprj10040");
	}
    
	
	// 응답
	public void saveAprj20051(String filePath, String fileName) throws CommonException {
        if ( fileName == null ) {
        	return;
        }
		
        Sheet sheet = ExcelFileUtil.getSheet(filePath + fileName);
		
        int rownum = 0;
        Aprj20030Model param = new Aprj20030Model();
        param.setUser(sessionUser);
        
        LinkedHashMap<String, String> titleMap  = new LinkedHashMap<String, String>();
        titleMap.put("coId         ".trim(), "업체 ID                      ".trim());
        titleMap.put("opId         ".trim(), "업무 ID                      ".trim());
        titleMap.put("opSerNum     ".trim(), "업무 버전                    ".trim());
        titleMap.put("opChrgId     ".trim(), "업무 담당 ID                 ".trim());
        titleMap.put("opChrgNm     ".trim(), "업무 담당 명                 ".trim());
        titleMap.put("userId       ".trim(), "사용자 ID                    ".trim());
        titleMap.put("userNm       ".trim(), "사용자 명                    ".trim());
        
        titleMap.put("resSerNum    ".trim(), "응답 일련번호                ".trim());
        
        String itmNum    = "";
        String resId     = "";
        String resCtt    = "";
        String resSerNum = "";
        
        while (true) {
            Row row = sheet.getRow(rownum++);

            if ( row == null ) {
                break;
            }

            if ( row.getCell(0) == null ) {
                break;
            }

            if ( StringUtil.isNull(row.getCell(0).toString()) ) {
                break;
            }

            // 첫 라인은 생략
            if ( rownum == 1 ) {
                continue;
            }

            param = setRowData20051(titleMap, row, param);
            
            System.out.println("-----------------------------------------------------ROWNUM : " + rownum);
            param.println();
            
            if ( rownum == 2 && !StringUtil.isNull(param.getResSerNum())) {
            	serviceAprj20050.saveAprj20050(param);
            	serviceAprj20051.deleteAprj20051(param);
            	resSerNum = param.getResSerNum();
            }
            
            
            // 단일선택, 다중선택에서 선택값이 없는 경우
            if ( !StringUtil.isNull(param.getItmVal()) ) {
            	if ( StringUtil.isNull(param.getResItmSerNum())) {
                	continue;
            	}
            }
            
            
            // 요청종류가 추가면 생략
            if ( ApplicationConstants_Aprj.REQ_TYP_CD_9000.equals(param.getReqTypCd()) ) {
              	continue;
            }
            
            
            itmNum = param.getItmSerNum();
            resId  = param.getResId    ();
            resCtt = param.getResCtt   ();
            param.setResSerNum(resSerNum);
            
        	try {
			    switch (param.getReqTypCd()) {
					case ApplicationConstants_Aprj.REQ_TYP_CD_1000 :  // 일반
						param.setResCtt   (resCtt);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_1001 :  // 텍스트
						param.setResCtt   (resCtt);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_2000 :  // 단일선택
						param.setItmSerNum(itmNum);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_2001 :  // 단일입력
						param.setItmSerNum(itmNum);
						param.setResCtt   (resCtt);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_3000 :  // 다중선택
						param.setItmSerNum(itmNum);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_5000 :  // 일자
						param.setResCtt   (resCtt);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_5001 :  // 과거일자
						param.setResCtt   (resCtt);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_6000 :  // 사용자
						param.setResId    (resId );
						param.setResCtt   (resCtt);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_6001 :  // 결제자
						param.setResId    (resId );
						param.setResCtt   (resCtt);
						
						if ( serviceAprj20036.srchAprj20036Exist(param) == null ) {
							param.setStmAuthCd("3000");
							param.setStmClCd  ("1000");
							param.setStmUserId(resId );
							param.setStmUserNm(resCtt);
							
							serviceAprj20036.saveAprj20036(param);
						}
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_6002 :  // 기안자
						param.setResId    (resId );
						param.setResCtt   (resCtt);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_7000 :  // 부서
						param.setResId    (resId );
						param.setResCtt   (resCtt);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_8000 :  // 업무자산
						param.setResId    (resId );
						param.setResCtt   (resCtt);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_8001 :  // 업무자산결제자
						String[] stmOpChrg = resId .split("/");
						String[] stmUser   = resCtt.split("/");
						
						param.setStmOpChrgId(stmOpChrg[0]);
						param.setStmOpChrgNm(stmOpChrg[1]);
						
						param.setStmUserId  (stmUser  [0]);
						param.setStmUserNm  (stmUser  [1]);
						
						if ( serviceAprj20036.srchAprj20036Exist(param) == null ) {
							param.setStmAuthCd("3000");
							param.setStmClCd  ("1000");
							
							serviceAprj20036.saveAprj20036(param);
						}
						
						param.setResId    (resId );
						param.setResCtt   (resCtt);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_8002 :  // 자산
						param.setResId    (resId );
						param.setResCtt   (resCtt);
						break;
					case ApplicationConstants_Aprj.REQ_TYP_CD_9000 :  // 추가
						param.setResId    (resId );
						param.setResCtt   (resCtt);
						break;
			    }
			
			    serviceAprj20051.insertAprj20051(param);
        	} catch ( Exception e ) {
        		e.printStackTrace();
        	}
        }
        
		System.out.println("saveAprj10040");
	}

	
	public Aprj20030Model setRowData20051(LinkedHashMap<String, String> titleMap, Row row, Aprj20030Model bfRaram) {
        
        Aprj20030Model param = new Aprj20030Model();
        
        // 업무등록
        int i = 0;
        // 업체
        param.setCoId            (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setCoNm            (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
        
        param.setOpId            (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setOpSerNum        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 5));
        param.setOpNm            (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
        param.setOpCtt           (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 200));
        param.setPrdCnt          (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 5));
        param.setCyclClCd        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 4));
        param.setStdDt           (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
      
        // 요청
        param.setReqSerNum       (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setReqSeqNum       (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setReqTypCd        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setReqTypNm        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
        param.setReqCtt          (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 200));
        
        // 요청항목
        param.setItmSerNum       (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 5));
        param.setItmVal          (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));

        // 응답
        param.setOpChrgId        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 10));
        param.setOpChrgNm        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 40));
        param.setUserId          (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 20));
        param.setUserNm          (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 40));
        param.setResSerNum       (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 200));
        param.setResStCd         ("3000");
        param.setResDt           (DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD));

        // 응답항목
        param.setResItmSerNum    (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 5));
        param.setRgstClCd        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 4));
        param.setRgstClNm        (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 40));
        param.setResId           (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 100));
        param.setResCtt          (getMaxLength(ExcelFileUtil.getCell(row.getCell(i++)), 1000));

        setBfData20051(titleMap, param, bfRaram);
        
        return param;
	}
	
	
	public void setBfData20051(LinkedHashMap<String, String> titleMap, Object param, Object bfRaram) {
		
        Iterator<String> keyData = titleMap.keySet().iterator();
        String key;
        String value;
	    Method method;
	    
        while (keyData.hasNext()) {
            key = (String) keyData.next();
            
    		try {
                method = param.getClass().getMethod("get" + key.substring(0,1).toUpperCase() + key.substring(1));
                value = (String) method.invoke(param);
                
    			if ( StringUtil.isNull(value) ) {
                    method = bfRaram.getClass().getMethod("get" + key.substring(0,1).toUpperCase() + key.substring(1));
                    value = (String) method.invoke(bfRaram);
    				
    				
	    			method = param.getClass().getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class);
	    			method.invoke(param, value);
    			}
    		} catch ( Exception e ) {
    			
    		}
    	}
	}
	
	
	/*****************************************************************************
    *  원하는 문자열 길이 만큼
    *****************************************************************************/
    public static String getMaxLength(String sStr, int nLen) {
    	   
        if ( sStr == null ) {
     		return "";
     	}
     	
        sStr = sStr.trim();
        String sReturnStr = sStr;
        int    nCount     = 0;                // 단위 문장 길이
        
        try {
            for (int i = 0; i < sStr.length(); i++) {
            	nCount = nCount + sStr.substring(i, i + 1).getBytes("UTF-8").length;
  
                if (nCount > nLen) {
                    sReturnStr = sStr.substring(0, i);
                    break;
                }
            }
        } catch (Exception e) {
        	e.printStackTrace();
        } 

        return sReturnStr;
    }
    
    

    /*****************************************************************************
    *  원하는 숫자크기 만큼
    *****************************************************************************/
    public String getUpper(String sStr, int max) {
        if ( sStr == null ) {
    		return "";
        }
    	
        sStr = sStr.trim();
        String sReturnStr = "";
        
        char oneChar;

        for (int i = 0; i < sStr.length(); i++ ) {
            oneChar = sStr.charAt(i);
            
            if ( oneChar >= '0' && oneChar <= '9' ) {
            	sReturnStr = sReturnStr + oneChar;
                continue;
            }

            if( oneChar >= 'a' && oneChar <= 'z' ) {
            	sReturnStr = sReturnStr + (oneChar - 32); // 대문자로 변경
                continue;
            }

            if( oneChar >= 'A' && oneChar <= 'Z' ) {
            	sReturnStr = sReturnStr + oneChar;
                continue;
            }
        }

        return getMaxLength(sReturnStr, max);
    }
    
    
    
    /*****************************************************************************
    *  원하는 숫자크기 만큼
    *****************************************************************************/
    public String getNumeric(String sStr, int max) {
        if ( sStr == null ) {
    		return "0";
        }
    	
        sStr = StringUtil.getNumber(sStr);
       
        try {
        	if ( Integer.parseInt(sStr) > max ) {
        		sStr = Integer.toString(max);
        	}
        } catch (Exception e) {
        	System.out.println(sStr);
        	sStr = "0";
        } 

        return sStr;
    }
    
    
    
    /*****************************************************************************
    *  원하는 숫자크기 만큼
    *****************************************************************************/
    public String getDate(String sStr, int nLen) {
        if ( sStr == null ) {
    		return "";
        }
    	
        try {
        	sStr = DateUtil.getNumber(sStr).substring(0, nLen);
        	sStr = DateUtil.getDateFormat(sStr);
        } catch (Exception e) {
        	System.out.println(sStr);
    		return "";
        } 

        return sStr;
    }
    
}