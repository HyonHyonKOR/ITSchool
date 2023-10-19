# -*- coding:utf-8 -*-
from datetime import datetime

# 현재 시간 날짜
# now = datetime.today()  #자동완성 주의 (_datetime X)
# print(now)
#
# # 특정 시간 날짜
# yesterday = datetime(2003,10,18)
# print(yesterday)
# print(type(yesterday))
# print(yesterday.year)
# print(yesterday.month)
# print(yesterday.day)

# 생일을 입력받아서 (연/월/일) 나이를 계산해주는 프로그램(출력)

# now = datetime.today()
#
# byear = int(input("출생년 :"))
# bmonth = int(input("출생월 :"))
# bday = int(input("출생일 :"))
# # birthday = input("yyyy/mm/dd")
#
# age = now.year - byear
#
# if now.month<bmonth: 
    # age -= 1
# elif now.month==bmonth and now.day<bday:
    # age -= 1    
    #
# print("당신의 나이는 %d살임다" %age)    

# str => datetime: strptime
# bd = datetime.strptime(birthday,"%y/%m/%d")
#print(type(bd))

# datetime => str:strftime
# bd = datetime.strftime(bd,"%A")
#print(bd)
############################################
# Pattern
# %Y : 연도 4자리 /%y : 연도 뒤에 2자리
# %m : 월 / %d: 일 /%H: 시간(24시간) /%I: 시간(12시간)
# %p : AM,PM   %M: 분    %S:초
# %a : 요일(짧게 /'Sun') / %A :요일(길게/ 'Sunday')
##############################################
# 특정 날짜를 연/월/일 형태로 입력받아서 -> 일/월 형태의 문자열로 출력
randomDate = input("yyyy/mm/dd:")

#str -> datetime
randomDate = datetime.strptime(randomDate, "%Y%m%d")

# datetime -> str
date = datetime.strftime(randomDate,"%d/%m")
print(date)

