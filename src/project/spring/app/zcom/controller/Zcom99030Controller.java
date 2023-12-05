/*-------------------------------------------------------------------
* NAME   : Zcom99030Controller
* DESC   : 관리자_사용자
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
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.object.ZcomController;
import project.spring.app.zcom.lib.util.EncryptionSha256;
import project.spring.app.zcom.lib.util.SendMail;
import project.spring.app.zcom.lib.util.StringUtil;
import project.spring.app.zcom.model.Zcom99010Model;
import project.spring.app.zcom.model.Zcom99030Model;
import project.spring.app.zcom.service.Zcom99030Service;


@Controller
public class Zcom99030Controller extends ZcomController {

    @Autowired
    Zcom99030Service serviceZcom99030;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String userAuthCdList                 = "userAuthCdList"              ;  // 사용자 권한 코드리스트        
    private String ofcLvlClCdList                 = "ofcLvlClCdList"              ;  // 직급 구분 코드리스트        
    /**
     * 관리자_사용자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99030_40)
    public @ResponseBody Object srchZcom99030List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Zcom99030Model param = new Zcom99030Model();
        getParameter(request, param);

        // 사용자 권한 코드
        List<Zcom99010Model> cdList = getGrpCdList(GrpCdConstants_Aprj.USER_AUTH_CD);
        if ( !ApplicationConstants_Aprj.USER_AUTH_CD_ADMIN.equals(sessionUser.getUserAuthCd()) ) {
        	cdList.remove(0);
        }
        modelAndView.addObject(userAuthCdList                , cdList);
        
        // 직급 구분 코드
        modelAndView.addObject(ofcLvlClCdList                , getGrpCdList(GrpCdConstants_Aprj.OFC_LVL_CL_CD                 ));

        modelAndView.addObject(resultList   , serviceZcom99030.srchZcom99030List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99030.srchZcom99030Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99030_40);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99030_90)
    public @ResponseBody Object srchZcom99030PopupList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99030Model param = new Zcom99030Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceZcom99030.srchZcom99030List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99030.srchZcom99030Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99030_90);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99030_41)
    public @ResponseBody Object srchZcom99030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 사용자 권한 코드
        List<Zcom99010Model> cdList = getGrpCdList(GrpCdConstants_Aprj.USER_AUTH_CD);
        if ( !ApplicationConstants_Aprj.USER_AUTH_CD_ADMIN.equals(sessionUser.getUserAuthCd()) ) {
        	cdList.remove(0);
        }
        modelAndView.addObject(userAuthCdList                , cdList);

        // 직급 구분 코드
        modelAndView.addObject(ofcLvlClCdList                , getGrpCdList(GrpCdConstants_Aprj.OFC_LVL_CL_CD                 ));

        Zcom99030Model param = new Zcom99030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceZcom99030.srchZcom99030(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99030_41);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99030_50)
    public @ResponseBody Object srchZcom99030User(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Zcom99030Model param = new Zcom99030Model();
        getParameter(request, param);

        param.setUserId(sessionUser.getUserId());
        modelAndView.addObject(resultObject , serviceZcom99030.srchZcom99030(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99030_50);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99030_70)
    public @ResponseBody Object srchZcom99030ExcelList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99030Model param = new Zcom99030Model();
        getParameter(request, param);

        File file = serviceZcom99030.srchZcom99030ExcelList(param);
        
        //FileDownloadView Parameter값 설정
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("filePath"  , file);
        map.put("lgcFileNm" , file.getName());
        
        return new ModelAndView("download", "downloadFile", map);
    }

    
    /**
     * 관리자_사용자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99030_60)
    public @ResponseBody Object srchZcom99030CoList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Zcom99030Model param = new Zcom99030Model();
        getParameter(request, param);

        // 사용자 권한 코드
        List<Zcom99010Model> cdList = getGrpCdList(GrpCdConstants_Aprj.USER_AUTH_CD);
        if ( !ApplicationConstants_Aprj.USER_AUTH_CD_ADMIN.equals(sessionUser.getUserAuthCd()) ) {
        	cdList.remove(0);
        }
        modelAndView.addObject(userAuthCdList                , cdList);

        // 직급 구분 코드
        modelAndView.addObject(ofcLvlClCdList                , getGrpCdList(GrpCdConstants_Aprj.OFC_LVL_CL_CD                 ));

        modelAndView.addObject(resultList   , serviceZcom99030.srchZcom99030List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99030.srchZcom99030Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99030_60);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99030_61)
    public @ResponseBody Object srchZcom99030Co(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        // 사용자 권한 코드
        List<Zcom99010Model> cdList = getGrpCdList(GrpCdConstants_Aprj.USER_AUTH_CD);
        if ( !ApplicationConstants_Aprj.USER_AUTH_CD_ADMIN.equals(sessionUser.getUserAuthCd()) ) {
        	cdList.remove(0);
        }
        modelAndView.addObject(userAuthCdList                , cdList);

        // 직급 구분 코드
        modelAndView.addObject(ofcLvlClCdList                , getGrpCdList(GrpCdConstants_Aprj.OFC_LVL_CL_CD                 ));

        Zcom99030Model param = new Zcom99030Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceZcom99030.srchZcom99030(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99030_61);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99030_00)
    public @ResponseBody Object saveZcom99030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99030Model param = new Zcom99030Model();
        getParameter(request, param);

        Zcom99030Model temp = null;
//        if ( "INSERT".equals(param.getWorkType()) ) {
//        	temp = serviceZcom99030.srchZcom99030(param);
//        }

        
    	if ( temp == null ) {
        	serviceZcom99030.saveZcom99030(param);
    	}

    	modelAndView = (ModelAndView) srchZcom99030List(request);
    	if ( temp != null ) {
    		param.setUserId(null);
            modelAndView.addObject(resultObject , param);
    		AprjMessage.setMsg(modelAndView, "warn.common.login.fail.exist");
        } else {
    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
    	}

    	return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99030_01)
    public @ResponseBody Object saveZcom99030User(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Zcom99030Model param = new Zcom99030Model();
        getParameter(request, param);

        
//        if ( !sessionUser.getPwd().equals(EncryptionSha256.encryptSha256(param.getOldUserPwd())) ) {
//        	AprjMessage.setMsg(modelAndView, "warn.common.login.fail.pwd");
//        } else {
//        	param.setPwdUpdtDt(param.getUpdtDtm().substring(0, 8));
//            serviceZcom99030.updateZcom99030User(param);
//
//        	
//            sessionUser = serviceZcom99030.srchZcom99030(param);
//            sessionUser.setSrchCoId(sessionUser.getCoId());
//            sessionUser.setSrchCoNm(sessionUser.getCoNm());
//            
//            String ip = request.getRemoteAddr();
//            sessionUser.setRgstIp(ip);
//            sessionUser.setUpdtIp(ip);
//            
//            setLogin(request, modelAndView);
//
//    		AprjMessage.setMsg(modelAndView, "info.common.save.success");
//        }
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99030_50);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99030_02)
    public @ResponseBody Object srchZcom99030PwdInit(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99030Model param = new Zcom99030Model();
        getParameter(request, param);

        param = serviceZcom99030.srchZcom99030(param);
        
        if ( !StringUtil.isNull(param.getMailAddr()) ) {
        	UUID uuid = UUID.randomUUID();
        	
//            param.setPwd(uuid.toString().replace("-", "").substring(3, 13));
//            param.setPwdUpdtDt(null);
            serviceZcom99030.updateZcom99030PwdInit(param);
            
            SendMail.sendMailPwd(param);

            AprjMessage.setMsg(modelAndView, "info.common.mail.success");
        } else {
    		AprjMessage.setMsg(modelAndView, "info.common.mail.empty");
        }

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99030_02);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_사용자삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99030_80)
    public @ResponseBody Object deleteZcom99030(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        
        Zcom99030Model param = new Zcom99030Model();
        
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setUserId(delKeys[i]);

            cnt =+ serviceZcom99030.deleteZcom99030(param);
        }

        modelAndView = (ModelAndView) srchZcom99030List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}