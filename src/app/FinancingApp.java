package app;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingApp {
	public static void main(String[] args) {
		try {
			Financing financing1 = FinancingFactory.createFinancyEntity(100000.00, 2000.00, 20 );
			System.out.println("Dados do financiamento 1: ");
			System.out.printf("Entrada : %.2f%n", financing1.entry());
			System.out.printf("Prestação: %.2f%n", financing1.quota());
		}catch (IllegalArgumentException e) {
			System.out.println("Erro no financiamento: " + e.getMessage());
		}
		
		
		try {
			Financing financing2 = FinancingFactory.createFinancyEntity(100000.00, 2000.00, 80 );
			System.out.println("Dados do financiamento 2: ");
			System.out.printf("Entrada : %.2f%n", financing2.entry());
			System.out.printf("Prestação: %.2f%n", financing2.quota());
		}catch (IllegalArgumentException e) {
			System.out.println("Erro no financiamento: " + e.getMessage());
		}
	}
}
