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

