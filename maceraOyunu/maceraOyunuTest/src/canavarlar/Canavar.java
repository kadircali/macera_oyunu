package canavarlar;

import Esyalar.Esya;

public abstract class Canavar {

    private String canavarAdi;
    private int canavarCani;
    private int canavarHasari;
    private Esya canavarEsyasi;


    public Canavar(String canavarAdi, int canavarCani, int canavarHasari, Esya canavarEsyasi) {
        this.canavarAdi = canavarAdi;
        this.canavarCani = canavarCani;
        this.canavarHasari = canavarHasari;
        this.canavarEsyasi = canavarEsyasi;
    }


    public String getCanavarAdi() {
        return canavarAdi;
    }

    public void setCanavarAdi(String canavarAdi) {
        this.canavarAdi = canavarAdi;
    }

    public int getCanavarCani() {
        return canavarCani;
    }

    public void setCanavarCani(int canavarCani) {
        this.canavarCani = canavarCani;
    }

    public int getCanavarHasari() {
        return canavarHasari;
    }

    public void setCanavarHasari(int canavarHasari) {
        this.canavarHasari = canavarHasari;
    }

    public Esya getCanavarEsyasi() {
        return canavarEsyasi;
    }

    public void setCanavarEsyasi(Esya canavarEsyasi) {
        this.canavarEsyasi = canavarEsyasi;
    }
}
