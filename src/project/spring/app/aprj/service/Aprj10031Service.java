/*-------------------------------------------------------------------
* NAME   : Aprj10031Service
* DESC   : 설정_결제라인
* Author : 
* DATE   : 2018-11-08
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

import project.spring.app.aprj.dao.Aprj10031Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10031Service extends AprjService {

    @Autowired
    private Aprj10031Dao daoAprj10031;

    /**
     * 설정_결제라인검색리스트
     * @param Aprj10030Model 설정_결제라인
     * @return List<Aprj10030Model> 설정_결제라인리스트
     */
    public List<Aprj10030Model> srchAprj10031List(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10031.srchAprj10031List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인검색리스트수
     * @param Aprj10030Model 설정_결제라인
     * @return String 설정_결제라인리스트수
     */
    public String srchAprj10031Cnt(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10031.srchAprj10031Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인검색
     * @param Aprj10030Model 설정_결제라인
     * @return Aprj10030Model 설정_결제라인
     */
    public Aprj10030Model srchAprj10031(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10031.srchAprj10031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인저장
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인저장수
     */
    public int saveAprj10031(Aprj10030Model param) throws CommonException {
        try {
            int nCount = updateAprj10031(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10031(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인입력
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인입력수
     */
    public int insertAprj10031(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10031.insertAprj10031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인입력
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인입력수
     */
    public int insertAprj10031Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10031.insertAprj10031Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인수정
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인수정수
     */
    public int updateAprj10031(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10031.updateAprj10031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인삭제
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인삭제수
     */
    public int deleteAprj10031(Aprj10030Model param) throws CommonException {
        try {
            return daoAprj10031.deleteAprj10031(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인삭제
     * @param Aprj10030Model 설정_결제라인
     * @return int 설정_결제라인삭제수
     */
    public int deleteAprj10031All() throws CommonException {
        try {
            return daoAprj10031.deleteAprj10031All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_결제라인삭제
     * @param Aprj10031Model 설정_결제라인
     * @return int 설정_결제라인삭제수
     */
    public int deleteAprj10031Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10031.deleteAprj10031Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}