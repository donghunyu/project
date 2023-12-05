/*-------------------------------------------------------------------
* NAME   : Aprj20011Controller
* DESC   : 프로젝트_첨부파일
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
import project.spring.app.aprj.model.Aprj20010Model;
import project.spring.app.aprj.model.Aprj20011Model;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20010Service;
import project.spring.app.aprj.service.Aprj20011Service;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.FileUpload;
import project.spring.app.zcom.lib.util.FileUtil;
import project.spring.app.zcom.lib.util.StringUtil;


@Controller
public class Aprj20011Controller extends AprjController {

    @Autowired
    Aprj20011Service serviceAprj20011;

    @Autowired
    Aprj20010Service serviceAprj20010;

    @Autowired
    Aprj20030Service serviceAprj20030;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 프로젝트결과
    
    /**
     * 프로젝트_첨부파일리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20011_40)
    public @ResponseBody Object srchAprj20011List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20011Model param = new Aprj20011Model();
        getParameter(request, param);
        
        if ( StringUtil.isNull(param.getOpId()) ) {
            Aprj20010Model header = new Aprj20010Model();
            getParameter(request, header);

            header = serviceAprj20010.srchAprj20010(header);
            modelAndView.addObject(resultHeader  , header);

            modelAndView.addObject(resultList   , serviceAprj20011.srchAprj20011PrjList(param));
        } else {
            Aprj20030Model header = new Aprj20030Model();
            getParameter(request, header);

        	header = serviceAprj20030.srchAprj20030(header);
            modelAndView.addObject(resultHeader  , header);
            
            modelAndView.addObject(resultList   , serviceAprj20011.srchAprj20011OpList(param));
        }
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20011_40);
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
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20011_41)
    public @ResponseBody Object srchAprj20011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20010Model paramAprj20010 = new Aprj20010Model();
        getParameter(request, paramAprj20010);

        modelAndView.addObject(resultHeader , serviceAprj20010.srchAprj20010(paramAprj20010));
        
        
        Aprj20011Model param = new Aprj20011Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20011.srchAprj20011(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20011_41);
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
    @RequestMapping(ActionConstants_Aprj.ACTION_FILE_DOWNLOAD)
    public @ResponseBody Object srchAprj20011_FILE_DOWNLOAD(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20011Model param = new Aprj20011Model();
        getParameter(request, param);

        Aprj20011Model result = serviceAprj20011.srchAprj20011(param);

        System.out.println(result.getFilePath());
        File filePath = new File(result.getFilePath());
        // 파일 존재 여부 확인.
        if ( !filePath.exists() || !filePath.canRead() ) {
        	AprjMessage.setMsg(modelAndView, "info.common.search.empty");
            modelAndView = (ModelAndView) srchAprj20011List(request);
            return returnResponse(modelAndView);
        }
        
        
        //Download Count값 증가
        serviceAprj20011.updateAprj20011(result);
        
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("fileSerNum", result.getFileSerNum());
        map.put("filePath"  , filePath);
        map.put("lgcFileNm" , result.getLgcFileNm ());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    /**
     * 프로젝트_첨부파일저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20011_00)
    public @ResponseBody Object saveAprj20011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20010Model paramAprj20010 = new Aprj20010Model();
        getParameter(request, paramAprj20010);

        modelAndView.addObject(resultHeader , serviceAprj20010.srchAprj20010(paramAprj20010));
        
        
        Aprj20011Model param = new Aprj20011Model();
        getParameter(request, param);

        // 파일 작업
        MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;
        Iterator<String> fileNameIterator = mpRequest.getFileNames();

		String realUploadPath = ApplicationConstants_Aprj.UPLOAD_DIR_PATH + "/" + param.getCoId() + "/"+ param.getPrjId() + "/";
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
	            
	            serviceAprj20011.insertAprj20011(param);
	        }
			
			AprjMessage.setMsg(modelAndView, "info.common.create.success");
			
		} catch ( Exception e ) {
			AprjMessage.setMsg(modelAndView, "error.common.create.fail");
		}

        modelAndView = (ModelAndView) srchAprj20011List(request);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_첨부파일삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20011_80)
    public @ResponseBody Object deleteAprj20011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj20011Model param = new Aprj20011Model();
        getParameter(request, param);
        
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setFileSerNum(delKeys[i]);

            cnt =+ serviceAprj20011.deleteAprj20011(param);
        }

        modelAndView = (ModelAndView) srchAprj20011List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}