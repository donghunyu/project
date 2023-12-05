/*-------------------------------------------------------------------
* NAME   : Zcom99032Model
* DESC   : 관리자_부서
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

public class Zcom99032Model extends AprjModel {

    private String srchCoId                      ;    /* 검색업체 ID                        */
    private String srchDeptId                    ;    /* 검색부서 ID                        */
    private String srchDeptNm                    ;    /* 검색부서 명                        */
    private String srchDeptCtt                   ;    /* 검색부서 내용                      */
    private String srchSupDeptId                 ;    /* 검색상위 부서 ID                   */

    private String coId                          ;    /* 업체 ID                        */
    private String deptId                        ;    /* 부서 ID                        */
    private String deptNm                        ;    /* 부서 명                        */
    private String deptCtt                       ;    /* 부서 내용                      */
    private String supDeptId                     ;    /* 상위 부서 ID                   */
    private String supDeptNm                     ;    /* 상위 부서 명                   */

    private String lev                           ;    /* 부서 레벨                      */

    public String getLev() {
		return lev;
	}

	public void setLev(String lev) {
		this.lev = lev;
	}

	public String getSrchCoId() {
        return srchCoId;
    }

    public void setSrchCoId(String srchCoId) {
        this.srchCoId = srchCoId;
    }

    public String getSrchDeptId() {
        return srchDeptId;
    }

    public void setSrchDeptId(String srchDeptId) {
        this.srchDeptId = srchDeptId;
    }

    public String getSrchDeptNm() {
        return srchDeptNm;
    }

    public void setSrchDeptNm(String srchDeptNm) {
        this.srchDeptNm = srchDeptNm;
    }

    public String getSrchDeptCtt() {
        return srchDeptCtt;
    }

    public void setSrchDeptCtt(String srchDeptCtt) {
        this.srchDeptCtt = srchDeptCtt;
    }

    public String getSrchSupDeptId() {
        return srchSupDeptId;
    }

    public void setSrchSupDeptId(String srchSupDeptId) {
        this.srchSupDeptId = srchSupDeptId;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getDeptCtt() {
        return deptCtt;
    }

    public void setDeptCtt(String deptCtt) {
        this.deptCtt = deptCtt;
    }

    public String getSupDeptId() {
        return supDeptId;
    }

    public void setSupDeptId(String supDeptId) {
        this.supDeptId = supDeptId;
    }

	public String getSupDeptNm() {
		return supDeptNm;
	}

	public void setSupDeptNm(String supDeptNm) {
		this.supDeptNm = supDeptNm;
	}

}