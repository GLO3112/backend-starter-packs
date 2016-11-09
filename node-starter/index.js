const express = require('express');
const bodyParser = require('body-parser');
const errors = require('./common/errors');
const cors = require('cors');

const app = express();
const corsOptions = {
    origin: '*',
    methods: ['GET', 'PUT', 'POST', 'PATCH', 'DELETE', 'UPDATE'],
    credentials: true
};

app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(__dirname + '/public'));

app.use(errors.genericErrorHandler);

require('./controllers/sample-controller')(app);

const port = process.env.PORT || 3000;
app.listen(port);

console.log(`App started on port ${port}`)
