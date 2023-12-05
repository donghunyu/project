/*-------------------------------------------------------------------
* NAME   : Bacr10100Model
* DESC   : 기본정보_회원
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

public class Bacr10100Model extends BacrModel {

    private String srchPvlId                     ;    /* 검색정 ID                          */
    private String srchMbNum                     ;    /* 검색회원 번호                      */
    private String srchMbId                      ;    /* 검색회원 ID                        */
    private String srchMbNm                      ;    /* 검색회원 명                        */
    private String srchMbPwd                     ;    /* 검색회원 비밀번호                  */
    private String srchBtd                       ;    /* 검색생년월일                       */
    private String srchMblNum                    ;    /* 검색모바일 번호                    */
    private String srchMailAddr                  ;    /* 검색메일 주소                      */
    private String srchGdCd                      ;    /* 검색성별 코드                      */

    private String pvlId                         ;    /* 정 ID                          */
    private String mbNum                         ;    /* 회원 번호                      */
    private String mbId                          ;    /* 회원 ID                        */
    private String mbNm                          ;    /* 회원 명                        */
    private String mbPwd                         ;    /* 회원 비밀번호                  */
    private String btd                           ;    /* 생년월일                       */
    private String mblNum                        ;    /* 모바일 번호                    */
    private String mailAddr                      ;    /* 메일 주소                      */
    private String gdCd                          ;    /* 성별 코드                      */


    public String getSrchPvlId() {
        return srchPvlId;
    }

    public void setSrchPvlId(String srchPvlId) {
        this.srchPvlId = srchPvlId;
    }

    public String getSrchMbNum() {
        return srchMbNum;
    }

    public void setSrchMbNum(String srchMbNum) {
        this.srchMbNum = srchMbNum;
    }

    public String getSrchMbId() {
        return srchMbId;
    }

    public void setSrchMbId(String srchMbId) {
        this.srchMbId = srchMbId;
    }

    public String getSrchMbNm() {
        return srchMbNm;
    }

    public void setSrchMbNm(String srchMbNm) {
        this.srchMbNm = srchMbNm;
    }

    public String getSrchMbPwd() {
        return srchMbPwd;
    }

    public void setSrchMbPwd(String srchMbPwd) {
        this.srchMbPwd = srchMbPwd;
    }

    public String getSrchBtd() {
        return srchBtd;
    }

    public void setSrchBtd(String srchBtd) {
        this.srchBtd = srchBtd;
    }

    public String getSrchMblNum() {
        return srchMblNum;
    }

    public void setSrchMblNum(String srchMblNum) {
        this.srchMblNum = srchMblNum;
    }

    public String getSrchMailAddr() {
        return srchMailAddr;
    }

    public void setSrchMailAddr(String srchMailAddr) {
        this.srchMailAddr = srchMailAddr;
    }

    public String getSrchGdCd() {
        return srchGdCd;
    }

    public void setSrchGdCd(String srchGdCd) {
        this.srchGdCd = srchGdCd;
    }

    public String getPvlId() {
        return pvlId;
    }

    public void setPvlId(String pvlId) {
        this.pvlId = pvlId;
    }

    public String getMbNum() {
        return mbNum;
    }

    public void setMbNum(String mbNum) {
        this.mbNum = mbNum;
    }

    public String getMbId() {
        return mbId;
    }

    public void setMbId(String mbId) {
        this.mbId = mbId;
    }

    public String getMbNm() {
        return mbNm;
    }

    public void setMbNm(String mbNm) {
        this.mbNm = mbNm;
    }

    public String getMbPwd() {
        return mbPwd;
    }

    public void setMbPwd(String mbPwd) {
        this.mbPwd = mbPwd;
    }

    public String getBtd() {
        return btd;
    }

    public void setBtd(String btd) {
        this.btd = btd;
    }

    public String getMblNum() {
        return mblNum;
    }

    public void setMblNum(String mblNum) {
        this.mblNum = mblNum;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

    public String getGdCd() {
        return gdCd;
    }

    public void setGdCd(String gdCd) {
        this.gdCd = gdCd;
    }

}