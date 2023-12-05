/*-------------------------------------------------------------------
* NAME   : Bacr20011Controller
* DESC   : 대회_사대
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
import project.spring.app.bacr.service.Bacr20011Service;
import project.spring.app.bacr.model.Bacr20011Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Bacr20011Controller extends BacrController {

    @Autowired
    Bacr20011Service serviceBacr20011;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String spClCdList                     = "spClCdList"                  ;  // 사대 구분 코드리스트          
    /**
     * 대회_사대리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20011_40)
    public @ResponseBody Object srchBacr20011List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Bacr20011Model param = new Bacr20011Model();
        getParameter(request, param);

        // 사대 구분 코드
        modelAndView.addObject(spClCdList                    , getGrpCdList(GrpCdConstants_Bacr.SP_CL_CD                      ));

        modelAndView.addObject(resultList   , serviceBacr20011.srchBacr20011List(param));
        modelAndView.addObject(resultListCnt, serviceBacr20011.srchBacr20011Cnt (param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20011_40);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_사대조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20011_41)
    public @ResponseBody Object srchBacr20011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20011Model param = new Bacr20011Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceBacr20011.srchBacr20011(param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR20011_41);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_사대저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20011_00)
    public @ResponseBody Object saveBacr20011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr20011Model param = new Bacr20011Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceBacr20011.saveBacr20011(param);

        modelAndView = (ModelAndView) srchBacr20011List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 대회_사대삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR20011_80)
    public @ResponseBody Object deleteBacr20011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Bacr20011Model param = new Bacr20011Model();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceBacr20011.deleteBacr20011(param);
        }

        modelAndView = (ModelAndView) srchBacr20011List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}