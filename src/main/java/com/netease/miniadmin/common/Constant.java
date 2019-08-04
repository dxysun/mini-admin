package com.netease.miniadmin.common;

public class Constant {
    public static class DynamicDistribute {
        public static final int DYNAMICTOPNUM = 5;
        public static final String DEFAULTNICKNAME = "未知小可爱";

        public static final int DYNAMICSECTIONNUM = 5;
        public static final int DYNAMICNUMPOINT1 = 5;
        public static final int DYNAMICNUMPOINT2 = 10;
        public static final int DYNAMICNUMPOINT3 = 20;
        public static final int DYNAMICNUMPOINT4 = 30;

        public static final String DYNAMICSECTION1 = "发表日记0到5条";
        public static final String DYNAMICSECTION2 = "发表日记6到10条";
        public static final String DYNAMICSECTION3 = "发表日记11到20条";
        public static final String DYNAMICSECTION4 = "发表日记20到30条";
        public static final String DYNAMICSECTION5 = "发表日记大于30条";

        public static String getDynamicSection(int i){
            switch(i){
                case 0: return DYNAMICSECTION1;
                case 1: return DYNAMICSECTION2;
                case 2: return DYNAMICSECTION3;
                case 3: return DYNAMICSECTION4;
                case 4: return DYNAMICSECTION5;
            }
            return "not found";
        }
    }
}
