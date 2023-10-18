# -*- coding:utf-8 -*-

class Book:
    #def __init__(self):
    #    print("Basic constructor - Book")
        
    # 생성자 : 객체가 메모리 상에 만들어질 때 호출하는 메소드    
    # overloading이 안되니 => 생성자를 하나만...!
    
    def __init__(self, title, price):
        print("Custom Constructor ")
        self.title = title   # 보통은 이렇게 생성자에서 멤버변수를 만들어서 결정 
        self.price = price   
        
    def printInfo(self):
        print(self.title, self.price)
        
        
    # 소멸자(destructor) : 객체가 메모리상에서 사라질 때 호출하는 메소드
    def __del__(self):
        print("Delete Book Object on Memory")
 
################################################## 
# 사람 클래스 : 이름, 나이 / 그 속성들 출력하는 기능/ 생성자, 소멸자
class Human:
    def __init__(self,name,age):
        print("Custom Constructor Human on Memory ")
        self.name = name
        self.age = age
        
    def printInfo(self):       
        print(self.name, self.age)
        
    def __del__(self):
        print("Delete Human Object on Memory")    
#################################################
# b1 = Book()
b2 = Book("One piece",8000)
b2.printInfo()
print("------")
###############################################
# Garbage Collection : 그 객체를 가리키는 변수가 없게 되면 Heap영역을 자동으로 정리
h1 = Human("John", 50)
h1.printInfo()
print("------")
h2 = Human("Amy", 30)
h2.printInfo()
print("-------")

h3 = h1
h3.printInfo()
#print(id(h1))
#print(id(h3))

h1 = None
#h3.printInfo()
h3 = None   # h1のgc位置
print("!@#$%%^")