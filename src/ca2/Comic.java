/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2;

/*
    Name :Laurence Goh Ming Shen
    Class : DIT/FT/1B/03
    Admin no: 2220327
*/
public class Comic {
    private String comicNum = null;
    private String comicName = null;
    private int comicPages = 0;
    private double comicPrice = 0;

    public Comic(){
        
    }
    
//    Comic class properties
    public Comic(String num, String name, int pages, double price) {
        comicNum = num;
        comicName = name;
        comicPages = pages;
        comicPrice = price;
    }

    
//    Get and set methods
    public String getComicNum() {
        return comicNum;
    }

    public void setComicNum(String comicNum) {
        this.comicNum = comicNum;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public int getComicPages() {
        return comicPages;
    }

    public void setComicPages(int comicPages) {
        this.comicPages = comicPages;
    }

    public double getComicPrice() {
        return comicPrice;
    }

    public void setComicPrice(double comicPrice) {
        this.comicPrice = comicPrice;
    }

   public String getLanguage() {
       return "";
   }
}
