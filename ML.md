### 0001 F1求解出错

python编译报错 

```shell
Target is multiclass but average='binary'. Please choose another average setting
```

```python
# 加上参数average='micro'
tt = metrics.roc_auc_score(val_y, predict_test, average='micro')
pp = metrics.recall_score(val_y, predict_test, average='micro')
```



