import psycopg2
from config import config
#pip install psycopg2
#psql postgres -U zoe           --> login to user
#CREATE DATABASE suppliers;     --> in psql

#tutorial reference: https://www.postgresqltutorial.com/postgresql-python/

#conn = psycopg2.connect("dbname=suppliers user=zoe password=maithi123")
#can create a configuration file

def get_cur(self):
    params = config()
        # print('Connecting to the PostgreSQL database...')
    conn = psycopg2.connect(**params)
    conn.autocommit = True
    cur = conn.cursor()
    return cur
    
def connect(self,commands):
    """ Connect to PostgreSQL database server """
    conn = None
    try:
        cur = self.get_cur()
        for command in commands:
            # print(command)
            try:
                # print(command)
                print(command)
                cur.execute(command)
                print("Postgres executed successfully")
            except(Exception) as error:
                print(error)
        
        #close the connection with the postgreSQL
        cur.close()
        # print("CLOSED CONNECTION")
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)

def drop_table(self,table_name):
    sql = (f"""DROP TABLE IF EXISTS {table_name};""",)
    self.connect(sql);

#I manually created this table but there should be a way to create it
def create_table(self):
    commands = (
    """DROP TABLE IF EXISTS customers;""",
    """CREATE TABLE customers (
        \ufeffCUSTOMER_ID VARCHAR(255),
        FIRST_NAME VARCHAR(255) NOT NULL,
        LAST_NAME VARCHAR(255) NOT NULL,
        PHONE_NUM VARCHAR(255),
        AGE INT,
        DOB VARCHAR(255),
        SSN VARCHAR(255),
        GENDER VARCHAR(255),
        INCOME BIGINT,
        ADDRESS VARCHAR(255),
        COUNTRY VARCHAR(255),
        CONTACT_PREF VARCHAR(255),
        MARITIAL_STATUS VARCHAR(255),
        JOINED_AT VARCHAR(255),
        EMAIL VARCHAR(255),
        INSURANCE_NUMBER VARCHAR(255),
        CITIZENSHIP VARCHAR(255),
        SAVINGS_NUMBER INT,
        CHECKINGS_NUMBER INT,
        JOB VARCHAR(255) )
    """,)
    self.connect(commands)
    
def create_customer_table(self):
    commands = (
    """DROP TABLE IF EXISTS customers;""",
    """CREATE TABLE customers (
        ID VARCHAR(255),
        FIRST_NAME VARCHAR(255) NOT NULL,
        LAST_NAME VARCHAR(255) NOT NULL,
        PHONE_NUM VARCHAR(255),
        AGE INT,
        ADDRESS VARCHAR(255),
        JOB VARCHAR(255) )
    """,)
    self.connect(commands)
    
def insert_csv(self,filename):
    #reference https://www.geeksforgeeks.org/python-import-csv-into-postgresql/
    
    sql = (f'''copy customers
    FROM '/Users/zoebrown/Projects/DBSyncProject/{filename}'
    DELIMITER ','
    CSV HEADER;''',)
    self.connect(sql)

def insert(self, table_name, record):
    attributes = []
    values = []
    a = ""
    v = ""
    for key in record:
        attributes.append(key)
        values.append(f"""'{record[key]}'""")
        print(type(record[key]))
    # a = ', '.join(attributes)
    # v = ', '.join(values)
    # sql = (f"""INSERT into {table_name}({a}) VALUES ({v})""",)
    # self.connect(sql)

def create_new_table(self, table_name, attributes):
    l = []
    for element in attributes:
        l.append(f"{element} VARCHAR(255)")
    str = ',\n'.join(l)
    sql = (f"""CREATE TABLE IF NOT EXISTS {table_name} (
        {str}
    )
            """,)
    self.connect(sql) 
    
def convert_to_table(self, table_name, data):
    #need to implement multiline insert
    check = False
    for record in data:
        attributes = []
        values = []
        for key in record:
            attributes.append(key)
            values.append(f"""'{record[key]}'""")
        a = ', '.join(attributes)
        v = ', '.join(values)
        if not check:
                self.create_new_table(table_name, attributes)
                check = True
        sql = (f"""INSERT into {table_name}({a}) VALUES ({v})""",)
        self.connect(sql)

def view_table(self,table_name):
    sql = f"""SELECT * FROM {table_name}"""
    cur = self.get_cur()
    cur.execute(sql)
    for i in cur.fetchall():
        print(i)
    cur.close()



# drop_table('customers')
# create_table()
# insert_csv('/Users/zoebrown/Projects/DBSyncProject/customer_1.csv')
# view_table('customers')