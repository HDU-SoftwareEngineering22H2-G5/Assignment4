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
    
class NormaContent(ContentFactory):
    """
    一般内容
    """
    def __init__(self):
        print('this is a normal user')
        
    
class MediaContent(ContentFactory):
    """
    含附件内容
    """
    def __init__(self):
        print('this is a super user')
        
        
class ContentList():
    def make_content():
        pass
    
    
if __name__ == '__main__':
    List = UserList()
    List.make_user('SuperUser', 'modas', '123456')
    List.make_user('SuperUser', 'modas', '123456')
    acc = List.login('modas', '123456')


