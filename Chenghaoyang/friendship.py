from abc import ABCMeta, abstractmethod


class UserFactory(metaclass=ABCMeta):
    """
    建立抽象用户工厂
    """
    @abstractmethod
    def __init__(self):
        pass


class NormalUser(UserFactory):
    """
    普通用户类
    """

    def __init__(self, name, passwd):
        self.name = name
        self.passwd = passwd
        self.permission = 0


class SuperUser(UserFactory):
    """
    管理员类
    """

    def __init__(self, name, passwd):
        self.name = name
        self.passwd = passwd
        self.permission = 1


class UserList():
    """
    用户类
    """

    def __init__(self):
        """
        建立用户名单
        """
        self.account_list = []

    def make_user(self, cls, name, passwd):
        """建立新账号

        Args:
            cls (SuperUser/NormalUser): 用户组, 普通用户或管理员
            name (str): 用户名称
            passwd (str): 密码
        """
        for account in self.account_list:   # 账号唯一性检查
            if account.name is name:
                print('This account is already existed.\n')
                return

        self.account_list.append(eval(cls)(name, passwd))
        print('Successfully sign up.\n')

    def list(self):
        """列出所有账户

        Returns:
            list: 所有账户列表
        """
        return self.account_list

    def login(self, name, passwd):
        """登录

        Args:
            name (str): 账户名称
            passwd (str): 密码

        Returns:
            用户类: 返回当前登录的账户
        """
        for account in self.account_list:
            if name is account.name and passwd is account.passwd:
                print('Successfully sign in!\nYour name is {}.\nYou are a {}.\n'.format(account.name,
                      'Superuser' if account.permission == 1 else 'Normaluser'))
                return account

        print('There is no such account.\n')


class ContentFactory(metaclass=ABCMeta):
    """
    建立抽象内容工厂
    """
    @abstractmethod
    def __init__(self):
        pass


class NormalContent(ContentFactory):
    """
    一般内容
    """

    def __init__(self, user, text, annex):
        """生成普通内容

        Args:
            user (用户类): 发表内容的用户
            text (string): 内容文本
        """
        self.user = user
        self.text = text
        self.annex = 'null'


class MediaContent(ContentFactory):
    """
    含附件内容
    """

    def __init__(self, user, text, annex):
        """生成含附件内容

        Args:
            user (用户类): 发表内容的用户
            text (string): 内容文本
            annex (string): 模拟附件内容
        """
        self.user = user
        self.text = text
        self.annex = annex


class ContentList():
    def __init__(self):
        """建立内容列表
        """
        self.content_list = []

    def make_content(self, user, cls, text, annex):
        pass

    def list(self):
        i = 0
        for content in self.content_list:
            print(i, 'user: {}\ncontent: {}\nannex: {}\n'.format(
                content.user, content.text, content.annex))

    def publish(self, account):
        text = input('Please input content\n>> ')
        annex = input('Please input annex\n>> ')
        cls = 'MediaContent'
        self.content_list.append(eval(cls)(account, text, annex))
        print("Successfully Published\n")


class observer():
    """建立观察者以通知用户朋友圈列表的改变
    """

    def __init__(self):
        self.actions = []

    @classmethod
    def attach(cls, action):
        cls.actions.append(action)

    @classmethod
    def notify(cls):
        for action in cls.actions:
            action()


class prompt():
    def __init__(self):
        self.UserList = UserList()
        print('Welcome! please sign in or sign up\n')
        # 开始注册和登录
        c = input('Input 1 to sign up or input 2 to log in\n>> ')
        while c != '1' and c != '2':
            c = input('Wrong input, please try again.\n>> ')

        if c == '1':
            print('Sign up now.\n')
            cls = input('Please input your permission\n>> ')
            name = input('Please input your name\n>> ')
            passwd = input('Please input your password\n>> ')
            self.UserList.make_user(cls, name, passwd)  # 此处未作成功性检查
            self.account = self.UserList.login(name, passwd)
        elif c == '2':
            print('Log in now.\n')
            name = input('Please input your name\n>> ')
            passwd = input('Please input your password\n>> ')
            self.account = self.UserList.login(name, passwd)

        # 以下开始正式交互
        print('Input "show" to show content list, \nInput "publish" to publish a content\nInput "like + no." to like a content\nInput "exit" to exit\n')
        self.ContentList = ContentList()
        while 1:
            command = input('>> ')
            if command == 'exit':
                print('Bye!\n')
                return

            if command == 'show':
                self.ContentList.list()
            elif command == 'publish':
                self.ContentList.publish(self.account)
            elif command == 'like':
                pass


if __name__ == '__main__':
    prompt()
