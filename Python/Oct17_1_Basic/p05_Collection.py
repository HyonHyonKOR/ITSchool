# -*- coding:utf-8 -*- 

# str 
s="Can't tuna kkk"
print(s)
print(s[0])
print(s[0:6]) #(0번째부터 (6-1)번째까지의 문자열)
print(s[2:10:2]) #(2번째부터 (10-1)번째까지의 문자열을 2칸씩 건너서 출력
print("-------------------")

# List: 리스트(순서 o , 중복 o )
a = [123,4,56,789,1011]
print(a,type(a))
print(a[0])
print(a[0:3])
print(a[0:5:2])
print(a[-1])    # 뒤에서 첫번째

print(len(a))   # 요소의 갯수 
a.append(1213)  # 끝에 요소 추가
a.insert(2,1415)# 중간에 요소 추가
a[4] = 7788     # 수정
del a[0]        # 삭제

#a.sort()        #오름차순 정렬
a.sort(reverse=True)
print(a)
print("-------------------")

# Tuple : 순서 O, 중복 O , 수정 X , 삭제 X
tuple1 = ('1','2','3') # 소괄호 생략 가능 O
print(tuple1)
# del tuple1[0] # 삭제 안됨
# tuple[0] = 'c'  # 수정 안됨

t = (1,2,3,4,5,6)
print(t)
print(t.index(5)) # 값이 들어있는 해당 위치에 있는 index 반환(여러개의 경우 첫번째 인덱스만 반환)
print(t.count(4)) # 값이 튜플안에 몇개 있는지 그 갯수를 반환

# a1 = 10
# b1 = 20
(a1,b1) = (10,20)
print(a1)
print(b1) 
(a1,b1) = (b1,a1) #튜플에 넣어서 서로의 값 바꾸기
print(a1,b1)

x,y,z = 10,20,30
x,y,z = z,x,y
print(x,y,z)
print("----------------------------")
# Set(집합) : 중복 제거, 순서는 랜덤
s = {"ㄱ","ㄱ","ㄹ","ㅃ","ㅃ"}
print(len(s))
s = list(s)
print(s)
print("----------------------------")
# Dict(=map)
d = {"name": "곽투팔", "age" :12}
print(type(d))
print(d["name"])
print(d["age"])
print("----------------------------")
#Range
r = range(10)   # 0 ~ (10 - 1 )까지의 범위
r = range(2,10) # 2~ (10-1)까지의 범위
r = range(2,10,3) # 2 ~ (10-1)까지, 3칸씩  
print(r,type(r))

#0~9까지 있는 list
r2 = range(10)
r2 = list(r2)
print(r2,type(r2))
print(list)
#1~20까지 홀수만 있는 list 출력 
r3 = list(range(1,21,2))
print(r3,type(r3))