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



