package com.test;

import com.userinfo.UserinfoManage;
import com.userinfo.WeixinUserInfo;
import com.util.AccessToken;
import com.util.CommonUtil;

public class testUserinfo {

	public static void main(String args[]) {
        // 获取接口访问凭证
		AccessToken accessToken = CommonUtil.getToken("wx8a0415d501621f00", "3195ae749f13a1ca4cca261a083e4fb5");
        /**
         * 获取用户信息
         */
        WeixinUserInfo user = UserinfoManage.getUserInfo("BpEeTDZ_TcHSVCIqMtY6fDtmnkqSmTmgJfIVhY50VNlSdiUkldcKyI_UzJ_GLNPb7HjZuOE04kw98igpAmMPQhiYILwORd-0sf2ADj_VtETcVKv-81liihZLDskyWFeKWCPcAFAEKX", "obCpIv1q05A_-_FDB0coo1ljaw0s");
        System.out.println(accessToken.getToken());
        System.out.println("OpenID：" + user.getOpenId());
        System.out.println("关注状态：" + user.getSubscribe());
        System.out.println("关注时间：" + user.getSubscribeTime());
        System.out.println("昵称：" + user.getNickname());
        System.out.println("性别：" + user.getSex());
        System.out.println("国家：" + user.getCountry());
        System.out.println("省份：" + user.getProvince());
        System.out.println("城市：" + user.getCity());
        System.out.println("语言：" + user.getLanguage());
        System.out.println("头像：" + user.getHeadImgUrl());
    }

}
