dacp::k994zRf7I47lW4tPKmIyxg==

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
5. 数据核对无误，发邮件确认（数据细分到地市，数据为实时查询的数据）
6. 上线实时指标（离线平台）

### 0005 模型申请使用

先确认租户，资产目录- 找到表模型-申请使用

申请标题 ： ****** 表申请使用

内容：需求编号：****** ，需要使用该表

如果找不到表，可能是该表还未开放，可以去相应租户下查看模型是否存在

### 0006 根据离线指标开发实时指标

1. 在指标库搜索离线指标，点击获取测试SQL
2. 根据测试SQL截取业务逻辑，先删减与查询结果不相关的sql语句

### 0007 Oracle分区

```sql
# 查询分区
select * from user_tab_subpartitions where table_name = 'BOI_22649_DM'
# 删除分区
alter table DWD_RSVC_GM_EXT_USER_INFO_DM
 drop partition P_STAT_MONTH_202308;
# 新增分区
alter table DWD_RSVC_GM_USER_WWG_REF_DM
  add partition P_STAT_MONTH_202308 values ('202308')
  (subpartition P_STAT_DATE_20230801 values ('20230801')) 
# 新增子分区
alter table BOI_22649_DM 
modify partition P_STAT_MONTH_202307 add subpartition P_STAT_DATE_20230702 values('20230702');
  
```







