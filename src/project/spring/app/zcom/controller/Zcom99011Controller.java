/*-------------------------------------------------------------------
* NAME   : Zcom99011Controller
* DESC   : 관리자_코드
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

import java.util.List;

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
public class Zcom99011Controller extends ZcomController {

    @Autowired
    Zcom99010Service serviceZcom99010;

    @Autowired
    Zcom99011Service serviceZcom99011;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultGrpCd                    = "resultGrpCd"                 ;  // 리스트결과
    /**
     * 관리자_코드리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99011_40)
    public @ResponseBody Object srchZcom99011List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Zcom99010Model param = new Zcom99010Model();
        getParameter(request, param);
        
        modelAndView.addObject(resultGrpCd  , serviceZcom99010.srchZcom99010(param));

        
        List<Zcom99010Model> list = serviceZcom99011.srchZcom99011List(param);
        
        modelAndView.addObject(resultList   , list);
        modelAndView.addObject(resultListCnt, list.size());

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99011_40);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_코드조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99011_41)
    public @ResponseBody Object srchZcom99011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99010Model param = new Zcom99010Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceZcom99011.srchZcom99011(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99011_41);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_코드저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99011_00)
    public @ResponseBody Object saveZcom99011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99010Model param = new Zcom99010Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceZcom99011.saveZcom99011(param);

        modelAndView = (ModelAndView) srchZcom99011List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_코드삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99011_80)
    public @ResponseBody Object deleteZcom99011(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        
        Zcom99010Model param = new Zcom99010Model();
        getParameter(request, param);
        
        for ( int i = 0; i < delKeys.length; i++ ) {
//            param.setCd(delKeys[i]);

            cnt =+ serviceZcom99011.deleteZcom99011(param);
        }

        modelAndView = (ModelAndView) srchZcom99011List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}