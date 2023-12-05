/*-------------------------------------------------------------------
* NAME   : Aprj10050Controller
* DESC   : 설정_양식
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj10050Model;
import project.spring.app.aprj.service.Aprj10050Service;
import project.spring.app.aprj.service.Aprj10051Service;
import project.spring.app.aprj.service.Aprj10052Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj10050Controller extends AprjController {

    @Autowired
    Aprj10050Service serviceAprj10050;

    @Autowired
    Aprj10051Service serviceAprj10051;

    @Autowired
    Aprj10052Service serviceAprj10052;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String resultReqList                  = "resultReqList"               ;  // 리스트결과
    /**
     * 설정_양식리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10050_40)
    public @ResponseBody Object srchAprj10050List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj10050Model param = new Aprj10050Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj10050.srchAprj10050List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10050.srchAprj10050Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10050_40);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_양식조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10050_41)
    public @ResponseBody Object srchAprj10050(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10050Model param = new Aprj10050Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj10050.srchAprj10050(param));

        modelAndView.addObject(resultReqList, serviceAprj10051.srchAprj10051List(param));
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10050_41);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_양식저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10050_00)
    public @ResponseBody Object saveAprj10050(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10050Model param = new Aprj10050Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj10050.saveAprj10050(param);

        modelAndView = (ModelAndView) srchAprj10050List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 설정_양식삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10050_80)
    public @ResponseBody Object deleteAprj10050(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj10050Model param = new Aprj10050Model();
        String[] temp = new String[2];
        for ( int i = 0; i < delKeys.length; i++ ) {
        	temp = StringUtils.split(delKeys[i], "_");
        	
            param.setCoId      (temp[0]);
            param.setFormId    (temp[1]);

            cnt =+ serviceAprj10050.deleteAprj10050(param);
        }

        modelAndView = (ModelAndView) srchAprj10050List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}