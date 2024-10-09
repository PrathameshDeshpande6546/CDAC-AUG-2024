#include <iostream>
#include <vector>
using namespace std;

class Person
{
    string name;

public:
    Person()
    {
    }
    Person(string name)
    {               
        this->name = name;
    }
    virtual void accept()
    {
        cout << "Enter name - ";
        cin >> name;
    }
    virtual void display()
    {
        cout << "Name - " << name << endl;
    }
};

class Employee : public Person
{
    int empid;
    double salary;

public:
    Employee()
    {
    }
    Employee(int empid, string name, double salary) : Person(name)
    {
        this->empid = empid;
        this->salary = salary;
    }

    void accept()
    {
        cout << "Enter empid - ";
        cin >> empid;
        Person::accept();
        cout << "Enter salary - ";
        cin >> salary;
    }
    void display()
    {
        cout << "Empid - " << empid << endl;
        Person::display();
        cout << "Salary - " << salary << endl;
    }
    int getEmpId()
    {
        return empid;
    }
};

int findEmployee(vector<Person *> &personList)
{
    int id;
    cout << "Enter empid to search - ";
    cin >> id;
    for (int i = 0; i < personList.size(); i++)
    {
        // Employee *eptr = dynamic_cast<Employee *>(personList[i]);
        // if (eptr != NULL && id == eptr->getEmpId())
        //     return i;
         if (typeid(*personList[i]) == typeid(Employee))
    {
        Employee *eptr = (Employee *)personList[i];
        if (id == eptr->getEmpId())
             return i;
    }
    }
   
    return -1;
}

// To-Do -> Create a class student derived from the Person
// To-Do -> Implement the findStudent()
class Student:public Person{
    int rollno;
    double marks;

public:
Student(){
    rollno=0;
    marks=0.0;

}
Student(int rollno,double marks,string name):Person(name){
    this->rollno=rollno;
    this->marks=marks;

}

void accept(){
    cout<<"Enter Roll_No: "<<endl;
    cin>>rollno;
    Person::accept();
    cout<<"Enter Marks: "<<endl;
    cin>>marks;
}
void display(){
    cout<<"Roll No: "<<rollno<<endl;
    Person::display();
    cout<<"Marks: "<<marks<<endl;
}
int getRollno(){
    return rollno;
}

     
    

};
int findStudent(vector<Person *> &personList)
{
    int id;
    cout << "Enter rollno to search - ";
    cin >> id;
    for (int i = 0; i < personList.size(); i++)
    {
        // Student *sptr = dynamic_cast<Student *>(personList[i]);
        // if (sptr != NULL && id == sptr->getRollno())
        //     return i;

    if (typeid(*personList[i]) == typeid(Employee))
    {
        Employee *eptr = (Employee *)personList[i];
        if (id == eptr->getEmpId())
             return i;
    }

    }
    return -1;
}

int main()
{
    int choice;
    vector<Person *> personList;
    do
    {
        cout << "0. EXIT" << endl;
        cout << "1. Add Employee" << endl;
        cout << "2. Display Employees" << endl;
        cout << "3. Find Employee" << endl;
        cout << "4. Delete Employee" << endl;
        cout << "5. Add Student" << endl;
        cout << "6. Display Students" << endl;
        cout << "7. Find Student" << endl;
        cout << "8. Delete Student" << endl;

        // To-Do -> Add the similar above 4 cases for Student
        cout << "Enter the choice - ";
        cin >> choice;

        switch (choice)
        {
        case 0:
            cout << "Thank you for using the app..." << endl;
            break;
        case 1:
        {
            Employee *e = new Employee;
            e->accept();
            personList.push_back(e);
        }
        break;
        case 2:
            for (int i = 0; i < personList.size(); i++)
                if (typeid(*personList[i]) == typeid(Employee))
                    personList[i]->display();
            break;
        case 3:
        {
            int index = findEmployee(personList);
            if (index != -1)
                personList[index]->display();
            else
                cout << "Employee not found..." << endl;
        }
        break;
        case 4:
        {
            int index = findEmployee(personList);
            if (index != -1)
            {
                delete personList[index];
                personList.erase(personList.begin() + index);
            }
            else
                cout << "Incorrect Empid ..." << endl;
        }
        break;

        case 5:
        {
            Student *s = new Student;
            s->accept();
            personList.push_back(s);      
            }
        break;  

        case 6:
            for (int i = 0; i < personList.size(); i++)
                if (typeid(*personList[i]) == typeid(Student))
                    personList[i]->display();
            break;
    
    case 7:
            {
            int index = findStudent(personList);
            if (index != -1)
                personList[index]->display();
            else
                cout << "Student not found..." << endl;
        }
        break;

 case 8:
        {
            int index = findStudent(personList);
            if (index != -1)
            {
                delete personList[index];
                personList.erase(personList.begin() + index);
            }
            else
                cout << "Incorrect Rollno ..." << endl;
        }
        break;


        default:
            cout << "Wrong choice..." << endl;
            break;
        }

    } while (choice != 0);

    // to de allocate all the dynamic memory
    for (int i = 0; i < personList.size(); i++)
    {
        delete personList[i];
        personList[i] = NULL;
    }
    return 0;
}