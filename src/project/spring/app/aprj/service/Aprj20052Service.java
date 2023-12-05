/*-------------------------------------------------------------------
* NAME   : Aprj20052Service
* DESC   : 프로젝트_응답첨부파일
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

import project.spring.app.aprj.dao.Aprj20052Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20052Service extends AprjService {

    @Autowired
    private Aprj20052Dao daoAprj20052;

    /**
     * 프로젝트_응답첨부파일검색리스트
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return List<Aprj20030Model> 프로젝트_응답첨부파일리스트
     */
    public List<Aprj20030Model> srchAprj20052List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20052.srchAprj20052List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일검색리스트수
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return String 프로젝트_응답첨부파일리스트수
     */
    public String srchAprj20052Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20052.srchAprj20052Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일검색
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return Aprj20030Model 프로젝트_응답첨부파일
     */
    public Aprj20030Model srchAprj20052(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20052.srchAprj20052(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일저장
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return int 프로젝트_응답첨부파일저장수
     */
    public int saveAprj20052(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20052(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20052(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일입력
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return int 프로젝트_응답첨부파일입력수
     */
    public int insertAprj20052(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20052.insertAprj20052(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일수정
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return int 프로젝트_응답첨부파일수정수
     */
    public int updateAprj20052(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20052.updateAprj20052(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일삭제
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return int 프로젝트_응답첨부파일삭제수
     */
    public int deleteAprj20052(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20052.deleteAprj20052(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일삭제
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return int 프로젝트_응답첨부파일삭제수
     */
    public int deleteAprj20052All() throws CommonException {
        try {
            return daoAprj20052.deleteAprj20052All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_응답첨부파일삭제
     * @param Aprj20030Model 프로젝트_응답첨부파일
     * @return int 프로젝트_응답첨부파일삭제수
     */
    public int deleteAprj20052Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20052.deleteAprj20052Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}