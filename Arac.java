package aracSigortaApp;

import java.util.Scanner;

public class Arac {

    //aracla ilgili ihtiyacimiz olan variable lar nelerdir
    public String type;//otobus//otomobil

    public int prim;//tarife donemine gore prim

    //5- prim hesaplama
    public void primHesaplama(int donem){

        //tipine gore hesaplamayapicaz
        switch (this.type){
            case "otomobil":
            this.prim = donem ==1? 2000:2500;
            break;
            case "kamyon"://ODEV
                this.prim = donem ==1? 3000:3500;
                break;
            case "otobus":
                primHesaplaOtobus(donem);
                break;
            case "motosiklet"://ODEV
                this.prim = donem ==1?1500:1750;
                    break;
                    default:
                        System.out.println("Hatali Giris");
                        this.prim =0;
                        break;

        }

    }

    public void primHesaplaOtobus(int donem){

        Scanner innput = new Scanner(System.in);
        System.out.println("Otobus tipini seciniz");
        System.out.println("1. 18-30 arasi koltuk sayisi");
        System.out.println("2. 31 ve ustu koltuk sayisi");

        int otobusTipi = innput.nextInt();

        switch (otobusTipi){
            case 1:
                this.prim=donem==1?4000:4500;
                break;

            case 2:
                this.prim=donem==1?5000:5500;
                break;

            default:
                System.out.println("Hatali Giriş!!!");
                this.prim=0;
                break;
        }

    }


}