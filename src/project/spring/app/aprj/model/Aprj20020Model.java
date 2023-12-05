/*-------------------------------------------------------------------
* NAME   : Aprj20020Model
* DESC   : 프로젝트_통제
* DATE   : 2018-11-20
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.model;

import project.spring.app.aprj.lib.object.AprjModel;

public class Aprj20020Model extends AprjModel {

    private String srchPrjId                     ;    /* 검색프로젝트 ID                    */
    private String srchPrjNm                     ;    /* 검색프로젝트 명                    */
    private String srchCtrlNum                   ;    /* 검색통제 번호                      */
    private String srchCtrlNm                    ;    /* 검색통제 명                        */
    private String srchCtrlCtt                   ;    /* 검색통제 내용                      */
    private String srchAstClId                   ;    /* 검색자산 구분 ID                   */
    private String srchAstClNm                   ;    /* 검색자산 구분 명                   */

    private String prjId                         ;    /* 프로젝트 ID                    */
    private String prjNm                         ;    /* 프로젝트 명                    */
    private String prjCtt                        ;    /* 프로젝트 내용                  */
    private String ctrlNum                       ;    /* 통제 번호                      */
    private String ctrlNm                        ;    /* 통제 명                        */
    private String ctrlCtt                       ;    /* 통제 내용                      */
    private String astClId                       ;    /* 자산 구분 ID                   */
    private String astClNm                       ;    /* 자산 구분 명                   */
    private String astClCtt                      ;    /* 자산 구분 내용                 */
    private String astId                         ;    /* 자산 ID                        */
    private String astNm                         ;    /* 자산 명                        */
    private String astCtt                        ;    /* 자산 내용                      */

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

	public String getSrchCtrlNum() {
        return srchCtrlNum;
    }

    public void setSrchCtrlNum(String srchCtrlNum) {
        this.srchCtrlNum = srchCtrlNum;
    }

    public String getSrchCtrlNm() {
        return srchCtrlNm;
    }

    public void setSrchCtrlNm(String srchCtrlNm) {
        this.srchCtrlNm = srchCtrlNm;
    }

    public String getSrchCtrlCtt() {
        return srchCtrlCtt;
    }

    public void setSrchCtrlCtt(String srchCtrlCtt) {
        this.srchCtrlCtt = srchCtrlCtt;
    }

    public String getSrchAstClId() {
		return srchAstClId;
	}

	public void setSrchAstClId(String srchAstClId) {
		this.srchAstClId = srchAstClId;
	}

	public String getSrchAstClNm() {
		return srchAstClNm;
	}

	public void setSrchAstClNm(String srchAstClNm) {
		this.srchAstClNm = srchAstClNm;
	}

	public String getPrjNm() {
		return prjNm;
	}

	public void setPrjNm(String prjNm) {
		this.prjNm = prjNm;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getPrjCtt() {
		return prjCtt;
	}

	public void setPrjCtt(String prjCtt) {
		this.prjCtt = prjCtt;
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

    public String getCtrlCtt() {
        return ctrlCtt;
    }

    public void setCtrlCtt(String ctrlCtt) {
        this.ctrlCtt = ctrlCtt;
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