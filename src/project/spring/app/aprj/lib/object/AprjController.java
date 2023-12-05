package project.spring.app.aprj.lib.object;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.object.ZcomController;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.StringUtil;

public class AprjController extends ZcomController {

	public AprjController() {
		super();
	}
	
    public boolean isLogin(HttpServletRequest request, ModelAndView modelAndView, boolean isMenu, boolean isCopy) throws CommonException {
    	
    	return true;
    }

    
    /**************************************************************************
     *  검색업체정보설정
     **************************************************************************/
	public void setCoInfo(HttpServletRequest request, ModelAndView modelAndView, AprjModel model) {
		
	    if ( sessionUser == null ) return;

	    if ( ApplicationConstants_Aprj.USER_AUTH_ADMIN.equals(sessionUser.getUserAuthCd()) ) {
	    	
	    	String srchCoId = getParameter(request, "srchCoId");
	    	String srchCoNm = getParameter(request, "srchCoNm");
	    	
	    	if ( StringUtil.isNull(srchCoId) ) {
		    	srchCoId = getParameter(request, "coId");
		    	srchCoNm = getParameter(request, "coNm");
	    	}

	    	if ( StringUtil.isNull(srchCoId) ) {
		    	srchCoId = sessionUser.getGrpCoId();
		    	srchCoNm = sessionUser.getGrpCoNm();
	    	}

	    	sessionUser.setSrchGrpCoId(srchCoId);
    		sessionUser.setSrchGrpCoNm(srchCoNm);
	    	
	    	setObject(request, modelAndView, model,"srchCoId", sessionUser.getSrchGrpCoId());
	    	setObject(request, modelAndView, model,"srchCoNm", sessionUser.getSrchGrpCoNm());

	    	setObject(request, modelAndView, model,"coId", sessionUser.getSrchGrpCoId());
	    	setObject(request, modelAndView, model,"coNm", sessionUser.getSrchGrpCoNm());
	    } else {
	    	setObject(request, modelAndView, model,"srchCoId", sessionUser.getGrpCoId());
	    	setObject(request, modelAndView, model,"srchCoNm", sessionUser.getGrpCoNm());

	    	setObject(request, modelAndView, model,"coId", sessionUser.getGrpCoId());
	    	setObject(request, modelAndView, model,"coNm", sessionUser.getGrpCoNm());
	    }
	}
	

    /**************************************************************************
     *  검색년월설정
     **************************************************************************/
    public void setDate(HttpServletRequest request, ModelAndView modelAndView, AprjModel model) {
    	setDate(request, modelAndView, model, 0, false);
    }

    public void setDate(HttpServletRequest request, ModelAndView modelAndView, AprjModel model, int addDt) {
    	setDate(request, modelAndView, model, addDt, false);
    }

    public void setDate(HttpServletRequest request, ModelAndView modelAndView, AprjModel model, int addDt, boolean oneDay) {
    	try {
    		String currDt  = DateUtil.getCurrentDate(DateUtil.sDateFormatYMD);
    		String addedDt = DateUtil.getDateFormat (DateUtil.getAddDate(currDt, addDt), DateUtil.sDateFormatYMD);

            modelAndView.addObject   ("currYy", addedDt.subSequence(0,  4));
		    modelAndView.addObject   ("currMm", addedDt.subSequence(5,  7));
		    modelAndView.addObject   ("currDt", addedDt);

		    // 조회일자를 설정한다.
		    String srchDt  = getParameter(request, "srchDt");
		    if (srchDt == null || srchDt.length() == 0) {
		    	srchDt = addedDt;
		    } else if (srchDt.length() == 8) {
		    	srchDt = DateUtil.getDateFormat(srchDt);
		    }
		    setObject(request, modelAndView, model, "srchDt", srchDt);



		    // 조회기간을 설정한다. (시작일:당월1일, 종료일:당일)
		    String  srchStaDt  = getParameter(request, "srchStaDt");
		    String  srchEndDt  = getParameter(request, "srchEndDt");

		    if ( srchStaDt == null || srchStaDt.length() == 0 ) {
		    	if ( oneDay ) {
		          srchStaDt = addedDt;
		    	} else {
		          srchStaDt = addedDt.substring(0, 7) + "-01";
		    	}
		    } else if (srchStaDt.length() == 8) {
		    	srchStaDt = DateUtil.getDateFormat(srchStaDt);
		    }

		    if ( srchEndDt == null || srchEndDt.length() == 0) {
		        srchEndDt = addedDt;
		    } else if (srchEndDt.length() == 8) {
		    	srchEndDt = DateUtil.getDateFormat(srchEndDt);
		    }
		    setObject(request, modelAndView, model, "srchStaDt", srchStaDt);
		    setObject(request, modelAndView, model, "srchEndDt", srchEndDt);


		    
		    // 조회년월을 설정한다.
		    String  srchYy    = getParameter(request, "srchYy"   );
		    String  srchMm    = getParameter(request, "srchMm"   );

		    if ( srchYy == null || srchYy.length() == 0 ) {
		    	srchYy = addedDt.substring(0, 4);
		    }
		    if ( srchMm == null || srchMm.length() == 0) {
		    	srchMm = addedDt.substring(5, 7);
		    }
		    setObject(request, modelAndView, model, "srchYy", srchYy);
		    setObject(request, modelAndView, model, "srchMm", srchMm);

		    
		    if ( srchMm.length() == 1 ) {
		        setObject(request, modelAndView, model, "srchYm", srchYy + "0" + srchMm);
		    } else {
		        setObject(request, modelAndView, model, "srchYm", srchYy + srchMm);
    	    }
		    
    	} catch ( Exception e ) {

    	}
    }

    
    /**************************************************************************
     *  Response Data 생성
     **************************************************************************/
    public Object returnResponse(ModelAndView modelAndView) {
    	try {

		   	/**************************************************************************
		     *  JSON
		     **************************************************************************/
		    if ( ApplicationConstants_Aprj.RESPONSE_DATA_TYPE_JSON.equals(modelAndView.getModel().get(ApplicationConstants_Aprj.RESPONSE_TYPE)) ) {
		    	Set<String> keySet = modelAndView.getModel().keySet();
		    	Iterator<String> keyIterator = keySet.iterator();

		    	Map<String, Object> outerMap = new HashMap<String, Object>();

		    	while ( keyIterator.hasNext() ) {
		    		String key = keyIterator.next();
		    		outerMap.put(key, modelAndView.getModel().get(key));
		    	}

		    	return outerMap;
		    }

		    /**************************************************************************
		     *  XML
		     **************************************************************************/
    		if ( ApplicationConstants_Aprj.RESPONSE_DATA_TYPE_XML.equals(modelAndView.getModel().get(ApplicationConstants_Aprj.RESPONSE_TYPE)) ) {
    			Set<String> keySet = modelAndView.getModel().keySet();
    			Iterator<String> keyIterator = keySet.iterator();

    			Map<String, Object> outerMap = new HashMap<String, Object>();

    			while ( keyIterator.hasNext() ) {
    				String key = keyIterator.next();
    				outerMap.put(key, modelAndView.getModel().get(key));
    			}

    			return outerMap;
    		}

    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}

    	return modelAndView;
    }

}
