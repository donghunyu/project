package project.spring.app.zcom.lib.object;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

public class CommonController {

	
	protected Log    logger      = LogFactory.getLog(getClass());
	
    /**************************************************************************
     *  modelAndView 설정
    **************************************************************************/
	public void setModelAndView(HttpServletRequest request, ModelAndView modelAndView) {
		logger.info("*******************************[ INPUT DataSet(Http) START ]********************************");

		Enumeration<String> eParameterNames = request.getParameterNames();
				
		String      sParaName  = "";
		while ( eParameterNames.hasMoreElements() ) {
			sParaName = eParameterNames.nextElement();
			
			String[]  aParaValue = request.getParameterValues(sParaName);
			for ( int i = 0; i < aParaValue.length; i++ ) {
				logger.info(sParaName + " : [" + aParaValue[i] + "]");
			}
			
			if ( aParaValue.length == 1 ) {
				modelAndView.addObject(sParaName, aParaValue[0]);
				continue;
			}
	
			if ( aParaValue.length > 1 ) {
				modelAndView.addObject(sParaName, aParaValue);
				continue;
			}
		}

		logger.info("*******************************[ INPUT DataSet(Http) END ]********************************");
	}

    /**************************************************************************
     *  getParameter
     **************************************************************************/
    public String getParameter(HttpServletRequest request, String paraName) {
    	if ( request.getParameter(paraName) == null ) {
    		return getAttribute(request, paraName);
    	}

    	return (String) request.getParameter(paraName);
    }

    
    /**************************************************************************
     *  getAttribute
     **************************************************************************/
    public String getAttribute(HttpServletRequest request, String paraName) {
    	if ( request.getAttribute(paraName) == null ) {
    		return "";
    	}

    	return (String) request.getAttribute(paraName);
    }

	/*************************************************************************
	 * getObject
    **************************************************************************/
	public Object getObject(ModelAndView modelAndView, String paramName) {
		return modelAndView.getModel().get(paramName.trim());
	}

	public String getString(ModelAndView modelAndView, String paramName) {
		try {
			if ( modelAndView.getModel().get(paramName.trim()) == null ) {
				return "";
			}
			return (String) modelAndView.getModel().get(paramName.trim());
		} catch ( Exception e ) {
			return "";
		}
	}
	
	public int getInt(ModelAndView modelAndView, String paramName)	{
		try {
			return Integer.parseInt((String) modelAndView.getModel().get(paramName.trim()));
		} catch ( Exception e ) {
			return 0;
		}
	}
	
	public double getDouble(ModelAndView modelAndView, String paramName) {
		try {
			return Double.parseDouble((String) modelAndView.getModel().get(paramName.trim()));
		} catch ( Exception e ) {
			return 0;
		}
	}
	
	public ArrayList<String> getArray(HttpServletRequest request, String paramName) {
		try {
			String[]  aParaValue = request.getParameterValues(paramName.trim());
			if ( aParaValue == null ) return null;

			ArrayList<String> alList = new ArrayList<String>();
			for ( int i = 0; i < aParaValue.length; i++ ) {
				alList.add(aParaValue[i]);
			}
			
			return alList;
		} catch ( Exception e ) {
			return null;
		}
	}
	
	public void setObject(HttpServletRequest request, ModelAndView modelAndView, CommonModel model, String paramName, Object paramValue) {
        request     .setAttribute(paramName, paramValue);
        modelAndView.addObject   (paramName, paramValue);
		try {
	        setValue   (model, paramName, paramValue);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
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
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public void setValue(Object model, String attrNm, Object value) {
		try {
			String methodNm = "set" + attrNm.substring(0, 1).toUpperCase() + attrNm.substring(1);
			Method method = model.getClass().getMethod(methodNm, String.class);
			method.invoke(model, value);
		} catch ( Exception e ) {

		}
	}
}

