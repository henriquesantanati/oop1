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

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
    }

    public double getBalance(){
        return this.balance;
    }

    public void transfer(BankAccount recipient, double amount) throws InsufficientFundsException {
        withdraw(amount);
        recipient.deposit(amount);
    }

    public void transfer(String recipientAccountNumber, double amount) throws InsufficientFundsException {
        withdraw(amount);
        System.out.println("Transferring " + amount + " to account " + recipientAccountNumber);
    }
}
