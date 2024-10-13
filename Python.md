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

### 0009 基础数学函数

```python
** #乘方  math.pow()
math.fabs() #绝对值 
math.exp() #exp/sin/cos等同

```

### 0010 统计某个list中元素的个数

```python
# 如果是list 可以使用
str(predict_test).count("1")
# 如果是array 需要使用
str(predict_test.tolist()).count("1")
```

### 0011  画图

```python
import matplotlib.pyplot as plt			# 导入模块

plt.style.use('ggplot')					# 设置图形的显示风格
fig=plt.figure(1)						# 新建一个 figure1
fig=plt.figure(figsize=(12,6.5),dpi=100,facecolor='w')
fig.patch.set_alpha(0.5)				# 设置透明度为 0.5
font1 = {'weight' : 60, 'size' : 10}	# 创建字体，设置字体粗细和大小
ax1.set_xlim(0,100)						# 设置 x 轴最大最小刻度
ax1.set_ylim(-0.1,0.1)					# 设置 y 轴最大最小刻度
plt.xlim(0,100)  						# 和上面效果一样
plt.ylim(-1,1)
ax1.set_xlabel('X name',font1)			# 设置 x 轴名字
ax1.set_ylabel('Y name',font1)			# 设置 y 轴名字
plt.xlabel('aaaaa')						# 设置 x 轴名字
plt.ylabel('aaaaa')						# 设置 y 轴名字
plt.grid(True)					 		# 增加格网
plt.grid(axis="y")						# 只显示横向格网
plt.grid(axis="x")						# 只显示纵向格网
ax=plt.gca()							# 获取当前axis,
fig=plt.gcf()							# 获取当前figures
plt.gca().set_aspect(1)					# 设置横纵坐标单位长度相等
plt.text(x,y,string)					# 在 x,y 处加入文字注释
plt.gca().set_xticklabels(labels, rotation=30, fontsize=16) # 指定在刻度上显示的内容
plt.xticks(ticks, labels, rotation=30, fontsize=15)   # 上面两句合起来
plt.legend(['Float'],ncol=1,prop=font1,frameon=False)	# 设置图例 列数、去掉边框、更改图例字体
plt.title('This is a Title')			# 图片标题
plt.show()								# 显示图片，没这行看不见图
plt.savefig(path, dpi=600)				# 保存图片，dpi可控制图片清晰度
plt.rcParams['font.sans-serif'] = ['SimHei']  	# 添加这条可以让图形显示中文
mpl.rcParams['axes.unicode_minus'] = False		# 添加这条可以让图形显示负号
ax.spines['right'].set_color('none')
ax.spines['top'].set_color('none')				#设置图片的右边框和上边框为不显示
# 子图
ax1=plt.subplot(3,1,1)
ax1.scatter(time,data[:,1],s=5,color='blue',marker='o') # size, color, 标记
ax1=plt.subplot(3,1,2)
...
# 控制图片边缘的大小
plt.subplots_adjust(left=0, bottom=0, right=1, top=1，hspace=0.1,wspace=0.1)

# 设置坐标刻度朝向，暂未成功
plt.rcParams['xtick.direction'] = 'in'
ax = plt.gca()
ax.invert_xaxis() 
ax.invert_yaxis()

```

更多参见http://t.csdn.cn/KwYrF

### 0012 pycharm 撤销忽略错误

点击设置 -> 编辑器 -> 检查，在搜索图标右边有个筛选按钮，选择“仅显示修改的检查”，就可以找出被忽略的检查。

### 0013 pandas 替换指定数据

http://t.csdn.cn/PlsmK

```python
# 一、构造dataframe
import pandas as pd
import numpy as np
df=pd.DataFrame(np.arange(16).reshape(4,4),columns=["sh","bj","sz","gz"],index=["one","two","three","four"])
df.iloc[0,1]=np.nan
# 二、替换指定数据（fillna、isin、replace)
df.replace({"bj":{5:10,9:50},"gz":{7:10}})#将"bj"列的5替换为10，9替换为50，将gz列的7替换为10

```

### 0014 if else 条件表达式

```python
<expression1> if <condition> else <expression2>
# 判断condition真假，真则返回expression1，假则返回expression2
```

### 0015 np查看数据类型

```python
data.dtypes
```

### 0016 plot坐标轴设置

```python
# 设置坐标轴为整数
plt.xlim(1, 6)
# 设置刻度值
plt.yticks(np.arange(1, 5, 0.25))
```



```python
def evolve_based_on_best(fox):
    kappa = np.random.uniform(0, 1)
    best_foxes = best_foxes_broadcast.value
    habitatCenter = [(best_foxes[0][0][i] + best_foxes[1][0][i]) / 2 for i in range(dimension_broadcast.value)]
    
    if kappa >= 0.35:
        # 随机生成新个体
        new_fox = [np.random.uniform(L_broadcast.value[i], R_broadcast.value[i]) for i in range(dimension_broadcast.value)]
    else:
        # 生成接近最佳个体中心的新个体
        new_fox = []
        for i in range(dimension_broadcast.value):
            tmp = kappa * habitatCenter[i]
            tmp = max(min(tmp, R_broadcast.value[i]), L_broadcast.value[i])
            new_fox.append(tmp)
    
    return new_fox

# 淘汰和繁衍过程
def regenerate_population(foxes_rdd):
    FromIndex = int(populationSize - 0.2 * populationSize)  # 确定淘汰个体的起始索引
    # 保留前面的个体
    retained_foxes_rdd = foxes_rdd.zipWithIndex().filter(lambda x: x[1] < FromIndex).map(lambda x: x[0])
    # 淘汰后20%的个体，并基于最佳个体生成新个体
    evolved_foxes_rdd = foxes_rdd.zipWithIndex().filter(lambda x: x[1] >= FromIndex).map(lambda x: evolve_based_on_best(x[0]))
    
    # 合并保留的个体和新生成的个体
    updated_foxes_rdd = retained_foxes_rdd.union(evolved_foxes_rdd)
    return updated_foxes_rdd

# 应用淘汰和繁衍过程
updated_foxes_rdd = regenerate_population(foxes_rdd)

# 可选：重新计算适应度，排序，并选出新的最佳个体进行下一轮迭代
foxes_with_fitness_rdd = distributed_fitness_function(updated_foxes_rdd)
foxes_with_fitness_rdd = sort_by_fitness(foxes_with_fitness_rdd)
best_foxes = updated_foxes_rdd.takeOrdered(2, key=lambda x: -x[1])  # 假设这里应用正确的适应度函数
best_foxes_broadcast = sc.broadcast(best_foxes)

```



