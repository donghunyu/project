/*-------------------------------------------------------------------
* NAME   : Aprj20010Model
* DESC   : 프로젝트_프로젝트
* DATE   : 2018-11-16
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.model;

import project.spring.app.aprj.lib.object.AprjModel;

public class Aprj20010Model extends AprjModel {

    private String srchCoId                      ;    /* 검색업체 ID                        */
    private String srchPrjSerNum                 ;    /* 검색프로젝트 일련번호              */
    private String srchPrjId                     ;    /* 검색프로젝트 ID                    */
    private String srchPrjNm                     ;    /* 검색프로젝트 명                    */
    private String srchPrjVer                    ;    /* 검색프로젝트 버전                  */
    private String srchPrjCtt                    ;    /* 검색프로젝트 내용                  */
    private String srchProcStCd                  ;    /* 검색진행 상태 코드                 */

    private String coId                          ;    /* 업체 ID                        */
    private String prjSerNum                     ;    /* 프로젝트 일련번호              */
    private String prjId                         ;    /* 프로젝트 ID                    */
    private String prjNm                         ;    /* 프로젝트 명                    */
    private String prjVer                        ;    /* 프로젝트 버전                  */
    private String prjCtt                        ;    /* 프로젝트 내용                  */
    private String procStCd                      ;    /* 진행 상태 코드                 */
    private String procStNm                      ;    /* 진행 상태 명                   */

    private String ctrlSerNum                    ;    /* 통제 일련번호                  */
    private String ctrlNum                       ;    /* 통제 번호                      */
    private String ctrlNm                        ;    /* 통제 명                        */

    private String opId                          ;    /* 업무 ID                        */
    private String opSerNum                      ;    /* 업무 일련번호                  */
    private String opNm                          ;    /* 업무 명                        */
    private String opCtt                         ;    /* 업무 내용                      */
    private String userId                        ;    /* 사용자 ID                      */
    private String userNm                        ;    /* 사용자 명                      */
    private String cyclId                        ;    /* 주기 ID                        */
    private String cyclNm                        ;    /* 주기 명                        */
    
    private String reqSeqNum                     ;    /* 요청 순번                      */
    private String reqTypCd                      ;    /* 요청 종류 코드                 */
    private String reqTypNm                      ;    /* 요청 종류 명                   */
    private String reqCtt                        ;    /* 요청 내용                      */

    private String itmSerNum                     ;    /* 항목 일련번호                  */
    private String itmVal                        ;    /* 항목 값                        */
    private String itmCtt                        ;    /* 항목 내용                      */
    private String itmCnt                        ;    /* 항목 수                        */
    
    private String astClId                       ;    /* 자산 구분 ID                   */
    private String astClNm                       ;    /* 자산 구분 명                   */
    private String astClCtt                      ;    /* 자산 구분 내용                 */
    private String astId                         ;    /* 자산 ID                        */
    private String astNm                         ;    /* 자산 명                        */
    private String astCtt                        ;    /* 자산 내용                      */

    public String getSrchCoId() {
        return srchCoId;
    }

    public void setSrchCoId(String srchCoId) {
        this.srchCoId = srchCoId;
    }

    public String getSrchPrjSerNum() {
        return srchPrjSerNum;
    }

    public void setSrchPrjSerNum(String srchPrjSerNum) {
        this.srchPrjSerNum = srchPrjSerNum;
    }

    public String getSrchPrjId() {
        return srchPrjId;
    }

    public void setSrchPrjId(String srchPrjId) {
        this.srchPrjId = srchPrjId;
    }

    public String getSrchPrjNm() {
        return srchPrjNm;
    }

    public void setSrchPrjNm(String srchPrjNm) {
        this.srchPrjNm = srchPrjNm;
    }

    public String getSrchPrjVer() {
        return srchPrjVer;
    }

    public void setSrchPrjVer(String srchPrjVer) {
        this.srchPrjVer = srchPrjVer;
    }

    public String getSrchPrjCtt() {
        return srchPrjCtt;
    }

    public void setSrchPrjCtt(String srchPrjCtt) {
        this.srchPrjCtt = srchPrjCtt;
    }

    public String getSrchProcStCd() {
        return srchProcStCd;
    }

    public void setSrchProcStCd(String srchProcStCd) {
        this.srchProcStCd = srchProcStCd;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getPrjSerNum() {
        return prjSerNum;
    }

    public void setPrjSerNum(String prjSerNum) {
        this.prjSerNum = prjSerNum;
    }

    public String getPrjId() {
        return prjId;
    }

    public void setPrjId(String prjId) {
        this.prjId = prjId;
    }

    public String getPrjNm() {
        return prjNm;
    }

    public void setPrjNm(String prjNm) {
        this.prjNm = prjNm;
    }

    public String getPrjVer() {
        return prjVer;
    }

    public void setPrjVer(String prjVer) {
        this.prjVer = prjVer;
    }

    public String getPrjCtt() {
        return prjCtt;
    }

    public void setPrjCtt(String prjCtt) {
        this.prjCtt = prjCtt;
    }

    public String getProcStCd() {
        return procStCd;
    }

    public void setProcStCd(String procStCd) {
        this.procStCd = procStCd;
    }

	public String getProcStNm() {
		return procStNm;
	}

	public void setProcStNm(String procStNm) {
		this.procStNm = procStNm;
	}

	public String getCtrlSerNum() {
		return ctrlSerNum;
	}

	public void setCtrlSerNum(String ctrlSerNum) {
		this.ctrlSerNum = ctrlSerNum;
	}

	public String getCtrlNum() {
		return ctrlNum;
	}

	public void setCtrlNum(String ctrlNum) {
		this.ctrlNum = ctrlNum;
	}

	public String getCtrlNm() {
		return ctrlNm;
	}

	public void setCtrlNm(String ctrlNm) {
		this.ctrlNm = ctrlNm;
	}

	public String getOpId() {
		return opId;
	}

	public void setOpId(String opId) {
		this.opId = opId;
	}

	public String getOpSerNum() {
		return opSerNum;
	}

	public void setOpSerNum(String opSerNum) {
		this.opSerNum = opSerNum;
	}

	public String getOpNm() {
		return opNm;
	}

	public void setOpNm(String opNm) {
		this.opNm = opNm;
	}

	public String getOpCtt() {
		return opCtt;
	}

	public void setOpCtt(String opCtt) {
		this.opCtt = opCtt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
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

	public String getAstClId() {
		return astClId;
	}

	public void setAstClId(String astClId) {
		this.astClId = astClId;
	}

	public String getAstClNm() {
		return astClNm;
	}

	public void setAstClNm(String astClNm) {
		this.astClNm = astClNm;
	}

	public String getAstClCtt() {
		return astClCtt;
	}

	public void setAstClCtt(String astClCtt) {
		this.astClCtt = astClCtt;
	}

	public String getAstId() {
		return astId;
	}

	public void setAstId(String astId) {
		this.astId = astId;
	}

	public String getAstNm() {
		return astNm;
	}

	public void setAstNm(String astNm) {
		this.astNm = astNm;
	}

	public String getAstCtt() {
		return astCtt;
	}

	public void setAstCtt(String astCtt) {
		this.astCtt = astCtt;
	}

}