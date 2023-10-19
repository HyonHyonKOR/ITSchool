# -*- coding:utf-8 -

# 파일로부터 데이터를 읽어봐서 프로그램에서 활용하기 위함
# 프로그램에서 만든 데이터를 파일 형태로 저장하기 위함

# 파일 열기 => 작업(읽기,쓰기) => 파일 닫기(필수!!!)

#1. 파일에 내용 쓰기 (write)
#폴더는 미리 만들어놔야 함 / 파일은 존재하지 않아도 실행시에 파일을 만들어 줌

# w : 덮어쓰기 모드
# file = open("C:/Users/gram/Desktop/t/text.txt","w", encoding="UTF-8")
# file.write("test2")
# print("finish")
# file.close()

# 2. 파일에 내용을 추가
# file = open("C:/Users/gram/Desktop/t/text.txt","a", encoding="UTF-8")
# file.write("\nappend test")
# print("finish")
# file.close()

#3: 파일 읽어오기
file = open("C:/Users/gram/Desktop/t/text.txt","r", encoding="UTF-8")

# # 3-1. 파일 전체 읽기
# data = file.read()
# print(data)
# file.close()

#3-2. 파일을 한줄한줄 읽기
while True: 
    data = file.readline()
    print(data,end="")
    # readline의 결과가 공백인 상황 (파일의 맨 마지막 줄까지 끝난 상황)
    if data == "":
        break 
file.close()    