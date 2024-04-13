
public class CheckingAccount extends BankAccount {
	final double FEE = .15;
	public CheckingAccount(String name, double initial) {
		super(name, initial);
		super.setAccountNumber(super.getAccountNumber() + "-10");
		
	}
	public boolean withdraw(double amount) {
		amount += FEE;
		return super.withdraw(amount);
		
	}

}
