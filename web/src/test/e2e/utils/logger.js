var log4js = require('log4js');

log4js.configure({
    appenders: [
        { type: 'console' },
        { type: 'file', filename: 'reports/e2e-test.txt'}
    ]
});

var logger = log4js.getLogger('E2E-test');
//TRACE, DEBUG, INFO, WARN, ERROR, FATAL
logger.setLevel('TRACE');

module.exports = logger;