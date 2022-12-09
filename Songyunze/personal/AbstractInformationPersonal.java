package Assignment4.Songyunze.personal;

public class AbstractInformationPersonal extends AbstractPersonal{
	@Override
	public InformationPersonal getInformationPersonal(String name) {
		System.out.println("This is your information");
		if(name.equalsIgnoreCase("Information1")) {
			System.out.println("Information1 is ok");
			return new Information1();
		}else if(name.equalsIgnoreCase("Information2")) {
			System.out.println("Information2 is ok");
			return new Information2();
		}
		else {
			System.out.println("No Information");
			return null;
		}
	}
	
	@Override
	public FavoritesPersonal getFavoritesPersonal(String name) {
		//
		return null;
	}
}
