# -*- coding:utf-8 -*-

# OOP : 객체 단위로 실생활을 표현 => 유지보수가 편하게
#  캡슐화 => 데이터를 안전하게 처리
#  1 file == 1 class => 코드를 재사용

# Java : Perfect한 OOP
#    java file(class) => 파일 하나가 곧 클래스 하나
#    클래스명 대문자로 시작 ex) Cat / Dog...

# Phyhon : hybrid한 OOP
#    python file(module) => 파일 하나에 클래스 여러개 가능
#    클래스명 무조건 대문자로 시작하지 않아도 됨
#    접근제어자(ex: public, private)없음 => 캡술화 없음
#    static 멤버 변수 없음
###############################################
class Shop:
    def showInfo(self):
        print(self.name,self.floor)


class Dog:
    name ="asdf"   # 의미 없음 #멤버변수는 생성자에서 만들어줄 것!
                   
    def bark(self):   # 메소드의 첫번째 파라미터로 self 필수
        print("왕왕")

    def printInfo(self):
        # Java : this.name => this. 은 생략이 가능 => name
        # Python : self.name => self. 은 생략이 불가능
        print(self.name, self.age)


    # overloading 지원 안됨 => 모든 메소드명이 다 달라야 함
    
    # static method : 객체 만들지 않고 사용할 수 있는 메소드
    # @ : decorator(데코레이터)
    
    @staticmethod
    def staticMethodTest():
        print("스태틱왕왕")
#################################################
Dog.staticMethodTest()         
s = Shop()
s.name = "카페" 
s.floor = 1
s.showInfo()
print("-------------")  
d = Dog()
d.name="댕댕이"   
d.age= 1892 
print(d,type(d)) 
d.printInfo()
d.bark()      # 메소드 호출방법 1
Dog.bark(d)   # 메소드 호출방법 2