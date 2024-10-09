#include <iostream>
using namespace std;

class Employee{
    int id;
    double salary;

    Employee(){
       id=0;
       salary=0;

    }
    Employee(int id,double salary){
        this->id=id;
        this->salary=salary;
    }

    void setId(int x){
        id=x;
    }
    int getId(){
        return id;
    }
    
    void accept(){
        
    }
    void display(){
        
    }


};

class Manager:public Employee{

    double bonus;

    
    Manager(){
        bonus=00;
    }
    Manager(double bonus){
        this->bonus=bonus;

    }
protected:
    void acceptManager(){
        

    }
    void displayManager(){
        

    }
};
class Salesman:public Employee {
    double commission;


    Salesman(){
        commission=0;

    }
    Salesman(double commission){
        this->commission=commission;

    }
    void acceptSalesman(){
         

    }
    void displaySalesman(){
        
    }
};

class SalesManager:public Manager,public Salesman
{

    SalesManager(int id,double salary,double bonus,double commission){
this->id=id;
this->salary=salary;
this->bonus=bonus;
this->commission=commission;

    }


}