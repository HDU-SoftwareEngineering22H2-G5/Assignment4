import argparse

def cli():
    parser = argparse.ArgumentParser(description='CLI描述')
    subparsers = parser.add_subparsers(metavar='子命令')
    
    # 添加子命令，演示没有参数
    one_parser = subparsers.add_parser('one', help='第一个命令')
    one_parser.set_defaults(handle=handle_one)
    
    # 解析命令
    args = parser.parse_args()
    # 1.第一个命令会解析成handle，使用args.handle()就能够调用
    if hasattr(args, 'handle'):
        args.handle(args)
    # 2.如果没有handle属性，则表示未输入子命令，则打印帮助信息
    else:
        parser.print_help()
        
def handle_one(args):
    print('handle_one')
    
if __name__ == '__main__':
    cli()