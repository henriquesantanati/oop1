public class InvestmentAccount extends BankAccount {
    private double interestRate;

    public InvestmentAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance, AccountType.INVESTMENT);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }
}