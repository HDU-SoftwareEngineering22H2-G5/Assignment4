package Assignment4.Songyunze.personal;

public class AbstractFavoritesPersonal extends AbstractPersonal{
	@Override
	public InformationPersonal getInformationPersonal(String name) {
		///
		return null;
	}
	@Override
	public FavoritesPersonal getFavoritesPersonal(String name) {
		System.out.println("This is your favorites");
		if(name.equalsIgnoreCase("Favorites1")) {
			System.out.println("Favorites1 is ok");
			return new Favorites1();
		}else if(name.equalsIgnoreCase("Favorites2")) {
			System.out.println("Favorites2 is ok");
			return new Favorites2();
		}
		else {
			System.out.println("No Favorites");
			return null;
		}

	}
}
