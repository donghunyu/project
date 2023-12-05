/*-------------------------------------------------------------------
* NAME   : Aprj10050Service
* DESC   : 설정_양식
* Author : 
* DATE   : 2018-10-12
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

import project.spring.app.aprj.dao.Aprj10050Dao;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10050Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10050Service extends AprjService {

    @Autowired
    private Aprj10050Dao daoAprj10050;

    /**
     * 설정_양식검색리스트
     * @param Aprj10050Model 설정_양식
     * @return List<Aprj10050Model> 설정_양식리스트
     */
    public List<Aprj10050Model> srchAprj10050List(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10050.srchAprj10050List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식검색리스트수
     * @param Aprj10050Model 설정_양식
     * @return String 설정_양식리스트수
     */
    public String srchAprj10050Cnt(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10050.srchAprj10050Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식검색
     * @param Aprj10050Model 설정_양식
     * @return Aprj10050Model 설정_양식
     */
    public Aprj10050Model srchAprj10050(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10050.srchAprj10050(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식저장
     * @param Aprj10050Model 설정_양식
     * @return int 설정_양식저장수
     */
    public int saveAprj10050(Aprj10050Model param) throws CommonException {
        try {
            int nCount = updateAprj10050(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10050(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식입력
     * @param Aprj10050Model 설정_양식
     * @return int 설정_양식입력수
     */
    public int insertAprj10050(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10050.insertAprj10050(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식수정
     * @param Aprj10050Model 설정_양식
     * @return int 설정_양식수정수
     */
    public int updateAprj10050(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10050.updateAprj10050(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식수정
     * @param Aprj10050Model 설정_양식
     * @return int 설정_양식수정수
     */
    public int copyAprj10050(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10050.copyAprj10050(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식삭제
     * @param Aprj10050Model 설정_양식
     * @return int 설정_양식삭제수
     */
    public int deleteAprj10050(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10050.deleteAprj10050(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}