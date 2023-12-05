/*-------------------------------------------------------------------
* NAME   : Aprj20050Controller
* DESC   : 프로젝트_응답
* Author : 
* DATE   : 2019-02-18
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
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.aprj.service.Aprj20050Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj20050Controller extends AprjController {

    @Autowired
    Aprj20030Service serviceAprj20030;
    
    @Autowired
    Aprj20050Service serviceAprj20050;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    
    private String resStCdList                    = "resStCdList"                 ;  // 처리 상태 코드리스트          
    /**
     * 프로젝트_응답리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20050_40)
    public @ResponseBody Object srchAprj20050List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        // 업무
        Aprj20030Model header = new Aprj20030Model();
        getParameter(request, header);
        
        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030User(header));

        
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        // 처리 상태 코드
        modelAndView.addObject(resStCdList                  , getGrpCdList(GrpCdConstants_Aprj.RES_ST_CD                    ));

        modelAndView.addObject(resultList   , serviceAprj20050.srchAprj20050List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20050.srchAprj20050Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20050_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20050_41)
    public @ResponseBody Object srchAprj20050(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20050.srchAprj20050(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20050_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20050_00)
    public @ResponseBody Object saveAprj20050(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj20050.saveAprj20050(param);

        modelAndView = (ModelAndView) srchAprj20050List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20050_80)
    public @ResponseBody Object deleteAprj20050(HttpServletRequest request) throws CommonException {
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
            param.setOpChrgId(delKeys[i]);
            param.setUserId(delKeys[i]);
            param.setResSerNum(delKeys[i]);

            cnt =+ serviceAprj20050.deleteAprj20050(param);
        }

        modelAndView = (ModelAndView) srchAprj20050List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}