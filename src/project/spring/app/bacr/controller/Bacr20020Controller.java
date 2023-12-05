/*-------------------------------------------------------------------
* NAME   : Bacr20020Controller
* DESC   : 대회_참가구분
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
import project.spring.app.bacr.service.Bacr20020Service;
import project.spring.app.bacr.model.Bacr20020Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Bacr20020Controller extends BacrController {

    @Autowired
    Bacr20020Service serviceBacr20020;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String cptClCdList                    = "cptClCdList"                 ;  // 참가 구분 코드리스트          
    /**
     * 대회_참가구분리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20020_40)
    public @ResponseBody Object srchBacr20020List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Bacr20020Model param = new Bacr20020Model();
        getParameter(request, param);

        // 참가 구분 코드
        modelAndView.addObject(cptClCdList                   , getGrpCdList(GrpCdConstants_Bacr.CPT_CL_CD                     ));

        modelAndView.addObject(resultList   , serviceBacr20020.srchBacr20020List(param));
        modelAndView.addObject(resultListCnt, serviceBacr20020.srchBacr20020Cnt (param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20020_40);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_참가구분조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20020_41)
    public @ResponseBody Object srchBacr20020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20020Model param = new Bacr20020Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceBacr20020.srchBacr20020(param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20020_41);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_참가구분저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20020_00)
    public @ResponseBody Object saveBacr20020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20020Model param = new Bacr20020Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceBacr20020.saveBacr20020(param);

        modelAndView = (ModelAndView) srchBacr20020List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_참가구분삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20020_80)
    public @ResponseBody Object deleteBacr20020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Bacr20020Model param = new Bacr20020Model();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceBacr20020.deleteBacr20020(param);
        }

        modelAndView = (ModelAndView) srchBacr20020List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}