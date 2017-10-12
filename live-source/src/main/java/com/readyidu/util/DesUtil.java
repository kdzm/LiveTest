package com.readyidu.util;

import java.security.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * Copyright 2007 GuangZhou Cotel Co. Ltd.
 * All right reserved.
 * DES加密解密类.
 *
 * @author <a href="mailto:xiexingxing1121@126.com" mce_href="mailto:xiexingxing1121@126.com">AmigoXie</a>
 * @version 1.0
 *          Creation date: 2007-7-31 - 上午11:59:28
 */
public class DesUtil {

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//        String content="aaaaaaaabbbbbbbbaaaaaaaa";
//        String key="01234567";
//
//        System.out.println("加密前："+byteToHexString(content.getBytes()));
//        byte[] encrypted=DES_ECB_Encrypt(content.getBytes(), key.getBytes());
//        System.out.println("加密后："+byteToHexString(encrypted));
//        byte[] decrypted=DES_ECB_Decrypt(encrypted, key.getBytes());
//        System.out.println("解密后："+byteToHexString(decrypted));
//    }

    public static byte[] DES_ECB_Encrypt(byte[] content, byte[] keyBytes){
        try {
            DESKeySpec keySpec=new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("DES");
            SecretKey key=keyFactory.generateSecret(keySpec);

            Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result=cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("exception:"+e.toString());
        }
        return null;
    }

    public static byte[] DES_ECB_Decrypt(byte[] content, byte[] keyBytes){
        try {
            DESKeySpec keySpec=new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("DES");
            SecretKey key=keyFactory.generateSecret(keySpec);

            Cipher cipher=Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result=cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("exception:"+e.toString());
        }
        return null;
    }

    public static String byteToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length);
        String sTemp;
        for (int i = 0; i < bytes.length; i++) {
            sTemp = Integer.toHexString(0xFF & bytes[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }
}