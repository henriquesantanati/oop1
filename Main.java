public class Main {

    public static void main(String[] args){
        BankAccount account1 = new BankAccount("123456", 1000);
        BankAccount account2 = new BankAccount("789012");

        account1.deposit(500);
        account1.withdraw(200);
        System.out.println("Current balance: " + account1.getBalance());

        account1.transfer(account2, 300.0);
        System.out.println("Account 1 balance after transfer: " + account1.getBalance());
        System.out.println("Account 2 balance after transfer: " + account2.getBalance());

    }
}
