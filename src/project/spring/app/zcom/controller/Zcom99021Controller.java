/*-------------------------------------------------------------------
* NAME   : Zcom99021Controller
* DESC   : 관리자_메뉴권한
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
import project.spring.app.aprj.constants.GrpCdConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.object.ZcomController;
import project.spring.app.zcom.model.Zcom99021Model;
import project.spring.app.zcom.service.Zcom99021Service;


@Controller
public class Zcom99021Controller extends ZcomController {

    @Autowired
    Zcom99021Service serviceZcom99021;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String menuAuthCdList                 = "menuAuthCdList"              ;  // 메뉴 권한 코드리스트          
    private String userAuthCdList                 = "userAuthCdList"              ;  // 사용자 권한 코드리스트        
    /**
     * 관리자_메뉴권한리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99021_40)
    public @ResponseBody Object srchZcom99021List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        // 메뉴 권한 코드
        modelAndView.addObject(menuAuthCdList                , getGrpCdList(GrpCdConstants_Aprj.MENU_AUTH_CD                  ));

        // 사용자 권한 코드
        modelAndView.addObject(userAuthCdList                , getGrpCdList(GrpCdConstants_Aprj.USER_AUTH_CD                  ));

        Zcom99021Model param = new Zcom99021Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceZcom99021.srchZcom99021List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99021.srchZcom99021Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99021_40);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_메뉴권한조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99021_41)
    public @ResponseBody Object srchZcom99021(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 메뉴 권한 코드
        modelAndView.addObject(menuAuthCdList                , getGrpCdList(GrpCdConstants_Aprj.MENU_AUTH_CD                  ));

        // 사용자 권한 코드
        modelAndView.addObject(userAuthCdList                , getGrpCdList(GrpCdConstants_Aprj.USER_AUTH_CD                  ));

        Zcom99021Model param = new Zcom99021Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceZcom99021.srchZcom99021(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99021_41);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_메뉴권한저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99021_00)
    public @ResponseBody Object saveZcom99021(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99021Model param = new Zcom99021Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceZcom99021.saveZcom99021(param);

        modelAndView = (ModelAndView) srchZcom99021List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_메뉴권한삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99021_80)
    public @ResponseBody Object deleteZcom99021(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Zcom99021Model param = new Zcom99021Model();
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setSerNum(delKeys[i]);

            cnt =+ serviceZcom99021.deleteZcom99021(param);
        }

        modelAndView = (ModelAndView) srchZcom99021List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}