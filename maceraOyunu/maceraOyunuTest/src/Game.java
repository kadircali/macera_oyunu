import Esyalar.Ekmek;
import Esyalar.Esya;
import Esyalar.Odun;
import Esyalar.Su;

import Silahlar.Kilic;
import Silahlar.Mizrak;
import Silahlar.Yay;
import Zırhlar.Agir;
import Zırhlar.Hafif;
import Zırhlar.Orta;
import canavarlar.Ayi;
import canavarlar.Canavar;
import canavarlar.Vampir;
import canavarlar.Zombi;
import karakterler.Karakter;
import karakterler.Okcu;
import karakterler.Savasci;
import karakterler.Sovalye;
import mekanlar.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Karakter karakter;
    Mekan mekan ;
    Random random = new Random();
    int randomNumber = random.nextInt(3) + 1;
    int silahDegeri ;

    //mekana gidiş ekranları başlangıç
    //1- güvenli ev
    public void guvenliEvEkrani(){
        System.out.println("***********************");
        System.out.println("şu anda güvenli evdesiniz");
        System.out.println("canınız tazekendi");
        System.out.println("***********************");

        if(karakter.getSaglik() < karakter.getMaxSaglik()){
            karakter.setSaglik(karakter.getMaxSaglik());
        }
        setMKarakterMekan();
    }
    //2-mağaza
    public void magazaEkrani(){
        while(true){
            int secim ;
            System.out.println("***********************");
            System.out.println("şu anda mağazadasınız");
            System.out.println("***********************");
            System.out.println("1-kılıç canı yenileme(3 coin)");
            System.out.println("2-zırh canı yenileme(4 coin)");
            System.out.println("3-can iksiri(5 coin)");
            System.out.println("4- satış yap");
            System.out.println("5-silah satın al");
            System.out.print("ne satın almak istersiniz:");

            //try
            try {
                secim = scanner.nextInt();
                if(secim == 1){
                    //kılıcın canını kontrol et, düşükse para karşılığı yenile,karaktere para eksiltme metodu ekle
                    //karakterin parası var mı?
                    if(3 <= karakter.getPara()){
                        if(karakter.getSilah().getSilahSaglik() < karakter.getSilah().getMaxSaglik()){
                            karakter.getSilah().setSilahSaglik(karakter.getSilah().getMaxSaglik());
                            karakter.paraEksilt(3);
                            System.out.println("***********************");
                            System.out.println("silah yenilendi");
                            System.out.println("***********************");
                        }else{
                            System.out.println("***********************");
                            System.out.println("silah sağlığı tam");
                            System.out.println("***********************");
                        }
                    }else{
                        System.out.println("***********************");
                        System.out.println("para yetersiz");
                        System.out.println("***********************");
                    }

                }else if(secim == 2){
                    //zırh canı

                    if(4 <= karakter.getPara()){
                        if(karakter.getZirh().getZirhSaglik() < karakter.getZirh().getMaxSaglik()){
                            karakter.getZirh().setZirhSaglik(karakter.getZirh().getMaxSaglik());
                            karakter.paraEksilt(4);
                            System.out.println("***********************");
                            System.out.println("zirh yenilendi");
                            System.out.println("***********************");
                        }else{
                            System.out.println("***********************");
                            System.out.println("zırh sağlığı tam");
                            System.out.println("***********************");
                        }
                    }else{
                        System.out.println("***********************");
                        System.out.println("para yetersiz");
                        System.out.println("***********************");
                    }



                }else if (secim == 3){
                    //karakter canı
                    if(5 <= karakter.getPara()){
                        if(karakter.getSaglik() < karakter.getMaxSaglik()){
                            karakter.setSaglik(karakter.getMaxSaglik());
                            karakter.paraEksilt(5);
                            System.out.println("***********************");
                            System.out.println("saglik yenilendi");
                            System.out.println("***********************");
                        }else{
                            System.out.println("***********************");
                            System.out.println("sağlık yeterli");
                            System.out.println("***********************");
                        }
                    }else{
                        System.out.println("***********************");
                        System.out.println("para yetersiz");
                        System.out.println("***********************");
                    }
                }else if (secim == 4){
                    //satış ekranı
                    System.out.println("satış ekranı");

                    List<Esya> karakterEsya = karakter.getEsyalar();
                    if(karakterEsya.size() == 0 || karakterEsya.isEmpty()){
                        System.out.println("***********************");
                        System.out.println("satacak eşyanız yok...");
                        System.out.println("***********************");
                    }else{
                        System.out.println("***********************");
                        System.out.println("tüm eşyalar satıldı");
                        System.out.println("***********************");
                        for (int i = 0; i < karakterEsya.size(); i++) {
                            karakter.paraEkle(karakterEsya.get(i).getEsyaDegeri());
                            karakterEsya.clear();

                        }
                        System.out.println("***********************");
                        System.out.println("güncel paranız:"+karakter.getPara());
                        System.out.println("***********************");
                    }

                }else if(secim == 5){

                    //silah satış ekranı: önce karakter kontrol edilmeli, karaktere göre silah sunulmalı,silahlara değer eklemeyi unuttum o yüzden buralar elle yazılacak
                    //ya da silah değerine şöyle bir şey yapabilirim : silahMaxSaglik / silahHasar ?

                    //silah varsa
                    if(karakter.getSilah() != null){
                        System.out.println("zaten bir silahınız var");
                    }else{




                        if(karakter.getKarakterAd().equals("savasci")){


                            if(karakter.getPara() >= silahDegeri){
                                karakter.setSilah(new Kilic("kilic",2,30,30));
                                karakter.paraEksilt(silahDegeri);

                                System.out.println("***********************");
                                System.out.println("kılıç eklendi");
                                System.out.println("***********************");
                            }else{
                                System.out.println("***********************");
                                System.out.println("para yetersiz, oyun bitti");
                                System.out.println("***********************");
                                return;
                            }


                        }else if (karakter.getKarakterAd().equals("okcu")){
                            if(karakter.getPara() >= silahDegeri){
                                karakter.setSilah(new Yay("yay",3,40,40));
                                karakter.paraEksilt(silahDegeri);
                                System.out.println("***********************");
                                System.out.println("yay eklendi");
                                System.out.println("***********************");
                            }else{
                                System.out.println("***********************");
                                System.out.println("para yetersiz, oyun bitti");
                                System.out.println("***********************");
                                return;
                            }

                        }else if (karakter.getKarakterAd().equals("sovalye")){
                            if(karakter.getPara() >= silahDegeri){
                                karakter.setSilah(new Mizrak("mizrak",4,50,50));
                                karakter.paraEksilt(silahDegeri);
                                System.out.println("***********************");
                                System.out.println("mızrak eklendi");
                                System.out.println("***********************");
                            }else{
                                System.out.println("***********************");
                                System.out.println("para yetersiz, oyun bitti");
                                System.out.println("***********************");
                                return;
                            }
                        }




                    }

                }else {
                    System.out.println("***********************");
                    System.out.println("hatalı seçim");
                    System.out.println("***********************");
                    continue;
                }
                setMKarakterMekan();
            }
            catch (Exception e){
                System.out.println("Lütfen geçerli bir sayı girin.");
                System.out.println(e.getMessage());
                e.printStackTrace();
                scanner.next();
            }

        }
    }
    //2-mağaza bitiş



    //3-orman başlangıç
    boolean ormanTemizMi = false ;
    public void ormanEkran(){
        int secim ;
        randomNumber = random.nextInt(3) + 1;

        if(karakter.getMekan().isTemizlendi() == false ){
            while (true){
                System.out.println("şu anda ormandasın");
                System.out.println("burada "+randomNumber+" tane vampir var");
                System.out.print("(1-savaş/2-kaç) ne yapmak istiyorsun:");
                //try
                try {
                    secim = scanner.nextInt();
                    if(secim == 1){
                        //savaş ekranı
                        System.out.println("savaşmayı seçtiniz");

                        savasEkrani(karakter,karakter.getMekan().getCanavar(),randomNumber);
                    }else if(secim == 2){
                        //kaçış
                        System.out.println("kaçtınız");
                        setMKarakterMekan();
                    }
                }catch (Exception e){
                    System.out.println("Lütfen geçerli bir sayı girin.");
                    scanner.next();
                }
            }
        }else{
            ormanTemizMi = true ;
            System.out.println("**************************");
            System.out.println("mekan temiz");
            setMKarakterMekan();
            System.out.println("**************************");
        }




    }

    //3-orman bitiş

    //4 nehir başlangıç
    boolean nehirTemizMi = false ;
    public void nehirEkran(){
        int secim ;
        randomNumber = random.nextInt(3) + 1;
        if(karakter.getMekan().isTemizlendi() == false ){
            while (true){
                System.out.println("şu anda nehirdesin");
                System.out.println("burada "+randomNumber+" tane ayı var");
                System.out.print("(1-savaş/2-kaç) ne yapmak istiyorsun:");
                try {
                    secim = scanner.nextInt();
                    if(secim == 1){
                        //savaş ekranı
                        System.out.println("savaşmayı seçtiniz");

                        savasEkrani(karakter,karakter.getMekan().getCanavar(),randomNumber);
                    }else if(secim == 2){
                        //kaçış
                        System.out.println("kaçtınız");
                        setMKarakterMekan();
                    }
                }catch (Exception e){
                    System.out.println("Lütfen geçerli bir sayı girin.");
                    scanner.next();
                }
            }
        }else{
            nehirTemizMi = true ;
            System.out.println("**************************");
            System.out.println("mekan temiz");
            setMKarakterMekan();
            System.out.println("**************************");
        }

        //try


    }
    //nehir bitiş



    //mağara başlangıç
    boolean magaraTemizMi = false;
    public void magaraEkran(){
        int secim =0;
        randomNumber = random.nextInt(3) + 1;


        if(karakter.getMekan().isTemizlendi() == false ) {
            System.out.println("şu anda mağaradasın");
            System.out.println("burada "+randomNumber+" tane zombi var");
            System.out.print("(1-savaş/2-kaç) ne yapmak istiyorsun:");
            while (true){
                //try
                try {
                    secim = scanner.nextInt();
                    if(secim == 1){
                        //savaş ekranı
                        System.out.println("savaşmayı seçtiniz");

                        savasEkrani(karakter,karakter.getMekan().getCanavar(),randomNumber);
                    }else if(secim == 2){
                        //kaçış
                        System.out.println("kaçtınız");
                        setMKarakterMekan();
                    }
                }catch (Exception e) {
                    System.out.println("Lütfen geçerli bir sayı girin.");
                    scanner.next();
                }
            }

        }else{
            magaraTemizMi = true ;
            System.out.println("**************************");
            System.out.println("mekan temiz");
            setMKarakterMekan();
            System.out.println("**************************");
        }





    }
    //mağara bitiş
    //mekana gidiş ekranları bitiş


    //savaş ekranı
    public void savasEkrani(Karakter karakter, Canavar canavar,int canavar_sayisi){
        int secim = 0;
        System.out.println("*******************");
        System.out.println("Savaş başladı! Karşında " + canavar_sayisi + " tane " + canavar.getCanavarAdi() + " var.");
        System.out.println("*******************");
        System.out.println("mevcut mekan"+karakter.getMekan().getMekanAd());
        // Her canavarla sırayla savaşıyoruz
        for (int i = 1; i <= canavar_sayisi; i++) {

            Canavar mevcutCanavar = null;
            int para = 0 ;

            if (canavar instanceof Vampir) {
                mevcutCanavar = new Vampir(canavar.getCanavarAdi(), canavar.getCanavarCani(), canavar.getCanavarHasari(), canavar.getCanavarEsyasi());
                para = 3 ;
            } else if (canavar instanceof Ayi) {
                mevcutCanavar = new Ayi(canavar.getCanavarAdi(), canavar.getCanavarCani(), canavar.getCanavarHasari(), canavar.getCanavarEsyasi());
                para = 4 ;
            } else if (canavar instanceof Zombi) {
                mevcutCanavar = new Zombi(canavar.getCanavarAdi(), canavar.getCanavarCani(), canavar.getCanavarHasari(), canavar.getCanavarEsyasi());
                para = 5;
            }
            System.out.println("Savaş " + i + ". canavar ile başladı!");

            while (mevcutCanavar.getCanavarCani() > 0 && karakter.getSaglik() > 0) {
                System.out.println("Ne yapmak istiyorsunuz?");
                System.out.println("1- Vur / 2- Kaç");

                //try
                try {
                    secim = scanner.nextInt();
                    int zirhsizCanavarHasari = 0 ;

                    if (secim == 1) {
                        // Karakter canavara saldırıyor
                        System.out.println("Vurdunuz!");
                        mevcutCanavar.setCanavarCani(mevcutCanavar.getCanavarCani() - ( karakter.getSilah().getHasar() +karakter.getHasar()));
                        System.out.println(mevcutCanavar.getCanavarAdi() + " kalan sağlık: " + mevcutCanavar.getCanavarCani());
                        //silah canını  azalt:

                        karakter.getSilah().setSilahSaglik(karakter.getSilah().getSilahSaglik() - 1);
                        System.out.println("karakter silah canı:"+karakter.getSilah().getSilahSaglik());

                        //zırh canını azalt
                        karakter.getZirh().setZirhSaglik(karakter.getZirh().getZirhSaglik() - 1);
                        System.out.println("karakter zırh canı:"+karakter.getZirh().getZirhSaglik());

                        //silah sağlık kontrolü:
                        if (karakter.getSilah().getSilahSaglik() <= 0) {
                            System.out.println("Silahınız kırıldı! arkana bakmadan kaç");
                            karakter.setSilah(null); // silah artık yok
                            //setMKarakterMekan(); bunun yerine karakter mağazaya mecburi yönlendirilsin
                            magazaEkrani();
                            //mağazaya silah alma ekle
                        }

                        //zırh kırılırsa canavar daha çok vursun ?
                        if(karakter.getZirh().getZirhSaglik() <= 0) {
                            zirhsizCanavarHasari = 5 ;
                        }


                        // Canavarın sağlığı sıfır olduysa bu canavarı yenmiş oluruz
                        if (mevcutCanavar.getCanavarCani() <= 0) {
                            System.out.println(i + ". canavarı yendiniz!");
                            // karakter.setEsya(new Odun("odun",3));
                            karakter.esyaEkle(canavar.getCanavarEsyasi());
                            karakter.paraEkle(para);

                            break; // Bu canavar bitti, diğerine geçecek
                        }

                        // Canavar karaktere saldırıyor
                        System.out.println(mevcutCanavar.getCanavarAdi() + " size vurdu!");
                        karakter.setSaglik(karakter.getSaglik() - mevcutCanavar.getCanavarHasari() +zirhsizCanavarHasari);
                        System.out.println("Kalan sağlık: " + karakter.getSaglik());
                        //zırh canını azalt
                        karakter.getZirh().setZirhSaglik(karakter.getZirh().getZirhSaglik() -1);

                        // Karakterin sağlığı sıfırsa oyun biter
                        if (karakter.getSaglik() <= 0) {
                            System.out.println("Savaşta yenildiniz. Oyun bitti.");
                            return;
                        }

                    } else if (secim == 2) {
                        System.out.println("Kaçtınız!");
                        karakter.getMekan().setTemizlendi(false);
                        setMKarakterMekan();
                        return;
                    } else {
                        System.out.println("Geçersiz seçim!");
                        //geçersiz seçimlerde program patlayabilir burayı döngüye almak gerekebilir
                    }
                }catch (Exception e){
                    System.out.println("Lütfen geçerli bir sayı girin."); //
                    scanner.next();
                }

            }
        }

        // Eğer tüm canavarları yendiyse savaş biter
        System.out.println("Tüm canavarları yendiniz, tebrikler!");
        karakter.getMekan().setTemizlendi(true);

        setMKarakterMekan(); // Savaşı bitirdikten sonra mekana geri dön






    }
    //savaş ekranı bitiş



    //mekan metotları

    //set karakter mekan
    public void setMKarakterMekan(){


        checkGameOver();



        int mekanSecimi = mekanListele();
        if(mekanSecimi == 1){
            karakter.setMekan(new GuvenliEv(null,"guvenliev"));
            guvenliEvEkrani();
        }else if (mekanSecimi == 2){
            karakter.setMekan(new Magaza(null,"magaza"));
            magazaEkrani();
        }else if (mekanSecimi == 3){
            karakter.setMekan(Orman.getInstance());
            ormanEkran();
        }else if (mekanSecimi == 4){
            karakter.setMekan(Nehir.getInstance());
            nehirEkran();
        }else if (mekanSecimi == 5){
            karakter.setMekan(Magara.getInstance());
            magaraEkran();
        }
    }

    //mekan listele
    public int mekanListele(){

        int secim = 0;
        while (true) {
            System.out.println("MEKAN SEÇİMİ");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Mağaza");
            System.out.println("3 - Orman");
            System.out.println("4 - Nehir");
            System.out.println("5 - Mağara");
            System.out.print("Gitmek istediğiniz mekanı seçin: ");

            try {
                secim = scanner.nextInt();
                if (secim >= 1 && secim <= 5) {
                    return secim;
                } else {

                }
            } catch (InputMismatchException e) {
                System.out.println("Geçersiz giriş. Lütfen bir sayı girin.");
                scanner.next();
            }
        }
    }

    //mekan metotları







    //karakter metotları

    //karakter set metodu
    public Karakter setKarakter(){
        int karakterSecim = karakterListele();
        if(karakterSecim == 1){
            //savaşçı set : test amaçlı özellikleri çok değiştirdim
            karakter = new Savasci(100,15,15,100,new Hafif("hafif",50,50),new Kilic("kilic",2,3,30),"savasci");
            silahDegeri = karakter.getSilah().getMaxSaglik() / karakter.getSilah().getHasar() ;
            System.out.println("seçilen karakter:"+karakter.getKarakterAd());
        }else if(karakterSecim == 2){
            //okçu set
            karakter = new Okcu(80,15,20,80,new Orta("orta",60,60),new Yay("yay",3,40,40),"okcu");
            silahDegeri = karakter.getSilah().getMaxSaglik() / karakter.getSilah().getHasar() ;
            System.out.println("seçilen karakter:"+karakter.getKarakterAd());
        }else if(karakterSecim == 3){
            //şovalye set
            karakter = new Sovalye(120,15,25,120,new Agir("agir",80,80),new Mizrak("mizrak",4,50,50),"sovalye");
            silahDegeri = karakter.getSilah().getMaxSaglik() / karakter.getSilah().getHasar() ;
            System.out.println("seçilen karakter:"+karakter.getKarakterAd());
        }
        return karakter;
    }

    //karakter listele
    public int karakterListele(){
        int secim =0 ;
        while (true){

            System.out.println("KARAKTER SEÇİM EKRANI");
            System.out.println("1-savaşçı");
            System.out.println("2-okçu");
            System.out.println("3-şovalye");
            System.out.print("karakter seçiniz:");

            try {
                secim = scanner.nextInt();
                if (secim == 1 || secim == 2 || secim == 3) {
                    return secim;
                } else {

                }

            }catch (InputMismatchException e) {
                System.out.println("Geçersiz giriş. Lütfen bir sayı girin.");
                scanner.next(); // Geçersiz girişi temizle
            }


        }
    }

    //karakter metotları




    public void checkGameOver() {
        if (ormanTemizMi && nehirTemizMi && magaraTemizMi) {
            System.out.println("Tüm mekanlar temizlendi! Oyun bitti.");

            System.exit(0); // Oyunu kapat
        }
    }
}