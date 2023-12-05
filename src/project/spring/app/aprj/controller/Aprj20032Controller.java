/*-------------------------------------------------------------------
* NAME   : Aprj20032Controller
* DESC   : 프로젝트_결제라인
* Author : 
* DATE   : 2018-12-06
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
import project.spring.app.aprj.constants.GrpCdConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.aprj.service.Aprj20032Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj20032Controller extends AprjController {

    @Autowired
    Aprj20030Service serviceAprj20030;

    @Autowired
    Aprj20032Service serviceAprj20032;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더

    private String stmClCdList                    = "stmClCdList"                 ;  // 결제 구분 코드리스트          
    private String stmAuthCdList                  = "stmAuthCdList"               ;  // 결제 권한 코드리스트          
    /**
     * 프로젝트_결제라인리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20032_40)
    public @ResponseBody Object srchAprj20032List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 결제 구분 코드
        modelAndView.addObject(stmClCdList                   , getGrpCdList(GrpCdConstants_Aprj.STM_CL_CD                     ));

        // 결제 권한 코드
        modelAndView.addObject(stmAuthCdList                 , getGrpCdList(GrpCdConstants_Aprj.STM_AUTH_CD                   ));

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));

        modelAndView.addObject(resultList   , serviceAprj20032.srchAprj20032List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20032.srchAprj20032Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20032_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_결제라인조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20032_41)
    public @ResponseBody Object srchAprj20032(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 결제 구분 코드
        modelAndView.addObject(stmClCdList                   , getGrpCdList(GrpCdConstants_Aprj.STM_CL_CD                     ));

        // 결제 권한 코드
        modelAndView.addObject(stmAuthCdList                 , getGrpCdList(GrpCdConstants_Aprj.STM_AUTH_CD                   ));

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20032.srchAprj20032(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20032_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_결제라인저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20032_00)
    public @ResponseBody Object saveAprj20032(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20032.saveAprj20032(param);

        modelAndView = (ModelAndView) srchAprj20032List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_결제라인저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20032_01)
    public @ResponseBody Object saveAprj20032Pool(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20032.insertAprj20032Pool(param);

        modelAndView.addObject(resultCnt    , cnt);
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10030_90);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_결제라인삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20032_80)
    public @ResponseBody Object deleteAprj20032(HttpServletRequest request) throws CommonException {
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
            param.setStmSerNum (delKeys[i]);

            cnt =+ serviceAprj20032.deleteAprj20032(param);
        }

        modelAndView = (ModelAndView) srchAprj20032List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}