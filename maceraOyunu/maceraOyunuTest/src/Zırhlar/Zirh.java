package Zırhlar;

public abstract class Zirh {

    private String zirhAd;
    private int zirhSaglik;
    private int maxSaglik;


    public Zirh(String zirhAd, int zirhSaglik, int maxSaglik) {
        this.zirhAd = zirhAd;
        this.zirhSaglik = zirhSaglik;
        this.maxSaglik = maxSaglik;
    }

    public String getZirhAd() {
        return zirhAd;
    }

    public void setZirhAd(String zirhAd) {
        this.zirhAd = zirhAd;
    }

    public int getZirhSaglik() {
        return zirhSaglik;
    }

    public void setZirhSaglik(int zirhSaglik) {
        this.zirhSaglik = zirhSaglik;
    }

    public int getMaxSaglik() {
        return maxSaglik;
    }

    public void setMaxSaglik(int maxSaglik) {
        this.maxSaglik = maxSaglik;
    }
}
