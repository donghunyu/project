/*-------------------------------------------------------------------
* NAME   : Zcom99031Dao
* DESC   : 관리자_업체
* Author : 
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.dao;

import project.spring.app.aprj.lib.object.AprjDao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99031Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Zcom99031Dao extends AprjDao {

    /**
     * 관리자_업체검색리스트
     * @param Zcom99031Model 관리자_업체
     * @return List<Zcom99031Model> 관리자_업체리스트
     */
    public List<Zcom99031Model> srchZcom99031List(Zcom99031Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99031Query.selectZCOM99031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체검색리스트수
     * @param Zcom99031Model 관리자_업체
     * @return String 관리자_업체리스트수
     */
    public String srchZcom99031Cnt(Zcom99031Model param) throws CommonException {
        try {
            return ((Zcom99031Model) sessionConn.selectOne("Zcom99031Query.selectZCOM99031_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체검색
     * @param Zcom99031Model 관리자_업체
     * @return Zcom99031Model 관리자_업체
     */
    public Zcom99031Model srchZcom99031(Zcom99031Model param) throws CommonException {
        try {
            return (Zcom99031Model) sessionConn.selectOne("Zcom99031Query.selectZCOM99031_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체입력
     * @param Zcom99031Model 관리자_업체
     * @return int 관리자_업체입력수
     */
    public int insertZcom99031(Zcom99031Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99031Query.insertZCOM99031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체수정
     * @param Zcom99031Model 관리자_업체
     * @return int 관리자_업체수정수
     */
    public int updateZcom99031(Zcom99031Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99031Query.updateZCOM99031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체삭제
     * @param Zcom99031Model 관리자_업체
     * @return int 관리자_업체삭제수
     */
    public int deleteZcom99031(Zcom99031Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99031Query.deleteZCOM99031_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체삭제
     * @param Zcom99031Model 관리자_업체
     * @return int 관리자_업체삭제수
     */
    public int deleteZcom99031All() throws CommonException {
        try {
            return sessionConn.update("Zcom99031Query.deleteZCOM99031_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_업체삭제
     * @param Zcom99031Model 관리자_업체
     * @return int 관리자_업체삭제수
     */
    public int deleteZcom99031Co(AprjModel param) throws CommonException {
        try {
            return sessionConn.update("Zcom99031Query.deleteZCOM99031_10", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}