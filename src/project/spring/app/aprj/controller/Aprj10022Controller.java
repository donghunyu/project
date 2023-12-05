/*-------------------------------------------------------------------
* NAME   : Aprj10022Controller
* DESC   : 설정_업무자산구분
* Author : 
* DATE   : 2018-11-07
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
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj10020Model;
import project.spring.app.aprj.service.Aprj10020Service;
import project.spring.app.aprj.service.Aprj10022Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj10022Controller extends AprjController {

    @Autowired
    Aprj10020Service serviceAprj10020;

    @Autowired
    Aprj10022Service serviceAprj10022;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    /**
     * 설정_업무자산구분리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10022_40)
    public @ResponseBody Object srchAprj10022List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);

        modelAndView.addObject(resultHeader, serviceAprj10020.srchAprj10020(param));

        modelAndView.addObject(resultList   , serviceAprj10022.srchAprj10022List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10022.srchAprj10022Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10022_40);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무자산구분조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10022_41)
    public @ResponseBody Object srchAprj10022(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj10022.srchAprj10022(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10022_41);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무자산구분저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10022_00)
    public @ResponseBody Object saveAprj10022(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj10022.saveAprj10022(param);

        modelAndView = (ModelAndView) srchAprj10022List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무자산구분삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10022_80)
    public @ResponseBody Object deleteAprj10022(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);

        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setAstClId (delKeys[i]);

            cnt =+ serviceAprj10022.deleteAprj10022(param);
        }

        modelAndView = (ModelAndView) srchAprj10022List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}