package de.ratzed.cloudplugin.utils;

import cloud.timo.TimoCloud.api.TimoCloudAPI;
import cloud.timo.TimoCloud.api.messages.objects.PluginMessage;
import sun.plugin2.main.server.Plugin;

public class MessageSender {

    public static void sendisRegistered(String name,String uuid,boolean value,String fromServer) {
        PluginMessage message = new PluginMessage("RECIVE_REGISTERED").set("playername",name).set("playeruuid",uuid).set("value",value);
        if(fromServer.equalsIgnoreCase("Proxy")) {
            TimoCloudAPI.getUniversalAPI().getProxy(fromServer).sendPluginMessage(message);
        } else {
            TimoCloudAPI.getMessageAPI().sendMessageToServer(message, fromServer);
        }
    }

    public static void sendLanguage(String name,String uuid,String value,String fromServer) {
        PluginMessage message = new PluginMessage("RECIVE_LANGUAGE").set("playername",name).set("playeruuid",uuid).set("value",value);
        if(fromServer.equalsIgnoreCase("Proxy")) {
            TimoCloudAPI.getUniversalAPI().getProxy(fromServer).sendPluginMessage(message);
        }else {
            TimoCloudAPI.getMessageAPI().sendMessageToServer(message,fromServer);
        }
    }

    public static void sendSilentHub(String name,String uuid,boolean value,String fromServer) {
        PluginMessage message = new PluginMessage("RECIVE_SILENTHUB").set("playername",name).set("playeruuid",uuid).set("value",value);
        if(fromServer.equalsIgnoreCase("Proxy")) {
            TimoCloudAPI.getUniversalAPI().getProxy(fromServer).sendPluginMessage(message);
        } else {
            TimoCloudAPI.getMessageAPI().sendMessageToServer(message,fromServer);
        }
    }

    public static void sendLayout(String name,String uuid,int value,String fromServer) {
        PluginMessage message = new PluginMessage("RECIVE_LAYOUT").set("playername",name).set("playeruuid",uuid).set("value",value);
        if(fromServer.equalsIgnoreCase("Proxy")) {
            TimoCloudAPI.getUniversalAPI().getProxy(fromServer).sendPluginMessage(message);
        } else {
            TimoCloudAPI.getMessageAPI().sendMessageToServer(message,fromServer);
        }
    }

    public static void sendVisibility(String name,String uuid, int value,String fromServer) {
        PluginMessage message = new PluginMessage("RECIVE_VISIBILITY").set("playername",name).set("playeruuid",uuid).set("value",value);
        if(fromServer.equalsIgnoreCase("Proxy")) {
            TimoCloudAPI.getUniversalAPI().getProxy(fromServer).sendPluginMessage(message);
        } else {
            TimoCloudAPI.getMessageAPI().sendMessageToServer(message,fromServer);
        }
    }

    public static void sendCoins(String name,String uuid,int value,String fromServer) {
        PluginMessage message = new PluginMessage("RECIVE_COINS").set("playername",uuid).set("playeruuid",uuid).set("value",value);
        if(fromServer.equalsIgnoreCase("Proxy")) {
            TimoCloudAPI.getUniversalAPI().getProxy(fromServer).sendPluginMessage(message);
        } else {
            TimoCloudAPI.getMessageAPI().sendMessageToServer(message,fromServer);
        }
    }

    public static void sendRegisteredServer(String group,boolean value,String fromServer) {
        PluginMessage message = new PluginMessage("RECIVE_SERVER_REGISTERED").set("groupname",group).set("value",value);
        if(fromServer.equalsIgnoreCase("Proxy")) {
            TimoCloudAPI.getUniversalAPI().getProxy("Proxy");
        } else {
            TimoCloudAPI.getMessageAPI().sendMessageToServer(message,fromServer);
        }
    }
    public static void sendMaintenanceServer(String group,boolean value,String fromServer) {
        PluginMessage message = new PluginMessage("RECIVE_SERVER_MAINTENANCE").set("groupname",group).set("value",value);
        if(fromServer.equalsIgnoreCase("Proxy")) {
            TimoCloudAPI.getUniversalAPI().getProxy(fromServer).sendPluginMessage(message);
        } else {
            TimoCloudAPI.getMessageAPI().sendMessageToServer(message,fromServer);
        }
    }
    public static void sendCoinBooster(String group,boolean value,String fromServer) {
        PluginMessage message = new PluginMessage("RECIVE_SERVER_COINBOOSTER").set("groupname",group).set("value",value);
        if(fromServer.equalsIgnoreCase("Proxy")) {
            TimoCloudAPI.getUniversalAPI().getProxy(fromServer).sendPluginMessage(message);
        } else {
            TimoCloudAPI.getMessageAPI().sendMessageToServer(message,fromServer);
        }
    }

    public static void sendNewGame(String group,boolean value,String fromServer) {
        PluginMessage message = new PluginMessage("RECIVE_SERVER_NEWGAME").set("groupname",group).set("value",value);
        if(fromServer.equalsIgnoreCase("Proxy")) {
            TimoCloudAPI.getUniversalAPI().getProxy(fromServer).sendPluginMessage(message);
        } else {
            TimoCloudAPI.getMessageAPI().sendMessageToServer(message,fromServer);
        }
    }
}
