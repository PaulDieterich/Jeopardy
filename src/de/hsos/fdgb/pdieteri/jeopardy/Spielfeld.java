package de.hsos.fdgb.pdieteri.jeopardy;
import com.mongodb.DBCollection;

public class Spielfeld {

    String[][] spielfeld = new String[6][5];

    public Spielfeld(String[] a){

        spielfeld [0][0] = a[0];
        spielfeld [0][1] = a[1];
        spielfeld [0][2] = a[2];
        spielfeld [0][3] = a[3];
        spielfeld [0][4] = a[4];

        for (int i = 0; i<5; i++) {
          spielfeld[1][i] = "200";
          spielfeld[2][i] = "400";
          spielfeld[3][i] = "600";
          spielfeld[4][i] = "800";
          spielfeld[5][i] = "1000";
        }
    }

    public void eliminiereFeld(String cat, Integer zahl){
        int tempcat=0;
        int tempzahl=0;
        String z = Integer.toString(zahl);

      for (int i = 0; i<5 ;++i){
            if (spielfeld[0][i].equals(cat)) {
                tempcat = i;
            }
            if (spielfeld[i+1][0].equals(z)) {
                tempzahl = i + 1;
            }
        }
        spielfeld[tempzahl][tempcat] = "X";
    }

    public void zeichneSpielfeld(){
        for (int i=0; i<6; i++){
            System.out.println(spielfeld[i][0] + "\t\t" + spielfeld[i][1] + "\t\t" +spielfeld[i][2] + "\t\t" +spielfeld[i][3] + "\t\t" + spielfeld[i][4]);
        }
    }

}
