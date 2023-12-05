/*-------------------------------------------------------------------
* NAME   : Aprj20040Service
* DESC   : 프로젝트_요청
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

import project.spring.app.aprj.dao.Aprj20040Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20040Service extends AprjService {

    @Autowired
    private Aprj20040Dao daoAprj20040;

    /**
     * 프로젝트_요청검색리스트
     * @param Aprj20030Model 프로젝트_요청
     * @return List<Aprj20030Model> 프로젝트_요청리스트
     */
    public List<Aprj20030Model> srchAprj20040List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20040.srchAprj20040List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청검색리스트수
     * @param Aprj20030Model 프로젝트_요청
     * @return String 프로젝트_요청리스트수
     */
    public String srchAprj20040Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20040.srchAprj20040Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청검색
     * @param Aprj20030Model 프로젝트_요청
     * @return Aprj20030Model 프로젝트_요청
     */
    public Aprj20030Model srchAprj20040(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20040.srchAprj20040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청검색리스트
     * @param Aprj20030Model 프로젝트_요청
     * @return List<Aprj20030Model> 프로젝트_요청리스트
     */
    public List<Aprj20030Model> srchAprj20040UserList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20040.srchAprj20040UserList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청검색리스트수
     * @param Aprj20030Model 프로젝트_요청
     * @return String 프로젝트_요청리스트수
     */
    public String srchAprj20040UserCnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20040.srchAprj20040UserCnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청저장
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청저장수
     */
    public int saveAprj20040(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20040(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20040(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청입력
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청입력수
     */
    public String srchAprj20040reqSeqNum(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20040.srchAprj20040reqSeqNum(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 프로젝트_요청입력
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청입력수
     */
    public int insertAprj20040(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20040.insertAprj20040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청입력
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청입력수
     */
    public int insertAprj20040Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20040.insertAprj20040Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청입력
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청입력수
     */
    public int insertAprj20040VerUp(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20040.insertAprj20040VerUp(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청수정
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청수정수
     */
    public int updateAprj20040(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20040.updateAprj20040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청삭제
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청삭제수
     */
    public int deleteAprj20040(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20040.deleteAprj20040(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청삭제
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청삭제수
     */
    public int deleteAprj20040All() throws CommonException {
        try {
            return daoAprj20040.deleteAprj20040All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_요청삭제
     * @param Aprj20030Model 프로젝트_요청
     * @return int 프로젝트_요청삭제수
     */
    public int deleteAprj20040Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20040.deleteAprj20040Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}