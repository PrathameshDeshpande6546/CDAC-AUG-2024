#include <iostream>
using namespace std;

struct Date{
    int day;
    int month;
    int year;


void initDate(){
    day=1;
    month=1;
     year=1900;
    //cout<<day<<month<<year;
}
void printdateOnConsole(){
    cout<<"Given Date is :"<<day<<":"<<month<<":"<<year<<"\n";

}
void acceptDateFromConsole(){
    cout<<"Enter date:\n";
    cin>>this->day>>this->month>>this->year;

}
bool checkisLeap(int year){
   if(year % 4==0 || year % 400 == 0) {
        return true;
    }
    else{
        return false;
    }

   

}

};

class date{
    int day;
    int month;
    int year;

public:
void initDate(){
    day=1;
    month=1;
     year=1900;
    //cout<<day<<month<<year;
}
void printdateOnConsole(){
    cout<<"Given Date is ="<<day<<":"<<month<<":"<<year<<"\n";

}
void acceptDateFromConsole(){
    cout<<"Enter date:\n";
    cin>>this->day>>this->month>>this->year;

}
bool checkisLeap(int year){
   if(year % 4==0 || year % 400 == 0) {
        return true;
    }
    else{
        return false;
    }

   

}

};

int menu()
{
    int choice;
    cout << "\n0. EXIT" << endl;
    cout << "1. ADD Date" << endl;
    cout << "2. DISPLAY Date" << endl;
    cout << "3. Check Leap Year/Not Leap" << endl;
    cout << "Enter your choice - \n";
    cin >> choice;
    return choice;
}
int main(){
    struct Date d1;
 class Date d2;
 d1.initDate();
 d2.initDate();
   
     
    int choice;

    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
            d1.acceptDateFromConsole();
            break;
        case 2:
            d1.printdateOnConsole();
            break;
             case 3:
                 if(d1.checkisLeap(d1.year)==0){
        cout<<"Given year is not Leap year\n";
    }
    else{
        cout<<"Given year is a leap year\n";
        
    }
            break;
        default:
            cout << "Wrong Choice...\n" << endl;
            break;
        }
    }
    return 0;
}


