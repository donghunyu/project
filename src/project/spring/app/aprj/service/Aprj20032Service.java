/*-------------------------------------------------------------------
* NAME   : Aprj20032Service
* DESC   : 프로젝트_결제라인
* Author : 
* DATE   : 2018-12-06
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

import project.spring.app.aprj.dao.Aprj20032Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20032Service extends AprjService {

    @Autowired
    private Aprj20032Dao daoAprj20032;

    /**
     * 프로젝트_결제라인검색리스트
     * @param Aprj20030Model 프로젝트_결제라인
     * @return List<Aprj20030Model> 프로젝트_결제라인리스트
     */
    public List<Aprj20030Model> srchAprj20032List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20032.srchAprj20032List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인검색리스트수
     * @param Aprj20030Model 프로젝트_결제라인
     * @return String 프로젝트_결제라인리스트수
     */
    public String srchAprj20032Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20032.srchAprj20032Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인검색
     * @param Aprj20030Model 프로젝트_결제라인
     * @return Aprj20030Model 프로젝트_결제라인
     */
    public Aprj20030Model srchAprj20032(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20032.srchAprj20032(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인검색리스트
     * @param Aprj20030Model 프로젝트_결제라인
     * @return List<Aprj20030Model> 프로젝트_결제라인리스트
     */
    public List<Aprj20030Model> srchAprj20032ExcelList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20032.srchAprj20032ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인저장
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인저장수
     */
    public int saveAprj20032(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20032(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20032(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인입력
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인입력수
     */
    public int insertAprj20032(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20032.insertAprj20032(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인입력
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인입력수
     */
    public int insertAprj20032Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20032.insertAprj20032Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인입력
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인입력수
     */
    public int insertAprj20032VerUp(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20032.insertAprj20032VerUp(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인입력
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인입력수
     */
    public int insertAprj20032Pool(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20032.insertAprj20032Pool(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인수정
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인수정수
     */
    public int updateAprj20032(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20032.updateAprj20032(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인삭제
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인삭제수
     */
    public int deleteAprj20032(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20032.deleteAprj20032(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인삭제
     * @param Aprj20030Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인삭제수
     */
    public int deleteAprj20032All() throws CommonException {
        try {
            return daoAprj20032.deleteAprj20032All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제라인삭제
     * @param Aprj20032Model 프로젝트_결제라인
     * @return int 프로젝트_결제라인삭제수
     */
    public int deleteAprj20032Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20032.deleteAprj20032Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}