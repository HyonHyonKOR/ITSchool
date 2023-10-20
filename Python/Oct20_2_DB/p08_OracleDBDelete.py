# -*- coding:utf-8 -*-
from cx_Oracle import connect

con = connect("rnjsgurah2/1234@localhost:1521/xe")

while True:
    sql = "select * from oct20_coffee"
    cur = con.cursor()
    cur.execute(sql)
    
    for a in cur:
        print(a)
    
    n = int(input("no:"))
    sql = f"delete from oct20_coffee where c_no={n}"
    cur = con.cursor()
    cur.execute(sql)
        
    if(n==999):
        print("finish")
        con.commit()
        break
    
con.close()