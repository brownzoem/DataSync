from time import sleep
from json import dumps
from kafka import KafkaProducer
import requests

import sys
from random import choice
from argparse import ArgumentParser, FileType
from configparser import ConfigParser
from confluent_kafka import Producer

#initialize kafka producer
producer = KafkaProducer(bootstrap_servers=['localhost:9092'],
                         value_serializer=lambda x:
                         dumps(x).encode('utf-8'))

#get data from Couchbase
#listen to events and send json to
