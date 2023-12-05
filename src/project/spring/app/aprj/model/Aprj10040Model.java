/*-------------------------------------------------------------------
* NAME   : Aprj10040Model
* DESC   : 설정_업무주기
* DATE   : 2018-11-07
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.model;

import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.zcom.lib.util.DateUtil;

public class Aprj10040Model extends AprjModel {

    private String srchCoId                      ;    /* 검색업체 ID                        */
    private String srchCyclId                    ;    /* 검색주기 코드                      */
    private String srchCyclNm                    ;    /* 검색주기 명                        */
    private String srchPrdCnt                    ;    /* 검색기간 수                        */
    private String srchCyclClCd                  ;    /* 검색주기 구분 코드                 */
    private String srchStdDt                     ;    /* 검색기준 일자                      */
    private String srchStdH                      ;    /* 검색기준 시                        */

    private String coId                          ;    /* 업체 ID                        */
    private String cyclId                        ;    /* 주기 코드                      */
    private String cyclNm                        ;    /* 주기 명                        */
    private String prdCnt                        ;    /* 기간 수                        */
    private String cyclClCd                      ;    /* 주기 구분 코드                 */
    private String cyclClNm                      ;    /* 주기 구분 명                   */
    private String stdDt                         ;    /* 기준 일자                      */
    private String stdH                          ;    /* 기준 시                        */


    public String getSrchCoId() {
        return srchCoId;
    }

    public void setSrchCoId(String srchCoId) {
        this.srchCoId = srchCoId;
    }

    public String getSrchCyclId() {
        return srchCyclId;
    }

    public void setSrchCyclId(String srchCyclId) {
        this.srchCyclId = srchCyclId;
    }

    public String getSrchCyclNm() {
        return srchCyclNm;
    }

    public void setSrchCyclNm(String srchCyclNm) {
        this.srchCyclNm = srchCyclNm;
    }

    public String getSrchPrdCnt() {
        return srchPrdCnt;
    }

    public void setSrchPrdCnt(String srchPrdCnt) {
        this.srchPrdCnt = srchPrdCnt;
    }

    public String getSrchCyclClCd() {
        return srchCyclClCd;
    }

    public void setSrchCyclClCd(String srchCyclClCd) {
        this.srchCyclClCd = srchCyclClCd;
    }

    public String getSrchStdDt() {
        return srchStdDt;
    }

    public void setSrchStdDt(String srchStdDt) {
        this.srchStdDt = srchStdDt;
    }

    public String getSrchStdH() {
		return srchStdH;
	}

	public void setSrchStdH(String srchStdH) {
		this.srchStdH = srchStdH;
	}

	public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getCyclId() {
        return cyclId;
    }

    public void setCyclId(String cyclId) {
        this.cyclId = cyclId;
    }

    public String getCyclNm() {
        return cyclNm;
    }

    public void setCyclNm(String cyclNm) {
        this.cyclNm = cyclNm;
    }

    public String getPrdCnt() {
        return prdCnt;
    }

    public void setPrdCnt(String prdCnt) {
        this.prdCnt = prdCnt;
    }

    public String getCyclClCd() {
        return cyclClCd;
    }

    public void setCyclClCd(String cyclClCd) {
        this.cyclClCd = cyclClCd;
    }

    public String getCyclClNm() {
		return cyclClNm;
	}

	public void setCyclClNm(String cyclClNm) {
		this.cyclClNm = cyclClNm;
	}

	public String getStdDt() {
        return stdDt;
    }

	public String getStdDtFormat() {
	    return DateUtil.getDateFormat(stdDt);
    }

    public void setStdDt(String stdDt) {
        this.stdDt = DateUtil.getNumber(stdDt);
    }

	public String getStdH() {
		return stdH;
	}

	public void setStdH(String stdH) {
		this.stdH = Integer.toString(Integer.parseInt(stdH));
	}

}