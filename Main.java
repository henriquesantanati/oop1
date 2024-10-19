public class Main {
    public static void main(String[] args) {
        var account1 = new BankAccount("123456", 1000);
        var account2 = new BankAccount("789012");
        var investmentAccount = new InvestmentAccount("246810", 5000, 0.005);

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

        // Print transaction history for account1
        System.out.println("\nTransaction History for Account 1:");
        for (var transaction : account1.getTransactionHistory()) {
            System.out.println(transaction);
        }

        // Print transaction history for account2
        System.out.println("\nTransaction History for Account 2:");
        for (var transaction : account2.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}