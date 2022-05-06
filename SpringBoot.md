### 0001 springboot 静态资源网站加载时，js内中文乱码问题

在properties中添加如下语句，使其强制编码，然后对应的文件使用相对应的编码格式

```properties
server.servlet.encoding.force=true
```

### 0002 springboot静态资源热部署

devtool

参考：https://blog.csdn.net/zhiyikeji/article/details/104994473?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-104994473-blog-89579952.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-104994473-blog-89579952.pc_relevant_default&utm_relevant_index=2

Jrebel

参考：https://blog.csdn.net/yang_guang3/article/details/119108698?utm_medium=distribute.pc_feed_404.none-task-blog-2~default~BlogCommendFromBaidu~Rate-3-119108698-blog-null.pc_404_mixedpudn&depth_1-utm_source=distribute.pc_feed_404.none-task-blog-2~default~BlogCommendFromBaidu~Rate-3-119108698-blog-null.pc_404_mixedpud

