
public class BankAccount {
	private double balance;
	private long accountNumber;
	private long pin;
	private User user;
	
	
	public BankAccount(long _balance, long _accountNumber, long _pin, User _user){
		balance = _balance;
		accountNumber = _accountNumber; // find last account number and add 1
		pin = _pin;
		user = _user;
	}
	
	public void setBalance(double _balance){
		balance = _balance;
	}
	
	public void setAccountNumber(long _accountNumber){
		accountNumber = _accountNumber;
	}
	
	public void setPin(long _pin){
		pin = _pin;
	}
	
	public void setUser(User _user){
		user = _user;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public long getAccountNumber(){
		return accountNumber;
	}
	
	public long getPin(){
		return pin;
	}
	
	public User getUser() {
		return user;
	}
	
	public void depositBalance(double deposit){
		balance = deposit + balance;
	}
	
}
