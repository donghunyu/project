/*-------------------------------------------------------------------
* NAME   : Bacr10020Controller
* DESC   : 기본정보 과녁
* Author : 
* DATE   : 2023-02-13
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.bacr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.bacr.lib.object.BacrController;
import project.spring.app.bacr.constants.ActionConstants_Bacr;
import project.spring.app.bacr.constants.ViewConstants_Bacr;
import project.spring.app.bacr.constants.GrpCdConstants_Bacr;
import project.spring.app.bacr.service.Bacr10020Service;
import project.spring.app.bacr.model.Bacr10020Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Bacr10020Controller extends BacrController {

    @Autowired
    Bacr10020Service serviceBacr10020;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 기본정보 과녁리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10020_40)
    public @ResponseBody Object srchBacr10020List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Bacr10020Model param = new Bacr10020Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceBacr10020.srchBacr10020List(param));
        modelAndView.addObject(resultListCnt, serviceBacr10020.srchBacr10020Cnt (param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR10020_40);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보 과녁조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10020_41)
    public @ResponseBody Object srchBacr10020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr10020Model param = new Bacr10020Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceBacr10020.srchBacr10020(param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR10020_41);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보 과녁저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10020_00)
    public @ResponseBody Object saveBacr10020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr10020Model param = new Bacr10020Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceBacr10020.saveBacr10020(param);

        modelAndView = (ModelAndView) srchBacr10020List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보 과녁삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10020_80)
    public @ResponseBody Object deleteBacr10020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Bacr10020Model param = new Bacr10020Model();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceBacr10020.deleteBacr10020(param);
        }

        modelAndView = (ModelAndView) srchBacr10020List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}