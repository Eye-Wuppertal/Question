### 0001  字符串中引入变量

```python
a = "123"
print("a是{}".format(a))
```

详细见  http://t.csdn.cn/llMsi

### 0002 取整

```python
math.ceil() # 向上取整
math.floor() # 向下取整
round() # 四舍五入取整
int()   # 去尾取整
9//2   # 4  j
```

### 0003 将数据写入文本

```python
# String类型的内容进行写入
# 定义文件对象
f = open(文件名，模式)

# 文件对象操作
# 读取
content = f.read(N)          # 读取N bytes的数据
content = f.readline()       # 读取一行
content = f.readlines()      # 读取所有行，储存在列表中，每个元素是一行。
# 写入
f.write('I like apple')      # 将'I like apple'写入文件
f.close()

# 对数组类型的内容进行写入
# 将整个数据写入到文件中，就是先完成数组的创建和数据的存储，之后将整个数组写入的文件中。
# 保存：表示将dets数组保存到指定路径下的txt文件中，格式是浮点型，以逗号为分割符
dets = np.array([[1,2],[3,4]])
np.savetxt("路径", dets,fmt='%f',delimiter=',')
 
# 读取：表示从指定txt文件下读取，并以逗号为分割符
dets= np.loadtxt('dets.txt',delimiter=',')

```

