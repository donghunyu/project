/*-------------------------------------------------------------------
* NAME   : Aprj10012Controller
* DESC   : 설정_자산
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

import java.io.File;
import java.util.HashMap;

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
import project.spring.app.aprj.service.Aprj10012Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj10012Controller extends AprjController {

    @Autowired
    Aprj10012Service serviceAprj10012;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 설정_자산리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10012_40)
    public @ResponseBody Object srchAprj10012List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj10012.srchAprj10012List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10012.srchAprj10012Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10012_40);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_자산조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10012_41)
    public @ResponseBody Object srchAprj10012(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceAprj10012.srchAprj10012(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10012_41);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_자산리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10012_90)
    public @ResponseBody Object srchAprj10012PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);
        setCoInfo(request, modelAndView, param);

        modelAndView.addObject(resultList   , serviceAprj10012.srchAprj10012List(param));
        modelAndView.addObject(resultListCnt, serviceAprj10012.srchAprj10012Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ10012_90);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_자산리스트조회(Excel)
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10012_70)
    public @ResponseBody Object srchAprj10012ExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);

        File file = serviceAprj10012.srchAprj10012ExcelList(param);
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    /**
     * 설정_자산저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10012_00)
    public @ResponseBody Object saveAprj10012(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj10010Model param = new Aprj10010Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceAprj10012.saveAprj10012(param);

        modelAndView = (ModelAndView) srchAprj10012List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 설정_자산삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ10012_80)
    public @ResponseBody Object deleteAprj10012(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Aprj10010Model param = new Aprj10010Model();
        
        for ( int i = 0; i < delKeys.length; i++ ) {
            String temp[] = delKeys[i].split("_");

            param.setCoId (temp[0]);
            param.setAstId(temp[1]);

            cnt =+ serviceAprj10012.deleteAprj10012(param);
        }

        modelAndView = (ModelAndView) srchAprj10012List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}