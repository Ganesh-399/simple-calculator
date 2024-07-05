import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    public double checkBalance() {
        return balance;
    }
public class ATM {
    private BankAccount account;
    private Scanner scanner;
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        System.out.println("\n==== ATM Menu ====");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
    }
    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Your balance is: $" + account.checkBalance());
                    break;
                case "2":
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance is: $" + account.checkBalance());
                    } else {
                        System.out.println("Withdrawal failed. Insufficient funds.");
                    }
                    break;
                case "3":
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. Current balance is: $" + account.checkBalance());
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.run();
    }
}
