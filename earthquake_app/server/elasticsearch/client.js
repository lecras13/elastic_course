const {Client} = require('@elastic/elasticsearch');

const client = new Client({
    node: 'http://localhost:9200', // Elasticsearch endpoint
    auth: {
        username: 'elastic',
        password: 'elastic'
    }
});

client.ping()
    .then(response => console.log("you are connected"))
    .catch(error => console.error("you are not connected"))

module.exports = client;