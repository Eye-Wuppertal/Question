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

### 0002 springboot 定时任务的三种方式

一、基于注解(@Scheduled)

 基于注解@Scheduled默认为单线程，开启多个任务时，任务的执行时机会受上一个任务执行时间的影响；

```java
// 1、创建定时器
// 使用SpringBoot基于注解来创建定时任务比较简单，只需要如下代码即可。 代码如下：
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
    //3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
// @Scheduled：除了支持灵活的参数表达式cron之外，还支持简单的延时操作，例如 fixedDelay ，fixedRate 填写相应的毫秒数即可。

// 使用@Scheduled 注解很方便，但缺点是当我们调整了执行周期的时候，需要重启应用才能生效，这多少有些不方便。为了达到实时生效的效果，可以使用接口来完成定时任务。
```

二、基于接口（SchedulingConfigurer）

```xml
<!--导入依赖包-->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>2.0.4.RELEASE</version>
</parent>

<dependencies>
    <dependency><!--添加Web依赖 -->
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency><!--添加MySql依赖 -->
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <dependency><!--添加Mybatis依赖 配置mybatis的一些初始化的东西-->
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.3.1</version>
    </dependency>
    <dependency><!-- 添加mybatis依赖 -->
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.4.5</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

```sql
DROP DATABASE IF EXISTS `socks`;
CREATE DATABASE `socks`;
USE `SOCKS`;
DROP TABLE IF EXISTS `cron`;
CREATE TABLE `cron`  (
  `cron_id` varchar(30) NOT NULL PRIMARY KEY,
  `cron` varchar(30) NOT NULL  
);
INSERT INTO `cron` VALUES ('1', '0/5 * * * * ?');
```

```java
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class DynamicScheduleTask implements SchedulingConfigurer {
 
    @Mapper
    public interface CronMapper {
        @Select("select cron from cron limit 1")
        public String getCron();
    }
 
    @Autowired      //注入mapper
    @SuppressWarnings("all")
    CronMapper cronMapper;
 
    /**
     * 执行定时任务.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
 
        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronMapper.getCron();
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
```

三、多线程定时任务

```java
//@Component注解用于对那些比较中立的类进行注释；
//相对与在持久层、业务层和控制层分别采用 @Repository、@Service 和 @Controller 对分层中的类进行注释
@Component
@EnableScheduling   // 1.开启定时任务
@EnableAsync        // 2.开启多线程
public class MultithreadScheduleTask {
 
        @Async
        @Scheduled(fixedDelay = 1000)  //间隔1秒
        public void first() throws InterruptedException {
            System.out.println("第一个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
            System.out.println();
            Thread.sleep(1000 * 10);
        }
 
        @Async
        @Scheduled(fixedDelay = 2000)
        public void second() {
            System.out.println("第二个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
            System.out.println();
        }
    }
```

