/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adventofcodeday1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 *
 * @author MERT
 */
public class Adventofcodeday1 {

    public static void main(String[] args) {
        
        
           String filePath = "C:\\Users\\MERT\\Desktop\\New Text Document.txt";
        
        List<Integer> column1 = new ArrayList<>();
        List<Integer> column2 = new ArrayList<>();    
               
        readIntegersFromFile(filePath, column1, column2);
        
        System.out.println("Column 1: " + column1);
        System.out.println("Column 2: " + column2);

        Collections.sort(column1);
        Collections.sort(column2);
        System.out.println("Column1 sorted: " + column1);
        System.out.println("Column2 sorted: " + column2);
        
        //day 1 part 1
        List<Integer> subres = new ArrayList<>();
        for(int i =0;i<column1.size();i++){
            subres.add(column2.get(i) - column1.get(i));
        }
        System.out.println("result list for substraction: " + subres);
        
        int sum = 0;
        
        for(int i=0;i<subres.size();i++){
            subres.set(i,Math.abs(subres.get(i))); // transform negative numbers to positive     
            sum = sum + subres.get(i);
        }
        System.out.println("Result of distance : " + sum);
        
        
        //day 1 part 2 with hashmap
        
        HashMap<Integer, Integer> map = new HashMap();  
        for(int num: column2){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        System.out.println("hashmap: " +map);
        
        
        int sum1 = 0;
        
        for(int num1: column1){
            int count = map.getOrDefault(num1, 0);
            sum1 += count*num1;
        }
        System.out.println("Result with hashmap : " + sum1);
        
        //day 1 part 2 without hasmap
        int totalSum = 0;
        for(int num1 : column1){
            int count = 0;
            for(int num2 : column2){
                if(num2 == num1){
                    count++;
                }
            }
            totalSum += count * num1;
        }
        
        System.out.println("Result 2: " + totalSum);
        
        
    }

    public static void readIntegersFromFile(String filePath, List<Integer> column1, List<Integer> column2) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+"); 
                
                if (parts.length == 2) {
                    try {
                        column1.add(Integer.valueOf(parts[0]));
                        column2.add(Integer.valueOf(parts[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + line);
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
        }
    }
    
    
}