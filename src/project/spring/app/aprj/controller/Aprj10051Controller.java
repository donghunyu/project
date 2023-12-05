/*-------------------------------------------------------------------
* NAME   : Aprj10051Controller
* DESC   : 설정_양식요청
* Author : 
* DATE   : 2018-10-12
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
import project.spring.app.aprj.model.Aprj10050Model;
import project.spring.app.aprj.service.Aprj10050Service;
import project.spring.app.aprj.service.Aprj10051Service;
import project.spring.app.aprj.service.Aprj10052Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj10051Controller extends AprjController {

    @Autowired
    Aprj10050Service serviceAprj10050;

    @Autowired
    Aprj10051Service serviceAprj10051;

    @Autowired
    Aprj10052Service serviceAprj10052;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수

    private String resultForm                     = "resultForm"                  ;  // 검색결과
    private String resultReq                      = "resultReq"                   ;  // 검색결과
    private String reqTypCdList                   = "reqTypCdList"                ;  // 요청 종류 코드리스트
    
    private String resultObject                   = "resultObject"                ;  // 검색결과
    private String resultReqList                  = "resultReqList"               ;  // 리스트결과
    
    String REQ_TYP_CD_NORMAL = "1000";
    /**
     * 설정_양식요청리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10051_40)
    public @ResponseBody Object srchAprj10051List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        // 사용자 권한 코드
        modelAndView.addObject(reqTypCdList                , getGrpCdList(GrpCdConstants_Aprj.REQ_TYP_CD                  ));
        
        
        Aprj10050Model paramAprj10050 = new Aprj10050Model();
        getParameter(request, paramAprj10050);

        modelAndView.addObject(resultForm  , serviceAprj10050.srchAprj10050(paramAprj10050));

        
        Aprj10050Model param = new Aprj10050Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceAprj10051.srchAprj10051List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10051.srchAprj10051Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10051_40);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_양식요청조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10051_41)
    public @ResponseBody Object srchAprj10051(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 사용자 권한 코드
        modelAndView.addObject(reqTypCdList                , getGrpCdList(GrpCdConstants_Aprj.REQ_TYP_CD                  ));
        
        Aprj10050Model param = new Aprj10050Model();
        getParameter(request, param);

        modelAndView.addObject(resultReq   , serviceAprj10051.srchAprj10051(param));

        modelAndView.addObject(resultList   , serviceAprj10052.srchAprj10052List(param));
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10051_41);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_양식요청저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10051_00)
    public @ResponseBody Object saveAprj10051(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 사용자 권한 코드
        modelAndView.addObject(reqTypCdList                , getGrpCdList(GrpCdConstants_Aprj.REQ_TYP_CD                  ));
        
        // 요청 등록
        Aprj10050Model param = new Aprj10050Model();
        getParameter(request, param);
        
        serviceAprj10051.saveAprj10051(param);
        
        // 항목 등록
        serviceAprj10052.deleteAprj10052(param);
        int cnt = 0;
        if ( !REQ_TYP_CD_NORMAL.equals(param.getReqTypCd()) ) {
	        String[] itmVals = request.getParameterValues("itmVal");
	        String[] itmCtts = request.getParameterValues("itmCtt");
	        
	        if ( itmVals != null ) {
		        for ( int i = 0; i < itmVals.length; i++ ) {
		            param.setItmVal(itmVals[i]);
		            param.setItmCtt(itmCtts[i]);
		
		            cnt =+ serviceAprj10052.insertAprj10052(param);
		        }
	        }
        }
        
        param.println();
        modelAndView.addObject(resultReq    , serviceAprj10051.srchAprj10051(param));
        modelAndView.addObject(resultList   , serviceAprj10052.srchAprj10052List(param));
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10051_41);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 설정_양식요청삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10051_80)
    public @ResponseBody Object deleteAprj10051(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKeyReq");
        Aprj10050Model param = new Aprj10050Model();
        getParameter(request, param);
        
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setReqSerNum(delKeys[i]);

            cnt =+ serviceAprj10051.deleteAprj10051(param);
            serviceAprj10052.deleteAprj10052(param);
        }

        modelAndView.addObject(resultObject , serviceAprj10050.srchAprj10050(param));

        modelAndView.addObject(resultReqList, serviceAprj10051.srchAprj10051List(param));
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10050_41);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}