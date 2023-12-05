/*-------------------------------------------------------------------
* NAME   : Aprj10022Service
* DESC   : 설정_업무자산구분
* Author : 
* DATE   : 2018-11-07
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

import project.spring.app.aprj.dao.Aprj10022Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10020Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10022Service extends AprjService {

    @Autowired
    private Aprj10022Dao daoAprj10022;

    /**
     * 설정_업무자산구분검색리스트
     * @param Aprj10020Model 설정_업무자산구분
     * @return List<Aprj10020Model> 설정_업무자산구분리스트
     */
    public List<Aprj10020Model> srchAprj10022List(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10022.srchAprj10022List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분검색리스트수
     * @param Aprj10020Model 설정_업무자산구분
     * @return String 설정_업무자산구분리스트수
     */
    public String srchAprj10022Cnt(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10022.srchAprj10022Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분검색
     * @param Aprj10020Model 설정_업무자산구분
     * @return Aprj10020Model 설정_업무자산구분
     */
    public Aprj10020Model srchAprj10022(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10022.srchAprj10022(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분저장
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분저장수
     */
    public int saveAprj10022(Aprj10020Model param) throws CommonException {
        try {
            int nCount = updateAprj10022(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10022(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분입력
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분입력수
     */
    public int insertAprj10022(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10022.insertAprj10022(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분입력
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분입력수
     */
    public int insertAprj10022Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10022.insertAprj10022Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분수정
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분수정수
     */
    public int updateAprj10022(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10022.updateAprj10022(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분삭제
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분삭제수
     */
    public int deleteAprj10022(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10022.deleteAprj10022(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분삭제
     * @param Aprj10020Model 설정_업무자산구분
     * @return int 설정_업무자산구분삭제수
     */
    public int deleteAprj10022All() throws CommonException {
        try {
            return daoAprj10022.deleteAprj10022All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무자산구분삭제
     * @param Aprj10022Model 설정_업무자산구분
     * @return int 설정_업무자산구분삭제수
     */
    public int deleteAprj10022Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10022.deleteAprj10022Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}