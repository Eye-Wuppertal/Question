### 0001 设置代理

```shell
# 1.首先查看下目前配置:npm config list 查看是否已经配置了
# 2.设置网络代理的命令如下：
npm config set proxy http://server:port
npm config set https-proxy http://server:port
# 3.如果需要认证的话可以这样设置：
npm config set proxy http://username:password@server:port
npm confit set https-proxy http://username:password@server:port

```

### 0002 更换镜像源

```shell
# 设置淘宝源：
npm config set registry https://registry.npm.taobao.org
# 查看现有源 
npm config get registry
```

