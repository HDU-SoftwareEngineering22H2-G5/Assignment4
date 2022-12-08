package Assignment4.Shiyongxin.src;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Emoji implements Message{
    Map<Integer, String> emoji = new HashMap<Integer, String>() {{
        put(1, "╮(￣▽ ￣)╭");
        put(2, "T_T");
        put(3, ":)");
        put(4, ":(");
        put(5, ":D");
        put(6, ":x");
        put(7, "@_@");
    }};
    public void show()
    {
        for (Map.Entry entry : emoji.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    @Override
    public void send(int emojiID, int sendID, int recID) {
        Friend friend = new Friend();
        String recName = friend.getValue(sendID);

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("[yyyy-MM-dd hh:mm] ");

        String mes = recName+dateFormat.format(date)+ emoji.get(emojiID);
        //System.out.println(mes);

        History history = new History();
        history.updateHistory(recID, mes);
    }
    public void send(String text, int sendID, int recID) {}
}
