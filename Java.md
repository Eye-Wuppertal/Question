### 0001 List映射实例

```java
List<String> meetingEvaluations = this.findEvaluationById(meetingId).stream().map(meetingEvaluation -> {
    return meetingEvaluation.getMeeting_eva(); }).collect(Collectors.toList());
```

### 0002 判断文件是否存在

```java
File file = new File("d:\\hello.txt");
if (!file.exists()) {
    try {
        file.createNewFile();
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println("文件已创建");
} else {
    System.out.println("文件已存在");
}
```

### 0003 字符串中包含变量

```java
String.format("./pyUse/emotion.py %s", meetingId)
```

### 0004 字符串正则是否匹配

```java
String passwd = "rqbkjhrjqh1111@!45";
String regex = "^[A-Za-z]|[0-9]|[!@#$%^&*]{6,18}$";
if(!passwd .matches(regex)){
    return false; //验证不通过
}
```

### 0005  字符串首尾去空格

```java
str.trim()
```

### 0006 字符串转时间

```java
// long型字符串转yyyy-MM-dd HH:mm:ss格式
public static String longStrFormate(String time) {    
    Date date=new Date(Long.parseLong(time));
    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    time=formatter.format(date);
    return time;
}
// String 转 Date
public static Date str2Date(String time) throws Exception{
    Date date=null;
    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    date=formatter.parse(time);
    return date;
}

// 需要定义一个Date对象
// 定义一个简单时间格式SimpleDateFormat，时间类型是制造方法参数
// 使用格式对象将String的内容按照格式标准化之后得到的时间传给Date
```

### 0007 时间比较

```java
// 1
date1.compareTo(date2);
//如果两个日期相等，则返回值为0。
//如果date1在date2参数之后，则返回值大于0。
//如果date1在date2参数之前，则返回值小于0。


// 2
Date.before()，Date.after()和Date.equals()
if (date1.after(date2)) {
	System.out.println("Date1 时间在 Date2 之后");
}

if (date1.before(date2)) {
	System.out.println("Date1 时间在 Date2 之前");
}

if (date1.equals(date2)) {
	System.out.println("Date1 时间与 Date2 相等");
}


```



