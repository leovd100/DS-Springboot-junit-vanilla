package tests.entities;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTest {
	
	Financing financing;
	
	
	@BeforeEach
	public void setUp() {
		Double totalAmount = 10000.00;
		Double income = 2000.00;
		Integer months = 80;
		
		financing = FinancingFactory.createFinancyEntity(totalAmount, income, months);
		
	}
	
	
	
	@Test
	public void constructorShouldCreateAValidFinancialObject () {
		
		Assertions.assertNotNull(financing);
	}
	
	@Test
	public void constructorShouldThrowExceptionWhenCreateAFinancialObject() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Double totalAmount = 100000.00;
			Double income = 2000.00;
			Integer months = 20;
			
			FinancingFactory.createFinancyEntity(totalAmount, income, months );
		});
	}
	
	@Test
	public void totalAmountShouldUpdateValue() {
		Double newAmount = 80000.00;
		
		financing.setTotalAmont(newAmount);
		
		Assertions.assertEquals(financing.getTotalAmont(), newAmount);
		
	}
	
	@Test
	public void totalAmountShouldThrowExceptionWhenUpdateValue() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			Double newAmount = -3500.00;
			financing.setTotalAmont(newAmount);
			
			
		});
	}
	
	
	@Test
	public void incomeShouldChangeValueWhenInsertANewValue() {
		Double newIncome = 3000.00;
		financing.setIncome(newIncome);
		Assertions.assertEquals(financing.getIncome(), newIncome);
	}
	
	@Test
	public void incomeShouldThrowExceptionWhenInsertValue() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			Double newIncome = -3000.00;
			financing.setIncome(newIncome);
		});
	}
	
	@Test
	public void monthsShouldChangeValueWhenInsertANewValue() {
		Integer months = 90;
		financing.setMonths(months);
		Assertions.assertEquals(financing.getMonths(), months);
	}
	
	@Test
	public void monthsShouldThorwExceptionWhenInsertValue() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Integer months = -90;
			financing.setMonths(months);
		});
	}
	
	@Test
	public void entryShouldCalculateWhenEntryValuesInConstructor() {
		Double totalAmount = 10000.00;
		Double income = 2000.00;
		Integer months = 80;
		
		Financing financingEntity = FinancingFactory.createFinancyEntity(totalAmount, income, months);
		Double entryValue = financingEntity.getTotalAmont() * 0.2;
		
		
		Assertions.assertEquals(entryValue, financingEntity.entry());
		
	}
	
	@Test
	public void quotaShouldCalculateCorrectValueWhenCalled() {
		
		Double totalAmount = 10000.00;
		Double income = 2000.00;
		Integer months = 80;
		
		Financing financingEntity = FinancingFactory.createFinancyEntity(totalAmount, income, months);
		Double quotaExpected = (totalAmount - financing.entry()) / months; 

		
		
		Assertions.assertEquals(quotaExpected, financingEntity.quota());
	}
	
}
