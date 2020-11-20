package de.hsos.fdgb.pdieteri.dao;

import com.mongodb.*;
import de.hsos.fdgb.pdieteri.jeopardy.Question;
import de.hsos.fdgb.pdieteri.jeopardy.Spieler;

import java.awt.*;
import java.io.IOException;

public class MongoDao extends IOException {

    final String HOST = "localhost";
    final int PORT = 27017;
    final String DB = "jeopardy";
    final String COLLECTION = " questions";

    private String host;
    private int port;
    private String db;
    private String coll;

    protected MongoClient mongo;
    protected DB datenbank;
    protected DBCollection collecion;

    public MongoDao(String host, int port, String DB, String coll){
        this.host = host;
        this.port = port;
        this.db = DB;
        this.coll = coll;
    }
    public MongoDao(){
        this.host = HOST;
        this.port = PORT;
        this.db = DB;
        this.coll = COLLECTION;
    }
    public boolean connect() {
        try {
            mongo = new MongoClient(host, port);
            datenbank = mongo.getDB(db);
            collecion = datenbank.getCollection(coll);
            return true;
        } catch (Exception e) {
            System.err.println("Auf die Datenbank konnte nicht connectet werdem");
            e.getMessage();
        }
        return false;
    }
    public boolean createCollection(String name){
        connect();
        try {
            datenbank.createCollection(name, null);

        }catch(Exception e){
            System.err.println("Collection konnte nicht erstellt werden.");
            e.getMessage();
        }
        return false;
    }
    public boolean createSpielerObject(){
        try {
            Spieler s = new Spieler();
            DBObject doc = createQuestionDBObject(s);
            DBCollection collection = this.collecion;
            WriteResult result = collection.insert(doc);
            return true;
        }catch (Exception e){
            System.err.println("Object konnte nicht in DB hinzugefuegt werden");
            e.getMessage();
        }
        return false;
    }
    private DBObject createQuestionDBObject(Spieler s){
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        docBuilder.append("_id", s.getId());
        docBuilder.append("name", s.getName());
        docBuilder.append("name", s.getPunktestand());

        return docBuilder.get();
    }
    public boolean ListPlayer(DBCollection collection){
        try {
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("", "");
            DBCursor cursor = collection.find(searchQuery);
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
            return true;
        }catch (Exception e){
            e.getMessage();
        }
        return false;
    }
    public boolean createQuestionObject(DBCollection collection){
        try {
            Question q = new Question();
            DBObject doc = createQuestionDBObject(q);
            WriteResult result = collection.insert(doc);

            return true;
        }catch (Exception e){
            System.err.println("Object konnte nicht in DB hinzugefuegt werden");
            e.getMessage();
        }
        return false;
    }
    private DBObject createQuestionDBObject(Question q){
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        docBuilder.append("_id", q.getId());
        docBuilder.append("category", q.getCategory());
        docBuilder.append("air_date", q.getAir_date());
        docBuilder.append("question", q.getQuestion());
        docBuilder.append("value", q.getValue());
        docBuilder.append("answer", q.getAnswer());
        docBuilder.append("round", q.getRound());
        docBuilder.append("show_number", q.getShow_number());
        return docBuilder.get();
    }
    public boolean ListQuestion(){
        try {
            DBCollection collection = this.collecion;
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("answer","H2O");
            DBCursor cursor = collection.find(searchQuery);
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
            return true;
        }catch (Exception e){
            e.getMessage();
        }
        return false;
    }public boolean getCategorys(){
        try{
            DBCollection collection = this.collecion;
            BasicDBObject searchQuery = new BasicDBObject();

            List cat = new List();
            cat = (List) collection.distinct("Category");
            System.out.println(cat);

        }catch (Exception e){
            e.getMessage();
        }
        return false;
    }


}
