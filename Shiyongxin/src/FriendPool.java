import java.util.HashMap;
import java.util.Map;

public class FriendPool {
    Map<Integer, String> friendPool = new HashMap<Integer, String>() {{
        put(10213142, "Wang");
        put(17211142, "Feng");
        put(19210312, "Li");
        put(19123152, "Gu");
        put(19639281, "Hong");
        put(17211313, "Jin");
        put(19215123, "Fei");
        put(14125960, "Tun");
        put(10334212, "Meng");
        put(14123141, "Shi");
        put(15121341, "Xu");
        put(19678941, "Hua");
    }};
    public boolean exist(int id) {
        return friendPool.containsKey(id);
    }
    public String getString(int id) {
        if (friendPool.containsKey(id))
        {
            for (int key : friendPool.keySet())
            {
                if (key == id)
                {
                    return friendPool.get(key);
                }
            }
        }
        else
        {
            System.out.println("该群聊不存在");
        }
        return null;
    }
}
