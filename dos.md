### 0001 查看端口号

```shell

netstat -ano

netstat -ano | findstr xxxx 
```

### 0002 切换磁盘

切换磁盘时需要单独再输一次盘符，例如：F:

### 0003 终止程序

```shell
taskkill /pid XXXX -t # PID号
taskkill /f /t /im XX.exe # 进程名
tskill pid
```

