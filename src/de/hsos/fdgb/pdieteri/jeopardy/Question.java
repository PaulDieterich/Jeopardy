package de.hsos.fdgb.pdieteri.jeopardy;

public class Question {

    private String id;
    private String category;
    private String air_date;
    private String question;
    private String value;
    private String answer;
    private String round;
    private String show_number;

    public Question(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getShow_number() {
        return show_number;
    }

    public void setShow_number(String show_number) {
        this.show_number = show_number;
    }

}
