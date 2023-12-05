package project.spring.app.zcom.lib.object;

public class CommonException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2951223109391047777L;

	public CommonException() {
    	
    }
    
    public CommonException(String sErrorContent) {
    	super(sErrorContent);
    }
    
    public CommonException(String sErrorCode, String sErrorContent) {

    }

    public CommonException(Exception e) {
    	e.printStackTrace();
    }
}
