package com.voda.tenpin.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import com.voda.tenpin.exception.TenPinUtilityException;

/**
 * Class for all the utility methods 
 * for the TenPin Bowling
 * @author d.das
 *
 */
public class TenPinUtility {

	public static int[] tokenScoresofTenPin(String tenPinUtlityScore) throws TenPinUtilityException{
		int i=0;
		String[] tokens =  tenPinUtlityScore.split(" ");
		int[] arr=new int[tokens.length];
		if(tokens.length > 20){
			throw new TenPinUtilityException("You have entered more than maximum allowed attempts.Please enter a valid input.");
		}
		try{
			for(String token: tokens){
				int scoreValue = Integer.parseInt(token);
				TenPinUtility.checkScoreValue(scoreValue);
				arr[i]=Integer.parseInt(token);
				i++;
			}
		}catch(NumberFormatException ex){
			throw new TenPinUtilityException("The Format of the scores entered is incorrect.Please enter valid scores with a space between them.");
			
		}
			
		return arr;
	}
	
	private static int checkScoreValue(int scoreValue) throws TenPinUtilityException{
		if(scoreValue > 10) throw new TenPinUtilityException("Please make sure that you enter a value between 1 and 10 and a valid format with space.");
		return scoreValue;
		
		
	}
	
	public static List<Integer> prepareStrikeTenPinScoring(int[] arr) throws TenPinUtilityException{
		List<Integer> prepareScoringPinList = new ArrayList<Integer>();
		//System.out.println("arr.length" + arr.length);
		TenPinUtility.checkNumbers(arr);
		if(arr.length > 21){
			throw new TenPinUtilityException("You have entered more than maximum allowed attempts.Please enter a valid input.");
		}
		for(int i=0;i<arr.length;i++){
			TenPinUtility.checkScoreValue(arr[i]);
			if(arr[i] == 10){
				prepareScoringPinList.add(10);
				prepareScoringPinList.add(0);
				
			}else{
				prepareScoringPinList.add(arr[i]);
			}
		}
		return prepareScoringPinList;
	}
	
	private static void checkNumbers(int[] arr)  throws TenPinUtilityException {
		boolean checkNumber = false;
		//if(arr.length > 12){
			for(int i=0;i<arr.length;i++){
				if(arr.length > 12 && arr[i] == 10 ){
					checkNumber = true;
					break;
				}else{
					checkNumber = false;
				}
			}
		//}
		if(checkNumber == true){
			throw new TenPinUtilityException("You have entered more then maximum allowed attempts.Please enter a vaid input.");
		}
	}
	
	
	public static void checkMaxTreshold(int score1 , int score2, int location) throws TenPinUtilityException{
		int maxThreshold = 10 - score1;
		if(score2 > maxThreshold){
			throw new TenPinUtilityException("One of the scores has an invalid input.Please enter a a maximum value of " +  maxThreshold );
		}
	}
	
	
	public static void main(String [] args) throws TenPinUtilityException{
		int[] arr = {10,2,1,4};
		List<Integer> prepareScoringPinList = TenPinUtility.prepareStrikeTenPinScoring(arr);
		for(Integer element: prepareScoringPinList){
			System.out.println(" " + element);
		}
		//tenPinUtility.tokenScoresofTenPin();
	}
}
