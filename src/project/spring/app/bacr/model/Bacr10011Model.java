/*-------------------------------------------------------------------
* NAME   : Bacr10011Model
* DESC   : 기본정보 그룹
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

public class Bacr10011Model extends BacrModel {

    private String srchPvlId                     ;    /* 검색정 ID                          */
    private String srchGrpSerNum                 ;    /* 검색그룹 일련번호                  */
    private String srchGrpNm                     ;    /* 검색그룹 명                        */

    private String pvlId                         ;    /* 정 ID                          */
    private String grpSerNum                     ;    /* 그룹 일련번호                  */
    private String grpNm                         ;    /* 그룹 명                        */


    public String getSrchPvlId() {
        return srchPvlId;
    }

    public void setSrchPvlId(String srchPvlId) {
        this.srchPvlId = srchPvlId;
    }

    public String getSrchGrpSerNum() {
        return srchGrpSerNum;
    }

    public void setSrchGrpSerNum(String srchGrpSerNum) {
        this.srchGrpSerNum = srchGrpSerNum;
    }

    public String getSrchGrpNm() {
        return srchGrpNm;
    }

    public void setSrchGrpNm(String srchGrpNm) {
        this.srchGrpNm = srchGrpNm;
    }

    public String getPvlId() {
        return pvlId;
    }

    public void setPvlId(String pvlId) {
        this.pvlId = pvlId;
    }

    public String getGrpSerNum() {
        return grpSerNum;
    }

    public void setGrpSerNum(String grpSerNum) {
        this.grpSerNum = grpSerNum;
    }

    public String getGrpNm() {
        return grpNm;
    }

    public void setGrpNm(String grpNm) {
        this.grpNm = grpNm;
    }

}