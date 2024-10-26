package Silahlar;

public  abstract  class Silah {

    private String silahAd;
    private int hasar ;
    private int silahSaglik;
    private int maxSaglik ;

    public Silah(String silahAd, int hasar, int silahSaglik, int maxSaglik) {
        this.silahAd = silahAd;
        this.hasar = hasar;
        this.silahSaglik = silahSaglik;
        this.maxSaglik = maxSaglik;
    }

    public String getSilahAd() {
        return silahAd;
    }

    public void setSilahAd(String silahAd) {
        this.silahAd = silahAd;
    }

    public int getHasar() {
        return hasar;
    }

    public void setHasar(int hasar) {
        this.hasar = hasar;
    }

    public int getSilahSaglik() {
        return silahSaglik;
    }

    public void setSilahSaglik(int silahSaglik) {
        this.silahSaglik = silahSaglik;
    }

    public int getMaxSaglik() {
        return maxSaglik;
    }

    public void setMaxSaglik(int maxSaglik) {
        this.maxSaglik = maxSaglik;
    }
}
