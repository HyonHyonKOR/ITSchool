# -*- coding:utf-8 -*-
from random import randint

# 숫자야구(3자리) (함수) (각 자리수의 숫자는 중복 X)
# 012 ~ 987 중에 랜덤한 숫자가 정답
# 유저가 입력 => 자릿수와 값까지 같으면 S/ 자릿수는 다른데 값이 같으면 B
# S가 3개 나오면 정답! => 종료 (몇 번만에 맞췄는지 출력)

def comPick():
    numbers = []
    while len(numbers) < 3 :
        num = randint(0,9)
        if num not in numbers:
            numbers.append(num)
    print("컴퓨터가 세 자리 수를 선정했습니다.") 
    return numbers

def userPick1():
    userlist = []
    firstNum = int(input("첫번째 번호 입력(0~9)"))
    if -1<firstNum<10:
        userlist.append(firstNum)   
        return userlist            
    else:
        print("잘못된 입력입니다. 다시 입력해주세요")
        return userPick1()
    
def userPick2(userlist):
    secondNum = int(input("두번째 번호 입력(0~9)"))
    if -1<secondNum<10:
        if secondNum != userlist[0]:
            userlist.append(secondNum) 
            return userlist         
        else:
            print("중복된 숫자를  입력했습니다. 다시 입력해주세요")
            return userPick2(userlist)      
            
    else:
        print("잘못된 입력입니다. 다시 입력해주세요")
        return userPick2(userlist)    
    
def userPick3(userlist):
    finalNum = int(input("마지막 번호 입력(0~9)"))
    if -1<finalNum<10:
        if finalNum not in userlist:
            userlist.append(finalNum) 
            return userlist;            
        else:
            print("중복된 숫자를  입력했습니다. 다시 입력해주세요")
            return userPick3(userlist)      
            
    else:
        print("잘못된 입력입니다. 다시 입력해주세요")
        return userPick3(userlist)      
    
    
def judge(comlist,userlist):
    strike, ball = 0,0
    for i in range(0,3):
        for j in range(0,3):
            if comlist[i] == int(userlist[j]):
                if i == j:
                    strike += 1
                else: 
                    ball += 1
    return strike,ball                
##########################################
comlist = comPick()
print(comlist)
userlist= userPick3(userPick2(userPick1()))
print(userlist)    
strike,ball = judge(comlist,userlist)
print(strike,ball)