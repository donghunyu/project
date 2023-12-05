/*-------------------------------------------------------------------
* NAME   : Zcom99021Model
* DESC   : 관리자_메뉴권한
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

public class Zcom99021Model extends AprjModel {

    private String srchSerNum                    ;    /* 검색일련번호                       */
    private String srchMenuAuthCd                ;    /* 검색메뉴 권한 코드                 */
    private String srchUserAuthCd                ;    /* 검색사용자 권한 코드               */
    private String srchUserId                    ;    /* 검색사용자 ID                      */
    private String srchUserNm                    ;    /* 검색사용자 명                      */

    private String serNum                        ;    /* 일련번호                       */
    private String menuAuthCd                    ;    /* 메뉴 권한 코드                 */
    private String menuAuthNm                    ;    /* 메뉴 권한 명                   */
    private String userAuthCd                    ;    /* 사용자 권한 코드               */
    private String userAuthNm                    ;    /* 사용자 권한 명                 */
    private String userId                        ;    /* 사용자 ID                      */
    private String userNm                        ;    /* 사용자 명                      */


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

	public String getMenuAuthNm() {
		return menuAuthNm;
	}

	public void setMenuAuthNm(String menuAuthNm) {
		this.menuAuthNm = menuAuthNm;
	}

	public String getUserAuthCd() {
		return userAuthCd;
	}

	public void setUserAuthCd(String userAuthCd) {
		this.userAuthCd = userAuthCd;
	}

	public String getUserAuthNm() {
		return userAuthNm;
	}

	public void setUserAuthNm(String userAuthNm) {
		this.userAuthNm = userAuthNm;
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

}