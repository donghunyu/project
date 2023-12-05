/*-------------------------------------------------------------------
* NAME   : Aprj20041Service
* DESC   : 프로젝트_선택항목
* Author : 
* DATE   : 2018-11-26
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.dao.Aprj20041Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20041Service extends AprjService {

    @Autowired
    private Aprj20041Dao daoAprj20041;

    /**
     * 프로젝트_선택항목검색리스트
     * @param Aprj20030Model 프로젝트_선택항목
     * @return List<Aprj20030Model> 프로젝트_선택항목리스트
     */
    public List<Aprj20030Model> srchAprj20041List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20041.srchAprj20041List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목검색리스트수
     * @param Aprj20030Model 프로젝트_선택항목
     * @return String 프로젝트_선택항목리스트수
     */
    public String srchAprj20041Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20041.srchAprj20041Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목검색
     * @param Aprj20030Model 프로젝트_선택항목
     * @return Aprj20030Model 프로젝트_선택항목
     */
    public Aprj20030Model srchAprj20041(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20041.srchAprj20041(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목저장
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목저장수
     */
    public int saveAprj20041(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20041(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20041(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목입력
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목입력수
     */
    public int insertAprj20041(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20041.insertAprj20041(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목입력
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목입력수
     */
    public int insertAprj20041Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20041.insertAprj20041Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목입력
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목입력수
     */
    public int insertAprj20041VerUp(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20041.insertAprj20041VerUp(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목수정
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목수정수
     */
    public int updateAprj20041(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20041.updateAprj20041(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목삭제
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목삭제수
     */
    public int deleteAprj20041(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20041.deleteAprj20041(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목삭제
     * @param Aprj20030Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목삭제수
     */
    public int deleteAprj20041All() throws CommonException {
        try {
            return daoAprj20041.deleteAprj20041All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_선택항목삭제
     * @param Aprj20041Model 프로젝트_선택항목
     * @return int 프로젝트_선택항목삭제수
     */
    public int deleteAprj20041Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20041.deleteAprj20041Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}