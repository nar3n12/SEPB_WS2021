//WRITE YOUR ANSWER HERE
public class Account {
    private int accountNumber;
    private int pin;
    private double balance;

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public boolean debit(double amount, int pn) {
        if (checkSum(pn) == pin && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transferTo(Account to, double amount, int pn) {
        if (checkSum(pn) == pin && amount <= balance) {
            balance -= amount;
            to.balance += amount;
            return true;
        }
        return false;
    }

    public int checkSum(int num) {
        int sum;
        for (sum = 0; num != 0; num = num / 10) {
            sum += (num % 10);
        }
        return sum;
    }

    public Account(int an, int pn) {
        accountNumber = an;
        pin = checkSum(pn);
        balance = 0.0;
    }

    public static void main(String []args){
        Account petersAccount = new Account(1010101, 4567);
        System.out.println(petersAccount.getAccountNumber()); // returns 1010101
        System.out.println(petersAccount.getPin()); // returns 22
        petersAccount.credit(5000.0);
        System.out.println(petersAccount.getBalance()); // returns 5000.0
        System.out.println(petersAccount.debit(150.0, 4567)); // returns true
        System.out.println(petersAccount.debit(150.0, 4577)); // returns false (wrong pin)
        System.out.println(petersAccount.debit(5500.0, 4567)); // returns false (not enough money on the account)
        System.out.println(petersAccount.getBalance()); // returns 4850.0 (150 were debited once)
        Account sallysAccount = new Account(1010102, 9984);
        System.out.println(petersAccount.transferTo(sallysAccount, 563.5, 4567)); //returns true
        System.out.println(petersAccount.getBalance()); //returns 4286.5
        System.out.println(sallysAccount.getBalance()); //returns 563.5
    }

    }