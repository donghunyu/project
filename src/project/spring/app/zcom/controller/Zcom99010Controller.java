/*-------------------------------------------------------------------
* NAME   : Zcom99010Controller
* DESC   : 관리자_그룹코드
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
import project.spring.app.zcom.model.Zcom99010Model;
import project.spring.app.zcom.service.Zcom99010Service;
import project.spring.app.zcom.service.Zcom99011Service;


@Controller
public class Zcom99010Controller extends ZcomController {

    @Autowired
    Zcom99010Service serviceZcom99010;

    @Autowired
    Zcom99011Service serviceZcom99011;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 관리자_그룹코드리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99010_40)
    public @ResponseBody Object srchZcom99010List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Zcom99010Model param = new Zcom99010Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceZcom99010.srchZcom99010List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99010.srchZcom99010Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99010_40);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_그룹코드조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99010_41)
    public @ResponseBody Object srchZcom99010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99010Model param = new Zcom99010Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceZcom99010.srchZcom99010(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99010_41);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_그룹코드저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99010_00)
    public @ResponseBody Object saveZcom99010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99010Model param = new Zcom99010Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceZcom99010.saveZcom99010(param);

        modelAndView = (ModelAndView) srchZcom99010List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_그룹코드삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99010_80)
    public @ResponseBody Object deleteZcom99010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Zcom99010Model param = new Zcom99010Model();
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setGrpCd(delKeys[i]);

            cnt =+ serviceZcom99010.deleteZcom99010(param);
            cnt =+ serviceZcom99011.deleteZcom99011(param);
        }

        modelAndView = (ModelAndView) srchZcom99010List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}