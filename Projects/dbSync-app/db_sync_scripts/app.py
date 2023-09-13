#create instance of Flask object
import testing.cb_sync as cb_sync
import json
import flask
from flask import Flask
from flask.views import MethodView
import marshmallow as ma
from flask_smorest import Api, Blueprint, abort

app = Flask(__name__)
app.config["API_TITLE"] = "My API"
app.config["API_VERSION"] = "v1"
app.config["OPENAPI_VERSION"] = "3.0.2"
api = Api(app)

#define a route
@app.route('/')
def hello_world():
    return 'Hello, World!'

#add a new endpoint that sends this data as a response to a request
@app.route('/users', methods=["GET"])
def users():
    print("users endpoint reached...")
    with open("users.json", "r") as f:
        data = json.load(f)
        data.append({
            "username": "user4",
            "pets": ["hamster"]
        })
        return flask.jsonify(data)

if __name__ == "__main__":
    app.run("localhost", 6969)