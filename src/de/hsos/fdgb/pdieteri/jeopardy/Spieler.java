package de.hsos.fdgb.pdieteri.jeopardy;

public class Spieler{
    private String id;
    private String name;
    private int punktestand = 0;

    public Spieler(String name){
        setName(name);
    }
    public Spieler(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPunktestand() {
        return punktestand;
    }
    public void setPunktestand(int punktestand){
        this.punktestand = punktestand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
