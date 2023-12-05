/*-------------------------------------------------------------------
* NAME   : Bacr10020Model
* DESC   : 기본정보 과녁
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

public class Bacr10020Model extends BacrModel {

    private String srchPvlId                     ;    /* 검색정 ID                          */
    private String srchSerNum                    ;    /* 검색일련번호                       */
    private String srchTgNm                      ;    /* 검색과녁 명                        */

    private String pvlId                         ;    /* 정 ID                          */
    private String serNum                        ;    /* 일련번호                       */
    private String tgNm                          ;    /* 과녁 명                        */


    public String getSrchPvlId() {
        return srchPvlId;
    }

    public void setSrchPvlId(String srchPvlId) {
        this.srchPvlId = srchPvlId;
    }

    public String getSrchSerNum() {
        return srchSerNum;
    }

    public void setSrchSerNum(String srchSerNum) {
        this.srchSerNum = srchSerNum;
    }

    public String getSrchTgNm() {
        return srchTgNm;
    }

    public void setSrchTgNm(String srchTgNm) {
        this.srchTgNm = srchTgNm;
    }

    public String getPvlId() {
        return pvlId;
    }

    public void setPvlId(String pvlId) {
        this.pvlId = pvlId;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public String getTgNm() {
        return tgNm;
    }

    public void setTgNm(String tgNm) {
        this.tgNm = tgNm;
    }

}