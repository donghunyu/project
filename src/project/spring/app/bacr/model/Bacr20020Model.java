/*-------------------------------------------------------------------
* NAME   : Bacr20020Model
* DESC   : 대회_참가구분
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

public class Bacr20020Model extends BacrModel {

    private String srchTnmtId                    ;    /* 검색대회 ID                        */
    private String srchCptClCd                   ;    /* 검색참가 구분 코드                 */

    private String tnmtId                        ;    /* 대회 ID                        */
    private String cptClCd                       ;    /* 참가 구분 코드                 */


    public String getSrchTnmtId() {
        return srchTnmtId;
    }

    public void setSrchTnmtId(String srchTnmtId) {
        this.srchTnmtId = srchTnmtId;
    }

    public String getSrchCptClCd() {
        return srchCptClCd;
    }

    public void setSrchCptClCd(String srchCptClCd) {
        this.srchCptClCd = srchCptClCd;
    }

    public String getTnmtId() {
        return tnmtId;
    }

    public void setTnmtId(String tnmtId) {
        this.tnmtId = tnmtId;
    }

    public String getCptClCd() {
        return cptClCd;
    }

    public void setCptClCd(String cptClCd) {
        this.cptClCd = cptClCd;
    }

}