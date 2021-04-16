package pl.kaminski.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

/**
 * Klasa Island jest rozszerzeniem klasy GameObject odpowiadajaca w grze za obiekty wysp
 */

public class Island extends GameObject {
    int nbConnections;
    ArrayList<Island> islands = new ArrayList<>();

    /**
     * Konstruktor Island
     * @param sprite instancja klasy Sprite
     */

    public Island(Sprite sprite) {
        super(sprite);
    }

    /**
     * Konstruktor Island
     * @param x polozenie na osi x
     * @param y polozenie na osi y
     * @param width szerokosc elementu
     * @param height wysokosc elementu
     * @param sprite instacja klasy Sprite
     * @param nbConnections ilosc polaczen miedzy elementami
     */

    public Island(float x, float y, float width, float height, Sprite sprite, int nbConnections) {
        super(x, y, width, height, sprite);
        this.nbConnections = nbConnections;
    }

    /**
     * metoda isGood informuje czy wyspa posiada prawidlowa ilosc polaczen
     * @param islands argument w postaci tablicy wysp
     * @return zwraca wartosc true/false
     */

    public boolean isGood(ArrayList<Island> islands) {
        return getConnections(islands) == nbConnections;
    }

    /**
     *
     * @param islands argument w postaci tablicy wysp
     * @return metoda ta zwraca ilosc polaczen wyspy
     */

    public int getConnections(ArrayList<Island> islands) {
        int tmp = this.islands.size();
        for (Island island : islands) {
            if (island.islands.contains(this) && !island.equals(this)) tmp++;
        }
        return tmp;
    }

}
