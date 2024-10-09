#include <iostream>
#include <string>
using namespace std;

class Product {
protected:
    int id;
    string title;
    float price;
    
public:

    virtual float getDiscountedPrice() = 0;

    virtual void acceptDetails() {
        cout << "Enter ID: ";
        cin >> id;


        cout << "Enter Title: ";
       cin>>title;

        cout << "Enter Price: ";
        cin >> price;
    }

    virtual void displayDetails() {
        cout << "ID: " << id << "\nTitle: " << title << "\nPrice: " << price << endl;
    }

    
};


class Book : public Product {
    string author;

public:
    void acceptDetails()  {
        Product::acceptDetails();  
    
        cout << "Enter Author: ";
        cin>>author;
    }

    float getDiscountedPrice() {
        return price * 0.90;  
    }

    void displayDetails()  {
        Product::displayDetails();
        cout << "Author: " << author << "\nDiscount Price: " << getDiscountedPrice() << endl;
    }
};


class Tape : public Product {
    string artist;

public:
    void acceptDetails() {
        Product::acceptDetails(); 
        cin.ignore();
        cout << "Enter Artist: ";
        getline(cin, artist);
    }

    float getDiscountedPrice()  {
        return price * 0.95;  
    }

    void displayDetails() {
        Product::displayDetails();
        cout << "Artist: " << artist << "\nDiscounted Price: " << getDiscountedPrice() << endl;
    }
};

int main() {
    Product* arr[3];  
    int choice;
    float totalBill = 0;

    
    for (int i = 0; i < 3; ++i) {
        cout << "Enter details for product " << i + 1 << endl;
        cout << "Choose 1 for Book, 2 for Tape: ";
        cin >> choice;

        if (choice == 1) {
            arr[i] = new Book();
        } else if (choice == 2) {
            arr[i] = new Tape();
        } else {
            cout << "Wrong choice..\n";
            
           
        }

        arr[i]->acceptDetails();
    }

    cout << "\nPurchased Products:\n";
    for (int i = 0; i < 3; ++i) {
        arr[i]->displayDetails();
        totalBill += arr[i]->getDiscountedPrice();
    }

    cout << "\nTotal Bill: " << totalBill << endl;

    
    for (int i = 0; i < 3; ++i) {
        delete arr[i];
    }

    return 0;
}