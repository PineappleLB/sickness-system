package com.sickness.util;

import java.security.MessageDigest;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
/**
 * 加密类
 *
 * @author pineapple
 * @create 2019/3/5
 */
public class EncryptUtil {

//    private static final String key="1q2w3e4r5t6y!Q@W#E$R%T^Y";

    public static String decode3Des(String key, String desStr) throws Exception{
        byte[] src =Base64.decodeBase64(desStr);
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(key.getBytes(), "DESede");
            //解密
            Cipher c1 = Cipher.getInstance("DESede");
            c1.init(Cipher.DECRYPT_MODE, deskey);
            String pwd = new String(c1.doFinal(src),"UTF-8");
            return pwd;
        } catch (java.security.NoSuchAlgorithmException e1) {
            throw new Exception("无此算法");
        }catch(javax.crypto.NoSuchPaddingException e2){
            throw new Exception("无法padding");
        }catch(java.lang.Exception e3){
            throw new Exception(e3.getMessage());
        }
    }
    public static String  encode3Des(String key,String srcStr) throws Exception{
        byte[] src = srcStr.getBytes("UTF-8");
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(key.getBytes("UTF-8"), "DESede");
            //加密
            Cipher c1 = Cipher.getInstance("DESede");
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            String pwd = Base64.encodeBase64String(c1.doFinal(src));
            return pwd;
        } catch (java.security.NoSuchAlgorithmException e1) {
            throw new Exception("无此算法");
        }catch(javax.crypto.NoSuchPaddingException e2){
            throw new Exception("无法padding");
        }catch(java.lang.Exception e3){
            throw new Exception(e3.getMessage());
        }
    }

    /**
     * MD5加密方法
     * @param srcStr 源字符串
     * @param solt 加密盐
     * @return
     */
    public static String getMd5Encrypt(String srcStr, String solt) {
        StringBuffer buffer = new StringBuffer(srcStr + solt);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte tar[] = md.digest(srcStr.getBytes("UTF-8"));
            return Base64.encodeBase64String(tar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * MD5加密方法
     * @param srcStr 源字符串
     * @return
     */
    public static String getMd5Encrypt(String srcStr) {
        StringBuffer buffer = new StringBuffer(srcStr);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte tar[] = md.digest(srcStr.getBytes("UTF-8"));
            return Base64.encodeBase64String(tar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }


    public static void main(String[] args) throws Exception {
        String aaa = "222222";
//        System.out.println(getMd5Encrypt(aaa));
        String uuid = UUID.randomUUID().toString();

		 String encode = getMd5Encrypt(aaa, uuid);
		 System.out.println(encode);
//		 System.out.println(encode);
//		 String decode = decode3Des(key, encode);
//		 System.out.println(decode);
    }

}
