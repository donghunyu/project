/*-------------------------------------------------------------------
* NAME   : Aprj20021Controller
* DESC   : 프로젝트_통제자산
* Author : 
* DATE   : 2018-10-31
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
import project.spring.app.aprj.model.Aprj20020Model;
import project.spring.app.aprj.service.Aprj20020Service;
import project.spring.app.aprj.service.Aprj20021Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj20021Controller extends AprjController {

    @Autowired
    Aprj20020Service serviceAprj20020;

    @Autowired
    Aprj20021Service serviceAprj20021;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
   /**
     * 프로젝트_통제자산리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20021_40)
    public @ResponseBody Object srchAprj20021List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20020Model param = new Aprj20020Model();
        getParameter(request, param);

        modelAndView.addObject(resultHeader , serviceAprj20020.srchAprj20020(param));
        
        modelAndView.addObject(resultList   , serviceAprj20021.srchAprj20021List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20021.srchAprj20021Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20021_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_통제자산조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20021_41)
    public @ResponseBody Object srchAprj20021(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20020Model param = new Aprj20020Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20021.srchAprj20021(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20021_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_통제자산저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20021_00)
    public @ResponseBody Object saveAprj20021(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20020Model param = new Aprj20020Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20021.saveAprj20021(param);

        modelAndView = (ModelAndView) srchAprj20021List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_통제자산삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20021_80)
    public @ResponseBody Object deleteAprj20021(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj20020Model param = new Aprj20020Model();
        getParameter(request, param);
        
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setAstClId(delKeys[i]);

            cnt =+ serviceAprj20021.deleteAprj20021(param);
        }

        modelAndView = (ModelAndView) srchAprj20021List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}