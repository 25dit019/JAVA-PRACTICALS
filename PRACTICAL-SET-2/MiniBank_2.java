record BankInfo(String name, String branch) {}
enum MenuOption {
    OPEN_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    EXIT
}
public class MiniBank_2{
        public static void main(String[] args) {
        BankInfo bank = new BankInfo("MiniBank", "Anand Branch");
        System.out.println("MINI BANK APPLICATION");
        System.out.println(bank);
        System.out.println();
        Customer c1 = new Customer("Dhairya", "dhairya@gmail.com", "9876543210");
        Customer c2 = new Customer("Rahul", "rahul@gmail.com", "9876501234");
        Customer c3 = new Customer("Priya", "priya@gmail.com", "9988776655");
        Account[] accounts = {
                new Account(c1.getName(), 5000),
                new Account(c2.getName(), 0),
                new Account(c3.getName(), 10000)
        };
        
accounts[0].deposit(2000);
        accounts[0].withdraw(1000);
        accounts[1].deposit(3000);
        accounts[1].withdraw(500);
        accounts[2].withdraw(12000);
        accounts[2].deposit(1500);
        System.out.println("Account Details");
        for (Account acc : accounts) {
            System.out.println("Account Number : " + acc.getAccountNumber());
            System.out.println("Owner          : " + acc.getOwnerName());
            System.out.println("Balance        : Rs" + acc.getBalance());
            System.out.println();
        }
    }
}

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
    private static long accountCounter = 1;
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
        balance += amount;
    }
    public boolean withdraw(long amount) {
        if (balance >= amount) {
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