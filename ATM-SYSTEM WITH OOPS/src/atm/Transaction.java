package atm;

/**********************************************
 Developer Name: Vikas
 /**********************************************/
public class Transaction
{
    private final String type;
    private final double amount;
    private final double balanceAfter;

    public Transaction(String type, double amount, double balanceAfter)
    {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public double getBalanceAfter()
    {
        return balanceAfter;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getType()
    {
        return type;
    }


}
