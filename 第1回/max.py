import numpy as np
import time
import sys

#配列の最大値を求める関数
def max(x):
    y=x[0]
    for i in x:
        if i>y:
            y=i
    return y

start=time.time()#時間測定開始
l=np.random.rand(int(sys.argv[1]))
print("Max: ",max(l))
fin=time.time()#時間測定終了
print("Time: ",fin-start,"s")
