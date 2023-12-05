/*-------------------------------------------------------------------
* NAME   : Zcom99030Model
* DESC   : 관리자_사용자
* DATE   : 2023-03-25
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.model;

import project.spring.app.zcom.lib.object.ZcomModel;

public class Zcom99030Model extends ZcomModel {

    private String srchGrpCoId                   ;    /* 검색그룹사 ID                      */
    private String srchUserNum                   ;    /* 검색사용자 번호                    */
    private String srchUserId                    ;    /* 검색사용자 ID                      */
    private String srchUserNm                    ;    /* 검색사용자 명                      */
    private String srchUserPwd                   ;    /* 검색사용자 비밀번호                */
    private String srchUserAuthCd                ;    /* 검색사용자 권한 코드               */
    private String srchDeptId                    ;    /* 검색부서 ID                        */
    private String srchMblNum                    ;    /* 검색모바일 번호                    */
    private String srchPhonNum                   ;    /* 검색전화 번호                      */
    private String srchMailAddr                  ;    /* 검색메일 주소                      */
    private String srchZipNum                    ;    /* 검색우편번호                       */
    private String srchAddr                      ;    /* 검색주소                           */
    private String srchDtlAddr                   ;    /* 검색상세 주소                      */

    private String grpCoId                       ;    /* 그룹사 ID                      */
    private String userNum                       ;    /* 사용자 번호                    */
    private String userId                        ;    /* 사용자 ID                      */
    private String userNm                        ;    /* 사용자 명                      */
    private String userPwd                       ;    /* 사용자 비밀번호                */
    private String userAuthCd                    ;    /* 사용자 권한 코드               */
    private String deptId                        ;    /* 부서 ID                        */
    private String mblNum                        ;    /* 모바일 번호                    */
    private String phonNum                       ;    /* 전화 번호                      */
    private String mailAddr                      ;    /* 메일 주소                      */
    private String zipNum                        ;    /* 우편번호                       */
    private String addr                          ;    /* 주소                           */
    private String dtlAddr                       ;    /* 상세 주소                      */


    public String getSrchGrpCoId() {
        return srchGrpCoId;
    }

    public void setSrchGrpCoId(String srchGrpCoId) {
        this.srchGrpCoId = srchGrpCoId;
    }

    public String getSrchUserNum() {
        return srchUserNum;
    }

    public void setSrchUserNum(String srchUserNum) {
        this.srchUserNum = srchUserNum;
    }

    public String getSrchUserId() {
        return srchUserId;
    }

    public void setSrchUserId(String srchUserId) {
        this.srchUserId = srchUserId;
    }

    public String getSrchUserNm() {
        return srchUserNm;
    }

    public void setSrchUserNm(String srchUserNm) {
        this.srchUserNm = srchUserNm;
    }

    public String getSrchUserPwd() {
        return srchUserPwd;
    }

    public void setSrchUserPwd(String srchUserPwd) {
        this.srchUserPwd = srchUserPwd;
    }

    public String getSrchUserAuthCd() {
        return srchUserAuthCd;
    }

    public void setSrchUserAuthCd(String srchUserAuthCd) {
        this.srchUserAuthCd = srchUserAuthCd;
    }

    public String getSrchDeptId() {
        return srchDeptId;
    }

    public void setSrchDeptId(String srchDeptId) {
        this.srchDeptId = srchDeptId;
    }

    public String getSrchMblNum() {
        return srchMblNum;
    }

    public void setSrchMblNum(String srchMblNum) {
        this.srchMblNum = srchMblNum;
    }

    public String getSrchPhonNum() {
        return srchPhonNum;
    }

    public void setSrchPhonNum(String srchPhonNum) {
        this.srchPhonNum = srchPhonNum;
    }

    public String getSrchMailAddr() {
        return srchMailAddr;
    }

    public void setSrchMailAddr(String srchMailAddr) {
        this.srchMailAddr = srchMailAddr;
    }

    public String getSrchZipNum() {
        return srchZipNum;
    }

    public void setSrchZipNum(String srchZipNum) {
        this.srchZipNum = srchZipNum;
    }

    public String getSrchAddr() {
        return srchAddr;
    }

    public void setSrchAddr(String srchAddr) {
        this.srchAddr = srchAddr;
    }

    public String getSrchDtlAddr() {
        return srchDtlAddr;
    }

    public void setSrchDtlAddr(String srchDtlAddr) {
        this.srchDtlAddr = srchDtlAddr;
    }

    public String getGrpCoId() {
        return grpCoId;
    }

    public void setGrpCoId(String grpCoId) {
        this.grpCoId = grpCoId;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserAuthCd() {
        return userAuthCd;
    }

    public void setUserAuthCd(String userAuthCd) {
        this.userAuthCd = userAuthCd;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getMblNum() {
        return mblNum;
    }

    public void setMblNum(String mblNum) {
        this.mblNum = mblNum;
    }

    public String getPhonNum() {
        return phonNum;
    }

    public void setPhonNum(String phonNum) {
        this.phonNum = phonNum;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

    public String getZipNum() {
        return zipNum;
    }

    public void setZipNum(String zipNum) {
        this.zipNum = zipNum;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDtlAddr() {
        return dtlAddr;
    }

    public void setDtlAddr(String dtlAddr) {
        this.dtlAddr = dtlAddr;
    }

}