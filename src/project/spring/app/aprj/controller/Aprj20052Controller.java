/*-------------------------------------------------------------------
* NAME   : Aprj20052Controller
* DESC   : 프로젝트_응답첨부파일
* Author : 
* DATE   : 2019-02-18
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

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
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20050Service;
import project.spring.app.aprj.service.Aprj20052Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.FileUpload;
import project.spring.app.zcom.lib.util.FileUtil;


@Controller
public class Aprj20052Controller extends AprjController {

    @Autowired
    Aprj20050Service serviceAprj20050;
    
    @Autowired
    Aprj20052Service serviceAprj20052;

    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultFileList                 = "resultFileList"              ;  // 리스트결과
    
    /**
     * 프로젝트_응답첨부파일리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20052_40)
    public @ResponseBody Object srchAprj20052List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        modelAndView.addObject(resultFileList, serviceAprj20052.srchAprj20052List(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20051_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답첨부파일조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20052_41)
    public @ResponseBody Object srchAprj20052(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20052.srchAprj20052(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20052_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_첨부파일조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_FILE_DOWNLOAD2)
    public @ResponseBody Object srchAprj20052_FILE_DOWNLOAD(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        Aprj20030Model result = serviceAprj20052.srchAprj20052(param);

        System.out.println(result.getFilePath());
        File filePath = new File(result.getFilePath());
        // 파일 존재 여부 확인.
        if ( !filePath.exists() || !filePath.canRead() ) {
        	AprjMessage.setMsg(modelAndView, "info.common.search.empty");
            modelAndView = (ModelAndView) srchAprj20052List(request);
            return returnResponse(modelAndView);
        }
        
        
        //Download Count값 증가
        serviceAprj20052.updateAprj20052(result);
        
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("fileSerNum", result.getFileSerNum());
        map.put("filePath"  , filePath);
        map.put("lgcFileNm" , result.getLgcFileNm ());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    /**
     * 프로젝트_응답첨부파일저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20052_00)
    public @ResponseBody Object saveAprj20052(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

//        modelAndView.addObject(resultHeader , serviceAprj20050.srchAprj20050(param));

        // 파일 작업
        MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;
        Iterator<String> fileNameIterator = mpRequest.getFileNames();

		String realUploadPath = ApplicationConstants_Aprj.UPLOAD_DIR_PATH + "/" + param.getCoId() + "/" + param.getOpId() + "/" + param.getOpSerNum() + "/" + param.getReqSerNum() + "/" + param.getResSerNum() + "/";
		FileUtil.mkdir(realUploadPath);
    	
		try {
			while (fileNameIterator.hasNext()) {
	            MultipartFile multiFile = mpRequest.getFile(fileNameIterator.next());
	
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
			
			AprjMessage.setMsg(modelAndView, "info.common.create.success");
			
		} catch ( Exception e ) {
			AprjMessage.setMsg(modelAndView, "error.common.create.fail");
		}

        modelAndView = (ModelAndView) srchAprj20052List(request);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답첨부파일삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20052_80)
    public @ResponseBody Object deleteAprj20052(HttpServletRequest request) throws CommonException {
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
            param.setFileSerNum(delKeys[i]);

            cnt =+ serviceAprj20052.deleteAprj20052(param);
        }

        modelAndView = (ModelAndView) srchAprj20052List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}