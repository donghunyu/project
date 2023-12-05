/*-------------------------------------------------------------------
* NAME   : Zcom99010Model
* DESC   : 관리자_그룹코드
* DATE   : 2023-03-21
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.model;

import project.spring.app.zcom.lib.object.ZcomModel;

public class Zcom99010Model extends ZcomModel {

    private String srchGrpCd                     ;    /* 검색그룹 코드                      */
    private String srchGrpCdNm                   ;    /* 검색그룹 코드 명                   */
    private String srchGrpCdCtt                  ;    /* 검색그룹 코드 내용                 */

    private String grpCd                         ;    /* 그룹 코드                      */
    private String grpCdNm                       ;    /* 그룹 코드명                    */
    private String grpCdCtt                      ;    /* 그룹 코드 내용                 */


    public String getSrchGrpCd() {
        return srchGrpCd;
    }

    public void setSrchGrpCd(String srchGrpCd) {
        this.srchGrpCd = srchGrpCd;
    }

    public String getSrchGrpCdNm() {
        return srchGrpCdNm;
    }

    public void setSrchGrpCdNm(String srchGrpCdNm) {
        this.srchGrpCdNm = srchGrpCdNm;
    }

    public String getSrchGrpCdCtt() {
        return srchGrpCdCtt;
    }

    public void setSrchGrpCdCtt(String srchGrpCdCtt) {
        this.srchGrpCdCtt = srchGrpCdCtt;
    }

    public String getGrpCd() {
        return grpCd;
    }

    public void setGrpCd(String grpCd) {
        this.grpCd = grpCd;
    }

    public String getGrpCdNmNm() {
        return grpCdNm;
    }

    public void setGrpCdNmNm(String grpCdNm) {
        this.grpCdNm = grpCdNm;
    }

    public String getGrpCdCtt() {
        return grpCdCtt;
    }

    public void setGrpCdCtt(String grpCdCtt) {
        this.grpCdCtt = grpCdCtt;
    }

}