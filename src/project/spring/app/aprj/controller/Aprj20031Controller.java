/*-------------------------------------------------------------------
* NAME   : Aprj20031Controller
* DESC   : 프로젝트_업무통제
* Author : 
* DATE   : 2018-12-17
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20020Service;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.aprj.service.Aprj20031Service;
import project.spring.app.aprj.service.Aprj20032Service;
import project.spring.app.aprj.service.Aprj20033Service;
import project.spring.app.aprj.service.Aprj20034Service;
import project.spring.app.aprj.service.Aprj20038Service;
import project.spring.app.aprj.service.Aprj20039Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.StringUtil;


@Controller
public class Aprj20031Controller extends AprjController {

    @Autowired
    Aprj20020Service serviceAprj20020;

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
    Aprj20038Service serviceAprj20038;
    
    @Autowired
    Aprj20039Service serviceAprj20039;
    
    

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultCnt                      = "resultCnt"                   ;  // 결과수

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    /**
     * 프로젝트_업무통제리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20031_40)
    public @ResponseBody Object srchAprj20031List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        Aprj20030Model header = serviceAprj20030.srchAprj20030(param);

        List<Aprj20030Model> list = serviceAprj20031.srchAprj20031List(header);

        modelAndView.addObject(resultHeader , header);
        modelAndView.addObject(resultList   , list);
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20031_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무통제조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20031_41)
    public @ResponseBody Object srchAprj20031(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultList , serviceAprj20031.srchAprj20031List(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20031_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무통제저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20031_00)
    public @ResponseBody Object saveAprj20031(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        if ( StringUtil.isNull(param.getPrjId()) ) {
        	param.setPrjId(null);
        	param.setPrjNm(null);
        }
        serviceAprj20030.updateAprj20030Prj(param);
        
        
        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        
        serviceAprj20031.deleteAprj20031(param);
        serviceAprj20033.deleteAprj20033(param);
        serviceAprj20034.deleteAprj20034(param);
        serviceAprj20038.deleteAprj20038(param);
        serviceAprj20039.deleteAprj20039(param);

        if ( delKeys != null ) {
	        for ( int i = 0; i < delKeys.length; i++ ) {
	            param.setCtrlNum(delKeys[i]);
	
	            cnt =+ serviceAprj20031.saveAprj20031(param);
	
	            serviceAprj20033.selectInsertAprj20033(param);
	            serviceAprj20034.selectInsertAprj20034(param);
	            serviceAprj20038.selectInsertAprj20038(param);
	            serviceAprj20039.selectInsertAprj20039(param);
	        }
        }
        
        modelAndView = (ModelAndView) srchAprj20031List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무통제삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20031_80)
    public @ResponseBody Object deleteAprj20031(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj20030Model param = new Aprj20030Model();
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setPrjId(delKeys[i]);
            param.setCtrlNum(delKeys[i]);

            cnt =+ serviceAprj20031.deleteAprj20031(param);
        }

        modelAndView = (ModelAndView) srchAprj20031List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}