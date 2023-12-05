/*-------------------------------------------------------------------
* NAME   : Bacr20010Controller
* DESC   : 대회_대회
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
import project.spring.app.bacr.service.Bacr20010Service;
import project.spring.app.bacr.model.Bacr20010Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Bacr20010Controller extends BacrController {

    @Autowired
    Bacr20010Service serviceBacr20010;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String tnmtClCdList                   = "tnmtClCdList"                ;  // 대회 구분 코드리스트          
    /**
     * 대회_대회리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20010_40)
    public @ResponseBody Object srchBacr20010List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Bacr20010Model param = new Bacr20010Model();
        getParameter(request, param);

        // 대회 구분 코드
        modelAndView.addObject(tnmtClCdList                  , getGrpCdList(GrpCdConstants_Bacr.TNMT_CL_CD                    ));

        modelAndView.addObject(resultList   , serviceBacr20010.srchBacr20010List(param));
        modelAndView.addObject(resultListCnt, serviceBacr20010.srchBacr20010Cnt (param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20010_40);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_대회조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20010_41)
    public @ResponseBody Object srchBacr20010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20010Model param = new Bacr20010Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceBacr20010.srchBacr20010(param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20010_41);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_대회저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20010_00)
    public @ResponseBody Object saveBacr20010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20010Model param = new Bacr20010Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceBacr20010.saveBacr20010(param);

        modelAndView = (ModelAndView) srchBacr20010List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_대회삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20010_80)
    public @ResponseBody Object deleteBacr20010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Bacr20010Model param = new Bacr20010Model();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceBacr20010.deleteBacr20010(param);
        }

        modelAndView = (ModelAndView) srchBacr20010List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}