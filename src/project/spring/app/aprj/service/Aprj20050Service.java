/*-------------------------------------------------------------------
* NAME   : Aprj20050Service
* DESC   : 프로젝트_응답
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

import project.spring.app.aprj.dao.Aprj20050Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20050Service extends AprjService {

    @Autowired
    private Aprj20050Dao daoAprj20050;

    /**
     * 프로젝트_응답검색리스트
     * @param Aprj20030Model 프로젝트_응답
     * @return List<Aprj20030Model> 프로젝트_응답리스트
     */
    public List<Aprj20030Model> srchAprj20050List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20050.srchAprj20050List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색리스트수
     * @param Aprj20030Model 프로젝트_응답
     * @return String 프로젝트_응답리스트수
     */
    public String srchAprj20050Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20050.srchAprj20050Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색
     * @param Aprj20030Model 프로젝트_응답
     * @return Aprj20030Model 프로젝트_응답
     */
    public Aprj20030Model srchAprj20050(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20050.srchAprj20050(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답검색리스트수
     * @param Aprj20030Model 프로젝트_응답
     * @return String 프로젝트_응답리스트수
     */
    public String srchAprj20050ResCnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20050.srchAprj20050ResCnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답저장
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답저장수
     */
    public int saveAprj20050(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20050(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20050(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답입력
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답입력수
     */
    public int insertAprj20050(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20050.insertAprj20050(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답수정
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답수정수
     */
    public int updateAprj20050(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20050.updateAprj20050(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답수정
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답수정수
     */
    public int updateAprj20050Sign(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20050.updateAprj20050Sign(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20050(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20050.deleteAprj20050(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20050All() throws CommonException {
        try {
            return daoAprj20050.deleteAprj20050All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답삭제
     * @param Aprj20030Model 프로젝트_응답
     * @return int 프로젝트_응답삭제수
     */
    public int deleteAprj20050Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20050.deleteAprj20050Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}