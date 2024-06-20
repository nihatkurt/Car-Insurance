package aracSigortaApp;

import java.util.Scanner;

public class AracSigortaApp {

    /*
        Proje: Araç Sigorta Prim Hesaplama
       Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                    -otobüs: 18-30 koltuk veya 31 ve üstü koltuk

       Tarife dönemi:Aralık 2024,Haziran 2024
          1.dönem :Haziran 2024               2.dönem:Aralık 2024
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750

        1- Tekrar tekrar kullanılanbir seçim menüsü(form) gösterelim.
        2-Tarife dönemi bilgisi,araç tipi bilgilerini kullanıcıdan alalım.
        3-Hatalı girişte hesaplama başarısız uyarısı verip tekrar menü(form) gösterilsin.
        4-Menüde yeni işlem veya çıkış için seçenek sunulsun .
        5-tarife dönemi ve araç tipine göre sigorta primi hesaplansın.
 */

    public static void main(String[] args) {
        //1- uygulamanin baslamasi icin bir method olusturalım
        start();
    }

    public static void start(){

        //2. kullanıcıdan bilgi alma
        Scanner input=new Scanner(System.in);
        boolean isAgain;

        //3. tekrar tekrar menü gosterilsin
        do {
            System.out.println("--Zorunlu Arac Sigorta Primi Hesaplama--");
            System.out.println("Tarife Donemi Seciniz : ");
            System.out.println("1. Haziran 2024");
            System.out.println("2. Aralık 2024");
            int donem= input.nextInt();//haziran

            //if (input.hasNextInt()){//dogru bir sekilde int deger giriliyor mu diye kontrol eder
            //    donem=input.nextInt();//eger dogru bir int deger girildiyse deger atamasi yapıldı
            //}else {
            //    input.nextLine();//haziran degerini kullanmıs oluyoruz //dummpy
            //}
            //System.out.println(donem);

            String donemBilgisi=donem==1?"Haziran 2024":"Aralık 2024";
            //tarife donemi bilgisi dogru girilirse isleme devam eden yanlis girilse basa donduren bir yapı yapalım
            if (donem==1||donem==2){//dogru bir donem bilgisi girilmisse

                //4.arac objesine ihtiyacimiz var!!!
                Arac arac=new Arac();
                System.out.println("Arac tipini seciniz : ");
                System.out.println("otomobil, kamyon, otobus, motosiklet");//OTOMOBİL
                arac.type=input.next().toLowerCase();
                arac.primHesaplama(donem);

                //prim=0 ise hatali giris yapılmıstır yeni işlem yapsın
                //prim>0 ise hesaplama islemi basarali bir sekilde tamamlanmıstır

                if (arac.prim>0){

                    System.out.println("----------------------------");
                    System.out.println("Arac Tipi : "+arac.type);
                    System.out.println("Tarife donemi : "+donemBilgisi);
                    System.out.println("Aracinizin ilgili dobem sigorta primi : "+arac.prim);
                    System.out.println("-----------------------------");
                    System.out.println("Yeni islem icin 1, cikis icin 0'i seciniz");

                    int select= input.nextInt();
                    isAgain=select==1? true:false;

                }else {
                    System.out.println("Hesaplama islemi basarisiz, tekrar deneyiniz");
                    System.out.println("Yeni islem icin 1, cikis icin 0'i seciniz");

                    int select= input.nextInt();
                    isAgain=select==1? true:false;
                }

            }else {
                System.out.println("Hatali giriş!!!");
                isAgain=true;
            }


        }while (isAgain);
    }


}