package Assignment4.Shiyongxin.src;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Text implements Message{
    int sendID;
    int recID;

    @Override
    public void send(String text, int sendID, int recID) {
        Friend friend = new Friend();
        String recName = friend.getValue(sendID);

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("[yyyy-MM-dd hh:mm] ");

        String mes = recName+dateFormat.format(date)+text;
//        System.out.println(mes);

        History history = new History();
        history.updateHistory(recID, mes);

    }
    public void send(int emoji, int sendID, int recID) {

    }
}
