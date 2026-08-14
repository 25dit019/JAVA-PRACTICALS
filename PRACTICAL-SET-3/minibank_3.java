import java.util.Objects;

record BankInfo(String name, String branch) {}

enum MenuOption {
    OPEN_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    EXIT
}

public class minibank_3 {

    public static void main(String[] args) {

        BankInfo bank = new BankInfo("MiniBank", "Anand Branch");
        System.out.println(bank);
        System.out.println();

        Customer.Address address =
                new Customer.Address("MG Road", "Anand", "388001");

        Customer c1 = new Customer(
                "Dhairya",
                "dhairya@gmail.com",
                "9876543210",
                address
        );

        Account acc1 = new Account(c1.getName(), 5000);
        Account acc2 = new Account(c1.getName(), 5000);

        System.out.println(acc1);
        System.out.println(acc2);

        System.out.println("\nAre accounts equal? " + acc1.equals(acc2));

        Object obj = acc1;

        if (obj instanceof Account) {
            System.out.println("obj is an Account");
        }

        try {
            Customer copy = c1.clone();

            System.out.println("\nOriginal Customer : "
                    + c1.getCustomerId());

            System.out.println("Cloned Customer   : "
                    + copy.getCustomerId());

            System.out.println("City : "
                    + copy.getAddress().getCity());

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported.");
        }
    }
}

class Customer implements Cloneable {

    private String name;
    private String email;
    private String mobile;
    private final String customerId;
    private Address address;

    private static long customerCounter = 101;

    private static String generateCustomerId() {
        return "CUST" + customerCounter++;
    }

    public Customer(String name, String email,
                    String mobile, Address address) {

        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.customerId = generateCustomerId();
    }

    public static class Address {

        private String line;
        private String city;
        private String pincode;

        public Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        public String getLine() {
            return line;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }
    }

    @Override
    public Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Address getAddress() {
        return address;
    }
}

class Account {

    private final String accountNumber;
    private String ownerName;
    private long balance;

    private static long accountCounter = 1;

    private static String generateAccountNumber() {
        return String.format("AC%04d", accountCounter++);
    }

    public Account(String ownerName, long balance) {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public Account(String ownerName) {
        this(ownerName, 0);
    }

    @Override
    public String toString() {
        return accountNumber + " | " + ownerName + " | Rs " + balance;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Account))
            return false;

        Account other = (Account) obj;

        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}