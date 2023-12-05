/*-------------------------------------------------------------------
* NAME   : Aprj10031Controller
* DESC   : 설정_결제라인
* Author : 
* DATE   : 2018-11-08
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
import project.spring.app.aprj.model.Aprj10030Model;
import project.spring.app.aprj.service.Aprj10030Service;
import project.spring.app.aprj.service.Aprj10031Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj10031Controller extends AprjController {

    @Autowired
    Aprj10030Service serviceAprj10030;

    @Autowired
    Aprj10031Service serviceAprj10031;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과
    
    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더

    private String stmClCdList                    = "stmClCdList"                 ;  // 결제 구분 코드리스트          
    private String stmAuthCdList                  = "stmAuthCdList"               ;  // 결제 권한 코드리스트          
    /**
     * 설정_결제라인리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10031_40)
    public @ResponseBody Object srchAprj10031List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10030Model param = new Aprj10030Model();
        getParameter(request, param);

        // 결제 구분 코드
        modelAndView.addObject(stmClCdList                   , getGrpCdList(GrpCdConstants_Aprj.STM_CL_CD                     ));

        // 결제 권한 코드
        modelAndView.addObject(stmAuthCdList                 , getGrpCdList(GrpCdConstants_Aprj.STM_AUTH_CD                   ));

        modelAndView.addObject(resultHeader, serviceAprj10030.srchAprj10030(param));
        
        
        modelAndView.addObject(resultList   , serviceAprj10031.srchAprj10031List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10031.srchAprj10031Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10031_40);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_결제라인조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10031_41)
    public @ResponseBody Object srchAprj10031(HttpServletRequest request) throws CommonException {
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
        
        Aprj10030Model param = new Aprj10030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj10031.srchAprj10031(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10031_41);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_결제라인저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10031_00)
    public @ResponseBody Object saveAprj10031(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10030Model param = new Aprj10030Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj10031.saveAprj10031(param);

        modelAndView = (ModelAndView) srchAprj10031List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 설정_결제라인삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10031_80)
    public @ResponseBody Object deleteAprj10031(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj10030Model param = new Aprj10030Model();
        getParameter(request, param);
        
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setStmSerNum(delKeys[i]);

            cnt =+ serviceAprj10031.deleteAprj10031(param);
        }

        modelAndView = (ModelAndView) srchAprj10031List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}