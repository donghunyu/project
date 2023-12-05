/*-------------------------------------------------------------------
* NAME   : Zcom99031Model
* DESC   : 관리자_업체
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.model;

import project.spring.app.aprj.lib.object.AprjModel;

public class Zcom99031Model extends AprjModel {

    private String srchCoId                      ;    /* 검색업체 ID                        */
    private String srchCoNm                      ;    /* 검색업체 명                        */
    private String selCoId                       ;    /* 검색업체 ID                        */
    private String selCoNm                       ;    /* 검색업체 명                        */
    private String srchCoBizNum                  ;    /* 검색업체 사업자 번호               */
    private String srchCoPhonNum                 ;    /* 검색업체 전화 번호                 */
    private String srchCoAddr                    ;    /* 검색업체 주소                      */
    private String srchCoCtt                     ;    /* 검색업체 내용                      */

    private String coId                          ;    /* 업체 ID                        */
    private String coNm                          ;    /* 업체 명                        */
    private String coBizNum                      ;    /* 업체 사업자 번호               */
    private String coPhonNum                     ;    /* 업체 전화 번호                 */
    private String coAddr                        ;    /* 업체 주소                      */
    private String coCtt                         ;    /* 업체 내용                      */


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

    public String getSelCoId() {
		return selCoId;
	}

	public void setSelCoId(String selCoId) {
		this.selCoId = selCoId;
	}

	public String getSelCoNm() {
		return selCoNm;
	}

	public void setSelCoNm(String selCoNm) {
		this.selCoNm = selCoNm;
	}

	public String getSrchCoBizNum() {
        return srchCoBizNum;
    }

    public void setSrchCoBizNum(String srchCoBizNum) {
        this.srchCoBizNum = srchCoBizNum;
    }

    public String getSrchCoPhonNum() {
        return srchCoPhonNum;
    }

    public void setSrchCoPhonNum(String srchCoPhonNum) {
        this.srchCoPhonNum = srchCoPhonNum;
    }

    public String getSrchCoAddr() {
        return srchCoAddr;
    }

    public void setSrchCoAddr(String srchCoAddr) {
        this.srchCoAddr = srchCoAddr;
    }

    public String getSrchCoCtt() {
        return srchCoCtt;
    }

    public void setSrchCoCtt(String srchCoCtt) {
        this.srchCoCtt = srchCoCtt;
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

    public String getCoBizNum() {
        return coBizNum;
    }

    public void setCoBizNum(String coBizNum) {
        this.coBizNum = coBizNum;
    }

    public String getCoPhonNum() {
        return coPhonNum;
    }

    public void setCoPhonNum(String coPhonNum) {
        this.coPhonNum = coPhonNum;
    }

    public String getCoAddr() {
        return coAddr;
    }

    public void setCoAddr(String coAddr) {
        this.coAddr = coAddr;
    }

    public String getCoCtt() {
        return coCtt;
    }

    public void setCoCtt(String coCtt) {
        this.coCtt = coCtt;
    }

}