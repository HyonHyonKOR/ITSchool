# -*- coding:utf-8 -*-
from cx_Oracle import connect

# DB연결 => 커피 이름, 가격, 원두 정보 => .csv파일로 생성(,를 기준으로)

con = connect("rnjsgurah2/1234@localhost:1521/xe")

sql ="select c_name,c_price,c_bean from oct20_coffee"

cur = con.cursor()
cur.execute(sql)

file = open("C:/Users/gram/Desktop/t/text3.csv","a", encoding="UTF-8")

for n,p,b in cur:
    file.write(f"{n},{p},{b}\n")

print("finish")
file.close()