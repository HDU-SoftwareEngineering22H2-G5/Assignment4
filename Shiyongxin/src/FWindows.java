import java.util.Scanner;

public class FWindows implements Windows{
    static int MAX_NUM = 5;
    static int sendID = 17211142;
    int[] arr = new int[]{10213142, 19123152, 19210312, 0, 0};

    public void show() {
        Friend friend = new Friend();
        for(int i = 0; arr[i] != 0 && i < 5; i++)
        {
            if(arr[i]!=0)
            {
                System.out.println((i+1)+":"+friend.getValue(arr[i]));
            }
        }
    };
    public int getID(int flag) {
        return this.arr[flag-1];
    }
    public void createWindows() {
        System.out.println("请输入要创建会话的微信号");

        Scanner in = new Scanner(System.in);
        int id = in.nextInt();

        Friend friend = new Friend();
        FriendPool friendPool = new FriendPool();
        if (!friendPool.exist(id))
        {
            System.out.println("该用户不存在");
            return;
        }
        else if (!friend.exist(id))
        {
            System.out.println("与该用户不是好友关系");
            return;
        }

        for(int i = 4; i > 0; i--)
        {
            arr[i-1] = arr[i];
        }
        arr[0] = id;
        this.openWindows(sendID, id);
    };
    public void openWindows(int sendID, int recID) {
        Friend friend = new Friend();
        History history = new History();
        System.out.println("进入与 "+friend.getValue(recID)+" 的聊天");
        while (true)
        {
            System.out.println("===============聊天框===============");
            history.showChat(recID);
            System.out.println("===================================");
            System.out.println("---------------");
            System.out.println("--------请输入命令-------");
            System.out.println("1:发送文本");
            System.out.println("2:发送表情");
            System.out.println("3:查看聊天记录");
            System.out.println("0:退出会话");
            System.out.println("-----------------------");

            Scanner in = new Scanner(System.in);
            int result = in.nextInt();
            switch (result)
            {
                case 1:
                    System.out.println("请输入要发送的文本:");
                    String str = in.next();
                    Text text = new Text();
                    text.send(str, sendID, recID);
                    break;
                case 2:
                    Emoji emoji = new Emoji();
                    System.out.println("请输入要发送的表情:");
                    emoji.show();
                    int emojiID = in.nextInt();
                    emoji.send(emojiID, sendID, recID);

                    break;
                case 3:
                    System.out.println(".......................");
                    System.out.println("与 "+friend.getValue(recID)+" 的聊天记录");
                    history.showHistory(recID);
                    System.out.println(".......................");
                    in.nextLine();
                    in.nextLine();
                    break;
                default:
                    break;
            }
            if(result == 0 ) {
                System.out.println("退出会话成功");
                return;
            }
        }

    };
}
