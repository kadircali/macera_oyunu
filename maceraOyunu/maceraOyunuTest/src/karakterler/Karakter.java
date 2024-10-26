package karakterler;

import Esyalar.Esya;
import Silahlar.Silah;
import Zırhlar.Zirh;
import mekanlar.Mekan;

import java.util.ArrayList;
import java.util.List;

public abstract class Karakter {
//karakteri düzgün oluştur

    private String karakterAd;
    private  Silah silah ;
    private Zirh zirh ;
    private int saglik;
    private int maxSaglik;;
    private int hasar ;
    private int para ;
    private List<Esya> karakterEsya = new ArrayList<Esya>();


    public void esyaEkle(Esya esya){

        karakterEsya.add(esya);
    }

    public  List<Esya> getEsyalar(){
        return karakterEsya;
    }

    //ekstra özellikler,bunları yapıcıda alma ,, maximum saglık ekle

    private Mekan mekan;
    private Esya esya;

    public Karakter(int maxSaglik, int para, int hasar, int saglik, Zirh zirh, Silah silah, String karakterAd) {
        this.maxSaglik = maxSaglik;
        this.para = para;
        this.hasar = hasar;
        this.saglik = saglik;
        this.zirh = zirh;
        this.silah = silah;
        this.karakterAd = karakterAd;
    }

    public Esya getEsya() {
        return esya;
    }

    public void setEsya(Esya esya) {
        this.esya = esya;
    }

    public String getKarakterAd() {
        return karakterAd;
    }

    public void setKarakterAd(String karakterAd) {
        this.karakterAd = karakterAd;
    }

    public Silah getSilah() {
        return silah;
    }

    public void setSilah(Silah silah) {
        this.silah = silah;
    }

    public Zirh getZirh() {
        return zirh;
    }

    public void setZirh(Zirh zirh) {
        this.zirh = zirh;
    }

    public int getSaglik() {
        return saglik;
    }

    public void setSaglik(int saglik) {
        this.saglik = saglik;
    }

    public int getHasar() {
        return hasar;
    }

    public void setHasar(int hasar) {
        this.hasar = hasar;
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    public int getMaxSaglik() {
        return maxSaglik;
    }

    public void setMaxSaglik(int maxSaglik) {
        this.maxSaglik = maxSaglik;
    }

    public Mekan getMekan() {
        return mekan;
    }

    public void setMekan(Mekan mekan) {
        this.mekan = mekan;
    }

    public void paraEksilt(int i) {
        this.para -= i ;
    }
    public void paraEkle(int i) {
        this.para += i ;
    }
}
