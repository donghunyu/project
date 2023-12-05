package project.spring.app.zcom.lib.object;



import java.lang.reflect.Method;

import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.StringUtil;

public class CommonModel {
	
	protected String groupPageCnt = "10";    /* 페이지 그룹내 페이지 수   */
	protected String pageRowCnt   = "10";    /* 페이지 페이지내 레코드 수 */
	protected String pageNo       = "1" ;    /* 페이지 페이지 번호        */
	protected String totCnt       = "0" ;    /* 페이지 총건수             */
	protected String rowNum             ;    /* ROW 번호                  */
	protected String strRowNum          ;    /* Mysql Page 시작번호       */
    
	protected String rgstIp       ;     /* 등록 IP          */
	protected String rgstId       ;     /* 등록 ID          */
	protected String rgstNm       ;     /* 등록 명          */
	protected String rgstDtm      ;     /* 등록 일시        */
	protected String updtIp       ;     /* 수정 IP          */
	protected String updtId       ;     /* 수정 ID          */
	protected String updtNm       ;     /* 수정 명          */
	protected String updtDtm      ;     /* 수정 일시        */
    
	protected String effStaDt     ;     /* 유효시작일자     */
	protected String effEndDt     ;     /* 유효종료일자     */
	
	
	// 검색일자관련 변수.. 시작.
	protected String srchDt       ;     /* 검색일자               */
	protected String srchStaDt    ;     /* 검색시작일자           */
	protected String srchEndDt    ;     /* 검색종료일자           */
	
	protected String srchStaHh    ;     /* 검색시작시각           */
	protected String srchEndHh    ;     /* 검색종료시각           */
	// 검색일자관련 변수.. 끝.
    
	
	
	/**************************************************************************
	 * 페이지설정
	 **************************************************************************/
	public String getGroupPageCnt() {
		return groupPageCnt;
	}

	public void setGroupPageCnt(String groupPageCnt) {
		this.groupPageCnt = groupPageCnt;
	}

	public String getPageRowCnt() {
		return pageRowCnt;
	}

	public int getPageRowCntInt() {
		try {
			return Integer.parseInt(pageRowCnt);
		} catch ( Exception e ) {
			
		}
		return 0;
	}

	public void setPageRowCnt(String pageRowCnt) {
		this.pageRowCnt = pageRowCnt;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getTotCnt() {
		return totCnt;
	}

	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}

	public String getRowNum() {
		return rowNum;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	public int getStrRowNum() {
		try {
			return (Integer.parseInt(getPageNo()) - 1) * Integer.parseInt(getPageRowCnt());
		} catch ( Exception e ) {
			
		}
		return 0;
	}

	public void setStrRowNum(String strRowNum) {
		this.strRowNum = strRowNum;
	}

	/**************************************************************************
	 * 사용자설정
	 **************************************************************************/
	
	public String getRgstIp() {
		return rgstIp;
	}

	public void setRgstIp(String rgstIp) {
		this.rgstIp = rgstIp;
	}

	public String getRgstId() {
		return rgstId;
	}

	public void setRgstId(String rgstId) {
		this.rgstId = rgstId;
	}

	public String getRgstNm() {
		return rgstNm;
	}

	public void setRgstNm(String rgstNm) {
		this.rgstNm = rgstNm;
	}

	public String getRgstDtm() {
		return rgstDtm;
	}

	public void setRgstDtm(String rgstDtm) {
		this.rgstDtm = rgstDtm;
	}

	public String getRgstDtmFormat() {
		return DateUtil.getDateFormat(rgstDtm);
	}
	
	public String getUpdtIp() {
		return updtIp;
	}

	public void setUpdtIp(String updtIp) {
		this.updtIp = updtIp;
	}

	public String getUpdtId() {
		return updtId;
	}

	public void setUpdtId(String updtId) {
		this.updtId = updtId;
	}

	public String getUpdtNm() {
		return updtNm;
	}

	public void setUpdtNm(String updtNm) {
		this.updtNm = updtNm;
	}

	public String getUpdtDtm() {
		return updtDtm;
	}

	public void setUpdtDtm(String updtDtm) {
		this.updtDtm = updtDtm;
	}

	public String getUpdtDtmFormat() {
		return DateUtil.getDateFormat(updtDtm);
	}
	
	
	/**************************************************************************
	 * 유효기간
	 **************************************************************************/
	public String getEffStaDt() {
		return effStaDt;
	}

	public void setEffStaDt(String effStaDt) {
		this.effStaDt = StringUtil.getNumber(effStaDt);
	}

	public String getEffEndDt() {
		return effEndDt;
	}

	public void setEffEndDt(String effEndDt) {
		this.effEndDt = StringUtil.getNumber(effEndDt);
	}

	public String getEffStaDtFormat() {
		return DateUtil.getDateFormat(effStaDt);
	}

	public String getEffEndDtFormat() {
		return DateUtil.getDateFormat(effEndDt);
	}

	public String getEffDt() {
		return DateUtil.getDateFormat(effStaDt) + " ~ " + DateUtil.getDateFormat(effEndDt);
	}
	
	
	/**************************************************************************
     * 검색기간
     **************************************************************************/
    public String getSrchDt() {
		return srchDt;
	}

	public void setSrchDt(String srchDt) {
		this.srchDt = StringUtil.getNumber(srchDt);
	}

    public String getSrchStaDt() {
        return srchStaDt;
    }

	public void setSrchStaDt(String srchStaDt) {
        this.srchStaDt = StringUtil.getNumber(srchStaDt);
    }

	public String getSrchEndDt() {
        return srchEndDt;
    }

    public void setSrchEndDt(String srchEndDt) {
        this.srchEndDt = StringUtil.getNumber(srchEndDt);
    }

    public String getSrchDtFormat() {
    	return DateUtil.getDateFormat(srchDt);
    }
    
    public String getSrchStaDtFormat() {
        return DateUtil.getDateFormat(srchStaDt);
    }

    public String getSrchEndDtFormat() {
        return DateUtil.getDateFormat(srchEndDt);
    }
    
    public String getSrchStaHh() {
		return srchStaHh;
	}

	public void setSrchStaHh(String srchStaHh) {
		this.srchStaHh = srchStaHh;
	}

	public String getSrchEndHh() {
		return srchEndHh;
	}

	public void setSrchEndHh(String srchEndHh) {
		this.srchEndHh = srchEndHh;
	}

    /**************************************************************************
     * Model value 인쇄
     **************************************************************************/
	public void println() {
		try {
			Method[] methods = this.getClass().getMethods();
			
			System.out.println("***************************************************************************");
			System.out.println(this.getClass().getSimpleName() + " METHOD VALUE[METHOD CNT : " + methods.length + "]");
			System.out.println("***************************************************************************");
			for ( int j = 0; j < methods.length; j++ ) {
				if ( !methods[j].getName().startsWith("get") ) {
					continue;
				}
				System.out.println(methods[j].getName() + " : [" + methods[j].invoke(this) + "]");
			}
			System.out.println("***************************************************************************");

		} catch ( Exception e ) {
			e.printStackTrace();
		}
    }
	
    /***************************************************************************
    *  복사본 생성
    ***************************************************************************/
    public CommonModel clone() {
    	CommonModel newCommonModel = new CommonModel();
        try {
        	newCommonModel = (CommonModel) super.clone();
        } catch ( Exception e ) {
        	e.printStackTrace();
        }
        
        return newCommonModel;
    }
    
    
}

