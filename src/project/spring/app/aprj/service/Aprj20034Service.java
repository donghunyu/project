/*-------------------------------------------------------------------
* NAME   : Aprj20034Service
* DESC   : 프로젝트_업무담당자
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

import project.spring.app.aprj.dao.Aprj20034Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20034Service extends AprjService {

    @Autowired
    private Aprj20034Dao daoAprj20034;

    /**
     * 프로젝트_업무담당자검색리스트
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return List<Aprj20030Model> 프로젝트_업무담당자리스트
     */
    public List<Aprj20030Model> srchAprj20034List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.srchAprj20034List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자검색리스트수
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return String 프로젝트_업무담당자리스트수
     */
    public String srchAprj20034Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.srchAprj20034Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자검색
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return Aprj20030Model 프로젝트_업무담당자
     */
    public Aprj20030Model srchAprj20034(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.srchAprj20034(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자검색리스트
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return List<Aprj20030Model> 프로젝트_업무담당자리스트
     */
    public List<Aprj20030Model> srchAprj20034GroupList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.srchAprj20034GroupList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자검색리스트수
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return String 프로젝트_업무담당자리스트수
     */
    public String srchAprj20034GroupCnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.srchAprj20034GroupCnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자저장
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자저장수
     */
    public int saveAprj20034(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20034(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20034(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자입력
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자입력수
     */
    public int insertAprj20034(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.insertAprj20034(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자입력
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자입력수
     */
    public int insertAprj20034Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.insertAprj20034Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자입력
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자입력수
     */
    public int insertAprj20034VerUp(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.insertAprj20034VerUp(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자입력
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자입력수
     */
    public int selectInsertAprj20034(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.selectInsertAprj20034(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자수정
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자수정수
     */
    public int updateAprj20034(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.updateAprj20034(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자수정
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자수정수
     */
    public int updateAprj20034Trnsf(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.updateAprj20034Trnsf(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자수정
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자수정수
     */
    public int updateAprj20034Sign(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.updateAprj20034Sign(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자삭제
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자삭제수
     */
    public int deleteAprj20034(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.deleteAprj20034(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자삭제
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자삭제수
     */
    public int deleteAprj20034All() throws CommonException {
        try {
            return daoAprj20034.deleteAprj20034All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자삭제
     * @param Aprj20030Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자삭제수
     */
    public int deleteAprj20034Trnsf(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20034.deleteAprj20034Trnsf(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무담당자삭제
     * @param Aprj20034Model 프로젝트_업무담당자
     * @return int 프로젝트_업무담당자삭제수
     */
    public int deleteAprj20034Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20034.deleteAprj20034Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}