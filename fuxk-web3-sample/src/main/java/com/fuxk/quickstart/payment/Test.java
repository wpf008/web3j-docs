package com.fuxk.quickstart.payment;

/**
 * @Author : wangpengfei@hashkeytech.com
 * @create 2022/7/25 18:17
 */
public class Test {

    public static void main(String[] args) {
        String s ="1111";
        try {
             s = Bech32.addressDecodeHex("0x1111");
        }catch (Exception e){
        }
        System.out.println(s);

    }
}
