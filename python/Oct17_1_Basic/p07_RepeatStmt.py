# -*- coding:utf-8 -*-
# for(int i = 0; ...) : X
# for(int ii : i      : O

l = [123,45,6,78,910]
for ll in l :
    print(ll)
print()     

# ㅋ를 10번 출력
# 1~20까지의 숫자 중에서 홀수만 출력

###########################################
for ll in range(10):
    print('ㅋ',end="")
print()

for ll in range(1,21,2):
    print(ll,end=" ")
print()
#############################################
# while문 : O
while True:
    y = int(input("y: "))
    if y % 2 == 0:
        print("짝수")
        break
############################################
# do -while문 : X
############################################
# enumerate : 반복문을 사용할 때 몇 번 반복되었는지 확인이 필요할 때 사용
#     (인덱스, 값) 형태의 tuple로 리턴 
li = ["컴퓨터","모니터","마우스","키보드"]
for i,v in enumerate(li):
    print(i + 1, v)
 
print("------")   

score = [10,54,56,70,70,87,65,99,91,88]
# 1등 학생은 몇번째에? / 점수는 몇점인지? 출력
maxI,maxS = 0,0

for i,v in enumerate(score):
    if maxS < v:
        maxS = v
        maxI = i    
print(maxI, maxS)    
        