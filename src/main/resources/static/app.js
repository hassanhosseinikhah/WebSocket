// // var stompClient = null;
// // var SId = null;
// // var wId = null;
// //
var token = "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJjbGFyaXR5X3NzbyIsImlhdCI6MTYxNDA4ODkyMCwiZXhwIjoxNjE0MTE3NzIwLCJzdWIiOiJkRnNNSjVQQndVeXEvQm9VL2hhU29LUDNYeWZuWHplbjhkbHI5dGlJVkowRDZwaWxlN3Y3OEpHbjFOZ2IyVy9IIiwibnVhbmNlIjoiRC9xcEZ6WUVNdGVlMHlOVmR3N0xNZz09In0.e_sKdkq7JFlm055leU0Lzy6bG_KYCcx74apnWB0s5Nojc37jqKeebC2xNcFTIyKB8JXMFLzU4e-UMh4-YJlT28jSvZSDIJ0IC7Av5C3owXyK9_FM8MFf3h2uNqeLLp2nhtI4muWbAkoCKHMbJPI5R3bQK8gckH5DVNWb6bEVSM7UCNPJV3VS7w4ZxxtGj8cHko1B0B8QiuLUSyHbN9wOH84ZKmvMlSqLWyWj2nWSInLq01dGYlDqvCkA6yj3zN_lruh3Q8w8pCvcBBr0qR6nbTkj0S6qNhSSJjU7vqFgz4ptJ4sGP1XSqedHfGMacvfs_eAyxWH8E37743uk3qLp1g"
// // // var token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJDTEFSSVRZX0FETUlOIiwiZXhwIjoxNjA5NzQzNDI0LCJhdWQiOiI5bEFJMGZyb3FhRldXNTcyVE11d0JRPT0ifQ.2BHvfITJmBtrkeyMYTUsivIM_-V_9BaFL20Rpsijuoo_-awVXNmq9VOT9_DF5Yk5wMXachcoJkHV6zYV82E8cw"
// //
// // var noFilter = {"id":null,"name":"No Filter","description":"","groupFilter":{"rules":[],"condition":"AND","groups":[]},"preDefined":[]}
// // var testFilter = {
// //                      "id": 1958,
// //                      "name": "Network Faults",
// //                      "groupFilter": {
// //                          "id": 1983,
// //                          "condition": "AND",
// //                          "rules": [
// //                              {
// //                                  "id": 2389,
// //                                  "field": "type",
// //                                  "operator": "IN",
// //                                  "value": [
// //                                      "NETWORK_FAULT",
// //                                      "NETWORK_MANUAL_FAULT"
// //                                  ],
// //                                  "type": "LIST"
// //                              }
// //                          ],
// //                          "groups": []
// //                      },
// //                      "preDefined": []
// //                  }
// //
// // function setConnected(connected) {
// //     $("#connect").prop("disabled", connected);
// //     $("#disconnect").prop("disabled", !connected);
// //     if (connected) {
// //         $("#conversation").show();
// //     } else {
// //         $("#conversation").hide();
// //     }
// //     $("#greetings").html("");
// // }
//
// function connect() {
//     var socket = new SockJS('/alarm-websocket');
//     stompClient = Stomp.over(socket);
//     SId = $("#dash").val();
//     wId = $("#name").val();
//     stompClient.connect({Authorization: token}, function (frame) {
//         // setConnected(true);
//         console.log('Connected: ' + frame);
//
//         stompClient.subscribe('/topic/fault/create', function (greeting) {
//             console.log("id " + " response " + greeting);
//         });
//         //     stompClient.subscribe('/topic/fault/create', function (greeting) {
//         //         console.log("id " + " response " + greeting);
//         //     });
//         //     stompClient.subscribe('/topic/fault/delete', function (greeting) {
//         //         console.log("id " + " response " + greeting);
//         //     });
//         //     stompClient.subscribe('/topic/fault/upsert', function (greeting) {
//         //         console.log("id " + " response " + greeting);
//         //     });
//         //     stompClient.subscribe('/topic/work-order/create', function (greeting) {
//         //         console.log("id " + " response " + greeting);
//         //     });
//         //     stompClient.subscribe('/topic/work-order/delete', function (greeting) {
//         //         console.log("id " + " response " + greeting);
//         //     });
//         //     stompClient.subscribe('/topic/work-order/upsert', function (greeting) {
//         //         console.log("id " + " response " + greeting);
//         //     });
//         //     startProcedure();
//         // });
//         stompClient.heartbeat
//     })
// }
//
//
//
// connect()
// // function startProcedure() {
// //     stompClient.send("/app/serverTime/start", {sessionId: SId, widgetId: wId}, {});
// //
// //     stompClient.send("/app/fault/set-configuration", {sessionId: SId, widgetId: wId}, JSON.stringify(testFilter));
// //     stompClient.send("/app/work-order/set-configuration", {sessionId: SId, widgetId: wId}, JSON.stringify(testFilter));
// //     stompClient.send("/app/activity/set-configuration", {sessionId: SId, widgetId: wId}, JSON.stringify(testFilter));
// //
// //     stompClient.send("/app/fault/start", {sessionId: SId, widgetId: wId}, {});
// //     stompClient.send("/app/work-order/start", {sessionId: SId, widgetId: wId}, {});
// //     stompClient.send("/app/activity/start", {sessionId: SId, widgetId: wId}, {});
// // }
// //
// // function disconnect() {
// //     if (stompClient !== null) {
// //         stompClient.disconnect();
// //     }
// //     setConnected(false);
// //     console.log("Disconnected");
// // }
// //
// // function addDashboard() {
// //     SId = $("#dash").val();
// //     stompClient.send("/app/addDashboard", {sessionId: SId}, JSON.stringify(alarmDashboardWidget));
// //     // stompClient.send("/app/set-configuration", {}, JSON.stringify({'name': $("#name").val()}));
// // }
// //
// // function addChannel() {
// //     stompClient.send("/app/", {sessionId: SId, widgetId: $("#name").val()}, JSON.stringify(alarmWidget));
// // }
// //
// // function startChannel() {
// //     stompClient.send("/app/fault/start", {widgetId: wId}, null);
// // }
// //
// // function stopChannel() {
// //     stompClient.send("/app/fault/stop", {widgetId: $("#name").val()}, {});
// // }
// //
// // function pauseChannel() {
// //     stompClient.send("/app/fault/pause", {widgetId: $("#name").val()}, {});
// // }
// //
// // function sendName() {
// //     stompClient.send("/app/fault/set-configuration", {sessionId: SId, widgetId: wId}, JSON.stringify(testFilter));
// //     // stompClient.send("/app/hello/" + $("#name").val(), {}, JSON.stringify({'name': $("#name").val()}));
// // }
// //
// // function startReadingFile() {
// //     stompClient.send("/app/startReadingFile", {}, {});
// // }
// //
// // function showGreeting(message) {
// //     $("#greetings").append("<tr><td>" + message + "</td></tr>");
// // }
// //
// // $(function () {
// //     $("form").on('submit', function (e) {
// //         e.preventDefault();
// //     });
// //     $("#connect").click(function () {
// //         connect();
// //     });
// //     $("#disconnect").click(function () {
// //         disconnect();
// //     });
// //     $("#send").click(function () {
// //         sendName();
// //     });
// //     $("#addDashboard").click(function () {
// //         addDashboard();
// //     });
// //     $("#addchannel").click(function () {
// //         addChannel();
// //     });
// //     $("#startchannel").click(function () {
// //         startChannel();
// //     });
// //     $("#stopchannel").click(function () {
// //         stopChannel();
// //     });
// //     $("#pausechannel").click(function () {
// //         pauseChannel();
// //     });
// //     $("#startReadingFile").click(function () {
// //         startReadingFile();
// //     });
// //
// // });

var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/alarm-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({Authorization: token}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/alarm/create', function (greeting) {
            // showGreeting(JSON.parse(greeting.body).content);
            console.log(greeting)
        });
        stompClient.send("/app/startChannel", {}, null);
        // stompClient.subscribe('/topic/fault/create', function (greeting) {
        //     // showGreeting(JSON.parse(greeting.body).content);
        //     console.log(greeting)
        // })

        // stompClient.send("/app/test" , {} , null)

        ;
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});