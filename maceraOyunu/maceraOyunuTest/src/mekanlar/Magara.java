package mekanlar;

import Esyalar.Ekmek;
import canavarlar.Canavar;
import canavarlar.Zombi;

public class Magara  extends  Mekan{

    private static Magara instance; // Singleton örneği

    // Özel yapıcı
    private Magara(Canavar canavar, String mekanAd) {
        super(canavar, mekanAd);
    }

    // Singleton metodu
    public static Magara getInstance() {
        if (instance == null) {
            instance = new Magara(new Zombi("zombi", 60, 9, new Ekmek("ekmek", 4)), "magara"); // Burada uygun canavarı seçin
        }
        return instance;
    }
}
