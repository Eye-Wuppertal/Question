### 0001 git 撤销commit（未push）

撤销commit一般用git reset ，语法如下：

```shell
git reset [ --mixed | --soft | --hard] [<commit ID>]
1.使用参数 --mixed(默认参数)，如git reset --mixed <commit ID>或git reset <commit ID>
撤销git commit，撤销git add，保留编辑器改动代码

2.使用参数 --soft，如git reset --soft<commit ID>
撤销git commit，不撤销git add，保留编辑器改动代码

3.使用参数 --hard，如git reset --hard <commit ID>——此方式非常暴力，全部撤销，慎用
撤销git commit，撤销git add，删除编辑器改动代码
```

### 0002 [GitHub Desktop报错 Authentication failed. Some common reasons include ](https://www.cnblogs.com/youzi-xuchongyou/p/15093336.html)

使用git-desktop时遇到该问题，一般来说是ssh密钥的问题，可以尝试先重新生成密钥，然后远程重新添加本地ssh。

但是我检查ssh文件是有的，且github远程也添加了本地ssh

```shell
ssh -T git@github.com
ssh -T -p 443 git@ssh.github.com
```

测试发现

第一条命令显示 Git报错：git@github.com: Permission denied (publickey)，要求输入密码，即使密码是对的也是denied

第二条命令显示

Hi username! You've successfully authenticated, but GitHub does not provide shell access.

那么说明可以通过 HTTPS 443端口建立的 SSH 连接，接下来编辑`~/.ssh/config`文件（`C:\Users\Admin\.ssh\config`），若没有该文件，可以输入如下指令新建一个：

```shell
touch ~/.ssh/config 

# 内容为
Host github.com
    Port 443
    HostName ssh.github.com
    User git
    IdentityFile ~/.ssh/id_rsa
```

再测试

```shell
ssh -T git@github.com
```

提示

Hi username! You've successfully authenticated, but GitHub does not provide shell access.

此时问题已得到解决
