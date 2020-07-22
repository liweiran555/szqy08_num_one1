package com.szqy08.shiro;

import com.szqy08.util.MyConstants;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.util.DigestUtils;

/**
 * @Author: 陈建
 * @Date: 2019/10/10 0010 17:06
 * @Version 1.0
 */
public class ShiroUtil {
    /**
     * 传入一个明文返回一个加密之后的密文
     */
    public static  String getciphertext(String phertext){
        String ciphertext = DigestUtils.md5DigestAsHex(phertext.getBytes());
        return ciphertext;
    }

    /**
     * 加盐加密
     * @param salt
     * @param message
     * @return
     */
    public static String  encryptionBySalt(String salt,String message){
        //String algorithmName 加密算法, Object source 明文, Object salt 盐值, int hashIterations 加密次数
        String algorithmName= MyConstants.ALGORITHM_NAME;
        int hashIterations=MyConstants.HASH_ITERATIONS;
        SimpleHash simpleHash=new SimpleHash(algorithmName,message,salt,hashIterations);
        return simpleHash.toString();
    }

    public static void main(String[] args) {
        String message="chenjian";
      /*  String s = getciphertext(message);
        System.out.println(s);*/
       //shiro加密
        String salt= "9ed6610c-6132-4d0c-a8a4-5011080ba754";

        String encryption = encryptionBySalt(salt, message);
        System.out.println(encryption);

    }
}
