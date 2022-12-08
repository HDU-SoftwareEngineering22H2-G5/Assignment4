package Assignment4.Shiyongxin.src;

import java.util.Scanner;

public class GWindows {
    static int MAX_NUM = 5;
    static int sendID = 17211142;
    int[] arr = new int[]{20221142, 27261142, 29123152, 0, 0};

    public void show() {
        Group group = new Group();
        for(int i = 0; arr[i] != 0 && i < 5; i++)
        {
            if(arr[i]!=0)
            {
                System.out.println((i+1)+":"+group.getValue(arr[i]));
            }
        }
    };
    public int getID(int flag) {
        return this.arr[flag-1];
    }
    public void createWindows() {
        System.out.println("请输入进入聊天的群聊号");

        Scanner in = new Scanner(System.in);
        int id = in.nextInt();

        Group group = new Group();
        GroupPool groupPool = new GroupPool();
        if (!groupPool.exist(id))
        {
            System.out.println("该群聊不存在");
            in.close();
            return;
        }
        else if (!group.exist(id))
        {
            System.out.println("未加入该群聊");
            in.close();
            return;
        }

        for(int i = 4; i > 0; i--)
        {
            arr[i-1] = arr[i];
        }
        arr[0] = id;
        this.openWindows(sendID, id);
        in.close();
    };
    public void openWindows(int sendID, int recID) {
        Group group = new Group();
        History history = new History();
        System.out.println("进入与 "+group.getValue(recID)+" 的聊天");
        while (true)
        {
            System.out.println("===============聊天框===============");
            history.showChat(recID);
            System.out.println("===================================");
            System.out.println("--------请输入命令-------");
            System.out.println("1:发送文本");
            System.out.println("2:发送表情");
            System.out.println("3:查看群聊记录");
            System.out.println("0:退出群聊会话");
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
                    System.out.println(group.getValue(recID)+" 的群聊记录");
                    history.showHistory(recID);
                    System.out.println(".......................");
                    in.nextLine();
                    in.nextLine();
                    break;
                default:
                    break;
            }
            if(result == 0 ) {
                System.out.println("退出群聊会话成功");
                in.close();
                return;
            }
            in.close();
        }

    };
}
