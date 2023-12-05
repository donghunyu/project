/*-------------------------------------------------------------------
* NAME   : Bacr20030Model
* DESC   : 대회_참가그룹
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

public class Bacr20030Model extends BacrModel {

    private String srchTnmtId                    ;    /* 검색대회 ID                        */
    private String srchCptClCd                   ;    /* 검색참가 구분 코드                 */
    private String srchGrpSerNum                 ;    /* 검색그룹 일련번호                  */
    private String srchCptGrpNm                  ;    /* 검색참가 그룹 명                   */

    private String tnmtId                        ;    /* 대회 ID                        */
    private String cptClCd                       ;    /* 참가 구분 코드                 */
    private String grpSerNum                     ;    /* 그룹 일련번호                  */
    private String cptGrpNm                      ;    /* 참가 그룹 명                   */


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

    public String getSrchGrpSerNum() {
        return srchGrpSerNum;
    }

    public void setSrchGrpSerNum(String srchGrpSerNum) {
        this.srchGrpSerNum = srchGrpSerNum;
    }

    public String getSrchCptGrpNm() {
        return srchCptGrpNm;
    }

    public void setSrchCptGrpNm(String srchCptGrpNm) {
        this.srchCptGrpNm = srchCptGrpNm;
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

    public String getGrpSerNum() {
        return grpSerNum;
    }

    public void setGrpSerNum(String grpSerNum) {
        this.grpSerNum = grpSerNum;
    }

    public String getCptGrpNm() {
        return cptGrpNm;
    }

    public void setCptGrpNm(String cptGrpNm) {
        this.cptGrpNm = cptGrpNm;
    }

}