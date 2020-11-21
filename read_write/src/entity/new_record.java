package entity;
import java.util.* ;
public class new_record {
	 private int account_number;
	 private String name;
	 private int balance;
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public new_record(int account_number, String name, int balance) {
		super();
		this.account_number = account_number;
		this.name = name;
		this.balance = balance;
	}
	public new_record() {
		super();
	}
	
	
     
}
