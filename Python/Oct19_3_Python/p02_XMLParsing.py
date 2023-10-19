# -*- coding:utf-8 -*-
from urllib.parse import quote
from http.client import HTTPSConnection
from xml.etree.ElementTree import fromstring
import re


#https://openapi.naver.com/v1/search/shop.xml
#akgnOKaAly9U6NNvSb7N
#uS4BagcuKc

# 상품명 : 입력
# xml 파싱해서
# 문서의 제목 / 최저가 / 브랜드 / 대분류 카테고리 정보를 출력 

q = input("상품명:")
#URLEncoding해서 주소로 넘겨줄 것 
q = quote(q)

# HTTP요청 시 .request() 함수 잘 살펴보고 요청 헤더 처리 
headers = {
"X-Naver-Client-Id": "akgnOKaAly9U6NNvSb7N",
"X-Naver-Client-Secret": "uS4BagcuKc"
}    

# request 함수의 body 어떠한 데이터를 담아서 보낼때만 사용
hc = HTTPSConnection("openapi.naver.com")
hc.request("GET", "/v1/search/shop.xml?query=" + q, headers=headers)

# response 반환
res = hc.getresponse()
resBody = res.read()

# html 파싱
def cleanhtml(raw_html):
    cleanr =re.compile('<.*?>|&([a-z0-9]+|#[0-9]{1,6}|#x[0-9a-f]{1,6});')
    cleantext = re.sub(cleanr,"",raw_html)
    return cleantext
    
# 파싱 (in 옆에는 만드시 iterator가 있어야함)
for i in fromstring(resBody).iter("item"):   
    print(cleanhtml(i.find("title").text))
    print(i.find("lprice").text)
    print(i.find("brand").text)
    print(i.find("category1").text)
    print("--------")