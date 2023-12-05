/*-------------------------------------------------------------------
* NAME   : Aprj10010Model
* DESC   : 설정_자산
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.model;

import project.spring.app.aprj.lib.object.AprjModel;

public class Aprj10020Model extends AprjModel {

    private String srchOpChrgId                  ;    /* 검색업무 담당 ID                   */
    private String srchOpChrgNm                  ;    /* 검색업무 담당 명                   */
    private String srchOpChrgCtt                 ;    /* 검색업무 담당 내용                 */
    private String srchAstClId                   ;    /* 검색자산 구분 ID                   */
    private String srchAstClNm                   ;    /* 검색자산 구분 명                   */
    private String srchAstId                     ;    /* 검색자산 ID                        */
    private String srchAstNm                     ;    /* 검색자산 명                        */
    private String srchUserId                    ;    /* 검색사용자 ID                      */
    private String srchUserNm                    ;    /* 검색사용자 명                      */

    private String opChrgId                      ;    /* 업무 담당 ID                   */
    private String opChrgNm                      ;    /* 업무 담당 명                   */
    private String opChrgCtt                     ;    /* 업무 담당 내용                 */
    private String astClId                       ;    /* 자산 구분 ID                   */
    private String astClNm                       ;    /* 자산 구분 명                   */
    private String astId                         ;    /* 자산 ID                        */
    private String astNm                         ;    /* 자산 명                        */
    private String userId                        ;    /* 사용자 ID                      */
    private String userNm                        ;    /* 사용자 명                      */


    public String getSrchOpChrgId() {
		return srchOpChrgId;
	}

	public void setSrchOpChrgId(String srchOpChrgId) {
		this.srchOpChrgId = srchOpChrgId;
	}

	public String getSrchOpChrgNm() {
		return srchOpChrgNm;
	}

	public void setSrchOpChrgNm(String srchOpChrgNm) {
		this.srchOpChrgNm = srchOpChrgNm;
	}

	public String getSrchOpChrgCtt() {
		return srchOpChrgCtt;
	}

	public void setSrchOpChrgCtt(String srchOpChrgCtt) {
		this.srchOpChrgCtt = srchOpChrgCtt;
	}

	public String getSrchAstClId() {
		return srchAstClId;
	}

	public void setSrchAstClId(String srchAstClId) {
		this.srchAstClId = srchAstClId;
	}

	public String getSrchAstClNm() {
		return srchAstClNm;
	}

	public void setSrchAstClNm(String srchAstClNm) {
		this.srchAstClNm = srchAstClNm;
	}

	public String getSrchAstId() {
		return srchAstId;
	}

	public void setSrchAstId(String srchAstId) {
		this.srchAstId = srchAstId;
	}

	public String getSrchAstNm() {
		return srchAstNm;
	}

	public void setSrchAstNm(String srchAstNm) {
		this.srchAstNm = srchAstNm;
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

	public String getOpChrgId() {
		return opChrgId;
	}

	public void setOpChrgId(String opChrgId) {
		this.opChrgId = opChrgId;
	}

	public String getOpChrgNm() {
		return opChrgNm;
	}

	public void setOpChrgNm(String opChrgNm) {
		this.opChrgNm = opChrgNm;
	}

	public String getOpChrgCtt() {
		return opChrgCtt;
	}

	public void setOpChrgCtt(String opChrgCtt) {
		this.opChrgCtt = opChrgCtt;
	}

	public String getAstClId() {
		return astClId;
	}

	public void setAstClId(String astClId) {
		this.astClId = astClId;
	}

	public String getAstClNm() {
		return astClNm;
	}

	public void setAstClNm(String astClNm) {
		this.astClNm = astClNm;
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

	public String getAstId() {
		return astId;
	}

	public void setAstId(String astId) {
		this.astId = astId;
	}

	public String getAstNm() {
		return astNm;
	}

	public void setAstNm(String astNm) {
		this.astNm = astNm;
	}

}