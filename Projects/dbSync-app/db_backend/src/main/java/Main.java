//import com.couchbase.client.java.json.JsonObject;
//import com.couchbase.client.java.kv.MutationResult;
//
//import com.couchbase.client.java.*;
//
//import java.time.Duration;
//
//public class Main {
//    public static void main(String[] args) {
//        //instantiate Couchbase connection
//        String bucketName = "default";
//        String scopeName = "_default";
//        String collectionName = "_default";
//
//        ConnectCouchbase connector = ConnectCouchbase.getInstance();
//        Cluster cluster = connector.getCluster();
//        Bucket bucket = cluster.bucket(bucketName);
//        bucket.waitUntilReady(Duration.ofSeconds(10));
//        Scope scope = bucket.scope(scopeName);
//        Collection collection = scope.collection(collectionName);
//
//        //upsert document
//        MutationResult upsertResult = collection.upsert("1", JsonObject.create().put("name", "luffy"));
//
//        //insert works wimilarily to ypsert, but will fail if the document already exists
///*        try {
//            JsonObject content = JsonObject.create()
//                    .put("title", "My Blog Post 2");
//            MutationResult insertResult = collection.insert("document-key2", content);
//        } catch (DocumentExistsException ex) {
//            System.err.println("The document already exists!");
//        } catch (CouchbaseException ex) {
//            System.err.println("Something else happened: " + ex);
//        }*/
//
//    }
//}