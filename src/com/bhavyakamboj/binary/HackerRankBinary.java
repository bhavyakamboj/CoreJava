package com.bhavyakamboj.binary;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HackerRankBinary {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] binaryNum = new int[32]; 
        
        // counter for binary array 
        int i = 0; 
        while (n > 0)  
        { 
            // storing remainder in binary array 
            binaryNum[i] = n % 2; 
            n = n / 2; 
            i++; 
        } 
        int maxConsecutive = 0;
        int ones = 0;
        boolean zeroFound = false;
        for(int k = i-1; k >= 0; k--) {
        	System.out.print(binaryNum[k] + " " );
        }
        System.out.println();
        // printing binary array in reverse order 
        for (int j = i-1; j >= 0; j--) {
            if(binaryNum[j]==1) {
                ones++;
                if(ones >= maxConsecutive)
                	maxConsecutive = ones;
            } else {
                ones = 0;
                zeroFound = true;
            }
        }
        if(!zeroFound) {
        	maxConsecutive = ones;
        }
        
        System.out.println(maxConsecutive); 
                              
            scanner.close();
    }
}

