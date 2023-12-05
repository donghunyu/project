package project.spring.app.zcom.lib.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.model.Zcom99030Model;

public class SendMail {
	
	
    public static final String WORK_MAIL_TITLE      = "업무 요청 알림 메일을 보내 드립니다. 검토 바랍니다.";
    public static final String WORK_MAIL_HEADER     = "업무 요청 알림 메일을 보내 드립니다." + "\n" + "주소를 클릭하시면 해당 업무로 이동합니다.";
    public static final String WORK_MAIL_FOOTER     = "\n\n\nCOPYRIGHT GADIAN Security. CO., LTD. ALL RIGHTS RESERVED.";
    
    public static final String SIGN_MAIL_TITLE      = "결제 요청 알림 메일을 보내 드립니다. 결제 바랍니다.";
    public static final String SIGN_MAIL_HEADER     = "업무 요청 알림 메일을 보내 드립니다." + "\n" + "주소를 클릭하시면 해당 결제로 이동합니다.";
    public static final String SIGN_MAIL_FOOTER     = "\n\n\nCOPYRIGHT GADIAN Security. CO., LTD. ALL RIGHTS RESERVED.";
    
    public static final String PWD_MAIL_TITLE       = "비밀번호 초기화 안내 메일입니다.";
    public static final String RWD_MAIL_HEADER      = "비밀번호 초기화 안내 메일입니다. 비밀번호 수정 후 사용하시기 바랍니다.";
    public static final String PWD_MAIL_FOOTER      = "\n\n\nCOPYRIGHT GADIAN Security. CO., LTD. ALL RIGHTS RESERVED.";
	
	
	public SendMail() {
		
	}
	
	
	public static void sendMailPwd(Zcom99030Model param) throws CommonException {
		SendMail sendMail = new SendMail();
		sendMail.sendMail(param.getMailAddr(), PWD_MAIL_TITLE, RWD_MAIL_HEADER + "\n\n" + "새로운 비밀번호는 '" + param.getUserPwd() + "' 입니다." + PWD_MAIL_FOOTER);
	}
	
	public static void sendMailWork(String mailAddr, String title, String cont) throws CommonException {
		SendMail sendMail = new SendMail();
		
		sendMail.sendMail(mailAddr, WORK_MAIL_TITLE, WORK_MAIL_HEADER + cont + WORK_MAIL_FOOTER);
	}
	
	public static void sendMailSign(String mailAddr, String title, String cont) throws CommonException {
		SendMail sendMail = new SendMail();
		sendMail.sendMail(mailAddr, SIGN_MAIL_TITLE, SIGN_MAIL_HEADER + cont + SIGN_MAIL_FOOTER);
	}
	
	public void sendMail(String mailAddr, String title, String cont) throws CommonException {
		
		String subject = title;                         // subject
		String msgText = cont;                          // message
		String host    = "mw-002.cafe24.com";           // smtp mail server      
		String from    = "gadian2018@gadian.kr";        // sender email address
		String to      = mailAddr;                      // receiver email address

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth","true");

		Authenticator auth = new MyAuthentication();
		Session sess = Session.getInstance(props, auth);

		try {
	        Message msg = new MimeMessage(sess);
	        msg.setFrom(new InternetAddress(from));
	        InternetAddress[] address = {new InternetAddress(to)};
	        msg.setRecipients(Message.RecipientType.TO, address);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	        msg.setText(msgText);

	        Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	public void sendMailGoogle(String mailAddr, String title, String cont) throws CommonException {
		
		Properties p = System.getProperties();
        p.put("mail.smtp.starttls.enable", "true"          );     
        p.put("mail.smtp.host"           , "smtp.gmail.com"); // smtp 서버 호스트
        p.put("mail.smtp.auth"           , "true"          );
        p.put("mail.smtp.port"           , "587"           ); // gmail 포트

        Authenticator auth = new MyAuthentication();    //구글 계정 인증

        //session 생성 및  MimeMessage생성
        Session session = Session.getDefaultInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
        String fromName = "Project Me";
        String charSet = "UTF-8";

        
//        String user    = "yudonghun7@daum.net";
        String user    = mailAddr;
        String text    = title;
        
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
        buffer.append("\n<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        buffer.append("\n    <head>");
        buffer.append("\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
        buffer.append("\n        <title>Demystifying Email Design</title>");
        buffer.append("\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>");
        buffer.append("\n    </head>");
        buffer.append("\n    <body>");
        buffer.append("\n" + cont);
        buffer.append("\n        <a href='http://localhost:8080/project/aprj00000_50.do?tmpLoginId=6eb1badc-9955-4bfb-9f26-efde072e7f41'>http://localhost:8080/project/aprj00000_50.do?tmpLoginId=6eb1badc-9955-4bfb-9f26-efde072e7f41</a>");
        buffer.append("\n    </body>");
        buffer.append("\n</html>");
        
        try{
            // 편지보낸시간 설정
            msg.setSentDate(new Date());

            // 송신자 설정
            InternetAddress from = new InternetAddress() ;
            from = new InternetAddress(new String(fromName.getBytes(charSet), "8859_1") + "<mainprojectm@gmail.com>");
            msg.setFrom(from);


            // 수신자 설정
            InternetAddress to = new InternetAddress(user);
            msg.setRecipient(Message.RecipientType.TO, to);


            // 제목 설정
            msg.setSubject(text, charSet);
           // msg.setText(buffer.toString(), charSet);  //내용 설정
            msg.setContent(buffer.toString(),"text/html; charset=utf-8"); 


            // 메일 송신
            Transport.send(msg);    

            System.out.println("메일 발송을 완료하였습니다.");
        }catch (AddressException addr_e) {  // 예외처리 주소를 입력하지 않을 경우
            JOptionPane.showMessageDialog(null, "메일을 입력해주세요", "메일주소입력", JOptionPane.ERROR_MESSAGE);
            addr_e.printStackTrace();
        }catch (MessagingException msg_e) { // 메시지에 이상이 있을 경우
            JOptionPane.showMessageDialog(null, "메일을 제대로 입력해주세요.", "오류발생", JOptionPane.ERROR_MESSAGE);
            msg_e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	public class MyAuthentication extends Authenticator {
	    PasswordAuthentication pa;

	    public MyAuthentication(){  //생성자를 통해 구글 ID/PW 인증
	        String id = "gadian2018@gadian.kr";       // ID
	        String pw = "rkeldks!2";       // 비밀번호

//	        String id = "mainprojectm";       // 구글 ID
//	        String pw = "pari8279";          // 구글 비밀번호

	        // ID와 비밀번호를 입력한다.
	        pa = new PasswordAuthentication(id, pw);
	    }
	  
	    // 시스템에서 사용하는 인증정보
	    public PasswordAuthentication getPasswordAuthentication() {
	        return pa;
	    }
	}

	  
}
