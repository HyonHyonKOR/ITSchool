# -*- coding:utf-8 -*-

# 조건문 : 흐름 제어
if True:
    print("와 ~ 조건문!")
if False:
    print("안나오지 ~?!")
####################################
# 우선순위(산술, 관계, 논리)
print(10 + 2 > 8 + 3)
print(10 + 2 * 2 > 8 + 3 * 2)
print(((10 + 2) > 3) and (6 + 4 == 10))
####################################
# 놀이동산 >> A : 성인, 150이상
# 나이/ 키 => 입력 => 탑승 가능 or 탑스 불가 출력

#if (int(input("age:"))>=20) and (float(input("height:"))>=150):
#    print("탑승 가능")    
#else:
#    print("탑승 불가")

# age = int(input("나이 : "))
# height = float(input("키 : "))
# 
# if(age >= 20): 
    # if(height>=150):
        # print("탑승 가능")
    # else:
        # print("탑승 불가")    
# else:
    # print("탑승불가")
    
# if(age >= 20 and height >= 150):
    # print("탑승 가능")
# else:
    # print("탑승 불가")    
    #
# print("탑승 가능" if(age >= 20 and height >=150) else "탑승 불가")
# print((age >= 20 and height >=150) and "탑승 가능" or "탑승 불가")
########################################## 
# 다중 조건문
# Java: if- else if - else
# Python : if - elif - else
   
# 점수 입력 => 80점 이상은 'A'
#          70점 이상은 'B'
#          60점 이상은 'C'
#          나머지는 'D'를 출력
 
point = int(input("점수: ")) 

 
if point > 100 or point < 0 :
    print("엥?") 
elif point>=80:
    print("A")
elif point>=70:
    print("B")
elif point>=60:
    print("C")
else:
    print("D")           
###############################################
# switch-case: 없음! 오~

# in, not in
abc = {"name":"비버", "age":19, "phone":"010-1111-2222"}
print("name" in abc)
print(20 in abc.values())
print("height" not in abc)   