package com.wechat.personal;

public interface InformationPersonal {
	String fsname="";
	String fscontent="";
	public void delete() ;
	public void edit(String content);
	public String getNews();
}
