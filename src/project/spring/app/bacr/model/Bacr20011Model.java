/*-------------------------------------------------------------------
* NAME   : Bacr20011Model
* DESC   : 대회_사대
* DATE   : 2023-02-13
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.bacr.model;

import project.spring.app.bacr.lib.object.BacrModel;

public class Bacr20011Model extends BacrModel {

    private String srchTnmtId                    ;    /* 검색대회 ID                        */
    private String srchSpClCd                    ;    /* 검색사대 구분 코드                 */
    private String srchSpSerNum                  ;    /* 검색사대 일련번호                  */
    private String srchSpNm                      ;    /* 검색사대 명                        */

    private String tnmtId                        ;    /* 대회 ID                        */
    private String spClCd                        ;    /* 사대 구분 코드                 */
    private String spSerNum                      ;    /* 사대 일련번호                  */
    private String spNm                          ;    /* 사대 명                        */


    public String getSrchTnmtId() {
        return srchTnmtId;
    }

    public void setSrchTnmtId(String srchTnmtId) {
        this.srchTnmtId = srchTnmtId;
    }

    public String getSrchSpClCd() {
        return srchSpClCd;
    }

    public void setSrchSpClCd(String srchSpClCd) {
        this.srchSpClCd = srchSpClCd;
    }

    public String getSrchSpSerNum() {
        return srchSpSerNum;
    }

    public void setSrchSpSerNum(String srchSpSerNum) {
        this.srchSpSerNum = srchSpSerNum;
    }

    public String getSrchSpNm() {
        return srchSpNm;
    }

    public void setSrchSpNm(String srchSpNm) {
        this.srchSpNm = srchSpNm;
    }

    public String getTnmtId() {
        return tnmtId;
    }

    public void setTnmtId(String tnmtId) {
        this.tnmtId = tnmtId;
    }

    public String getSpClCd() {
        return spClCd;
    }

    public void setSpClCd(String spClCd) {
        this.spClCd = spClCd;
    }

    public String getSpSerNum() {
        return spSerNum;
    }

    public void setSpSerNum(String spSerNum) {
        this.spSerNum = spSerNum;
    }

    public String getSpNm() {
        return spNm;
    }

    public void setSpNm(String spNm) {
        this.spNm = spNm;
    }

}