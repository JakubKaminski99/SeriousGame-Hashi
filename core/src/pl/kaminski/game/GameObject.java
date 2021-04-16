package pl.kaminski.game;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Klasa GameObject rozszerza klase Rectangle z biblioteki GDX
 */

public class GameObject extends Rectangle {
    Sprite sprite;

    /**
     * konstruktor GameObject
     * @param sprite instancja klasy Sprite
     */

    public GameObject(Sprite sprite) {
        this.sprite = sprite;
    }

    /**
     * konstruktor GameObject
     * @param x polozenie na osi x
     * @param y polozenie na osi y
     * @param width parametr odpowiadajacy za szerokosc
     * @param height parametr odpowiadajacy za wysokosc
     * @param sprite instancja klasy Sprite
     */

    public GameObject(float x, float y, float width, float height, Sprite sprite) {
        super(x, y, width, height);
        this.sprite = sprite;
    }

    /**
     * metoda draw
     * @param sb instancja klasy SpriteBatch
     */

    public void draw(SpriteBatch sb){
        sprite.setBounds(x,y,width,height);
        sprite.draw(sb);
    }
}
