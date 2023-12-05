/*-------------------------------------------------------------------
* NAME   : Aprj20011Model
* DESC   : 프로젝트_첨부파일
* DATE   : 2018-11-16
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.model;

import java.text.DecimalFormat;

import project.spring.app.aprj.lib.object.AprjModel;

public class Aprj20011Model extends AprjModel {

    private String srchCoId                      ;    /* 검색업체 ID                        */
    private String srchPrjSerNum                 ;    /* 검색프로젝트 일련번호              */
    private String srchFileSerNum                ;    /* 검색파일 일련번호                  */
    private String srchCtrlSerNum                ;    /* 검색통제 일련번호                  */
    private String srchOpSerNum                  ;    /* 검색업무 일련번호                  */
    private String srchReqSerNum                 ;    /* 검색요청 일련번호                  */
    private String srchResSerNum                 ;    /* 검색응답 일련번호                  */
    private String srchLgcFileNm                 ;    /* 검색논리 파일 명                   */
    private String srchPscFileNm                 ;    /* 검색물리 파일 명                   */
    private String srchFilePath                  ;    /* 검색파일 경로                      */
    private String srchFileSize                  ;    /* 검색파일 크기                      */
    private String srchDloadCnt                  ;    /* 검색다운로드 수                    */

    private String coId                          ;    /* 업체 ID                        */
    private String fileSerNum                    ;    /* 파일 일련번호                  */
    private String prjId                         ;    /* 프로젝트 ID                    */
    private String opId                          ;    /* 업무 ID                        */
    private String opSerNum                      ;    /* 업무 일련번호                  */
    private String lgcFileNm                     ;    /* 논리 파일 명                   */
    private String pscFileNm                     ;    /* 물리 파일 명                   */
    private String filePath                      ;    /* 파일 경로                      */
    private String fileSize                      ;    /* 파일 크기                      */
    private String dloadCnt                      ;    /* 다운로드 수                    */


    public String getSrchCoId() {
        return srchCoId;
    }

    public void setSrchCoId(String srchCoId) {
        this.srchCoId = srchCoId;
    }

    public String getSrchPrjSerNum() {
        return srchPrjSerNum;
    }

    public void setSrchPrjSerNum(String srchPrjSerNum) {
        this.srchPrjSerNum = srchPrjSerNum;
    }

    public String getSrchFileSerNum() {
        return srchFileSerNum;
    }

    public void setSrchFileSerNum(String srchFileSerNum) {
        this.srchFileSerNum = srchFileSerNum;
    }

    public String getSrchCtrlSerNum() {
		return srchCtrlSerNum;
	}

	public void setSrchCtrlSerNum(String srchCtrlSerNum) {
		this.srchCtrlSerNum = srchCtrlSerNum;
	}

	public String getSrchOpSerNum() {
        return srchOpSerNum;
    }

    public void setSrchOpSerNum(String srchOpSerNum) {
        this.srchOpSerNum = srchOpSerNum;
    }

    public String getSrchReqSerNum() {
        return srchReqSerNum;
    }

    public void setSrchReqSerNum(String srchReqSerNum) {
        this.srchReqSerNum = srchReqSerNum;
    }

    public String getSrchResSerNum() {
        return srchResSerNum;
    }

    public void setSrchResSerNum(String srchResSerNum) {
        this.srchResSerNum = srchResSerNum;
    }

    public String getSrchLgcFileNm() {
        return srchLgcFileNm;
    }

    public void setSrchLgcFileNm(String srchLgcFileNm) {
        this.srchLgcFileNm = srchLgcFileNm;
    }

    public String getSrchPscFileNm() {
        return srchPscFileNm;
    }

    public void setSrchPscFileNm(String srchPscFileNm) {
        this.srchPscFileNm = srchPscFileNm;
    }

    public String getSrchFilePath() {
        return srchFilePath;
    }

    public void setSrchFilePath(String srchFilePath) {
        this.srchFilePath = srchFilePath;
    }

    public String getSrchFileSize() {
        return srchFileSize;
    }

    public void setSrchFileSize(String srchFileSize) {
        this.srchFileSize = srchFileSize;
    }

    public String getSrchDloadCnt() {
        return srchDloadCnt;
    }

    public void setSrchDloadCnt(String srchDloadCnt) {
        this.srchDloadCnt = srchDloadCnt;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getFileSerNum() {
        return fileSerNum;
    }

    public void setFileSerNum(String fileSerNum) {
        this.fileSerNum = fileSerNum;
    }

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getOpId() {
		return opId;
	}

	public void setOpId(String opId) {
		this.opId = opId;
	}

	public String getOpSerNum() {
        return opSerNum;
    }

    public void setOpSerNum(String opSerNum) {
        this.opSerNum = opSerNum;
    }

    public String getLgcFileNm() {
        return lgcFileNm;
    }

    public void setLgcFileNm(String lgcFileNm) {
        this.lgcFileNm = lgcFileNm;
    }

    public String getPscFileNm() {
        return pscFileNm;
    }

    public void setPscFileNm(String pscFileNm) {
        this.pscFileNm = pscFileNm;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return fileSize;
    }

    public String getFileSizeFormat() {
    	long size = 0;
    	try {
    		size = Long.parseLong(fileSize);
    	} catch ( Exception e ) {
    	}
    	
        if ( size <= 0 ) return "0";
        final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
        
        int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getDloadCnt() {
        return dloadCnt;
    }

    public void setDloadCnt(String dloadCnt) {
        this.dloadCnt = dloadCnt;
    }

}