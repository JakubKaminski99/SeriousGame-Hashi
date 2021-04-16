package pl.kaminski.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Klasa GameScreen odpowiada za wyswietlanie
 */

public class GameScreen implements Screen {

    SpriteBatch batch;
    Texture img;
    Hashi hashi;

    /**
     * konstrukotr GameScreen
     * @param hashi parametr bedacy instancja klasy Hashi
     * @param board parametr bedacy instancja klasy Board
     */
    public GameScreen(Hashi hashi, Board board) {
        this.board = board;
        this.hashi = hashi;
    }

    Texture background;
    Texture fact;
    Texture backgroundMenu;
    BitmapFont font;
    Texture playButtonActive;
    Texture playButtonInactive;
    Board board;
    Sprite sprite;
    ShapeRenderer renderer;
    Island island;

    /**
     * metoda show odpowiada za inicjalizacje (zapisuje dane elementy do pamieci)
     */

    @Override
    public void show() {
        batch = new SpriteBatch();
        img = new Texture("island.png");
        background = new Texture("water.jpg");
        backgroundMenu = new Texture("t.jpg");
        fact = new Texture("c" + board.lvl + ".jpg");
        sprite = new Sprite(img);
        font = new BitmapFont();
        font.getData().setScale(4 / 3);
        renderer = new ShapeRenderer();
    }

    /**
     * metoda render odpowiada za wyswietlanie na ekranie
     * @param delta odpowiada za renderowanie (czas miedzy klatkami)
     */

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (board.isFinished()) {
            batch.begin();
            batch.draw(fact, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.end();
            if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
                hashi.setScreen(new MenuScreen(hashi));
            }

        } else {
            if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
                hashi.setScreen(new MenuScreen(hashi));
            }
            update();
            batch.begin();
            batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            board.draw(batch);
            font.draw(batch, "Ilosc polaczen: " + String.valueOf(board.getAllConnections()), 150, 700);
            batch.end();

            renderer.begin(ShapeRenderer.ShapeType.Filled);
            renderer.setColor(Color.BROWN);
            board.drawConnections(renderer);
            if (island != null) {
                renderer.rectLine(island.x + island.width / 2, island.y + island.height / 2, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 3);
            }
            renderer.end();
            batch.begin();
            board.drawMessage(font, batch);
            batch.end();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        font.dispose();
    }

    /**
     * metoda update odpowiada za mechanike laczenia oraz rozlaczania polaczen miedzy wysp
     */

    public void update() {
        if (island == null) {
            if (Gdx.input.justTouched()) {
                island = board.getIsland(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
            }
        } else {
            if (Gdx.input.justTouched()) {
                Island W = board.getIsland(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
                if (W == null) {
                    island = null;
                } else {
                    if (island.islands.contains(W)) {
                        island.islands.remove(W);
                    } else {
                        if ((W.x == island.x || W.y == island.y) && W!=island) {
                            island.islands.add(W);
                        }
                    }
                    island = null;
                }
            }
        }
    }

}
