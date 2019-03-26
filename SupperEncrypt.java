package cn.shadada.cloudconsumer.controller;

import sun.misc.BASE64Encoder;

/**
 * @author By:刘鑫龙
 * @date 2019-03-26
 */
public class SupperEncrypt {
    public static String encode(String string) {
        String[] keys = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"
                ,"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
                ,"0","1","2","3","4","5","6","7","8","9"};
        StringBuffer pwdBuffer = new StringBuffer();
        //声明Base64工具
        String[] strs = string.split("");
        System.out.println("---------------------->> Rock : Add Pwd:" + string);
        if (strs.length != 0){
            System.out.println("---------------------->> Rock : Start Add Pwd....");
            /**
             * 1.加密
             */
            for (int i = 0; i < strs.length; i++) {
                //a为一层加密字符串
                int a = (int) charToByteAscii(string.charAt(i));
                //b为二层加密字符串
                String b = Integer.toBinaryString(a);
                String c = String.valueOf(b.getBytes());
//                System.out.println(c);
                pwdBuffer.append(c.substring(c.length()-2));
            }
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String str2 = pwdBuffer.toString();
            System.out.println("---------------------->> " + base64Encoder.encode(str2.getBytes()));
            return base64Encoder.encode(str2.getBytes());
        }
        return null;
    }

    private static byte charToByteAscii(char ch){
        byte byteAscii = (byte)ch;
        return byteAscii;
    }
    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
}
