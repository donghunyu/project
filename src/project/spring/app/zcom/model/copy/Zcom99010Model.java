/*-------------------------------------------------------------------
* NAME   : Zcom99010Model
* DESC   : 관리자_그룹코드
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.model.copy;

import project.spring.app.aprj.lib.object.AprjModel;

public class Zcom99010Model extends AprjModel {

    private String srchGrpCd                     ;    /* 검색그룹 코드                      */
    private String srchGrpCdNm                   ;    /* 검색그룹 코드 명                   */
    private String srchGrpCdCtt                  ;    /* 검색그룹 코드 내용                 */

    private String grpCd                         ;    /* 그룹 코드                      */
    private String grpCdNm                       ;    /* 그룹 코드 명                   */
    private String grpCdCtt                      ;    /* 그룹 코드 내용                 */
    private String cd                            ;    /* 코드                           */
    private String cdNm                          ;    /* 코드 명                        */
    private String seqNum                        ;    /* 순번                           */
    private String cdCtt                         ;    /* 코드 내용                      */


    public String getSrchGrpCd() {
        return srchGrpCd;
    }

    public void setSrchGrpCd(String srchGrpCd) {
        this.srchGrpCd = srchGrpCd;
    }

    public String getSrchGrpCdNm() {
        return srchGrpCdNm;
    }

    public void setSrchGrpCdNm(String srchGrpCdNm) {
        this.srchGrpCdNm = srchGrpCdNm;
    }

    public String getSrchGrpCdCtt() {
        return srchGrpCdCtt;
    }

    public void setSrchGrpCdCtt(String srchGrpCdCtt) {
        this.srchGrpCdCtt = srchGrpCdCtt;
    }

    public String getGrpCd() {
        return grpCd;
    }

    public void setGrpCd(String grpCd) {
        this.grpCd = grpCd;
    }

    public String getGrpCdNm() {
        return grpCdNm;
    }

    public void setGrpCdNm(String grpCdNm) {
        this.grpCdNm = grpCdNm;
    }

    public String getGrpCdCtt() {
        return grpCdCtt;
    }

    public void setGrpCdCtt(String grpCdCtt) {
        this.grpCdCtt = grpCdCtt;
    }

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCdNm() {
		return cdNm;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public String getCdCtt() {
		return cdCtt;
	}

	public void setCdCtt(String cdCtt) {
		this.cdCtt = cdCtt;
	}

}