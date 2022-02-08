/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.pkg2;

import java.util.*;

/**
 *
 * @author Windows10
 */
public class Bilgi {
    private String adSoyad;
    private Date birthDate;
    private List<String> arrayList;

    public Bilgi(String adSoyad, proje.pkg2.Date birthDate, List<String> arrayList) {
        this.adSoyad = adSoyad;
        this.birthDate = birthDate;
        this.arrayList = arrayList;
    }
    
    public Bilgi(String adSoyad){
        this.adSoyad= adSoyad;
        this.birthDate=null;
        this.arrayList=null;
    }

    public Bilgi() {
    }

    /**
     * @return the adSoyad
     */
    public String getAdSoyad() {
        return adSoyad;
    }

    /**
     * @param adSoyad the adSoyad to set
     */
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the arrayList
     */
    public List<String> getArrayList() {
        return arrayList;
    }

    /**
     * @param arrayList the arrayList to set
     */
    public void setArrayList(List<String> arrayList) {
        this.arrayList = arrayList;
    }
    

   public String toString(){
       Iterator<String> it=arrayList.iterator();
       String arrayList_string="";
       while(it.hasNext()){
           arrayList_string+=","+it.next();
       }
       //arrayList_string+="\n";
       return adSoyad + ", " + birthDate + arrayList_string;
   }
    
    
} //NABER