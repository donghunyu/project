/*-------------------------------------------------------------------
* NAME   : Bacr10011Controller
* DESC   : 기본정보 그룹
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
import project.spring.app.bacr.service.Bacr10011Service;
import project.spring.app.bacr.model.Bacr10011Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Bacr10011Controller extends BacrController {

    @Autowired
    Bacr10011Service serviceBacr10011;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 기본정보 그룹리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10011_40)
    public @ResponseBody Object srchBacr10011List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Bacr10011Model param = new Bacr10011Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceBacr10011.srchBacr10011List(param));
        modelAndView.addObject(resultListCnt, serviceBacr10011.srchBacr10011Cnt (param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR10011_40);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보 그룹조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10011_41)
    public @ResponseBody Object srchBacr10011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr10011Model param = new Bacr10011Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceBacr10011.srchBacr10011(param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR10011_41);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보 그룹저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10011_00)
    public @ResponseBody Object saveBacr10011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr10011Model param = new Bacr10011Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceBacr10011.saveBacr10011(param);

        modelAndView = (ModelAndView) srchBacr10011List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보 그룹삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10011_80)
    public @ResponseBody Object deleteBacr10011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Bacr10011Model param = new Bacr10011Model();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceBacr10011.deleteBacr10011(param);
        }

        modelAndView = (ModelAndView) srchBacr10011List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}