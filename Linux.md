### 0001 查看后台程序

```shell
jps
```

### 0002 常见操作

```shell
ls	list	# 查看当前文件夹下的内容
pwd	print work directory	# 查看当前所在文件夹
cd[目录名]	changge directory	# 切换文件夹
touch[文件名]	touch	# 如果文件不存在，新建文件
mkdir[目录名]	make directory	# 创建目录
rm[文件名]	remove	# 删除指定文件
clear	clear	# 清屏
find [路径] -name “*.py”	# 查找指定路径下扩展名是 .py 的文件，包括子目录
ln -s 被链接的源文件 链接文件	# 建立文件的软链接，用通俗的方式讲类似于 Windows 下的快捷方式
# 没有 -s 选项建立的是一个 硬链接文件两个文件占用相同大小的硬盘空间，工作中几乎不会建立文件的硬链接
# 源文件要使用绝对路径，不能使用相对路径，这样可以方便移动链接文件后，仍然能够正常使用
# 查看网卡配置信息
$ ifconfig
# 查看网卡对应的 IP 地址
$ ifconfig | grep inet
# 检测到目标主机是否连接正常
$ ping IP地址
# 检测本地网卡工作正常
$ ping 127.0.0.1
scp -P port 01.py user@remote:Desktop/01.py
# 把远程 家目录下的 Desktop/01.py 文件 复制到 本地当前目录下的 01.py

```

- `ctrl + shift + =` **放大**终端窗口的字体显示
- `ctrl + -` **缩小**终端窗口的字体显示

自动补全
在敲出 文件 ／ 目录 ／ 命令 的前几个字母之后，按下 tab 键

- 如果输入的没有歧义，系统会自动补全
- 如果还存在其他 文件 ／ 目录 ／ 命令 ，再按一下 tab 键，系统会提示可能存在的命令

小技巧

- 按 上 ／ 下 光标键可以在曾经使用过的命令之间来回切换
- 如果想要退出选择，并且不想执行当前选中的命令，可以按 ctrl + c

### 0003 文件编辑模式

按ESC退出INSERT模式，然后CTRL+Z退出 

:q 退出         :wq 保存并退出

shift+zz 也可以保存并退出

### 0004 zxvf和xvf

```shell
tar -zxvf 用于解压  .tar.gz 后缀结尾的
tar -xvf 用于解压   .tar后缀结尾的
```

### 0005 cp 和scp

cp用于终端上的文件拷贝，scp用于跨终端的文件拷贝

```shell
scp -r spark-defaults.conf root@slave1:$PWD
```



### 0006 rpm(RedHat Package Manager)

常用命令：

**1、查询**
rpm -q …
附加查询命令：
a 查询所有已经安装的包
以下附加命令用于查询安装包的信息；
i 显示安装包的信息；
l 显示安装包中的所有文件被安装到哪些目录下；
s 显示安装版中的所有文件状态及被安装到哪些目录下；
以下附加命令用于指定需要查询的是安装包还是已安装后的文件；
p 查询的是安装包的信息；
f 查询的是已安装的某文件信息；
举例如下：
rpm -qa | grep tomcat4 查看 tomcat4 是否被安装；
rpm -qip example.rpm 查看 example.rpm 安装包的信息；
rpm -qif /bin/df 查看/bin/df 文件所在安装包的信息；
rpm -qlf /bin/df 查看/bin/df 文件所在安装包中的各个文件分别被安装到哪个目录下；
**2、RPM 安装操作**
命令：
rpm -i 需要安装的包文件名
举例如下：
rpm -i example.rpm 安装 example.rpm 包；
rpm -iv example.rpm 安装 example.rpm 包并在安装过程中显示正在安装的文件信息；
rpm -ivh example.rpm 安装 example.rpm 包并在安装过程中显示正在安装的文件信息及安装进度；
**3、RPM 卸载操作**
命令：
rpm -e 需要卸载的安装包
在卸载之前，通常需要使用rpm -q …命令查出需要卸载的安装包名称。
举例如下：
rpm -e tomcat4 卸载 tomcat4 软件包
rpm -evh example 卸载example软件包并在卸载过程中显示卸载的文件信息及卸载进度；
**4、RPM 升级操作**
命令：
rpm -U 需要升级的包
举例如下：
rpm -Uvh example.rpm 升级example.rpm软件包并在升级过程中显示升级的文件信息及升级进度；
**5、RPM 验证操作**
验证软件包是通过比较已安装的文件和软件包中的原始文件信息来进行的。验证主要是比较文件的尺寸， MD5 校验码，文件权限， 类型， 属主和用户组等。
如果有错误信息输出， 您应当认真加以考虑，是通过删除还是重新安装来解决出现的问题。
命令：
rpm -V 需要验证的包
举例如下：
rpm -Vf /etc/tomcat4/tomcat4.conf
输出信息类似如下：
S.5....T c /etc/tomcat4/tomcat4.conf
其中，S 表示文件大小修改过，T 表示文件日期修改过。
**RPM 的其他附加命令**
--force 强制操作 如强制安装删除等；
--requires 显示该包的依赖关系；
--nodeps 忽略依赖关系并继续操作；

### 0007 RPM和YUM的区别

最直观的区别是rpm只能安装本地的安装包，而yum可以线上下载

具体区别可以参考：[Linux软件安装，RPM与YUM - LaplaceDemon - 博客园 (cnblogs.com)](https://www.cnblogs.com/shijiaqi1066/p/3843955.html)

### 0008 连接不上网络 ping不通

打开网络配置文件，检查配置（BOOTPROTO和ONBOOT等），添加DNS解析

```shell
DNS1="8.8.8.8"
DNS2="8.8.4.4"

# 重启网络
service network restart 
```

### 0009 文件内容显示行号

```shell
# 在文件编辑页面esc后输入
:set nu
```

### 0010 虚拟机网卡只有lo，不能联网

```shell
1. 确保 vi /etc/sysconfig/network-scripts/ifcfg-ens33 
ip地址和mac地址正确，克隆的一定要住HWADDR需要修改
2. systemctl stop NetworkManager
systemctl disable NetworkManager
systemctl start network.service
# 网卡启动/重启失败，流程同上
```

### 0011 查看端口占用情况

```shell
 netstat -ntulp | grep 10000 
```

