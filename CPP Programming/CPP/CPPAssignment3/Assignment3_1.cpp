#include <iostream>
using namespace std;
class Box{
    double length;
    double width;
    double height;
public:
    Box(){
        length=10;
         width=20;
         height=40;
        double volume=length*width*height;
        cout<<"Volume of Box is :"<<volume<<endl;
    }

    Box(double x,double y,double z){
        double vol=x*y*z;
        cout<<"Volume of Box is:"<<vol<<endl;
    }

    Box(double x):length(x),width(x),height(x)
    {
        double vol=length*width*height;
        cout<<"Volume of Box is:"<<vol<<endl;
    }
  
 
    
};
int menu(){
    int choice;
     cout<<"Enter Your Choice\n"<<"1.Volume with default values :\n 2.Volume with Paramaterized :\n 3.Volume with single value\n";
   cin>>choice;
   return choice;
}

    int main(){
     int choice ;
   cout<<"Enter Your Choice\n"<<"0.Exit\n1.Volume with default values :\n 2.Volume with Paramaterized :\n 3.Volume with single value\n";
   cin>>choice;
   while((choice=menu()) != 0){
   switch (choice)
   {
   case 1: {Box b1;
             break;}

     case 2:{
                double l,b,h;
                cout<<"Enter Length,width,height.\n";
                cin>>l>>b>>h;
                 Box b2(l,b,h);
     break;}
     case 3:{
                double side;
                cout<<"Enter Side\n";
                cin>>side;
        Box b3(side);
     break;}

        default : { cout<<"Wrong Choice\n";}
         break; 
   }
  
   }

   
   
   
}