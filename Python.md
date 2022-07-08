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

### 0004 pop函数和append函数

```python
# pop(元素位置)移除列表中的一个元素（默认为最后一个元素）返回值为移除的元素
# append(元素内容)将传入的对象添加到现有列表中(末尾)，无返回值，更新现有列表
# insert(插入位置，插入元素)将元素插入数组指定位置
```

### 0005 [-1]

python中[-1]代表数组中的最后一位

### 0006 reverse

reverse() 反转数组

### 0007 join用法

```python
# join 将序列里的元素用指定的字符连接生成一个新的字符串
a='I love China !'
print(' '.join(a))
print('-'.join(a))
print('*'.join(a))

#结果：
I   l o v e   C h i n a   !
I- -l-o-v-e- -C-h-i-n-a- -!
I* *l*o*v*e* *C*h*i*n*a* *!
# 可以使用 "".join 将多字符数组合并连接
```

### 0008 set()函数

```python
# set() 函数创建一个无序不重复元素集，可进行关系测试，删除重复数据，还可以计算交集、差集、并集等。

>>>x = set('runoob')
>>> y = set('google')
>>> x, y
(set(['b', 'r', 'u', 'o', 'n']), set(['e', 'o', 'g', 'l']))   # 重复的被删除
>>> x & y         # 交集
set(['o'])
>>> x | y         # 并集
set(['b', 'e', 'g', 'l', 'o', 'n', 'r', 'u'])
>>> x - y         # 差集
set(['r', 'b', 'u', 'n'])
>>>
```



