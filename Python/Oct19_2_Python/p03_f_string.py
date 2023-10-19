# -*- coding:utf-8 -
from datetime import datetime

# 좋아하는 음료 이름, 마시는 횟수 => 입력 받아서 그 내용을 출력
drink = input("음료 : ")
count = int(input("마시는 횟수 : "))
print("저는 %s를 좋아하고, 하루 %d잔을 마십니다" %(drink,count))
print("----------------------")

# Python 3.6.x부터 f-string이라고 부르는 포맷팅을 좀 더 쉽게 할 수 있는 방법이 추가

# f-string의 모양은 f와 {}만 기억하세요!
# f"문자열{변수명} 숫자..."의 형태
print(f"저는 {drink}를 좋아하고, 하루 {count}잔을 마십니다.")
print("------------")

#소주점 반올림 표현
#기본적으로 % 포맷팅과 거의 유사함
#하지만 {}를 사용해서 포맷팅할때는
# 포맷팅하는 값의 자료형에 상관없이 {}를 사용하면 됨
f = 1.125
# f = 1.135
print(f"{f}")       #1.125 / 1.135
print(f"{f:.1f}")   #1.1  /  1.1
print(f"{f:.2f}")   #1.12 /  1.14

# Python의 반올림은 반올림하려는 수가 올림, 내림 했을때
# 동일하게 차이가 나는 경우에는 (5가 기준이 되었을 때)
# 0,1,2만 반올림이 안됨...(공식문서 => 이진 소수의 한계점)

# 문자 정렬
s1 = "left"
result = f"│{s1:<10}│"
print(result)

s2 = "mid"
result = f"│{s2:^10}│"
print(result)

s3 = "right"
result = f"│{s3:>10}│"
print(result)

# 중괄호를 연속해서 2개를 사용하면 ({{}}), 로 중괄호 자체를 출력할 수 있음
# 값까지 표현하는 경우는 ({{{変数名}}}로 작성한다._


# f-string과 dict
d = {
    "name": "beaver",
    "age": 100,
    "gender": "male"
}

result5 = f"name: {d['name']}, gender:{d['gender']},age:{d['age']}"
print(result5)

# f-string과 list
n = [100,200,300]

print(f"list : {n[0]}, {n[1]},{n[2]}")

for v in n:
    print(f"element : {v}")
    
num2 = 1234567890
print(num2)

#1,234,567,890
print(f"{num2:,}")
print("-------------")    
date1 = datetime.today()
print(date1)
# 연 - 월 - 일 => 요일
print(f"{date1:%Y-%m-%d} is on a {date1:%A}.")

# 정리
# 1. 문자열 맨 앞에(따옴표 앞) 'f'를 붙인다.
# 2. 사용하고 싶은 변수, 값을 중괄호  {} 안에 넣는다
# 3. 예쁘게 출력한다.