/*-------------------------------------------------------------------
* NAME   : Zcom99011Model
* DESC   : 관리자_코드
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

public class Zcom99011Model extends ZcomModel {

    private String srchGrpCd                     ;    /* 검색그룹 코드                      */
    private String srchCd                        ;    /* 검색코드                           */
    private String srchCdNm                      ;    /* 검색코드 명                        */
    private String srchSerNum                    ;    /* 검색일련번호                       */
    private String srchCdCtt                     ;    /* 검색코드 내용                      */

    private String grpCd                         ;    /* 그룹 코드                      */
    private String grpCdNm                       ;    /* 그룹 코드명                    */
    private String cd                            ;    /* 코드                           */
    private String cdNm                          ;    /* 코드 명                        */
    private String serNum                        ;    /* 일련번호                       */
    private String cdCtt                         ;    /* 코드 내용                      */


    public String getSrchGrpCd() {
        return srchGrpCd;
    }

    public void setSrchGrpCd(String srchGrpCd) {
        this.srchGrpCd = srchGrpCd;
    }

    public String getSrchCd() {
        return srchCd;
    }

    public void setSrchCd(String srchCd) {
        this.srchCd = srchCd;
    }

    public String getSrchCdNm() {
        return srchCdNm;
    }

    public void setSrchCdNm(String srchCdNm) {
        this.srchCdNm = srchCdNm;
    }

    public String getSrchSerNum() {
        return srchSerNum;
    }

    public void setSrchSerNum(String srchSerNum) {
        this.srchSerNum = srchSerNum;
    }

    public String getSrchCdCtt() {
        return srchCdCtt;
    }

    public void setSrchCdCtt(String srchCdCtt) {
        this.srchCdCtt = srchCdCtt;
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

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getCdNm() {
        return cdNm;
    }

    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public String getCdCtt() {
        return cdCtt;
    }

    public void setCdCtt(String cdCtt) {
        this.cdCtt = cdCtt;
    }

}