#include <iostream>
using namespace std;

class student{
     string name;
     string gender;
     const int rollNumber;
     int marks[3];
public:
        
     
     student(int rollNumber):rollNumber(++rollNumber){
        name="";
        gender="";
     }
     void acceptData(){
          cout<<"Enter name : "<<endl;
          cin>>name;
          cout<<"Enter gender : "<<endl;
          cin>>gender;
          for(int i=0; i<3; i++){
               cout<<"Enter marks : "<<endl;
               cin>>marks[i];
          }       
     }

     void displayData(){
          int sum;
          float per;
          cout<<"rollnumber : "<<rollNumber<<endl;
          cout<<"name : "<<name<<endl;
          cout<<"gender : "<<gender<<endl;
          for(int i=0; i<3; i++){
               sum+=marks[i];
          }

          per=sum/3;
          cout<<"percentage : "<<per<<endl;
     }

     static student* getstudent(student** arr, int r) {
        for (int i = 0; i < 3; i++) {
            if (arr[i]->rollNumber == r) {
                return arr[i];
            }
        }
        return nullptr;
    }

     static int search(student** ptr) {
        int rollNo;
        cout << "Enter rollNo: " << endl;
        cin >> rollNo;
        student* foundStudent = getstudent(ptr, rollNo);
        if (foundStudent != nullptr) {
            return foundStudent->rollNumber;
        }
        return -1;  
    }
};
int menu(){
     int choice;
     cout<<"Enter your choice : "<<endl;
     cin>>choice;
     return choice;
}
int main(){
     
     student *arr[3];
     int choice;
       int index;
     

     while((choice=menu())!=0){
          cout<<"press 1 to enter data :"<<endl;
          cout<<"press 2 for displaying the data :"<<endl;

     switch(choice){
           case 1:
           {
         for(int i=0; i<3; i++){
          arr[i]=new student(i);
          arr[i]->acceptData();
         }
         
         
     }
     break;
     case 2:
     {
           for(int i=0; i<3; i++){
          arr[i]->displayData();
             }
     }
     break;
     case 3:
     index = student::search(arr);
                if (index != -1) {
                    cout << "Student found with roll number: " << index << endl;
                } else {
                    cout << "Student not found." << endl;
                }
                break;
     default : cout<<"wrong choice..."<<endl;
     }

     }
     
     
}