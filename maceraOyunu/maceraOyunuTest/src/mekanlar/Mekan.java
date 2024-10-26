package mekanlar;

import canavarlar.Canavar;

public abstract class Mekan {


    Canavar canavar;
    private String mekanAd;
    private boolean temizlendi =false ;

    public Mekan(Canavar canavar, String mekanAd) {
        this.canavar = canavar;
        this.mekanAd = mekanAd;
    }


    public boolean isTemizlendi() {
        return temizlendi;
    }

    public void setTemizlendi(boolean temizlendi) {
        this.temizlendi = temizlendi;
    }




    public Canavar getCanavar() {
        return canavar;
    }

    public void setCanavar(Canavar canavar) {
        this.canavar = canavar;
    }

    public String getMekanAd() {
        return mekanAd;
    }

    public void setMekanAd(String mekanAd) {
        this.mekanAd = mekanAd;
    }

    @Override
    public String toString() {
        return this.mekanAd;
    }
}
