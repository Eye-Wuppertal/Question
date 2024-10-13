### 0001 分区是什么

分区是kafka的物理划分，分区使kafka能够水平扩展，每个分区都有一个唯一标识符，分区好，每个分区在消息日志中都是一个有序的不可变的消息序列，按照写入顺序存储。

### 0002 常用命令

1.  主题相关命令

  kafka-topics.sh

| **参数**                                                 | **描述**                             |
| -------------------------------------------------------- | ------------------------------------ |
| **--bootstrap-server  <String: server toconnect to>**    | 连接的Kafka Broker主机名称和端口号。 |
| **--topic <String: topic>**                              | 操作的topic名称。                    |
| **--create**                                             | 创建主题。                           |
| **--delete**                                             | 删除主题。                           |
| **--alter**                                              | 修改主题。                           |
| **--list**                                               | 查看所有主题。                       |
| **--describe**                                           | 查看主题详细描述。                   |
| **--partitions <Integer: # of partitions>**              | 设置分区数。                         |
| **--replication-factor  <Integer: replication  factor>** | 设置分区副本。                       |
| **--config <String: name=value>**                        | 更新系统默认的配置。                 |

```shell
kafka-topics.sh --bootstrap-server master:9092 --list   # 查看所有topic
kafka-topics.sh --bootstrap-server master:9092 --create --partitions 1 --replication-factor 3 --topic first
kafka-topics.sh --bootstrap-server master:9092 --describe --topic first # 查看first详情
# 修改分区数（注意：分区数只能增加，不能减少）
kafka-topics.sh --bootstrap-server master:9092 --alter --topic first --partitions 3
kafka-topics.sh --bootstrap-server master:9092 --delete --topic first # 删除
```

2. 生产者相关命令

   kafka-console-producer.sh

| **参数**                                              | **描述**                             |
| ----------------------------------------------------- | ------------------------------------ |
| **--bootstrap-server  <String: server toconnect to>** | 连接的Kafka Broker主机名称和端口号。 |
| **--topic <String: topic>**                           | 操作的topic名称。                    |

```shell
kafka-console-producer.sh --bootstrap-server master:9092 --topic first # 发送消息
```

3. 生产者相关命令

   kafka-console-consumer.sh

| **参数**                                              | **描述**                             |
| ----------------------------------------------------- | ------------------------------------ |
| **--bootstrap-server  <String: server toconnect to>** | 连接的Kafka Broker主机名称和端口号。 |
| **--topic <String: topic>**                           | 操作的topic名称。                    |
| **--from-beginning**                                  | 从头开始消费。                       |
| **--group <String: consumer group id>**               | 指定消费者组名称。                   |

```shell
kafka-console-consumer.sh --bootstrap-server master:9092 --topic first # 消费first中的数据
# 把主题中所有的数据都读取出来（包括历史数据）
kafka-console-consumer.sh --bootstrap-server hadoop102:9092 --from-beginning --topic first
```

