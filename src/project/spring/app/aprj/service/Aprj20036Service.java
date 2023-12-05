/*-------------------------------------------------------------------
* NAME   : Aprj20036Service
* DESC   : 프로젝트_결제담당자
* Author : 
* DATE   : 2019-01-30
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.dao.Aprj20036Dao;
import project.spring.app.aprj.lib.object.AprjModel;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.StringUtil;

@Service
public class Aprj20036Service extends AprjService {

    @Autowired
    private Aprj20036Dao daoAprj20036;

    private String STM_AUTH_CD_DEPT = "1000";
    
    /**
     * 프로젝트_결제담당자검색리스트
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return List<Aprj20030Model> 프로젝트_결제담당자리스트
     */
    public List<Aprj20030Model> srchAprj20036List(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.srchAprj20036List(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색리스트수
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return String 프로젝트_결제담당자리스트수
     */
    public String srchAprj20036Cnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.srchAprj20036Cnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return Aprj20030Model 프로젝트_결제담당자
     */
    public Aprj20030Model srchAprj20036(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.srchAprj20036(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return Aprj20030Model 프로젝트_결제담당자
     */
    public List<Aprj20030Model> srchAprj20036Batch(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.srchAprj20036Batch(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return Aprj20030Model 프로젝트_결제담당자
     */
    public List<Aprj20030Model> srchAprj20036High(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.srchAprj20036High(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return Aprj20030Model 프로젝트_결제담당자
     */
    public List<Aprj20030Model> srchAprj20036OpChrg(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.srchAprj20036OpChrg(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return Aprj20030Model 프로젝트_결제담당자
     */
    public Aprj20030Model srchAprj20036Exist(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.srchAprj20036Exist(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색리스트
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return List<Aprj20030Model> 프로젝트_결제담당자리스트
     */
    public List<Aprj20030Model> srchAprj20036UserList(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.srchAprj20036UserList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자검색리스트수
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return String 프로젝트_결제담당자리스트수
     */
    public String srchAprj20036UserCnt(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.srchAprj20036UserCnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자저장
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자저장수
     */
    public int saveAprj20036StmUser(Aprj20030Model param) throws CommonException {
        int cnt = 0;
        try {
            List<Aprj20030Model> batchList = srchAprj20036Batch(param);

            List<Aprj20030Model> insertList = new ArrayList<Aprj20030Model>();
            
            List<Aprj20030Model> tempList = new ArrayList<Aprj20030Model>();
            Aprj20030Model temp   = new Aprj20030Model();
            
            String deptId   = "";
            String opChrgId = "";
            String userId   = "";
            
            param.setStmSerNum(null);
            param.setStmSeqNum(null);
            param.setOpChrgId (null);
            param.setUserId   (null);
            deleteAprj20036(param);
            
            for ( int i = 0; i < batchList.size(); i++ ) {
            	if ( i == 0 ) {
            		param = batchList.get(i);
            	}
            	
            	temp = batchList.get(i);
            	
            	if ( !(userId.equals(temp.getUserId()) && opChrgId.equals(temp.getOpChrgId())) ) {
            		opChrgId = temp.getOpChrgId();
            		userId   = temp.getUserId  ();
            		deptId   = temp.getDeptId  ();
            	}
            	
            	if ( STM_AUTH_CD_DEPT.equals(temp.getStmAuthCd()) ) {
            		if ( StringUtil.isNull(deptId) ) {
            			continue;
            		}
            		
            		temp.setDeptId(deptId);
            		tempList = srchAprj20036High(temp);
            		addList(insertList, tempList);
            		if ( tempList != null && tempList.size() > 0 ) {
            			deptId = tempList.get(0).getStmDeptId();
            		}
            	} else {
            		tempList = srchAprj20036OpChrg(temp);
            		addList(insertList, tempList);
            	}
            	
            	if ( !StringUtil.isNull(temp.getStmUserId()) ) {
            		insertList.add(temp);
            	}
            }
            
            for ( int i = 0; i < insertList.size(); i++ ) {
            	param = insertList.get(i);
            	
    			if ( srchAprj20036Exist(param) == null ) {
    				cnt += insertAprj20036(param);
    			}
            }
            
        } catch ( Exception e) {
            throw new CommonException(e);
        }
        
        return cnt;
    }


    public List<Aprj20030Model> addList(List<Aprj20030Model> arrayTarget, List<Aprj20030Model> arrayAttact) {
      	if ( arrayTarget == null ) {
      		return arrayAttact;
      	}
      	if ( arrayAttact == null ) {
      		return arrayTarget;
      	}
      	 
      	for ( int i = 0; i < arrayAttact.size(); i++ ) {
      		arrayTarget.add(arrayAttact.get(i));
      	}
      	
      	return arrayTarget;
    }
    
    
    /**
     * 프로젝트_결제담당자저장
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자저장수
     */
    public int saveAprj20036(Aprj20030Model param) throws CommonException {
        try {
            int nCount = updateAprj20036(param);
            if ( nCount == 0 ) {
                nCount = insertAprj20036(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자입력
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자입력수
     */
    public int insertAprj20036(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.insertAprj20036(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자입력
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자입력수
     */
    public int insertAprj20036Co(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.insertAprj20036Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자입력
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자입력수
     */
    public int insertAprj20036VerUp(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.insertAprj20036VerUp(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자수정
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자수정수
     */
    public int updateAprj20036(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.updateAprj20036(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자삭제
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자삭제수
     */
    public int deleteAprj20036(Aprj20030Model param) throws CommonException {
        try {
            return daoAprj20036.deleteAprj20036(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자삭제
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자삭제수
     */
    public int deleteAprj20036All() throws CommonException {
        try {
            return daoAprj20036.deleteAprj20036All();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 프로젝트_결제담당자삭제
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자삭제수
     */
    public int deleteAprj20036Co(AprjModel param) throws CommonException {
        try {
            return daoAprj20036.deleteAprj20036Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

    
    /**
     * 프로젝트_결제담당자삭제
     * @param Aprj20030Model 프로젝트_결제담당자
     * @return int 프로젝트_결제담당자삭제수
     */
    public int deleteAprj20036Add(AprjModel param) throws CommonException {
        try {
            return daoAprj20036.deleteAprj20036Add(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}