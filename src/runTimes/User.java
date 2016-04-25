package runTimes;

public class User {

	public String name;
	public int accountBalance;
	
	public User(String name, int accountBalance){
		this.name=name;
		this.accountBalance = accountBalance;
	}
	
	public User() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
}
