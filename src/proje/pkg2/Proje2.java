package proje.pkg2;
import java.util.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author Windows10
 */
public class Proje2 {
    
    public static void dosyaYaz(IkiYonluListe Liste) {
        String yazılacak=Liste.recursiveToString(Liste.getIlk());                                   
        String[] Line = yazılacak.split("\n");
        try(FileWriter writer = new FileWriter("sporcu.txt");
           BufferedWriter bw= new BufferedWriter(writer)){
            for (String x:Line){
            bw.write(x);
            bw.newLine();
                               }  bw.close();                                }
        catch(IOException e){
            System.err.format("IOException: %s%n", e); }   
                                                        }

    
    public static void main(String[] args) throws Exception{            //NOT: ALFABETİK SIRALAMA YAPARKEN
        final int number_of_char=30;                                        // LİSTENİN SONUNDAKİ 1 FUTBOLCU HARİÇ
        IkiYonluListe Liste = new IkiYonluListe();                       // SIRALAMA YAPILMAKTIR.
         File file = new File("sporcu.txt");                                
         BufferedReader br = new BufferedReader(new FileReader(file)); 
  String st; 
  while ((st = br.readLine()) != null   ) {
    String[] parts = st.split(",");
    String[] parts2 = parts[1].split("/");
    
    List<String> ara_liste = new ArrayList<String>();
    for (int i=2;i<parts.length;i++){
        ara_liste.add(parts[i]);
    }
      Date date = new Date(parts2[1],Integer.parseInt(parts2[0].trim()),Integer.parseInt(parts2[2]));
      Liste.listeyeEkle(parts[0],date,ara_liste);
  }

     // DENEME ÇALIŞMALARI
     //System.out.println(Arrays.toString(Liste.alfabetikYap(Liste)));       
     //Liste.cevirArraya(Liste);
    //System.out.println(Liste.recursiveToString(Liste.getIlk()));            //IKIYONLULİSTE'Yİ BAASTIRIR.
    /*   String x[]=Liste.alfabetikYap(Liste);                               //SIRALANMIŞ ARRAY'I BASTIRIR.  
        for(int i =0;i<x.length;i++){
            System.out.println(x[i]);
        }           */

  
    JFrame jframe=new JFrame();
    
    
    jframe.setSize(800,700);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setTitle("Futbolcu bilgi Programı");
    jframe.setResizable(false);
    jframe.setLocation(300,100);
    jframe.setLayout(new GridLayout(3,2));
    
    JPanel panel1 = new JPanel();
    panel1.setBackground(Color.PINK);
    JLabel bilgi_label = new JLabel("Programımız 5 parçadan oluşuyor.");
    panel1.add(bilgi_label);
    jframe.add(panel1);

    JPanel panel2= new JPanel();
    panel2.setLayout(new FlowLayout());
    panel2.setBackground(Color.RED);
    JLabel nameLabel = new JLabel("Eklemek istediğiniz futbolcunun sırasıyla");
    panel2.add(nameLabel);
    JLabel nameLabel_devam = new JLabel("adı,doğum tarihi ve oynadığı takımları giriniz.");
    panel2.add(nameLabel_devam);
    JLabel nameLabel_devam_devam = new JLabel("Lütfen 2. satırda doğum tarihi girerken '/' ile ayırınız...");
    panel2.add(nameLabel_devam_devam);
    JLabel nameLabel_devam_devam_devam = new JLabel("Lütfen 3. satırda takımları girerken ', '(virgül ve boşluk) ile ayırınız.");
    panel2.add(nameLabel_devam_devam_devam);
    JTextField name= new JTextField(number_of_char);
    JTextField date= new JTextField(number_of_char);
    JTextField takimlar= new JTextField(number_of_char);
    panel2.add(name);
    panel2.add(date);
    panel2.add(takimlar);
    JButton ekleme = new JButton("Ekle");
    ekleme.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
       String[] parts = takimlar.getText().split(",");
       List<String> ara_liste = new ArrayList<String>();
      for (int i=0;i<parts.length;i++){
          if(i==0){
          ara_liste.add(" "+parts[i]);  }
          else{
        ara_liste.add(parts[i]); }}
      String[] parts2 = date.getText().split("/");
      Date date_ekleme = new Date(parts2[1],Integer.parseInt(parts2[0].trim()),Integer.parseInt(parts2[2]));
      //  System.out.println(ara_liste);
      Liste.listeyeEkle(name.getText(), date_ekleme, ara_liste);
      JOptionPane eklendi=new JOptionPane();
      eklendi.showMessageDialog(null,"Eklendi...");   
      name.setText("");     
      date.setText("");
      takimlar.setText("");         
      dosyaYaz(Liste);            }});
      panel2.add(ekleme);
    jframe.add(panel2);
    
    JPanel panel3 = new JPanel();
    panel3.setBackground(Color.BLUE);
    JLabel isim_giris = new JLabel("Bilgilerini görmek istediğiniz futbolcunun adını giriniz.");
    panel3.add(isim_giris);
    JTextField bilgi_gir= new JTextField(number_of_char);
    panel3.add(bilgi_gir);
    JButton isimle_bilgi_getirme = new JButton("Futbolcunun bilgilerini getir.");
    isimle_bilgi_getirme.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){;
        JOptionPane bilgiler=new JOptionPane();
        bilgiler.showMessageDialog(null,Liste.elemanAra(bilgi_gir.getText()));
    bilgi_gir.setText("");    }});  
    panel3.add(isimle_bilgi_getirme);
    jframe.add(panel3);
    
    JPanel panel4 = new JPanel();
    panel4.setBackground(Color.MAGENTA);
    JLabel isim_giris2 = new JLabel("Bilgilerini silmek istediğiniz futbolcunun adını giriniz.");
    panel4.add(isim_giris2);
    JTextField bilgi_gir2= new JTextField(number_of_char);
    panel4.add(bilgi_gir2);
    JButton isimle_bilgi_silme = new JButton("Futbolcunun bilgilerini sil.");
    isimle_bilgi_silme.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        // Liste.seciliSil(   bilgi_gir2.getText()   );
        JOptionPane bilgiler=new JOptionPane();
        bilgiler.showMessageDialog(null,Liste.seciliSil(   bilgi_gir2.getText()   ));    
        bilgi_gir2.setText("");
        dosyaYaz(Liste);
        }}); 
         panel4.add(isimle_bilgi_silme);
    jframe.add(panel4);
    
    JPanel panel5 = new JPanel();
    panel5.setBackground(Color.YELLOW);
    JButton kayit_goster_artan = new JButton("Listedeki tüm kayıtları artan sırada göster.");
    kayit_goster_artan.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            JOptionPane liste_gosterme_seysi_artan=new JOptionPane();
            String x[]=Liste.alfabetikYap(Liste);
            liste_gosterme_seysi_artan.showMessageDialog(null, x );}});
    panel5.add(kayit_goster_artan);
    JButton kayit_goster_azalan = new JButton("Listedeki tüm kayıtları azalan sırada göster.");
    kayit_goster_azalan.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            JOptionPane liste_gosterme_seysi_azalan=new JOptionPane();
            String x[]=Liste.alfabetikYapTers(Liste);
            liste_gosterme_seysi_azalan.showMessageDialog(null, x );}});
    panel5.add(kayit_goster_azalan);
    jframe.add(panel5);
    
    JPanel panel6 = new JPanel();
    panel6.setBackground(Color.GREEN);
    JButton endButton2 = new JButton("ÇIKIŞ");
    endButton2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            //JOptionPane liste_gosterme_seysi=new JOptionPane();
            //liste_gosterme_seysi.showMessageDialog(null,Liste.recursiveToString(Liste.getIlk()));
            System.exit(0);  }});
    panel6.add(endButton2);
    jframe.add(panel6);
    
    jframe.setVisible(true);

    
    
    }
    } 