package com.myservlet.Controller;

import com.myservlet.Model.*;
import java.io.IOException;
import java.util.*;

import com.google.gson.*;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/myendpoint")
public class ChatEndPoint {

    private static final Gson gson = new Gson();
    public static Map<String, Session> usersSession = new HashMap<>();
    public static List<User> users = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) throws IOException {
        String query = session.getQueryString();
        String[] params = query.split("&");
        String name = params[0].split("=")[1];
        String gender = params[1].split("=")[1];

        System.out.println("name : " + name + "\nGender :" + gender);

        User user = new User(name, gender.charAt(0));
        Message message = new Message(0, "it's New User", name);
        usersSession.put(name, session);
        users.add(user);

        JsonObject jsonObject = new JsonObject();
        JsonElement object1Json = gson.toJsonTree(user);
        JsonElement object2Json = gson.toJsonTree(message);
        jsonObject.add("user", object1Json);
        jsonObject.add("message", object2Json);

        String jsonMessage = gson.toJson(jsonObject);

        onMessage(jsonMessage, session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {

        System.out.println(usersSession.size());
        for (Session ses : usersSession.values())
            ses.getBasicRemote().sendText(message);

        // Gson gson = new Gson();
        // JsonObject jsonObject = gson.fromJson(message, JsonObject.class);
        // JsonElement object1Json = jsonObject.get("user");
        // JsonElement object2Json = jsonObject.get("object2");
        // User object1 = gson.fromJson(object1Json, User.class);
        // Message object2 = gson.fromJson(object2Json, Message.class);
        // String name = messageObj.getName();
        // int type = messageObj.getMessageType();
        // char gender = messageObj.getGender();
        // // int messageType, String messageContent, String name, char gender
        // Message responseObj = new Message(type, "notMessage", name);
        // String response = gson.toJson(responseObj);
        // for (Session ses : users.values())
        // ses.getBasicRemote().sendText(response);

    }

    @OnClose
    public void onClose(Session session) throws IOException {
        // get user from session
        // messagetype 2
        // User user = new User(name, gender.charAt(0));
        // Message message = new Message(0, "it's New User", name);
        // usersSession.put(name, session);
        // users.add(user);
        // JsonObject jsonObject = new JsonObject();
        // JsonElement object1Json = gson.toJsonTree(user);
        // JsonElement object2Json = gson.toJsonTree(message);
        // jsonObject.add("user", object1Json);
        // jsonObject.add("message", object2Json);
        // String jsonMessage = gson.toJson(jsonObject);
        // onMessage(jsonMessage, session , true);

        String keyToRemove = null;
        for (Map.Entry<String, Session> entry : usersSession.entrySet()) {
            if (entry.getValue().equals(session)) {
                keyToRemove = entry.getKey();
                break;
            }
        }

        // Remove the key-value pair
        if (keyToRemove != null)
            usersSession.remove(keyToRemove);

    }

}
