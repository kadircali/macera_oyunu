package mekanlar;

import Esyalar.Su;
import canavarlar.Ayi;
import canavarlar.Canavar;

public class Nehir  extends Mekan{

    private static Nehir instance; // Singleton örneği

    // Özel yapıcı
    private Nehir(Canavar canavar, String mekanAd) {
        super(canavar, mekanAd);
    }

    // Singleton metodu
    public static Nehir getInstance() {
        if (instance == null) {
            instance = new Nehir(new Ayi("ayi", 50, 6, new Su("su", 3)), "nehir"); // Burada uygun canavarı seçin
        }
        return instance;
    }
}
