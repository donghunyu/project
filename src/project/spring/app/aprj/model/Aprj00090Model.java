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

public class Aprj00090Model extends AprjModel {

    private String workId                        ;    /* 작업 ID                        */
    private String workNm                        ;    /* 작업 명                        */
    private String fileNm                        ;    /* 파일 명                        */
    
    
	public String getWorkId() {
		return workId;
	}
	
	public void setWorkId(String workId) {
		this.workId = workId;
	}

	public String getWorkNm() {
		return workNm;
	}

	public void setWorkNm(String workNm) {
		this.workNm = workNm;
	}

	public String getFileNm() {
		return fileNm;
	}

	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}

}