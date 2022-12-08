import java.util.HashMap;
import java.util.Map;

public class GroupPool {
    Map<Integer, String> groupPool = new HashMap<Integer, String>() {{
        put(20221142, "招生群");
        put(27261142, "交流群");
        put(29232312, "学生群");
        put(29123552, "家校群");
        put(20221642, "公司群");
        put(25261742, "聊天群");
        put(24232812, "大群");
        put(23123952, "小群");
        put(22261542, "管理群");
        put(21252212, "学校群");
        put(21123252, "教师群");
    }};
    public boolean exist(int id) {
        return groupPool.containsKey(id);
    }
    public String getString(int id) {
        if (groupPool.containsKey(id))
        {
            for (int key : groupPool.keySet())
            {
                if (key == id)
                {
                    return groupPool.get(key);
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
