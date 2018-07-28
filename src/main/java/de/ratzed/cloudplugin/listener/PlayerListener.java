package de.ratzed.cloudplugin.listener;

import cloud.timo.TimoCloud.api.messages.listeners.MessageListener;
import cloud.timo.TimoCloud.api.messages.objects.AddressedPluginMessage;
import cloud.timo.TimoCloud.api.messages.objects.PluginMessage;
import de.ratzed.cloudplugin.api.PlayerAPI;
import de.ratzed.cloudplugin.utils.MessageSender;

public class PlayerListener implements MessageListener {

    PlayerAPI api = new PlayerAPI();


    @Override
    public void onPluginMessage(AddressedPluginMessage e) {
        PluginMessage message = e.getMessage();
        String function = message.getString("function");
        String name = message.getString("name");
        String uuid = message.getString("uuid");
        String value = message.getString("value");

        if(function.equalsIgnoreCase("register")) {
            api.register(name,uuid);
        }
        if(function.equalsIgnoreCase("isRegistered")) {
            MessageSender.sendisRegistered(name,uuid,api.isRegistered(uuid),e.getSender().getName());
        }
        if(function.equalsIgnoreCase("updateName")) {
            api.updateName(name,uuid);
        }
        if(function.equalsIgnoreCase("getLanguage")) {
            MessageSender.sendLanguage(name,uuid,api.getLanguage(name,uuid),e.getSender().getName());
        }
        if(function.equalsIgnoreCase("getSilentHub")) {
            MessageSender.sendSilentHub(name,uuid,api.getSilentHub(name,uuid),e.getSender().getName());
        }
        if(function.equalsIgnoreCase("getLayout")) {
            MessageSender.sendLayout(name,uuid,api.getlayout(name,uuid),e.getSender().getName());
        }
        if(function.equalsIgnoreCase("getVisibility")) {
            MessageSender.sendVisibility(name,uuid,api.getVisibility(name,uuid),e.getSender().getName());
        }
        if(function.equalsIgnoreCase("getCoins")) {
            MessageSender.sendCoins(name,uuid,api.getCoins(name,uuid),e.getSender().getName());
        }

        if(function.equalsIgnoreCase("setLanguage")) {
            api.setLanguage(uuid,name,value);
        }
        if(function.equalsIgnoreCase("setSilentHub")) {
            api.setSilentHub(name,uuid,Boolean.valueOf(value));
        }
        if(function.equalsIgnoreCase("setLayout")) {
            api.setLayout(name,uuid,Integer.valueOf(value));
        }
        if(function.equalsIgnoreCase("addCoins")) {
            api.addCoins(name,uuid,Integer.valueOf(value));
        }
        if(function.equalsIgnoreCase("setCoins")) {
            api.setCoins(name,uuid,Integer.valueOf(value));
        }
        if(function.equalsIgnoreCase("removeCoins")) {
            api.removeCoins(name,uuid,Integer.valueOf(value));
        }
    }
}
