# -*- coding:utf-8 -*-
import random

#i = random.randint(1, 10)
#print(i)

# 로또 번호 뽑기 (6개만) (1~45) => 중복 없이 => 출력
def lotto():
    num = random.randint(1, 45)
    lotto = {num}
    while True:
        num = random.randint(1, 45)
        lotto.add(num)
        lottolist = list(lotto)
        if (len(lottolist)==6):
            break
    print(lotto)
    
# def getNumber():
#     return random.randint(1, 45)

# num_list = []
# count = 0

# while count < 6:
#     ran_num = getNumber()
#     if ran_num not in num_list: #뽑은 숫자가 list에 안들어있다면
#         num_list.append(ran_num)
#         count += 1 

# for n in num_list:
#    print(n,end=' ')
######################################    
lotto()    