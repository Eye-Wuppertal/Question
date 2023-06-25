### 0001 新增入网用户判定条件

```java
STARTDATE!=''&&STARTDATE!=nil&&isNotBlank(STARTDATE)&&str(NETTYPE)=='GSM'&&(string.contains(STATUS,'US3')||STATUS=='US10')&&timeStampFormat(timeSplit(STARTDATE,"yyyy-MM-dd HH:mm:ss",1,'second'),'second','yyyyMMdd')==timeStampFormat(timeSplit(now_data(),"yyyy-MM-dd HH:mm:ss",1,'second'),'second','yyyyMMdd')&&MINI_GRID_CODE!=nil&&MINI_GRID_CODE!=""&&isNotBlank(MINI_GRID_CODE)
```

### 0002 新增宽带判定条件

```java
((str(NETTYPE)=='WBAND'||str(NETTYPE)=='MWBAND'||str(PRODID)=='pg.grp.other.rhjtkd')||(str(NETTYPE)=='FMYNET'&&(str(PRODID)=='fmynet_main_kd'||str(PRODID)=='fmynet_main_hjh')))&&(STATUS=='US10'||STATUS=='US30'||STATUS=='US28')&&timeStampFormat(timeSplit(CREATEDATE,"yyyy-MM-dd HH:mm:ss",1,'second'),'second','yyyyMMdd')==timeStampFormat(timeSplit(now_data(),"yyyy-MM-dd HH:mm:ss",1,'second'),'second','yyyyMMdd')&&MINI_GRID_CODE!=nil&&MINI_GRID_CODE!=""&&isNotBlank(MINI_GRID_CODE)
```

### 0003 实时指标分片字段

```sql
str_to_timestamp(STARTDATE,'yyyy-MM-dd HH:mm:ss')
```

### 0004 实施指标开发流程

1. 在指标库建立指标
2. 实时指标的程序开发（可能含建模和外部表的使用）
3. 在实时平台上线实时程序（在已有程序上增加更改需要走变更而不是上线），先跑几天
4. 跑了几天数据后，编写SQL分别在离线平台和实时程序输出的明细表中查询核对数据
5. 数据核对无误，发邮件确认（数据细分到地市）
6. 上线实时指标（离线平台）

