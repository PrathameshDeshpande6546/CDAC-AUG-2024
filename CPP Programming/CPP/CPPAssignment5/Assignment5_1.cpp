#include <iostream>
using namespace std;
class Date
{
    int day;
    int month;
    int year;

public:
    Date()
    {
        this->day = 0;
        this->month = 0;
        this->year = 0;
    }
    Date(int day, int month, int year)
    {
        this->day = day;
        this->month = month;
        this->year = year;
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
        cout << "Enter the day, month and year - "<<endl;
        cin >> day >> month >> year;
    }

    void displayDate()
    {
        cout << day << "/" << month << "/" << year << endl;
    }
};
class Person{
        string name;
        string address;
        Date dob;
    public:
    Person(){
        name="";
        address="";

    }
    Person(string name,string address,int day,int month,int year):dob(day,month,year)
    {
        this->name=name;
        this->address=address;
        this->dob.setDay(day);
        this->dob.setMonth(month);
        this->dob.setYear(year);

    }
    
     void acceptDetails()
    {
        cout << "Enter Name: ";
        cin >> name;
        cout << "Enter Address: ";
        cin >> address;
        cout << "Date of Birth: ";
        dob.acceptDate();
    }
    void display(){
        cout<<"\nName:"<<name<<endl;
        cout<<"\nAddress:"<<address<<endl;
        cout<<"\nDate Of Birth:"<<endl;
        dob.displayDate();

        
    }
    
    
    };
    int main(){

    Person p1;
    p1.acceptDetails();
    Person p2("Prathamesh","Sulkud",31,5,2002);
    p1.display();
    p2.display();
    return 0;
    }