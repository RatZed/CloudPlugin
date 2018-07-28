package de.ratzed.cloudplugin;


import cloud.timo.TimoCloud.api.plugins.TimoCloudPlugin;

public class CloudPlugin extends TimoCloudPlugin {

    public void onEnable() {

        System.out.print("[CloudZNetwork] Plugin aktiviert");

    }

    public void onDisable() {

       System.out.print("[CloudZNetwork] Plugin deaktiviert");

    }

}
