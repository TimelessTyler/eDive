package com.example.edives.frame;

public class NetConfig {
    public static String BaseUrl;
    public static int API_TYPE = 1;//1:正式服务器 2：外测服务器 3：内测服务器
    public static String BASE_URL2 = "http://28f1w59522.zicp.vip:55937/";
    //http://192.168.0.246:8000/    http://47.107.50.253:8080/DmdMall
//    http://sport-data.dqdgame.com/sd/biz/index
    static {
        if (API_TYPE == 1) BaseUrl = "http://47.107.50.253:8080/sso/";
        else if (API_TYPE == 2) BaseUrl = "http://sport-data.dqdgame.com/";
        else BaseUrl = "";
    }
}
