package org.howard.edu.lsp.assignment2.combination;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @class Combination 
 * Given an input list and a target sum, prints output as subsets of index of elements that add up to the target sum
 *
 */

public class Combination {

	  public static ArrayList<ArrayList> findCombinations(int [] input, int target){
	    //taking an integer array and an integer target as parameters
		  
		ArrayList <ArrayList> finalArr = new ArrayList<>();
	    //return type which is an Arraylist of Arraylists

	    for (int i = 0; i < input.length; i ++){
	      if (input[i] == target){
	        ArrayList <Integer> singleValue = new ArrayList<>(Arrays.asList(i));
	        finalArr.add(singleValue);
	        continue;
	        //in case a single number equals the target
	      }
	      
	      int tempSum = 0;
	      int runningSum = input[i];
	      tempSum += input[i];

	      ArrayList <Integer> innerArr = new ArrayList<>();
	      ArrayList <Integer> tempArr = new ArrayList<>();

	      innerArr.add(i);
	      tempArr.add(i);
	      //innerArr handles cases if two numbers add up to target
	      //tempArr handles cases if more than two numbers add up to target

	      for (int j = i + 1; j < input.length; j ++){

	        if (runningSum + input[j] < target){
	          tempArr.add(j);
	          tempSum += input[j];

	          if (tempSum == target){
	            
	            ArrayList <Integer> newArr = new ArrayList<>();
	            for (int indice = 0; indice < tempArr.size(); indice++) {
	            	newArr.add(tempArr.get(indice));
	            }

	            finalArr.add(newArr);
	            tempArr.remove(tempArr.size() - 1);
	            //removing the last element of the ArrayList in case there are duplicates of the most recent number
	         }
	        }	

	        else if (input[i] + input[j] == target){
	          innerArr.add(j);
	          
	          ArrayList <Integer> newArr = new ArrayList<>();
	          for (int indice = 0; indice < innerArr.size(); indice++) {
	          	newArr.add(innerArr.get(indice));
	          	//iterating through innerArr so that removing the last element doesn't affect the list
	          }
	          finalArr.add(newArr);
	          innerArr.remove(innerArr.size() - 1);
	        }
	      }
	    }
	    
	    return finalArr;
	    
	  }
	



	}