package test;

import java.security.MessageDigest;

public class Sha256 {

	
	public Sha256() {
		
	}
	
	
	public String encryptSha256(String str) {
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
		Sha256 cla = new Sha256();
		System.out.println(cla.encryptSha256("yudonghun7"));
		System.out.println(cla.encryptSha256("yudonghun7"));
		System.out.println(cla.encryptSha256("yudonghun"));
		System.out.println(cla.encryptSha256("pari8279"));
	}
	
	
	
}
