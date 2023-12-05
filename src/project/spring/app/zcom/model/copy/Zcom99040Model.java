/*-------------------------------------------------------------------
* NAME   : Zcom99040Model
* DESC   : 관리자_임시로그인
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

public class Zcom99040Model extends AprjModel {

    private String srchTmpLoginId                ;    /* 검색임시 로그인 ID                 */
    private String srchUserId                    ;    /* 검색사용자 ID                      */
    private String srchUserNm                    ;    /* 검색사용자 ID                      */
    private String srchScrUrl                    ;    /* 검색화면 URL                       */

    private String tmpLoginId                    ;    /* 임시 로그인 ID                 */
    private String userId                        ;    /* 사용자 ID                      */
    private String userNm                        ;    /* 사용자 명                      */
    private String scrUrl                        ;    /* 화면 URL                       */


    public String getSrchTmpLoginId() {
        return srchTmpLoginId;
    }

    public void setSrchTmpLoginId(String srchTmpLoginId) {
        this.srchTmpLoginId = srchTmpLoginId;
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

	public String getSrchScrUrl() {
        return srchScrUrl;
    }

    public void setSrchScrUrl(String srchScrUrl) {
        this.srchScrUrl = srchScrUrl;
    }

    public String getTmpLoginId() {
        return tmpLoginId;
    }

    public void setTmpLoginId(String tmpLoginId) {
        this.tmpLoginId = tmpLoginId;
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

	public String getScrUrl() {
        return scrUrl;
    }

    public void setScrUrl(String scrUrl) {
        this.scrUrl = scrUrl;
    }

}