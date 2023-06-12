package tests.factory;

import entities.Financing;

public class FinancingFactory {
	public static Financing createFinancyEntity(Double totalAmont, Double income, Integer months) {
		return new Financing(totalAmont, income, months);
	}
}
