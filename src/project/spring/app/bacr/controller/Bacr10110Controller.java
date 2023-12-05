/*-------------------------------------------------------------------
* NAME   : Bacr10110Controller
* DESC   : 기본정보_회원정
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
import project.spring.app.bacr.service.Bacr10110Service;
import project.spring.app.bacr.model.Bacr10110Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Bacr10110Controller extends BacrController {

    @Autowired
    Bacr10110Service serviceBacr10110;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 기본정보_회원정리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10110_40)
    public @ResponseBody Object srchBacr10110List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Bacr10110Model param = new Bacr10110Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceBacr10110.srchBacr10110List(param));
        modelAndView.addObject(resultListCnt, serviceBacr10110.srchBacr10110Cnt (param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR10110_40);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보_회원정조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10110_41)
    public @ResponseBody Object srchBacr10110(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr10110Model param = new Bacr10110Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceBacr10110.srchBacr10110(param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR10110_41);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보_회원정저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10110_00)
    public @ResponseBody Object saveBacr10110(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr10110Model param = new Bacr10110Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceBacr10110.saveBacr10110(param);

        modelAndView = (ModelAndView) srchBacr10110List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보_회원정삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10110_80)
    public @ResponseBody Object deleteBacr10110(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Bacr10110Model param = new Bacr10110Model();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceBacr10110.deleteBacr10110(param);
        }

        modelAndView = (ModelAndView) srchBacr10110List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}