package com.uhms.uhms.utils.wechat;

import com.google.gson.Gson;
import com.uhms.uhms.entity.wechat.AccessTokenEntity;

/**
 *这里是获取微信的accessToke
 */
public class AccessTokenUtils {

    public static String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static String getAccessToken(String APPID,String APPSECRET){
        url=url.replaceAll("APPID", APPID).replaceAll("APPSECRET", APPSECRET);
        String json = HttpUtils.httpsRequest(url,"GET",null);
        Gson gson=new Gson();
        AccessTokenEntity accessToken = gson.fromJson(json, AccessTokenEntity.class);
        String access_token = accessToken.getAccess_token();
        return access_token;
    }

//    public static void main(String[] args) {
//        String accessToken = getAccessToken(AccountEntity.APPID, AccountEntity.APPSECRET);
//        System.out.println(accessToken);
//    }

}