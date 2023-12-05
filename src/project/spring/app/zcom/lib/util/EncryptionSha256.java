package project.spring.app.zcom.lib.util;

import java.security.MessageDigest;

public class EncryptionSha256 {

	
	public EncryptionSha256() {
		
	}
	
	
	public static String encryptSha256(String str) {
		String encryjptOrg = "";
		
		try {
			MessageDigest msgdigest = MessageDigest.getInstance("SHA-256");
			msgdigest.update(str.getBytes());
			byte byteData[] = msgdigest.digest();
			
			StringBuffer buffer = new StringBuffer();
			for ( int i = 0; i < byteData.length; i++ ) {
				buffer.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			
			encryjptOrg = buffer.toString();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		
		return encryjptOrg;
	}
	
	
	public static void main(String[] args) {
		System.out.println(EncryptionSha256.encryptSha256("yudonghun7"));
		System.out.println(EncryptionSha256.encryptSha256("yudonghun7"));
		System.out.println(EncryptionSha256.encryptSha256("yudonghun"));
		System.out.println(EncryptionSha256.encryptSha256("pari8279"));
	}
	
	
	
}
