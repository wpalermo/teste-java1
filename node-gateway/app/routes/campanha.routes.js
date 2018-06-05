'use strict'

var express = require('express');
var request = require('request');
var router = express.Router();
var eureka = require('../config/eureka.js')

var service = '/campanha-service';


router.get(service, function(req, resp){

        var client = eureka.getClient();

        var campanhaInstances = client.getInstancesByAppId('campanha-service');
        console.log(campanhaInstances);

        request('http://localhost:8082/campanha/', function(err, res, body){
            console.log('error', err);
            console.log('statusCode', res && res.statusCode);
            console.log('body', body);
            resp.send('body: ' + body);
        });       
});


module.exports = router;