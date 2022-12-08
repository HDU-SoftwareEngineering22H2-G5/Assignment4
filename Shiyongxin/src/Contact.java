import java.util.HashMap;
import java.util.Map;

public interface Contact {

    public void add(int key);
    public void delete(int key);
    public void show();
    public void searchContact(int id);
    public int searchContact(String name);
}
