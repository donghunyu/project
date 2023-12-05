/*-------------------------------------------------------------------
* NAME   : Aprj30020Dao
* DESC   : 보고서_업무 현황
* Author : 
* DATE   : 2018-11-16
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.dao;

import project.spring.app.aprj.lib.object.AprjDao;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Aprj30020Dao extends AprjDao {

    /**
     * 보고서_업무검색리스트
     * @param Aprj20030Model 보고서_업무
     * @return List<Aprj20030Model> 보고서_업무리스트
     */
    public List<Aprj20030Model> srchAprj30020List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj30020Query.selectAPRJ30020_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 보고서_업무검색리스트수
     * @param Aprj20030Model 보고서_업무
     * @return String 보고서_업무리스트수
     */
    public String srchAprj30020Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj30020Query.selectAPRJ30020_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }
}