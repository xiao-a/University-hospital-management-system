package com.uhms.uhms.service.serviceimpl;


import com.google.gson.Gson;
import com.uhms.uhms.entity.wechat.*;
import com.uhms.uhms.utils.wechat.AccessTokenUtils;
import com.uhms.uhms.utils.wechat.HttpUtils;
import com.uhms.uhms.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class SendWeChatMessage {
    public static void main(String[] args) {
        //发送文本消息
        String text = getText();
        System.out.println(text);
        SendMsg(text);

//        //发送图文消息
//        String getkfnews = getkfnews(AccountEntity.OPENID);
//        System.out.println(getkfnews);
//        SendMsg(getkfnews);
    }
    /**
     *          图文消息
     * @param openid
     * @return
     */
    public static String getkfnews(String openid) {
        //先实例化图文内容
        ArticlesEntity art1 = new ArticlesEntity();
        art1.setDescription("假如没有热情世界上任何伟大的事业都不会成功那么给我们一个支点用热情去撼动无限的未来吧！");
        art1.setPicUrl("http://www.joffro.com/Activity/upload/sendImg.jpg");
        art1.setTitle("商品防伪溯源大师");
        art1.setUrl("http://www.baidu.com");

        ArticlesEntity art2 = new ArticlesEntity();
        art2.setDescription("传统习俗出门赏月、燃灯放焰、喜猜灯谜、共吃元宵、拉兔子灯等。此外，不少地方元宵节还增加了耍龙灯、耍狮子、踩高跷、划旱船、扭秧歌、打太平鼓等传统民俗表演。");
        art2.setPicUrl("http://www.joffro.com/Activity/upload/hello.jpg");
        art2.setTitle("欢度元宵");
        art2.setUrl("https://baike.baidu.com/item/%E5%85%83%E5%AE%B5%E8%8A%82/118213?fr=aladdin&fromid=19472310&fromtitle=%E5%85%83%E5%AE%B5");
        List<ArticlesEntity> list = new ArrayList<ArticlesEntity>();
        KFNewsEntity news = new KFNewsEntity();
        list.add(art1);
        list.add(art2);
        news.setArticlesEntities(list);


        WeChatNewsEntity kfbean = new WeChatNewsEntity();
        kfbean.setMsgType("news");
        kfbean.setToUser(openid);
        kfbean.setKfNewsEntity(news);
//        //对象转json 方式1
//        String jsonkfbean = JSONObject.fromObject(kfbean).toString();
//        System.out.println(jsonkfbean);
        //方式2
        Gson gson=new Gson();
        String json = gson.toJson(kfbean);
        System.out.println(json);
        return json;
    }

    /**
     * 文本消息
     */
    public static String getText(){
        TextMessageEntity tm=new TextMessageEntity();
        TextEntity t=new TextEntity();
        t.setContent("我曾经跨过山和大海，也穿过人山人海！");

        tm.setText(t);
        tm.setMsgType("text");
        tm.setToUser(AccountEntity.OPENID);

        //将对象转为json
        Gson gson=new Gson();
        String json = gson.toJson(tm);
        return json;
    }

    /**
     * 发送消息的方法
     */
    public static void SendMsg(String json){
        //发送消息的url
//        String url="https://mp.weixin.qq.com/cgi-bin/masssendpage?t=mass/send&token=1460242592&lang=zh_CN";
        String url="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
        String accessToken = AccessTokenUtils.getAccessToken(AccountEntity.APPID, AccountEntity.APPSECRET);
        url = url.replaceAll("ACCESS_TOKEN", accessToken);
        String httpsRequest = HttpUtils.httpsRequest(url, "POST", json);
        LogUtils.info("JSON"+json);
        LogUtils.info( "httpsRequest:"+httpsRequest);
    }

}


