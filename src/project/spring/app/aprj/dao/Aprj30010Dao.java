/*-------------------------------------------------------------------
* NAME   : Aprj30010Dao
* DESC   : 보고서_프로젝트 현황
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
public class Aprj30010Dao extends AprjDao {

    /**
     * 보고서_프로젝트검색리스트
     * @param Aprj20030Model 보고서_프로젝트
     * @return List<Aprj20030Model> 보고서_프로젝트리스트
     */
    public List<Aprj20030Model> srchAprj30010List(Aprj20030Model param) throws CommonException {
        try {
            return sessionConn.selectList("Aprj30010Query.selectAPRJ30010_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 보고서_프로젝트검색리스트수
     * @param Aprj20030Model 보고서_프로젝트
     * @return String 보고서_프로젝트리스트수
     */
    public String srchAprj30010Cnt(Aprj20030Model param) throws CommonException {
        try {
            return ((Aprj20030Model) sessionConn.selectOne("Aprj30010Query.selectAPRJ30010_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }
}