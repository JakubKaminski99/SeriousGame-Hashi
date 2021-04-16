package pl.kaminski.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Klasa MenuItem odpowiada za ustawienia elementow
 */

public class MenuItem extends Rectangle {

    String name;
    Board board;

    /**
     *
     * @param x polozenie na osi x
     * @param y polozenie na osi y
     * @param width szerokosc elementu
     * @param height wysokosc elementu
     * @param name nazwa elementu
     * @param board
     */

    public MenuItem(float x, float y, float width, float height, String name, Board board) {
        super(x, y, width, height);
        this.name = name;
        this.board = board;
    }

    /**
     *
     * @param shapeRenderer odpowiada za polozenie, rozmiar oraz kolor generowanego elementu
     */

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.SKY);
        shapeRenderer.rect(x, y, width, height);
    }

    /**
     *
     * @param batch
     * @param font odpowiada za kolor oraz polozenie generowanego tekstu
     */

    public void renderFont(SpriteBatch batch, BitmapFont font) {
        font.setColor(Color.GOLDENROD);
        font.draw(batch, name, x + 10, y + height / 2 - 2);
    }

    /**
     *
     * @param hashi
     * @return
     */

    public GameScreen launch(Hashi hashi) {
        return new GameScreen(hashi, board);
    }
}
