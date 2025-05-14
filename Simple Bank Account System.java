import java.util.Scanner;

class BankAccount {
    private String accountUsername;
    private String accountNumber;
    private double balance;

    // Using Private Class for Customer Personal Information
    // New Account
    public BankAccount(String name, String accNumber) {
        this.accountUserName = name;
        this.accountNumber = accNumber;
        this.balance = 0.0;
    }

    // Depositing into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdrawing money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Display account details
    public void displayAccountInfo() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountUserName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input to create account
        System.out.print("Enter account User name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();

        BankAccount myAccount = new BankAccount(name, accNumber);

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Info");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            // Using Switch Case to prevent Stealing.
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    myAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    myAccount.checkBalance();
                    break;
                case 4:
                    myAccount.displayAccountInfo();
                    break;
                case 5:
                    System.out.println("Thank you for Banking With Us.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
