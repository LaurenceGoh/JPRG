/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.util.Arrays;
import java.io.*;
/**
 *
 * @author Laurence
 */
public class test {
    public static void main(String[] args) {
        RentalSystem rs = new RentalSystem();
        try{
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("rentee.dat"));
            while (true){
                Rentee r = (Rentee) is.readObject();
                
                    System.out.println(r.getMemberId());
                    System.out.println(r.getMemberName());
                    System.out.println(Arrays.toString(r.getLoanedComics()));
                
            }
        } catch(EOFException e) {
            System.out.println("End of file.");
        }
        
        catch (IOException e) {
            System.out.println("Error in reading file");
        } catch(ClassNotFoundException e){
            System.out.println("File not found.");
        }
    }
}
