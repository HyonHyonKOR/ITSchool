# -*- coding:utf-8 -*-

class Avengers:
    def __init__(self,realName):
        self.realName = realName
    def attack(self):
        print("attack")
    def printInfo(self):
        print(self.realName)    
########################################### 
class Human:
    def __init__(self,age):
        self.age = age
    def eat(self):
        print("yummy")
    def attack(self):
        print("human attack")
    def printInfo(self):
        print(self.age)
############################################        

## 상속받는게 중복되면 (ex:attack) 먼저 상속받을 것을 불러옴
## Human의 attack을 불러오고 싶다면 직접 입력해야함
class Ironman(Avengers,Human):
    def __init__(self,realName,age):
        Avengers.__init__(self,realName)
        Human.__init__(self, age)
    def attack(self):
        Human.attack(self)        
    def printInfo(self):
        Avengers.printInfo(self)
        Human.printInfo(self)
############################################### 
if __name__ =="__main__":
    i = Ironman("Tony Stark", 40)
    i.attack()
    i.eat()
    i.printInfo()       
##########################################               