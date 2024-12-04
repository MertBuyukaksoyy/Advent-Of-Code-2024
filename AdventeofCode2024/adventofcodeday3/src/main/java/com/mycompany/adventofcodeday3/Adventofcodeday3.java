/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adventofcodeday3;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

/**
 *
 * @author MERT
 */
public class Adventofcodeday3 {

    public static void main(String[] args) throws IOException {
        
        String filePath = "C:\\Users\\MERT\\Desktop\\Days\\day3.txt";
        String content = Files.readString(Paths.get(filePath));
        System.out.println(content);

        String regexMul = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regexMul);
        Matcher matcher1 = pattern.matcher(content);
        
        int sum = 0;
        List<String> validInstructions = new ArrayList<>();

        while (matcher1.find()) {
            int a = Integer.parseInt(matcher1.group(1));
            int b = Integer.parseInt(matcher1.group(2));
            sum += a * b;
            validInstructions.add(matcher1.group());
        }

        System.out.println("Valid Instructions: " + validInstructions);
        System.out.println("Sum of Results: " + sum);
      
        // PART 2
        boolean enabled = true;
        int sum2 = 0;
        List<String> validInstructions2 = new ArrayList<>();
        String regexDo = "do\\(\\)";
        String regexDont = "don't\\(\\)";

        Matcher matcher2 = Pattern.compile(regexDo + "|" + regexDont + "|" + regexMul).matcher(content);
        
        while(matcher2.find()){
            String match = matcher2.group();
            
            if(match.matches(regexDo)){
                enabled = true;
            }
            else if(match.matches(regexDont)){
                enabled = false;
            }
            else if(enabled && match.matches(regexMul)){
                Matcher mulMatcher = pattern.matcher(match);
                if(mulMatcher.matches()){
                    int a = Integer.parseInt(matcher2.group(1));
                    int b = Integer.parseInt(matcher2.group(2));
                    sum2 += a * b;
                    validInstructions2.add(match);
                }
            }
        }
        
        System.out.println("Valid Instructions For Part 2: " + validInstructions2);
        System.out.println("Sum of Results For Part 2: " + sum2);
        
        
    }
}