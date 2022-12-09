package Assignment4.Songyunze.personal;

public class PersonalDemo {
 public void main(){  
	   AbstractPersonal a=PersonalProducer.getPersonal("FavoritesPersonal");
	   FavoritesPersonal b=a.getFavoritesPersonal("Favorites1");
	   AbstractPersonal d=PersonalProducer.getPersonal("InformationPersonal");
	   InformationPersonal c=d.getInformationPersonal("Information1");
	   //b.publish("dasdas");
	   Observer user1=new WechatUser("Bob",b,c);
	   user1.update();
    }  
}
