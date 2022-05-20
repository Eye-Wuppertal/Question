### 0001 js导致的中文编码乱码问题

utf-8格式需要如此添加<script charset="UTF-8"><script/>，gbk则不需要

### 0002 js中<text>字体颜色设置

标签中字体的颜色用fill来设置

### 0003 js中的扩展运算符[...]

```scala
// 1、在解构赋值中使用
let [a,b]=[1,2]
console.log(a,b) // a=1 b=2

let [c,d]=[1,2,3,4]
console.log(c,d) // 按需解构c=1 d=2

let [e,...f]=[1,2,3,4,5,6]
console.log(e,f) //e=1 f=[ 2, 3, 4, 5, 6 ]
    
// 2、用作剩余形参,就不必使用函数内置的argument伪数组  
function getMax(...item: number[]) : number{
  let max=item[0]
  for(let i=1;i<item.length;i++){
    if(max<item[i]){
      max=item[i]
    }
  }
  return max
}
console.log(getMax(2,3,4,78,23,56)) //78

// 3、将数组/string/对象在语法层面上展开
let number = [5,6,7,8,9]
console.log(...number) //5 6 7 8 9

let str = 'Hello World'
console.log(...str)  //H e l l o   W o r l d

let wc= {
  name:'晴天',
  age: 18
}
console.log({...wc}) //{ name: '晴天', age: 18 }

```

### 0004 js中的数据结构转换实例

```js
const temp1 = [{
      member_id1:'001',
      member_id2:'002',
      member_relatedNum: 5
    },
      {
        member_id1:'001',
        member_id2:'003',
        member_relatedNum: 3
      },
      {
        member_id1:'001',
        member_id2:'004',
        member_relatedNum: 2
      },
      {
        member_id1:'002',
        member_id2:'004',
        member_relatedNum: 2
      },
      {
        member_id1:'003',
        member_id2:'004',
        member_relatedNum: 2
      }]

    console.log(temp1)
    const map = {}


    /*temp1.forEach((item)=>{
      const id1 = item.member_id1;
      const id2 = item.member_id2;
      const relate = item.member_relatedNum;
      if(!map[id1]){
        map[id1]={member_id1:id1}
      }
      map[id1].member_relatedNum.push({
        member_id2:id2,
        member_relatedNum:relate
      })
    })*/

    temp1.forEach((item)=>{
      const id1 = item.member_id1;
      const id2 = item.member_id2;
      const relate = item.member_relatedNum;
      if(!map[id1]){
        map[id1]={member_id1:id1}
        map[id1].relatedMember = []
      }
      map[id1].relatedMember.push({
        member_id2:id2,
        member_relatedNum:relate
      })
    })
    console.log(map)
```

![image-20220519231545910](img/image-20220519231545910.png)

出现push undefined可能是因为没有初始化数组，导致缺少push属性，初始化=[ ]即可

### 0005 indexOf() 方法

```js
var str="Hello world, welcome to the universe.";
var n=str.indexOf("welcome");
// 输出：13
// indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置，
/如果没有找到匹配的字符串则返回 -1。
```

### 0006 promise、resolve，reject

new Promise()返回一个promise对象，该对象共有三种状态：进行中、已完成和失败，回调函数的调用是根据对象的状态来完成的；该对象的原型上拥有then和catch等方法。

resolve方法的作用是把promise对象的状态从进行中变成已完成，同时可以向resolve方法传入参数，这个参数会在将来被promise对象的then方法获取，而reject方法也是同样的道理，只不过是把promise对象状态变成失败，同时传入的参数会被catch方法获取而已。

resolve和reject方法的作用只不过是根据代码逻辑，把promise对象的状态置为已完成或失败，同时通知promise方法的then方法或catch方法：我们已经修改promise对象的状态，接下来需要你们（then和catch）根据对象的状态决定走哪条路

### 0007 字符串转数字

```js
// 1. 转换函数
parseInt()   
parseFloat()
parseInt("1234blue"); //returns 1234
parseInt("0xA"); //returns 10
parseInt("22.5"); //returns 22
parseInt("blue"); //returns NaN

// 2. 强制类型转换
Boolean(value) // 把给定的值转换成Boolean型；
Number(value)  // 把给定的值转换成数字（可以是整数或浮点数）；
String(value)  // 把给定的值转换成字符串。

```

### 0008 JS数组有值，但是长度为0

js数组下标使用字符串时，不会被检索到，所以长度为0，

可以使用遍历的方式得到长度length
