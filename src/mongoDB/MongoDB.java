package mongoDB;

import com.mongodb.*;
import com.mongodb.ServerAddress;
import Core.*;

public class MongoDB {

    private static MongoClient mongoDBConnect;
    private static String dbName = "Accounts";
    private static String collectionName = "users";

    /**Called in LoginDriver to Make Connection */
    public static void setMongoConnection() throws Exception{
        MongoDB.mongoDBConnect = new MongoClient(new ServerAddress("Localhost", 27017));
        System.out.println("MongoDB connection created to Host: Localhost and Port: 27017");
    }

    /**Add User to the database */
    public static void addUserToMongoDB(User user) {
        DB database = mongoDBConnect.getDB(dbName);
        DBCollection collection = database.getCollection(collectionName);
        DBObject document = new BasicDBObject("First Name", user.getFirstName())
                .append("Last Name", user.getLastName())
                .append("DOB", user.getDob())
                .append("Gender", user.getGender())
                .append("Username", user.getUserName())
                .append("Email", user.getEmail())
                .append("Phone Number", user.getPhone())
                .append("Password", user.getPassword())
                .append("Profile Pic", user.getPhoto());
        collection.insert(document);
    }

    /**Creates a Cursor to point to a user in the DB */
    private static DBCursor getUserCursor(String field, String data) {
        DB database = MongoDB.mongoDBConnect.getDB(dbName);
        DBCollection collection = database.getCollection(collectionName);
        DBCursor userCursor = collection.find(new BasicDBObject(field, data));

        return userCursor;
    }

    /**Query DB for User by Username */
    public static User getUser(String userName){
        DBCursor cursor = getUserCursor("Username", userName);
        User user = null; //instantiate user to null
        DBObject dataObject; //declare data holding variable object

        while (cursor.hasNext()) {
            dataObject = cursor.next();
            user = new User((String) dataObject.get("First Name"),
                    (String) dataObject.get("Last Name"),
                    (String) dataObject.get("DOB"),
                    (String) dataObject.get("Gender"),
                    (String) dataObject.get("Username"),
                    (String) dataObject.get("Password"),
                    (String) dataObject.get("Email"),
                    (String) dataObject.get("Phone Number"),
                    (String) dataObject.get("Profile Pic"));
        }
        return user; //returns all user information
    }

    /**Check if Username already exists in DB */
    public static boolean doesUsernameExist(String userName) {
        DBCursor user = getUserCursor("Username",userName);
        boolean usernameExists = false;

        if (user.size() >= 1) {
            usernameExists = true;
        } else if (user.size()==0) {
            usernameExists = false;
        }
        return usernameExists;
    }

}
