/*-------------------------------------------------------------------
* NAME   : Aprj20030Service
* DESC   : 프로젝트_업무버전
* Author : 
* DATE   : 2018-11-16
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

import project.spring.app.aprj.dao.Aprj20030Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class Aprj20030Service extends AprjService {

    @Autowired
    private Aprj20030Dao daoAprj20030;

    /**
     * 프로젝트_업무버전검색리스트
     * @param Aprj20030Model 프로젝트_업무버전
     * @return List<Aprj20030Model> 프로젝트_업무버전리스트
     */
    public List<Aprj20030Model> srchAprj20030List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트수
     * @param Aprj20030Model 프로젝트_업무버전
     * @return String 프로젝트_업무버전리스트수
     */
    public String srchAprj20030Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 프로젝트_업무버전검색
     * @param Aprj20030Model 프로젝트_업무버전
     * @return Aprj20030Model 프로젝트_업무버전
     */
    public Aprj20030Model srchAprj20030(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트
     * @param Aprj20030Model 프로젝트_업무버전
     * @return List<Aprj20030Model> 프로젝트_업무버전리스트
     */
    public List<Aprj20030Model> srchAprj20030UserList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030UserList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트수
     * @param Aprj20030Model 프로젝트_업무버전
     * @return String 프로젝트_업무버전리스트수
     */
    public String srchAprj20030UserCnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030UserCnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색
     * @param Aprj20030Model 프로젝트_업무버전
     * @return Aprj20030Model 프로젝트_업무버전
     */
    public Aprj20030Model srchAprj20030User(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030User(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색
     * @param Aprj20030Model 프로젝트_업무버전
     * @return Aprj20030Model 프로젝트_업무버전
     */
    public List<Aprj20030Model> srchAprj20030UserMailList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030UserMailList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색
     * @param Aprj20030Model 프로젝트_업무버전
     * @return Aprj20030Model 프로젝트_업무버전
     */
    public List<Aprj20030Model> srchAprj20030ScheduleList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030ScheduleList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색
     * @param Aprj20030Model 프로젝트_업무버전
     * @return Aprj20030Model 프로젝트_업무버전
     */
    public List<Aprj20030Model> srchAprj20030TodayList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030TodayList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트수
     * @param Aprj20030Model 프로젝트_업무버전
     * @return String 프로젝트_업무버전리스트수
     */
    public List<Aprj20030Model> srchAprj20030ExcelList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030ExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트수
     * @param Aprj20030Model 프로젝트_업무버전
     * @return String 프로젝트_업무버전리스트수
     */
    public List<Aprj20030Model> srchAprj20030StmExcelList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030StmExcelList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전검색리스트수
     * @param Aprj20030Model 프로젝트_업무버전
     * @return String 프로젝트_업무버전리스트수
     */
    public String srchAprj20030UserOpId(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.srchAprj20030UserOpId(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전저장
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전저장수
     */
    public int saveAprj20030(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20030(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20030(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전입력
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전입력수
     */
    public int insertAprj20030(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.insertAprj20030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전입력
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전입력수
     */
    public int insertAprj20030Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.insertAprj20030Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전입력
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전입력수
     */
    public int insertAprj20030VerUp(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.insertAprj20030VerUp(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전수정
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전수정수
     */
    public int updateAprj20030(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.updateAprj20030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전수정
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전수정수
     */
    public int updateAprj20030Tran(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.updateAprj20030Tran(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전수정
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전수정수
     */
    public int updateAprj20030Prj(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.updateAprj20030Prj(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전삭제
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전삭제수
     */
    public int deleteAprj20030(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20030.deleteAprj20030(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전삭제
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전삭제수
     */
    public int deleteAprj20030All() throws CommonException {
        try {
            return daoAprj20030.deleteAprj20030All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_업무버전삭제
     * @param Aprj20030Model 프로젝트_업무버전
     * @return int 프로젝트_업무버전삭제수
     */
    public int deleteAprj20030Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20030.deleteAprj20030Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}