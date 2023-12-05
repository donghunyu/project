/*-------------------------------------------------------------------
* NAME   : Zcom99030Model
* DESC   : 관리자_사용자
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
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.EncryptionSha256;

public class Zcom99030Model extends AprjModel {

    private String srchUserId                    ;    /* 검색사용자 ID                      */
    private String srchUserNm                    ;    /* 검색사용자 명                      */
    private String srchUserPwd                   ;    /* 검색사용자 비밀번호                */
    private String srchPwdUpdtDt                 ;    /* 검색비밀번호 수정 일자             */
    private String srchUserAuthCd                ;    /* 검색사용자 권한 코드               */
    private String srchSupUserId                 ;    /* 검색상위 사용자 ID                 */
    private String srchCoId                      ;    /* 검색업체 ID                        */
    private String srchCoNm                      ;    /* 검색업체 명                        */
    private String srchDeptId                    ;    /* 검색부서 ID                        */
    private String srchDeptNm                    ;    /* 검색부서 명                        */
    private String srchPhonNum                   ;    /* 검색전화 번호                      */
    private String srchMailAddr                  ;    /* 검색메일 주소                      */
    private String srchIniScrUrl                 ;    /* 검색초기 화면 URL                  */
    
    private String workType                      ;    /* 작업 종류                      */
    private String userId                        ;    /* 사용자 ID                      */
    private String userNm                        ;    /* 사용자 명                      */
    private String userPwd                       ;    /* 사용자 비밀번호                */
    private String userPwdSha256                 ;    /* 사용자 비밀번호                */
    private String oldUserPwd                    ;
    private String pwdUpdtDt                     ;    /* 비밀번호 수정 일자             */
    private String userAuthCd                    ;    /* 사용자 권한 코드               */
    private String userAuthNm                    ;    /* 사용자 권한 명                 */
    private String supUserId                     ;    /* 상위 사용자 ID                 */
    private String supUserNm                     ;    /* 상위 사용자 명                 */
    private String coId                          ;    /* 업체 ID                        */
    private String coNm                          ;    /* 업체 명                        */
    private String deptId                        ;    /* 부서 ID                        */
    private String deptNm                        ;    /* 부서 명                        */
    private String opChrgId                      ;    /* 업무 담당 ID                   */
    private String opChrgNm                      ;    /* 업무 담당 명                   */
    private String ofcLvlClCd                    ;    /* 직급 구분 코드                 */
    private String ofcLvlClNm                    ;    /* 직급 구분 명                   */
    private String phonNum                       ;    /* 전화 번호                      */
    private String mailAddr                      ;    /* 메일 주소                      */
    private String iniScrUrl                     ;    /* 초기 화면 URL                  */
    private String lastLoginDtm                  ;    /* 마지막 로그인 일시             */

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

    public String getSrchUserPwd() {
        return srchUserPwd;
    }

    public void setSrchUserPwd(String srchUserPwd) {
        this.srchUserPwd = srchUserPwd;
    }

    public String getSrchPwdUpdtDt() {
        return srchPwdUpdtDt;
    }

    public void setSrchPwdUpdtDt(String srchPwdUpdtDt) {
        this.srchPwdUpdtDt = srchPwdUpdtDt;
    }

    public String getSrchUserAuthCd() {
        return srchUserAuthCd;
    }

    public void setSrchUserAuthCd(String srchUserAuthCd) {
        this.srchUserAuthCd = srchUserAuthCd;
    }

    public String getSrchSupUserId() {
        return srchSupUserId;
    }

    public void setSrchSupUserId(String srchSupUserId) {
        this.srchSupUserId = srchSupUserId;
    }

    public String getSrchCoId() {
        return srchCoId;
    }

    public void setSrchCoId(String srchCoId) {
        this.srchCoId = srchCoId;
    }

    public String getSrchCoNm() {
		return srchCoNm;
	}

	public void setSrchCoNm(String srchCoNm) {
		this.srchCoNm = srchCoNm;
	}

	public String getSrchDeptId() {
		return srchDeptId;
	}

	public void setSrchDeptId(String srchDeptId) {
		this.srchDeptId = srchDeptId;
	}

	public String getSrchDeptNm() {
		return srchDeptNm;
	}

	public void setSrchDeptNm(String srchDeptNm) {
		this.srchDeptNm = srchDeptNm;
	}

	public String getSrchPhonNum() {
        return srchPhonNum;
    }

    public void setSrchPhonNum(String srchPhonNum) {
        this.srchPhonNum = srchPhonNum;
    }

    public String getSrchMailAddr() {
        return srchMailAddr;
    }

    public void setSrchMailAddr(String srchMailAddr) {
        this.srchMailAddr = srchMailAddr;
    }

    public String getSrchIniScrUrl() {
        return srchIniScrUrl;
    }

    public void setSrchIniScrUrl(String srchIniScrUrl) {
        this.srchIniScrUrl = srchIniScrUrl;
    }

    public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
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

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPwdSha256() {
    	this.userPwdSha256 = EncryptionSha256.encryptSha256(this.userPwd);
		return this.userPwdSha256;
	}

	public void setUserPwdSha256(String userPwdSha256) {
		this.userPwdSha256 = userPwdSha256;
	}

	public String getOldUserPwd() {
		return oldUserPwd;
	}

	public void setOldUserPwd(String oldUserPwd) {
		this.oldUserPwd = oldUserPwd;
	}

	public String getPwdUpdtDt() {
        return pwdUpdtDt;
    }

    public String getPwdUpdtDtFormat() {
        return DateUtil.getDateFormat(pwdUpdtDt);
    }

    public void setPwdUpdtDt(String pwdUpdtDt) {
        this.pwdUpdtDt = pwdUpdtDt;
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

	public String getSupUserId() {
		return supUserId;
	}

	public void setSupUserId(String supUserId) {
		this.supUserId = supUserId;
	}

	public String getSupUserNm() {
		return supUserNm;
	}

	public void setSupUserNm(String supUserNm) {
		this.supUserNm = supUserNm;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
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

	public String getCoNm() {
		return coNm;
	}

	public void setCoNm(String coNm) {
		this.coNm = coNm;
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

	public String getIniScrUrl() {
		return iniScrUrl;
	}

	public void setIniScrUrl(String iniScrUrl) {
		this.iniScrUrl = iniScrUrl;
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

	public String getOfcLvlClCd() {
		return ofcLvlClCd;
	}

	public void setOfcLvlClCd(String ofcLvlClCd) {
		this.ofcLvlClCd = ofcLvlClCd;
	}

	public String getOfcLvlClNm() {
		return ofcLvlClNm;
	}

	public void setOfcLvlClNm(String ofcLvlClNm) {
		this.ofcLvlClNm = ofcLvlClNm;
	}

	public String getLastLoginDtm() {
		return lastLoginDtm;
	}

	public void setLastLoginDtm(String lastLoginDtm) {
		this.lastLoginDtm = lastLoginDtm;
	}

}