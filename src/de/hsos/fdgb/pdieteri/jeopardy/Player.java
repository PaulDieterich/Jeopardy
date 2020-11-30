package de.hsos.fdgb.pdieteri.jeopardy;

public class Player{

    private String name;
    private Integer money;

    public Player(){
        name = "";
        money=0;
    }

    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }

    public void setMoney (int m){
        money=m;
    }
    public int getMoney() {
        return money;
    };


}
