import java.util.HashMap;
import java.util.Map;

public class Friend implements Contact {

    Map<Integer, String> contacts = new HashMap<Integer, String>() {{
        put(10213142, "Wang");
        put(17211142, "Feng");
        put(19210312, "Li");
        put(19123152, "Gu");
    }};

    public void add(int key) {
        FriendPool friendPool = new FriendPool();
        if (contacts.containsKey(key))
        {
            System.out.println("好友已存在");
        }
        else if(friendPool.exist(key))
        {
            contacts.put(key, friendPool.getString(key));
            System.out.println("添加成功!");
        }
        else System.out.println("查找不到该用户");
    }


    public void delete(int key) {
        if (contacts.containsKey(key))
        {
            contacts.keySet().removeIf(i -> i == key);
        }
        else
        {
            System.out.println("联系人不存在");
        }
    }

    public void show() {
        System.out.println("用户ID" + "    " + "用户昵称");
        for (Map.Entry entry : contacts.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void searchContact(int id) {
        if (contacts.containsKey(id))
        {
            for (int key : contacts.keySet())
            {
                if (key == id)
                {
                    String value = contacts.get(key);
                    System.out.println("好友昵称:" + value+" 微信号:" + key);
                }
            }
        }
        else
        {
            System.out.println("未查询到符合信息的联系人");
        }
    }

    public int searchContact(String name) {
        if (contacts.containsValue(name))
        {
            for (Map.Entry<Integer, String> entry : contacts.entrySet())
            {
                if (entry.getValue().equals(name))
                {
                    return entry.getKey();
                }
            }
        }
        return 0;
    }

    public String getValue(int key){
        return contacts.get(key);
    }
    public boolean exist(int key) {
        return contacts.containsKey(key);
    }
}
