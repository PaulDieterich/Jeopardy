package de.hsos.fdgb.pdieteri.jeopardy;

import de.hsos.fdgb.pdieteri.dao.MongoDao;

import java.util.HashSet;
import java.util.List;

public class Spiel {

    private int spielerAnzahl = 3;
    private int rundenAnzahl = 10;
    private HashSet<Spieler> spielerListe;

    MongoDao mongoDao;

    Spiel(){
        mongoDao = new MongoDao();
        spielerListe = new HashSet<>();
    }

    public void Start(){
        mongoDao.connect();

        System.out.println("HERZLICH WILLKOMMEN!!");
       // SpielerHinzufuegen();
        mongoDao.getCategorys();

        for(int runde = 0; runde < rundenAnzahl; runde++ ){

        }


    }

    private void SpielerHinzufuegen(){
        NutzerEingabe input = new NutzerEingabe();
        for(int i = 1; i <= spielerAnzahl; i++){
            System.out.println("SPIELER " + i +".");
            String name = input.nutzerNameEingabe();
            Spieler p = new Spieler(name);
            spielerListe.add(p);
        }
    }

    public void Ende(){

    }
}
