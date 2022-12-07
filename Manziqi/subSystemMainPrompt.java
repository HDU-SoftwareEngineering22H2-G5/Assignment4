package HDU_SE.Manziqi;

import java.util.*;

public class subSystemMainPrompt {
    private User user = new User();
    private Agency agency = new Agency();
    private Scanner scan = new Scanner(System.in);
    private int nextInt() {
        boolean flag = false;
        int x = 0;
        try {
            x = scan.nextInt();
        } catch (InputMismatchException e) {
            flag = true;
        }
        if(flag) return -1;
        else return x;
    }
    private int userInput() {
        int x = -1;
        do {
            x = this.nextInt();
            if(x == -1) System.out.println("输入错误！");
        }while(x == -1);
        return x;
    }
    public void promptMain() {
        int x = -1;
        while(x != 0) {
            System.out.println("欢迎使用公众号系统!");
            System.out.println("请选择你的身份：");
            System.out.println("1. 运营机构");
            System.out.println("2. 用户");
            System.out.println("按0退出");
            x = this.userInput();
            if(x == 1) {this.promptAgency();}
            else if(x == 2) {this.promptUser();}
            else if(x == 0) {break;}
        }
        System.out.println("感谢使用公众号系统，再见。");
        return ;
    }
    private void promptUser() {
        int x = -1;
        while(x != 0) {
            System.out.println("您现在是：用户");
            System.out.println("请选择您要执行的操作");
            System.out.println("1. 订阅公众号");
            System.out.println("2. 退订公众号");
            System.out.println("3. 列出已订阅公众号");
            System.out.println("按0返回");
            x = nextInt();
            if(x == 1) {
                System.out.println("请输入公众号ID:");
                x = nextInt();
                if(x == -1) break;
                this.user.addSubscriptionAccount(x);
            } else if(x == 2) {
                System.out.println("请输入公众号ID:");
                x = nextInt();
                if(x == -1) break;
                this.user.deleteSubscriptionAccount(x);
            } else if(x == 3) {
                this.user.listSubscriptionAccount();
            } else if(x == 0) {break;}
        }
        System.out.println("已退出:用户");
        return ;
    }
    private void promptAgency() {
        int x = -1; 
        String name = "";
        while(x != 0) {
            System.out.println("您现在是：运营机构");
            System.out.println("请选择您要执行的操作");
            System.out.println("1. 创建公众号");
            System.out.println("2. 停用公众号");
            System.out.println("3. 列出全部公众号");
            System.out.println("4. 创建推文");
            System.out.println("5. 删除推文");
            System.out.println("按0返回");
            x = nextInt();
            if(x == 1) {
                System.out.println("请输入公众号ID：");
                x = nextInt();
                if(x == -1) break;
                System.out.println("请输入公众号名称：");
                name = scan.next();
                this.agency.createSubscriptionAccount(x, name);
            } else if(x == 2) {
                System.out.println("请输入公众号ID：");
                x = nextInt();
                if(x == -1) break;
                this.agency.stopSubscriptionAccount(x);
            } else if(x == 3) {
                this.agency.listSubscriptionAccount();
            } else if(x == 4) {
                System.out.println("请输入公众号ID：");
                x = nextInt();
                if(x == -1) break;
                System.out.println("请输入公众号名称：");
                name = scan.next();
                this.agency.createArticle(x, name);
            } else if(x == 5) {
                System.out.println("请输入公众号ID：");
                x = nextInt();
                if(x == -1) break;
                System.out.println("请输入公众号名称：");
                name = scan.next();
                this.agency.deleteArticle(x, name);
            } else if(x == 0) {
                break;
            }
        }
        System.out.println("已退出:运营机构");
        return ;
    }
}
class subscriptionOperator {
    private static class subscriptionOperatorHolder {
        private static subscriptionOperator instance = new subscriptionOperator();
    }
    private subscriptionOperator() {}
    public static subscriptionOperator getInstance() {
        return subscriptionOperatorHolder.instance;
    }
    public boolean hasSubAccount(int accountId) {
        return true;
    }
    public boolean hasArticle(int accountId, String artName) {
        return true;
    }
    public boolean addUserToAccount(int accountId) {
        return true;
    }
    public boolean deleteUserFromAccount(int accountId) {
        return true;
    }
    public boolean createAccountFromAgency(int accountId, String accName) {
        return true;
    }
    public boolean stopAccountFromAgency(int accountId) {
        return true;
    }
    public boolean createArticleToAccount(int accountId, String artName) {
        return true;
    }
    public boolean deleteArticleFromAccount(int accountId, String artName) {
        return true;
    }
    public void listAccountInfo(int accountId) {
        
    }
    public void listAllAccount() {

    }
    
}
class User {
    private Vector<Integer> subscriptionList ;
    private boolean hasSubAccount(int x) {
        return subscriptionOperator.getInstance().hasSubAccount(x);
    }
    public boolean addSubscriptionAccount(int x) {
        boolean result = false;
        Integer i = new Integer(x);
        if(this.hasSubAccount(x) && !subscriptionList.contains(i)) {
            subscriptionList.add(i);
            Collections.sort(subscriptionList);
            subscriptionOperator.getInstance().addUserToAccount(x);
            result = true;
            System.out.println("订阅成功！");
        } else {
            System.out.println("订阅失败！");
            result = false;
        }
        return result;
    }
    public boolean deleteSubscriptionAccount(int x) {
        boolean result = false;
        Integer i = new Integer(x);
        if(subscriptionList.contains(i)) {
            subscriptionList.remove(i);
            subscriptionOperator.getInstance().deleteUserFromAccount(x);
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
            result = false;
        }
        return result;
    }
    public boolean listSubscriptionAccount() {
        boolean result = false;
        if(!subscriptionList.isEmpty()) {
            Iterator<Integer> iterator = subscriptionList.iterator();
            while(iterator.hasNext()) {
                System.out.println("公众号" + iterator.next() + ".");
            }
            result = true;
        } else {
            System.out.println("列表为空！");
            result = false;
        }
        return result;
    }
}
interface Observer {
    boolean listen(int x);
    boolean remindAll();
    boolean remind(int x);
}
class Agency {
    private boolean hasSubAccount(int x) {
        return subscriptionOperator.getInstance().hasSubAccount(x);
    }
    private boolean hasArticle(int x, String artName) {
        return subscriptionOperator.getInstance().hasArticle(x, artName);
    }
    public boolean createSubscriptionAccount(int x, String accName) {
        boolean result = false;
        if(!this.hasSubAccount(x)) {
            subscriptionOperator.getInstance().createAccountFromAgency(x, accName);
            result = true;
        } else {
            System.out.println("创建失败！公众号ID重复。");
            result = false;
        }
        return result;
    }
    public boolean stopSubscriptionAccount(int x) {
        boolean result = false;
        if(this.hasSubAccount(x)) {
            subscriptionOperator.getInstance().stopAccountFromAgency(x);
            result = true;
        } else {
            System.out.println("停用失败！无此公众号ID。");
            result = false;
        }
        return result;
    }
    public void listSubscriptionAccount() {
        subscriptionOperator.getInstance().listAllAccount();
    }
    public boolean createArticle(int x, String artName) {
        boolean result = false;
        if(this.hasSubAccount(x)) {
            subscriptionOperator.getInstance().createArticleToAccount(x, artName);
            result = true;
        } else {
            System.out.println("创建失败！无此公众号ID。");
            result = false;
        }
        return result;
    }
    public boolean deleteArticle(int x, String artName) {
        boolean result = true;
        if(this.hasSubAccount(x) && this.hasArticle(x, artName)) {
            subscriptionOperator.getInstance().deleteArticleFromAccount(x, artName);
            result = true;
        } else {
            System.out.println("删除失败！无此公众号ID或无此推文。");
            result = false;
        }
        return result;
    }
}