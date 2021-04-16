package pl.kaminski.game;

import com.badlogic.gdx.Game;

/**
 *  Klasa Hashi jest rozszerzeniem klasy Game biblioteki Gdx
 */

public class Hashi extends Game {

    /**
     * metoda wywolywana przy wyswietlaniu elementow
     */

    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
