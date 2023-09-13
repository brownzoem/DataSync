#import statements
import pg_db
import couchbase.n1ql
import csv
from couchbase.exceptions import QueryIndexAlreadyExistsException
from config import cb, cb_coll
from config import cluster

def insert_csv(filename, given_key):
    #refereces: https://forums.couchbase.com/t/import-a-csv-to-couchbase-bucket/28134
    # https://www.geeksforgeeks.org/convert-csv-to-json-using-python/
    
    data = {}   #dictionary
    with open(filename, encoding='utf-8') as csvf:
        csvReader = csv.DictReader(csvf)
        
        #convert each row into a dictionary adn add it to the data
        for rows in csvReader:
            # print(rows)
            key = rows[given_key]
            data[key] = rows
            try:
                cb_coll.upsert(key,rows)
                #cb_keys.upsert()
                print("Couchbase Insert Success")
            except(Exception) as error:
                print(error)
    
def empty_cluster():
    for item in self.list_ids:
        remove_result = cb_coll.remove(item)
        print("CAS:", remove_result.cas)
        

def get_data():
    #ERROR: WHEN I GET DATA I GET DATA OUT OF ORDER, gets it in alphabetical order
    #get data for specific collection
    
    # need later
    # try:
    #     cluster.query("CREATE PRIMARY INDEX ON default._default._default;")
    # except QueryIndexAlreadyExistsException:
    #     print("index already exists")
    
    #query all documents
    #data = cluster.query("SELECT * from default._default._default")
    sql = """SELECT * FROM default._default._default;"""
    #nq = N1QLQuery("SELECT META().id FROM default._default_default")
    
    # get id select meta().id from `default`.`_default`.`_default` data order by meta().id
    
    result = cluster.query(sql)
    data = []
    for row in result:
        data.append(row)
        #print(row)
    print(data)

    #get all documents
    #data is a list of dict

    # data = [row['_default'] for row in data]
    # for element in data:
    #     print(element)
    #     print()
    # print(data[0]['_default'])
    # return data
    
