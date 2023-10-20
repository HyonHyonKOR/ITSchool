# -*- coding:utf-8 -*-
from http.client import HTTPSConnection
from json import loads

# https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
#42008a8c8e7402a3fc9d3b1a7df8fee9

# 도시 이름: 입력 (영어)
# 요청파라미터 추가 O
# 응답 내용 출력까지
city_name = input("city name : ")

hc = HTTPSConnection("api.openweathermap.org") 
url = f"/data/2.5/weather?q={city_name}&appid=42008a8c8e7402a3fc9d3b1a7df8fee9"
url += "&units=metric&lang=kr"
hc.request("GET", url)

resBody = hc.getresponse().read()

# print(resBody.decode())

weatherData = loads(resBody) #JS => Python
# print(weatherData)

# python : List / JS : Array
# python : dict / JS : object

# 날씨 / 기온 / 체감기온 / 습도 / 바람속도
# 데이터를 콘솔창에 출력
#################################################
# 단 하나의 데이터 O => 반복문이 필요 없음!
print(weatherData["weather"][0]["description"])
print(weatherData["main"]["temp"])
print(weatherData["main"]["feels_like"])
print(weatherData["main"]["humidity"])
print(weatherData["wind"]["speed"])