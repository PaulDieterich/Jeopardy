package de.hsos.fdgb.pdieteri.jeopardy;

import com.mongodb.MongoClient;
import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import de.hsos.fdgb.pdieteri.dao.MongoDao;
import de.hsos.fdgb.pdieteri.ui.NutzerEingabe;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Aggregates.sample;

public class Spiel {

    ArrayList<Player> highscore;
    ArrayList<Player> players;
    public Spiel(){
        highscore = new ArrayList<Player>();
        players = new ArrayList<Player>();
    }

    public void Start(){
        NutzerEingabe io = new NutzerEingabe();
        MongoDao md = new MongoDao("localhost", 27017,"jeopardy","questions");
        md.connect();

        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();

        System.out.println("Herzlichen Willkommen bei Jeopardy!!");
        io.nutzerNameEingabe(p1);
        io.nutzerNameEingabe(p2);
        io.nutzerNameEingabe(p3);

        players.add(p1);
        players.add(p2);
        players.add(p3);

        System.out.println("Dann wollen wir keine Zeit verlieren " + p1.getName() + " fängt an");
        System.out.println("Wenn Sie die antwort wissen muss; \n Spieler1 (1) druecken \n Spieler2 (2) druecken \n Spieler3 (3) druecken");
        //Auslesen von 5 Kategorien in einen Array
        String[] categoryen = new String[5];
        categoryen = md.getCategorys();

        Spielfeld spielfeld = new Spielfeld(categoryen);
        //spielfeld.zeichneSpielfeld();

        String anwaerter = "";
        for (int i = 0; i < 25; i++) {

            spielfeld.zeichneSpielfeld();
            if (i != 0) System.out.println(anwaerter + "ist dran");
            System.out.println("Wählen Sie eine Category:");
            String category = io.leseString();
            System.out.println("Wählen Sie ein Preis:");
            int preis = io.leseInteger();

            //TODO: fehlerbehebung wenn nichts gefunden wird oder falsche eingabe.
            //aus datenbank etwas auswählen mit der Category und Preis

            Question q = md.getQuestion(category, preis);
            System.out.println("DIE FRAGE IST: \n " + q.getQuestion());

            int player = io.werAntwortet();
           while (!io.spielerAntwort(player, players,q,preis)){
               if(player <= players.size()) player++;
           }

            spielfeld.eliminiereFeld(category, preis);
        }

        System.out.println("Gewonnen hat " + highscore.get(0).getName() + " mit " + highscore.get(0).getMoney() + " Dollar");
        ende();
    }


    public void ende(){
    //TODO: add highscore to players collection und soteire diese
                /*      Collections.sort(highscore, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getMoney().compareTo(o2.getMoney());
            }
        });*/

    }
}
