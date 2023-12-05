/*-------------------------------------------------------------------
* NAME   : Aprj10011Controller
* DESC   : 설정_자산구분자산
* Author : 
* DATE   : 2019-01-18
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
import project.spring.app.aprj.model.Aprj10010Model;
import project.spring.app.aprj.service.Aprj10010Service;
import project.spring.app.aprj.service.Aprj10011Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj10011Controller extends AprjController {

    @Autowired
    Aprj10010Service serviceAprj10010;

    @Autowired
    Aprj10011Service serviceAprj10011;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    /**
     * 설정_자산구분자산리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10011_40)
    public @ResponseBody Object srchAprj10011List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultHeader, serviceAprj10010.srchAprj10010(param));
        
        modelAndView.addObject(resultList   , serviceAprj10011.srchAprj10011List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10011.srchAprj10011Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10011_40);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_자산구분자산조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10011_41)
    public @ResponseBody Object srchAprj10011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj10011.srchAprj10011(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10011_41);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_자산구분자산저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10011_00)
    public @ResponseBody Object saveAprj10011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj10011.saveAprj10011(param);

        modelAndView = (ModelAndView) srchAprj10011List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_자산구분자산삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10011_80)
    public @ResponseBody Object deleteAprj10011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);
        
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setAstId(delKeys[i]);

            cnt =+ serviceAprj10011.deleteAprj10011(param);
        }

        modelAndView = (ModelAndView) srchAprj10011List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}