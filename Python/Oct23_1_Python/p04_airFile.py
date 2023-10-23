'''
Created on 2023. 10. 23.

@author: ckd39
'''
from cx_Oracle import connect

# -*- coding:utf-8 -*-

file = open("C:/Users/ckd39/Downloads/Test/air.txt", "a", encoding = "UTF-8")

con = connect("ainchel/1541547@localhost:1521/xe")
cur = con.cursor()

sql = "select * from oct23_air"
cur.execute(sql)

for n, g, pm10, pm25 in cur:
    file.write(f"고유번호 : {str(n)} |")
    file.write(f"구 : {str(g)} |")
    file.write(f"미세먼지 농도 : {str(pm10)} |")
    file.write(f"초미세먼지 농도 : {str(pm25)} \n")
    print("메모장 입력 완료!")
    
file.close()