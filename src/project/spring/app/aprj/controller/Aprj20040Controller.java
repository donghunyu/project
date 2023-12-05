/*-------------------------------------------------------------------
* NAME   : Aprj20040Controller
* DESC   : 프로젝트_요청
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
import project.spring.app.aprj.constants.GrpCdConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20030Service;
import project.spring.app.aprj.service.Aprj20040Service;
import project.spring.app.aprj.service.Aprj20041Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj20040Controller extends AprjController {

    @Autowired
    Aprj20030Service serviceAprj20030;

    @Autowired
    Aprj20040Service serviceAprj20040;

    @Autowired
    Aprj20041Service serviceAprj20041;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더

    private String resultItmList                  = "resultItmList"               ;  // 리스트결과
    
    private String reqTypCdList                   = "reqTypCdList"                ;  // 요청 종류 코드리스트       
    
    String REQ_TYP_CD_2000 = "2000";
    String REQ_TYP_CD_3000 = "3000";
    /**
     * 프로젝트_요청리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20040_40)
    public @ResponseBody Object srchAprj20040List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 요청 종류 코드
        modelAndView.addObject(reqTypCdList                  , getGrpCdList(GrpCdConstants_Aprj.REQ_TYP_CD                    ));

        // 양식
        Aprj20030Model header = new Aprj20030Model();
        getParameter(request, header);
        
        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(header));

        
        // 요청
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        
        modelAndView.addObject(resultList   , serviceAprj20040.srchAprj20040List(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20040_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_요청조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20040_41)
    public @ResponseBody Object srchAprj20040(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 요청 종류 코드
        modelAndView.addObject(reqTypCdList                  , getGrpCdList(GrpCdConstants_Aprj.REQ_TYP_CD                    ));
        
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20040.srchAprj20040(param));

        modelAndView.addObject(resultItmList, serviceAprj20041.srchAprj20041List(param));
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20040_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_요청리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20040_50)
    public @ResponseBody Object srchAprj20040UserList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 요청 종류 코드
        modelAndView.addObject(reqTypCdList                  , getGrpCdList(GrpCdConstants_Aprj.REQ_TYP_CD                    ));

        // 양식
        Aprj20030Model header = new Aprj20030Model();
        getParameter(request, header);
        
        modelAndView.addObject(resultHeader, serviceAprj20030.srchAprj20030(header));

        
        // 요청
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceAprj20040.srchAprj20040UserList(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20040_50);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_요청조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20040_51)
    public @ResponseBody Object srchAprj20040User(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 요청 종류 코드
        modelAndView.addObject(reqTypCdList                  , getGrpCdList(GrpCdConstants_Aprj.REQ_TYP_CD                    ));
        
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20040.srchAprj20040(param));

        modelAndView.addObject(resultItmList, serviceAprj20041.srchAprj20041List(param));
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20040_51);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_요청저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20040_00)
    public @ResponseBody Object saveAprj20040(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 요청 등록
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = serviceAprj20040.saveAprj20040(param);

        // 항목 등록
        if ( REQ_TYP_CD_2000.equals(param.getReqTypCd()) || REQ_TYP_CD_3000.equals(param.getReqTypCd()) ) {
	        String[] itmVals = request.getParameterValues("itmVal");
	        String[] itmCtts = request.getParameterValues("itmCtt");
	        
	        serviceAprj20041.deleteAprj20041(param);
	        if ( itmVals != null ) {
		        for ( int i = 0; i < itmVals.length; i++ ) {
		            param.setItmVal(itmVals[i]);
		            param.setItmCtt(itmCtts[i]);
		
		            cnt =+ serviceAprj20041.insertAprj20041(param);
		        }
	        }
        } else {
        	param.setItmSerNum(null);
        	serviceAprj20041.deleteAprj20041(param);
            cnt =+ serviceAprj20041.saveAprj20041(param);
        }

        
        modelAndView = (ModelAndView) srchAprj20040List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_요청삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20040_80)
    public @ResponseBody Object deleteAprj20040(HttpServletRequest request) throws CommonException {
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
            param.setReqSerNum(delKeys[i]);

            cnt =+ serviceAprj20040.deleteAprj20040(param);
        }

        modelAndView = (ModelAndView) srchAprj20040List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}