package project.spring.app.bacr.lib.object;

import java.net.InetAddress;

import project.spring.app.zcom.lib.object.ZcomModel;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.StringUtil;
import project.spring.app.zcom.model.Zcom99030Model;

public class BacrModel extends ZcomModel implements Cloneable {
	
	public BacrModel() {
		super();
	}
	
	/**************************************************************************
	 * 그룹사코드 추가
	 **************************************************************************/
    private String srchCoId                      ;    /* 검색업체 ID                        */
    private String srchCoNm                      ;    /* 검색업체 명                        */

    private String coId                          ;    /* 업체 ID                        */
    private String coNm                          ;    /* 업체 명                        */
			 
    private String copyCoId                      ;    /* 업체 ID                        */
    private String copyCoNm                      ;    /* 업체 명                        */
			 
    private String delYn                         ;    /* 삭제 여부                      */
    private String workType                      ;    /* 작업 종류                      */

	public String getSrchCoId() {
		return srchCoId;
	}

	public void setSrchCoId(String srchCoId) {
		this.srchCoId = srchCoId;
	}

	public String getSrchCoNm() {
		return srchCoNm;
	}

	public void setSrchCoNm(String srchCoNm) {
		this.srchCoNm = srchCoNm;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getCoNm() {
		return coNm;
	}

	public void setCoNm(String coNm) {
		this.coNm = coNm;
	}

	public String getCopyCoId() {
		return copyCoId;
	}

	public void setCopyCoId(String copyCoId) {
		this.copyCoId = copyCoId;
	}

	public String getCopyCoNm() {
		return copyCoNm;
	}

	public void setCopyCoNm(String copyCoNm) {
		this.copyCoNm = copyCoNm;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}


	/**************************************************************************
	 * 매출년월 설정
	 **************************************************************************/
	private String srchYy   ;     /* 검색매출년           */
	private String srchMm   ;     /* 검색매출월           */
	private String srchDt   ;     /* 검색매출일자         */

	private String saleYy       ;     /* 매출년               */
    private String saleMm       ;     /* 매출월               */
    
    
    public String getSrchYy() {
		return srchYy;
	}

	public void setSrchYy(String srchYy) {
		this.srchYy = srchYy;
	}

	public String getSrchMm() {
		return srchMm;
	}

	public void setSrchMm(String srchMm) {
		try {
			if ( srchMm != null ) {
			    if ( Integer.parseInt(srchMm) < 10 ) {
			    	srchMm = "0" + Integer.parseInt(srchMm);
			    }
			}
		} catch ( Exception e ) {
		}
		this.srchMm = srchMm;
	}
	
	public String getSrchYm() {
		return (this.srchYy == null ? "" : this.srchYy) + (this.srchMm == null ? "" : this.srchMm);
	}

	public String getSrchYmFormat() {
		return DateUtil.getDateFormat(this.srchYy + this.srchMm);
	}

	public void setSrchYm(String srchYm) {
		try {
			srchYm = StringUtil.getNumber(srchYm);
			setSrchYy(srchYm.substring(0, 4));
			setSrchMm(srchYm.substring(4, 6));
		} catch ( Exception e ) {
		}
	}

	
	
	
	public String getSrchDt() {
		return srchDt;
	}

	public void setSrchDt(String srchDt) {
		this.srchDt = StringUtil.getNumber(srchDt);
	}
	
	public String getSrchDtFormat() {
        return DateUtil.getDateFormat(srchDt);
    }
	
	
	

	public String getYy() {
		return saleYy;
	}

	public void setYy(String saleYy) {
		this.saleYy = saleYy;
	}

	public String getMm() {
		return saleMm;
	}

	public void setMm(String saleMm) {
		try {
			if ( saleMm != null ) {
			    if ( Integer.parseInt(saleMm) < 10 ) {
			    	saleMm = "0" + Integer.parseInt(saleMm);
			    }
			}
		} catch ( Exception e ) {
		}
		this.saleMm = saleMm;
	}
	
	public String getYm() {
		return (this.saleYy == null ? "" : this.saleYy) + (this.saleMm == null ? "" : this.saleMm);
	}

	public String getYmFormat() {
		return DateUtil.getDateFormat(this.saleYy + this.saleMm);
	}

	public void setYm(String saleYm) {
		try {
			saleYm = StringUtil.getNumber(saleYm);
			setYy(saleYm.substring(0, 4));
			setMm(saleYm.substring(4, 6));
		} catch ( Exception e ) {
		}
	}


	
	/**************************************************************************
	 * 사용자설정
	 **************************************************************************/
	public void setUser(Zcom99030Model sessionUser)  {
		String currDt = DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMDHMS);
		this.setRgstDtm(currDt);
		this.setUpdtDtm(currDt);

		if ( sessionUser == null ) {
    		return;
		}

		if ( sessionUser.getUserId() != null ) {
			this.setRgstId(sessionUser.getUserId());
			this.setRgstNm(sessionUser.getUserNm());
			this.setUpdtId(sessionUser.getUserId());
			this.setUpdtNm(sessionUser.getUserNm());

//			this.setRgstIp(sessionUser.getRgstIp());
//			this.setUpdtIp(sessionUser.getUpdtIp());
		}

	}

	/**************************************************************************
	 * 사용자설정
	 **************************************************************************/
	public void setBatchUser()  {
		String currDt = DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMDHMS);
		this.setRgstDtm(currDt);
		this.setUpdtDtm(currDt);

		this.setRgstId("BATCH");
		this.setUpdtId("BATCH");

    	try {
	    	InetAddress local = InetAddress.getLocalHost();
	    	this.setRgstIp(local.getHostAddress());
			this.setUpdtIp(local.getHostAddress());
    	} catch ( Exception e ) {
    		
    	}

	}

}

