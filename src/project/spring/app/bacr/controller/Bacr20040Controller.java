/*-------------------------------------------------------------------
* NAME   : Bacr20040Controller
* DESC   : 대회_참가자
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
import project.spring.app.bacr.service.Bacr20040Service;
import project.spring.app.bacr.model.Bacr20040Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Bacr20040Controller extends BacrController {

    @Autowired
    Bacr20040Service serviceBacr20040;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String cptClCdList                    = "cptClCdList"                 ;  // 참가 구분 코드리스트          
    /**
     * 대회_참가자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20040_40)
    public @ResponseBody Object srchBacr20040List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Bacr20040Model param = new Bacr20040Model();
        getParameter(request, param);

        // 참가 구분 코드
        modelAndView.addObject(cptClCdList                   , getGrpCdList(GrpCdConstants_Bacr.CPT_CL_CD                     ));

        modelAndView.addObject(resultList   , serviceBacr20040.srchBacr20040List(param));
        modelAndView.addObject(resultListCnt, serviceBacr20040.srchBacr20040Cnt (param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20040_40);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_참가자조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20040_41)
    public @ResponseBody Object srchBacr20040(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20040Model param = new Bacr20040Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceBacr20040.srchBacr20040(param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20040_41);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_참가자저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20040_00)
    public @ResponseBody Object saveBacr20040(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20040Model param = new Bacr20040Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceBacr20040.saveBacr20040(param);

        modelAndView = (ModelAndView) srchBacr20040List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_참가자삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20040_80)
    public @ResponseBody Object deleteBacr20040(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Bacr20040Model param = new Bacr20040Model();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceBacr20040.deleteBacr20040(param);
        }

        modelAndView = (ModelAndView) srchBacr20040List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}