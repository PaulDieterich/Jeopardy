package de.hsos.fdgb.pdieteri.jeopardy;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import de.hsos.fdgb.pdieteri.dao.MongoDB;


public class Main {

    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 27017;
        final String DB = "jeopardy";
        final String COLLECTION = " questions";

        MongoDB db = new MongoDB(HOST, PORT, DB, COLLECTION);
        db.connect();
        db.read();

    }

}

