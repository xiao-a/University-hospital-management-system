package com.uhms.uhms.utils;

import com.zhenzi.sms.ZhenziSmsClient;
import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.Map;

public class SMSUtils {
    public static void sendMessage(String phoneNumber,String message) {
     /**
     * apiUrl为请求地址
                *  个人开发者使用https://sms_developer.zhenzikj.com
     *  企业开发者使用https://sms.zhenzikj.com
     */
        ZhenziSmsClient client=new ZhenziSmsClient("https://sms_developer.zhenzikj.com","104766","eff3c25d-2b26-43ea-a538-f870942e127a");

        /**
         *  参数名称    必选  类型      描述
         *  message	    是	string	短信内容
         *  number	    是	string	接收者手机号码
         *  messageId	否	string	messageId即该条短信的唯一标识, 不能重复
         *  clientIp	否	string	客户端IP，需要与应用设置中的”客户IP限额“配合使用，主要防止用户恶意刷短信
         */
        Map<String, Object> params = new HashMap<String, Object>();
        boolean isMobileNumber = PhoneUtils.isMobileNumber(phoneNumber);
        LogUtils.info("isMobileNumber:"+isMobileNumber);
        params.put("number", phoneNumber);
        params.put("message", message);
        LogUtils.info("number:"+phoneNumber+";message:"+message);
        String balance = null;
        try {
            //查看余额，查看当前剩余短信条数
            balance = client.balance();
            LogUtils.info("balance:"+balance);
            //发送短信
            String result = client.send(params);
            LogUtils.info("result"+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
