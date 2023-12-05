/*-------------------------------------------------------------------
* NAME   : Zcom99022Model
* DESC   : 관리자_사용자메뉴
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.model.copy;

import project.spring.app.aprj.lib.object.AprjModel;

public class Zcom99022Model extends AprjModel {

    private String srchSerNum                    ;    /* 검색일련번호                       */
    private String srchMenuId                    ;    /* 검색메뉴 ID                        */

    private String serNum                        ;    /* 일련번호                       */
    private String menuId                        ;    /* 메뉴 ID                        */
    private String menuNm                        ;    /* 메뉴 명                        */
    private String supMenuId                     ;    /* 상위 메뉴 ID                   */
    private String supMenuNm                     ;    /* 상위 메뉴 명                   */
    private String actId                         ;    /* ACTION ID                      */
    private String chkMenuId                     ;    /* CHECK 메뉴 ID                  */


    public String getSrchSerNum() {
        return srchSerNum;
    }

    public void setSrchSerNum(String srchSerNum) {
        this.srchSerNum = srchSerNum;
    }

    public String getSrchMenuId() {
        return srchMenuId;
    }

    public void setSrchMenuId(String srchMenuId) {
        this.srchMenuId = srchMenuId;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

	public String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	public String getSupMenuId() {
		return supMenuId;
	}

	public void setSupMenuId(String supMenuId) {
		this.supMenuId = supMenuId;
	}

	public String getSupMenuNm() {
		return supMenuNm;
	}

	public void setSupMenuNm(String supMenuNm) {
		this.supMenuNm = supMenuNm;
	}

	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getChkMenuId() {
		return chkMenuId;
	}

	public void setChkMenuId(String chkMenuId) {
		this.chkMenuId = chkMenuId;
	}

}