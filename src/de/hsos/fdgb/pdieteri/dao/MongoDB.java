package de.hsos.fdgb.pdieteri.dao;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.stream.BaseStream;

public class MongoDB extends IOException {
    private String host;
    private int port;
    private String db;
    private String coll;

    protected MongoClient mongo;
    protected DB datenbank;
    protected DBCollection collecion;

    public MongoDB(String host, int port, String DB, String coll){
        this.host = host;
        this.port = port;
        this.db = DB;
        this.coll = coll;
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

    public boolean createObject(){
        try {
            Question q = new Question();
            DBObject doc = createDBObject(q);
            WriteResult result = collecion.insert(doc);

            return true;
        }catch (Exception e){
            System.err.println("Object konnte nicht in DB hinzugefuegt werden");
            e.getMessage();
        }
        return false;
    }
    public boolean read(){
    //    DBObject query = collecion.find();
        DBCursor cursor = collecion.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
        return true;
    }
    private DBObject createDBObject(Question q){
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

}
