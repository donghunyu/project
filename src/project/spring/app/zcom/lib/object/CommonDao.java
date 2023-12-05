package project.spring.app.zcom.lib.object;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

public class CommonDao {
	protected Log    logger      = LogFactory.getLog(getClass());


	@Resource(name = "sqlSessionConn")
	protected SqlSession sessionConn;
	
}

