package Assignment4;

import Assignment4.Manziqi.subSystemMainPrompt;
import Assignment4.Qinxianglin.WechatPay;
import Assignment4.Shiyongxin.src.Chat;
import Assignment4.Songyunze.personal.PersonalDemo;

import java.io.IOException;
import java.util.Scanner;

public class weChatSystem {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        subSystemMainPrompt SubmainPrompt = new subSystemMainPrompt();
        WechatPay PaymainPrompt = new WechatPay();
        Chat ChatmainPrompt = new Chat();
        PersonalDemo personalDemo = new PersonalDemo();
        String x = "";
        while(x != "0") {
            System.out.println();
            System.out.println("欢迎使用微信");
            System.out.println("请选择您要使用的功能:");
            System.out.println("1. 即时通讯");
            System.out.println("2. 支付");
            System.out.println("3. 朋友圈");
            System.out.println("4. 个人偏好");
            System.out.println("5. 公众号");
            System.out.println("按0退出");
            x = scan.next();
            if(x == "1") {
                ChatmainPrompt.main();
            } else if(x == "2") {
                PaymainPrompt.PayMain();
            } else if(x == "3") {
            } else if(x == "4") {
                personalDemo.main();
            } else if(x == "5") {
                SubmainPrompt.promptMain();
            } else if(x == "0") {
                break;
            } else {
                System.out.println("输入错误!");
            }
        }
        scan.close();
    }
}
