package com.wechat.personal;

public class WechatUser extends Observer{
	public WechatUser(String name, FavoritesPersonal v1, InformationPersonal p1) {
		this.name=name;
		this.subInformation1=p1;
		//this.subInformation2=p2;
		this.subFavorites1=v1;
		//this.subFavorites2=v2;
	}
	@Override
	public void update() {
		System.out.printf("%s 已获得个人偏好Information1的信息:%s%n",name,subInformation1.getNews());
		//System.out.printf("%s 已获得个人偏好Information2的信息:%s%n",name,subInformation2.getNews());
		System.out.printf("%s 已获得个人偏好Favorites1的信息:%s%n",name,subFavorites1.getNews());
		//System.out.printf("%s 已获得个人偏好Favorites2的信息:%s%n",name,subFavorites2.getNews());
	}
}
