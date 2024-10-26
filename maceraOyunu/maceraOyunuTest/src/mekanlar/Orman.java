package mekanlar;

import Esyalar.Odun;
import canavarlar.Canavar;
import canavarlar.Vampir;

public class Orman extends  Mekan{

    private static Orman instance; // Singleton örneği

    // Özel yapıcı
    private Orman(Canavar canavar, String mekanAd) {
        super(canavar, mekanAd);
    }

    // Singleton metodu
    public static Orman getInstance() {
        if (instance == null) {
            instance = new Orman(new Vampir("vampir", 40, 3, new Odun("odun", 3)), "orman"); // Burada uygun canavarı seçin
        }
        return instance;
    }
}
