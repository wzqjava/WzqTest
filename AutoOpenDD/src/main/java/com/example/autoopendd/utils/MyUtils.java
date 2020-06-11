package com.example.autoopendd.utils;

public class MyUtils {
    private static boolean isMain = true;

    public static boolean isIsMain() {
        return isMain;
    }

    public static void setIsMain(boolean isMain) {
        MyUtils.isMain = isMain;
    }
}
