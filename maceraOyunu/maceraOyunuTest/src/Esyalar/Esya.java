package Esyalar;

public abstract class Esya {
    private String esyaAdi ; //ekmek odun
    private int esyaDegeri; // satılırsa gelecek para


    public Esya(String esyaAdi, int esyaDegeri) {
        this.esyaAdi = esyaAdi;
        this.esyaDegeri = esyaDegeri;
    }

    public String getEsyaAdi() {
        return esyaAdi;
    }

    public void setEsyaAdi(String esyaAdi) {
        this.esyaAdi = esyaAdi;
    }

    public int getEsyaDegeri() {
        return esyaDegeri;
    }

    public void setEsyaDegeri(int esyaDegeri) {
        this.esyaDegeri = esyaDegeri;
    }
}
