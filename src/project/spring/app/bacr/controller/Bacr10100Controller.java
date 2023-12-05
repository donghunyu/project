/*-------------------------------------------------------------------
* NAME   : Bacr10100Controller
* DESC   : 기본정보_회원
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
import project.spring.app.bacr.service.Bacr10100Service;
import project.spring.app.bacr.model.Bacr10100Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Bacr10100Controller extends BacrController {

    @Autowired
    Bacr10100Service serviceBacr10100;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String gdCdList                       = "gdCdList"                    ;  // 성별 코드리스트               
    /**
     * 기본정보_회원리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10100_40)
    public @ResponseBody Object srchBacr10100List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Bacr10100Model param = new Bacr10100Model();
        getParameter(request, param);

        // 성별 코드
        modelAndView.addObject(gdCdList                      , getGrpCdList(GrpCdConstants_Bacr.GD_CD                         ));

        modelAndView.addObject(resultList   , serviceBacr10100.srchBacr10100List(param));
        modelAndView.addObject(resultListCnt, serviceBacr10100.srchBacr10100Cnt (param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR10100_40);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보_회원조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10100_41)
    public @ResponseBody Object srchBacr10100(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr10100Model param = new Bacr10100Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceBacr10100.srchBacr10100(param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR10100_41);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보_회원저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10100_00)
    public @ResponseBody Object saveBacr10100(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr10100Model param = new Bacr10100Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceBacr10100.saveBacr10100(param);

        modelAndView = (ModelAndView) srchBacr10100List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보_회원삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10100_80)
    public @ResponseBody Object deleteBacr10100(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Bacr10100Model param = new Bacr10100Model();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceBacr10100.deleteBacr10100(param);
        }

        modelAndView = (ModelAndView) srchBacr10100List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}