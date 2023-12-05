/*-------------------------------------------------------------------
* NAME   : Aprj10021Service
* DESC   : 설정_업무담당자
* Author : 
* DATE   : 2018-12-12
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

import project.spring.app.aprj.dao.Aprj10021Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj10020Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj10021Service extends AprjService {

    @Autowired
    private Aprj10021Dao daoAprj10021;

    /**
     * 설정_업무담당자검색리스트
     * @param Aprj10020Model 설정_업무담당자
     * @return List<Aprj10020Model> 설정_업무담당자리스트
     */
    public List<Aprj10020Model> srchAprj10021List(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10021.srchAprj10021List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자검색리스트수
     * @param Aprj10020Model 설정_업무담당자
     * @return String 설정_업무담당자리스트수
     */
    public String srchAprj10021Cnt(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10021.srchAprj10021Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자검색
     * @param Aprj10020Model 설정_업무담당자
     * @return Aprj10020Model 설정_업무담당자
     */
    public Aprj10020Model srchAprj10021(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10021.srchAprj10021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자검색리스트
     * @param Aprj10020Model 설정_업무담당자
     * @return List<Aprj10020Model> 설정_업무담당자리스트
     */
    public List<Aprj10020Model> srchAprj10021UserList(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10021.srchAprj10021UserList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자검색리스트수
     * @param Aprj10020Model 설정_업무담당자
     * @return String 설정_업무담당자리스트수
     */
    public String srchAprj10021UserCnt(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10021.srchAprj10021UserCnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자검색리스트수
     * @param Aprj10020Model 설정_업무담당자
     * @return String 설정_업무담당자리스트수
     */
    public List<Aprj10020Model> srchAprj10021StmList(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10021.srchAprj10021StmList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자저장
     * @param Aprj10020Model 설정_업무담당자
     * @return int 설정_업무담당자저장수
     */
    public int saveAprj10021(Aprj10020Model param) throws CommonException {
        try {
            int nCount = updateAprj10021(param);
            if ( nCount == 0 ) {
                nCount = insertAprj10021(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자입력
     * @param Aprj10020Model 설정_업무담당자
     * @return int 설정_업무담당자입력수
     */
    public int insertAprj10021(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10021.insertAprj10021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자수정
     * @param Aprj10020Model 설정_업무담당자
     * @return int 설정_업무담당자수정수
     */
    public int updateAprj10021(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10021.updateAprj10021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자삭제
     * @param Aprj10020Model 설정_업무담당자
     * @return int 설정_업무담당자삭제수
     */
    public int deleteAprj10021(Aprj10020Model param) throws CommonException {
        try {
            return daoAprj10021.deleteAprj10021(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자삭제
     * @param Aprj10020Model 설정_업무담당자
     * @return int 설정_업무담당자삭제수
     */
    public int deleteAprj10021All() throws CommonException {
        try {
            return daoAprj10021.deleteAprj10021All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 설정_업무담당자삭제
     * @param Aprj10021Model 설정_업무담당자
     * @return int 설정_업무담당자삭제수
     */
    public int deleteAprj10021Co(AprjModel param) throws CommonException {
        try {
            return daoAprj10021.deleteAprj10021Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}