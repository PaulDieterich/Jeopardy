package de.hsos.fdgb.pdieteri.ui;

import de.hsos.fdgb.pdieteri.jeopardy.Player;
import de.hsos.fdgb.pdieteri.jeopardy.Question;
import de.hsos.fdgb.pdieteri.ui.EinUndAusgabe;

import java.util.ArrayList;

public class NutzerEingabe extends EinUndAusgabe{

   public NutzerEingabe(){}

    public String nutzerNameEingabe(Player p) {
        System.out.println("Geben Sie ihren namen ein.");
        return leseString();

    }
    public int werAntwortet(){
        System.out.println("Wer hat die Antwort?");
        return leseInteger();
    }
    public boolean spielerAntwort(int p, ArrayList<Player> players, Question q, int preis){
       System.out.print("Ihre Antwort? ");
       String antwort = leseString();

        if (antwort == q.getAnswer()) {
            System.out.println("sehr gut " + players.get(p).getName());
            players.get(p).setMoney(players.get(p).getMoney() + preis);
            return true;
        }
        System.out.println("leider falsch " + players.get(p).getName());
        players.get(p).setMoney(players.get(p).getMoney() - preis);
        return false;
    }

}
