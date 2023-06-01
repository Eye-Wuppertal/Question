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

