/*-------------------------------------------------------------------
* NAME   : Aprj20053Service
* DESC   : 프로젝트_응답결제
* Author : 
* DATE   : 2019-02-18
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

import project.spring.app.aprj.dao.Aprj20053Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20053Service extends AprjService {

    @Autowired
    private Aprj20053Dao daoAprj20053;

    /**
     * 프로젝트_응답결제검색리스트
     * @param Aprj20030Model 프로젝트_응답결제
     * @return List<Aprj20030Model> 프로젝트_응답결제리스트
     */
    public List<Aprj20030Model> srchAprj20053List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20053.srchAprj20053List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제검색리스트수
     * @param Aprj20030Model 프로젝트_응답결제
     * @return String 프로젝트_응답결제리스트수
     */
    public String srchAprj20053Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20053.srchAprj20053Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제검색
     * @param Aprj20030Model 프로젝트_응답결제
     * @return Aprj20030Model 프로젝트_응답결제
     */
    public Aprj20030Model srchAprj20053(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20053.srchAprj20053(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제검색리스트
     * @param Aprj20030Model 프로젝트_응답결제
     * @return List<Aprj20030Model> 프로젝트_응답결제리스트
     */
    public List<Aprj20030Model> srchAprj20053UserList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20053.srchAprj20053UserList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제검색리스트수
     * @param Aprj20030Model 프로젝트_응답결제
     * @return String 프로젝트_응답결제리스트수
     */
    public String srchAprj20053UserCnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20053.srchAprj20053UserCnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제검색
     * @param Aprj20030Model 프로젝트_응답결제
     * @return Aprj20030Model 프로젝트_응답결제
     */
    public Aprj20030Model srchAprj20053User(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20053.srchAprj20053User(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제저장
     * @param Aprj20030Model 프로젝트_응답결제
     * @return int 프로젝트_응답결제저장수
     */
    public int saveAprj20053(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20053(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20053(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제입력
     * @param Aprj20030Model 프로젝트_응답결제
     * @return int 프로젝트_응답결제입력수
     */
    public int insertAprj20053(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20053.insertAprj20053(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제수정
     * @param Aprj20030Model 프로젝트_응답결제
     * @return int 프로젝트_응답결제수정수
     */
    public int updateAprj20053(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20053.updateAprj20053(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제삭제
     * @param Aprj20030Model 프로젝트_응답결제
     * @return int 프로젝트_응답결제삭제수
     */
    public int deleteAprj20053(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20053.deleteAprj20053(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제삭제
     * @param Aprj20030Model 프로젝트_응답결제
     * @return int 프로젝트_응답결제삭제수
     */
    public int deleteAprj20053All() throws CommonException {
        try {
            return daoAprj20053.deleteAprj20053All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답결제삭제
     * @param Aprj20030Model 프로젝트_응답결제
     * @return int 프로젝트_응답결제삭제수
     */
    public int deleteAprj20053Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20053.deleteAprj20053Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}