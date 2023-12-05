/*-------------------------------------------------------------------
* NAME   : Zcom99030Service
* DESC   : 관리자_사용자
* Author : 
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.zcom.dao.Zcom99030Dao;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99030Model;

@Service
public class Zcom99030Service extends AprjService {

    @Autowired
    private Zcom99030Dao daoZcom99030;

    /**
     * 관리자_사용자검색리스트
     * @param Zcom99030Model 관리자_사용자
     * @return List<Zcom99030Model> 관리자_사용자리스트
     */
    public List<Zcom99030Model> srchZcom99030List(Zcom99030Model param) throws CommonException {
        try {
            return daoZcom99030.srchZcom99030List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자검색리스트수
     * @param Zcom99030Model 관리자_사용자
     * @return String 관리자_사용자리스트수
     */
    public String srchZcom99030Cnt(Zcom99030Model param) throws CommonException {
        try {
            return daoZcom99030.srchZcom99030Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자검색
     * @param Zcom99030Model 관리자_사용자
     * @return Zcom99030Model 관리자_사용자
     */
    public Zcom99030Model srchZcom99030(Zcom99030Model param) throws CommonException {
        try {
            return daoZcom99030.srchZcom99030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자검색리스트
     * @param Zcom99030Model 관리자_사용자
     * @return List<Zcom99030Model> 관리자_사용자리스트
     */
    public File srchZcom99030ExcelList(Zcom99030Model param) throws CommonException {
        try {
            return daoZcom99030.srchZcom99030ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자저장
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자저장수
     */
    public int saveZcom99030(Zcom99030Model param) throws CommonException {
        try {
            int nCount = updateZcom99030(param);
            if ( nCount == 0 ) {
                nCount = insertZcom99030(param);
                updateZcom99030PwdInit(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자입력
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자입력수
     */
    public int insertZcom99030(Zcom99030Model param) throws CommonException {
        try {
            return daoZcom99030.insertZcom99030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자수정
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자수정수
     */
    public int updateZcom99030(Zcom99030Model param) throws CommonException {
        try {
            return daoZcom99030.updateZcom99030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자수정
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자수정수
     */
    public int updateZcom99030User(Zcom99030Model param) throws CommonException {
        try {
            return daoZcom99030.updateZcom99030User(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자수정
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자수정수
     */
    public int updateZcom99030PwdInit(Zcom99030Model param) throws CommonException {
        try {
            return daoZcom99030.updateZcom99030PwdInit(param);
        } catch ( Exception e) {
        	e.printStackTrace();
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자수정
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자수정수
     */
    public int updateZcom99030LastLoginDtm(Zcom99030Model param) throws CommonException {
        try {
            return daoZcom99030.updateZcom99030LastLoginDtm(param);
        } catch ( Exception e) {
        	e.printStackTrace();
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자삭제
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자삭제수
     */
    public int deleteZcom99030(Zcom99030Model param) throws CommonException {
        try {
            return daoZcom99030.deleteZcom99030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자삭제
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자삭제수
     */
    public int deleteZcom99030All() throws CommonException {
        try {
            return daoZcom99030.deleteZcom99030All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_사용자삭제
     * @param Zcom99030Model 관리자_사용자
     * @return int 관리자_사용자삭제수
     */
    public int deleteZcom99030Co(AprjModel param) throws CommonException {
        try {
            return daoZcom99030.deleteZcom99030Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}