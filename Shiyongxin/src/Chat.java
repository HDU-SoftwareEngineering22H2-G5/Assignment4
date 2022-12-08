package Assignment4.Shiyongxin.src;

import java.io.IOException;
import java.util.Scanner;

public class Chat {
    int sendID = 17211142;
    Friend friend  = new Friend();
    Group group = new Group();
    FWindows friendWindows = new FWindows();
    GWindows gWindows = new GWindows();
    public void main() throws IOException {
        System.out.println("<即时通讯模块>");
        while(true)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("--------请输入命令-------");
            System.out.println("1:联系人");
            System.out.println("2:好友聊天");
            System.out.println("3:进入群聊");
            System.out.println("0:退出程序");
            System.out.println("-----------------------");
            int result = in.nextInt();
            switch(result) {
                case 1:
                    contact();
                    break;
                case 2:
                    friend();
                    break;
                case 3:
                    group();
                    break;
                default:
                    break;
            }
            if(result == 0 ) {
                System.out.println("退出程序成功");
                break;
            }
        }




//        String name = "Wang";
//        Friend friend= new Friend();
//        friend.show();
//        friend.searchContact(name);
//        friend.searchContact(10213142);
//        friend.add(19123152,"Li");
//        friend.delete(17211142);
//        friend.show();

//        Text text = new Text();
//        text.send("Feng", 17211142, 19210312);
//
//        Emoji emoji = new Emoji();
//        emoji.send(1, 17211142, 19210312);
//
//        History history = new History();
//        history.showHistory(19210312);
    }
    public void group() {
        System.out.println("群聊列表");
        gWindows.show();
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.println("--------请输入命令-------");
            System.out.println("1:进入聊天");
            System.out.println("2:创建聊天");
            System.out.println("0:退出会话列表");
            System.out.println("-----------------------");
            int result = in.nextInt();
            switch (result)
            {
                case 1:
                    System.out.println("请输入要进入的群聊");
                    int flag = in.nextInt();
                    gWindows.openWindows(sendID, gWindows.getID(flag));
                    break;
                case 2:
                    gWindows.createWindows();
                    break;
                default:
                    break;
            }
            if(result == 0 ) {
                System.out.println("退出群聊列表成功");
                break;
            }
        }
    }
    public void friend() {
        System.out.println("会话列表");

        friendWindows.show();
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.println("--------请输入命令-------");
            System.out.println("1:进入聊天");
            System.out.println("2:创建聊天");
            System.out.println("0:退出会话列表");
            System.out.println("-----------------------");
            int result = in.nextInt();
            switch (result)
            {
                case 1:
                    System.out.println("请输入要进入的聊天");
                    int flag = in.nextInt();
                    friendWindows.openWindows(sendID, friendWindows.getID(flag));
                    break;
                case 2:
                    friendWindows.createWindows();
                    break;
                default:
                    break;
            }
            if(result == 0 ) {
                System.out.println("退出会话列表成功");
                break;
            }
        }
    }
    public void contact(){
        Scanner in = new Scanner(System.in);
        while(true)
        {
            System.out.println("--------请输入命令-------");
            System.out.println("1:查看好友");
            System.out.println("2:查看群聊");
            System.out.println("3:添加好友或群聊");
            System.out.println("4:联系人查询");
            System.out.println("0:退出联系人");
            System.out.println("-----------------------");
            int result = in.nextInt();
            switch(result) {
                case 1:

                    friend.show();
                    in.nextLine();
                    in.nextLine();
                    break;
                case 2:
                    group.show();
                    in.nextLine();
                    in.nextLine();
                    break;
                case 3:
                    System.out.println("请输入添加的ID");
                    int addID = in.nextInt();
                    if(addID >=20000000 && addID < 30000000)
                    {
                        group.add(addID);
                        in.nextLine();
                        in.nextLine();
                    }
                    else if(addID>=10000000)
                    {

                        friend.add(addID);
                        in.nextLine();
                        in.nextLine();
                    }
                    break;
                case 4:
                    in.nextLine();
                    System.out.println("请输入要查询的信息");
                    String str = in.nextLine();
                    if (str.matches("[0-9]+"))
                    {
                        int id = Integer.parseInt(str);
                        if(id >=20000000 && id < 30000000)
                        {
                            group.searchContact(id);
                        }
                        else if(id>=10000000)
                        {

                            friend.searchContact(id);
                        }
                        else
                        {
                            System.out.println("未查询到符合信息的联系人");
                        }
                    }
                    else
                    {

                        if(group.searchContact(str)!=0)
                        {
                            System.out.println("群聊名称:"+str+" 群聊号码:"+group.searchContact(str));
                        }
                        else if(friend.searchContact(str)!=0)
                        {
                            System.out.println("好友昵称:"+str+" 微信号:"+friend.searchContact(str));
                        }
                        else
                        {
                            System.out.println("未查询到符合信息的联系人");
                        }
                    }
                    in.nextLine();
                    break;
                default:
                    break;
            }
            if(result == 0 ) {
                System.out.println("退出联系人");
                break;
            }
        }
    }
}