### 0001 git 撤销commit（未push）

撤销commit一般用git reset ，语法如下：

```shell
git reset [ --mixed | --soft | --hard] [<commit ID>]
1.使用参数 --mixed(默认参数)，如git reset --mixed <commit ID>或git reset <commit ID>
撤销git commit，撤销git add，保留编辑器改动代码

2.使用参数 --soft，如git reset --soft<commit ID>
撤销git commit，不撤销git add，保留编辑器改动代码

3.使用参数 --hard，如git reset --hard <commit ID>——此方式非常暴力，全部撤销，慎用
撤销git commit，撤销git add，删除编辑器改动代码
```

