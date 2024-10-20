public class InvestmentAccount extends BankAccount {
    private double interestRate;

    public InvestmentAccount(String accountNumber, double initialBalance) {
        this(accountNumber, initialBalance, 0.005); // Default interest rate of 0.5%
    }

    public InvestmentAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance, AccountType.INVESTMENT);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        super.deposit(interest);
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Special handling for investment account deposit");
        super.deposit(amount); 
    }
}