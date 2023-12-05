/*-------------------------------------------------------------------
* NAME   : Bacr20040Model
* DESC   : 대회_참가자
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

public class Bacr20040Model extends BacrModel {

    private String srchTnmtId                    ;    /* 검색대회 ID                        */
    private String srchCptClCd                   ;    /* 검색참가 구분 코드                 */
    private String srchGrpSerNum                 ;    /* 검색그룹 일련번호                  */
    private String srchMbNum                     ;    /* 검색회원 번호                      */
    private String srchPvlId                     ;    /* 검색정 ID                          */

    private String tnmtId                        ;    /* 대회 ID                        */
    private String cptClCd                       ;    /* 참가 구분 코드                 */
    private String grpSerNum                     ;    /* 그룹 일련번호                  */
    private String mbNum                         ;    /* 회원 번호                      */
    private String pvlId                         ;    /* 정 ID                          */


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

    public String getSrchMbNum() {
        return srchMbNum;
    }

    public void setSrchMbNum(String srchMbNum) {
        this.srchMbNum = srchMbNum;
    }

    public String getSrchPvlId() {
        return srchPvlId;
    }

    public void setSrchPvlId(String srchPvlId) {
        this.srchPvlId = srchPvlId;
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

    public String getMbNum() {
        return mbNum;
    }

    public void setMbNum(String mbNum) {
        this.mbNum = mbNum;
    }

    public String getPvlId() {
        return pvlId;
    }

    public void setPvlId(String pvlId) {
        this.pvlId = pvlId;
    }

}