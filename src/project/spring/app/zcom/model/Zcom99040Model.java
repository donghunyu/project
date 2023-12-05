/*-------------------------------------------------------------------
* NAME   : Zcom99040Model
* DESC   : 관리자_부서
* DATE   : 2023-03-21
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.model;

import project.spring.app.zcom.lib.object.ZcomModel;

public class Zcom99040Model extends ZcomModel {

    private String srchDeptId                    ;    /* 검색부서 ID                        */
    private String srchDeptNm                    ;    /* 검색부서 명                        */
    private String srchDeptCtt                   ;    /* 검색부서 내용                      */
    private String srchSupDeptId                 ;    /* 검색상위 부서 ID                   */

    private String deptId                        ;    /* 부서 ID                        */
    private String deptNm                        ;    /* 부서 명                        */
    private String deptCtt                       ;    /* 부서 내용                      */
    private String supDeptId                     ;    /* 상위 부서 ID                   */


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

}