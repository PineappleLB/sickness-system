package com.sickness.util;

import java.util.Random;
import java.util.UUID;

/**
 * 随机数类
 *
 * @author pineapple
 * @create 2019/3/5
 */
public class RandomUtil {

    private static final int[] bounds = new int[] {9,99,999,9999,99999,999999,9999999,99999999,999999999};

    public static String getRandom(int num) {
        if(num<1||num>bounds.length) {
            return "0";
        }
        Random random = new Random();
        int st =  random.nextInt(bounds[num-1]);
        String res = paddingNum(st+"",num);
        return res;
    }

    public static String  paddingNum(String num,int bounds) {
        int len = num.length();
        for(int i = 0;i<(bounds-len);i++) {
            num = num+"0";
        }
        return num;
    }

    public static String randomUUID() {
        return UUID.randomUUID().toString().toUpperCase();
    }

}
