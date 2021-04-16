package pl.kaminski.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

/**
 * Klasa Board odpowiada za relacje miedzy wyspami
 */

public class Board {
    ArrayList<Island> islands = new ArrayList<>();
    int lvl;

    /**
     * Konstruktor Board
     * @param lvl parametr bedacy liczba porzadkowa poziomu
     */

    public Board(int lvl) {
        this.lvl = lvl;
    }

    /**
     * metoda draw
     * @param sb
     */

    public void draw(SpriteBatch sb){
        for (Island island : islands) {
            island.draw(sb);
        }
    }

    /**
     * metoda ma za zadanie rysowanie linii miedzy polaczonymi wyspami
     * @param sb
     */

    public void drawConnections(ShapeRenderer sb){
        for (Island island1 : islands) {
            for (Island island : island1.islands) {
                sb.rectLine(island1.x+ island1.width/2, island1.y+ island1.height/2, island.x+ island.width/2, island.y+ island.height/2,5);
            }
        }
    }

    /**
     *  metoda drawMessage ma za zadanie poinformowac uzytkownika o sytuacji kiedy miedzy wyspami znajduja sie dwa mosty oraz nad kazda wyspa wyswietlic ilosc potrzebnych dla niej polaczen oraz ilosc obecnych poloaczen
     * @param font
     * @param sb
     */

    public void drawMessage(BitmapFont font, SpriteBatch sb){
        for (Island island1 : islands) {
            for (Island island : island1.islands) {
                if(island1.islands.contains(island) && island.islands.contains(island1)){
                    font.draw(sb, "2", (island1.x+ island1.width/2+ island.x+ island.width/2)/2, (island1.y+ island1.height/2+ island.y+ island.height/2)/2);
                }
            }
            font.draw(sb, island1.nbConnections +"", island1.x+ island1.width/2, island1.y+ island1.height/2);
            font.draw(sb, island1.getConnections(islands) +"", island1.x+ island1.width/2+35, island1.y+ island1.height/2+35);
        }
    }

    /**
     * metoda getIsland sprawdza czy w danym miejscu jest wyspa i jesli tak to ja zwraca
     * @param x polozenie na osi x
     * @param y polozenie na osi y
     * @return zwraca wyspe na podanych koordynatach lub jej brak
     */

    public Island getIsland(float x, float y){
        for (Island island : islands) {
            if(island.contains(x,y)){
                return island;
            }
        }
        return null;
    }

    /**
     *
     * @return metoda ta sprawdza czy kazda wyspa ma odpowiednia ilosc polaczen i zwraca wartosc true/false
     */

    public boolean isFinished(){
        for (Island island : islands) {
            if(!island.isGood(islands)) return false;
        }
        return true;
    }

    /**
     *
     * @return metoda zwraca laczna ilosc polaczen wszystkich wysp
     */

    public int getAllConnections(){
        int tmp = 0 ;
        for (Island island : islands) {
            tmp+=island.getConnections(islands);
        }
        return (tmp/2);
    }

}




