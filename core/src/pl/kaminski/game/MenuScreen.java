package pl.kaminski.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

/**
 * Klasa Menuscreen odpowiada za menu z poziomami oraz muzyke w tle
 */

public class MenuScreen implements Screen {

    Music muzyka;
    Hashi hashi;
    ArrayList<MenuItem> item = new ArrayList<>();
    Texture backgroundMenu;

    /**
     *  Konstruktor MenuScreen
     * @param hashi instancja klasy Hashi
     */

    public MenuScreen(Hashi hashi) {
        this.hashi = hashi;
    }

    Sprite sprite;

    /**
     * Metoda show zawiera struktury poziomow oraz przyciski dostepu do poziomow
     */

    @Override
    public void show() {
        sprite = new Sprite(new Texture("island.png"));
        Board board = new Board(1);
        board.islands.add(new Island(30, 20, 100, 100, sprite, 1));
        board.islands.add(new Island(330, 20, 100, 100, sprite, 3));
        board.islands.add(new Island(780, 20, 100, 100, sprite, 1));
        board.islands.add(new Island(30, 120, 100, 100, sprite, 2));
        board.islands.add(new Island(330, 120, 100, 100, sprite, 7));
        board.islands.add(new Island(780, 120, 100, 100, sprite, 4));
        board.islands.add(new Island(480, 220, 100, 100, sprite, 1));
        board.islands.add(new Island(30, 320, 100, 100, sprite, 2));
        board.islands.add(new Island(180, 320, 100, 100, sprite, 1));
        board.islands.add(new Island(480, 420, 100, 100, sprite, 3));
        board.islands.add(new Island(780, 420, 100, 100, sprite, 3));
        board.islands.add(new Island(30, 520, 100, 100, sprite, 3));
        board.islands.add(new Island(330, 520, 100, 100, sprite, 5));
        board.islands.add(new Island(630, 520, 100, 100, sprite, 2));
        item.add(new MenuItem(Gdx.graphics.getWidth() / 2 - 65 - 70, Gdx.graphics.getHeight() / 2 + 120, 130, 40, "Pierwszy poziom", board));

        Board board1 = new Board(2);
        board1.islands.add(new Island(165, 20, 100, 100, sprite, 2));
        board1.islands.add(new Island(465, 20, 100, 100, sprite, 6));
        board1.islands.add(new Island(915, 20, 100, 100, sprite, 4));
        board1.islands.add(new Island(15, 120, 100, 100, sprite, 4));
        board1.islands.add(new Island(315, 120, 100, 100, sprite, 2));
        board1.islands.add(new Island(15, 240, 100, 100, sprite, 4));
        board1.islands.add(new Island(465, 240, 100, 100, sprite, 8));
        board1.islands.add(new Island(765, 240, 100, 100, sprite, 2));
        board1.islands.add(new Island(615, 320, 100, 100, sprite, 1));
        board1.islands.add(new Island(915, 320, 100, 100, sprite, 5));
        board1.islands.add(new Island(15, 420, 100, 100, sprite, 2));
        board1.islands.add(new Island(465, 420, 100, 100, sprite, 4));
        board1.islands.add(new Island(165, 520, 100, 100, sprite, 2));
        board1.islands.add(new Island(915, 520, 100, 100, sprite, 4));
        item.add(new MenuItem(Gdx.graphics.getWidth() / 2 - 65 +70 , Gdx.graphics.getHeight() / 2 + 120, 130, 40, "Drugi poziom", board1));

        Board board2 = new Board(3);
        board2.islands.add(new Island(15, 20, 100, 100, sprite, 1));
        board2.islands.add(new Island(315, 20, 100, 100, sprite, 2));
        board2.islands.add(new Island(615, 20, 100, 100, sprite, 1));
        board2.islands.add(new Island(465, 120, 100, 100, sprite, 2));
        board2.islands.add(new Island(765, 120, 100, 100, sprite, 3));
        board2.islands.add(new Island(15, 220, 100, 100, sprite, 5));
        board2.islands.add(new Island(315, 220, 100, 100, sprite, 5));
        board2.islands.add(new Island(765, 220, 100, 100, sprite, 3));
        board2.islands.add(new Island(165, 320, 100, 100, sprite, 1));
        board2.islands.add(new Island(315, 320, 100, 100, sprite, 3));
        board2.islands.add(new Island(615, 320, 100, 100, sprite, 1));
        board2.islands.add(new Island(15, 520, 100, 100, sprite, 3));
        board2.islands.add(new Island(765, 520, 100, 100, sprite, 2));
        item.add(new MenuItem(Gdx.graphics.getWidth() / 2 - 65-70, Gdx.graphics.getHeight() / 2 +60, 130, 40, "Trzeci poziom", board2));

        Board board3 = new Board(4);
        board3.islands.add(new Island(30, 20, 100, 100, sprite, 2));
        board3.islands.add(new Island(330, 20, 100, 100, sprite, 2));
        board3.islands.add(new Island(630, 20, 100, 100, sprite, 1));
        board3.islands.add(new Island(180, 120, 100, 100, sprite, 1));
        board3.islands.add(new Island(480, 120, 100, 100, sprite, 3));
        board3.islands.add(new Island(780, 120, 100, 100, sprite, 4));
        board3.islands.add(new Island(30, 220, 100, 100, sprite, 4));
        board3.islands.add(new Island(780, 220, 100, 100, sprite, 6));
        board3.islands.add(new Island(180, 320, 100, 100, sprite, 1));
        board3.islands.add(new Island(480, 320, 100, 100, sprite, 3));
        board3.islands.add(new Island(30, 420, 100, 100, sprite, 3));
        board3.islands.add(new Island(480, 420, 100, 100, sprite, 4));
        board3.islands.add(new Island(780, 420, 100, 100, sprite, 2));
        item.add(new MenuItem(Gdx.graphics.getWidth() / 2 - 65+70, Gdx.graphics.getHeight() / 2 + 60, 130, 40, "Czwarty poziom", board3));

        batch = new SpriteBatch();
        renderer = new ShapeRenderer();
        font = new BitmapFont();
    }

    SpriteBatch batch;
    ShapeRenderer renderer;
    BitmapFont font;

    /**
     * metoda render odpowiada za wygenerowanie obrazu tla oraz muzyki w tle
     * @param delta
     */

    @Override
    public void render(float delta) {
        muzyka = Gdx.audio.newMusic(Gdx.files.internal("muzyka.mp3"));
        muzyka.setVolume(0.2f);
        muzyka.play();
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backgroundMenu = new Texture("t.jpg");
        batch.begin();
        batch.draw(backgroundMenu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        for (MenuItem menuItem : item) {
            menuItem.render(renderer);
        }
        renderer.end();

        batch.begin();
        for (MenuItem menuItem : item) {
            menuItem.renderFont(batch, font);
        }
        batch.end();


        if (Gdx.input.justTouched()) {
            float x = Gdx.input.getX(), y = Gdx.graphics.getHeight() - Gdx.input.getY();
            for (MenuItem menuItem : item) {
                if (menuItem.contains(x, y)) hashi.setScreen(menuItem.launch(hashi));
            }
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
    }
}
