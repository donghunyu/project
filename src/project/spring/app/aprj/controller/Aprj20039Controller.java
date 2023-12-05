/*-------------------------------------------------------------------
* NAME   : Aprj20039Controller
* DESC   : 프로젝트_업무자산
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
import project.spring.app.aprj.model.Aprj10020Model;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj10021Service;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.aprj.service.Aprj20039Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj20039Controller extends AprjController {

    @Autowired
    Aprj20030Service serviceAprj20030;

    @Autowired
    Aprj20039Service serviceAprj20039;

    @Autowired
    Aprj10021Service serviceAprj10021;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    private String resultStmList                  = "resultStmList"               ;  // 리스트결과
    /**
     * 프로젝트_업무자산리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20039_40)
    public @ResponseBody Object srchAprj20039List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));

        modelAndView.addObject(resultList   , serviceAprj20039.srchAprj20039List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20039.srchAprj20039Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20039_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무자산조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20039_41)
    public @ResponseBody Object srchAprj20039(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20039.srchAprj20039(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20039_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무자산리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20039_50)
    public @ResponseBody Object srchAprj20039GroupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));

        modelAndView.addObject(resultList   , serviceAprj20039.srchAprj20039GroupList(param));
        modelAndView.addObject(resultListCnt, serviceAprj20039.srchAprj20039GroupCnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20039_50);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무자산리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20039_90)
    public @ResponseBody Object srchAprj20039PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));

        modelAndView.addObject(resultList   , serviceAprj20039.srchAprj20039GroupList(param));
        modelAndView.addObject(resultListCnt, serviceAprj20039.srchAprj20039GroupCnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20039_90);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무자산리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20039_91)
    public @ResponseBody Object srchAprj20039AstList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));

        modelAndView.addObject(resultList   , serviceAprj20039.srchAprj20039GroupList(param));
        modelAndView.addObject(resultListCnt, serviceAprj20039.srchAprj20039GroupCnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20039_91);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무자산리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20039_92)
    public @ResponseBody Object srchAprj20039StmList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);
        
        modelAndView.addObject(resultStmList, serviceAprj10021.srchAprj10021StmList(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20039_92);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무자산저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20039_00)
    public @ResponseBody Object saveAprj20039(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20039.saveAprj20039(param);

        modelAndView = (ModelAndView) srchAprj20039List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_업무자산삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20039_80)
    public @ResponseBody Object deleteAprj20039(HttpServletRequest request) throws CommonException {
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
            param.setAstId(delKeys[i]);

            cnt =+ serviceAprj20039.deleteAprj20039(param);
        }

        modelAndView = (ModelAndView) srchAprj20039List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}