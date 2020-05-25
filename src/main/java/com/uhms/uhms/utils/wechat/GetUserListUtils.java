package com.uhms.uhms.utils.wechat;

import com.uhms.uhms.entity.wechat.AccountEntity;
import net.sf.json.JSONObject;

import java.util.List;

public class GetUserListUtils {

//    AccessTokenUtils.
//    String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + accessToken.getAccessToken() + "&next_openid=";//获取所有用户openid
//    JSONObject jsonObject = httpRequest(url, "GET", null);
//	try
//
//    {
//        if (jsonObject.getString("errcode") != null) {
//        }
//    }catch(
//    Exception e)
//
//    {
//    }
//
//    WeixinUserList userList = (WeixinUserList) JSONObject.toBean(jsonObject, WeixinUserList.class);
//	if(null==userList)
//
//    {
//        return "无用户";
//    }
//	userList.getTotal();//关注总人数
//    //用户openId 列表
//    WxOpenidInfo wxOpenidInfo = userList.getData();
//    List<String> openIdList = null;
//	if(null!=wxOpenidInfo)
//
//    {
//        openIdList = wxOpenidInfo.getOpenid();//公众号返回的数据
//        if (null != openIdList && openIdList.size() > 0) {
//            for (String opendid : openIdList) {
//                url = "https://api.weixin.qq.com/cgi-bin/user/info?       access_token=" + accessToken.getAccessToken() + "&openid=" + opendid + "&lang=zh_CN";//通过openid获取用户信息
//                jsonObject = httpRequest(url, "GET", null);
//                WeixinUser wxUser = (WeixinUser) JSONObject.toBean(jsonObject, WeixinUser.class);
//                weixinUserService.save(wxUser);
//            }
//        }
//    }
//
//
//
//
//    public class WeixinUser {
//        private String subscribe;//	用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
//        private String openid;//	用户的标识，对当前公众号唯一
//        private String nickname;//	用户的昵称
//        private String sex;//	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
//        private String city;//	用户所在城市
//        private String country;//	用户所在国家
//        private String province;//	用户所在省份
//        private String language;//	用户的语言，简体中文为zh_CN
//        private List<String> tagid_list;//用户被打上的标签ID列表
//
//
//        public String getSubscribe() {
//            return subscribe;
//        }
//
//        public void setSubscribe(String subscribe) {
//            this.subscribe = subscribe;
//        }
//
//        public String getOpenid() {
//            return openid;
//        }
//
//        public void setOpenid(String openid) {
//            this.openid = openid;
//        }
//
//        public String getNickname() {
//            return nickname;
//        }
//
//        public void setNickname(String nickname) {
//            this.nickname = nickname;
//        }
//
//        public String getSex() {
//            return sex;
//        }
//
//        public void setSex(String sex) {
//            this.sex = sex;
//        }
//
//        public String getCity() {
//            return city;
//        }
//
//        public void setCity(String city) {
//            this.city = city;
//        }
//
//        public String getCountry() {
//            return country;
//        }
//
//        public void setCountry(String country) {
//            this.country = country;
//        }
//
//        public String getProvince() {
//            return province;
//        }
//
//        public void setProvince(String province) {
//            this.province = province;
//        }
//
//        public String getLanguage() {
//            return language;
//        }
//
//        public void setLanguage(String language) {
//            this.language = language;
//        }
//
//        public List<String> getTagid_list() {
//            return tagid_list;
//        }
//
//        public void setTagid_list(List<String> tagid_list) {
//            this.tagid_list = tagid_list;
//        }
//    }


}
