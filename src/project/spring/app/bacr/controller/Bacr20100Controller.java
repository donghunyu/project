/*-------------------------------------------------------------------
* NAME   : Bacr20100Controller
* DESC   : 대회_점수
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
import project.spring.app.bacr.service.Bacr20100Service;
import project.spring.app.bacr.model.Bacr20100Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Bacr20100Controller extends BacrController {

    @Autowired
    Bacr20100Service serviceBacr20100;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String cptClCdList                    = "cptClCdList"                 ;  // 참가 구분 코드리스트          
    /**
     * 대회_점수리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20100_40)
    public @ResponseBody Object srchBacr20100List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Bacr20100Model param = new Bacr20100Model();
        getParameter(request, param);

        // 참가 구분 코드
        modelAndView.addObject(cptClCdList                   , getGrpCdList(GrpCdConstants_Bacr.CPT_CL_CD                     ));

        modelAndView.addObject(resultList   , serviceBacr20100.srchBacr20100List(param));
        modelAndView.addObject(resultListCnt, serviceBacr20100.srchBacr20100Cnt (param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20100_40);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_점수조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20100_41)
    public @ResponseBody Object srchBacr20100(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20100Model param = new Bacr20100Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceBacr20100.srchBacr20100(param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20100_41);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_점수저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20100_00)
    public @ResponseBody Object saveBacr20100(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20100Model param = new Bacr20100Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceBacr20100.saveBacr20100(param);

        modelAndView = (ModelAndView) srchBacr20100List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_점수삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20100_80)
    public @ResponseBody Object deleteBacr20100(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Bacr20100Model param = new Bacr20100Model();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceBacr20100.deleteBacr20100(param);
        }

        modelAndView = (ModelAndView) srchBacr20100List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}