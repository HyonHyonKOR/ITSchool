# -*- coding:utf-8 -*-
from cx_Oracle import connect

# 원두의 이름을 검색해서
# 그 원두를 사용하는 커피의 종류 갯수, 평균가를 출력

#1.DB 연결
con = connect("rnjsgurah2/1234@localhost:1521/xe")

#3. Data확보!
b = input("coffee bean : ")

sql = "select count(c_no),avg(c_price) from oct20_coffee where c_bean='%s'" %b

#5. DB관련작업 (sql문을 서버로 전송, 실행, 결과 받기)
#   Java: PreparedStatement (pstmt)
#   Python : cursor()
cur = con.cursor()

#6. 수행 (sql문을 서버로 전송, 실행, 결과 받기)
cur.execute(sql)

#7. 결과처리
for n,p in cur:
    print(n,p)
    print("------------")
    

#2. DB연결 종료        
con.close()    