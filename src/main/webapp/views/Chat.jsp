<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Advanced Level Chat-Box UI</title>
    <link rel="stylesheet" href="chat.css">
</head>

<body  onload="openWebSocket()">
    <div class="container">

        <!-- chat box -->
        <div class="chat-box">
            <!-- main chat section -->
            <div class="chats">
                <div class="client-msg">
                    <img class="client-image" src="../images/logo.png" alt="logo" />
                    <div class="client-chat">Hi!</div>
                </div>
                <br><br>
                <div class="my-msg">
                    <img class="my-image" src="../images/logo.png" alt="logo" />
                    <div class="my-chat">Hi!</div>
                </div>

            </div>
        </div>
        <div class="client">
            <img src="../images/logo.png" alt="logo" />
            <div class="client-info">
                <h2>Thanos</h2>
                <p>online</p>
            </div>
        </div>
        <div class="chat-input">
            <input type="text" id="messageInput" placeholder="Enter Message" />
            <button class="send-btn" onclick="sendWebSocketMessage()">
                <img src="../images/send.png" alt="send-btn">
            </button>
        </div>

    </div>

    <div>
        <button type="button" onclick="closeWebSocket()" >Log Out</button>
    </div>

    <script src="script.js"></script>
    <script src="jquery-3.4.1.min.js"></script>

</body>

</html>