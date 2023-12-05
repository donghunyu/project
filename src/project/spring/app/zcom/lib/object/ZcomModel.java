package project.spring.app.zcom.lib.object;

public class ZcomModel extends CommonModel {
	
	public ZcomModel() {
		super();
	}

    private String srchGrpCoId                   ;    /* 검색그룹사 ID                  */
    private String srchGrpCoNm                   ;    /* 검색그룹사 명                  */
			 
    private String grpCoId                       ;    /* 그룹사 ID                      */
    private String grpCoNm                       ;    /* 그룹사 명                      */
    
    
	public String getSrchGrpCoId() {
		return srchGrpCoId;
	}
	
	public void setSrchGrpCoId(String srchGrpCoId) {
		this.srchGrpCoId = srchGrpCoId;
	}

	public String getSrchGrpCoNm() {
		return srchGrpCoNm;
	}

	public void setSrchGrpCoNm(String srchGrpCoNm) {
		this.srchGrpCoNm = srchGrpCoNm;
	}

	public String getGrpCoId() {
		return grpCoId;
	}

	public void setGrpCoId(String grpCoId) {
		this.grpCoId = grpCoId;
	}

	public String getGrpCoNm() {
		return grpCoNm;
	}

	public void setGrpCoNm(String grpCoNm) {
		this.grpCoNm = grpCoNm;
	}

}

