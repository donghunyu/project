/*-------------------------------------------------------------------
* NAME   : Bacr20030Controller
* DESC   : 대회_참가그룹
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
import project.spring.app.bacr.service.Bacr20030Service;
import project.spring.app.bacr.model.Bacr20030Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Bacr20030Controller extends BacrController {

    @Autowired
    Bacr20030Service serviceBacr20030;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String cptClCdList                    = "cptClCdList"                 ;  // 참가 구분 코드리스트          
    /**
     * 대회_참가그룹리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20030_40)
    public @ResponseBody Object srchBacr20030List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Bacr20030Model param = new Bacr20030Model();
        getParameter(request, param);

        // 참가 구분 코드
        modelAndView.addObject(cptClCdList                   , getGrpCdList(GrpCdConstants_Bacr.CPT_CL_CD                     ));

        modelAndView.addObject(resultList   , serviceBacr20030.srchBacr20030List(param));
        modelAndView.addObject(resultListCnt, serviceBacr20030.srchBacr20030Cnt (param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20030_40);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_참가그룹조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20030_41)
    public @ResponseBody Object srchBacr20030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20030Model param = new Bacr20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceBacr20030.srchBacr20030(param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20030_41);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_참가그룹저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20030_00)
    public @ResponseBody Object saveBacr20030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20030Model param = new Bacr20030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceBacr20030.saveBacr20030(param);

        modelAndView = (ModelAndView) srchBacr20030List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_참가그룹삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20030_80)
    public @ResponseBody Object deleteBacr20030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Bacr20030Model param = new Bacr20030Model();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceBacr20030.deleteBacr20030(param);
        }

        modelAndView = (ModelAndView) srchBacr20030List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}