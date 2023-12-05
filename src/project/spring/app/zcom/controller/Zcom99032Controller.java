/*-------------------------------------------------------------------
* NAME   : Zcom99032Controller
* DESC   : 관리자_부서
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

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.object.ZcomController;
import project.spring.app.zcom.model.Zcom99032Model;
import project.spring.app.zcom.service.Zcom99032Service;


@Controller
public class Zcom99032Controller extends ZcomController {

    @Autowired
    Zcom99032Service serviceZcom99032;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 관리자_부서리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99032_40)
    public @ResponseBody Object srchZcom99032List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Zcom99032Model param = new Zcom99032Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceZcom99032.srchZcom99032List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99032.srchZcom99032Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99032_40);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_부서리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99032_90)
    public @ResponseBody Object srchZcom99032PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99032Model param = new Zcom99032Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceZcom99032.srchZcom99032List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99032.srchZcom99032Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99032_90);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_부서리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99032_91)
    public @ResponseBody Object srchZcom99032Chart(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99032Model param = new Zcom99032Model();
        getParameter(request, param);

//        modelAndView.addObject(resultList   , serviceZcom99032.srchZcom99032List(param));
//        modelAndView.addObject(resultListCnt, serviceZcom99032.srchZcom99032Cnt (param));


        // 최상위 부서 조회
        param.setDeptId("0000000000");
        param = serviceZcom99032.srchZcom99032(param);
        
        List<Zcom99032Model> list = new ArrayList<Zcom99032Model>();
        
    	if ( param != null ) {
            list.add(param);
            param.setLev("0");
            srchZcom99032SubList(list, param, 1);
    	}
        
        modelAndView.addObject(resultList   , list);
        modelAndView.addObject(resultListCnt, list.size());

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99032_91);
        return returnResponse(modelAndView);
    }


    public List<Zcom99032Model> srchZcom99032SubList(List<Zcom99032Model> list, Zcom99032Model param, int lev) throws CommonException {

    	if ( param == null ) {
    		return null;
    	}
    	
    	List<Zcom99032Model> subList = serviceZcom99032.srchZcom99032SubList(param);
    	param.println();
    	if ( subList == null || subList.size() == 0 ) {
    		return null;
    	}
    	
    	for ( int i = 0; i < subList.size(); i++ ) {
    		Zcom99032Model temp = subList.get(i);
    		temp.setLev(lev + "");
    		list.add(temp);
    		srchZcom99032SubList(list, temp, lev + 1);
    	}
    	
        return list;
    }
    
    
    /**
     * 관리자_부서조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99032_41)
    public @ResponseBody Object srchZcom99032(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99032Model param = new Zcom99032Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceZcom99032.srchZcom99032(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99032_41);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_부서리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99032_70)
    public @ResponseBody Object srchZcom99032ExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99032Model param = new Zcom99032Model();
        getParameter(request, param);

        File file = serviceZcom99032.srchZcom99032ExcelList(param);
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }


    /**
     * 관리자_부서저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99032_00)
    public @ResponseBody Object saveZcom99032(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99032Model param = new Zcom99032Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceZcom99032.saveZcom99032(param);

        modelAndView = (ModelAndView) srchZcom99032List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_부서삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99032_80)
    public @ResponseBody Object deleteZcom99032(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Zcom99032Model param = new Zcom99032Model();
        
        String[] temp = new String[2];
        for ( int i = 0; i < delKeys.length; i++ ) {
        	temp = delKeys[i].split("_");
        	
            param.setCoId  (temp[0]);
            param.setDeptId(temp[1]);

            cnt =+ serviceZcom99032.deleteZcom99032(param);
        }

        modelAndView = (ModelAndView) srchZcom99032List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}