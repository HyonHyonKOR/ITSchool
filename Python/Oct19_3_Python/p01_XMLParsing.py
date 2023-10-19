# -*- coding:utf-8 -*-
from http.client import HTTPConnection
from xml.etree.ElementTree import fromstring

# http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150060300

# HTTP통신
hc = HTTPConnection("www.kma.go.kr")# 서버 주소
hc.request("GET", "/wid/queryDFSRSS.jsp?zone=1150060300") #요청

res = hc.getresponse()
resBody = res.read()
# print(resBody.decode()) # 출력(한글 처리)
############################################
# XML Parsing
# DOM객체 여러개 찾기 : .getiterator("태그명")/ .iter("태그명")
# DOM객체 하나 찾기 : .find("태그명")

# kmaWeather = fromstring(resBody)
# weathers = kmaWeather.iter("data")
# for w in weathers:
    # print(w)
    # print("--------")
    
for w in fromstring(resBody).iter("data"):   
    print(w.find("hour").text)
    print(w.find("temp").text)
    print(w.find("wfKor").text)
    print("-----------")