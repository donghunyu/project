/*-------------------------------------------------------------------
* NAME   : Aprj10040Controller
* DESC   : 설정_업무주기
* Author : 
* DATE   : 2018-11-07
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.GrpCdConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj10040Model;
import project.spring.app.aprj.service.Aprj10040Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj10040Controller extends AprjController {

    @Autowired
    Aprj10040Service serviceAprj10040;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String cyclClCdList                   = "cyclClCdList"                ;  // 주기 구분 코드리스트          
    /**
     * 설정_업무주기리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10040_40)
    public @ResponseBody Object srchAprj10040List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj10040Model param = new Aprj10040Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        // 주기 구분 코드
        modelAndView.addObject(cyclClCdList                  , getGrpCdList(GrpCdConstants_Aprj.CYCL_CL_CD                    ));

        modelAndView.addObject(resultList   , serviceAprj10040.srchAprj10040List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10040.srchAprj10040Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10040_40);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무주기조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10040_41)
    public @ResponseBody Object srchAprj10040(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10040Model param = new Aprj10040Model();
        getParameter(request, param);

        // 주기 구분 코드
        modelAndView.addObject(cyclClCdList                  , getGrpCdList(GrpCdConstants_Aprj.CYCL_CL_CD                    ));

        modelAndView.addObject(resultObject , serviceAprj10040.srchAprj10040(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10040_41);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무주기리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10040_70)
    public @ResponseBody Object srchAprj10040ExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10040Model param = new Aprj10040Model();
        getParameter(request, param);

        File file = serviceAprj10040.srchAprj10040ExcelList(param);
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    /**
     * 설정_업무주기리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10040_90)
    public @ResponseBody Object srchAprj10040PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10040Model param = new Aprj10040Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        // 주기 구분 코드
        modelAndView.addObject(cyclClCdList                  , getGrpCdList(GrpCdConstants_Aprj.CYCL_CL_CD                    ));

        modelAndView.addObject(resultList   , serviceAprj10040.srchAprj10040List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10040.srchAprj10040Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10040_90);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무주기저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10040_00)
    public @ResponseBody Object saveAprj10040(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10040Model param = new Aprj10040Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj10040.saveAprj10040(param);

        modelAndView = (ModelAndView) srchAprj10040List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 설정_업무주기삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10040_80)
    public @ResponseBody Object deleteAprj10040(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj10040Model param = new Aprj10040Model();
        String[] temp = new String[2];
        
        for ( int i = 0; i < delKeys.length; i++ ) {
        	temp = StringUtils.split(delKeys[i], "_");
        	
            param.setCoId  (temp[0]);
            param.setCyclId(temp[1]);

            cnt =+ serviceAprj10040.deleteAprj10040(param);
        }

        modelAndView = (ModelAndView) srchAprj10040List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}