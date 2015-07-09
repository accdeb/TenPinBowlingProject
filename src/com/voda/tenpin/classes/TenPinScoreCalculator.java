package com.voda.tenpin.classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import com.voda.tenpin.exception.TenPinUtilityException;
import com.voda.tenpin.utils.TenPinUtility;

/**
 * THis is the class that calculates the score for a ten Pin Bowling
 * For a single Player with basic scoring, strike or spare.
 * If a player has not finished his game then it assumes the rest of the scores
 * to be 0.
 * Ten Pin Bowling class
 * @author d.das
 *
 */
public class TenPinScoreCalculator {
	
	/**
	 * 
	 * @param arr
	 * @return
	 * @throws TenPinUtilityException 
	 */
	public int calculateStrikeTenPinScoring(int[] arr) throws TenPinUtilityException{
		int totalScore = 0;
		int score1 = 0;
		int score2 = 0;
		//get the list with 0 appended 
		List<Integer> prepareScoringPinList = TenPinUtility.prepareStrikeTenPinScoring(arr);
		for(int counter=0; counter < prepareScoringPinList.size(); counter = counter+2){
			int bonus1 = 0;
			int bonus2 = 0;
			int bonus = 0;
			score1 = prepareScoringPinList.get(counter);
			if(score1 == 10){ 
				if(counter == prepareScoringPinList.size()-2){ // end of the line with strike
					bonus1 = 0; bonus2 = 0;
				if(counter == prepareScoringPinList.size()-2 && counter == 20)
					return 290;
				if(counter == 22)
					continue;
				}else{
					bonus1 = prepareScoringPinList.get(counter+2);
					if(bonus1 == 10){
						if( (counter+2) == ( prepareScoringPinList.size()-2)){ //end of the line with a Strike
							bonus2 = 0;
							if(counter+2 == 22)
							continue;
						}else{
							bonus2 = prepareScoringPinList.get(counter+4);
						}
					}else{
						if (counter+2 == (prepareScoringPinList.size()-1)){
							bonus2=0;
						}else{
							bonus2 = prepareScoringPinList.get(counter+3);
							if(counter == 18){
								totalScore = totalScore + score1+bonus1+bonus2;
								break;
							}
						}
					}
				}
				totalScore = totalScore + score1+bonus1+bonus2;
			}else{
				if(counter == prepareScoringPinList.size()-1){
					score2 = 0; // end of each game
				}else{
					score2 = prepareScoringPinList.get(counter+1);
				}
				TenPinUtility.checkMaxTreshold(score1, score2, counter+2);
				if(score1+score2 == 10 && counter < prepareScoringPinList.size()-1){ // spare logic
					if(prepareScoringPinList.size() % 2 == 0 &&  counter == prepareScoringPinList.size()-2)
						bonus = 0;
					else
						bonus = prepareScoringPinList.get(counter+2);
				}
				totalScore = totalScore+score1+score2+bonus;
			}
		}
		return totalScore;
	}
	
	
	
	public static void main(String [] args){
		TenPinScoreCalculator tenPinScoreCalculator = new TenPinScoreCalculator();
		System.out.println("Please the scores for the Bowling: ");
 		@SuppressWarnings("resource")
		Scanner inputReader = new Scanner(System.in);
 		String tenPingBowling = inputReader.nextLine();
 		System.out.println(tenPingBowling);
 		try {
			int[] arrayofScores = TenPinUtility.tokenScoresofTenPin(tenPingBowling);
			System.out.print("Total Calculated Score: " + tenPinScoreCalculator.calculateStrikeTenPinScoring(arrayofScores));	
		} catch (TenPinUtilityException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
		}
 	}

}
