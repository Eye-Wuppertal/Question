### 0001 更新某一个字段的数据

```sql
update 表名 set 字段名 = 更新内容s （将该字段的所有内容更新为相同的s）

update 表名 set 字段名 = 更新内容 where 限定条件 （在限定位置更新字段内容）
```

### 0002 将查询结果作为搜寻条件

```sql
SELECT
SUM(CASE WHEN meeting_hotelNum BETWEEN 0 AND 3 THEN 1 ELSE 0 END) AS '2017' FROM meeting_base WHERE meeting_base.organizer_id IN (SELECT organizer_id FROM meeting_organizer WHERE organizer_name="***")

SELECT
SUM(CASE WHEN meeting_hotelNum BETWEEN 0 AND 3 THEN 1 ELSE 0 END) AS '2017' FROM meeting_base WHERE meeting_base.organizer_id = (SELECT organizer_id FROM meeting_organizer WHERE organizer_name="***")

```

### 0003 去重查询

```sql
select distinct * from table

select c_name,c_year,c_month from table group by c_name,c_year,c_month
```

详情见：https://blog.csdn.net/wang1qqqq/article/details/115241993?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522165251372616780366533395%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=165251372616780366533395&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-115241993-null-null.142^v9^control,157^v4^new_style&utm_term=mysql%E6%9F%A5%E8%AF%A2%E5%8E%BB%E9%87%8D&spm=1018.2226.3001.4187

### 0004 查询结果生成新表

```sql
CREATE TABLE school SELECT * FROM class

CREATE TABLE school SELECT * FROME CLASS1,CLASS2 WHERE CLASS1.NAME=CLASS2.NAME

```

### 0005 插入条件判断

```sql
# 使用 INSERT INTO IF EXISTS
INSERT INTO a (order_id, operator, oper_date, memo) 
SELECT '3', 'onion3', '2017-11-28', '测试3'  
from DUAL  
where not exists(select order_id from a where operator='onion3' and memo = '测试3'); 

# 不存在插入，存在更新
INSERT INTO tb_addrbook(num,name,mobile) VALUE('1001','小李','13112345678') ON DUPLICATE KEY UPDATE name= '小李',mobile='13112345678'

# REPLACE INTO 以主键判别
REPLACE INTO 表名称(列1, 列2, 列3) VALUES(值1, 值2, 值3)
```







