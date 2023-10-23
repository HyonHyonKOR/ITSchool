'''
Created on 2023. 10. 23.

@author: ckd39
'''
from cx_Oracle import connect

# -*- coding:utf-8 -*-

# p01에서 만든 데이터를 .txt파일로 만들어 주세요.

# (번호, 시간, 온도, 최고기온, 최저기온의 형태로.)

file = open("C:/Users/ckd39/Downloads/Test/weather.txt", "a", encoding = "UTF-8")

con = connect("ainchel/1541547@localhost:1521/xe")
cur = con.cursor()

sql = "select * from oct23_weather"
cur.execute(sql)

for s, h, t, tmax, tmin in cur:
    file.write(f"고유번호 : {str(s)} |")
    file.write(f"시간 : {str(h)} |")
    file.write(f"온도 : {str(t)} |")
    file.write(f"최대기온 : {str(tmax)} |")
    file.write(f"최저기온 : {str(tmin)} \n")
    
file.close()
    