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

public class Aprj10010Model extends AprjModel {

    private String srchAstClId                   ;    /* 검색자산 구분 ID                   */
    private String srchAstClNm                   ;    /* 검색자산 구분 명                   */
    private String srchAstClCtt                  ;    /* 검색자산 구분 내용                 */
    private String srchAstId                     ;    /* 검색자산 ID                        */
    private String srchAstNm                     ;    /* 검색자산 명                        */
    private String srchAstCtt                    ;    /* 검색자산 내용                      */

    private String astClId                       ;    /* 자산 구분 ID                   */
    private String astClNm                       ;    /* 자산 구분 명                   */
    private String astClCtt                      ;    /* 자산 구분 내용                 */
    private String astId                         ;    /* 자산 ID                        */
    private String astNm                         ;    /* 자산 명                        */
    private String astCtt                        ;    /* 자산 내용                      */
    
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

	public String getSrchAstClCtt() {
		return srchAstClCtt;
	}

	public void setSrchAstClCtt(String srchAstClCtt) {
		this.srchAstClCtt = srchAstClCtt;
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

	public String getSrchAstCtt() {
		return srchAstCtt;
	}

	public void setSrchAstCtt(String srchAstCtt) {
		this.srchAstCtt = srchAstCtt;
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

	public String getAstClCtt() {
		return astClCtt;
	}

	public void setAstClCtt(String astClCtt) {
		this.astClCtt = astClCtt;
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

	public String getAstCtt() {
		return astCtt;
	}

	public void setAstCtt(String astCtt) {
		this.astCtt = astCtt;
	}


}