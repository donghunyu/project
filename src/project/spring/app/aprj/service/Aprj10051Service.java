/*-------------------------------------------------------------------
* NAME   : Aprj10051Service
* DESC   : 설정_양식요청
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

import project.spring.app.aprj.dao.Aprj10051Dao;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10050Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10051Service extends AprjService {

    @Autowired
    private Aprj10051Dao daoAprj10051;

    /**
     * 설정_양식요청검색리스트
     * @param Aprj10050Model 설정_양식요청
     * @return List<Aprj10050Model> 설정_양식요청리스트
     */
    public List<Aprj10050Model> srchAprj10051List(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10051.srchAprj10051List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청검색리스트수
     * @param Aprj10050Model 설정_양식요청
     * @return String 설정_양식요청리스트수
     */
    public String srchAprj10051Cnt(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10051.srchAprj10051Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청검색
     * @param Aprj10050Model 설정_양식요청
     * @return Aprj10050Model 설정_양식요청
     */
    public Aprj10050Model srchAprj10051(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10051.srchAprj10051(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청저장
     * @param Aprj10050Model 설정_양식요청
     * @return int 설정_양식요청저장수
     */
    public int saveAprj10051(Aprj10050Model param) throws CommonException {
        try {
            int nCount = updateAprj10051(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10051(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청입력
     * @param Aprj10050Model 설정_양식요청
     * @return int 설정_양식요청입력수
     */
    public int insertAprj10051(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10051.insertAprj10051(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청수정
     * @param Aprj10050Model 설정_양식요청
     * @return int 설정_양식요청수정수
     */
    public int updateAprj10051(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10051.updateAprj10051(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청수정
     * @param Aprj10050Model 설정_양식요청
     * @return int 설정_양식요청수정수
     */
    public int copyAprj10051(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10051.copyAprj10051(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_양식요청삭제
     * @param Aprj10050Model 설정_양식요청
     * @return int 설정_양식요청삭제수
     */
    public int deleteAprj10051(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10051.deleteAprj10051(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}