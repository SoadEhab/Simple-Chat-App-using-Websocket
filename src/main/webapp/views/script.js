var webSocket;
var userName;
var gender;

function Join() {
  sessionStorage.setItem('userName', $("#nametxt").val());
  sessionStorage.setItem('gender', $("input[name='gender']:checked").val());
  window.location.href = "views/Chat.jsp";
}

function openWebSocket() {
  userName = sessionStorage.getItem('userName');
  gender = sessionStorage.getItem('gender');

  console.log("openWebSocket");
  webSocket = new WebSocket("ws://localhost:8081/myendpoint?name=" + userName + "&gender=" + gender);
  webSocket.onmessage = onMessage;
}

function sendWebSocketMessage() {


  var message = {
    messageType: "1",
    messageContent: $("#messageInput").val()
  };

  var user = {
    name: userName,
    gender: gender
  };

  var messageObj = {
    user: user,
    message: message
  };

  var jsonMessage = JSON.stringify(messageObj);


  webSocket.send(jsonMessage);


}

function onMessage(event) {

  var messageObj = JSON.parse(event.data);
  var user = messageObj.user;
  var message = messageObj.message;

  console.log("Message [ " + message.messageContent + " ]  received from : " + user.name + "//// Type" + message.messageType + " /////");
};

function closeWebSocket() {

  var message = {
    messageType: "2",
    messageContent: $("#messageInput").val()
  };

  var user = {
    name: userName,
    gender: gender
  };

  var messageObj = {
    user: user,
    message: message
  };

  var jsonMessage = JSON.stringify(messageObj);
  webSocket.send(jsonMessage);

  webSocket.close();

}