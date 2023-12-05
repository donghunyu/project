/*-------------------------------------------------------------------
* NAME   : Zcom99020Controller
* DESC   : 관리자_메뉴
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
import project.spring.app.zcom.model.Zcom99020Model;
import project.spring.app.zcom.service.Zcom99020Service;


@Controller
public class Zcom99020Controller extends ZcomController {

    @Autowired
    Zcom99020Service serviceZcom99020;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String ynCdList                       = "ynCdList"                    ;  // 여부 코드리스트        
    /**
     * 관리자_메뉴리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99020_40)
    public @ResponseBody Object srchZcom99020List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        // 여부 코드
        modelAndView.addObject(ynCdList                , getGrpCdList(GrpCdConstants_Aprj.YN_CD                 ));
        
        Zcom99020Model param = new Zcom99020Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceZcom99020.srchZcom99020List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99020.srchZcom99020Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99020_40);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_메뉴조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99020_41)
    public @ResponseBody Object srchZcom99020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 여부 코드
        modelAndView.addObject(ynCdList                , getGrpCdList(GrpCdConstants_Aprj.YN_CD                 ));
        
        Zcom99020Model param = new Zcom99020Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceZcom99020.srchZcom99020(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99020_41);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_메뉴저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99020_00)
    public @ResponseBody Object saveZcom99020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99020Model param = new Zcom99020Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceZcom99020.saveZcom99020(param);

        modelAndView = (ModelAndView) srchZcom99020List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_메뉴삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99020_80)
    public @ResponseBody Object deleteZcom99020(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Zcom99020Model param = new Zcom99020Model();
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setMenuId(delKeys[i]);

            cnt =+ serviceZcom99020.deleteZcom99020(param);
        }

        modelAndView = (ModelAndView) srchZcom99020List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}