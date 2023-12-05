/*-------------------------------------------------------------------
* NAME   : Zcom99031Controller
* DESC   : 관리자_업체
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
import project.spring.app.zcom.model.Zcom99031Model;
import project.spring.app.zcom.service.Zcom99031Service;


@Controller
public class Zcom99031Controller extends ZcomController {

    @Autowired
    Zcom99031Service serviceZcom99031;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 관리자_업체리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99031_40)
    public @ResponseBody Object srchZcom99031List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Zcom99031Model param = new Zcom99031Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceZcom99031.srchZcom99031List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99031.srchZcom99031Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99031_40);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_업체리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99031_90)
    public @ResponseBody Object srchZcom99031PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99031Model param = new Zcom99031Model();
        getParameter(request, param);

        param.setSrchCoId("");
        param.setSrchCoNm("");
        
        modelAndView.addObject(resultList   , serviceZcom99031.srchZcom99031List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99031.srchZcom99031Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99031_90);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_업체조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99031_41)
    public @ResponseBody Object srchZcom99031(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99031Model param = new Zcom99031Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceZcom99031.srchZcom99031(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99031_41);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_업체저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99031_00)
    public @ResponseBody Object saveZcom99031(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99031Model param = new Zcom99031Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceZcom99031.saveZcom99031(param);

        modelAndView = (ModelAndView) srchZcom99031List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_업체삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99031_80)
    public @ResponseBody Object deleteZcom99031(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Zcom99031Model param = new Zcom99031Model();
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setCoId(delKeys[i]);

            cnt =+ serviceZcom99031.deleteZcom99031(param);
        }

        modelAndView = (ModelAndView) srchZcom99031List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}