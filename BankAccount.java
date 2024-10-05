public class BankAccount {
    
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance){
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Construtor overloading for accounts without initialBalance parameter
    public BankAccount(String accountNumber){
        this(accountNumber, 0.0); // this() here will call the above constructor
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        if (amount <= this.balance){
            this.balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double getBalance(){
        return this.balance;
    }

    public void transfer(BankAccount recipient, double amount){
        if (amount <= this.balance){
            this.withdraw(amount);
            recipient.deposit(amount);
        } else {
            System.out.println("Insufficient funds for transfer");
        }
    }
}
