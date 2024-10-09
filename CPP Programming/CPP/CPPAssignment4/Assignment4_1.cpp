#include <iostream>
using namespace std;

class Time{
    int hrs;
    int min;
    int sec;


public:
void printTime(){
    
    cout<<"Time=\n"<<hrs<<"-"<<min<<"-"<<sec<<endl;
    
}
void acceptTime(){
    
    cout<<"Enter Date:\n"<<"Hrs:Min:Sec\n";
    cin>>hrs>>min>>sec;

    
}
void setHour(int h){
    hrs=h;
}
int gethour(){
    return hrs;
}
void setMin(int m){
    min=m;
}
int getMin(){
    return min;
}
void setsec(int s){
    sec=s;
}
int getsec(){
    return sec;
}
 Time(){
    int hrs=12;
    int min=32;
    int sec=35;
    
 }
 Time(int x,int y,int z){
    hrs=x;
    min=y;
    sec=z;
 }


};

int main(){
    Time **t1=new Time *[5];
    for(int i=0;i<5;i++){
        t1[i]=new Time;
    t1[i]->acceptTime();
    
    }

    cout<<"Registered Dates:"<<endl;

    for(int i=0;i<5;i++){
    t1[i]->printTime();
    }
    
}
