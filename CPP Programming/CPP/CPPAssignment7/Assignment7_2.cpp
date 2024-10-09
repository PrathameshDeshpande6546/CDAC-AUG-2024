#include <iostream>
#include <typeinfo>
using namespace std;

class Employee {
    int id;
    double salary;

public:
    Employee(){

    }
    Employee(int id, double salary){

    }

    virtual void accept() {
        cout << "Enter empid : ";
        cin >> id;
        cout << "Enter Salary : ";
        cin >> salary;
    }

    virtual void display() const {
        cout << "Empid -  " << id << endl;
        cout << "Salary -  " << salary << endl;
    }

    
};

class Manager : virtual public Employee {
    double bonus;

protected:
    void acceptManager() {
        cout << "Enter bonus : ";
        cin >> bonus;
    }
    void displayManager() const {
        cout << "Bonus : " << bonus << endl;
    }

public:
    Manager(){

    }
    Manager(int id, double salary, double bonus){

    }

    void accept(){
        Employee::accept();
        acceptManager();
    }

    void display(){
        Employee::display();
        displayManager();
    }
};

class Salesman : virtual public Employee {
    double commission;

protected:
    void acceptSalesman() {
        cout << "Enter commission : ";
        cin >> commission;
    }
    void displaySalesman() const {
        cout << "Commission : "<< commission << endl;
    }

public:
    Salesman(){

    }
    Salesman(int id, double salary, double commission){

    }

    void accept(){
        Employee::accept();
        acceptSalesman();
    }

    void display(){
        Employee::display();
        displaySalesman();
    }
};

class Salesmanager : public Manager, public Salesman {
public:
    Salesmanager() {}
    Salesmanager(int id, double salary, double bonus, double commission){

    }

    void accept(){
        Employee::accept();
        this->acceptManager();
        this->acceptSalesman();
    }

    void display(){
        Employee::display();
        this->displayManager();
        this->displaySalesman();

    }
};

enum Menu {
    EXIT,
    ACCEPT_EMPLOYEE,
    DISPLAY_COUNT_DESIGNATION,
    DISPLAY_MANAGERS,
    DISPLAY_SALESMAN,
    DISPLAY_SALESMANAGERS,
};

enum eMenu {
    EXITo,
    ACCEPT_MANAGER,
    ACCEPT_SALESMAN,
    ACCEPT_SALESMANAGER,
};

void count_designation(Employee ** ptr ,int index){
    int mcount=0;
    int scount=0;
    int smcount=0;

    for(int i=0; i<index; i++){
        if(typeid(*ptr[i])==typeid(Manager)){
            mcount++;
        }
        else if(typeid(*ptr[i])==typeid(Salesman)){
            scount++;
        }else if(typeid(*ptr[i])==typeid(Salesmanager)){
            smcount++;
        }
    }

    cout<<"Total Mangers : "<<mcount<<endl;
    cout<<"Total Salesman : "<<scount<<endl;
    cout<<"Total Salesmanagers : "<<smcount<<endl;

}

int main() {
    Employee *arr[10];
    int choice;
    int index = 0;

 cout << "Enter your choice"<<endl;
 cin>>choice;
    while (choice!=Menu::EXIT) {
        
        cout << "0: EXIT"<<endl;
        cout << "1: Accept Employee"<<endl;
        cout << "2: Display count"<<endl;
        cout << "3: Display Managers"<<endl;
        cout << "4: Display Salesman"<<endl;
        cout << "5: Display Salesmanager"<<endl;
        cin >> choice;

        

        switch (choice) {
        case Menu::ACCEPT_EMPLOYEE: {
            int Choice;
            while (true) {
                cout << "Enter your choice:"<<endl;
                cout << "0: Exit"<<endl;
                cout << "1: Accept Manager "<<endl;
                cout << "2: Accept Salesman"<<endl;
                cout << "3: Accept Salesmanager"<<endl;
                cin >> Choice;

                if (Choice == eMenu::EXITo) break;

                switch (Choice) {
                case eMenu::ACCEPT_MANAGER:
                    if (index < 10) {
                        arr[index] = new Manager;
                        arr[index]->accept();
                        index++;
                    } else {
                        cout << "Cannot add array is full"<<endl;
                    }
                    break;

                case eMenu::ACCEPT_SALESMAN:
                    if (index < 10) {
                        arr[index] = new Salesman;
                        arr[index]->accept();
                        index++;
                    } else {
                        cout << "Cannot add array is full"<<endl;
                    }
                    break;

                case eMenu::ACCEPT_SALESMANAGER:
                    if (index < 10) {
                        arr[index] = new Salesmanager;
                        arr[index]->accept();
                        index++;
                    } else {
                        cout << "Cannot add array is full"<<endl;
                    }
                    break;

                default:
                    cout << "Wrong choice..."<<endl;
                    break;
                }
            }
            break;
        }

        case Menu::DISPLAY_COUNT_DESIGNATION: {
            
                count_designation(arr,index);
            
            break;
        }

        case Menu::DISPLAY_MANAGERS: {
            for (int i = 0; i < index; i++) {
                if (typeid(*arr[i])==typeid(Manager)) {
                    arr[i]->display();
                }
            }
            break;
        }

        case Menu::DISPLAY_SALESMAN: {
            for (int i = 0; i < index; i++) {
                if (typeid(*arr[i])==typeid(Salesman)) {
                    arr[i]->display();
                }
            }
            break;
        }

        case Menu::DISPLAY_SALESMANAGERS: {
            for (int i = 0; i < index; i++) {
                if (typeid(*arr[i])==typeid(Salesmanager)) {
                    arr[i]->display();
                }
            }
            break;
        }

        default:
            cout << "Wrong choice..."<<endl;
            break;
        }
    }
 
    for (int i = 0; i < index; i++) {
        delete arr[i];
        arr[i]=NULL;
    }

    return 0;
}