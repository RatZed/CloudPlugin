package de.ratzed.cloudplugin.listener;

import cloud.timo.TimoCloud.api.messages.listeners.MessageListener;
import cloud.timo.TimoCloud.api.messages.objects.AddressedPluginMessage;
import cloud.timo.TimoCloud.api.messages.objects.PluginMessage;

public class ServerListener implements MessageListener {


    @Override
    public void onPluginMessage(AddressedPluginMessage e) {
        PluginMessage message = e.getMessage();
        String function = message.getString("function");
        String name = message.getString("name");
        String uuid = message.getString("uuid");
        String value = message.getString("value");

        if(function.equalsIgnoreCase("isRegistered")) {

    }
}
}
