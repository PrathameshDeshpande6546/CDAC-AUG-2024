#include <iostream>
using namespace std;

class Date{
    int day;
    int month;
    int year;
public:
Date(){
    day=0;
    month=0;
    year=0;

}
Date(int day,int month,int year){
    this->day=day;
    this->month=month;
    this->year=year;
}
void setDay(int day)
    {
        this->day = day;
    }

    void setMonth(int month)
    {
        this->month = month;
    }

    void setYear(int year)
    {
        this->year = year;
    }

    void acceptDate()
    {
        cout << "Enter the day, month and year - ";
        cin >> day >> month >> year;
    }

    void displayDate()
    {
        cout << day << "/" << month << "/" << year << endl;
    }

};
class Person{
   
    protected: 
    string name;
     string address;
       Date birthdate;
public:
    Person() {
        name="";
        address="";
    
    }
    Person(string name,string address,int day,int month,int year):birthdate(day,month,year)
    {
        this->name=name;
        this->address=address;
        this->birthdate.setDay(day);
    this->birthdate.setMonth(month);
    this->birthdate.setYear(year);



    }

    void acceptperson(){
        cout<<"Enter your info: "<<endl;
        cout<<"Enter name: "<<name<<endl;
        cin>>name;
        cout<<"Enter address: "<<address<<endl;
        cin>>address;
        cout<<"Enter Date of Birth: "<<endl ;
        birthdate.acceptDate();
        

    }
    
};

class Employee: protected Person{
    int id;
    float sal;
    string dept;
    Date joiningDate;
    public:
    Employee(){
id=0;
sal=000;
dept="";    }


Employee(int id,float sal,string dept,int day,int month,int year):joiningDate(day,month,year)
{
    this->id=id;
    this->sal=sal;
    this->dept=dept;
    this->joiningDate.setDay(day);
    this->joiningDate.setMonth(month);
    this->joiningDate.setYear(year);

}


void acceptemp(){
    Person::acceptperson();
    cout<<"Enter Employee details: "<<endl;
    cout<<"Enter id: "<<endl;
    cin>>id;
    cout<<"Enter sal: "<<endl;
    cin>>sal;
    cout<<"Enter dept: "<<endl;
    cin>>dept;
    joiningDate.acceptDate();
}
void displayemp(){
    
    cout<<"Employee Details: "<<endl;
    cout<<"Emp_id: "<<id<<endl;
    cout<<"Name: "<<name<<endl;
    cout<<"DOB: "<<endl;
    birthdate.displayDate();
    cout<<"Dept: "<<dept<<endl;
    cout<<"Joining Date: "<<endl;
    joiningDate.displayDate();
    cout<<endl<<"Salary: "<<sal<<endl;
    
}


};
int main(){
    Employee e1;
    e1.acceptemp();
    e1.displayemp();
    
return 0;
}