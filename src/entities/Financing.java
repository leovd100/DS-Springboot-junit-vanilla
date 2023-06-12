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
			throw new IllegalArgumentException("Valor inválido de financiamento.");
		}
		this.totalAmount = totalAmont;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		if(income < 0 ) {
			throw new IllegalArgumentException("Valor de renda mensal é inválido.");
		}
		this.income = income;
	}
	public Integer getMonths() {
		return months;
	}
	public void setMonths(Integer months) {
		if(months < 0) {
			throw new IllegalArgumentException("Valor de meses é inválido.");
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
			throw new IllegalArgumentException("A parcela não pode ser maior do que a metade do salário.");
		}
	}
}
