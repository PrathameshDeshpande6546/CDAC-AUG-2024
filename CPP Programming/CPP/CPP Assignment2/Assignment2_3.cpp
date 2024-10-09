#include <iostream>
using namespace std;
namespace nStudent{
 class student{
    int roll_no;
    string name;
    int mob_no;

public:
    void acceptdetails(){
        cout<<"Enter Your Details:\n"<<"Rollno\nName\nMobNo\n";
        cin>>this->roll_no>>this->name>>this->mob_no;
    }
    void displaydetails(){
        cout<<"\nRoll No:"<<roll_no<<"\nName:"<<name<<"\nMob No:"<<mob_no;
        {
            
        } 
        
    }
 };
}
int main(){
nStudent::student s1;
s1.acceptdetails();
s1.displaydetails();
}