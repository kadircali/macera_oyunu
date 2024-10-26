import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //nasıl bir şey olmalı?
        //oyun game sınıfınıın içindeki metotlarda dönmeli
        //her şey metoda ayrılmalı
        //problemler : karakter seçimi, mekan seçimi , savaş ekranı
        //karakter seçimi: bir metotta listeleme olsun, başka bir metotta karakter seçimi onaylansın
        //problem 1 çözüldü, karakter düzgünce seçiliyor
        //mekan seçimi: önce mekan listelenmeli(while döngüsü burada olsun) sonra başka bir mekan set metoduna gidilmeli her seferinde



        Game game = new Game();
        game.setKarakter();
        game.setMKarakterMekan();




    }
}