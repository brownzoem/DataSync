from cb_sync import CB_Object
from pg_sync import PG_Object

def cascade_cb_to_pg(cb, pg):
    #data from non-relational is transformed into relational format and then inserted into relational
    #map non-relational data into tables, columns, and relationships
    data = cb.get_data()
    for record in data:
        pg.insert('customers', record)

def sync_table_cb_to_pg(table_name, cb, pg):
    #creates table and finds attributes if needed
    data = cb.get_data()
    #data is a list of maps
    pg.convert_to_table(table_name, data)
    

def reset_pg(pg):
    pg.create_table('customers')

def main():
    cb = CB_Object()
    pg = PG_Object()
    pg.create_customer_table()
    #cb.show_key_data()
    # for element in data:
    #     print(data)
    # pg.create_table()
    # cascade_cb_to_pg(cb, pg)
    
    # pg.drop_table('customer_1.csv')
    # sync_table_cb_to_pg('employees', cb, pg)
    # cb.insert_csv('employees.csv')
    # pg.create_table()
    # cb.insert_csv('customer_1.csv')
    # cb.insert_csv('customer_1.csv')
    # cb.get_data()
    # cb.insert_csv('customer_1.csv')
    # pg.insert_csv('customer_1.csv')
    # cascade_cb_to_pg(cb,pg)
    # pg.view_table('customers')
    # sync_table_cb_to_pg('customer1', cb, pg)
    # pg.view_table('customer1')
    
    

    

if __name__ == "__main__":
    main()