/*-------------------------------------------------------------------
* NAME   : Aprj20053Controller
* DESC   : 프로젝트_응답결제
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

import java.util.List;

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
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj20034Service;
import project.spring.app.aprj.service.Aprj20050Service;
import project.spring.app.aprj.service.Aprj20053Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;


@Controller
public class Aprj20053Controller extends AprjController {

    @Autowired
    Aprj20034Service serviceAprj20034;

    @Autowired
    Aprj20050Service serviceAprj20050;

    @Autowired
    Aprj20053Service serviceAprj20053;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultHeader                   = "resultHeader"                ;  // 검색 헤더
    
    private String signClCdList                   = "signClCdList"                ;  // 서명 구분 코드리스트   
    
   
    /**
     * 프로젝트_응답결제리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20053_40)
    public @ResponseBody Object srchAprj20053List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        // 서명 구분 코드
        modelAndView.addObject(signClCdList                  , getGrpCdList(GrpCdConstants_Aprj.SIGN_CL_CD                    ));

        // 업무
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultHeader, serviceAprj20050.srchAprj20050(param));
        
        modelAndView.addObject(resultList   , serviceAprj20053.srchAprj20053List(param));
        modelAndView.addObject(resultListCnt, serviceAprj20053.srchAprj20053Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20053_40);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답결제조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20053_41)
    public @ResponseBody Object srchAprj20053(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj20053.srchAprj20053(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20053_41);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답결제리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20053_50)
    public @ResponseBody Object srchAprj20053UserList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        // 서명 구분 코드
        modelAndView.addObject(signClCdList                  , getGrpCdList(GrpCdConstants_Aprj.SIGN_CL_CD                    ));

        modelAndView.addObject(resultList   , serviceAprj20053.srchAprj20053UserList(param));
        modelAndView.addObject(resultListCnt, serviceAprj20053.srchAprj20053UserCnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20053_50);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답결제리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20053_51)
    public @ResponseBody Object srchAprj20053User(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        // 서명 구분 코드
        modelAndView.addObject(signClCdList                  , getGrpCdList(GrpCdConstants_Aprj.SIGN_CL_CD                    ));

        
        param = serviceAprj20053.srchAprj20053User(param);
        modelAndView.addObject(resultHeader , param);
        modelAndView.addObject(resultObject , param);

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ20053_51);
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답결제저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20053_00)
    public @ResponseBody Object saveAprj20053(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        int cnt = 0;
        
        String blcinVal = "";
        List<Aprj20030Model> tempList = serviceAprj20053.srchAprj20053List(param);
        for (int i = 0; i < tempList.size(); i++ ) {
        	Aprj20030Model temp = tempList.get(i);
        	if ( temp.getStmSeqNum().compareTo(param.getStmSeqNum()) > 0 ) {
        		continue;
        	}
        	if ( null != temp.getSignDtm() ) {
        		blcinVal = blcinVal + temp.getStmSerNum() + temp.getSignDtm() + "/" ;
        	}
        }
        
        param.setSignDtm(DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMDHMS));
        param.setBlcinVal(blcinVal);
        cnt = serviceAprj20053.saveAprj20053(param);
        
        // 최종 승인
        if ( ApplicationConstants_Aprj.SIGN_CL_CD_1000.equals(param.getSignClCd()) && Integer.parseInt(param.getStmSeqNum()) == tempList.size() ) {
        	serviceAprj20034.updateAprj20034Sign(param);
        	serviceAprj20050.updateAprj20050Sign(param);
        }
        
        // 반려
        if ( ApplicationConstants_Aprj.SIGN_CL_CD_2000.equals(param.getSignClCd()) ) {
        	serviceAprj20034.updateAprj20034Sign(param);
        	serviceAprj20050.updateAprj20050Sign(param);
        }
        
        modelAndView = (ModelAndView) srchAprj20053User(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 프로젝트_응답결제삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ20053_80)
    public @ResponseBody Object deleteAprj20053(HttpServletRequest request) throws CommonException {
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
            param.setStmSerNum(delKeys[i]);

            cnt =+ serviceAprj20053.deleteAprj20053(param);
        }

        modelAndView = (ModelAndView) srchAprj20053List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}