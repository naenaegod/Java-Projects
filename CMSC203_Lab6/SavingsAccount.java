
public class SavingsAccount extends BankAccount {
	private double rate = 2.5;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double initial) {
		super(name, initial);
		this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		
	}
	public void postInterest() {
		super.deposit(((rate/100)/12)*super.getBalance());
	}
	public String getAccountNumber() {
		return this.accountNumber;
	}
	//copy constructor that adds the new account number with the initial balance
	public SavingsAccount(SavingsAccount oldAccount, double amount) {
		super(oldAccount, amount);
		savingsNumber = oldAccount.savingsNumber + 1;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		
	}

}
