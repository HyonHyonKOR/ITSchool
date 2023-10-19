# -*- coding:utf-8 -*-

# 강아지 클래스 => 생성자에 이름, 나이 + 그 속성 출력 기능 

class Dog:
    def __init__(self,name,age):
        self.name = name;
        self.age = age;
        
    def printInfo(self):
        print(self.name, self.age)   
        
    if __name__ == "__main__":
        # 여기에 야생동물 불러와서 => 객체 만들고 출력하는 기능까지   
        # oMain1에서 실행하면... ->
        from animal.wild import Ant 
        a = Ant("ant",100000)
        a.printInfo()