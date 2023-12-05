/*-------------------------------------------------------------------
* NAME   : Zcom99020Model
* DESC   : 관리자_메뉴
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

public class Zcom99020Model extends AprjModel {

    private String srchMenuId                    ;    /* 검색메뉴 ID                        */
    private String srchMenuNm                    ;    /* 검색메뉴 명                        */
    private String srchMenuLevVal                ;    /* 검색메뉴 레벨 값                   */
    private String srchSeqNum                    ;    /* 검색순번                           */
    private String srchSupMenuId                 ;    /* 검색상위 메뉴 ID                   */
    private String srchSupMenuNm                 ;    /* 검색상위 메뉴 명                   */
    private String srchActId                     ;    /* 검색ACTION ID                      */
    private String srchUrl                       ;    /* 검색URL                            */
    private String srchMenuCtt                   ;    /* 검색메뉴 내용                      */

    private String menuId                        ;    /* 메뉴 ID                        */
    private String menuNm                        ;    /* 메뉴 명                        */
    private String menuLevVal                    ;    /* 메뉴 레벨 값                   */
    private String seqNum                        ;    /* 순번                           */
    private String supMenuId                     ;    /* 상위 메뉴 ID                   */
    private String supMenuNm                     ;    /* 상위 메뉴 명                   */
    private String actId                         ;    /* ACTION ID                      */
    private String url                           ;    /* URL                            */
    private String menuCtt                       ;    /* 메뉴 내용                      */

    private String userId                        ;    /* 사용자 ID                      */
    private String userAuthCd                    ;    /* 사용자 권한 코드               */
    private String execActId                     ;    /* 실행 ACTION ID                 */
    private String selMenuId                     ;    /* 선택 메뉴 ID                   */

    public String getSrchMenuId() {
        return srchMenuId;
    }

    public void setSrchMenuId(String srchMenuId) {
        this.srchMenuId = srchMenuId;
    }

    public String getSrchMenuNm() {
        return srchMenuNm;
    }

    public void setSrchMenuNm(String srchMenuNm) {
        this.srchMenuNm = srchMenuNm;
    }

    public String getSrchMenuLevVal() {
        return srchMenuLevVal;
    }

    public void setSrchMenuLevVal(String srchMenuLevVal) {
        this.srchMenuLevVal = srchMenuLevVal;
    }

    public String getSrchSeqNum() {
        return srchSeqNum;
    }

    public void setSrchSeqNum(String srchSeqNum) {
        this.srchSeqNum = srchSeqNum;
    }

    public String getSrchSupMenuId() {
        return srchSupMenuId;
    }

    public void setSrchSupMenuId(String srchSupMenuId) {
        this.srchSupMenuId = srchSupMenuId;
    }

    public String getSrchSupMenuNm() {
		return srchSupMenuNm;
	}

	public void setSrchSupMenuNm(String srchSupMenuNm) {
		this.srchSupMenuNm = srchSupMenuNm;
	}

	public String getSrchActId() {
        return srchActId;
    }

    public void setSrchActId(String srchActId) {
        this.srchActId = srchActId;
    }

    public String getSrchUrl() {
        return srchUrl;
    }

    public void setSrchUrl(String srchUrl) {
        this.srchUrl = srchUrl;
    }

    public String getSrchMenuCtt() {
        return srchMenuCtt;
    }

    public void setSrchMenuCtt(String srchMenuCtt) {
        this.srchMenuCtt = srchMenuCtt;
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

    public String getMenuLevVal() {
        return menuLevVal;
    }

    public void setMenuLevVal(String menuLevVal) {
        this.menuLevVal = menuLevVal;
    }

    public String getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(String seqNum) {
        this.seqNum = seqNum;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuCtt() {
        return menuCtt;
    }

    public void setMenuCtt(String menuCtt) {
        this.menuCtt = menuCtt;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAuthCd() {
		return userAuthCd;
	}

	public void setUserAuthCd(String userAuthCd) {
		this.userAuthCd = userAuthCd;
	}

	public String getExecActId() {
		return execActId;
	}

	public void setExecActId(String execActId) {
		this.execActId = execActId;
	}

	public String getSelMenuId() {
		return selMenuId;
	}

	public void setSelMenuId(String selMenuId) {
		this.selMenuId = selMenuId;
	}

}