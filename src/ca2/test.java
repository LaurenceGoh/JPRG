/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;
import java.io.*;
import java.util.Arrays;
/**
 *
 * @author Laurence
 */
public class test {
    // This is to test that the rentee.dat file works.
    public static void main(String[] args) {
        RentalSystem rs = new RentalSystem();
        Rentee[] renteeArr = rs.getRenteeArr();
        System.out.println(renteeArr.length);
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("rentee.dat"));
           for (int a=0;a<renteeArr.length;a++){
              Rentee renteeDetail = (Rentee) is.readObject();
              System.out.println(renteeDetail.getMemberId() +" "  + renteeDetail.getMemberName() +" " + Arrays.toString(renteeDetail.getLoanedComics()));
           }
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error in reading rentee file.");
        }
    }
}
