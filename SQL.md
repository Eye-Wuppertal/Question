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

### 0006 排序

```sql
ORDER BY m1.member_id1 			# 默认为顺序
ORDER BY m1.member_id1 DESC 	# DESC 为逆序
```

### 0007 分组排序取前TOPN

```sql
SELECT 
member_id1,member_id2,member_relatedNum
FROM `member_relationship` m1
WHERE
10>(
SELECT COUNT(*) FROM `member_relationship` m2
WHERE m2.member_id1 = m1.member_id1 
AND m1.member_relatedNum  <=  m2.member_relatedNum
)
ORDER BY m1.member_id1, m1.member_relatedNum DESC 

# 02 窗口函数 MYSQL需要使用8以上的版本
select * 
from 
(select 
    member_id1,member_id2,member_relatedNum,
    row_number() over(
        partition by member_id1					# partition by 接分组字段
        order by member_relatedNum desc) num	 # order by 接排序字段
 	from member_relationship) as mr
where num <=10	
```

详情见：https://blog.csdn.net/qq_41934680/article/details/120816081

### 0008 SQL 在有5.7的版本下，安装8

详情见：http://t.csdn.cn/yt05W

### 0009 SQL 常用关键字顺序

```sql
select
from
where
group by
order by
```

```java
{
    member_id1:'001'
    member_id2:'002'
    member_relatedNum:1
},
{
    member_id1:'001'
    member_id2:'003'
    member_relatedNum:2
},{...}...
    
    
{
    member_id1:'001',
    relatedMember:[{
        member_id2:'002'
        member_relatedNum:1
    },
    {
        member_id2:'003'
        member_relatedNum:2
    }...]
}    
    
    
    
```

```js
const map = {}
temp1.forEach((item,i)=>{
    const id1 = item.member_id1; 
    const id2 = item.member_id2;
    const relate = item.member_relatedNum; 
    if(!map[id1]){
        map[id1]={member_id1:id1}
    }
    map[id1].member_relatedNum.push({
        member_id2:id2,
        member_relatedNum:relate
    })
})
```

### 0010 时间段

```sql
select * from booking where month(booking_time) =  month(curdate()) and year(booking_time) = year(curdate())  # month

select * from spf_booking where month(booking_time) =  month(curdate()) and week(booking_time) = week(curdate())  #week

SELECT *  
 
FROM blog_article  
 
WHERE year( FROM_UNIXTIME( BlogCreateTime ) ) = year( curdate( ))# year


# 按照年统计次数
select 
	me.member_id ,
    SUM(CASE WHEN year(mb.meeting_hostTime)=year(now()) THEN 1 ELSE 0 END) AS y1,
    SUM(CASE WHEN year(mb.meeting_hostTime)=year(date_sub(now(),interval 1 year)) THEN 1 ELSE 0 END) AS y2,
    SUM(CASE WHEN year(mb.meeting_hostTime)=year(date_sub(now(),interval 2 year)) THEN 1 ELSE 0 END) AS y3,
    SUM(CASE WHEN year(mb.meeting_hostTime)=year(date_sub(now(),interval 3 year)) THEN 1 ELSE 0 END) AS y4,
    SUM(CASE WHEN year(mb.meeting_hostTime)=year(date_sub(now(),interval 4 year)) THEN 1 ELSE 0 END) AS y5
from meeting_base mb, meeting_evaluation me 
where mb.meeting_index = me.meeting_index 
group by me.member_id 
```

详见：http://t.csdn.cn/Uz0bX

### 0011 左连接left join

```sql
# 是以左表为基础，根据ON后给出的两表的条件将两表连接起来。结果会将左表所有的查询信息列出，而右表只列出ON后条件与左表满足的部分。左连接全称为左外连接，是外连接的一种。
select * from A left join b on A
```

### 0012  创建时间字段

字段 create_time  默认值可以设置为CURRENT_TIMESTAMP

update_time 默认值可以设置为CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

### 0013 MySQL5.x 自定义实现row_number() over(partition by ) 分组排序功能

```sql
select id,class,score,rank from (
	select 
		b.*,
		@rownum := @rownum+1 ,
    -- 定义用户变量@rownum来记录数据的行号。通过赋值语句@rownum := @rownum+1来累加达到递增行号。
		if(@pdept=b.class,@rank:=@rank+1,@rank:=1) as rank,
    -- 如果当前分组编号和上一次分组编号相同，则@rank（对每一组的数据进行编号）值加1，否则表示为新的分组，从1开始
		@pdept:=b.class 
    -- 定义变量@pdept用来保存上一次的分组id
	from (select * from a order by a.class,a.score desc) b ,
    -- 这里的排序不确定是否需要，保险点还是加上吧
		(select @rownum :=0 , @pdept := null ,@rank:=0) c  
    -- 初始化自定义变量值
	order by b.class,b.score desc -- 该排序必须，否则结果会不对
) result
having rank < 2;

```

### 0014 删除操作

```sql
drop #删除整张表
truncate #清空表内容
delete #删除单行数据不释放空间
```

