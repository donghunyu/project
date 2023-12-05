/*-------------------------------------------------------------------
* NAME   : Zcom99040Controller
* DESC   : 관리자_임시로그인
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
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.schedule.Aprj20030AutoOpSchedule;
import project.spring.app.aprj.schedule.Aprj20051UserMailSchedule;
import project.spring.app.aprj.schedule.Aprj20053SignMailSchedule;
import project.spring.app.aprj.service.Aprj20034Service;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.object.ZcomController;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.SendMail;
import project.spring.app.zcom.lib.util.StringUtil;
import project.spring.app.zcom.model.Zcom99040Model;
import project.spring.app.zcom.service.Zcom99040Service;


@Controller
public class Zcom99040Controller extends ZcomController {

    @Autowired
    Aprj20034Service serviceAprj20034;

    @Autowired
    Zcom99040Service serviceZcom99040;

    @Autowired
    Aprj20030AutoOpSchedule autoOpSchedule;
    
    @Autowired
    Aprj20051UserMailSchedule userSchedule;
    
    @Autowired
    Aprj20053SignMailSchedule signSchedule;
    
    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 관리자_임시로그인리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99040_40)
    public @ResponseBody Object srchZcom99040List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Zcom99040Model param = new Zcom99040Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceZcom99040.srchZcom99040List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99040.srchZcom99040Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99040_40);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_임시로그인조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99040_41)
    public @ResponseBody Object srchZcom99040(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99040Model param = new Zcom99040Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceZcom99040.srchZcom99040(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_ZCOM99040_41);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_임시로그인리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99040_50)
    public @ResponseBody Object srchZcom99040UserList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        userSchedule.srchAprj20030UserList();
        
        modelAndView = (ModelAndView) srchZcom99040List(request);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_임시로그인리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99040_51)
    public @ResponseBody Object srchZcom99040SignList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        signSchedule.srchAprj20030SignList();
        
        modelAndView = (ModelAndView) srchZcom99040List(request);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_임시로그인리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99040_52)
    public @ResponseBody Object srchZcom99040AutoOpList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        autoOpSchedule.srchAprj20030AutoOpList();
        
        modelAndView = (ModelAndView) srchZcom99040List(request);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_임시로그인저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99040_00)
    public @ResponseBody Object saveZcom99040(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }
        
        Zcom99040Model param = new Zcom99040Model();
        getParameter(request, param);

//        if ( StringUtil.isNull(param.getTmpLoginId()) ) {
//	        UUID uuid = UUID.randomUUID();
//	        param.setTmpLoginId(uuid.toString());
//        }
        
        int cnt = 0;
        cnt = serviceZcom99040.saveZcom99040(param);

        modelAndView = (ModelAndView) srchZcom99040List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_임시로그인저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99040_01)
    public @ResponseBody Object saveZcom99040ReqUser(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Aprj20030Model temp = new Aprj20030Model();
        getParameter(request, temp);
        
        temp.setPageRowCnt("99999");
        List<Aprj20030Model> userList = serviceAprj20034.srchAprj20034GroupList(temp);
        
        
        String reqUrl = ApplicationConstants_Aprj.getDomain() + "/aprj20051_40.do?";
        String url    = ApplicationConstants_Aprj.getDomain() + ActionConstants_Aprj.ACTION_TEMP_LOGIN + "?tmpLoginId=";
        String scrUrl = "";
        UUID uuid;
        
        Zcom99040Model param = new Zcom99040Model();
    	SendMail sendMail = new SendMail();
        
        for ( int i = 0; i < userList.size(); i++ ) {
        	temp = userList.get(i);
        	
        	if ( StringUtil.isNull(temp.getMailAddr()) ) {
        		continue;
        	}
        	
        	scrUrl = reqUrl + "coId="       + temp.getCoId     ()
        			        + "&opId="      + temp.getOpId     ()
        			        + "&opSerNum="  + temp.getOpSerNum ()
        			        + "&opChrgId="  + temp.getOpChrgId ()
        			        + "&userId="    + temp.getUserId   ()
	                        + "&resSerNum=" + temp.getResSerNum();
        	
        	// 메일보내기
        	try {
        		System.out.println(temp.getMailAddr());
            	uuid = UUID.randomUUID();
            	sendMail.sendMail(temp.getMailAddr(), "작업요청 메일", url + uuid.toString ());
            	
            	// 임시로그인 정보 저장
//            	param.setTmpLoginId(uuid.toString ());
//            	param.setUserId    (temp.getUserId());
//            	param.setScrUrl    (scrUrl          );
//            	param.setEffStaDt  (DateUtil.getCurrentDate("yyyyMMdd"));
//            	param.setEffEndDt  (DateUtil.getAddDate(param.getEffStaDt(), 7));
//            	param.setUser(sessionUser);
            	
            	serviceZcom99040.insertZcom99040(param);
        	} catch ( Exception e ) {
        		e.printStackTrace();
        	}
        }

        modelAndView = (ModelAndView) srchZcom99040List(request);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_임시로그인삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_ZCOM99040_80)
    public @ResponseBody Object deleteZcom99040(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Zcom99040Model param = new Zcom99040Model();
        for ( int i = 0; i < delKeys.length; i++ ) {
//            param.setTmpLoginId(delKeys[i]);

            cnt =+ serviceZcom99040.deleteZcom99040(param);
        }

        modelAndView = (ModelAndView) srchZcom99040List(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}