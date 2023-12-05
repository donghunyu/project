/*-------------------------------------------------------------------
* NAME   : Zcom99022Model
* DESC   : 관리자_권한별메뉴
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

public class Zcom99022Model extends ZcomModel {

    private String srchMenuId                    ;    /* 검색메뉴 ID                        */
    private String srchSerNum                    ;    /* 검색일련번호                       */

    private String menuId                        ;    /* 메뉴 ID                        */
    private String serNum                        ;    /* 일련번호                       */


    public String getSrchMenuId() {
        return srchMenuId;
    }

    public void setSrchMenuId(String srchMenuId) {
        this.srchMenuId = srchMenuId;
    }

    public String getSrchSerNum() {
        return srchSerNum;
    }

    public void setSrchSerNum(String srchSerNum) {
        this.srchSerNum = srchSerNum;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

}