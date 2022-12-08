package Assignment4.Qinxianglin;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WechatPay {
    public static void main(String[] args) {
        PayMain();
    }
    static void PayMain(){
        Scanner s = new Scanner(System.in);
        int choose;
        boolean flag = true;
        while (flag){
            System.out.println("============选择功能=============");
            System.out.println("1. 购买商品");
            System.out.println("2. 银行卡");
            System.out.println("0. 退出");
            System.out.println("请输入选项：");
            choose = s.nextInt();
            switch (choose){
                case 1:
                    chooseGoods();
                    break;
                case 2:
                    bank_card();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("没有该功能");
                    break;
            }
        }

    }
    static void bank_card(){
        getIsBind g = new getIsBind();
        System.out.println("==========银行卡========");
        System.out.printf("-------已绑定银行卡---------\n");
        if(g.IsBind("bank1")==1){
            System.out.printf("bank1\t");
        }
        if(g.IsBind("bank2")==1){
            System.out.printf("bank2\t");
        }
        System.out.println("\n--------------------------");
        System.out.println("1. 充值");
        System.out.println("2. 提现");
        System.out.println("3. 绑定");
        System.out.println("4. 解绑");
        System.out.println("0. 返回");
        System.out.println("请输入选项：");
        boolean flag = true;
        int choose;
        Scanner s = new Scanner(System.in);
        while (flag){
            choose = s.nextInt();
            switch (choose){
                case 1:
                    card_recharge();
                    flag = false;
                    break;
                case 2:
                    card_withdraw();
                    flag = false;
                    break;
                case 3:
                    card_bind();
                    flag = false;
                    break;
                case 4:
                    card_unbind();
                    flag = false;
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("没有该功能");
                    break;
            }
        }


    }
    static void card_withdraw(){
        System.out.println("=========银行卡提现========");
        System.out.println("1. bank1卡提现");
        System.out.println("2. bank2卡提现");
        System.out.println("0. 返回");
        System.out.println("请输入选项：");
        Scanner s = new Scanner(System.in);
        BankCard bb;
        int choose;
        choose = s.nextInt();
        System.out.println("请输入金额：");
        double money = s.nextDouble();
        boolean flag = true;
        bankFactory b = new bankFactory();
        while (flag){
            switch (choose){
                case 1:
                    bb = b.getBankCard("bank1");
                    bb.withdraw(money);
                    flag=false;
                    break;
                case 2:
                    bb = b.getBankCard("bank2");
                    bb.withdraw(money);
                    flag= false;
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("没有该功能");
                    break;
            }
        }
    }
    static void card_recharge(){
        System.out.println("=========银行卡充值========");
        System.out.println("1. bank1卡充值");
        System.out.println("2. bank2卡充值");
        System.out.println("0. 返回");
        System.out.println("请输入选项：");
        Scanner s = new Scanner(System.in);
        BankCard bb;
        int choose;
        choose = s.nextInt();
        System.out.println("请输入金额：");
        double money = s.nextDouble();
        boolean flag = true;
        bankFactory b = new bankFactory();
        while (flag){
            switch (choose){
                case 1:
                    bb = b.getBankCard("bank1");
                    bb.recharge(money);
                    flag=false;
                    break;
                case 2:
                    bb = b.getBankCard("bank2");
                    bb.recharge(money);
                    flag= false;
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("没有该功能");
                    break;
            }
        }
    }
    static void card_bind(){
        System.out.println("=========银行卡绑定========");
        System.out.println("1. 绑定bank1");
        System.out.println("2. 绑定bank2");
        System.out.println("0. 返回");
        System.out.println("请输入选项：");
        Scanner s = new Scanner(System.in);
        BankCard bb;
        int choose;
        boolean flag = true;
        bankFactory b = new bankFactory();
        while (flag){
            choose = s.nextInt();
            switch (choose){
                case 1:
                    bb = b.getBankCard("bank1");
                    bb.bind(1);
                    flag = false;
                    break;
                case 2:
                    bb = b.getBankCard("bank2");
                    bb.bind(1);
                    flag = false;
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("没有该功能");
                    break;
            }
        }
    }
    static void card_unbind(){
        System.out.println("=========银行卡解绑========");
        System.out.println("1. 解绑bank1");
        System.out.println("2. 解绑bank2");
        System.out.println("0. 返回");
        System.out.println("请输入选项：");
        Scanner s = new Scanner(System.in);
        BankCard bb;
        int choose;
        boolean flag = true;
        bankFactory b = new bankFactory();
        while (flag){
            choose = s.nextInt();
            switch (choose){
                case 1:
                    bb = b.getBankCard("bank1");
                    bb.bind(0);
                    flag = false;
                    break;
                case 2:
                    bb = b.getBankCard("bank2");
                    bb.bind(0);
                    flag = false;
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("没有该功能");
                    break;
            }
        }
    }
    static void chooseGoods(){
        Scanner s = new Scanner(System.in);
        int choose;
        boolean flag = true;

        while(flag){
            System.out.println("============选择商品=============");
            System.out.println("1. 商品1");
            System.out.println("2. 商品2");
            System.out.println("3. 商品3");
            System.out.println("0. 返回");
            System.out.println("请输入选项：");
            choose = s.nextInt();
            switch (choose){
                case 1, 2, 3:
                    mer Mer = chooseMers();
                    if(Mer!=null){
                        Goods goods = new Goods(Mer, "商品"+choose);
                        boolean f = choosePaytool();
                        if(f){
                            goods.performCommand();
                        }

                    }
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("没有该商品，请重新输入：");
                    choose = s.nextInt();
                    break;
            }
        }
    }
    static mer chooseMers(){
        System.out.println("============选择商家=============");
        System.out.println("1. 商家1");
        System.out.println("2. 商家2");
        System.out.println("3. 商家3");
        System.out.println("0. 返回");
        System.out.println("请输入选项：");
        Scanner s = new Scanner(System.in);
        int choose = s.nextInt();
        boolean flag = true;
        while (flag){
            switch (choose){
                case 1, 2, 3:
                    return new mer("商家"+choose);
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("没有该商家, 请重新输入：");
                    choose = s.nextInt();
                    break;
            }
        }
        return null;
    }
    static boolean choosePaytool(){
        System.out.println("==========选择支付方式======");
        System.out.println("1. 零钱");
        System.out.println("2. 银行卡");
        System.out.println("0. 返回");
        boolean flag = true;
        int choose;
        context c;
        Scanner s = new Scanner(System.in);
        while (flag){
            choose = s.nextInt();
            switch (choose){
                case 1:
                    c = new context(new change());
                    return c.pay(5);
                case 2:
                    getIsBind g = new getIsBind();
                    //默认使用bank1卡支付
                    if(g.IsBind("bank1")==1){
                        c = new context(new card("bank1"));
                        return c.pay(5);

                    }else if(g.IsBind("bank2")==1){    //bank1未绑定，则用bank2
                        c = new context(new card("bank2"));
                        return c.pay(5);
                    }else {
                        System.out.println("你没有绑定的银行卡");
                        return false;
                    }
                case 0:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}




class userInvoker{
    //购买命令列表
    private ArrayList<GoodsCommand> orders = new ArrayList<GoodsCommand>();
    //取消购买命令列表
    private ArrayList<GoodsCommand> cancelOrders = new ArrayList<GoodsCommand>();
    //向购物车添加商品
    public void addOrder(GoodsCommand order){
        orders.add(order);
        System.out.printf("增加购买商品 %s \n", order.GoodsName);
    }
    //减少购物车的商品
    public void delOrder(GoodsCommand order){
        if(orders.remove(order)){
            cancelOrders.add(order);
            System.out.printf("减少购买商品 %s\n", order.GoodsName);
        }else{
            System.out.printf("你的购物车中还没有该商品");
        }
    }
    public void performBuy(){
        for (GoodsCommand order: orders){
            order.performCommand();
        }
    }
    public void performNotBuy(){
        for (GoodsCommand order: cancelOrders){
            order.cancelCommand();
        }
    }
}


abstract class GoodsCommand {          //指令的抽象类
    public  mercnants mer;
    public String GoodsName;
    public GoodsCommand(mercnants mer, String GoodsName){
        this.mer = mer;
        this.GoodsName = GoodsName;
    }
    abstract public void performCommand();  //执行指令抽象方法
    abstract public void cancelCommand();   //取消指令抽象方法
}

class Goods extends GoodsCommand{
    public Goods(mercnants mer, String GoodsName){  //创建实体命令
        super(mer, GoodsName);
    }
    @Override
    public void performCommand(){  //重写父类方法，并通过调用商家类的方法实现执行命令
        mer.buy(GoodsName);
    }
    @Override
    public void cancelCommand(){
        mer.notBuy(GoodsName);
    }
}

abstract class mercnants{   //商家的抽象类
    public String merName;
    public mercnants(String merName){
        this.merName = merName;
    }
    abstract public void buy(String GoodsName);   //当用户执行购买时执行的方法
    abstract public void notBuy(String GoodsNmae); //当用户取消购买时执行的方法
}

class mer extends mercnants{    //实现商家类
    public mer(String merName){
        super(merName);
    }
    @Override
    public void buy(String GoodsName){
        System.out.printf("你已在 %s 购买商品 %s\n", merName, GoodsName);
    }
    @Override
    public void notBuy(String GoodsName){
        System.out.printf("你已在 %s 取消购买商品 %s\n", merName, GoodsName);
    }
}

class context {
    private paytool PayTool;
    public context(paytool tool){
        this.PayTool=tool;
    }
    public boolean pay(double cost){
        return PayTool.pay(cost) ;
    }
}



interface paytool{
    boolean pay(double cost);  //支付
    boolean checkPsw(int psw); //检查密码
    void recharge(double m); //充值
    void withdraw(double m);  //提现
}

class change implements paytool{
    private int Change_psw=123;       //密码
    private double balance=1000;      //余额
    @Override
    public boolean pay(double cost){
        if(cost>balance){
            System.out.printf("零钱余额(%.2f)不足", balance);
        }
        else{
            System.out.printf("请输入零钱密码：");
            Scanner s = new Scanner(System.in);
            int p = s.nextInt();
            if(checkPsw(p)){
                System.out.printf("成功支付%.2f元\n", cost);
                balance=balance-cost;
                return true;
            }else{
                System.out.printf("密码错误\n");
            }
        }
        return false;
    }
    @Override
    public boolean checkPsw(int p){
        if(p==Change_psw){
            return true;
        }
        return false;
    }
    @Override
    public void recharge(double m){

    }
    @Override
    public void withdraw(double m){

    }
}

class card implements paytool{
    BankCard b;
    public card(String name){
        bankFactory f = new bankFactory();
        this.b = f.getBankCard(name);
    }
    @Override
    public boolean pay(double cost) {
        return b.pay(cost);
    }

    @Override
    public boolean checkPsw(int psw) {
        return b.checkPsw(psw);
    }

    @Override
    public void recharge(double m) {
        b.recharge(m);
    }

    @Override
    public void withdraw(double m) {
        b.withdraw(m);
    }
}

interface BankCard {  //银行卡接口
    void recharge(double m);
    void withdraw(double m);
    boolean bind(int flag); //绑定方法, flag=0，解绑；=1绑定
    boolean checkPsw(int p);
    boolean pay(double cost);
}


class bank1 implements BankCard{
    boolean isBind;
    private double balance=500;
    private int psw = 234;
    public bank1(){
        getIsBind g = new getIsBind();
        if(g.IsBind("bank1")==1){
            this.isBind=true;
        }else {
            this.isBind=false;
        }
    }
    @Override
    public boolean pay(double cost){
        if(isBind){
            System.out.printf("请输入bank1银行卡密码：");
            Scanner s = new Scanner(System.in);
            int p = s.nextInt();
            if(checkPsw(p)){
                if(cost>balance){
                    System.out.printf("bank1的银行卡余额(%.2f)不足", balance);
                }else{
                    System.out.printf("成功支付%.2f元\n", cost);
                    balance=balance-cost;
                    return true;
                }
            }else{
                System.out.printf("密码错误\n");
            }
        }else {
            System.out.printf("请先绑定银行卡\n");
        }
        return false;
    }
    @Override
    public boolean checkPsw(int p){
        if(p==psw){
            return true;
        }
        return false;
    }
    @Override
    public void recharge(double m){
        if(isBind){
            System.out.printf("请输入bank1密码：");
            Scanner s = new Scanner(System.in);
            int p = s.nextInt();
            if(psw == p){
                System.out.printf("成功充值 %.2f 元\n", m);
                balance+=m;
            }else{
                System.out.printf("密码错误！\n");
            }
        }else{
            System.out.printf("请先绑定银行卡\n");
        }
    }
    @Override
    public void withdraw(double m){
        if(isBind){
            System.out.printf("请输入bank1密码：");
            Scanner s = new Scanner(System.in);
            int p = s.nextInt();
            if(psw == p){
                if(m>balance){
                    System.out.printf("余额(%.2f)不足\n", balance);
                }else{
                    System.out.printf("提现成功\n");
                    balance-=m;
                }
            }else{
                System.out.printf("密码错误！\n");
            }
        }else {
            System.out.printf("请先绑定银行卡\n");
        }
    }
    @Override
    public boolean bind(int flag){         //1:绑定；0：解绑
        if(flag==1 && isBind){
            System.out.println("该银行卡已绑定");
            return false;
        }else if(flag==0 && !isBind){
            System.out.println("该银行卡未绑定");
            return false;
        }
        Scanner s = new Scanner(System.in);
        System.out.printf("请输入银行卡密码：");
        int p = s.nextInt();
        if(psw == p){
            getIsBind g = new getIsBind();
            g.change(flag, "bank1");
            if(flag==1){
                System.out.printf("bank1绑定成功\n");
            }else {
                System.out.printf("bank1解绑成功\n");
            }
            isBind=true;
            return true;
        }else{
            System.out.printf("密码错误！\n");
            return false;
        }
    }
}

class bank2 implements BankCard{
    boolean isBind;
    private double balance=1500;
    private int psw = 345;
    public bank2(){
        getIsBind g = new getIsBind();
        if(g.IsBind("bank2")==1){
            this.isBind=true;
        }else {
            this.isBind=false;
        }
    }
    @Override
    public boolean pay(double cost){
        if(isBind){
            System.out.printf("请输入bank2银行卡密码：");
            Scanner s = new Scanner(System.in);
            int p = s.nextInt();
            if(checkPsw(p)){
                if(cost>balance){
                    System.out.printf("bank2的银行卡余额(%.2f)不足", balance);
                }else{
                    System.out.printf("成功支付%.2f元\n", cost);
                    balance=balance-cost;
                    return true;
                }
            }else{
                System.out.printf("密码错误\n");
            }
        }else{
            System.out.printf("请先绑定bank2银行卡\n");
        }
        return false;
    }
    @Override
    public boolean checkPsw(int p){
        if(p==psw){
            return true;
        }
        return false;
    }
    @Override
    public void recharge(double m){
        if(isBind){
            System.out.printf("请输入bank2密码：");
            Scanner s = new Scanner(System.in);
            int p = s.nextInt();
            if(psw == p){
                System.out.printf("成功充值 %.2f 元\n", m);
                balance+=m;
            }else{
                System.out.printf("密码错误！\n");
            }
        }else {
            System.out.printf("请先绑定银行卡\n");
        }
    }
    @Override
    public void withdraw(double m){
        if(isBind){
            System.out.printf("请输入bank2密码：");
            Scanner s = new Scanner(System.in);
            int p = s.nextInt();
            if(psw == p){
                if(m>balance){
                    System.out.printf("余额(%.2f)不足\n", balance);
                }else{
                    System.out.printf("成功提现 %.2f\n", m);
                    balance-=m;
                }
            }else{
                System.out.printf("密码错误！\n");
            }
        }else {
            System.out.printf("请先绑定银行卡\n");
        }
    }
    @Override
    public boolean bind(int flag){
        if(flag==1 && isBind){
            System.out.println("该银行卡已绑定");
            return false;
        }else if(flag==0 && !isBind){
            System.out.println("该银行卡未绑定");
            return false;
        }
        Scanner s = new Scanner(System.in);
        System.out.printf("请输入银行卡密码：");
        int p = s.nextInt();
        if(psw == p){
            getIsBind g = new getIsBind();
            g.change(flag, "bank2");
            if(flag==1){
                System.out.printf("bank2绑定成功\n");
            }else {
                System.out.printf("bank2解绑成功\n");
            }
            isBind=true;
            return true;
        }else{
            System.out.printf("密码错误！\n");
            return false;
        }
    }
}

//银行卡工厂类, 用户可通过此类对不同银行的银行卡进行绑定，选择银行卡支付等
class bankFactory{
    public BankCard getBankCard(String bankType){
        if(bankType.equalsIgnoreCase("bank1")){
            return new bank1();
        }else if(bankType.equalsIgnoreCase("bank2")){
            return new bank2();
        }
        return null;
    }
}

class getIsBind{
    public void change(int s, String bankType){
        FileWriter fw = null;
        try{
            fw = new FileWriter("./"+bankType+".txt",false);
            fw.write(s);
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int IsBind(String bankType){
        File file = null;
        FileReader reader = null;
        try {
            file = new File("./"+bankType+".txt");
            if(!file.exists()) {
                change(0, bankType);
            }
            reader = new FileReader(file);
            return reader.read();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 2;
    }
}
