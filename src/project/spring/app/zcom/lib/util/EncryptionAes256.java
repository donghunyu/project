package project.spring.app.zcom.lib.util;



import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionAes256 {

	private String key = "1234567890123abc"; //32bit


	public EncryptionAes256() {

	}

	
	public void setKey(String key) {
		this.key = key;
	}
	
	
	public String getKey() {
		return this.key;
	}
	
	
	public SecretKey getSecretKey() {
		SecretKey secureKey = null;
		
		try {
			byte[] keyData = getKey().getBytes();
			secureKey = new SecretKeySpec(keyData, "AES");
		} catch ( Exception e ) {
			e.printStackTrace();
		}

	    return secureKey;
	}
	
	
	// 암호화
	public String AES_Encode(String str) throws Exception {
		String encodedString = null;
		try {
			SecretKey secureKey = getSecretKey();

			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(getKey().getBytes()));

			byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
			encodedString = new String(Base64.getEncoder().encodeToString(encrypted));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return encodedString;
	}

	
	// 복호화
	public String AES_Decode(String str) throws Exception {
		String decodedString = null;
		try {
			SecretKey secureKey = getSecretKey();

			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(getKey().getBytes("UTF-8")));

			byte[] byteStr = Base64.getDecoder().decode(str.getBytes());
			decodedString = new String(c.doFinal(byteStr), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return decodedString;
	}
	
	
	public static void main(String[] args) {
		EncryptionAes256 cla = new EncryptionAes256();
		try {
			System.out.println(cla.AES_Encode("ƼŸ�Ӻ���_�ѹ��ｺ�ɾ�_��ź����_��Ʈ��ũ ����.ppt"));
			System.out.println(cla.AES_Encode("yudonghun"));
			System.out.println(cla.AES_Encode("pari8279"));
			
			
//			System.out.println(cla.AES_Decode("fg3lZO7/0YQsfzMSRJg6aBVfC6jXnW3I4FhKeIEhyQLD0+12/FE46KO3rQ20MECKTBlkQGzsv1L/T13CuRttRNhyu2BeG4XWz31ht/hsbSs="));
//			System.out.println(cla.AES_Decode("YBFzfE08CFuhjEWOeRlspg=="));
//			System.out.println(cla.AES_Decode("k28Wg86PxEdoLmlhfeTOFQ=="));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
