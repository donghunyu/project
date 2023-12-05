/*-------------------------------------------------------------------
* NAME   : Zcom99021Model
* DESC   : 관리자_메뉴권한
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

public class Zcom99021Model extends ZcomModel {

    private String srchSerNum                    ;    /* 검색일련번호                       */
    private String srchMenuAuthCd                ;    /* 검색메뉴 권한 코드                 */
    private String srchUserAuthCd                ;    /* 검색사용자 권한 코드               */
    private String srchUserNum                   ;    /* 검색사용자 번호                    */

    private String serNum                        ;    /* 일련번호                       */
    private String menuAuthCd                    ;    /* 메뉴 권한 코드                 */
    private String menuAuthCdNm                  ;    /* 메뉴 권한 코드명               */
    private String userAuthCd                    ;    /* 사용자 권한 코드               */
    private String userAuthCdNm                  ;    /* 사용자 권한 코드명             */
    private String userNum                       ;    /* 사용자 번호                    */


    public String getSrchSerNum() {
        return srchSerNum;
    }

    public void setSrchSerNum(String srchSerNum) {
        this.srchSerNum = srchSerNum;
    }

    public String getSrchMenuAuthCd() {
        return srchMenuAuthCd;
    }

    public void setSrchMenuAuthCd(String srchMenuAuthCd) {
        this.srchMenuAuthCd = srchMenuAuthCd;
    }

    public String getSrchUserAuthCd() {
        return srchUserAuthCd;
    }

    public void setSrchUserAuthCd(String srchUserAuthCd) {
        this.srchUserAuthCd = srchUserAuthCd;
    }

    public String getSrchUserNum() {
        return srchUserNum;
    }

    public void setSrchUserNum(String srchUserNum) {
        this.srchUserNum = srchUserNum;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public String getMenuAuthCd() {
        return menuAuthCd;
    }

    public void setMenuAuthCd(String menuAuthCd) {
        this.menuAuthCd = menuAuthCd;
    }

    public String getMenuAuthCdNmNm() {
        return menuAuthCdNm;
    }

    public void setMenuAuthCdNmNm(String menuAuthCdNm) {
        this.menuAuthCdNm = menuAuthCdNm;
    }

    public String getUserAuthCd() {
        return userAuthCd;
    }

    public void setUserAuthCd(String userAuthCd) {
        this.userAuthCd = userAuthCd;
    }

    public String getUserAuthCdNmNm() {
        return userAuthCdNm;
    }

    public void setUserAuthCdNmNm(String userAuthCdNm) {
        this.userAuthCdNm = userAuthCdNm;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

}