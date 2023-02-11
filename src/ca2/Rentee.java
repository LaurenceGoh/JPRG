/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;
import java.io.*;
/*
    Name :Laurence Goh Ming Shen
    Class : DIT/FT/1B/03
    Admin no: 2220327
*/
public class Rentee implements Serializable {

    private String memberId = null;
    private String memberName = null;
    private String[] comicsLoaned;

    
//    Rentee class properties
    public Rentee(String memberId, String memberName, String[] comicsLoaned) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.comicsLoaned = comicsLoaned;
    }

//    Get and set methods
    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String[] getLoanedComics() {
        return comicsLoaned;
    }   
}
