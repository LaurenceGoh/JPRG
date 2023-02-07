/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import javax.swing.*;

/*
    Name :Laurence Goh Ming Shen
    Class : DIT/FT/1B/03
    Admin no: 2220327
*/
public class RentalSystem {

    private static final Comic[] comicArr = new Comic[4];
    private static final Rentee[] renteeArr = new Rentee[3];
    private int id = 0, id2 = 0;

    public void createComic() {
        setComic(new Comic("978-0785199618", "Spider-Man: Miles Morales", 112, 14.39));
        setComic(new Comic("978-0785190219", "Ms. Marvel: No Normal", 120, 15.99));
        setComic(new Comic("978-0785198956", "Secret Wars", 312, 34.99));
        setComic(new Comic("978-0785156598", "Infinity Gauntlet", 256, 24.99));
    }

    public void setComic(Comic comic) {
        comicArr[id] = comic;
        id++;
    }

    public void createRentee() {
        setRentee(new Rentee("M220622", "Ariq Sulaiman", new String[]{"Spider-Man: Miles Morales", "Ms. Marvel: No Normal"}));
        setRentee(new Rentee("M220621", "John Tan", new String[]{"Secret Wars", "Infinity Gauntlet"}));
        setRentee(new Rentee("M220623", "Mary", new String[]{"Ms. Marvel: No Normal"}));
    }

    public void setRentee(Rentee rentee) {
        renteeArr[id2] = rentee;
        id2++;
    }

    public static Comic[] getComicArr() {
        return comicArr;
    }

    public static Rentee[] getRenteeArr() {
        return renteeArr;
    }

//  Printing out comicArr (input 1)
    public void displayComics() {
        String displayComic = "ISBN-13                |Title                                        | Pages | Price/Day | Deposit\n--------------------------------------------------------------------------\n";
        for (Comic comicArr1 : comicArr) {
              displayComic +=  String.format("%-41s %-11s" ,comicArr1.getComicNum() + " | " +comicArr1.getComicName()," |   " + comicArr1.getComicPages()) + String.format("%-16s"," |     $" + String.format("%.2f", comicArr1.getComicPrice() / 20)) +  " |    $" + String.format("%.2f", comicArr1.getComicPrice() * 1.1);
            displayComic += "\n";

        }

        JOptionPane.showMessageDialog(null, displayComic, "All comics", JOptionPane.INFORMATION_MESSAGE);

    }
// For printing out comic description (input 2)
    public void searchComic() {
        String searchComic = JOptionPane.showInputDialog(null, "Enter ISBN-13 to search: ");
        boolean found = false;
        for (int a = 0; a < comicArr.length; a++) {
            if (comicArr[a].getComicNum().equals(searchComic)) {
                JOptionPane.showMessageDialog(null, comicArr[a].getComicName() + "\n\nStock purchased at $" + comicArr[a].getComicPrice() + "\nCosts $" + String.format("%.2f", comicArr[a].getComicPrice() / 20.0) + " to rent.\nRequires deposit of $" + String.format("%.2f", comicArr[a].getComicPrice() * 1.1));
                found = true;
                break;
            }
        }
        if (found == false) {
            JOptionPane.showMessageDialog(null, "Cannot find the comic \"" + searchComic + "\"!!", "Info", JOptionPane.ERROR_MESSAGE);
        }
    }

    
//    Finding member details based on id (input 3)
    public void searchRentee() {

        String renteeID = JOptionPane.showInputDialog(null, "Enter Member Id to search:");
        int counter = 0;
        double totalFee = 0;
        for (Rentee rentee1 : renteeArr) {
            String displayMsg;
//            If input ID matches the ID in any of the renteeArr
            if (rentee1.getMemberId().equals(renteeID.toUpperCase())) {
                displayMsg = "MemberID  | Name \n"
                        + "-------------------------------------------\n"
                        + rentee1.getMemberId() + "  " + rentee1.getMemberName() + "\n"
                        + "Comics loaned: \n";

                //Display comic names
                for (int a = 0; a < rentee1.getLoanedComics().length; a++) {
                    displayMsg += (a + 1) + " " + rentee1.getLoanedComics()[a] + "\n";
                }

                try {
                    for (int a = 0; a < comicArr.length; a++) {

                        for (int b = 0; b < rentee1.getLoanedComics().length; b++) {
//                        If the name of the comics loaned in the renteeArr matches the comic name in comicArr

                            if (rentee1.getLoanedComics()[b].equals(comicArr[a].getComicName())) {
                                totalFee += (comicArr[a].getComicPrice() / 20.0);
                                break;
                            }
                        }

                    }
//                    Length of renteeArr is less than the length of comcicArr, it will cause an error
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("end of loaned array");
                }

                displayMsg += "\n\n Total Rental Per Day: $" + String.format("%.2f", totalFee);
                JOptionPane.showMessageDialog(null, displayMsg);
                counter++;

            }

        }
        if (counter == 0) {
            JOptionPane.showMessageDialog(null, "Cannot find the Member \"" + renteeID + "\"!!", "Info", JOptionPane.ERROR_MESSAGE);
        }
    }

//    Printing out statistics (input 4)
    public void earningStatistic() {
        double totalRentalFees = 0;

//        Using for in loop to iterate the array elements in renteeArr
        for (Rentee rentee1 : renteeArr) {

            try {
                for (int a = 0; a < comicArr.length; a++) {

                    for (int b = 0; b < rentee1.getLoanedComics().length; b++) {

//                        If the name of the comics loaned in the renteeArr matches the comic name in comicArr
                        if (rentee1.getLoanedComics()[b].equals(comicArr[a].getComicName())) {
                            totalRentalFees += (comicArr[a].getComicPrice() / 20.0);
                            break;
                        }
                    }

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("end of loaned array");
            }

        }
        System.out.println(totalRentalFees);
        JOptionPane.showMessageDialog(null, "Earning Per Day:\n----------------------------------------------\n\nThere are " + renteeArr.length
                + " Rentees in total.\n\n"
                + "Average earning per day based on number of rentees is $" + String.format("%.2f", totalRentalFees / 3) + "."
                + "\n\nTotal earning per day is $" + String.format("%.2f", totalRentalFees) + ".");
    }
}
