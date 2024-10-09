#include <iostream>
using namespace std;
class TollBooth{
    int totalcars;
    double totalrevenue;
    int paidcars;
    int nonpaidcars;
    

public:
TollBooth()
{
 totalcars=0;
 totalrevenue=0;
 paidcars=0;
 nonpaidcars=0;
}
void payingCar(){
    paidcars=paidcars+1;
    totalcars=totalcars+1;
    totalrevenue=totalrevenue+0.50 ;
}
void nonpayingCar(){
nonpaidcars=nonpaidcars+1;
    totalcars=totalcars+1;
}
void display(){
    cout<<"Total Cars Passed= "<<totalcars<<"\nTotal Cars that paid toll= "<<paidcars<<"\nTotal NonPaid cars= "<<nonpaidcars<<"\nTotal Revenue= "<<totalrevenue<<endl;
}
};

int menu(){
    int choice;
    cout<<"0.Exit\n1.If You Want to pay toll.\n2.If You don't want to pay toll.\n3.Show Total Paid and Non Paid Cars:\n";
    cin>>choice;
    return choice;
}
int main(){
    TollBooth t1;
    int choice;
    while ((choice=menu())!=0){

switch (choice)
{
case 1:t1.payingCar();
    break;

case 2:t1.nonpayingCar();
    break;
    case 3:t1.display();
    break;
    default:cout<<"Wrong Choice\n";
    break;
}
    }
    
    
}

 
 