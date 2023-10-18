# -*- coding:utf-8 -*-

import random

# UP/DOWN 게임 (함수)
# 유저의 이름을 입력받고 환영하는 인사를 출력
# (컴퓨터) 1~100사이의 랜덤한 정수를 하나 뽑아서
# 유저한테 정답을 입력하게 했을 때 
# 위의 범위의 정수가 아니면 다시 입력하도록!
# 입력한 숫자가 정답보다 작으면 'UP', 크면 'DOWN' 출력
# 정답을 맞췄을 때는 몇 번만에 맞췄는지 출력 + 종료
# 정답기회는 총 10번

#카운터 변수 (누적,10이면 종료 조건)
def updown():
    name = input("your name: ")
    print("welcome, " + name)
    com= random.randint(1, 100)
    count = 0
    
    while count<10:
        player=int(input("guess number(1~100) :"))
        if player<1 or player>100:
            print("wrong range.choose again(1~100)")
            continue
            
        if player==com:
            print("%d times clear!" %count)
            break
        elif  player<com:
            print("UP")
            count += 1
            continue
        else  :
            print("DOWN")
            count += 1
            continue
        
########################################## 
 
updown()      