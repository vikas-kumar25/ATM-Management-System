import java.util.ArrayList;
import java.util.Scanner;

/**********************************************
 Developer Name: Vikas
 /**********************************************/
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("============================");
        System.out.println("      WELCOME TO ATM        ");
        System.out.println("============================\n");

        System.out.println("1. Enter PIN");
        System.out.println("2. Exit\n");

        System.out.println("Enter your choice: ");

        Scanner scn = new Scanner(System.in);
        int choice = scn.nextInt();

        switch (choice)
        {
            case 1:
                int attempts = 3;
                int pin = 1234;
                while (attempts > 0)
                {
                    System.out.println("Please Enter your PIN: ");
                    int enteredPin = scn.nextInt();
                    if (pin == enteredPin)
                    {
                        System.out.println("PIN verified Successfully \n");
                        int menu;
                        ArrayList<String> transactions = new ArrayList<>();
                        double balance = 10000.00;
                        do
                        {
                            System.out.println("================================");
                            System.out.println("             ATM MENU            ");
                            System.out.println("================================\n");

                            System.out.println("1. Check Balance");
                            System.out.println("2. Deposit Money");
                            System.out.println("3. Withdraw Money");
                            System.out.println("4. Change PIN");
                            System.out.println("5. Transaction History");
                            System.out.println("6. Exit\n");

                            System.out.println("Enter your choice: ");

                            menu = scn.nextInt();

                            switch (menu)
                            {
                                case 1:
                                    System.out.println("Available Balance:  " + balance + "\n");
                                    break;
                                case 2:
                                    System.out.print("Enter the Amount to be deposited:  ");
                                    double deposit = scn.nextDouble();
                                    if (deposit > 0)
                                    {
                                        balance = balance + deposit;
                                        transactions.add("Deposited: " + deposit + " | Balance:" + balance);
                                        System.out.println(deposit + " Deposited Successfully.\n");
                                    } else
                                    {
                                        transactions.add("Deposit: REJECTED");
                                        System.out.println("Enter a Valid Amount!");
                                    }

                                    break;
                                case 3:
                                    System.out.print("Enter the withdrawal amount:  ");
                                    double withdraw = scn.nextDouble();
                                    if (withdraw > 0 && withdraw <= balance)
                                    {
                                        balance = balance - withdraw;
                                        transactions.add("Withdrawal: " + withdraw + " | Balance:" + balance);
                                        System.out.println(withdraw + " withdrawal successfully.");
                                        System.out.println("Available Balance: " + balance);
                                    } else
                                    {
                                        transactions.add("Withdrawal: REJECTED");
                                        System.out.println("Enter a Valid Amount and Check balance.");
                                    }
                                    break;
                                case 4:
                                    System.out.println("Please Enter your 4-digit-pin");
                                    int reEnterPin = scn.nextInt();
                                    if (reEnterPin == pin)
                                    {
                                        System.out.print("Enter the New 4-digit-PIN: ");
                                        int newPIN = scn.nextInt();
                                        if (newPIN >= 1000 && newPIN <= 9999)
                                        {
                                            System.out.println();
                                            System.out.print("Please verify Your new 4-digit-PIN");
                                            int verifyPin = scn.nextInt();
                                            if (newPIN == verifyPin)
                                            {
                                                pin = newPIN;
                                                System.out.println("PIN Changed!");
                                            } else
                                            {
                                                System.out.println("PIN does not match");
                                            }
                                        } else
                                        {
                                            System.out.println("Enter a 4-digit-PIN");
                                        }
                                    } else
                                    {
                                        System.out.println("Incorrect current PIN!");
                                    }
                                    break;
                                case 5:
                                    System.out.println("Your Transactions Are: ");
                                    if (transactions.isEmpty())
                                    {
                                        System.out.println("No transactions found.");
                                    } else
                                    {
                                        for (int i = 0; i < transactions.size(); i++)
                                        {
                                            System.out.println(transactions.get(i));
                                        }
                                    }
                                    break;
                                case 6:
                                    System.out.println("Thank you for using our ATM!");
                                    break;
                                default:
                                    System.out.println("! Invalid Choice !");
                            }
                        } while (menu != 6);

                        break;
                    } else
                    {
                        System.out.println("Incorrect PIN!");
                        attempts--;
                        System.out.println("Attempts remaining: " + attempts);
                    }
                }
                if (attempts == 0)
                {
                    System.out.println("ATM session blocked!");
                }
                break;

            case 2:
                System.out.println("Thank you for using our ATM");
                break;
            default:
                System.out.println("!Invalid Choice!");
        }
    }
}