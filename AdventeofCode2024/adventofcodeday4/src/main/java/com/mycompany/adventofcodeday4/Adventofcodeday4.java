/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adventofcodeday4;

import java.io.IOException;
import java.nio.file.*;

/**
 *
 * @author MERT
 */
public class Adventofcodeday4 {

    public static void main(String[] args) throws IOException {
        
        String filePath = "C:\\Users\\MERT\\Desktop\\Days\\day4.txt";
        String content = Files.readString(Paths.get(filePath));
        System.out.println(content);
        
        
        
    }
}
