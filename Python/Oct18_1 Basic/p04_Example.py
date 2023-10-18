# -*- coding:utf-8 -*-
from random import randint

# Java (null) = Python(None)

# 가위바위보 => 한번 질때까지 => 총 몇번 이겼는지 출력

handTable = [None,"가위","바위","보"]

def printRule():
    print("-------------")
    for i, h in enumerate(handTable):
        if i !=0:
            print("[%d] %s" %(i,h))
    print("-------------")
    
def comFire():
    return randint(1,3) 

def userFire():
    print("=-=-=-=-=-=-=-=-=-=-=-=-=-")
    uh = int(input("뭐 낼 까 ? :"))
    print("=-=-=-=-=-=-=-=-=-=-=-=-=-")
    if 1<= uh <= 3:
        return uh
    else:
        print("잘 못 입 력 했 음 !")
        return userFire()

def printHand(uhuh,chch):
    print("유저 : %s" %handTable[uhuh])
    print("컴퓨터 : %s"  %handTable[chch])
    
def judge(uhuh,chch):
    t = uhuh - chch
    if t == 0:
        print("무승부")
        return 0    
    elif t == -1 or t ==2:
        print("패배")
        return 999
    else:
        print("승리")
        return 1
    
def playGame():
    printRule()
    win = 0 
    while True:
        uHand = userFire()
        cHand = comFire()
        printHand(uHand,cHand)
        result = judge(uHand, cHand)
        
        if result == 999:
            print("=-=-=-=-=-=-=-=-=-=-=-=")
            print("종료 !")
            
            if win >= 10:
                print("...댕고수")
            elif win >=5:
                print("...좀 치네 ?")
            else:
                print("...삭제해라 애송이")
            break
        win += result 
    print("%d승으로 종료"  %win)
         
         
################
playGame()           