package atm;

import java.util.ArrayList;
import java.util.Scanner;

/*******************************
 Developer Name: Vikas
 *******************************/
public class ATM
{

    private final Scanner scn = new Scanner(System.in);

    // Connecting to BankAccount class
    private final BankAccount account = new BankAccount(10000);

    // Connecting to User class
    private final User user = new User("vikas", 1234);

    // Connecting to Transaction class
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    private int choice;

    // ATM STARTS FROM HERE
    public void start()
    {

        int attempts = 3;
        boolean isVerified = false;

        while (attempts > 0)
        {

            if (verifyPin())
            {
                System.out.println("PIN verified successfully.");
                System.out.println("Welcome, " + user.getName());

                isVerified = true;
                break;

            } else
            {
                attempts--;
                System.out.println("Incorrect PIN.");
                System.out.println("Attempts remaining: " + attempts);
            }
        }

        if (isVerified)
        {

            do
            {
                showMenu();

                switch (choice)
                {

                    case 1:
                        checkBalance();
                        break;

                    case 2:
                        deposit();
                        break;

                    case 3:
                        withdraw();
                        break;

                    case 4:
                        changeUserPin();
                        break;

                    case 5:
                        transactionHistory();
                        break;

                    case 6:
                        System.out.println("Thank you for using our ATM");
                        break;

                    default:
                        System.out.println("Please, Enter a Valid choice.");
                }

            } while (choice != 6);

        } else
        {
            System.out.println("ATM access blocked.");
        }
    }

    // Check Balance
    public void checkBalance()
    {
        System.out.println("Available Balance: " + account.checkBalance());
    }

    // Deposit
    public void deposit()
    {

        System.out.print("Enter the Amount to be deposited: ");
        double depositAmount = scn.nextDouble();

        boolean status = account.deposit(depositAmount);

        if (status)
        {

            Transaction transaction = new Transaction(
                    "Deposit",
                    depositAmount,
                    account.checkBalance()
            );

            transactions.add(transaction);

            System.out.println(
                    depositAmount + " Deposited Successfully | Balance: "
                            + account.checkBalance()
            );

        } else
        {
            System.out.println(depositAmount + " is not Valid");
        }
    }

    // Withdraw
    public void withdraw()
    {

        System.out.print("Enter the Amount to be Withdrawn: ");
        double withdrawAmount = scn.nextDouble();

        boolean status = account.withdraw(withdrawAmount);

        if (status)
        {

            Transaction transaction = new Transaction(
                    "Withdraw",
                    withdrawAmount,
                    account.checkBalance()
            );

            transactions.add(transaction);

            System.out.println(
                    withdrawAmount + " Withdrawn Successfully | Balance: "
                            + account.checkBalance()
            );

        } else
        {
            System.out.println(withdrawAmount + " is not Valid");
        }
    }

    // PIN Verification
    public boolean verifyPin()
    {

        System.out.print("Enter your PIN: ");
        int enteredPin = scn.nextInt();

        return user.verifyPin(enteredPin);
    }

    // Change PIN
    public void changeUserPin()
    {

        System.out.print("Enter your current PIN: ");
        int currentPin = scn.nextInt();

        System.out.print("Enter your new 4-digit PIN: ");
        int newPin = scn.nextInt();

        System.out.print("Confirm your new PIN: ");
        int confirmPin = scn.nextInt();

        if (newPin != confirmPin)
        {
            System.out.println("New PIN and confirmation PIN do not match.");
            return;
        }

        boolean status = user.changePin(currentPin, newPin);

        if (status)
        {
            System.out.println("PIN changed successfully!");
        } else
        {
            System.out.println("Incorrect current PIN or invalid new PIN.");
        }
    }

    // Transaction History
    private void transactionHistory()
    {

        if (transactions.isEmpty())
        {
            System.out.println("No transactions found.");

        } else
        {

            System.out.println("Transaction History:");

            for (int i = 0; i < transactions.size(); i++)
            {

                Transaction transaction = transactions.get(i);

                System.out.println("\nTransaction No: " + (i + 1));
                System.out.println("Type: " + transaction.getType());
                System.out.println("Amount: " + transaction.getAmount());
                System.out.println(
                        "Balance After Transaction: "
                                + transaction.getBalanceAfter()
                );

                System.out.println("-----------------------------------------");
            }
        }
    }

    // ATM MENU
    public void showMenu()
    {

        System.out.println("================================");
        System.out.println("             ATM MENU            ");
        System.out.println("================================\n");

        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change PIN");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit\n");

        System.out.print("Enter your choice: ");
        choice = scn.nextInt();
    }
}
