package project.spring.app.zcom.lib.object;



import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpSessionCheckingListener implements HttpSessionListener {

	private Log logger = LogFactory.getLog(getClass());

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		String text = "Session ID:".concat(event.getSession().getId()).concat(" created at ").concat(new Date().toString());
		logger.debug(text);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		String text = "Session ID:".concat(event.getSession().getId()).concat(" destroyed at ").concat(new Date().toString());
		logger.debug(text);
	}
}
