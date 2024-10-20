import java.util.ArrayList;
import java.util.List;
public class BankAccount {
    
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;
    private AccountType accountType;

    public BankAccount(String accountNumber, double initialBalance, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.accountType = accountType;
    }

    public BankAccount(String accountNumber, AccountType accountType) {
        this(accountNumber, 0.0, accountType);
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.addTransaction("Deposit: " + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            this.balance -= amount;
            this.addTransaction("Withdrawal: " + amount);
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public void transfer(BankAccount recipient, double amount) throws InsufficientFundsException {
        withdraw(amount);
        recipient.deposit(amount);
        this.addTransaction("Transfer to " + recipient.accountNumber + ": " + amount);
    }

    public void transfer(String recipientExternalAccountNumber, double amount) throws InsufficientFundsException {
        this.withdraw(amount);
        this.addTransaction("Transfer to " + recipientExternalAccountNumber + ": " + amount);
        System.out.println("Transferring " + amount + " to account " + recipientExternalAccountNumber);
    }

    @Override
    public String toString() {
        return "Account " + accountNumber + " (" + accountType + "): Balance = " + balance;
    }
    
    private void addTransaction(String transaction) {
        this.transactionHistory.add(transaction);
    }

    public List<String> getTransactionHistory() {
        return new ArrayList<>(this.transactionHistory);
    }
}
