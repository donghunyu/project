/*-------------------------------------------------------------------
* NAME   : Aprj20010Controller
* DESC   : 프로젝트_프로젝트
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
import project.spring.app.aprj.model.Aprj20020Model;
import project.spring.app.aprj.service.Aprj20010Service;
import project.spring.app.aprj.service.Aprj20011Service;
import project.spring.app.aprj.service.Aprj20020Service;
import project.spring.app.aprj.service.Aprj20021Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.FileUpload;
import project.spring.app.zcom.lib.util.FileUtil;

  
@Controller
public class Aprj20010Controller extends AprjController {

    @Autowired
    Aprj20010Service serviceAprj20010;

    @Autowired
    Aprj20011Service serviceAprj20011;

    @Autowired
    Aprj20020Service serviceAprj20020;

    @Autowired
    Aprj20021Service serviceAprj20021;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 프로젝트_프로젝트리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20010_40)
    public @ResponseBody Object srchAprj20010List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj20010Model param = new Aprj20010Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj20010.srchAprj20010List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20010.srchAprj20010Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20010_40);
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
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20010_70)
    public @ResponseBody Object srchAprj20020ExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20020Model param = new Aprj20020Model();
        getParameter(request, param);
        param.setPageRowCnt("999999999");
        
        List<Aprj20020Model> list = serviceAprj20020.srchAprj20020ExcelList(param);
        
        
		String realUploadPath = ApplicationConstants_Aprj.DOWNLOAD_EXCEL_PATH + "/" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD) + "/";
		FileUtil.mkdir(realUploadPath);
        
        String fileName = "프로젝트통제_" + DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
        File file = FileUtil.getSerNumFile(realUploadPath + fileName, "xlsx");


        LinkedHashMap<String, String> titleMap  = new LinkedHashMap<String, String>();
        titleMap.put("coId        ".trim(), "업체 ID                        ".trim());
        titleMap.put("coNm        ".trim(), "업체 명                        ".trim());
        titleMap.put("prjId       ".trim(), "프로젝트 ID                    ".trim());
        titleMap.put("prjNm       ".trim(), "프로젝트 명                    ".trim());
        titleMap.put("prjCtt      ".trim(), "프로젝트 내용                  ".trim());

        titleMap.put("ctrlNum     ".trim(), "통제 번호                      ".trim());
        titleMap.put("ctrlNm      ".trim(), "통제 명                        ".trim());
        titleMap.put("ctrlCtt     ".trim(), "통제 내용                      ".trim());
        
        titleMap.put("astClId     ".trim(), "자산구분 ID(복수 ID 등록은 쉼표로 구분)".trim());

       
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
        List<Aprj20020Model> tempList;
        Aprj20020Model temp;
	    
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
	                	tempList = serviceAprj20021.srchAprj20021List(param);
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
     * 프로젝트_프로젝트리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    //@RequestMapping(ActionConstants_Aprj.ACTION_APRJ20010_70)
    public @ResponseBody Object srchAprj20010ExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20010Model param = new Aprj20010Model();
        getParameter(request, param);

        File file = serviceAprj20010.srchAprj20010ExcelList(param);
       
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }

    
    /**
     * 프로젝트_프로젝트리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20010_90)
    public @ResponseBody Object srchAprj20010PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20010Model param = new Aprj20010Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj20010.srchAprj20010List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20010.srchAprj20010Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20010_90);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_프로젝트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20010_41)
    public @ResponseBody Object srchAprj20010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20010Model param = new Aprj20010Model();
        getParameter(request, param);
        setDate  (request, modelAndView, param);

        modelAndView.addObject(resultObject , serviceAprj20010.srchAprj20010(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20010_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_프로젝트저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20010_00)
    public @ResponseBody Object saveAprj20010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20010Model param = new Aprj20010Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20010.saveAprj20010(param);

        
        
        
        // 첨부파일
        MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;
        Iterator<String> fileNameIterator = mpRequest.getFileNames();

		String realUploadPath = ApplicationConstants_Aprj.UPLOAD_DIR_PATH + "/" + param.getPrjId() + "/";
		FileUtil.mkdir(realUploadPath);
    	
        Aprj20011Model paramAprj20011 = new Aprj20011Model();
        paramAprj20011.setPrjId(param.getPrjId());
        getParameter(request, paramAprj20011);
		try {
			while (fileNameIterator.hasNext()) {
	            MultipartFile multiFile = mpRequest.getFile(fileNameIterator.next());
	
	            if (multiFile.getSize() < 0) {
	                throw new Exception();
	            }
	            
                String fileName = FileUpload.uploadFormFile(multiFile, realUploadPath);
                paramAprj20011.setPscFileNm (fileName);
                paramAprj20011.setLgcFileNm (multiFile.getOriginalFilename());
                paramAprj20011.setFilePath  (realUploadPath + fileName);
                paramAprj20011.setFileSize  (multiFile.getSize() + "");
                paramAprj20011.setDloadCnt  ("0");
	            
	            serviceAprj20011.insertAprj20011(paramAprj20011);
	        }
			
			AprjMessage.setMsg(modelAndView, "info.common.create.success");
			
		} catch ( Exception e ) {
			AprjMessage.setMsg(modelAndView, "error.common.create.fail");
		}
        
        
        
        modelAndView = (ModelAndView) srchAprj20010List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_프로젝트삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20010_80)
    public @ResponseBody Object deleteAprj20010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj20010Model param  = new Aprj20010Model();
        Aprj20020Model param2 = new Aprj20020Model();
        
        String[] temp = new String[2];
        for ( int i = 0; i < delKeys.length; i++ ) {
        	temp = delKeys[i].split("_");
        	
            param.setCoId (temp[0]);
            param.setPrjId(temp[1]);

            param2.setCoId (temp[0]);
            param2.setPrjId(temp[1]);

            cnt =+ serviceAprj20010.deleteAprj20010(param );
            cnt =+ serviceAprj20020.deleteAprj20020(param2);
            cnt =+ serviceAprj20021.deleteAprj20021(param2);
        }

        modelAndView = (ModelAndView) srchAprj20010List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
       return returnResponse(modelAndView);
    }
}