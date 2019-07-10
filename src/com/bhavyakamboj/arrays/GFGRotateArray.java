package com.bhavyakamboj.arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

public class GFGRotateArray {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 int t = Integer.parseInt(sc.nextLine().split("")[0]);
		 for(int i = 0; i < t; i++) {
			 String[] arr =sc.nextLine().split(" ");
			 int n = Integer.parseInt(arr[0]);
			 int d = Integer.parseInt(arr[1]);
			 
		    String[] rawInput = sc.nextLine().split(" ");
		    int[] input = new int[rawInput.length];
		    for(int j=0; j<rawInput.length; j++){
		        input[j] = Integer.parseInt(rawInput[j]);
//		        System.out.println(input[j]);
		        }
		    
		 // now rotate the array by d elements
			 int[] temp = new int[d]; //d=2, n=5
			 for(int k = 0; k < d; k++) {
				 temp[k] = input[k]; // [0,1]
     	    }
			 
			for(int k = 0; k < input.length - d; k++) {
				input[k] = input[k+d]; // [0,1,2] = [2,3,4]
			}
			
			for(int k=input.length-d; k < input.length; k++) { // 3, 5
				 input[k] = temp[k-d-1]; // [3,4] = [3-2-1,4-2-1]
    	    }
			
			for(int ele: input) {
				System.out.printf("%d ", ele);
			}
			
			System.out.println();
		 }
	 }
}

