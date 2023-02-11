/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.awt.HeadlessException;
import javax.swing.*;

/*
    Name :Laurence Goh Ming Shen
    Class : DIT/FT/1B/03
    Admin no: 2220327
 */
public class RentalMenu {

    public static void main(String[] args) {

        int input = 0;
        boolean isValidNum = true;

//        Creating a new rental system 
        RentalSystem comics = new RentalSystem();

//        Creating and storing comic and rentee arrays under comicArr and renteeArr
        comics.createComic();
        comics.createRentee();

//          Using do-while loop to continue prompting for input until input equals 5
        do {
//            Using another do-while loop for user input
//          If input is not a number or is empty, it will prompt the user again to re-enter
            do {
                try {
                    input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your option: \n1. Display all comics\n2. Search comic by ISBN-13\n3. Search Rentee by MemberID\n4. Print Earning Statistic\n5. Exit", "Comic Rental System", JOptionPane.QUESTION_MESSAGE));
                } catch (HeadlessException | NumberFormatException e) {

                    JOptionPane.showMessageDialog(null, "Please enter a valid input from 1 to 5", "Error", JOptionPane.ERROR_MESSAGE);
//                  Resets input to 0 if user has already entered a value between 1 to 5
                    input = 0;
                }

                if (input < 0 || input > 5) {
                    JOptionPane.showMessageDialog(null, "Invalid option. Please enter a value between 1 to 5.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //Exits the do-while loop when input is between 1-5
                    isValidNum = false;
                }
            } while (isValidNum);

            //If input is between 1-5
            if (input == 1) {
                comics.displayComics();
            } else if (input == 2) {
//                comics.searchComic();
            } else if (input == 3) {
//                comics.searchRentee();
            } else if (input == 4) {
//                comics.earningStatistic();
            } else if (input == 5) {
                JOptionPane.showMessageDialog(null, "Thank you for using Comic Rental.\nWe hope to serve you in the near future.");
            }
        } while (input != 5);

    }
}
