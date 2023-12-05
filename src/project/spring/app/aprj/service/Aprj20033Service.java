/*-------------------------------------------------------------------
* NAME   : Aprj20033Service
* DESC   : 프로젝트_업무담당
* Author : 
* DATE   : 2019-01-15
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

import project.spring.app.aprj.dao.Aprj20033Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20033Service extends AprjService {

    @Autowired
    private Aprj20033Dao daoAprj20033;

    /**
     * 프로젝트_업무담당검색리스트
     * @param Aprj20030Model 프로젝트_업무담당
     * @return List<Aprj20030Model> 프로젝트_업무담당리스트
     */
    public List<Aprj20030Model> srchAprj20033List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.srchAprj20033List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당검색리스트수
     * @param Aprj20030Model 프로젝트_업무담당
     * @return String 프로젝트_업무담당리스트수
     */
    public String srchAprj20033Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.srchAprj20033Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당검색
     * @param Aprj20030Model 프로젝트_업무담당
     * @return Aprj20030Model 프로젝트_업무담당
     */
    public Aprj20030Model srchAprj20033(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.srchAprj20033(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당검색리스트
     * @param Aprj20030Model 프로젝트_업무담당
     * @return List<Aprj20030Model> 프로젝트_업무담당리스트
     */
    public List<Aprj20030Model> srchAprj20033GroupList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.srchAprj20033GroupList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당검색리스트수
     * @param Aprj20030Model 프로젝트_업무담당
     * @return String 프로젝트_업무담당리스트수
     */
    public String srchAprj20033GroupCnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.srchAprj20033GroupCnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당저장
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당저장수
     */
    public int saveAprj20033(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20033(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20033(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당입력
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당입력수
     */
    public int insertAprj20033(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.insertAprj20033(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당입력
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당입력수
     */
    public int insertAprj20033Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.insertAprj20033Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당입력
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당입력수
     */
    public int insertAprj20033VerUp(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.insertAprj20033VerUp(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당입력
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당입력수
     */
    public int selectInsertAprj20033(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.selectInsertAprj20033(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당수정
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당수정수
     */
    public int updateAprj20033(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.updateAprj20033(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당수정
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당수정수
     */
    public int updateAprj20033Trnsf(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.updateAprj20033Trnsf(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당삭제
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당삭제수
     */
    public int deleteAprj20033(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.deleteAprj20033(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당삭제
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당삭제수
     */
    public int deleteAprj20033All() throws CommonException {
        try {
            return daoAprj20033.deleteAprj20033All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 프로젝트_업무담당삭제
     * @param Aprj20030Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당삭제수
     */
    public int deleteAprj20033Trnsf(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20033.deleteAprj20033Trnsf(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당삭제
     * @param Aprj20033Model 프로젝트_업무담당
     * @return int 프로젝트_업무담당삭제수
     */
    public int deleteAprj20033Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20033.deleteAprj20033Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}