public class BankAccount {
    
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public BankAccount(String accountNumber) {
        this(accountNumber, 0.0);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
    }

    public double getBalance() {
        return balance;
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
