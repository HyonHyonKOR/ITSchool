'''
Created on 2023. 10. 23.

@author: ckd39
'''
from http.client import HTTPConnection
from json import loads
from cx_Oracle import connect

#서울시 권역별 실시간 대기환경정보 조회 API URL
#http://openAPI.seoul.go.kr:8088
#/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/

# 요청해서 구 이름, 미세먼지, 초미세먼지 정보를 DB에 담는다.
# 대신, 여러 기간에 걸쳐 이 데이터들을 모은다고 가정하고, 새 모듈을 만들어서 DB의 데이터를 txt로까지.

hc = HTTPConnection("openAPI.seoul.go.kr:8088")
hc.request("GET", "/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/")
resbody = hc.getresponse().read()
#print(resbody.decode())

con = connect("ainchel/1541547@localhost:1521/xe")
cur = con.cursor()

airData = loads(resbody)

for a in airData['RealtimeCityAir']['row']:
    findGoo = a['MSRSTE_NM']
    findpm10 = a['PM10']
    findpm25 = a['PM25']
    #print(findGoo, findpm10, findpm25)
    sql = f"insert into oct23_air values(oct23_air_seq.nextval, '{findGoo}', '{findpm10}', '{findpm25}')"
    cur.execute(sql)
    if cur.rowcount == 1:
        print("DB저장 성공!")
        con.commit()
    
con.close()
