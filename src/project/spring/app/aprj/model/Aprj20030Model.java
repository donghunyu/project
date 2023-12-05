/*-------------------------------------------------------------------
* NAME   : Aprj20030Model
* DESC   : 프로젝트_업무버전
* DATE   : 2018-11-22
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
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.StringUtil;

public class Aprj20030Model extends AprjModel {

    private String srchOpId                      ;    /* 검색업무 ID                        */
    private String srchOpSerNum                  ;    /* 검색업무 일련번호                  */
    private String srchOpSeqNum                  ;    /* 검색업무 순번                      */
    private String srchReqTypCd                  ;    /* 검색요청 종류 코드                 */
    private String srchOpNm                      ;    /* 검색업무 명                        */
    private String srchOpCtt                     ;    /* 검색업무 내용                      */
    private String srchCyclId                    ;    /* 검색주기 ID                        */
    private String srchStmId                     ;    /* 검색결제 ID                        */
    private String srchTranDt                    ;    /* 검색처리 일자                      */
    private String srchTranStCd                  ;    /* 검색처리 상태 코드                 */

    private String srchPrjId                     ;    /* 검색프로젝트 ID                    */
    private String srchPrjNm                     ;    /* 검색프로젝트 명                    */

    private String srchCtrlNum                   ;    /* 검색통제 번호                      */
    private String srchCtrlNm                    ;    /* 검색통제 명                        */
    
    private String srchOpChrgUser                ;    /* 검색업무 담당 사용자               */
    private String srchOpChrgId                  ;    /* 검색업무 담당 ID                   */
    private String srchOpChrgNm                  ;    /* 검색업무 담당 명                   */
    private String srchUserId                    ;    /* 검색사용자 ID                      */
    private String srchUserNm                    ;    /* 검색사용자 명                      */
    
    private String srchStmUserId                 ;    /* 검색사용자 ID                      */
    private String srchStmUserNm                 ;    /* 검색사용자 명                      */

    private String srchResStCd                   ;    /* 검색응답 상태 코드                 */
    private String srchSignClCd                  ;    /* 검색서명 구분 코드                 */

    private String opId                          ;    /* 업무 ID                        */
    private String opSerNum                      ;    /* 업무 일련번호                  */
    private String verUpOpSerNum                 ;    /* 버전 업 업무 일련번호          */
    private String opSeqNum                      ;    /* 업무 순번                      */
    private String opVer                         ;    /* 요청 버전                      */
    private String opNm                          ;    /* 업무 명                        */
    private String opCtt                         ;    /* 업무 내용                      */
    private String drftDeptId                    ;    /* 기안 부서 ID                   */
    private String drftDeptNm                    ;    /* 기안 부서 명                   */
    private String drftOpChrgId                  ;    /* 기안 업무 담당 ID              */
    private String drftOpChrgNm                  ;    /* 기안 업무 담당 명              */
    private String drftUserId                    ;    /* 기안 사용자 ID                 */
    private String drftUserNm                    ;    /* 기안 사용자 명                 */
    private String cyclId                        ;    /* 주기 ID                        */
    private String cyclNm                        ;    /* 주기 명                        */
    private String stmId                         ;    /* 결제 ID                        */
    private String stmNm                         ;    /* 결제 명                        */
    private String tranDt                        ;    /* 처리 일자                      */
    private String tranStCd                      ;    /* 처리 상태 코드                 */
    private String tranStNm                      ;    /* 처리 상태 명                   */
    private String autoClCd                      ;    /* 자동 구분 코드                 */
    private String autoClNm                      ;    /* 자동 구분 명                   */

    private String prdCnt                        ;    /* 기간 수                        */
    private String cyclClCd                      ;    /* 주기 구분 코드                 */
    private String cyclClNm                      ;    /* 주기 구분 명                   */
    private String stdDt                         ;    /* 기준 일자                      */
    private String stdH                          ;    /* 기준 시                        */
    
    private String stmSerNum                     ;    /* 결제 일련번호                  */
    private String stmSeqNum                     ;    /* 결제 순번                      */
    private String stmClCd                       ;    /* 결제 구분 코드                 */
    private String stmClNm                       ;    /* 결제 구분 코드                 */
    private String stmAuthCd                     ;    /* 결제 권한 코드                 */
    private String stmAuthNm                     ;    /* 결제 권한 명                   */
    private String stmDeptId                     ;    /* 결제 부서 ID                   */
    private String stmDeptNm                     ;    /* 결제 부서 명                   */
    private String stmOpChrgId                   ;    /* 결제 업무 담당 ID              */
    private String stmOpChrgNm                   ;    /* 결제 업무 담당 명              */
    private String stmUserId                     ;    /* 결제 사용자 ID                 */
    private String stmUserNm                     ;    /* 결제 사용자 명                 */
    private String signClCd                      ;    /* 서명 구분 코드                 */
    private String signClNm                      ;    /* 서명 구분 명                   */
    private String signDtm                       ;    /* 서명 일시                      */
    private String blcinVal                      ;    /* 블록체인 값                    */
    private String signFilePath                  ;    /* 서명 파일 경로                 */
    private String signCtt                       ;    /* 서명 내용                      */
    private String deptId                        ;    /* 부서 ID                        */
    private String deptNm                        ;    /* 부서 명                        */
    private String supDeptId                     ;    /* 상위 부서 ID                   */
    private String supDeptNm                     ;    /* 상위 부서 명                   */

    private String opChrgUser                    ;    /* 업무 담당 사용자               */
    private String opChrgId                      ;    /* 업무 담당 ID                   */
    private String opChrgNm                      ;    /* 업무 담당 명                   */
    private String opChrgCtt                     ;    /* 업무 담당 내용                 */
    private String userId                        ;    /* 사용자 ID                      */
    private String userNm                        ;    /* 사용자 명                      */
    private String phonNum                       ;    /* 전화 번호                      */
    private String mailAddr                      ;    /* 메일 주소                      */
    
    private String trnsfSerNum                   ;    /* 이관 일련번호                  */
    private String trnsfOpChrgId                 ;    /* 이관 업무 담당 ID              */
    private String trnsfOpChrgNm                 ;    /* 이관 업무 담당 명              */
    private String trnsfUserId                   ;    /* 이관 사용자 ID                 */
    private String trnsfUserNm                   ;    /* 이관 사용자 명                 */
    private String trnsfCtt                      ;    /* 이관 내용                      */
    private String trnsfTranCd                   ;    /* 이관 처리 코드                 */
    private String trnsfTranNm                   ;    /* 이관 처리 명                   */
    private String trnsfDtm                      ;    /* 이관 일시                      */
    private String trnsfTranCtt                  ;    /* 이관 처리 내용                 */

    private String prjId                         ;    /* 프로젝트 ID                    */
    private String prjNm                         ;    /* 프로젝트 명                    */
    private String prjVer                        ;    /* 프로젝트 버전                  */
    private String prjCtt                        ;    /* 프로젝트 내용                  */
    private String procStCd                      ;    /* 진행 상태 코드                 */
    private String procStNm                      ;    /* 진행 상태 명                   */

    private String ctrlNum                       ;    /* 통제 번호                      */
    private String opCtrlNum                     ;    /* 업무 통제 번호                 */
    private String ctrlNm                        ;    /* 통제 명                        */
    private String ctrlCtt                       ;    /* 통제 내용                      */

    private String reqSerNum                     ;    /* 요청 일련번호                  */
    private String reqSeqNum                     ;    /* 요청 순번                      */
    private String reqTypCd                      ;    /* 요청 종류 코드                 */
    private String reqTypNm                      ;    /* 요청 종류 명                   */
    private String reqId                         ;    /* 요청 ID                        */
    private String reqCtt                        ;    /* 요청 내용                      */

    private String itmSerNum                     ;    /* 항목 일련번호                  */
    private String itmVal                        ;    /* 항목 값                        */
    private String itmCtt                        ;    /* 항목 내용                      */
    private String itmCnt                        ;    /* 항목 수                        */
    
    private String astClId                       ;    /* 자산 구분 ID                   */
    private String astClNm                       ;    /* 자산 구분 명                   */
    private String astId                         ;    /* 자산 ID                        */
    private String astNm                         ;    /* 자산 명                        */
    private String astCtt                        ;    /* 자산 내용                      */
    
    private String resItmSerNum                  ;    /* 응답 항목 일련번호             */
    private String resSerNum                     ;    /* 응답 일련번호                  */
    private String rgstClCd                      ;    /* 등록 구분 코드                 */
    private String rgstClNm                      ;    /* 등록 구분 명                   */
    private String resId                         ;    /* 응답 ID                        */
    private String resCtt                        ;    /* 응답 내용                      */
    private String resStCd                       ;    /* 응답 상태 코드                 */
    private String resStNm                       ;    /* 응답 상태 명                   */
    private String resDt                         ;    /* 응답 일자                      */
    
    private String fileSerNum                    ;    /* 파일 일련번호                  */
    private String lgcFileNm                     ;    /* 논리 파일 명                   */
    private String pscFileNm                     ;    /* 물리 파일 명                   */
    private String filePath                      ;    /* 파일 경로                      */
    private String fileSize                      ;    /* 파일 크기                      */
    private String dloadCnt                      ;    /* 다운로드 수                    */
    
    private String srchUserAuthCd                ;    /* 검색사용자 권한 코드               */
    private String userCnt                       ;    /* 사용자 수                      */
    private String opCnt                         ;    /* 업무 수                        */
    private String userAuthCd                    ;    /* 사용자 권한 코드               */
    private String userAuthNm                    ;    /* 사용자 권한 명                 */
    
    
    public String getSrchOpId() {
		return srchOpId;
	}

	public void setSrchOpId(String srchOpId) {
		this.srchOpId = srchOpId;
	}

	public String getSrchOpSerNum() {
		return srchOpSerNum;
	}

	public void setSrchOpSerNum(String srchOpSerNum) {
		this.srchOpSerNum = srchOpSerNum;
	}

	public String getSrchOpSeqNum() {
		return srchOpSeqNum;
	}

	public void setSrchOpSeqNum(String srchOpSeqNum) {
		this.srchOpSeqNum = srchOpSeqNum;
	}

	public String getSrchReqTypCd() {
		return srchReqTypCd;
	}

	public void setSrchReqTypCd(String srchReqTypCd) {
		this.srchReqTypCd = srchReqTypCd;
	}

	public String getSrchOpNm() {
		return srchOpNm;
	}

	public void setSrchOpNm(String srchOpNm) {
		this.srchOpNm = srchOpNm;
	}

	public String getSrchOpCtt() {
		return srchOpCtt;
	}

	public void setSrchOpCtt(String srchOpCtt) {
		this.srchOpCtt = srchOpCtt;
	}

	public String getSrchCyclId() {
		return srchCyclId;
	}

	public void setSrchCyclId(String srchCyclId) {
		this.srchCyclId = srchCyclId;
	}

	public String getSrchStmId() {
		return srchStmId;
	}

	public void setSrchStmId(String srchStmId) {
		this.srchStmId = srchStmId;
	}

	public String getSrchTranDt() {
		return srchTranDt;
	}

	public void setSrchTranDt(String srchTranDt) {
		this.srchTranDt = srchTranDt;
	}

	public String getSrchTranStCd() {
		return srchTranStCd;
	}

	public void setSrchTranStCd(String srchTranStCd) {
		this.srchTranStCd = srchTranStCd;
	}

	public String getSrchPrjId() {
		return srchPrjId;
	}

	public void setSrchPrjId(String srchPrjId) {
		this.srchPrjId = srchPrjId;
	}

	public String getSrchPrjNm() {
		return srchPrjNm;
	}

	public void setSrchPrjNm(String srchPrjNm) {
		this.srchPrjNm = srchPrjNm;
	}

	public String getSrchCtrlNum() {
		return srchCtrlNum;
	}

	public void setSrchCtrlNum(String srchCtrlNum) {
		this.srchCtrlNum = srchCtrlNum;
	}

	public String getSrchCtrlNm() {
		return srchCtrlNm;
	}

	public void setSrchCtrlNm(String srchCtrlNm) {
		this.srchCtrlNm = srchCtrlNm;
	}

	public String getSrchOpChrgUser() {
		return srchOpChrgUser;
	}

	public void setSrchOpChrgUser(String srchOpChrgUser) {
		this.srchOpChrgUser = srchOpChrgUser;
		if ( !StringUtil.isNull(this.srchOpChrgUser) ) {
			String[] temp = this.srchOpChrgUser.split("_");
			
			this.setSrchOpChrgId(temp[0]);
			this.setSrchUserId  (temp[1]);
		}
	}

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

	public String getSrchStmUserId() {
		return srchStmUserId;
	}

	public void setSrchStmUserId(String srchStmUserId) {
		this.srchStmUserId = srchStmUserId;
	}

	public String getSrchStmUserNm() {
		return srchStmUserNm;
	}

	public void setSrchStmUserNm(String srchStmUserNm) {
		this.srchStmUserNm = srchStmUserNm;
	}

	public String getSrchResStCd() {
		return srchResStCd;
	}

	public void setSrchResStCd(String srchResStCd) {
		this.srchResStCd = srchResStCd;
	}

	public String getSrchSignClCd() {
		return srchSignClCd;
	}

	public void setSrchSignClCd(String srchSignClCd) {
		this.srchSignClCd = srchSignClCd;
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

	public String getVerUpOpSerNum() {
		return verUpOpSerNum;
	}

	public void setVerUpOpSerNum(String verUpOpSerNum) {
		this.verUpOpSerNum = verUpOpSerNum;
	}

	public String getOpSeqNum() {
		return opSeqNum;
	}

	public void setOpSeqNum(String opSeqNum) {
		this.opSeqNum = opSeqNum;
	}

	public String getOpVer() {
		return opVer;
	}

	public void setOpVer(String opVer) {
		this.opVer = opVer;
	}

	public String getOpNm() {
		return opNm;
	}

	public void setOpNm(String opNm) {
		this.opNm = opNm;
	}

	public String getOpCtt() {
		return opCtt;
	}

	public void setOpCtt(String opCtt) {
		this.opCtt = opCtt;
	}

	public String getDrftDeptId() {
		return drftDeptId;
	}

	public void setDrftDeptId(String drftDeptId) {
		this.drftDeptId = drftDeptId;
	}

	public String getDrftDeptNm() {
		return drftDeptNm;
	}

	public void setDrftDeptNm(String drftDeptNm) {
		this.drftDeptNm = drftDeptNm;
	}

	public String getDrftOpChrgId() {
		return drftOpChrgId;
	}

	public void setDrftOpChrgId(String drftOpChrgId) {
		this.drftOpChrgId = drftOpChrgId;
	}

	public String getDrftOpChrgNm() {
		return drftOpChrgNm;
	}

	public void setDrftOpChrgNm(String drftOpChrgNm) {
		this.drftOpChrgNm = drftOpChrgNm;
	}

	public String getDrftUserId() {
		return drftUserId;
	}

	public void setDrftUserId(String drftUserId) {
		this.drftUserId = drftUserId;
	}

	public String getDrftUserNm() {
		return drftUserNm;
	}

	public void setDrftUserNm(String drftUserNm) {
		this.drftUserNm = drftUserNm;
	}

	public String getCyclId() {
		return cyclId;
	}

	public void setCyclId(String cyclId) {
		this.cyclId = cyclId;
	}

	public String getCyclNm() {
		return cyclNm;
	}

	public void setCyclNm(String cyclNm) {
		this.cyclNm = cyclNm;
	}

	public String getStmId() {
		return stmId;
	}

	public void setStmId(String stmId) {
		this.stmId = stmId;
	}

	public String getStmNm() {
		return stmNm;
	}

	public void setStmNm(String stmNm) {
		this.stmNm = stmNm;
	}

	public String getTranDt() {
		return tranDt;
	}

	public void setTranDt(String tranDt) {
		this.tranDt = tranDt;
	}

	public String getTranStCd() {
		return tranStCd;
	}

	public void setTranStCd(String tranStCd) {
		this.tranStCd = tranStCd;
	}

	public String getTranStNm() {
		return tranStNm;
	}

	public void setTranStNm(String tranStNm) {
		this.tranStNm = tranStNm;
	}

	public String getAutoClCd() {
		return autoClCd;
	}

	public void setAutoClCd(String autoClCd) {
		this.autoClCd = autoClCd;
	}

	public String getAutoClNm() {
		return autoClNm;
	}

	public void setAutoClNm(String autoClNm) {
		this.autoClNm = autoClNm;
	}

	public String getPrdCnt() {
		return prdCnt;
	}

	public void setPrdCnt(String prdCnt) {
		this.prdCnt = prdCnt;
	}

	public String getCyclClCd() {
		return cyclClCd;
	}

	public void setCyclClCd(String cyclClCd) {
		this.cyclClCd = cyclClCd;
	}

	public String getCyclClNm() {
		return cyclClNm;
	}

	public void setCyclClNm(String cyclClNm) {
		this.cyclClNm = cyclClNm;
	}

	public String getStdDt() {
		if ( StringUtil.isNull(stdDt) ) {
			return DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
		}
		return stdDt;
	}

	public String getStdDtFormat() {
		return DateUtil.getDateFormat(stdDt);
	}

	public void setStdDt(String stdDt) {
		this.stdDt = StringUtil.getNumber(stdDt);
	}

	public String getStdH() {
		return stdH;
	}

	public void setStdH(String stdH) {
		this.stdH = stdH;
	}

	public String getStmSerNum() {
		return stmSerNum;
	}

	public void setStmSerNum(String stmSerNum) {
		this.stmSerNum = stmSerNum;
	}

	public String getStmSeqNum() {
		if ( StringUtil.isNull(stmSeqNum) ) {
			stmSeqNum = stmSerNum;
		}
		return stmSeqNum;
	}

	public void setStmSeqNum(String stmSeqNum) {
		this.stmSeqNum = stmSeqNum;
	}

	public String getStmClCd() {
		return stmClCd;
	}

	public void setStmClCd(String stmClCd) {
		this.stmClCd = stmClCd;
	}

	public String getStmClNm() {
		return stmClNm;
	}

	public void setStmClNm(String stmClNm) {
		this.stmClNm = stmClNm;
	}

	public String getStmAuthCd() {
		return stmAuthCd;
	}

	public void setStmAuthCd(String stmAuthCd) {
		this.stmAuthCd = stmAuthCd;
	}

	public String getStmAuthNm() {
		return stmAuthNm;
	}

	public void setStmAuthNm(String stmAuthNm) {
		this.stmAuthNm = stmAuthNm;
	}

	public String getStmDeptId() {
		return stmDeptId;
	}

	public void setStmDeptId(String stmDeptId) {
		this.stmDeptId = stmDeptId;
	}

	public String getStmDeptNm() {
		return stmDeptNm;
	}

	public void setStmDeptNm(String stmDeptNm) {
		this.stmDeptNm = stmDeptNm;
	}

	public String getStmOpChrgId() {
		return stmOpChrgId;
	}

	public void setStmOpChrgId(String stmOpChrgId) {
		this.stmOpChrgId = stmOpChrgId;
	}

	public String getStmOpChrgNm() {
		return stmOpChrgNm;
	}

	public void setStmOpChrgNm(String stmOpChrgNm) {
		this.stmOpChrgNm = stmOpChrgNm;
	}

	public String getStmUserId() {
		return stmUserId;
	}

	public void setStmUserId(String stmUserId) {
		this.stmUserId = stmUserId;
	}

	public String getStmUserNm() {
		return stmUserNm;
	}

	public void setStmUserNm(String stmUserNm) {
		this.stmUserNm = stmUserNm;
	}

	public String getSignClCd() {
		return signClCd;
	}

	public void setSignClCd(String signClCd) {
		this.signClCd = signClCd;
	}

	public String getSignClNm() {
		return signClNm;
	}

	public void setSignClNm(String signClNm) {
		this.signClNm = signClNm;
	}

	public String getSignDtm() {
		return signDtm;
	}

	public String getSignDtmFormat() {
		return DateUtil.getDateFormat(signDtm);
	}

	public void setSignDtm(String signDtm) {
		this.signDtm = signDtm;
	}

	public String getBlcinVal() {
		return blcinVal;
	}

	public void setBlcinVal(String blcinVal) {
		this.blcinVal = blcinVal;
	}

	public String getSignFilePath() {
		return signFilePath;
	}

	public void setSignFilePath(String signFilePath) {
		this.signFilePath = signFilePath;
	}

	public String getSignCtt() {
		return signCtt;
	}

	public void setSignCtt(String signCtt) {
		this.signCtt = signCtt;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getSupDeptId() {
		return supDeptId;
	}

	public void setSupDeptId(String supDeptId) {
		this.supDeptId = supDeptId;
	}

	public String getSupDeptNm() {
		return supDeptNm;
	}

	public void setSupDeptNm(String supDeptNm) {
		this.supDeptNm = supDeptNm;
	}

	public String getOpChrgUser() {
		this.opChrgUser = this.opChrgId + "_" + this.userId;
		return this.opChrgUser;
	}

	public void setOpChrgUser(String opChrgUser) {
		this.opChrgUser = opChrgUser;
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

	public String getPhonNum() {
		return phonNum;
	}

	public void setPhonNum(String phonNum) {
		this.phonNum = phonNum;
	}

	public String getMailAddr() {
		return mailAddr;
	}

	public void setMailAddr(String mailAddr) {
		this.mailAddr = mailAddr;
	}

	public String getTrnsfSerNum() {
		return trnsfSerNum;
	}

	public void setTrnsfSerNum(String trnsfSerNum) {
		this.trnsfSerNum = trnsfSerNum;
	}

	public String getTrnsfOpChrgId() {
		return trnsfOpChrgId;
	}

	public void setTrnsfOpChrgId(String trnsfOpChrgId) {
		this.trnsfOpChrgId = trnsfOpChrgId;
	}

	public String getTrnsfOpChrgNm() {
		return trnsfOpChrgNm;
	}

	public void setTrnsfOpChrgNm(String trnsfOpChrgNm) {
		this.trnsfOpChrgNm = trnsfOpChrgNm;
	}

	public String getTrnsfUserId() {
		return trnsfUserId;
	}

	public void setTrnsfUserId(String trnsfUserId) {
		this.trnsfUserId = trnsfUserId;
	}

	public String getTrnsfUserNm() {
		return trnsfUserNm;
	}

	public void setTrnsfUserNm(String trnsfUserNm) {
		this.trnsfUserNm = trnsfUserNm;
	}

	public String getTrnsfCtt() {
		return trnsfCtt;
	}

	public void setTrnsfCtt(String trnsfCtt) {
		this.trnsfCtt = trnsfCtt;
	}

	public String getTrnsfTranCd() {
		return trnsfTranCd;
	}

	public void setTrnsfTranCd(String trnsfTranCd) {
		this.trnsfTranCd = trnsfTranCd;
	}

	public String getTrnsfTranNm() {
		return trnsfTranNm;
	}

	public void setTrnsfTranNm(String trnsfTranNm) {
		this.trnsfTranNm = trnsfTranNm;
	}

	public String getTrnsfDtm() {
		return trnsfDtm;
	}

	public String getTrnsfDtmFormat() {
		return DateUtil.getDateFormat(trnsfDtm);
	}

	public void setTrnsfDtm(String trnsfDtm) {
		this.trnsfDtm = trnsfDtm;
	}

	public String getTrnsfTranCtt() {
		return trnsfTranCtt;
	}

	public void setTrnsfTranCtt(String trnsfTranCtt) {
		this.trnsfTranCtt = trnsfTranCtt;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getPrjNm() {
		return prjNm;
	}

	public void setPrjNm(String prjNm) {
		this.prjNm = prjNm;
	}

	public String getPrjVer() {
		return prjVer;
	}

	public void setPrjVer(String prjVer) {
		this.prjVer = prjVer;
	}

	public String getPrjCtt() {
		return prjCtt;
	}

	public void setPrjCtt(String prjCtt) {
		this.prjCtt = prjCtt;
	}

	public String getProcStCd() {
		return procStCd;
	}

	public void setProcStCd(String procStCd) {
		this.procStCd = procStCd;
	}

	public String getProcStNm() {
		return procStNm;
	}

	public void setProcStNm(String procStNm) {
		this.procStNm = procStNm;
	}

	public String getCtrlNum() {
		return ctrlNum;
	}

	public void setCtrlNum(String ctrlNum) {
		this.ctrlNum = ctrlNum;
	}

	public String getOpCtrlNum() {
		return opCtrlNum;
	}

	public void setOpCtrlNum(String opCtrlNum) {
		this.opCtrlNum = opCtrlNum;
	}

	public String getCtrlNm() {
		return ctrlNm;
	}

	public void setCtrlNm(String ctrlNm) {
		this.ctrlNm = ctrlNm;
	}

	public String getCtrlCtt() {
		return ctrlCtt;
	}

	public void setCtrlCtt(String ctrlCtt) {
		this.ctrlCtt = ctrlCtt;
	}

	public String getReqSerNum() {
		return reqSerNum;
	}

	public void setReqSerNum(String reqSerNum) {
		this.reqSerNum = reqSerNum;
	}

	public String getReqSeqNum() {
		if ( StringUtil.isNull(reqSeqNum) ) {
			reqSeqNum = reqSerNum;
		}
		return reqSeqNum;
	}

	public void setReqSeqNum(String reqSeqNum) {
		this.reqSeqNum = reqSeqNum;
	}

	public String getReqTypCd() {
		return reqTypCd;
	}

	public void setReqTypCd(String reqTypCd) {
		this.reqTypCd = reqTypCd;
	}

	public String getReqTypNm() {
		return reqTypNm;
	}

	public void setReqTypNm(String reqTypNm) {
		this.reqTypNm = reqTypNm;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getReqCtt() {
		return reqCtt;
	}

	public void setReqCtt(String reqCtt) {
		this.reqCtt = reqCtt;
	}

	public String getItmSerNum() {
		return itmSerNum;
	}

	public void setItmSerNum(String itmSerNum) {
		this.itmSerNum = itmSerNum;
	}

	public String getItmVal() {
		return itmVal;
	}

	public void setItmVal(String itmVal) {
		this.itmVal = itmVal;
	}

	public String getItmCtt() {
		return itmCtt;
	}

	public void setItmCtt(String itmCtt) {
		this.itmCtt = itmCtt;
	}

	public String getItmCnt() {
		return itmCnt;
	}

	public void setItmCnt(String itmCnt) {
		this.itmCnt = itmCnt;
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

	public String getResItmSerNum() {
		return resItmSerNum;
	}

	public void setResItmSerNum(String resItmSerNum) {
		this.resItmSerNum = resItmSerNum;
	}

	public String getResSerNum() {
		return resSerNum;
	}

	public void setResSerNum(String resSerNum) {
		this.resSerNum = resSerNum;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getRgstClCd() {
		return rgstClCd;
	}

	public void setRgstClCd(String rgstClCd) {
		this.rgstClCd = rgstClCd;
	}

	public String getRgstClNm() {
		return rgstClNm;
	}

	public void setRgstClNm(String rgstClNm) {
		this.rgstClNm = rgstClNm;
	}

	public String getResCtt() {
		return resCtt;
	}

	public void setResCtt(String resCtt) {
		this.resCtt = resCtt;
	}

	public String getResStCd() {
		return resStCd;
	}

	public void setResStCd(String resStCd) {
		this.resStCd = resStCd;
	}

	public String getResStNm() {
		return resStNm;
	}

	public void setResStNm(String resStNm) {
		this.resStNm = resStNm;
	}

	public String getResDtFormat() {
		return DateUtil.getDateFormat(resDt);
	}

	public String getResDt() {
		return resDt;
	}

	public void setResDt(String resDt) {
		this.resDt = resDt;
	}

	public String getFileSerNum() {
		return fileSerNum;
	}

	public void setFileSerNum(String fileSerNum) {
		this.fileSerNum = fileSerNum;
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
    
	public String getFileSize() {
		return fileSize;
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

	public String getSrchUserAuthCd() {
		return srchUserAuthCd;
	}

	public void setSrchUserAuthCd(String srchUserAuthCd) {
		this.srchUserAuthCd = srchUserAuthCd;
	}

	public String getUserCnt() {
		return userCnt;
	}

	public void setUserCnt(String userCnt) {
		this.userCnt = userCnt;
	}

	public String getOpCnt() {
		return opCnt;
	}

	public void setOpCnt(String opCnt) {
		this.opCnt = opCnt;
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

	public String getEffStaDt() {
		return getStdDt();
	}
	
	public String getEffEndDt() {
		if ( StringUtil.isNull(this.getStdDt()) ) {
			return null;
		}
		
		if ( StringUtil.isNull(this.getPrdCnt()) || Integer.parseInt(this.getPrdCnt()) <= 0 ) {
			return null;
		}
		
		String result = null;
		switch (this.getCyclClCd()) {
			case "1000":
				result = DateUtil.getAddYear (this.getStdDt(), Integer.parseInt(this.getPrdCnt()));
				break;
			case "2000":
				result = DateUtil.getAddMonth(this.getStdDt(), Integer.parseInt(this.getPrdCnt()));
				break;
			case "3000":
				result = DateUtil.getAddDate (this.getStdDt(), Integer.parseInt(this.getPrdCnt()) * 7);
				break;
			case "4000":
				result = DateUtil.getAddDate (this.getStdDt(), Integer.parseInt(this.getPrdCnt()));
				break;
		}
		
		return DateUtil.getDateFormat(result, DateUtil.sDateInputFormatYMD);
	}

}