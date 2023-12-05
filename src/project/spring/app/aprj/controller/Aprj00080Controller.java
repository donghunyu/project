/*-------------------------------------------------------------------
* NAME   : Aprj00080Controller
* DESC   : 공통_데이터 복사
* DATE   : 2013-11-21
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/
package project.spring.app.aprj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj20010Model;
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
import project.spring.app.aprj.service.Aprj20051Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.model.Zcom99030Model;
import project.spring.app.zcom.service.Zcom99030Service;
import project.spring.app.zcom.service.Zcom99031Service;
import project.spring.app.zcom.service.Zcom99032Service;

@Controller
public class Aprj00080Controller extends AprjController {

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


    
    private String resultHeader                   = "resultHeader"                ;  // 리스트결과
    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultCnt                      = "resultCnt"                   ;  // 결과수

    
    /**
     * 공통_데이터 복사
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return returnResponse(modelAndView) ModelAndView객체
     * @CommonException CommonException 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_COPY_DATA)
    public @ResponseBody Object srchAprj00080CopyList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Zcom99030Model model = new Zcom99030Model();
        getParameter(request, model);
        
        modelAndView.addObject(resultHeader , serviceZcom99030.srchZcom99030(model));
        
        
        
        Aprj20010Model param = new Aprj20010Model();
        getParameter(request, param);
        
        param.setSrchCoId  ("0000000000");
        param.setPageRowCnt("99999");
        
        modelAndView.addObject(resultList   , serviceAprj20010.srchAprj20010List(param));
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_COPY_DATA);
        return returnResponse(modelAndView);
    }


    /**
     * 공통_데이터 복사 EXECUTE
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return returnResponse(modelAndView) ModelAndView객체
     * @CommonException CommonException 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_COPY_EXECUTE)
    public @ResponseBody Object srchAprj00080CopyExecute(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자ID 오류
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }
        
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        String[] delKeys = request.getParameterValues("delKey");

        int cnt = 0;
        
        // 설정
        cnt =+ serviceAprj10010.deleteAprj10010Co(param);
        cnt =+ serviceAprj10012.deleteAprj10012Co(param);
        cnt =+ serviceAprj10020.deleteAprj10020Co(param);
        cnt =+ serviceAprj10022.deleteAprj10022Co(param);
        cnt =+ serviceAprj10030.deleteAprj10030Co(param);
        cnt =+ serviceAprj10031.deleteAprj10031Co(param);
        cnt =+ serviceAprj10040.deleteAprj10040Co(param);
        
        cnt =+ serviceAprj10010.insertAprj10010Co(param);
        cnt =+ serviceAprj10012.insertAprj10012Co(param);
        cnt =+ serviceAprj10020.insertAprj10020Co(param);
        cnt =+ serviceAprj10022.insertAprj10022Co(param);
        cnt =+ serviceAprj10030.insertAprj10030Co(param);
        cnt =+ serviceAprj10031.insertAprj10031Co(param);
        cnt =+ serviceAprj10040.insertAprj10040Co(param);


        
        
        cnt =+ serviceAprj20010.deleteAprj20010Co(param);
        cnt =+ serviceAprj20020.deleteAprj20020Co(param);
        cnt =+ serviceAprj20021.deleteAprj20021Co(param);
                
        cnt =+ serviceAprj20030.deleteAprj20030Co(param);
        cnt =+ serviceAprj20031.deleteAprj20031Co(param);
        cnt =+ serviceAprj20032.deleteAprj20032Co(param);
        cnt =+ serviceAprj20033.deleteAprj20033Co(param);
        cnt =+ serviceAprj20034.deleteAprj20034Co(param);
        cnt =+ serviceAprj20035.deleteAprj20035Co(param);
        cnt =+ serviceAprj20036.deleteAprj20036Co(param);
        cnt =+ serviceAprj20038.deleteAprj20038Co(param);
        cnt =+ serviceAprj20039.deleteAprj20039Co(param);
        cnt =+ serviceAprj20040.deleteAprj20040Co(param);
        cnt =+ serviceAprj20041.deleteAprj20041Co(param);
        cnt =+ serviceAprj20051.deleteAprj20051Co(param);
        
        String toDay = DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);

        for ( int i = 0; i < delKeys.length; i++ ) {

        	param.setPrjId(delKeys[i]);

            cnt =+ serviceAprj20010.insertAprj20010Co(param);
            cnt =+ serviceAprj20020.insertAprj20020Co(param);
            cnt =+ serviceAprj20021.insertAprj20021Co(param);

    		// 신규 버전
    		param.setStdDt   (toDay);
    		param.setTranStCd("1000");
    		param.setTranDt  (toDay);
            
            cnt =+ serviceAprj20030.insertAprj20030Co(param);
            cnt =+ serviceAprj20031.insertAprj20031Co(param);
            cnt =+ serviceAprj20032.insertAprj20032Co(param);
            cnt =+ serviceAprj20033.insertAprj20033Co(param);
//            cnt =+ serviceAprj20034.insertAprj20034Co(param);
//            cnt =+ serviceAprj20035.insertAprj20035Co(param);
//            cnt =+ serviceAprj20036.insertAprj20036Co(param);
            cnt =+ serviceAprj20038.insertAprj20038Co(param);
//            cnt =+ serviceAprj20039.insertAprj20039Co(param);
            cnt =+ serviceAprj20040.insertAprj20040Co(param);
            cnt =+ serviceAprj20041.insertAprj20041Co(param);
        }
        
        modelAndView = (ModelAndView) srchAprj00080CopyList(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }
    
    /**
     * 공통_데이터 복사 EXECUTE
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return returnResponse(modelAndView) ModelAndView객체
     * @CommonException CommonException 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_DEL_CO_DATA)
    public @ResponseBody Object srchAprj00080Del(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자ID 오류
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }
        
        AprjModel param = new AprjModel();
        getParameter(request, param);
        
        String[] delKeys = request.getParameterValues("delKey");

        for ( int i = 0; i < delKeys.length; i++ ) {

        	switch (delKeys[i]) {
        		// 자산구분
        		case "10010010" : 
        	        serviceAprj10010.deleteAprj10010Co(param);
        	        serviceAprj10011.deleteAprj10011Co(param);
        		break;
        		
        		// 자산
        		case "10010012" : 
        	        serviceAprj10012.deleteAprj10012Co(param);
        		break;
        		
        		// 프로젝트
        		case "10020010" : 
        	        serviceAprj20010.deleteAprj20010Co(param);
        	        serviceAprj20020.deleteAprj20020Co(param);
        	        serviceAprj20021.deleteAprj20021Co(param);
        		break;
        		
        		// 업무담당
        		case "10030010" : 
        	        serviceAprj10020.deleteAprj10020Co(param);
        	        serviceAprj10021.deleteAprj10021Co(param);
        	        serviceAprj10022.deleteAprj10022Co(param);
        		break;
        		
        		// 업무주기
        		case "10040010" : 
        	        serviceAprj10040.deleteAprj10040Co(param);
        		break;
        		
        		// 결제라인
        		case "10050010" : 
        	        serviceAprj10030.deleteAprj10030Co(param);
        	        serviceAprj10031.deleteAprj10031Co(param);
        		break;
        		
        		// 업무
        		case "20031010" : 
        	        serviceAprj20030.deleteAprj20030Co(param);
        	        serviceAprj20031.deleteAprj20031Co(param);
        	        serviceAprj20032.deleteAprj20032Co(param);
        	        serviceAprj20033.deleteAprj20033Co(param);
        	        serviceAprj20034.deleteAprj20034Co(param);
        	        serviceAprj20035.deleteAprj20035Co(param);
        	        serviceAprj20038.deleteAprj20038Co(param);
        	        serviceAprj20039.deleteAprj20039Co(param);
        	        
        	        serviceAprj20040.deleteAprj20040Co(param);
        	        serviceAprj20041.deleteAprj20041Co(param);
        	        serviceAprj20051.deleteAprj20051Co(param);
        		break;
        		
        		// 부서
        		case "20040010" : 
        	        serviceZcom99031.deleteZcom99031Co(param);
        	        serviceZcom99032.deleteZcom99032Co(param);
        		break;
        		
        		// 사용자
        		case "20050010" : 
        	        serviceZcom99030.deleteZcom99030Co(param);
        		break;
        		
        	}
        }
        
        modelAndView = (ModelAndView) srchAprj00080CopyList(request);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
    
}