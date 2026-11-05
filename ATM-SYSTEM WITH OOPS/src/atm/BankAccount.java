package atm;

/**********************************************
 Developer Name: Vikas
 /**********************************************/
public class BankAccount
{
    private double balance;

    public BankAccount(double balance)
    {
        if (balance >= 0)
        {

            this.balance = balance;
        } else
        {
            this.balance = 0;
        }
    }

    // CHECK BALANCE---------------
    public double checkBalance()
    {
        return balance;
    }

    //DEPOSIT-----------------------
    public boolean deposit(double amount)
    {

        if (amount > 0)
        {
            balance += amount;
            return true;
        } else
        {
            return false;
        }
    }

    //WITHDRAW-------------------
    public boolean withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            return true;
        } else
        {
            return false;
        }

    }

}

