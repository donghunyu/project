/*-------------------------------------------------------------------
* NAME   : Aprj20020Controller
* DESC   : 프로젝트_통제
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
import project.spring.app.aprj.model.Aprj20010Model;
import project.spring.app.aprj.model.Aprj20020Model;
import project.spring.app.aprj.service.Aprj20010Service;
import project.spring.app.aprj.service.Aprj20020Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj20020Controller extends AprjController {

    @Autowired
    Aprj20010Service serviceAprj20010;

    @Autowired
    Aprj20020Service serviceAprj20020;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    /**
     * 프로젝트_통제리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20020_40)
    public @ResponseBody Object srchAprj20020List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 프로젝트
        Aprj20010Model paramAprj20010 = new Aprj20010Model();
        getParameter(request, paramAprj20010);
        modelAndView.addObject(resultHeader, serviceAprj20010.srchAprj20010(paramAprj20010));
        
        // 통제
        Aprj20020Model param = new Aprj20020Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj20020.srchAprj20020List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20020.srchAprj20020Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20020_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_통제조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20020_41)
    public @ResponseBody Object srchAprj20020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20020Model param = new Aprj20020Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20020.srchAprj20020(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20020_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_통제리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20020_90)
    public @ResponseBody Object srchAprj20020PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 통제
        Aprj20020Model param = new Aprj20020Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj20020.srchAprj20020List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20020.srchAprj20020Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20020_90);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_통제저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20020_00)
    public @ResponseBody Object saveAprj20020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20020Model param = new Aprj20020Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20020.saveAprj20020(param);

        modelAndView = (ModelAndView) srchAprj20020List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_통제삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20020_80)
    public @ResponseBody Object deleteAprj20020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj20020Model param = new Aprj20020Model();
        getParameter(request, param);
        
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setCtrlNum(delKeys[i]);

            cnt =+ serviceAprj20020.deleteAprj20020(param);
        }

        modelAndView = (ModelAndView) srchAprj20020List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
       return returnResponse(modelAndView);
    }
}