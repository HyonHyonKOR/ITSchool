# -*- coding:utf-8 -*-
from cx_Oracle import connect

#1.DB 연결
con = connect("rnjsgurah2/1234@localhost:1521/xe")

#3. Data확보!
n = input("coffee name: ")
p = int(input("coffee price : "))
b = input("coffee bean : ")

#4. sql문 작성
#   Java: ?,?
#   MyBatis : #{멤버변수명}
#   Python: 완성된 sql문을 사용!
#      sql문 끝나고 나서 ;(세미콜론) 넣지 않는다 !!!!!!!!
sql = "insert into oct20_coffee values(oct20_coffe_seq.nextval, "
sql += "'%s', %d, '%s')" %(n,p,b)

#5. DB관련작업 (sql문을 서버로 전송, 실행, 결과 받기)
#   Java: PreparedStatement (pstmt)
#   Python : cursor()
cur = con.cursor()

#6. 수행 (sql문을 서버로 전송, 실행, 결과 받기)
cur.execute(sql)

#7. 결과처리
if cur.rowcount == 1: #방금 작업때문에 영향을 받은 행 수가 하나라면...
    print("성공")
    con.commit()
    

#2. DB연결 종료        
con.close()    