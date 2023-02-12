/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.util.Arrays;
import javax.swing.*;

/*
    Name :Laurence Goh Ming Shen
    Class : DIT/FT/1B/03
    Admin no: 2220327
 */
public class RentalSystem {

    private ReadWriteFile rw = new ReadWriteFile();
    private static final Comic[] comicArr = new Comic[6];
    private static final Rentee[] renteeArr = new Rentee[4];
    private int id = 0, id2 = 0;

    public void createComic() {
     
        String[][] temp = rw.readComicFile();

        for (int a = 0; a < temp.length; a++) {
            if (temp[a][4].equals("Comic")) {
                setComic(new Comic(temp[a][0], temp[a][1], Integer.parseInt(temp[a][2]), Double.parseDouble(temp[a][3])));
            } else {
                setComic(new Manga(temp[a][0], temp[a][1], Integer.parseInt(temp[a][2]), Double.parseDouble(temp[a][3]), temp[a][5]));
            }
        }
    }

    public void setComic(Comic comic) {
        comicArr[id] = comic;
        id++;
    }

    public void createRentee() {
      
        String[][] temp = rw.readRenteeFile();
        for (int a = 0; a < temp.length; a++) {
            String[] rentedComics = temp[a][2].split("#");
            setRentee(new Rentee(temp[a][0], temp[a][1], rentedComics));

        }
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
            displayComic += String.format("%-41s %-11s", comicArr1.getComicNum() + " | " + comicArr1.getComicName(), " |   " + comicArr1.getComicPages()) + String.format("%-16s", " |     $" + String.format("%.2f", comicArr1.getComicPrice() / 20)) + " |    $" + String.format("%.2f", comicArr1.getComicPrice() * 1.1);
            displayComic += "\n";

        }

        JOptionPane.showMessageDialog(null, displayComic, "All comics", JOptionPane.INFORMATION_MESSAGE);

    }
// For printing out comic description (input 2)
// Store the results into an array, then use rentalframe to print it out.
// [isbn,name,stock, rent, language (for manga)]
    // check if comic/manga using typeOf

    public String[] searchComic(String searchComic) {
        String[] results = new String[0];
//        String searchComic = JOptionPane.showInputDialog(null, "Enter ISBN-13 to search: ");
        int index = 0;
        for (int a = 0; a < comicArr.length; a++) {
            if (comicArr[a].getComicNum().equals(searchComic)) {

 
                if (comicArr[a] instanceof Manga) {
                    results = new String[6];
                    results[0] = searchComic;
                    results[1] = comicArr[a].getComicName();
                    results[2] = String.format("%.2f", comicArr[a].getComicPrice() / 20.0);
                    results[3] = String.format("%.2f", comicArr[a].getComicPrice() * 1.1);
                    results[4] = comicArr[a].getLanguage();
                    results[5] = Integer.toString(index);
                    break;
                } else {
                    results = new String[5];
                    results[0] = searchComic;
                    results[1] = comicArr[a].getComicName();
                    results[2] = String.format("%.2f", comicArr[a].getComicPrice() / 20.0);
                    results[3] = String.format("%.2f", comicArr[a].getComicPrice() * 1.1);
                    results[4] = Integer.toString(index);
                    break;
                }
            }
            else {
                index++;
            }
        }
        
        return results;
    }

//    Finding member details based on id (input 3)
    public Object[] searchRentee(String renteeID) {

        int index = 0;
        Object[] results = new Object[0];
        for (Rentee rentee1 : renteeArr) {
            if (rentee1 == null) {
                break;
            } else {
//            If input ID matches the ID in any of the renteeArr

                if (rentee1.getMemberId().equals(renteeID.toUpperCase())) {
                    results = new Object[4];
                    
                    results[0] = (String) rentee1.getMemberId();
                    results[1] = (String) rentee1.getMemberName();

                    String[] comicsLoaned = new String[rentee1.getLoanedComics().length];
                    for (int i = 0; i < rentee1.getLoanedComics().length; i++) {
                        comicsLoaned[i] = rentee1.getLoanedComics()[i];
                    }
                    results[2] = comicsLoaned;
                    results[3]= index;

                } else {
                    index++;
                }
                
            }
        }
       
        return results;
    }

//    Printing out statistics (input 4)
    public String earningStatistic() {
        double totalRentalFees = 0;
        String text;
        
//        Using for in loop to iterate the array elements in renteeArr
        for (Rentee rentee1 : renteeArr) {
            String [] rentedComics = rentee1.getLoanedComics();
            try {
                for (int a = 0; a < rentedComics.length; a++) {
                    String[] comicDetails = searchComic(rentedComics[a]);
                    totalRentalFees += Double.parseDouble(comicDetails[2]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("end of loaned array");
            }

        }
        text = "Earning Per Day:\n----------------------------------------------\n\nThere are " + renteeArr.length
                + " Rentees in total.\n\n"
                + "Average earning per day based on number of rentees is $" + String.format("%.2f", totalRentalFees / renteeArr.length) + "."
                + "\n\nTotal earning per day is $" + String.format("%.2f", totalRentalFees) + ".";
        return text;
    }
}
