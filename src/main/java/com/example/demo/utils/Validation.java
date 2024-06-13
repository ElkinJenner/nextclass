package com.example.demo.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Validation {
    public static String md5(String data) throws IOException, NoSuchAlgorithmException, CloneNotSupportedException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        MessageDigest msg = (MessageDigest) md.clone();
        msg.update(data.getBytes());
        return byteArrayToHex(msg.digest());
    }

    /*
     * Link:
     * https://stackoverflow.com/questions/9655181/java-convert-a-byte-array-to-a-
     * hex-string
     * Nota: Metodo altetnativo para JDK17, pero se debe tener cuidado con tener
     * este entorno activado
     * HexFormat hex = HexFormat.of();
     * hex.formatHex(someByteArray)
     */
    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }
}
