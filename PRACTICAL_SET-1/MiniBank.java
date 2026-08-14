import java.util.Scanner;

class Customer {

    private String name;
    private String email;
    private String mobile;
    private final String customerId;

    private static long customerCounter = 101;

    private static String generateCustomerId() {
        return "CUST" + customerCounter++;
    }

    public Customer(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.customerId = generateCustomerId();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCustomerId() {
        return customerId;
    }
}

class Account {

    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    private static int accountCounter = 1;

    private static String generateAccountNumber() {
        return String.format("AC%04d", accountCounter++);
    }

    public Account(String ownerName, long openingBalance) {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = openingBalance;
        this.active = true;
    }

    public Account(String ownerName) {
        this(ownerName, 0);
    }

    public void deposit(long amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(long amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }
}

public class MiniBank {

    record BankInfo(String name, String branch) {
    }

    enum MenuOption {
        OPEN_ACCOUNT,
        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        EXIT
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("MiniBank", "Main Branch");

        System.out.println("===== " + bank.name() + " =====");
        System.out.println("Branch: " + bank.branch());

        Customer c1 = new Customer("Parth", "parth@gmail.com", "9876543210");
        Customer c2 = new Customer("Rahul", "rahul@gmail.com", "9876500000");
        Customer c3 = new Customer("Amit", "amit@gmail.com", "9999999999");

        Account[] accounts = new Account[3];

        accounts[0] = new Account(c1.getName(), 5000);
        accounts[1] = new Account(c2.getName());
        accounts[2] = new Account(c3.getName(), 10000);

        accounts[0].deposit(1000);
        accounts[0].withdraw(2000);

        accounts[1].deposit(3000);
        accounts[1].withdraw(500);

        accounts[2].withdraw(15000);
        accounts[2].deposit(500);

        System.out.println("Account Details");

        for (Account acc : accounts) {
            System.out.println("Account No : " + acc.getAccountNumber());
            System.out.println("Owner      : " + acc.getOwnerName());
            System.out.println("Balance    : Rs. " + acc.getBalance());
            System.out.println("Active     : " + acc.isActive());
            System.out.println();
        }

        int choice;

        do {
            System.out.println("\n1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 5) {

                MenuOption option = switch (choice) {
                    case 1 -> MenuOption.OPEN_ACCOUNT;
                    case 2 -> MenuOption.DEPOSIT;
                    case 3 -> MenuOption.WITHDRAW;
                    case 4 -> MenuOption.TRANSFER;
                    default -> MenuOption.EXIT;
                };

                switch (option) {
                    case OPEN_ACCOUNT ->
                        System.out.println("Open Account - to be implemented in a later lab");

                    case DEPOSIT ->
                        System.out.println("Deposit - to be implemented in a later lab");

                    case WITHDRAW ->
                        System.out.println("Withdraw - to be implemented in a later lab");

                    case TRANSFER ->
                        System.out.println("Transfer - to be implemented in a later lab");

                    case EXIT ->
                        System.out.println("Exiting MiniBank...");
                }

            } else {
                System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        System.out.println("Thank you for using MiniBank!");

        sc.close();
    }
}