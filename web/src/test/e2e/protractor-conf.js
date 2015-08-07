exports.config = {
    seleniumAddress: 'http://localhost:4444/wd/hub',
    specs: ['spec.js'],
    //multiCapabilities: [{
    //    browserName: 'firefox'
    //}, {
    //    browserName: 'chrome'
    //}]
    capabilities: {
        'browserName': 'chrome'
    },
    baseUrl: 'http://localhost:8080/web/',
    onPrepare: function () {
        'use strict';

        browser.addMockModule('mock', function () {
            angular.module('mock', [])
                .run(function ($animate) {
                    $animate.enabled(false);
                });
        });
    },

    debug: false
};

//exports.config = {
//    allScriptsTimeout: 30000,
//
//    specs: [
//        'spec.js'
//    ],
//
//    capabilities: {
//        'browserName': 'chrome' //'firefox'
//    },
//
//    chromeOnly: false,
//
//    baseUrl: 'http://localhost:8000/',
//
//    framework: 'jasmine',
//    //
//    //onPrepare: function () {
//    //    'use strict';
//    //
//    //    browser.addMockModule('mock', function () {
//    //        angular.module('mock', [])
//    //            .run(function ($animate) {
//    //                $animate.enabled(false);
//    //            });
//    //    });
//    //},
//
//    debug: false,
//
//    jasmineNodeOpts: {
//        showColors: true,
//        defaultTimeoutInterval: 30000
//    }
//};