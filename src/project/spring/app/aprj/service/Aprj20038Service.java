/*-------------------------------------------------------------------
* NAME   : Aprj20038Service
* DESC   : 프로젝트_업무자산구분
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

import project.spring.app.aprj.dao.Aprj20038Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20038Service extends AprjService {

    @Autowired
    private Aprj20038Dao daoAprj20038;

    /**
     * 프로젝트_업무자산구분검색리스트
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return List<Aprj20030Model> 프로젝트_업무자산구분리스트
     */
    public List<Aprj20030Model> srchAprj20038List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20038.srchAprj20038List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분검색리스트수
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return String 프로젝트_업무자산구분리스트수
     */
    public String srchAprj20038Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20038.srchAprj20038Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분검색
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return Aprj20030Model 프로젝트_업무자산구분
     */
    public Aprj20030Model srchAprj20038(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20038.srchAprj20038(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분검색리스트
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return List<Aprj20030Model> 프로젝트_업무자산구분리스트
     */
    public List<Aprj20030Model> srchAprj20038GroupList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20038.srchAprj20038GroupList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분검색리스트수
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return String 프로젝트_업무자산구분리스트수
     */
    public String srchAprj20038GroupCnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20038.srchAprj20038GroupCnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분저장
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분저장수
     */
    public int saveAprj20038(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20038(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20038(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분입력
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분입력수
     */
    public int insertAprj20038(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20038.insertAprj20038(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분입력
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분입력수
     */
    public int insertAprj20038Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20038.insertAprj20038Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분입력
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분입력수
     */
    public int insertAprj20038VerUp(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20038.insertAprj20038VerUp(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분입력
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분입력수
     */
    public int selectInsertAprj20038(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20038.selectInsertAprj20038(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분수정
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분수정수
     */
    public int updateAprj20038(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20038.updateAprj20038(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분삭제
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분삭제수
     */
    public int deleteAprj20038(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20038.deleteAprj20038(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무자산구분삭제
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분삭제수
     */
    public int deleteAprj20038All() throws CommonException {
        try {
            return daoAprj20038.deleteAprj20038All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 프로젝트_업무자산구분삭제
     * @param Aprj20030Model 프로젝트_업무자산구분
     * @return int 프로젝트_업무자산구분삭제수
     */
    public int deleteAprj20038Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20038.deleteAprj20038Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


}