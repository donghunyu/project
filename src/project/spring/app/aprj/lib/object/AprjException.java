package project.spring.app.aprj.lib.object;

public class AprjException extends Exception {

    private static final long serialVersionUID = 5884045809270197513L;
    
    private String ecode;

    public AprjException() {
	}
	
	public AprjException(String ecode) {
	    this.setEcode(ecode);
    }
	
	public AprjException(Exception e) {
		e.printStackTrace();
	}

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }
}
