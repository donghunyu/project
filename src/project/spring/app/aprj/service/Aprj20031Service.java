/*-------------------------------------------------------------------
* NAME   : Aprj20031Service
* DESC   : 프로젝트_업무통제
* Author : 
* DATE   : 2018-12-17
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

import project.spring.app.aprj.dao.Aprj20031Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20031Service extends AprjService {

    @Autowired
    private Aprj20031Dao daoAprj20031;

    /**
     * 프로젝트_업무통제검색리스트
     * @param Aprj20030Model 프로젝트_업무통제
     * @return List<Aprj20030Model> 프로젝트_업무통제리스트
     */
    public List<Aprj20030Model> srchAprj20031List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20031.srchAprj20031List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제검색리스트수
     * @param Aprj20030Model 프로젝트_업무통제
     * @return String 프로젝트_업무통제리스트수
     */
    public String srchAprj20031Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20031.srchAprj20031Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제검색
     * @param Aprj20030Model 프로젝트_업무통제
     * @return Aprj20030Model 프로젝트_업무통제
     */
    public Aprj20030Model srchAprj20031(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20031.srchAprj20031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제검색리스트
     * @param Aprj20030Model 프로젝트_업무통제
     * @return List<Aprj20030Model> 프로젝트_업무통제리스트
     */
    public List<Aprj20030Model> srchAprj20031ExcelList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20031.srchAprj20031ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제저장
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제저장수
     */
    public int saveAprj20031(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20031(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20031(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제입력
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제입력수
     */
    public int insertAprj20031(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20031.insertAprj20031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제입력
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제입력수
     */
    public int insertAprj20031Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20031.insertAprj20031Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제입력
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제입력수
     */
    public int insertAprj20031VerUp(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20031.insertAprj20031VerUp(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제수정
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제수정수
     */
    public int updateAprj20031(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20031.updateAprj20031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제삭제
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제삭제수
     */
    public int deleteAprj20031(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20031.deleteAprj20031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무통제삭제
     * @param Aprj20030Model 프로젝트_업무통제
     * @return int 프로젝트_업무통제삭제수
     */
    public int deleteAprj20031All() throws CommonException {
        try {
            return daoAprj20031.deleteAprj20031All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무주기삭제
     * @param Aprj20031Model 프로젝트_업무주기
     * @return int 프로젝트_업무주기삭제수
     */
    public int deleteAprj20031Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20031.deleteAprj20031Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}