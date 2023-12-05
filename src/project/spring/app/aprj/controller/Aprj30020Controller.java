/*-------------------------------------------------------------------
* NAME   : Aprj30020Controller
* DESC   : 보고서_업무 현황
* Author : 
* DATE   : 2018-11-20
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
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.aprj.service.Aprj30020Service;
import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Aprj30020Controller extends AprjController {

    @Autowired
    Aprj30020Service serviceAprj30020;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수

    private String cyclClCdList                   = "cyclClCdList"                ;  // 주기 구분 코드리스트          
    private String autoClCdList                   = "autoClCdList"                ;  // 자동 구분 코드리스트          
    private String tranStCdList                   = "tranStCdList"                ;  // 처리 상태 코드리스트          
    private String userAuthCdList                 = "userAuthCdList"              ;  // 사용자 권한 코드리스트        
    /**
     * 보고서_업무 현황
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_APRJ30020_40)
    public @ResponseBody Object srchAprj30020List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true, true) ) {
            return returnResponse(modelAndView);
        }

        // 자동 구분 코드
        modelAndView.addObject(autoClCdList                  , getGrpCdList(GrpCdConstants_Aprj.AUTO_CL_CD                    ));
        
        // 처리 상태 코드
        modelAndView.addObject(tranStCdList                  , getGrpCdList(GrpCdConstants_Aprj.TRAN_ST_CD                    ));
        
        // 주기 구분 코드
        modelAndView.addObject(cyclClCdList                  , getGrpCdList(GrpCdConstants_Aprj.CYCL_CL_CD                    ));
        
        // 사용자 권한 코드
        modelAndView.addObject(userAuthCdList                , getGrpCdList(GrpCdConstants_Aprj.USER_AUTH_CD                  ));

        // 업무
        Aprj20030Model param = new Aprj20030Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceAprj30020.srchAprj30020List(param));
        modelAndView.addObject(resultListCnt, serviceAprj30020.srchAprj30020Cnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_APRJ30020_40);
        return returnResponse(modelAndView);
    }

}