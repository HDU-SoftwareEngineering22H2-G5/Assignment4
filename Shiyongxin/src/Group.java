import java.util.HashMap;
import java.util.Map;

public class Group implements Contact{
    Map<Integer, String> contacts = new HashMap<Integer, String>() {{
        put(20221142, "招生群");
        put(27261142, "交流群");
        put(29232312, "学生群");
        put(29123152, "家校群");
    }};
    public void add(int key) {
        GroupPool groupPool = new GroupPool();
        if (contacts.containsKey(key))
        {
            System.out.println("已加入该群聊");
        }
        else if(groupPool.exist(key))
        {
            contacts.put(key, groupPool.getString(key));
            System.out.println("添加成功!");
        }
        else System.out.println("查找不到该群聊");
    }

    public void delete(int key) {
        if (contacts.containsKey(key))
        {
            contacts.keySet().removeIf(i -> i == key);
        }
        else
        {
            System.out.println("群聊不存在");
        }
    }

    public void show() {
        System.out.println("群聊ID" + "    " + "群聊名称");
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
                    System.out.println("群聊名称:" + value + " 群聊号码:" + key);
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
