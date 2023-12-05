package project.spring.app.zcom.lib.object;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.zcom.constants.ApplicationConstants_Zcom;


@Component
public class ZcomMessage {
	
    private static MessageSourceAccessor messageSourceAccessor;
	
	@Autowired(required=true)
	public void setMessageSourceAccessor(MessageSourceAccessor msAcc){
		messageSourceAccessor = msAcc;
	}
	
	/**************************************************************************
     *  메시지설정
    **************************************************************************/
	public static String getMsg(String msgCd, String[] args) {
		String msgCtt = "";
		
		try {
			msgCtt = messageSourceAccessor.getMessage(msgCd, args);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return msgCtt;
	}
	
	
    /**************************************************************************
     *  메시지설정
    **************************************************************************/
    public static void setMsg(ModelAndView modelAndView, String msgCd) {
        String[] args = new String[1];

        setMsg(modelAndView, msgCd, args);
    }


    /**************************************************************************
     *  메시지설정
    **************************************************************************/
    public static void setMsg(ModelAndView modelAndView, String msgCd, String arg1) {
        String[] args = new String[1];
        args[0] = arg1;

        setMsg(modelAndView, msgCd, args);
    }


    /**************************************************************************
     *  메시지설정
    **************************************************************************/
    public static void setMsg(ModelAndView modelAndView, String msgCd, String arg1, String arg2) {
        String[] args = new String[2];
        args[0] = arg1;
        args[1] = arg2;

        setMsg(modelAndView, msgCd, args);
    }


    /**************************************************************************
     *  메시지설정
    **************************************************************************/
    public static void setMsg(ModelAndView modelAndView, String msgCd, String[] args) {
        String msgCtt = getMsg(msgCd, args);
  	    modelAndView.addObject(ApplicationConstants_Zcom.MESSAGE_CODE, msgCd );
  	    setMsgCtt(modelAndView, msgCtt);
    }


    /**************************************************************************
     *  메시지설정
    **************************************************************************/
    public static void setMsgCtt(ModelAndView modelAndView, String msgCtt) {
  	    modelAndView.addObject(ApplicationConstants_Zcom.MESSAGE_CTT , msgCtt);
    }

    
  
}
