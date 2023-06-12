package entities;

public class Account {
	private Long id;
	private Double balance;
	
	private static double DEPOSITY_PER_PERCENT = 0.02;
	public Account() {}


	public Account(Long id, Double balance) {
		this.id = id;
		this.balance = balance;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getBalance() {
		return balance;
	}

	public void deposity(Double amount) {
		if(amount > 0) {
			this.balance +=  amount - amount * DEPOSITY_PER_PERCENT;
		}
	}
	
	public void withdraw (Double amount) {
		if(amount > balance) {
			throw new IllegalArgumentException();
		}
		this.balance -= amount;
	}
	
	public double fullWithdraw() {
		double aux = this.balance;
		balance = 0.0;
		return aux;
		
	}
	
}
