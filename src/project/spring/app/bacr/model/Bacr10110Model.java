/*-------------------------------------------------------------------
* NAME   : Bacr10110Model
* DESC   : 기본정보_회원정
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

public class Bacr10110Model extends BacrModel {

    private String srchPvlId                     ;    /* 검색정 ID                          */
    private String srchMbNum                     ;    /* 검색회원 번호                      */
    private String srchSerNum                    ;    /* 검색일련번호                       */

    private String pvlId                         ;    /* 정 ID                          */
    private String mbNum                         ;    /* 회원 번호                      */
    private String serNum                        ;    /* 일련번호                       */


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

    public String getSrchSerNum() {
        return srchSerNum;
    }

    public void setSrchSerNum(String srchSerNum) {
        this.srchSerNum = srchSerNum;
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

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

}