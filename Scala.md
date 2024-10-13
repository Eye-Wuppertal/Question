### 0001 _的使用

在Scala中下划线`_`常表示一种简写或通配符，比如

```scala
lines.flatMap(_.split(" "))
// 此处的_指flatMap中的每一个对象，即lines的每一行
```

