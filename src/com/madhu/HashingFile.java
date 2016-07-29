package com.madhu;

import java.io.FileInputStream;
import java.security.MessageDigest;

public class HashingFile {

    public static void main(String[] args) throws Exception {

        System.out.println(">>> IH SHA1 <<<<");
        String pwd = "123456";
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(pwd.getBytes());
        FileInputStream fis = new FileInputStream("D:/eclipse/workspace/SpringExamples/ArtRefSql.txt");

        byte[] dataBytes = new byte[8192];

        int read = 0;

        while ((read = fis.read(dataBytes)) != -1) {
            System.out.println("HashingFile.main()>>>>> while");
            md.update(dataBytes, 0, read);
        }
        fis.close();

        byte[] sha = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sha.length; i++) {
            sb.append(Integer.toString((sha[i] & 0xff) + 0x100, 16).substring(1));
        }
        System.out.println("SHA1 is ... >" + sb.toString());
    }

}
