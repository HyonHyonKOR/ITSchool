# -*- coding:utf-8 -*-
from http.client import HTTPSConnection
from urllib.parse import quote
from json import loads

# 필요한 데이터 챙긴 후 
# 책(이름 검색) => 책 제목 - 작가 / 할인가 / 도서 소개 출력

book_name = input("book name: ")
book_name = quote(book_name)

header = {"Authorization": "KakaoAK 16e6c58f062166934ed7652260b1bc03"}
hc = HTTPSConnection("dapi.kakao.com")
url =f"/v3/search/book?query={book_name}"
hc.request("GET", url, headers=header)

resBody = hc.getresponse().read()

result = loads(resBody)

result["documents"]

for book in result["documents"]:
    print(book["title"]+"-" + book["authors"][0])
    print(book["price"])
    print(book["contents"])
    print()
