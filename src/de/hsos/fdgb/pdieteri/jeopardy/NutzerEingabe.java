package de.hsos.fdgb.pdieteri.jeopardy;

import de.hsos.fdgb.pdieteri.jeopardy.Spieler;
import de.hsos.fdgb.pdieteri.ui.EinUndAusgabe;

public class NutzerEingabe {

    private EinUndAusgabe io = new EinUndAusgabe();
    NutzerEingabe(){}

    public String nutzerNameEingabe(){
        String eingabe;
        String expt;
        boolean x = false;
        do{
            System.out.println("Bitte geben Sie ihren Namen an");
            eingabe = io.leseString();
            if(!eingabe.isEmpty()){
                System.out.println("Bitte bestätigen se den namen: " + eingabe + "(y) / (n)");
                expt = io.leseString();
                if(expt.equals("y")){
                    return eingabe;
                }else{
                    x = true;
                }
            }
        }while(x);
        return eingabe;
    }
    public String chooseCategory(){
        System.out.println("Wälen sie eine Category aus!");
        String eingabe =  io.leseString();
        return eingabe;
    }
}
