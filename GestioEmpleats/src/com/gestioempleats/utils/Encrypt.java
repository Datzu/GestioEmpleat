package com.gestioempleats.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
	
	/**
	 * @author Adrian Garcia
	 * @param cad Cadena que envia per transformar
	 * @return retorna la cadena ya transformada
	 * Clase que transforma i encripta una contrasenya
	 */
	
	public static String encrypt(String cad) {
		MessageDigest md;
		try {
			StringBuffer sb = new StringBuffer();
			md = MessageDigest.getInstance("SHA-256");
			md.update(cad.getBytes());

			byte byteData[] = md.digest();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// transform the cad into a new one
		return null;
	}
	
}
