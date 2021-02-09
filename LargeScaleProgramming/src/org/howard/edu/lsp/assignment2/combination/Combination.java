package org.howard.edu.lsp.assignment2.combination;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination {

	  public static ArrayList<ArrayList> findCombinations(int [] input, int target){
	    ArrayList <ArrayList> finalArr = new ArrayList<>();
	    

	    for (int i = 0; i < input.length; i ++){
	      if (input[i] == target){
	        ArrayList <Integer> singleValue = new ArrayList<>(Arrays.asList(i));
	        finalArr.add(singleValue);
	        continue;
	      }
	      
	      int tempSum = 0;
	      int runningSum = input[i];
	      tempSum += input[i];

	      ArrayList <Integer> innerArr = new ArrayList<>();
	      ArrayList <Integer> tempArr = new ArrayList<>();

	      innerArr.add(i);
	      tempArr.add(i);

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
	         }
	        }	

	        else if (input[i] + input[j] == target){
	          innerArr.add(j);
	          
	          ArrayList <Integer> newArr = new ArrayList<>();
	          for (int indice = 0; indice < innerArr.size(); indice++) {
	          	newArr.add(innerArr.get(indice));
	          }
	          finalArr.add(newArr);
	          innerArr.remove(innerArr.size() - 1);
	        }
	      }
	    }
	    
	    return finalArr;
	    
	  }
	



	}


