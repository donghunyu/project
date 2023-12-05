/*-------------------------------------------------------------------
* NAME   : Bacr10010Controller
* DESC   : 기본정보_정
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
import project.spring.app.bacr.service.Bacr10010Service;
import project.spring.app.bacr.model.Bacr10010Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Bacr10010Controller extends BacrController {

    @Autowired
    Bacr10010Service serviceBacr10010;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String pvlGrpCdList                   = "pvlGrpCdList"                ;  // 정 그룹 코드리스트            
    /**
     * 기본정보_정리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10010_40)
    public @ResponseBody Object srchBacr10010List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Bacr10010Model param = new Bacr10010Model();
        getParameter(request, param);

        // 정 그룹 코드
        modelAndView.addObject(pvlGrpCdList                  , getGrpCdList(GrpCdConstants_Bacr.PVL_GRP_CD                    ));

        modelAndView.addObject(resultList   , serviceBacr10010.srchBacr10010List(param));
        modelAndView.addObject(resultListCnt, serviceBacr10010.srchBacr10010Cnt (param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR10010_40);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보_정조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10010_41)
    public @ResponseBody Object srchBacr10010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr10010Model param = new Bacr10010Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceBacr10010.srchBacr10010(param));

        modelAndView.setViewName(ViewConstants_Bacr.VIEW_BACR10010_41);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보_정저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10010_00)
    public @ResponseBody Object saveBacr10010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Bacr10010Model param = new Bacr10010Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceBacr10010.saveBacr10010(param);

        modelAndView = (ModelAndView) srchBacr10010List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 기본정보_정삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Bacr.ACTION_BACR10010_80)
    public @ResponseBody Object deleteBacr10010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Bacr10010Model param = new Bacr10010Model();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceBacr10010.deleteBacr10010(param);
        }

        modelAndView = (ModelAndView) srchBacr10010List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}