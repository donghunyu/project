/*-------------------------------------------------------------------
* NAME   : Aprj10052Service
* DESC   : 설정_선택항목
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

import project.spring.app.aprj.dao.Aprj10052Dao;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10050Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10052Service extends AprjService {

    @Autowired
    private Aprj10052Dao daoAprj10052;

    /**
     * 설정_선택항목검색리스트
     * @param Aprj10052Model 설정_선택항목
     * @return List<Aprj10052Model> 설정_선택항목리스트
     */
    public List<Aprj10050Model> srchAprj10052List(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10052.srchAprj10052List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목검색리스트수
     * @param Aprj10052Model 설정_선택항목
     * @return String 설정_선택항목리스트수
     */
    public String srchAprj10052Cnt(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10052.srchAprj10052Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목검색
     * @param Aprj10052Model 설정_선택항목
     * @return Aprj10052Model 설정_선택항목
     */
    public Aprj10050Model srchAprj10052(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10052.srchAprj10052(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목저장
     * @param Aprj10052Model 설정_선택항목
     * @return int 설정_선택항목저장수
     */
    public int saveAprj10052(Aprj10050Model param) throws CommonException {
        try {
            int nCount = updateAprj10052(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10052(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목입력
     * @param Aprj10052Model 설정_선택항목
     * @return int 설정_선택항목입력수
     */
    public int insertAprj10052(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10052.insertAprj10052(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목수정
     * @param Aprj10052Model 설정_선택항목
     * @return int 설정_선택항목수정수
     */
    public int updateAprj10052(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10052.updateAprj10052(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목수정
     * @param Aprj10052Model 설정_선택항목
     * @return int 설정_선택항목수정수
     */
    public int copyAprj10052(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10052.copyAprj10052(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_선택항목삭제
     * @param Aprj10052Model 설정_선택항목
     * @return int 설정_선택항목삭제수
     */
    public int deleteAprj10052(Aprj10050Model param) throws CommonException {
        try {
            return daoAprj10052.deleteAprj10052(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}