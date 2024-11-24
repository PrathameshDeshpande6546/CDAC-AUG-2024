#include <iostream>
#include <vector>
#include <string>

using namespace std;

// Class Product
class Product {
private:
    int id;
    string productName;
    double price;

public:
    Product(int id, string productName, double price) {
        this->id = id;
        this->productName = productName;
        this->price = price;
    }

    int getId() {
        return id;
    }

    string getProductName() {
        return productName;
    }

    double getPrice() {
        return price;
    }
};

// Class Person
class Person {
protected:
    string name;

public:
    Person(string name) {
        this->name = name;
    }

    string getName() {
        return name;
    }
};

// Class Customer (inherits from Person)
class Customer : public Person {
private:
    string mobile;
    vector<Product*> purchasedProducts;

public:
    Customer(string name, string mobile) : Person(name) {
        this->mobile = mobile;
    }

    string getMobile() {
        return mobile;
    }

    void addPurchasedProduct(Product* product) {
        purchasedProducts.push_back(product);
    }

    vector<Product*> getPurchasedProducts() {
        return purchasedProducts;
    }
};

// Function to display all products
void displayAllProducts(vector<Product*> products) {
    cout << "All Products:" << endl;
    for (Product* product : products) {
        cout << "ID: " << product->getId() << ", Name: " << product->getProductName() << ", Price: " << product->getPrice() << endl;
    }
}

// Function to create a new customer
Customer* newCustomer(vector<Customer*>& customers) {
    string name, mobile;
    cout << "Enter customer name: ";
    cin >> name;
    cout << "Enter customer mobile: ";
    cin >> mobile;
    Customer* customer = new Customer(name, mobile);
    customers.push_back(customer);
    return customer;
}

// Function to create a new product
Product* newProduct(vector<Product*>& products) {
    int id;
    string productName;
    double price;
    cout << "Enter product ID: ";
    cin >> id;
    cout << "Enter product name: ";
    cin >> productName;
    cout << "Enter product price: ";
    cin >> price;
    Product* product = new Product(id, productName, price);
    products.push_back(product);
    return product;
}

// Function to handle customer purchase
void customerPurchase(vector<Customer*>& customers, vector<Product*>& products) {
    int customerId, productId;
    cout << "Enter customer ID: ";
    cin >> customerId;
    cout << "Enter product ID: ";
    cin >> productId;

    Customer* customer = customers[customerId - 1];
    Product* product = products[productId - 1];

    customer->addPurchasedProduct(product);
    cout << "Product purchased successfully!" << endl;
}

// Function to display products purchased by a customer
void displayCustomerPurchases(vector<Customer*>& customers) {
    string mobile;
    cout << "Enter customer mobile: ";
    cin >> mobile;

    for (Customer* customer : customers) {
        if (customer->getMobile() == mobile) {
            vector<Product*> purchasedProducts = customer->getPurchasedProducts();
            cout << "Products purchased by " << customer->getName() << ":" << endl;
            for (Product* product : purchasedProducts) {
                cout << "ID: " << product->getId() << ", Name: " << product->getProductName() << ", Price: " << product->getPrice() << endl;
            }
            return;
        }
    }

    cout << "Customer not found!" << endl;
}

int main() {
    vector<Product*> products;
    vector<Customer*> customers;

    int choice;
    while (true) {
        cout << "Menu:" << endl;
        cout << "1. Display all products" << endl;
        cout << "2. New Customer" << endl;
        cout << "3. New product" << endl;
        cout << "4. Customer purchase the product" << endl;
        cout << "5. Display products purchased by a customer" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                displayAllProducts(products);
                break;
            case 2:
                newCustomer(customers);
                break;
            case 3:
                newProduct(products);
                break;
            case 4:
                customerPurchase(customers, products);
                break;
            case 5:
                displayCustomerPurchases(customers);
                break;
            default:
                cout << "Invalid choice!" << endl;
        }
    }

    return 0;
}