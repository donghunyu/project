/*-------------------------------------------------------------------
* NAME   : Bacr10010Model
* DESC   : 기본정보_정
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

public class Bacr10010Model extends BacrModel {

    private String srchPvlId                     ;    /* 검색정 ID                          */
    private String srchPvlNm                     ;    /* 검색정 명                          */
    private String srchZipNum                    ;    /* 검색우편번호                       */
    private String srchAddr                      ;    /* 검색주소                           */
    private String srchDtlAddr                   ;    /* 검색상세 주소                      */
    private String srchPvlGrpCd                  ;    /* 검색정 그룹 코드                   */

    private String pvlId                         ;    /* 정 ID                          */
    private String pvlNm                         ;    /* 정 명                          */
    private String zipNum                        ;    /* 우편번호                       */
    private String addr                          ;    /* 주소                           */
    private String dtlAddr                       ;    /* 상세 주소                      */
    private String pvlGrpCd                      ;    /* 정 그룹 코드                   */


    public String getSrchPvlId() {
        return srchPvlId;
    }

    public void setSrchPvlId(String srchPvlId) {
        this.srchPvlId = srchPvlId;
    }

    public String getSrchPvlNm() {
        return srchPvlNm;
    }

    public void setSrchPvlNm(String srchPvlNm) {
        this.srchPvlNm = srchPvlNm;
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

    public String getSrchPvlGrpCd() {
        return srchPvlGrpCd;
    }

    public void setSrchPvlGrpCd(String srchPvlGrpCd) {
        this.srchPvlGrpCd = srchPvlGrpCd;
    }

    public String getPvlId() {
        return pvlId;
    }

    public void setPvlId(String pvlId) {
        this.pvlId = pvlId;
    }

    public String getPvlNm() {
        return pvlNm;
    }

    public void setPvlNm(String pvlNm) {
        this.pvlNm = pvlNm;
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

    public String getPvlGrpCd() {
        return pvlGrpCd;
    }

    public void setPvlGrpCd(String pvlGrpCd) {
        this.pvlGrpCd = pvlGrpCd;
    }

}