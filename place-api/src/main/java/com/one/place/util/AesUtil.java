package com.one.place.util;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public enum AesUtil {
  ;
  private static String CIPHER_NAME = "AES/CBC/PKCS5Padding";

  /**
   * 加密模式 AES/CBC(密文分组链接)/填充方式（填充总字节数）
   */
  private static final String CIPHER_MODE = "AES/CBC/PKCS5Padding";
  /**
   * 加密算法
   */
  private static final String ENCRYPT_ALG = "AES";

  /**
   * 密钥 不能修改
   */
  public static String key = "882195b6-0fbe-44b6-874c-4b924b53f46e";
  /**
   * 初始化向量IV (必须是16字节)
   */
  public static String iv = "1a6d6bc1-142f-44";

  public static byte[] encrypt(byte[] key, byte[] iv, byte[] input)
      throws Exception {
    Cipher cipher = Cipher.getInstance(CIPHER_NAME);
    SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv));
    return cipher.doFinal(input);
  }

  public static byte[] decrypt(byte[] key, byte[] iv, byte[] input) throws Exception {
    Cipher cipher = Cipher.getInstance(CIPHER_NAME);
    SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
    cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));
    return cipher.doFinal(input);
  }

  /**
   * 加密指定字符串
   *
   * @param rawText 原始字符串
   * @return 加密后字符串
   */
  public static String encrypt(String rawText) {
    byte[] content = rawText.getBytes(StandardCharsets.UTF_8);
    SecretKeySpec secretKeySpec = createSecretKey(key);
    try {
      Cipher cipher = Cipher.getInstance(CIPHER_MODE);
      cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(iv.getBytes()));
      byte[] data = cipher.doFinal(content);
      return Base64.encodeBase64URLSafeString(data);
    } catch (GeneralSecurityException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 解密指定字符串
   *
   * @param encryptText 加密后字符串
   * @return 原始字符串
   */
  public static String decrypt(String encryptText) {
    byte[] data = Base64.decodeBase64(encryptText);
    SecretKeySpec secretKeySpec = createSecretKey(key);
    try {
      Cipher cipher = Cipher.getInstance(CIPHER_MODE);
      cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv.getBytes()));
      byte[] content = cipher.doFinal(data);
      return new String(content, StandardCharsets.UTF_8);
    } catch (GeneralSecurityException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 生成密钥
   */
  private static SecretKeySpec createSecretKey(String key) {
    try {
      //构造密钥生成器
      KeyGenerator keyGen = KeyGenerator.getInstance(ENCRYPT_ALG);
      //根据传入的字节数组,生成一个256位的随机源
      SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
      random.setSeed(key.getBytes());
      keyGen.init(256, random);
      return new SecretKeySpec(keyGen.generateKey().getEncoded(), ENCRYPT_ALG);
    } catch (Exception e) {
      throw new IllegalStateException("生成随机密钥失败", e);
    }
  }

  /**
   * 加密指定字符串
   *
   * @param rawText 原始字符串
   * @param iv      初始化向量
   * @param key     私钥
   * @return 加密后字符串
   */
  public static String encrypt(String rawText, String iv, String key) {
    byte[] content = rawText.getBytes(StandardCharsets.UTF_8);
    SecretKeySpec secretKeySpec = createSecretKey(key);
    try {
      Cipher cipher = Cipher.getInstance(CIPHER_NAME);
      cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(iv.getBytes()));
      byte[] data = cipher.doFinal(content);
      return Base64.encodeBase64URLSafeString(data);
    } catch (GeneralSecurityException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 解密指定字符串
   *
   * @param encryptText 加密后字符串
   * @param iv          初始化向量
   * @param key         私钥
   * @return 原始字符串
   */
  public static String decrypt(String encryptText, String iv, String key) {
    byte[] data = Base64.decodeBase64(encryptText);
    SecretKeySpec secretKeySpec = createSecretKey(key);
    try {
      Cipher cipher = Cipher.getInstance(CIPHER_NAME);
      cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv.getBytes()));
      byte[] content = cipher.doFinal(data);
      return new String(content, StandardCharsets.UTF_8);
    } catch (GeneralSecurityException e) {
      throw new RuntimeException(e);
    }
  }
}
