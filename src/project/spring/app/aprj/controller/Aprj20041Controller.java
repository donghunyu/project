/*-------------------------------------------------------------------
* NAME   : Aprj20041Controller
* DESC   : 프로젝트_선택항목
* Author : 
* DATE   : 2018-11-26
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
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20040Service;
import project.spring.app.aprj.service.Aprj20041Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj20041Controller extends AprjController {

    @Autowired
    Aprj20040Service serviceAprj20040;

    @Autowired
    Aprj20041Service serviceAprj20041;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    /**
     * 프로젝트_선택항목리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20041_40)
    public @ResponseBody Object srchAprj20041List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        
        modelAndView.addObject(resultHeader , serviceAprj20040.srchAprj20040(param));
        
        
        modelAndView.addObject(resultList   , serviceAprj20041.srchAprj20041List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20041.srchAprj20041Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20041_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_선택항목조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20041_41)
    public @ResponseBody Object srchAprj20041(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20041.srchAprj20041(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20041_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_선택항목저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20041_00)
    public @ResponseBody Object saveAprj20041(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20041.saveAprj20041(param);

        modelAndView = (ModelAndView) srchAprj20041List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_선택항목삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20041_80)
    public @ResponseBody Object deleteAprj20041(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setItmSerNum(delKeys[i]);

            cnt =+ serviceAprj20041.deleteAprj20041(param);
        }

        modelAndView = (ModelAndView) srchAprj20041List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}