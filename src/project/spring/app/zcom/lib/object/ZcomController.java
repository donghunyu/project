package project.spring.app.zcom.lib.object;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.bacr.constants.ViewConstants_Bacr;
import project.spring.app.zcom.constants.ApplicationConstants_Zcom;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.StringUtil;
import project.spring.app.zcom.model.Zcom99010Model;
import project.spring.app.zcom.model.Zcom99020Model;
import project.spring.app.zcom.model.Zcom99030Model;
import project.spring.app.zcom.service.Zcom99011Service;
import project.spring.app.zcom.service.Zcom99020Service;
import project.spring.app.zcom.service.Zcom99030Service;

public class ZcomController extends CommonController {
	
    @Autowired
    protected Zcom99011Service serviceZcom99011;

    @Autowired
    protected Zcom99020Service serviceZcom99020;

    @Autowired
    protected Zcom99030Service serviceZcom99030;


    protected Map<String, Object> empthMap = new HashMap<>();

    protected final String pageNo           = "pageNo";
    protected final String pageRowCnt       = "pageRowCnt";
    protected final String grpPageCnt       = "grpPageCnt";
    protected final String pageYn           = "pageYn";

    protected final String initPageNo       = "1";
    protected final String initPageRowCnt   = "10";
    protected final String initGrpPageCnt   = "10";

    protected final String topMenuList      = "topMenuList";
    protected final String naviMenu         = "naviMenu";

    protected Zcom99030Model sessionUser    = null;
    
    /**************************************************************************
     *  초기화작업
     **************************************************************************/
    public void init(HttpServletRequest request, ModelAndView modelAndView) throws CommonException {

        String[] url   = request.getRequestURI().split("/");
        String[] actId = url[url.length - 1].split(".do");
        modelAndView.addObject("execActId", actId[0] + ".do");

        setPaging      (modelAndView);
        setModelAndView(request, modelAndView);
		if ( request.getParameter("newPage") != null ) {
    		modelAndView.addObject(pageNo    , initPageNo    );
    	}
    }

    /**************************************************************************
     *  페이지기본값 설정
     **************************************************************************/
    public void setPaging(ModelAndView modelAndView) throws CommonException {
        if ( StringUtil.isNull(modelAndView.getModel().get(pageNo    )) ) { modelAndView.addObject(pageNo    , initPageNo    );}
        if ( StringUtil.isNull(modelAndView.getModel().get(pageRowCnt)) ) { modelAndView.addObject(pageRowCnt, initPageRowCnt);}
        if ( StringUtil.isNull(modelAndView.getModel().get(grpPageCnt)) ) { modelAndView.addObject(grpPageCnt, initGrpPageCnt);}
    }

    /**************************************************************************
     *  메뉴조회
     **************************************************************************/
    public void getMenu(ModelAndView modelAndView) throws CommonException {
    	getMenuList(modelAndView);
    	getNaviMenu(modelAndView);
    }

    /**************************************************************************
     *  TOP메뉴리스트조회
     **************************************************************************/
    public void getMenuList(ModelAndView modelAndView) throws CommonException {
        Zcom99020Model param = new Zcom99020Model();

        param.setUserId    (sessionUser.getUserId    ());
        param.setUserAuthCd(sessionUser.getUserAuthCd());

        modelAndView.addObject(topMenuList, serviceZcom99020.srchZcom99020TopMenuList(param));
    }

    /**************************************************************************
     *  네이게이터리스트조회
     **************************************************************************/
    public void getNaviMenu(ModelAndView modelAndView) throws CommonException {
        Zcom99020Model param = new Zcom99020Model();
        
        param.setSelMenuId((String) modelAndView.getModel().get("selMenuId"));

        modelAndView.addObject(naviMenu, serviceZcom99020.srchZcom99020NaviMenu(param));
    }

    /**************************************************************************
     *  공통코드조회
     **************************************************************************/
    public List<Zcom99010Model> getGrpCdList(String grpCd) throws CommonException {
        Zcom99010Model param = new Zcom99010Model();
        param.setGrpCd     (grpCd  );

        return serviceZcom99011.srchZcom99011List(param);
    }

    /**************************************************************************
     *  사용자정보
     **************************************************************************/
    public void setLogin(HttpServletRequest request, ModelAndView modelAndView) throws CommonException {
        request.getSession().setAttribute("sessionUser", sessionUser);
        modelAndView.addObject("sessionUser", sessionUser);
    }
    
    /**************************************************************************
     *  사용자정보
     **************************************************************************/
    public boolean isLogin(HttpServletRequest request, ModelAndView modelAndView) throws CommonException {
    	return isLogin(request, modelAndView, true);
    }

    /**************************************************************************
     *  사용자정보
     **************************************************************************/
    public boolean isLogin(HttpServletRequest request, ModelAndView modelAndView, boolean isMenu) throws CommonException {
        try {
            // session에서 유저정보 취득.
            sessionUser = getLogin(request);

            if ( sessionUser == null ) {
            	ZcomMessage.setMsg(modelAndView, "warn.common.session.empty");
                modelAndView.setViewName(ViewConstants_Bacr.VIEW_LOGOUT);
                return false;
            }

            // 호출 URL 체크
            if ( isMenu ) {
            	getMenu(modelAndView);
            }
            
            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    /**************************************************************************
     *  사용자정보
     **************************************************************************/
    public Zcom99030Model getLogin(HttpServletRequest request) throws CommonException {
        try {
            HttpSession session = request.getSession();

            if ( session == null ) {
                return null;
            }

            if ( session.getAttribute("sessionUser") == null ) {
                return null;
            }

            // 사용자 정보 가져오기
            return (Zcom99030Model) session.getAttribute("sessionUser");
        } catch ( Exception e ) {
            return null;
        }
    }

    /**************************************************************************
     *  사용자정보삭제
     **************************************************************************/
    public void removeLogin(HttpServletRequest request) throws CommonException {

        try {
            HttpSession session = request.getSession();
            if ( session != null ) {
                session.removeAttribute("sessionUser" );
            }
        } catch ( Exception e ) {
            return;
        }
    }

    /**************************************************************************
     *  접속로그입력
     **************************************************************************/
    public void insertConnInfo(HttpServletRequest request) {
        try {
            if ( request.getAttribute("isInsertConnInfo") != null ) {
                return;
            }

            // localhost 혹은 127.0.0.1로 접속 (개발용 로컬서버)하는 경우 접속이력입력 안함.
            String requestURL = request.getRequestURL().toString();
            if (requestURL.indexOf("localhost") > 0 || requestURL.indexOf("127.0.0.1") > 0) {
                return;
            }

//            String actId     = requestURL.substring(requestURL.lastIndexOf("/") + 1);
//	        if (actId != null && "sem00000_90.do".equals(actId)) {
//	            return;
//	        }
/*
            Zcom99031Model param = new Zcom99031Model();

            param.setSysClCd(request.getSession().getAttribute("selSysClCd").toString().trim());
            //param.setSysClCd   (getParameter(request, "selSysClCd"));
            param.setMenuId    (getParameter(request, "selMenuId" ));
            param.setActId     (actId                      );
            param.setUserNum   (sessionUser.getUserNum   ());
            param.setGrpCoCd   (sessionUser.getGrpCoCd   ());
            param.setUserId    (sessionUser.getUserId    ());
            param.setUserNm    (sessionUser.getUserNm    ());
            param.setUserAuthCd(sessionUser.getUserAuthCd());
            param.setConnDevcNm(request.getHeader("User-Agent"));
            param.setConnDevcIp(request.getRemoteAddr ());
            param.setSvrIp     (inet   .getHostAddress());

            serviceZcom99031.insertZcom99031(param);
            request.setAttribute("isInsertConnInfo", true);
*/
        } catch ( Exception e ) {
            e.printStackTrace();
            return;
        }
    }


    /**************************************************************************
     *  필수항목 체크
     **************************************************************************/
    public void addMandatoryField(String name, String value) {
    	empthMap.put(name, value);
    }

    /**************************************************************************
     *  필수항목 체크
     **************************************************************************/
    public boolean isMandatoryField(ModelAndView modelAndView) {
    	boolean result = false;

    	String msgCd  = "warn.common.mandatory.field";
	    String msgCtt = "";

	    String[] temp = new String[1];

	    Iterator<String> iterator = empthMap.keySet().iterator();
	    while ( iterator.hasNext() ) {
	    	temp[0] = (String) iterator.next();
	    	if ( StringUtil.isNull(empthMap.get(temp[0])) ) {
	    		msgCtt = msgCtt + ZcomMessage.getMsg(msgCd, temp) + "\n";
	    //				msgCtt = msgCtt + messageSourceAccessor.getMessage(msgCd, temp) + "\n";
    		}
    	}

    	if ( !StringUtil.isNull(msgCtt) ) {
    		msgCtt = msgCtt.substring(0, msgCtt.length() - 1);
    		modelAndView.addObject(ApplicationConstants_Zcom.MESSAGE_CODE, msgCd );
    		modelAndView.addObject(ApplicationConstants_Zcom.MESSAGE_CTT , msgCtt);
    		result = true;
    	}

    	empthMap.clear();
    	return result;
    }


	/**************************************************************************
     *  파라미터를 객체로 넣기
     **************************************************************************/
	public void getParameter(HttpServletRequest request, Object model) {
		try {
			Enumeration<String> eParameterNames = request.getParameterNames();
			
			String      paramName  = "";
			while ( eParameterNames.hasMoreElements() ) {
				paramName = eParameterNames.nextElement();
				
				String[]  paramValues = request.getParameterValues(paramName);
				if ( paramValues.length == 1 ) {
					setValue(model, paramName, paramValues[0]);
					continue;
				}
		
				if ( paramValues.length > 1 ) {
					setValue(model, paramName, paramValues);
					continue;
				}
			}
			
			if ( request.getParameter("newPage") != null ) {
				setValue(model, "pageNo", "1");
			}
			
			
//			((ZcomModel) model).setUser(sessionUser);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	

    /**************************************************************************
     *  파라미터를 객체로 넣기
     **************************************************************************/
    public List<ZcomModel> getParameterArray(HttpServletRequest request, ZcomModel model) {

        List<ZcomModel> modelList = new ArrayList<ZcomModel>();

    	List<String> fieldList = new ArrayList<String>();
    	Method[] methods = model.getClass().getMethods();
    	String field = "";

	    int rows = 0;
	    for ( int j = 0; j < methods.length; j++ ) {
	    	if ( !methods[j].getName().startsWith("set") ) {
	    		continue;
	    	}

	    	field = methods[j].getName().substring(3, 4).toLowerCase() +  methods[j].getName().substring(4);
	    	String[] paramValues = request.getParameterValues(field);

	    	if ( paramValues == null ) {
	    		continue;
	    	}

	    	fieldList.add(field);
	    	if ( paramValues.length > rows ) {
	    		rows = paramValues.length;
	    	}
	    }

	    Method method;
        for ( int i = 0; i < rows; i++ ) {
        	ZcomModel rowModel = new ZcomModel();

	    	for ( int j = 0; j < fieldList.size(); j++ ) {
	    		field = fieldList.get(j);

	    		System.out.println(field);

	    		String[] paramValues = request.getParameterValues(field);

	    		try {
	    			if ( paramValues == null ) {continue;}

	    			method = rowModel.getClass().getMethod("set" + field.substring(0, 1).toUpperCase() + field.substring(1), String.class);

					if ( paramValues.length <= i + 1 ) {
						method.invoke(rowModel, paramValues[paramValues.length - 1]);
		    			continue;
					}

	    				method.invoke(rowModel, paramValues[i]);
				} catch ( Exception e ) {
					e.printStackTrace();
				}
	    	}

	    	modelList.add(rowModel);
    	}

    	return modelList;
    }

    
	/**************************************************************************
     *  파라미터를 객체로 넣기
     **************************************************************************/
	@SuppressWarnings("hiding")
	public <T> Object toBean(HttpServletRequest request, Class<T> clazz) {
		try {
			Object object = clazz.newInstance();
			Enumeration<String> eParameterNames = request.getParameterNames();
			
			String paramName  = "";
			while ( eParameterNames.hasMoreElements() ) {
				paramName = eParameterNames.nextElement();
				
				String[]  paramValues = request.getParameterValues(paramName);
				if ( paramValues.length == 1 ) {
					setValue(object, paramName, paramValues[0]);
					continue;
				}
		
				if ( paramValues.length > 1 ) {
					setValue(object, paramName, paramValues);
					continue;
				}
			}
			
			if ( request.getParameter("newPage") != null ) {
				setValue(object, "pageNo", "1");
			}
			
//			((ZcomModel) model).setUser(sessionUser);
			return object;
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}
	



    /**************************************************************************
     *  검색년월설정
     **************************************************************************/
    public void setDate(HttpServletRequest request, ModelAndView modelAndView, ZcomModel model) {
    	setDate(request, modelAndView, model, 0, false);
    }

    public void setDate(HttpServletRequest request, ModelAndView modelAndView, ZcomModel model, int addDt) {
    	setDate(request, modelAndView, model, addDt, false);
    }

    public void setDate(HttpServletRequest request, ModelAndView modelAndView, ZcomModel model, int addDt, boolean oneDay) {
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
		    if ( ApplicationConstants_Zcom.RESPONSE_DATA_TYPE_JSON.equals(modelAndView.getModel().get(ApplicationConstants_Zcom.RESPONSE_TYPE)) ) {
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
    		if ( ApplicationConstants_Zcom.RESPONSE_DATA_TYPE_XML.equals(modelAndView.getModel().get(ApplicationConstants_Zcom.RESPONSE_TYPE)) ) {
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

