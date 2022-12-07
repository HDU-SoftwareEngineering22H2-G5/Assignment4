package com.wechat.personal;

public class PersonalProducer {
	public static AbstractPersonal getPersonal(String name) {
		if(name.equalsIgnoreCase("FavoritesPersonal")) {
			System.out.println("Produce FavoritesPersonal");
			return new AbstractFavoritesPersonal();
		}
		else if(name.equalsIgnoreCase("InformationPersonal")) {
			System.out.println("Produce InformationPersonal");
			return new AbstractInformationPersonal();
			//return null;
		}
		else {
			System.out.println("No Item");
			return null;
		}
	}
}
