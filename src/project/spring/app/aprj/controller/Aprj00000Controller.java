/*-------------------------------------------------------------------
* NAME   : Aprj00000Controller
* DESC   : 관리자_로그인관리
* DATE   : 2013-11-21
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/
package project.spring.app.aprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjController;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.StringUtil;
import project.spring.app.zcom.model.Zcom99030Model;
import project.spring.app.zcom.model.Zcom99040Model;
import project.spring.app.zcom.service.Zcom99030Service;
import project.spring.app.zcom.service.Zcom99040Service;

@Controller
public class Aprj00000Controller extends AprjController {

    @Autowired
    Zcom99030Service serviceZcom99030;

    @Autowired
    Zcom99040Service serviceZcom99040;

    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 공통_로그인
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return returnResponse(modelAndView) ModelAndView객체
     * @CommonException CommonException 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_LOGIN)
    public @ResponseBody Object srchAprj00000Login(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_LOGIN_PAGE);

        Zcom99030Model param = new Zcom99030Model();
        getParameter(request, param);

        
        // 파라미터에 cesId가 없는 경우.. 여기서는 로그인 화면 최초진입으로 판단.
        if ( StringUtil.isNull(param.getUserId()) ) {
            return modelAndView;
        }
        
        
        Zcom99030Model result = serviceZcom99030.srchZcom99030(param);
        
        
        // 사용자ID 오류
        if ( result == null ) {
        	AprjMessage.setMsg(modelAndView, "warn.common.login.fail.empty");
            return returnResponse(modelAndView);
        }

        // 비밀번호 오류
//        if ( !param.getUserPwdSha256().equals(result.getUserPwd()) ) {
//        	ZcomMessage.setMsg(modelAndView, "warn.common.login.fail.pwd");
//            return returnResponse(modelAndView);
//        }

        
        if ( !setUser(request, modelAndView, result) ) {
            return returnResponse(modelAndView);
        }

        modelAndView.addObject("home", ActionConstants_Aprj.ACTION_HOME);
//        if ( StringUtil.isNull(result.getPwdUpdtDt()) ) {
//        	AprjMessage.setMsg(modelAndView, "warn.common.login.pwd.change");
//            modelAndView.addObject("home", ActionConstants_Aprj.ACTION_ZCOM99030_50);
//        }

        return returnResponse(modelAndView);
    }


    /**
     * 공통_임시로그인
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return returnResponse(modelAndView) ModelAndView객체
     * @CommonException CommonException 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_TEMP_LOGIN)
    public @ResponseBody Object srchAprj00000TempLogin(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_LOGIN_PAGE);

        Zcom99040Model param = new Zcom99040Model();
        getParameter(request, param);
        
        Zcom99040Model result = serviceZcom99040.srchZcom99040(param);
        
        
        // 사용자ID 오류
        if ( result == null ) {
        	AprjMessage.setMsg(modelAndView, "warn.common.login.fail.empty");
            return returnResponse(modelAndView);
        }

        
        // 유효기간경과
        String currDt = DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
        if ( currDt.compareTo(result.getEffStaDt()) < 0 ) {
        	AprjMessage.setMsg(modelAndView, "warn.common.login.fail.eff");
            return returnResponse(modelAndView);
        }

        if ( currDt.compareTo(result.getEffEndDt()) > 0 ) {
        	AprjMessage.setMsg(modelAndView, "warn.common.login.fail.eff");
            return returnResponse(modelAndView);
        }

        
        // 사용자로그인
        Zcom99030Model paramZcom99030 = new Zcom99030Model();
        
//        paramZcom99030.setUserId(result.getUserId());
//        paramZcom99030 = serviceZcom99030.srchZcom99030(paramZcom99030);
        
        if ( !setUser(request, modelAndView, paramZcom99030) ) {
            return returnResponse(modelAndView);
        }

        modelAndView.addObject(resultObject , result);
        
        modelAndView.setViewName(ViewConstants_Aprj.VIEW_TEMP_LOGIN_PAGE);
        return returnResponse(modelAndView);
    }


    public boolean setUser(HttpServletRequest request, ModelAndView modelAndView, Zcom99030Model result) throws CommonException {
    	
        if ( result == null || StringUtil.isNull(result.getEffStaDt()) || StringUtil.isNull(result.getEffEndDt()) ) {
        	AprjMessage.setMsg(modelAndView, "warn.common.login.fail.eff");
            return false;
        }

        // 유효기간경과
        String currDt = DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
        if ( currDt.compareTo(result.getEffStaDt()) < 0 ) {
        	AprjMessage.setMsg(modelAndView, "warn.common.login.fail.eff");
            return false;
        }

        if ( currDt.compareTo(result.getEffEndDt()) > 0 ) {
        	AprjMessage.setMsg(modelAndView, "warn.common.login.fail.eff");
            return false;
        }
        
    	
        if ( !ApplicationConstants_Aprj.USER_AUTH_ADMIN.equals(result.getUserAuthCd()) ) {
            // 관리자가 아닌 경우 session time out을 30분으로 설정.
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval((24 * 60 * 60) / 2);
        } else {
            // 관리자인 경우 session time out을 8시간으로 설정.
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(24 * 60 * 60);
        }
        
        sessionUser = result;
//        sessionUser.setSrchCoId(result.getCoId());
//        sessionUser.setSrchCoNm(result.getCoNm());
        
        String ip = request.getRemoteAddr();
        sessionUser.setRgstIp(ip);
        sessionUser.setUpdtIp(ip);
        
        setLogin(request, modelAndView);
        serviceZcom99030.updateZcom99030LastLoginDtm(result);
        
        return true;
    }
    
    
    
    
    /**
     * 공통_로그아웃
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return returnResponse(modelAndView) ModelAndView객체
     * @CommonException CommonException 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_LOGOUT)
    public @ResponseBody Object srchAprj00000Logout(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        removeLogin(request);

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_LOGIN_PAGE);
        return returnResponse(modelAndView);
    }
    
    
}