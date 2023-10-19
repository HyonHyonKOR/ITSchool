# -*- coding:utf-8 -*-

# abstract - X

# Java: 생성자 상속이 안됨
# Python : 생성자가 상속이 됨!
#   멤머변수를 생성자에서 결정 => 생성자를 상속안해주면 => 멤버변수가 상속이 안됨

class Avengers:
    def __init__(self,name,age):
        print("Avengers Assemble")
        self.name = name
        self.age = age
    
    def attack(self):
        print("ATTACK!")    
        
    def printInfo(self):
        print(self.name)
        print(self.age)    
#####################################################
class Ironman(Avengers):
    
    # overloading: 메소드명 같게, 파라미터를 다르게
    # overriding: 상속받은 메소드 기능 바꾸기
    def __init__(self,name,age,suitType):
        Avengers.__init__(self, name, age)
        self.suitType = suitType
        
    def attack(self):
        #Avengers.attack(self)
        super().attack()
        print("beam")   
        
    def printInfo(self):
        Avengers.printInfo(self) 
        print(self.suitType) 
###################################################           
# 헐크(어벤져스 소속) / 이름, 나이, 바지사이즈 / 공격 O / 정보 출력
class Hulk(Avengers):
    
    # overloading: 메소드명 같게, 파라미터를 다르게
    # overriding: 상속받은 메소드 기능 바꾸기
    def __init__(self,name,age,skincolor):
        Avengers.__init__(self, name, age)
        self.skincolor = skincolor
        
    def attack(self):
        #Avengers.attack(self)
        super().attack()
        print("i'm always angry")   
        
    def printInfo(self):
        Avengers.printInfo(self) 
        print(self.skincolor) 
###################################################
if __name__ == "__main__":
    i = Ironman("Tony Stark", 1, "mk-50")
    i.attack()    
    i.printInfo()
    print("------------")
    
    h = Hulk("Bruce Banner",2,"green")
    h.attack()
    h.printInfo()
    
    