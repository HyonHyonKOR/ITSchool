# -*- coding:utf-8 -*-
# function(함수)
# def 함수명(파라미터명)
#    code


def test():
    print("I'm sleepy")
    
def test2(): #:을 썼으면 그 다음줄에는 반드시 들여쓰기를 해줘야
    pass     #: 뒤에 코드 적을것이 없을때, 자리채워주라는 의미

# 정수 2개를 넣으면 그 합을 '출력'하는 함수
def printHab(a=0,b=0): # 호출할 때 값을 안넣어주면=>함수파라미터의 값을
# 기본값으로 사용
    print(a+b)

# 정수 3개를 넣으면 그 합을 '출력'하는 함수
def printHab2(a=0,b=0,c=0): #overloading이 안됨 => 모든 함수명이 다 달라야...!
    print(a+b+c)

# 정수 2개를 넣으면 그 합을 '구하는' 함수
def getHab(a=0,b=0):
    return a+b

# 정수 2개를 넣으면 사칙연산 결과를 '구하는' 함수
def calc(a=0,b=0):

    '''
         description...
         this function is..
         wow...
    '''
    
    q = a + b
    w = a - b
    e = a * b
    r = a / b
    return q,w,e,r # tuple 하나 리턴

############################################
help(calc)
help(print)
test()
printHab(5, 7)
printHab()
printHab2(1, 2, 3)

c = getHab(10,20)
print(c)

d = calc(10, 20)
print(d,type(d))

# u,i,o,p = calc(20,10)
u,i,_,p = calc(20,10) # _처리하면 곱하기 부분 안가져올 수 있음
