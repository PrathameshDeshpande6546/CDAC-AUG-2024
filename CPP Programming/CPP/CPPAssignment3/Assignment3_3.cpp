#include <iostream>
using namespace std;

class Address{
string building;
string street;
string city;
int pin;

public:
Address(){
    building="Morya Building";
    street="abc";
    city="Kagal";
    pin=416216;
    cout<<building<<"\n"<<street<<"\n"<<city<<"\n"<<pin<<endl;
}

void setbuilding(string b){
building=b;
}
void getbuilding(){

}
void setstreet(string s){
street=s;
}
void getstreet(){

}
void setcity(string c){
    city=c;
}
void getcity(){

}
void setpin(int p){
     pin=p;
}

int getpin() {
    return pin;
}


void acceptaddress(){
    cout<<"Enter proper address:\nbuilding\nstreet\ncity\npin\n";
    cin>>building>>street>>city>>pin;

}
void displayaddress(){
    cout<<" Given Address =\n"<<"Building Name:"<<building<<"\nStreet:"<<street<<"\nCity:"<<city<<"\nPin:"<<pin<<endl;
}

};
int main(){
    Address a1;
        a1.acceptaddress();
        a1.displayaddress();

}