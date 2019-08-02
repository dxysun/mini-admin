package com.netease.miniadmin.common.util;

import java.util.HashMap;

/**
 * 公用数据类
 */
public class Constant {
   /* public static WordVectorModel wordVectorModel;
    public static DocVectorModel docVectorModel;
*/
//    public static String SESSION_KEY = "A0vZuPMhIeIiWLErZaCr4g==";

    public static HashMap<Integer,String> degreeMap = new HashMap<>();
    static {
        degreeMap.put(0,"有学问");
        degreeMap.put(1,"专科");
        degreeMap.put(2,"本科");
        degreeMap.put(3,"研究生");
        degreeMap.put(4,"博士");
    }
    public static final String MODEL_FILE_NAME = "data/sgns.weibo.word";
    public class ResultCode{
        public static final int SUCCESS_CODE = 200;    // 调用成功
        public static final int ERROR_CODE = 500;      // 调用失败
        public static final int SESSION_CODE = 401;      // 调用失败
    }

    public class ResultInfo{
        public static final String SUCCESS_INFO = "success";    // 调用成功信息
        public static final String ERROR_INFO = "failed";      // 调用失败信息
        public static final String SESSION_ERROR_INFO = "sessionid error";      // 调用失败信息
    }
    public static final String APPID = "wx0360dea9e9f61add";
    public static final String APPSECRET = "d043be68e4318047b35683f609da3995";
    public static final String JSCODE = "";
    public static final String WX_OPENID_URL ="https://api.weixin.qq.com/sns/jscode2session?appid="+
                    APPID+"&secret="+APPSECRET+"&grant_type=authorization_code&js_code="+JSCODE;

    public class SpecialCode{
        public static final String HEIGH = "身高";
        public static final String WEIGHT = "体重";
        public static final String SAMEHOMETOWN = "同家乡";
        public static final String DEGREE = "学历";
        public static final String CONSTELLATION = "星座";
        public static final String SAMECITY = "同所在地";
        public static final String AGE = "年龄";
    }

    public class MatchingCoefficient{
        public static final double MToF = 0.3;
        public static final double FToM = 0.7;
    }

    public class GenderCode{
        public static final int MALE = 1;
        public static final int FEMAL = 0;
    }
    public class NeteaseYun{
        public static final String ACCESS_KEY = "d8792c08101842e4b737b6f924fc19a5";
        public static final String SECRET_KEY = "73c480324a3a45b7b708c08fec1de9b6";
        public static final String ENDPOINT = "nos-eastchina1.126.net";
        public static final String YUN_URL = "https://mini10.nos-eastchina1.126.net/";
    }


    public static final Integer SESSION_EXPIRED_TIME = 86400;

    public static final String USERKEY="AllUSERS";

    //默认的模板用户id
    public static final String DEFAULTOPENID = "DEFAULTTEMPLATEOPENID";
    //默认的模板群组id
    public static final String DEFAULTGROUPID ="DEFAULTGROUPID";

    public static final Integer MATCHTHREHOLD=0;

}
