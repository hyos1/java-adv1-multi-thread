package thread.sync;

public class WithdrawTask implements Runnable {

    private final int amount;
    private final BankAccount bankAccount;

    public WithdrawTask(int amount, BankAccount bankAccount) {
        this.amount = amount;
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        bankAccount.withdraw(amount);
    }
}