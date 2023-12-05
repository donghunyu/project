/*-------------------------------------------------------------------
* NAME   : Aprj20030Service
* DESC   : 프로젝트_업무
* Author : 
* DATE   : 2018-11-16
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.aprj.schedule;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.aprj.dao.Aprj20053Dao;
import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.aprj.model.Aprj20030Model;
import project.spring.app.zcom.dao.Zcom99040Dao;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.SendMail;
import project.spring.app.zcom.lib.util.StringUtil;
import project.spring.app.zcom.model.Zcom99040Model;

@Service
public class Aprj20053SignMailSchedule extends AprjService {

    @Autowired
    private Aprj20053Dao daoAprj20053;

    @Autowired
    private Zcom99040Dao daoZcom99040;

    
    // 매일 08시 작업
    @Scheduled(cron="0 0 0 * * ?")
    public void srchAprj20030SignList() throws CommonException {
    	try {
    		//System.out.println("----------------------------------- SCHEDULE Daily : " + DateUtil.getCurrentDateTime());
    		Aprj20030Model temp = new Aprj20030Model();
    		temp.setPageRowCnt("99999");
    		temp.setResStCd(ApplicationConstants_Aprj.RES_ST_CD_1000);
    		
            List<Aprj20030Model> userList = daoAprj20053.srchAprj20053UserList(temp);
            
            String reqUrl = ApplicationConstants_Aprj.getDomain() + "/aprj20053_51.do?";
            String url    = ApplicationConstants_Aprj.getDomain() + ActionConstants_Aprj.ACTION_TEMP_LOGIN + "?tmpLoginId=";
            String scrUrl = "";
    		String mailCtt  = "";
            UUID uuid;
    		String userId   = "";
    		String mailAddr = "";
            
            Zcom99040Model param = new Zcom99040Model();
        	SendMail sendMail = new SendMail();
            
            for ( int i = 0; i < userList.size(); i++ ) {
            	temp = userList.get(i);
            	
            	if ( StringUtil.isNull(temp.getMailAddr()) ) {
            		continue;
            	}
            	
    			System.out.println(temp.getStmUserId());
    			if ( !userId.equals(temp.getStmUserId()) ) {
    				if ( mailAddr.length() > 0  ) {
    					sendMail.sendMail(mailAddr, "결제요청 메일", mailCtt);
    				}
    				userId   = temp.getStmUserId();
    				mailAddr = temp.getMailAddr ();
    				mailCtt  = "";
    			}
    			
    			scrUrl = reqUrl + "coId="       + temp.getCoId     ()
            			        + "&opId="      + temp.getOpId     ()
            			        + "&opSerNum="  + temp.getOpSerNum ()
            			        + "&opChrgId="  + temp.getOpChrgId ()
            			        + "&userId="    + temp.getUserId   ()
		                        + "&resSerNum=" + temp.getResSerNum()
                                + "&stmSeqNum=" + temp.getStmSeqNum();

    			uuid = UUID.randomUUID();
    			mailCtt = mailCtt + url + uuid.toString () + "\n\n";
            	
            	// 메일보내기
            	try {
                	// 임시로그인 정보 저장
//                	param.setTmpLoginId(uuid.toString ());
//                	param.setUserId    (temp.getStmUserId());
//                	param.setScrUrl    (scrUrl          );
//                	param.setEffStaDt  (DateUtil.getCurrentDate("yyyyMMdd"));
//                	param.setEffEndDt  (DateUtil.getAddDate(param.getEffStaDt(), 7));
//                	param.setBatchUser ();
                	
                	daoZcom99040.insertZcom99040(param);
            	} catch ( Exception e ) {
            		e.printStackTrace();
            	}
            	
            	
            	if ( i == userList.size() - 1 ) {
    				if ( mailAddr.length() > 0  ) {
    					sendMail.sendMail(mailAddr, "결제요청 메일", mailCtt);
    				}
            	}
            }
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    }
}