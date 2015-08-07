//describe('test schedules', function() {
//    var firstNumber = element(by.model('first'));
//    var secondNumber = element(by.model('second'));
//    var goButton = element(by.id('gobutton'));
//    var latestResult = element(by.binding('latest'));
//    var history = element.all(by.repeater('result in memory'));
//
//    function add(a, b) {
//        firstNumber.sendKeys(a);
//        secondNumber.sendKeys(b);
//        goButton.click();
//    }
//
//    beforeEach(function() {
//        browser.get('http://localhost:8080/web/#/schedules');
//    });
//
//    it('should have a history', function() {
//        add(1, 2);
//        add(3, 4);
//
//        expect(history.count()).toEqual(2);
//
//        add(5, 6);
//
//        expect(history.count()).toEqual(0); // This is wrong!
//    });
//});

var logger = require('./utils/logger');

var delayFn = function() {
    return browser.sleep(0);
};

describe('test schedules', function() {

    beforeEach(function() {

        logger.trace('redirect to:', '#/schedules');
        browser.get('#/schedules');
    });

    it('check url.', function() {

        browser.getLocationAbsUrl()
            .then(function(url) {

                logger.info('assertion:', '/schedules');
                expect(url).toBe('/schedules');
            })
            .then(delayFn);
    });

    it('check schedules count',function(){

        logger.info('assertion:','/schedules count');
        expect(element.all(by.repeater('schedule in schedules')).count()).toEqual(4);
    });

    it('check schedule value',function(){

        element.all(by.repeater('schedule in schedules')).then(function(schedules) {

            logger.info('assertion:','/schedule1 courseName is correct');

            var courseName = schedules[0].element(by.className('courseName'));
            expect(courseName.getText()).toEqual('瑜伽');
        });
    });




});
