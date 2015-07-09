package com.voda.tenpin.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.voda.tenpin.classes.TenPinScoreCalculator;
import com.voda.tenpin.exception.TenPinUtilityException;
import com.voda.tenpin.utils.TenPinUtility;

public class TenPinJUnit {

	
	/**
	 * Basic Scoring Test
	 * @throws TenPinUtilityException
	 */
	@Test
	public void tenPinBasicScoreTest() throws TenPinUtilityException {
		TenPinScoreCalculator tenPinScoreCalculator = new TenPinScoreCalculator();
		int[] arr = {1,2,3,4,5};
		int actualOutput1 = tenPinScoreCalculator.calculateStrikeTenPinScoring(arr);
		assertEquals(15, actualOutput1);
	}
	
	
	/**
	 * Spare Scoring Test
	 * @throws TenPinUtilityException
	 */
	@Test
	public void tenPinSpareScoreTest() throws TenPinUtilityException {
		TenPinScoreCalculator tenPinScoreCalculator = new TenPinScoreCalculator();
		int[] arr = {1,9,1,9,1};
		int actualOutput2 = tenPinScoreCalculator.calculateStrikeTenPinScoring(arr);
		assertEquals(23, actualOutput2);
	}

	
	/**
	 * Strike Scoring Test
	 * @throws TenPinUtilityException
	 */
	@Test
	public void tenPinSrikeScoreTest() throws TenPinUtilityException {
		TenPinScoreCalculator tenPinScoreCalculator = new TenPinScoreCalculator();
		int[] arr = {1,1,10,1,1,10};
		int actualOutput2 = tenPinScoreCalculator.calculateStrikeTenPinScoring(arr);
		assertEquals(26, actualOutput2);
	}
	
	/**
	 * Excess attempt test
	 */
	@Test
	public void tenPinxcessNumberTest()  {
		String message = "";
		TenPinScoreCalculator tenPinScoreCalculator = new TenPinScoreCalculator();
		int[] arr = {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2};
		try {
		
			System.out.print("Total Score " + tenPinScoreCalculator.calculateStrikeTenPinScoring(arr));	
		} catch (TenPinUtilityException ex) {
			// TODO Auto-generated catch block
			message = ex.getMessage();
		}
		
		assertEquals("You have entered more than maximum allowed attempts.Please enter a valid input.",message);
	}
	
	/**
	 * Invalid format error
	 */
	@Test
	public void tenPinInvalidInputNumberTest()  {
		String message = "";
		TenPinScoreCalculator tenPinScoreCalculator = new TenPinScoreCalculator();
		int[] arr = {1,14,1,2,1};
		try {
		
			System.out.print("Total Score " + tenPinScoreCalculator.calculateStrikeTenPinScoring(arr));	
		} catch (TenPinUtilityException ex) {
			// TODO Auto-generated catch block
			message = ex.getMessage();
		}
		
		assertEquals("Please make sure that you enter a value between 1 and 10 and a valid format with space.",message);
	}
	
	/**
	 * Max Score Test 
	 * @throws TenPinUtilityException 
	 * 
	 */
	@Test
	public void tenPinMaxValueTest() throws TenPinUtilityException  {
		
		TenPinScoreCalculator tenPinScoreCalculator = new TenPinScoreCalculator();
		int[] arr = {10,10,10,10,10,10,10,10,10,10,10,10};
		int actualOutput2;
		
		actualOutput2 = tenPinScoreCalculator.calculateStrikeTenPinScoring(arr);
		assertEquals(300,actualOutput2);
	}
	
	/**
	 * Null Test
	 */
	@Test
	public void tenPinNullTest() throws TenPinUtilityException  {
		String message = "";
		TenPinScoreCalculator tenPinScoreCalculator = new TenPinScoreCalculator();
		//int[] arr = {10,10,10,10,10,10,10,10,10,10,10,10};
		int actualOutput2;
		
		int[] arr = {1,14,1,2,1};
		try {
		
			System.out.print("Total Score " + tenPinScoreCalculator.calculateStrikeTenPinScoring(arr));	
		} catch (TenPinUtilityException ex) {
			// TODO Auto-generated catch block
			message = ex.getMessage();
		}
		assertEquals("Please make sure that you enter a value between 1 and 10 and a valid format with space.",message);
	}
}
