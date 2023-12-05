/*-------------------------------------------------------------------
* NAME   : Zcom99022Controller
* DESC   : 관리자_사용자메뉴
* Author : 
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.controller;

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
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.object.ZcomController;
import project.spring.app.zcom.model.Zcom99021Model;
import project.spring.app.zcom.model.Zcom99022Model;
import project.spring.app.zcom.service.Zcom99021Service;
import project.spring.app.zcom.service.Zcom99022Service;


@Controller
public class Zcom99022Controller extends ZcomController {

    @Autowired
    Zcom99021Service serviceZcom99021;

    @Autowired
    Zcom99022Service serviceZcom99022;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 관리자_사용자메뉴리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99022_40)
    public @ResponseBody Object srchZcom99022List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99021Model paramZcom99021 = new Zcom99021Model();
        getParameter(request, paramZcom99021);

        modelAndView.addObject(resultObject , serviceZcom99021.srchZcom99021(paramZcom99021));

        Zcom99022Model param = new Zcom99022Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceZcom99022.srchZcom99022List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99022.srchZcom99022Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99022_40);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자메뉴조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99022_41)
    public @ResponseBody Object srchZcom99022(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99022Model param = new Zcom99022Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceZcom99022.srchZcom99022(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99022_41);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자메뉴저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99022_00)
    public @ResponseBody Object saveZcom99022(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99022Model param = new Zcom99022Model();
        getParameter(request, param);

        serviceZcom99022.deleteZcom99022(param);
        
        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setMenuId(delKeys[i]);

            cnt =+ serviceZcom99022.insertZcom99022(param);
        }

        modelAndView = (ModelAndView) srchZcom99022List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자메뉴삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99022_80)
    public @ResponseBody Object deleteZcom99022(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Zcom99022Model param = new Zcom99022Model();
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setSerNum(delKeys[i]);

            cnt =+ serviceZcom99022.deleteZcom99022(param);
        }

        modelAndView = (ModelAndView) srchZcom99022List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}