# -*- coding:utf-8 -*-
from cx_Oracle import connect

# input으로 숫자 2개를 입력
#    => 가격순(오름차순)으로 정렬해서
#    -> ?~?번째까지의 평균 가격을 출력

con = connect("rnjsgurah2/1234@localhost:1521/xe")

start = int(input("start: "))
end = int(input("end : "))

sql = "select avg(c_price) "
sql +="    from (select rownum as rn, c_price "
sql +="        from(select c_price "
sql +="            from oct20_coffee order by c_price)) "
sql +=f"where rn between {start} and {end}"

cur = con.cursor()
cur.execute(sql)

for a in cur:
    print(a)
    print(a[0])
con.close()