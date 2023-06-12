package entities;

public class Financing {
	
	
	private Double totalAmount;
	private Double income;
	private Integer months;
	

	
	public Financing(Double totalAmont, Double income, Integer months) {
		validateFinancing(totalAmont, income, months);
		this.totalAmount = totalAmont;
		this.income = income;
		this.months = months;
	}



	public Double getTotalAmont() {
		return totalAmount;
	}
	public void setTotalAmont(Double totalAmont) {
		if(totalAmont < 0) {
			throw new IllegalArgumentException("Valor inv�lido de financiamento.");
		}
		this.totalAmount = totalAmont;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		if(income < 0 ) {
			throw new IllegalArgumentException("Valor de renda mensal � inv�lido.");
		}
		this.income = income;
	}
	public Integer getMonths() {
		return months;
	}
	public void setMonths(Integer months) {
		if(months < 0) {
			throw new IllegalArgumentException("Valor de meses � inv�lido.");
		}
		this.months = months;
	}
	
	
	public Double entry() {
		return totalAmount * 0.2;
	}
	
	public Double quota() {
		return (totalAmount - entry()) / months;
	}

	
	
	public void validateFinancing(Double totalAmont, Double income, Integer months) {
		if(totalAmont * 0.8 / months > income / 2.0) {
			throw new IllegalArgumentException("A parcela n�o pode ser maior do que a metade do sal�rio.");
		}
	}
}
