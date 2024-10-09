#include<iostream>
using namespace std;

enum AccountType
{
    Saving = 1,
    Current,
    DMAT
};

class InsufficientFundsException
{
   
     string message;

    public:

    InsufficientFundsException() : message(""){}

    InsufficientFundsException(string message)
    {
       
        this->message = message;
    }

    void Display()
    {
        cout<<"Invalid Values"<<endl;
        cout << "Message : " << message << endl;
    
    }
    

};


class Account
{
    AccountType type;
    int accno;
    string EAccountType;
    double balance;
    public: 

    Account()
    {
        accno = 0;
        EAccountType = " ";
        balance = 0;
    }


    Account(int accno,string EAccountType,double balance)
    {
        this->accno = accno;
        this->EAccountType=EAccountType;
        this->balance = balance;
    }

    void setAccno(int accno)
    {
        if(accno <=0 || accno < 9999999)
        {
            throw InsufficientFundsException("Invalid Accno");

        }

        this->accno = accno;
    }

    void setCurrentBalance(int balance)
    {
        if(balance <= 0  || balance < 10000000)
        {
            throw InsufficientFundsException("Insufficent Balance .... ");

        }

        this->balance = balance;

    }

    void setWithdrawAmmount(int no)
    {
        if(no > balance && no < 0)
        {
            throw InsufficientFundsException();

        }
    }

    void Accept()
    {
        
        cout<<"1.Saving "<<endl;
        cout<<"2.Current"<<endl;
        cout<<"3.DMAT"<<endl;

        int choice = 0;

        cout<<"Enter the Choice of account "<<endl;
        cin>>choice;

        this->Deposit();

    }

    void Deposit()
    {
        int Deposit = 0;

        cout<<"Enter the Deposit Amount:"<<endl;
        cin>>Deposit;

        if(Deposit  < 0 )
        {
            throw InsufficientFundsException("Enter the valid Deposit Amount");
        }

        balance = Deposit + balance;
        cout<<"Deposited SuccessFully !!! Current balance is "<<balance<<endl; 
    }

    void WithDraw()
    {
        int withdraw = 0;

        cout<<"Enter the Withdraw Amount:"<<endl;
        cin>>withdraw;

         if(withdraw < 0 )
        {
            throw InsufficientFundsException("Withdrawal Amount should be more than ZERO!!!");
        }

         if(withdraw > balance )
        {
            throw InsufficientFundsException("Insufficent Balanace !!");
        }
       
        balance = balance - withdraw;
        cout<<withdraw<<" Rupees withdrawal Succesfully!!! Current Balance is :"<<balance<<endl;
    }

    void Display()
    {
        switch (type)
        {
        case Saving :
        cout<<"Account Type = "<<Saving<<endl;
        break;

        case Current:
        cout<<"Account Type = "<<Current<<endl;
        break;

        case DMAT:
        cout<<"Account Type = "<<DMAT<<endl;
        break;
        
        }

        cout<<"Account Balance is :"<<balance<<endl;
        
    }

};

int main()
{
    try
    {

        Account s1;
        s1.setAccno(85296385);
        s1.Accept();
        s1.WithDraw();
        s1.Display();


    }

    catch(InsufficientFundsException e)
    {
        e.Display();

    }

    return 0;

}