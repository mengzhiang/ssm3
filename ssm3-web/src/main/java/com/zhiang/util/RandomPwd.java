package com.zhiang.util;

public class RandomPwd {
    public static void main(String[] args) {
        getRandomPwd();
    }

    public static String getRandomPwd(){
        String randomPwd = "";
        for (int j = 0; j < 6; j++) {
            double rand = Math.random();
            double randTri = Math.random() * 3;
            if (randTri >= 0 && randTri < 1) {
                randomPwd = randomPwd + (char) (rand * ('9' - '0') + '0');
            } else if (randTri >= 1 && randTri < 2) {
                randomPwd = randomPwd + (char) (rand * ('Z' - 'A') + 'A');
            } else {
                randomPwd = randomPwd + (char) (rand * ('z' - 'a') + 'a');
            }
        }
        return randomPwd;
    }
}

