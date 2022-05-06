### 0001 List映射实例

```java
List<String> meetingEvaluations = this.findEvaluationById(meetingId).stream().map(meetingEvaluation -> {
    return meetingEvaluation.getMeeting_eva(); }).collect(Collectors.toList());
```