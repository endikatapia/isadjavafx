package ehu.isad;

import java.util.ArrayList;

public class Bilduma {

    private String izena;
    private ArrayList<Argazki> argazkiak;

    public Bilduma(String izena) {
        this.izena = izena;
        this.argazkiak=new ArrayList<Argazki>();
    }

    @Override
    public String toString() {
        return izena;
    }

    public String getIzena() {
        return izena;
    }
}
