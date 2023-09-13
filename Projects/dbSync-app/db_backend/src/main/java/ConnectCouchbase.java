//import com.couchbase.client.java.*;
//import com.couchbase.client.java.kv.*;
//import com.couchbase.client.java.json.*;
//
//import java.time.Duration;
//
//public class ConnectCouchbase {
//    private static ConnectCouchbase instance = null;
//    static String connectionString = "couchbase://127.0.0.1";
//    private String bucketName = "default";
//    private String username = "Administrator";
//    private String password = "maithi123";
//    private Cluster cluster = null;
//    private Bucket bucket = null;
//
//    private ConnectCouchbase() {
//        try {
//
//            // Initialize the Connection
//            Cluster cluster = Cluster.connect(connectionString, username, password);
//            bucket = cluster.bucket(bucketName);
//            bucket.waitUntilReady(Duration.ofSeconds(10));
//
//        } catch (Exception e) {
//            System.out.println("Ooops!... something went wrong");
//            e.printStackTrace();
//
//        }
//    }
//
//    public static synchronized ConnectCouchbase getInstance() {
//        if (instance == null) {
//            instance = new ConnectCouchbase();
//        }
//        return instance;
//    }
//
//    public Cluster getCluster() {
//        return cluster;
//    }
//
//}