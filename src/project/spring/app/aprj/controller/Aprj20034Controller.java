/*-------------------------------------------------------------------
* NAME   : Aprj20034Controller
* DESC   : 프로젝트_업무담당자
* Author : 
* DATE   : 2019-01-15
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.aprj.service.Aprj20034Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj20034Controller extends AprjController {

    @Autowired
    Aprj20030Service serviceAprj20030;

    @Autowired
    Aprj20034Service serviceAprj20034;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더

    /**
     * 프로젝트_업무담당자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20034_40)
    public @ResponseBody Object srchAprj20034List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));

        modelAndView.addObject(resultList   , serviceAprj20034.srchAprj20034List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20034.srchAprj20034Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20034_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무담당자조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20034_41)
    public @ResponseBody Object srchAprj20034(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20034.srchAprj20034(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20034_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무담당자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20034_50)
    public @ResponseBody Object srchAprj20034GroupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));

        modelAndView.addObject(resultList   , serviceAprj20034.srchAprj20034GroupList(param));
        modelAndView.addObject(resultListCnt, serviceAprj20034.srchAprj20034GroupCnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20034_50);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무담당자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20034_90)
    public @ResponseBody Object srchAprj20034PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));

        modelAndView.addObject(resultList   , serviceAprj20034.srchAprj20034GroupList(param));
        modelAndView.addObject(resultListCnt, serviceAprj20034.srchAprj20034GroupCnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20034_90);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무담당자저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20034_00)
    public @ResponseBody Object saveAprj20034(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20034.saveAprj20034(param);

        modelAndView = (ModelAndView) srchAprj20034List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무담당자삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20034_80)
    public @ResponseBody Object deleteAprj20034(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj20030Model param = new Aprj20030Model();
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setCoId(delKeys[i]);
            param.setOpId(delKeys[i]);
            param.setOpSerNum(delKeys[i]);
            param.setPrjId(delKeys[i]);
            param.setCtrlNum(delKeys[i]);
            param.setAstClId(delKeys[i]);
            param.setOpChrgId(delKeys[i]);
            param.setUserId(delKeys[i]);

            cnt =+ serviceAprj20034.deleteAprj20034(param);
        }

        modelAndView = (ModelAndView) srchAprj20034List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}