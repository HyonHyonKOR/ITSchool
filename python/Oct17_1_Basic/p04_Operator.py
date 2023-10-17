# -*- coding:utf-8 -*- 

# 정수 2개를 입력 받아서, 사직 연산에 대한 결과와
# 앞의 수를 뒤의 수로 나눴을 때의 나머지값을 출력

a = int(input("a: ")) 
b = int(input("b: "))

print(a+b)
print(a-b)
print(a*b)
print(a**b)
print(a/b)
print(a%b)
##############################
f = a//b # 몫
print(f)

z= "ㅋㅋㅋ"
# h = a + z # 숫자 + 문자열 => 불가능!
h = str(a) + z   # 문자열 결합
print(h)

i = a * z  # 숫자 * 문자열 = > 문자열 반복 
print(i)
#############################################
# x = x + 3
a+=3
print(a)
# ++, --는  없음
# x++
# print(x)
###########################################
j = a> 10 
print(j)

# && : and, || : or
k = (a > 10) and (b<3)
print(k)

# ! : not
l = k
print(l)

# m : x가 5 이상 ~ 10 이하 : True / 아니면 False 출력
#m = (a >=5) and (a<10)
m = (5 <=a <=10)
print(m)
# 3항 연산자
# Python에는 있다고 하는 사람도 있고, 없다고 하는 사람이 있음
#[참일때의 값] if [조건식] else[거짓일때의 값]
# 정수를 하나 입력받아서 => 그게 짝수면 '짝수', 홀수면 '홀수' 출력
number = int(input("number: "))
print("짝수" if number%2==0 else"홀수")

# 3.8 => [조건식] and [참일때의 값] or [거짓일때의 값]