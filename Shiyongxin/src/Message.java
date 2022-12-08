package Assignment4.Shiyongxin.src;

public interface Message {
    public void send(String text, int sendID, int recID);
    public void send(int emoji, int sendID, int recID);
}
