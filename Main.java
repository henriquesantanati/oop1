public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456", 1000);
        BankAccount account2 = new BankAccount("789012");
        InvestmentAccount investmentAccount = new InvestmentAccount("246810", 5000, 0.005);

        account1.deposit(500);
        try {
            account1.withdraw(200);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Current balance: " + account1.getBalance());

        try {
            account1.transfer(account2, 300.0);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Account 1 balance after transfer: " + account1.getBalance());
        System.out.println("Account 2 balance after transfer: " + account2.getBalance());

        investmentAccount.applyInterest();
        System.out.println("Investment account balance after interest: " + investmentAccount.getBalance());
    }
}