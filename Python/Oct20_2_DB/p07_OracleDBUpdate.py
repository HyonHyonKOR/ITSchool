# -*- coding:utf-8 -*-
from cx_Oracle import connect

con = connect("rnjsgurah2/1234@localhost:1521/xe")

b = input("bean name:")
p = input("price:")

sql =f"update oct20_coffee set c_price = c_price + {p} where c_bean='{b}'"

cur = con.cursor()
cur.execute(sql)

if cur.rowcount >= 1:
    print("성공!") 
    con.commit()

con.close()