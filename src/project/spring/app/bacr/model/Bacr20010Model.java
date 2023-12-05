/*-------------------------------------------------------------------
* NAME   : Bacr20010Model
* DESC   : 대회_대회
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

public class Bacr20010Model extends BacrModel {

    private String srchTnmtId                    ;    /* 검색대회 ID                        */
    private String srchTnmtNm                    ;    /* 검색대회 명                        */
    private String srchPwd                       ;    /* 검색비밀번호                       */
    private String srchTnmtPvlId                 ;    /* 검색대회 정 ID                     */
    private String srchTnmtClCd                  ;    /* 검색대회 구분 코드                 */
    private String srchSpCnt                     ;    /* 검색사대 수                        */
    private String srchSoonCnt                   ;    /* 검색순 수                          */
    private String srchSiCnt                     ;    /* 검색시 수                          */
    private String srchStaDt                     ;    /* 검색시작 일자                      */
    private String srchEndDt                     ;    /* 검색종료 일자                      */

    private String tnmtId                        ;    /* 대회 ID                        */
    private String tnmtNm                        ;    /* 대회 명                        */
    private String pwd                           ;    /* 비밀번호                       */
    private String tnmtPvlId                     ;    /* 대회 정 ID                     */
    private String tnmtClCd                      ;    /* 대회 구분 코드                 */
    private String spCnt                         ;    /* 사대 수                        */
    private String soonCnt                       ;    /* 순 수                          */
    private String siCnt                         ;    /* 시 수                          */
    private String staDt                         ;    /* 시작 일자                      */
    private String endDt                         ;    /* 종료 일자                      */


    public String getSrchTnmtId() {
        return srchTnmtId;
    }

    public void setSrchTnmtId(String srchTnmtId) {
        this.srchTnmtId = srchTnmtId;
    }

    public String getSrchTnmtNm() {
        return srchTnmtNm;
    }

    public void setSrchTnmtNm(String srchTnmtNm) {
        this.srchTnmtNm = srchTnmtNm;
    }

    public String getSrchPwd() {
        return srchPwd;
    }

    public void setSrchPwd(String srchPwd) {
        this.srchPwd = srchPwd;
    }

    public String getSrchTnmtPvlId() {
        return srchTnmtPvlId;
    }

    public void setSrchTnmtPvlId(String srchTnmtPvlId) {
        this.srchTnmtPvlId = srchTnmtPvlId;
    }

    public String getSrchTnmtClCd() {
        return srchTnmtClCd;
    }

    public void setSrchTnmtClCd(String srchTnmtClCd) {
        this.srchTnmtClCd = srchTnmtClCd;
    }

    public String getSrchSpCnt() {
        return srchSpCnt;
    }

    public void setSrchSpCnt(String srchSpCnt) {
        this.srchSpCnt = srchSpCnt;
    }

    public String getSrchSoonCnt() {
        return srchSoonCnt;
    }

    public void setSrchSoonCnt(String srchSoonCnt) {
        this.srchSoonCnt = srchSoonCnt;
    }

    public String getSrchSiCnt() {
        return srchSiCnt;
    }

    public void setSrchSiCnt(String srchSiCnt) {
        this.srchSiCnt = srchSiCnt;
    }

    public String getSrchStaDt() {
        return srchStaDt;
    }

    public void setSrchStaDt(String srchStaDt) {
        this.srchStaDt = srchStaDt;
    }

    public String getSrchEndDt() {
        return srchEndDt;
    }

    public void setSrchEndDt(String srchEndDt) {
        this.srchEndDt = srchEndDt;
    }

    public String getTnmtId() {
        return tnmtId;
    }

    public void setTnmtId(String tnmtId) {
        this.tnmtId = tnmtId;
    }

    public String getTnmtNm() {
        return tnmtNm;
    }

    public void setTnmtNm(String tnmtNm) {
        this.tnmtNm = tnmtNm;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTnmtPvlId() {
        return tnmtPvlId;
    }

    public void setTnmtPvlId(String tnmtPvlId) {
        this.tnmtPvlId = tnmtPvlId;
    }

    public String getTnmtClCd() {
        return tnmtClCd;
    }

    public void setTnmtClCd(String tnmtClCd) {
        this.tnmtClCd = tnmtClCd;
    }

    public String getSpCnt() {
        return spCnt;
    }

    public void setSpCnt(String spCnt) {
        this.spCnt = spCnt;
    }

    public String getSoonCnt() {
        return soonCnt;
    }

    public void setSoonCnt(String soonCnt) {
        this.soonCnt = soonCnt;
    }

    public String getSiCnt() {
        return siCnt;
    }

    public void setSiCnt(String siCnt) {
        this.siCnt = siCnt;
    }

    public String getStaDt() {
        return staDt;
    }

    public void setStaDt(String staDt) {
        this.staDt = staDt;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

}