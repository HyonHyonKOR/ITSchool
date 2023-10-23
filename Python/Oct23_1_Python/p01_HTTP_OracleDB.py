'''
Created on 2023. 10. 23.

@author: ckd39
'''
from http.client import HTTPSConnection, HTTPConnection
from xml.etree.ElementTree import fromstring
from cx_Oracle import connect

# -*- coding:utf-8 -*-

# 기상청 데이터 API(URL 가져오기)에 가서, XML데이터 받아온 것을 DB에 쌓을 것이다.
# 시간대 / 기온 / 최고기온 / 최저기온 데이터를 집어넣기.

# API : http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4157057000

#파이썬으로 HTTP 통신 해보기...! 아래 7줄로 끝난다. 참쉽죠?
hc = HTTPConnection("www.kma.go.kr")#먼저, 메인 주소까지만 가져온다. 
hc.request("GET", "/wid/queryDFSRSS.jsp?zone=4157057000") #요청
resBody = hc.getresponse().read() #받아온 결과를 읽어오기
#print(resBody) # 받아온 결과를 출력해보기.
#위 코드까지만 진행하면, jsp에 처리되어있는 인코딩을 디코딩하지 않아 깨져서  나온다.
#print(resBody.decode()) #받아온 결과.decode를 사용하여 디코딩시켜준다.

con = connect("ainchel/1541547@localhost:1521/xe")
cur = con.cursor()

# 먼저, 찾아온 XML 데이터를 파이썬의 str로 변환한다.
kmaWeather = fromstring(resBody)
weathers = kmaWeather.iter("data") # 변환한 str내에서, "data"라는 이름의 태그를 가져온다.
for w in weathers:
     h = w.find("hour").text
     t = w.find("temp").text
     tmax = w.find("tmx").text
     tmin = w.find("tmn").text
     if tmin == "-999.0":
         tmin = "missing"
     sql = f"insert into oct23_weather values(oct23_weather_seq.nextval, '{h}', '{t}', '{tmax}', '{tmin}')"
     cur.execute(sql)
     if cur.rowcount == 1:
         print("DB추가 성공!")
         con.commit()
     #print(sql)    
     #print(h, t, tmax, tmin)
    
con.close()
