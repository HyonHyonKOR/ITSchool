# -*- coding:utf-8 -*-
from cx_Oracle import connect

# OracleDB와 연동이 되는 Java : instant client에 있는 ojdbc8.jar
# OracleDB와 연동이 되는 Python : cx_Oracle.py(가 instant client를 사용)

# 기본적으로 python에는 OracleDB 연결 기능이 없음
# 시작 -> cmd -> pip install cx_oracle
# rnjsgurah2/1234@localhost:1521/xe

try:
    con = connect("rnjsgurah2/1234@localhost:1521/xe")
    print("성공")
except Exception as e:
    print(e)
        
con.close()    