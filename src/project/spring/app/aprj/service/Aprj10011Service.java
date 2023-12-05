/*-------------------------------------------------------------------
* NAME   : Aprj10011Service
* DESC   : 설정_자산구분자산
* Author : 
* DATE   : 2019-01-18
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

import project.spring.app.aprj.dao.Aprj10011Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10010Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10011Service extends AprjService {

    @Autowired
    private Aprj10011Dao daoAprj10011;

    /**
     * 설정_자산구분자산검색리스트
     * @param Aprj10010Model 설정_자산구분자산
     * @return List<Aprj10010Model> 설정_자산구분자산리스트
     */
    public List<Aprj10010Model> srchAprj10011List(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10011.srchAprj10011List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산검색리스트수
     * @param Aprj10010Model 설정_자산구분자산
     * @return String 설정_자산구분자산리스트수
     */
    public String srchAprj10011Cnt(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10011.srchAprj10011Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산검색
     * @param Aprj10010Model 설정_자산구분자산
     * @return Aprj10010Model 설정_자산구분자산
     */
    public Aprj10010Model srchAprj10011(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10011.srchAprj10011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산저장
     * @param Aprj10010Model 설정_자산구분자산
     * @return int 설정_자산구분자산저장수
     */
    public int saveAprj10011(Aprj10010Model param) throws CommonException {
        try {
            int nCount = updateAprj10011(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10011(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산입력
     * @param Aprj10010Model 설정_자산구분자산
     * @return int 설정_자산구분자산입력수
     */
    public int insertAprj10011(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10011.insertAprj10011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산수정
     * @param Aprj10010Model 설정_자산구분자산
     * @return int 설정_자산구분자산수정수
     */
    public int updateAprj10011(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10011.updateAprj10011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산삭제
     * @param Aprj10010Model 설정_자산구분자산
     * @return int 설정_자산구분자산삭제수
     */
    public int deleteAprj10011(Aprj10010Model param) throws CommonException {
        try {
            return daoAprj10011.deleteAprj10011(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산삭제
     * @param Aprj10010Model 설정_자산구분자산
     * @return int 설정_자산구분자산삭제수
     */
    public int deleteAprj10011All() throws CommonException {
        try {
            return daoAprj10011.deleteAprj10011All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_자산구분자산삭제
     * @param Aprj10010Model 설정_자산구분자산
     * @return int 설정_자산구분자산삭제수
     */
    public int deleteAprj10011Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10011.deleteAprj10011Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}