package com.wechat.personal;

public abstract class Observer {
	public FavoritesPersonal subFavorites1;
	public InformationPersonal subInformation1;
	public String name;
	
	abstract public void update();
}
