/*-------------------------------------------------------------------
* NAME   : Aprj10030Model
* DESC   : 설정_결제
* DATE   : 2018-11-08
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.model;

import project.spring.app.aprj.lib.object.AprjModel;

public class Aprj10030Model extends AprjModel {

    private String srchCoId                      ;    /* 검색업체 ID                        */
    private String srchStmId                     ;    /* 검색결제 ID                        */
    private String srchStmNm                     ;    /* 검색결제 명                        */
    private String srchStmCtt                    ;    /* 검색결제 내용                      */

    private String coId                          ;    /* 업체 ID                        */
    private String stmId                         ;    /* 결제 ID                        */
    private String stmNm                         ;    /* 결제 명                        */
    private String stmCtt                        ;    /* 결제 내용                      */

    private String stmSerNum                     ;    /* 결제 일련번호                  */
    private String stmClCd                       ;    /* 결제 구분 코드                 */
    private String stmClNm                       ;    /* 결제 구분 명                   */
    private String stmOpChrgId                   ;    /* 결제 업무 담당 ID              */
    private String stmOpChrgNm                   ;    /* 결제 업무 담당 명              */
    private String stmAuthCd                     ;    /* 결제 권한 코드                 */
    private String stmAuthNm                     ;    /* 결제 권한 명                   */


    public String getSrchCoId() {
        return srchCoId;
    }

    public void setSrchCoId(String srchCoId) {
        this.srchCoId = srchCoId;
    }

    public String getSrchStmId() {
        return srchStmId;
    }

    public void setSrchStmId(String srchStmId) {
        this.srchStmId = srchStmId;
    }

    public String getSrchStmNm() {
        return srchStmNm;
    }

    public void setSrchStmNm(String srchStmNm) {
        this.srchStmNm = srchStmNm;
    }

    public String getSrchStmCtt() {
        return srchStmCtt;
    }

    public void setSrchStmCtt(String srchStmCtt) {
        this.srchStmCtt = srchStmCtt;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getStmId() {
        return stmId;
    }

    public void setStmId(String stmId) {
        this.stmId = stmId;
    }

    public String getStmNm() {
        return stmNm;
    }

    public void setStmNm(String stmNm) {
        this.stmNm = stmNm;
    }

    public String getStmCtt() {
        return stmCtt;
    }

    public void setStmCtt(String stmCtt) {
        this.stmCtt = stmCtt;
    }

	public String getStmSerNum() {
		return stmSerNum;
	}

	public void setStmSerNum(String stmSerNum) {
		this.stmSerNum = stmSerNum;
	}

	public String getStmClCd() {
		return stmClCd;
	}

	public void setStmClCd(String stmClCd) {
		this.stmClCd = stmClCd;
	}

	public String getStmClNm() {
		return stmClNm;
	}

	public void setStmClNm(String stmClNm) {
		this.stmClNm = stmClNm;
	}

	public String getStmOpChrgId() {
		return stmOpChrgId;
	}

	public void setStmOpChrgId(String stmOpChrgId) {
		this.stmOpChrgId = stmOpChrgId;
	}

	public String getStmOpChrgNm() {
		return stmOpChrgNm;
	}

	public void setStmOpChrgNm(String stmOpChrgNm) {
		this.stmOpChrgNm = stmOpChrgNm;
	}

	public String getStmAuthCd() {
		return stmAuthCd;
	}

	public void setStmAuthCd(String stmAuthCd) {
		this.stmAuthCd = stmAuthCd;
	}

	public String getStmAuthNm() {
		return stmAuthNm;
	}

	public void setStmAuthNm(String stmAuthNm) {
		this.stmAuthNm = stmAuthNm;
	}

}