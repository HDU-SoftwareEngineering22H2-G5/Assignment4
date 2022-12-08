package Assignment4.Songyunze.personal;

public class Information2 implements InformationPersonal {
	String fsname="";
	String fscontent="";
	public void delete() {
		fscontent="";
		System.out.println("Delete Successful");
	}
	public void edit(String content) {
		fscontent=content;
		System.out.println("Edit Successful");
	}
	public String getNews() {
		return "Information2 is here";
	}
}
