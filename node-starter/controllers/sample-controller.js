const service = require('../services/sample-service');

module.exports = function(app){

    // Very simple GET.
    app.get('/', (req, res) => {
        return res.send(service.getSample());
    });

    // GET returning a JSON model.
    app.get('/:value', (req, res) => {
        return res.send(service.getParametrizedSample(req.params.value));
    });

    // POST uploading a value in s3.
    app.post('/create', (req, res) => {
      return res.send(service.uploadSample(req.params.value));
    });
}
