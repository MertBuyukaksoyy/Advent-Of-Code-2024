/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adventofcodeday2;

import java.io.*;
import java.util.*;

/**
 *
 * @author MERT
 */
public class Adventofcodeday2 {

    public static void main(String[] args) {
 
        String fileName = "C:\\Users\\MERT\\Desktop\\AdventeofCode2024\\AdventeofCode2024\\adventofcodeday2\\day2.txt";
        List<int[]> list = new ArrayList<>(); 

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                int[] row = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    row[i] = Integer.parseInt(tokens[i]);
                }
                list.add(row);
            }
        } catch (IOException e) {
        }

        for (int[] row : list) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        int safe = 0;
        int safeWithRemoval = 0;
        
        for(int rowIndex = 0 ; rowIndex < list.size(); rowIndex++){
            int[] row = list.get(rowIndex);
            
            if(isRowSafe(row)){
                safe++;
            }
            if(isRowSafeWithDelete(row)){
                safeWithRemoval++;
            }
        }
        System.out.println("Number of safe rows  : " + safe);   
        System.out.println("Number of safe rows with bad level removal   : " + safeWithRemoval);
    }
   public static boolean isRowSafe(int[] row) {
        if (row.length < 2) return true;

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < row.length - 1; i++) {
            int diff = Math.abs(row[i + 1] - row[i]);

            if (diff < 1 || diff > 3) return false; 
            if (row[i + 1] < row[i]) increasing = false;
            if (row[i + 1] > row[i]) decreasing = false;
        }

        return increasing || decreasing;
    }

    public static boolean isRowSafeWithDelete(int[] row) {
        if (isRowSafe(row)) return true;

        for (int i = 0; i < row.length; i++) {
            int[] reducedRow = removeElement(row, i);
            if (isRowSafe(reducedRow)) {
                return true; 
            }
        }
        return false; 
    }

    public static int[] removeElement(int[] row, int indexToRemove) {
        int[] newRow = new int[row.length - 1];
        for (int i = 0, j = 0; i < row.length; i++) {
            if (i != indexToRemove) {
                newRow[j++] = row[i];
            }
        }
        return newRow;
    }
}