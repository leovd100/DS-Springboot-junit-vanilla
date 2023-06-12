package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	@Test
	public void depositShouldEncreaseBalaceAndDicountFeeWhenPositiveAmount() {
		double amount = 200.00;
		double expectedValue = 196.00;
		Account acc = AccountFactory.createEmptyAccount();
		
		
		acc.deposity(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.00;
		
		acc.deposity(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void fullWithdrawnShouldClearBalance() {
		double expectedValue = 0.0;
		double initialBalance = 800.00;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertEquals(result, initialBalance);
	}
	
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		Account acc = AccountFactory.createAccount(800.00);
		
		acc.withdraw(500.00);
		
		Assertions.assertEquals(300, acc.getBalance());
		
	}
	
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.00);
			
			acc.withdraw(801.00);
		});
	}
	

	
	
}
