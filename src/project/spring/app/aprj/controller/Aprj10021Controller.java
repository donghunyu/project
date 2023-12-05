/*-------------------------------------------------------------------
* NAME   : Aprj10021Controller
* DESC   : 설정_업무담당자
* Author : 
* DATE   : 2018-12-12
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
import project.spring.app.aprj.model.Aprj10020Model;
import project.spring.app.aprj.service.Aprj10020Service;
import project.spring.app.aprj.service.Aprj10021Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj10021Controller extends AprjController {

    @Autowired
    Aprj10020Service serviceAprj10020;

    @Autowired
    Aprj10021Service serviceAprj10021;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    /**
     * 설정_업무담당자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10021_40)
    public @ResponseBody Object srchAprj10021List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultHeader, serviceAprj10020.srchAprj10020(param));

        modelAndView.addObject(resultList   , serviceAprj10021.srchAprj10021List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10021.srchAprj10021Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10021_40);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무담당자조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10021_41)
    public @ResponseBody Object srchAprj10021(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj10021.srchAprj10021(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10021_41);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무담당자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10021_90)
    public @ResponseBody Object srchAprj10021PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj10021.srchAprj10021UserList(param));
        modelAndView.addObject(resultListCnt, serviceAprj10021.srchAprj10021UserCnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10021_90);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무담당자저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10021_00)
    public @ResponseBody Object saveAprj10021(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj10021.saveAprj10021(param);

        modelAndView = (ModelAndView) srchAprj10021List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무담당자삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10021_80)
    public @ResponseBody Object deleteAprj10021(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj10020Model param = new Aprj10020Model();
        getParameter(request, param);
        
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setUserId(delKeys[i]);

            cnt =+ serviceAprj10021.deleteAprj10021(param);
        }

        modelAndView = (ModelAndView) srchAprj10021List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}