#include <iostream>
using namespace std;

class Student{
    int roll_no;
    string name;
    float marks;   
    int choice;

public:
    void inStudent(){
        
        roll_no=0;
        name="";
        marks=0;
   

    }
    void printStudentFromConsole(){
        cout<<"RollNo:"<<roll_no<<"\nName :"<<name<<"\nMarks :"<<marks<<endl;
        
        
    }
        
        void acceptStudentFromConsole(){
        cout<<"Enter details of students-\nRollNo\nName\nMarks\n";
        cin>>roll_no>>name>>marks;

        }
       
        

    };
     int menu(){
            int choice;
            cout<<"Enter your choice\n"<<"0.Exit\n"<<"1.add\n"<<"2.Show\n";
            cin>>choice;
            return choice;

        }
     
    int main(){
        class Student s1;
       s1.inStudent();
        int choice;
     
   while ((choice = menu()) != 0){
        switch (choice)
        {
        case 1: s1.acceptStudentFromConsole();
            break;
        case 2: s1.printStudentFromConsole();
        break;
        

        default: cout<<"Wrong choice\n";
            break;
        }
   }
}
    
    
