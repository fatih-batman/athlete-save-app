/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.pkg2;
import java.util.*;
/**
 *
 * @author ahmet
 */
public class IkiYonluListe {
    private Link ilk;
    private Link son;

    
    public class Link {
    public Bilgi sporcu;
    public Link sonraki;
    public Link önceki;
    public Link(Bilgi sporcu){
        this.sporcu=sporcu;  }
    }
    
    public Link getIlk(){
        return ilk;
    }
    /**
     * @param ilk the ilk to set
     */
    public void setIlk(Link ilk) {
        this.ilk = ilk;
    }

    /**
     * @return the son
     */
    public Link getSon() {
        return son;
    }

    /**
     * @param son the son to set
     */
    public void setSon(Link son) {
        this.son = son;
    }


    public IkiYonluListe(Link ilk, Link son) {
        ilk=null;
        son=null;
    }
    
    public IkiYonluListe() {
        ilk=null;
        son=null;
    }
    
    public boolean bosMu(){
        return ilk==null;
    }
    public void listeyeEkle(String adSoyad,Date birthDate,List<String> arrayList){
        Link yenisporcu= new Link(new Bilgi(adSoyad,birthDate,arrayList));
        if (bosMu()){
            setSon(yenisporcu);
        }else{
            ilk.önceki=yenisporcu;
            yenisporcu.sonraki=ilk;
        }
        setIlk(yenisporcu);
    }
       
    public String[] cevirArraya(IkiYonluListe Liste) {
    String aktar=Liste.recursiveToString(Liste.getIlk());
        String[] Line = aktar.split("\n");                //BURADA SON ELEMANA \n EKSİK GÖNDERİYOR                                     
         return Line;  }                                                         
                                                                                
                                                                                 
    public String[] alfabetikYap(IkiYonluListe Liste){                 
       String[] x= cevirArraya(Liste);                                 //BU HATA ALFABETİKYAP METODUNDA HATAYA SEBEBİYET VERİYOR.
       String temp;                                                     // BU YÜZDEN SONDAKİ 1 ELEMAN SIRALANMASI ÇALIŞMIYOR.
        int n = x.length;
       // x[n-1]="\n"+x[n-1];
        for (int i = 0; i < n; i++)  {
            for (int j = i+1 ; j < n ; j++)  {  
                if (x[i].compareToIgnoreCase(x[j])>0)  {
                    temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;             
                } } }
        return x; }
    
    public String[] alfabetikYapTers(IkiYonluListe Liste){           
        String[] x= cevirArraya(Liste);                              
       String temp;
        int n = x.length;
        //x[n-1]="\n"+x[n-1];
        for (int i = 0; i < n; i++)  {
            for (int j = i+1 ; j < n ; j++)  {
                if (x[i].compareToIgnoreCase(x[j])<=0)  {
                    //System.out.println(i+"  "+j);
                    temp = x[i];
                    x[i] = x[j];
                    x[j] = temp; 
                //System.out.println(Arrays.toString(x)); 
                } } }
        return x;
    }

    public String recursiveToString(Link current){   //Bu çalışmıyor şu an;
        if(current == null){
            return"";
        }
        else{
            return current.sporcu+ "\n" + recursiveToString(current.sonraki);  }
    }

    public String elemanAra (String sporcuara){
        Link aktif = ilk; 
        while(!aktif.sporcu.getAdSoyad().equals(sporcuara) ){
            if(aktif.sonraki==null){
                return "Futbolcu bulunamadı";
            }
            aktif=aktif.sonraki;
        }
        if(aktif==null){
            return null;
        }else{
            return aktif.sporcu.toString() ;
        }
        }

    public String seciliSil(String sporcusil){
        Link aktif = ilk;
        while(! (aktif.sonraki==null) ){
            if( aktif.sporcu.getAdSoyad().equals(sporcusil)  ){
        if (aktif==ilk) ilk=aktif.sonraki;
        else if ( aktif==son )  son=aktif.önceki; 
        else if (ilk==son) {
            ilk=null;
            son=null;}    
        else {
            aktif.önceki.sonraki=aktif.sonraki;
            aktif.sonraki.önceki=aktif.önceki; }
            return "Futbolcu silinmiştir...";  }
        aktif=aktif.sonraki;   }
        return "Böyle bir futbolcu bulunamadı...";
        }

    
}