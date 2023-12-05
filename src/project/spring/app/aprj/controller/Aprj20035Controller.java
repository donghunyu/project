/*-------------------------------------------------------------------
* NAME   : Aprj20035Controller
* DESC   : 프로젝트_담당자이관
* Author : 
* DATE   : 2019-01-15
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
import project.spring.app.aprj.model.Aprj10020Model;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj10020Service;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.aprj.service.Aprj20033Service;
import project.spring.app.aprj.service.Aprj20034Service;
import project.spring.app.aprj.service.Aprj20035Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99030Model;
import project.spring.app.zcom.service.Zcom99030Service;


@Controller
public class Aprj20035Controller extends AprjController {

    @Autowired
    Aprj10020Service serviceAprj10020;

    @Autowired
    Zcom99030Service serviceZcom99030;

    @Autowired
    Aprj20030Service serviceAprj20030;

    @Autowired
    Aprj20033Service serviceAprj20033;

    @Autowired
    Aprj20034Service serviceAprj20034;

    @Autowired
    Aprj20035Service serviceAprj20035;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    private String resultOpChrg                   = "resultOpChrg"                ;  // 검색 헤더
    private String resultUser                     = "resultUser"                  ;  // 검색 헤더
    
    private String trnsfTranCdList                = "trnsfTranCdList"             ;  // 이관 처리 코드리스트        
    /**
     * 프로젝트_담당자이관리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20035_40)
    public @ResponseBody Object srchAprj20035List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        // 여부 코드
        modelAndView.addObject(trnsfTranCdList, getGrpCdList(GrpCdConstants_Aprj.TRNSF_TRAN_CD));
        
        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));

        modelAndView.addObject(resultList   , serviceAprj20035.srchAprj20035List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20035.srchAprj20035Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20035_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_담당자이관조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20035_41)
    public @ResponseBody Object srchAprj20035(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        // 여부 코드
        modelAndView.addObject(trnsfTranCdList, getGrpCdList(GrpCdConstants_Aprj.TRNSF_TRAN_CD));
        
        modelAndView.addObject(resultObject , serviceAprj20035.srchAprj20035(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20035_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_담당자이관조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20035_50)
    public @ResponseBody Object srchAprj20035Request(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(param));

        Aprj10020Model paramAprj10020 = new Aprj10020Model();
        getParameter(request, paramAprj10020);
        modelAndView.addObject(resultOpChrg , serviceAprj10020.srchAprj10020(paramAprj10020));

        Zcom99030Model paramZcom99030 = new Zcom99030Model();
        getParameter(request, paramZcom99030);
        modelAndView.addObject(resultUser   , serviceZcom99030.srchZcom99030(paramZcom99030));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20035_50);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_담당자이관저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20035_00)
    public @ResponseBody Object saveAprj20035(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20035.saveAprj20035(param);

        modelAndView = (ModelAndView) srchAprj20035List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_담당자이관저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20035_01)
    public @ResponseBody Object saveAprj20035Tran(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20035.updateAprj20035Tran(param);

        // 이관 승인시 담당 변경
        if ( "1000".equals(param.getTrnsfTranCd()) ) {
        	serviceAprj20033.deleteAprj20033Trnsf(param);
        	serviceAprj20033.updateAprj20033Trnsf(param);
        	
        	serviceAprj20034.deleteAprj20034Trnsf(param);
        	serviceAprj20034.updateAprj20034Trnsf(param);
        }
        
        modelAndView = (ModelAndView) srchAprj20035List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_담당자이관삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20035_80)
    public @ResponseBody Object deleteAprj20035(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj20030Model param = new Aprj20030Model();
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setCoId(delKeys[i]);
            param.setOpId(delKeys[i]);
            param.setOpSerNum(delKeys[i]);
            param.setPrjId(delKeys[i]);
            param.setCtrlNum(delKeys[i]);
            param.setAstClId(delKeys[i]);
            param.setTrnsfSerNum(delKeys[i]);

            cnt =+ serviceAprj20035.deleteAprj20035(param);
        }

        modelAndView = (ModelAndView) srchAprj20035List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}