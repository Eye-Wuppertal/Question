### 0001 组件之间互相传值问题

可以定义一个Bus.js 来进行传值

![image-20220506194749972](img/image-20220506194749972.png)

```js
//bus.js
import Vue from 'vue'
export default new Vue()
```

![image-20220506195005503](img/image-20220506195005503.png)

![image-20220506195021840](img/image-20220506195021840.png)

在事件中将值传到bus

```vue
将此处的值传出去
<template>
  <div>
    <el-row :gutter="3">
      <el-col :span="15">
        <div style="margin-left: 6px" class="grid-content bg-purple">
          <el-input v-model="meetingIdInput" placeholder="请输入内容"></el-input>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="grid-content bg-purple">
          <el-button @click.native.prevent="searchMeetingId">选择会议</el-button>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import axios from "axios"
import Bus from '/src/api/bus.js'
export default {
  name: "upCenter",
  data() {
    return {
      apiUrl: 'http://127.0.0.1:8000/search/meetingId',
      meetingIdInput:'',
      meetingEvalution:[]
    }
  },
  mouted:{

  },
  methods:{
    searchMeetingId(){
      console.log("clicked!")
      Bus.$emit('val', this.meetingIdInput);
      axios.get(this.apiUrl, {params: {meetingId: this.meetingIdInput}}).then((res)=>{
        this.meetingEvalution = res.data.map((item)=>{
          return item.meeting_evaluation;
        })
        console.log(this.apiUrl)
        console.log(res)
      });
    }
  }
}
</script>

<style scoped>

</style>
```

![image-20220506195208023](img/image-20220506195208023.png)

```vue
<template>
  <div>value:{{xxx}}</div>
</template>

<script>

import Bus from '/src/api/bus.js'
export default {
  name: "upRight",
  data(){
    return{
      xxx:0
    }
  },
  mounted () {
    // 用$on事件来接收参数
    Bus.$on('val', elementValue => {
      console.log(elementValue)
      this.xxx = elementValue
    })
  }
}
</script>

<style scoped>


</style>
```

### 0002 父组件通过props向子组件传值

```vue
<!--父组件-->
<DownRight v-if="isRouterAlive" :meetingId="this.meetingIdInput"/>

<!--子组件-->

<template>
  <div >
    <img style="height: 100%; width: 100%; margin-top: 5px;
    background-color: rgb(255,255,255)"  :src="`http://localhost:8000/ldaFile/WordCloud_${imgUrl}.png`">
  </div>
</template>

<script>

export default {
  name: "downRight",
  props:{
    meetingId: String
  },
  data(){
    return{
      imgUrl:'001'
    }
  },
  mounted () {


  },
  created(){
    this.imgUrl = this.meetingId;
  },
  watch:{
    inputId(val){
      this.imgUrl = val;
    }
  }

}
</script>

<style scoped>

</style>
```

### 0003 子组件向父组件传值

1. 子组件主动触发将数据传递给父组件

   1.1 在子组件上绑定触发事件this.$emit('getTreeData',this.$refs.treeData.getCheckedNodes());

   ```vue
   <template>
       <div>
           <Tree :data="treeData" show-checkbox ref="treeData"></Tree>
           <Button type="success" @click="submit"></Button>
       </div> 
   </template>
   
   <script>
   ...
   submit(){
        this.$emit('getTreeData',this.$refs.treeData.getCheckedNodes());
         },
    ...
   
   </script>
   ```

   1.2 在父组件中绑定触发事件<AuthTree/>为子组件

   ```vue
   <AuthTree  @getTreeData='testData'></AuthTree>
   
   <script>
   ...
   testData(data){
         console.log("parent");
         console.log(data)
       },
   
    ...
   
   </script>
   ```

2. 父组件调用子组件

   2.1子组件绑定def

   ```vue
   <template>
       <div>
       	<Tree :data="treeData" show-checkbox ref="treeData"></Tree>
       </div>
   </template>
   <script>
   ...
   getData(){
           return this.$refs.treeData.getCheckedNodes()
       },
    ...
   
   </script>
   ```

   2.2 父组件注册子组件后绑定ref

   ```vue
   <AuthTree ref="authTree"></AuthTree>
   <script>
   ...
   console.log( this.$refs.authTree.getData());
    ...
   
   </script>
   ```

### 0004 抛出信息

```js
this.$message.success('登录成功');
```

### 0005  在已经写完页面的情况下，加入自适应匹配方案（使用transform:scale =＞ 组件化抽离ScaleBox）

创建一个ScaleBox组件

```vue
<template>
  <div
    class="ScaleBox"
    ref="ScaleBox"
    :style="{
      width: width + 'px',
      height: height + 'px',
    }"
  >
    <slot></slot>
  </div>
</template>
 
<script>
export default {
  name: "ScaleBox",
  props: {},
  data() {
    return {
      scale: 0,
      width: 1920,
      height: 1080,
    };
  },
  mounted() {
    this.setScale();
    window.addEventListener("resize", this.debounce(this.setScale));
  },
  methods: {
    getScale() {
      // 固定好16：9的宽高比，计算出最合适的缩放比
      const { width, height } = this;
      const wh = window.innerHeight / height;
      const ww = window.innerWidth / width;
      console.log(ww < wh ? ww : wh);
      return ww < wh ? ww : wh;
    },
    setScale() {
      // 获取到缩放比例，设置它
      this.scale = this.getScale();
      if (this.$refs.ScaleBox) {
        this.$refs.ScaleBox.style.setProperty("--scale", this.scale);
      }
    },
    debounce(fn, delay) {
      const delays = delay || 500;
      let timer;
      return function () {
        const th = this;
        const args = arguments;
        if (timer) {
          clearTimeout(timer);
        }
        timer = setTimeout(function () {
          timer = null;
          fn.apply(th, args);
        }, delays);
      };
    },
  },
};
</script>
 
<style lang="scss">
#ScaleBox {
  --scale: 1;
}
.ScaleBox {
  position: absolute;
  transform: scale(var(--scale)) translate(-50%, -50%);
  display: flex;
  flex-direction: column;
  transform-origin: 0 0;
  left: 50%;
  top: 50%;
  transition: 0.3s;
  z-index: 999;
  // background: rgba(255, 0, 0, 0.3);
}
</style>
 
```

引用组件

```vue
<template>
  <scale-box style="overflow: hidden;">
    <Index v-if="isRouterAlive" @login="getLogin"/>
    <Login v-if="!isRouterAlive" @login="getLogin"/>
  </scale-box>

</template>

<script>
 import Index from "./views/index";
 import Login from "./views/login";
 import ScaleBox from "@/utils/ScaleBox";

export default {
  name:'App',
  data(){
    return{
      isRouterAlive:false
    }
  },
  components:{ScaleBox, Index,Login},
  methods:{
    getLogin(data){
      this.isRouterAlive = data;
    }
  },


}

</script>

<style lang="scss">
body {
  margin: 0;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
```

注意：

（1）使用px做单位，不使用rem

（2）ScaleBox内部页面元素最大的盒子按照1920*1080为容器 严格计算。所有宽高加起来为1920*1080

（3）最好不要使用百分比分配宽高

参考：http://t.csdn.cn/jVJ8f
