/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.util.Arrays;

/**
 *
 * @author Laurence
 */
public class test {
    public static void main(String[] args) {
        ReadWriteFile rwFile = new ReadWriteFile();
        String [][] temp = rwFile.readComicFile();
        for (int a=0;a<rwFile.readComicFile().length;a++){
            System.out.println(Arrays.toString(temp[a]));
        }
    }
}
