/*-------------------------------------------------------------------
* NAME   : Aprj10050Model
* DESC   : 설정_양식
* DATE   : 2018-10-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.model;

import project.spring.app.aprj.lib.object.AprjModel;

public class Aprj10050Model extends AprjModel {

    private String srchCoId                      ;    /* 검색업체 ID                        */
    private String srchFormId                    ;    /* 검색양식 ID                        */
    private String srchFormNm                    ;    /* 검색양식 명                        */
    private String srchFormVer                   ;    /* 검색양식 버전                      */
    private String srchFormCtt                   ;    /* 검색양식 내용                      */
    private String srchDelYn                     ;    /* 검색삭제 여부                      */

    private String coId                          ;    /* 업체 ID                        */
    private String formId                        ;    /* 양식 ID                        */
    private String formNm                        ;    /* 양식 명                        */
    private String formVer                       ;    /* 양식 버전                      */
    private String formCtt                       ;    /* 양식 내용                      */
    private String delYn                         ;    /* 삭제 여부                      */

    private String reqSerNum                     ;    /* 요청 일련번호                  */
    private String reqSeqNum                     ;    /* 요청 순번                      */
    private String reqTypCd                      ;    /* 요청 종류 코드                 */
    private String reqTypNm                      ;    /* 요청 종류 코드                 */
    private String reqCtt                        ;    /* 요청 내용                      */

    private String itmSerNum                     ;    /* 항목 일련번호                  */
    private String itmVal                        ;    /* 항목 값                        */
    private String itmCtt                        ;    /* 항목 내용                      */
    private String itmCnt                        ;    /* 항목 수                        */

    private String srcFormId                     ;    /* 양식 ID                        */
    
    
    public String getSrchCoId() {
        return srchCoId;
    }

    public void setSrchCoId(String srchCoId) {
        this.srchCoId = srchCoId;
    }

    public String getSrchFormId() {
		return srchFormId;
	}

	public void setSrchFormId(String srchFormId) {
		this.srchFormId = srchFormId;
	}

	public String getSrchFormNm() {
        return srchFormNm;
    }

    public void setSrchFormNm(String srchFormNm) {
        this.srchFormNm = srchFormNm;
    }

    public String getSrchFormVer() {
        return srchFormVer;
    }

    public void setSrchFormVer(String srchFormVer) {
        this.srchFormVer = srchFormVer;
    }

    public String getSrchFormCtt() {
        return srchFormCtt;
    }

    public void setSrchFormCtt(String srchFormCtt) {
        this.srchFormCtt = srchFormCtt;
    }

    public String getSrchDelYn() {
        return srchDelYn;
    }

    public void setSrchDelYn(String srchDelYn) {
        this.srchDelYn = srchDelYn;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getFormNm() {
        return formNm;
    }

    public void setFormNm(String formNm) {
        this.formNm = formNm;
    }

    public String getFormVer() {
        return formVer;
    }

    public void setFormVer(String formVer) {
        this.formVer = formVer;
    }

    public String getFormCtt() {
        return formCtt;
    }

    public void setFormCtt(String formCtt) {
        this.formCtt = formCtt;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

	public String getReqSerNum() {
		return reqSerNum;
	}

	public void setReqSerNum(String reqSerNum) {
		this.reqSerNum = reqSerNum;
	}

	public String getReqSeqNum() {
		return reqSeqNum;
	}

	public void setReqSeqNum(String reqSeqNum) {
		this.reqSeqNum = reqSeqNum;
	}

	public String getReqTypCd() {
		return reqTypCd;
	}

	public void setReqTypCd(String reqTypCd) {
		this.reqTypCd = reqTypCd;
	}

	public String getReqTypNm() {
		return reqTypNm;
	}

	public void setReqTypNm(String reqTypNm) {
		this.reqTypNm = reqTypNm;
	}

	public String getReqCtt() {
		return reqCtt;
	}

	public void setReqCtt(String reqCtt) {
		this.reqCtt = reqCtt;
	}

	public String getItmSerNum() {
		return itmSerNum;
	}

	public void setItmSerNum(String itmSerNum) {
		this.itmSerNum = itmSerNum;
	}

	public String getItmVal() {
		return itmVal;
	}

	public void setItmVal(String itmVal) {
		this.itmVal = itmVal;
	}

	public String getItmCtt() {
		return itmCtt;
	}

	public void setItmCtt(String itmCtt) {
		this.itmCtt = itmCtt;
	}

	public String getItmCnt() {
		return itmCnt;
	}

	public void setItmCnt(String itmCnt) {
		this.itmCnt = itmCnt;
	}

	public String getSrcFormId() {
		return srcFormId;
	}

	public void setSrcFormId(String srcFormId) {
		this.srcFormId = srcFormId;
	}

}