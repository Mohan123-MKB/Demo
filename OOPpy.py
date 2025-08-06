#class and object
class Student:
    def __init__(self,name,age):
        self.name=name
        self.age=age
    def display(self):
        print(f"Name : {self.name}, Age : {self.age}")

#Inheritance
class Animal:
    def sound(self):
        print("Animal makes a sound")
class Dog(Animal):
    def sound(self):
        print("Dog barks")

#Encpasulation
class BankAccount:
    def __init__(self):
        self.__balance=0
    def set_balance(self,amount):
        if amount>=0:
            self.__balance=amount
    def get_balance(self):
        return self.__balance
    
#Polymorphism(method overiding)
class Shape:
    def area(self):
        print("cal are...")
class Circle(Shape):
    def area(self):
        print("pi r square")
class Square(Shape):
    def area(self):
        print("side * side")
    
#Abstraction
from abc import ABC, abstractmethod
class Vehicle(ABC):
    @abstractmethod
    def run(self):
        pass
class Bike(Vehicle):
    def run(self):
        print("Bike is running")


s1=Student("Mohane",20)
s1.display()

d=Dog()
d.sound()

b=BankAccount()
b.set_balance(1000)
print(b.get_balance())

s1=Circle()
s2=Square()
s1.area()
s2.area()

v=Bike()
v.run()