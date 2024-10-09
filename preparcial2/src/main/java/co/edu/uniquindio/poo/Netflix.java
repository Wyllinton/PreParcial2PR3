package co.edu.uniquindio.poo;

import java.util.ArrayList;

public class Netflix {
    private ArrayList<Serie> series;

    public Netflix() {
        this.series = new ArrayList<Serie>();
    }

    public ArrayList<Serie> getSeries() {
        return series;
    }
}
