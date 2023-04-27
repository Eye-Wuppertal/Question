### 0001 映射结构化数据去表头

```hive
create table(id int ,name string)
row format delimited
fields terminated by ','
tblproperties ("skip.header.line.count"="1");
```

### 0002 从文件加载数据到表

```hive
load data local inpath '/root/a.txt' into table a;
```

### 0003 insert报错

```shell
 [08S01][1] Error while processing statement: FAILED: Execution Error, return code 1 from org.apache.hadoop.hive.ql.exec.mr.MapRedTask
```

查看hive日志发现是root根目录权限问题

![image-20230426150639291](img/image-20230426150639291.png)
