/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.io.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Laurence
 */
public class ReadWriteFile implements Serializable {

    public ReadWriteFile() {

    }
// use if statement to check if its manga & language 

    public String[][] readRenteeFile() {
        String[][] renteeArr = new String[4][3];
        String rentee;
        String[] temp = null;
        int index = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("rentee.txt"));

            while ((rentee = br.readLine()) != null) {
                temp = rentee.split(";");
                renteeArr[index] = temp;
                index++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error in reading rentee file.");
        }
        return renteeArr;
    }

    public void writeRenteeFile(Rentee[] renteeArr) {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("rentee.dat"));
            for (int a=0;a<renteeArr.length;a++){
                outStream.writeObject(renteeArr[a]);
            }
            outStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error in writing rentee file.");
        }
    }

    public String[][] readComicFile() {
        String[][] comicArr = new String[6][6];
        int index = 0;
        String comic;
        try {
            BufferedReader br = new BufferedReader(new FileReader("comic.txt"));
            while ((comic = br.readLine()) != null) {
                String[] temp = comic.split(";");
                comicArr[index]=temp;
                index++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error in reading comic file.");
        }
        return comicArr;
    }

    public void writeComicFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("comic.txt"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error in writing Comic file.");
        }
    }
}
