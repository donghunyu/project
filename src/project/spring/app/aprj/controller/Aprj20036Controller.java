/*-------------------------------------------------------------------
* NAME   : Aprj20036Controller
* DESC   : 프로젝트_결제담당자
* Author : 
* DATE   : 2019-01-30
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
import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.aprj.constants.GrpCdConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.aprj.service.Aprj20034Service;
import project.spring.app.aprj.service.Aprj20036Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.StringUtil;


@Controller
public class Aprj20036Controller extends AprjController {

    @Autowired
    Aprj20030Service serviceAprj20030;

    @Autowired
    Aprj20034Service serviceAprj20034;

    @Autowired
    Aprj20036Service serviceAprj20036;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String opChrgUserList                 = "opChrgUserList"              ;  // 결제 구분 코드리스트 
    
    private String stmClCdList                    = "stmClCdList"                 ;  // 결제 구분 코드리스트          
    private String stmAuthCdList                  = "stmAuthCdList"               ;  // 결제 권한 코드리스트          
    private String signClCdList                   = "signClCdList"                ;  // 서명 구분 코드리스트 
    
    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    
    /**
     * 프로젝트_결제담당자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20036_40)
    public @ResponseBody Object srchAprj20036List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        // 결제 구분 코드
        modelAndView.addObject(stmClCdList                   , getGrpCdList(GrpCdConstants_Aprj.STM_CL_CD                     ));

        // 결제 권한 코드
        modelAndView.addObject(stmAuthCdList                 , getGrpCdList(GrpCdConstants_Aprj.STM_AUTH_CD                   ));

        // 서명 구분 코드
        modelAndView.addObject(signClCdList                  , getGrpCdList(GrpCdConstants_Aprj.SIGN_CL_CD                    ));

        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));
        
        modelAndView.addObject(resultList   , serviceAprj20036.srchAprj20036List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20036.srchAprj20036Cnt (param));

        param.setPageNo("1");
        param.setPageRowCnt("99999");
        modelAndView.addObject(opChrgUserList, serviceAprj20034.srchAprj20034GroupList(param));
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20036_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_결제담당자조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20036_41)
    public @ResponseBody Object srchAprj20036(HttpServletRequest request) throws CommonException {
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

        // 서명 구분 코드
        modelAndView.addObject(signClCdList                  , getGrpCdList(GrpCdConstants_Aprj.SIGN_CL_CD                    ));

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20036.srchAprj20036(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20036_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_결제담당자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20036_50)
    public @ResponseBody Object srchAprj20036UserList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        setDate(request, modelAndView, param);
        setCoInfo(request, modelAndView, param);
        
        if ( !ApplicationConstants_Aprj.USER_AUTH_ADMIN.equals(sessionUser.getUserAuthCd()) ) {
	    	setObject(request, modelAndView, param,"srchStmUserId", sessionUser.getUserId());
	    	setObject(request, modelAndView, param,"srchStmUserNm", sessionUser.getUserNm());
        } 
        
        // 결제 구분 코드
        modelAndView.addObject(stmClCdList                   , getGrpCdList(GrpCdConstants_Aprj.STM_CL_CD                     ));

        // 결제 권한 코드
        modelAndView.addObject(stmAuthCdList                 , getGrpCdList(GrpCdConstants_Aprj.STM_AUTH_CD                   ));

        // 서명 구분 코드
        modelAndView.addObject(signClCdList                  , getGrpCdList(GrpCdConstants_Aprj.SIGN_CL_CD                    ));

        
        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));
        
        modelAndView.addObject(resultList   , serviceAprj20036.srchAprj20036UserList(param));
        modelAndView.addObject(resultListCnt, serviceAprj20036.srchAprj20036UserCnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20036_50);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_결제담당자조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20036_51)
    public @ResponseBody Object srchAprj20036User(HttpServletRequest request) throws CommonException {
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

        // 서명 구분 코드
        modelAndView.addObject(signClCdList                  , getGrpCdList(GrpCdConstants_Aprj.SIGN_CL_CD                    ));

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20036.srchAprj20036(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20036_51);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_결제담당자저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20036_00)
    public @ResponseBody Object saveAprj20036(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        if ( StringUtil.isNull(param.getStmSerNum())) {
        	param.setStmSerNum(null);
        }
        
        int cnt = 0;
        param.setSignDtm(param.getUpdtDtm());
        cnt = serviceAprj20036.saveAprj20036(param);

        modelAndView = (ModelAndView) srchAprj20036List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_결제담당자저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20036_01)
    public @ResponseBody Object saveAprj20036Batch(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = serviceAprj20036.saveAprj20036StmUser(param);

        modelAndView = (ModelAndView) srchAprj20036List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }

    
    /**
     * 프로젝트_결제담당자삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20036_80)
    public @ResponseBody Object deleteAprj20036(HttpServletRequest request) throws CommonException {
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
            param.setStmSeqNum(delKeys[i]);

            cnt =+ serviceAprj20036.deleteAprj20036(param);
        }

        modelAndView = (ModelAndView) srchAprj20036List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}