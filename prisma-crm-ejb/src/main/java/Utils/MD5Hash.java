package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {

	public static String getMD5Hash(String input) {
		StringBuffer sb = new StringBuffer();

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			byte[] mdbytes = md.digest();

			for (int i = 0; i < mdbytes.length; i++) {
				sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		return sb.toString();
	}

}
