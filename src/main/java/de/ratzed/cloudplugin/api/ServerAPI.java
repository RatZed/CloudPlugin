package de.ratzed.cloudplugin.api;

import de.ratzed.cloudplugin.mysql.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServerAPI {

    public static boolean isRegisteredGroup(String group) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM server WHERE server= ?");

            ps.setString(1, group);
            ResultSet rs = ps.executeQuery();
            boolean groups = rs.next();
            rs.close();
            ps.close();

            return groups;

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void registerGroup(String group) {

        try {

            PreparedStatement ps = MySQL.getStatement("INSERT INTO server (server, maintenance, coinbooster, newgame) VALUES (?,?,?,?)");
            ps.setString(1, group);
            ps.setString(2,String.valueOf(false));
            ps.setString(3,String.valueOf(false));
            ps.setString(4,String.valueOf(false));
            System.out.println("test");
            ps.executeUpdate();
            ps.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean getMaintenance(String group) {
        if(isRegisteredGroup(group)) {
            try {
                PreparedStatement ps =MySQL.getStatement("SELECT * FROM server WHERE server = ?");

                ps.setString(1, group);
                ResultSet rs = ps.executeQuery();
                boolean maintenance = Boolean.valueOf(rs.getString("maintenance"));
                rs.close();
                ps.close();

                return maintenance;
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        registerGroup(group);
        return false;
    }

    public static void setMaintenance(String group, boolean maintenance) {
        if(isRegisteredGroup(group)) {
            try {
                PreparedStatement ps = MySQL.getStatement("UPDATE maintenance= ? FROM server WHERE server= ?");
                ps.setString(1, String.valueOf(maintenance));
                ps.setString(2, group);
                ps.executeUpdate();
                ps.close();
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        registerGroup(group);
    }

    public static boolean getCoinBooster(String group) {
        if(isRegisteredGroup(group)) {
            try {
                PreparedStatement ps = MySQL.getStatement("SELECT * FROM server WHERE server= ?");
                ps.setString(1,group);
                ResultSet rs = ps.executeQuery();
                boolean coinbooster = Boolean.valueOf(rs.getString("coinbooster"));
                rs.close();
                ps.close();
                return coinbooster;
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        registerGroup(group);
        return false;
    }

    public static void setCoinBooster(String group, boolean coinbooster){
        if(isRegisteredGroup(group)) {
            try {
                PreparedStatement ps = MySQL.getStatement("UPDATE coinbooster= ? FROM server WHERE server= ?");
                ps.setString(1, String.valueOf(coinbooster));
                ps.setString(2, group);
                ps.executeUpdate();
                ps.close();
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        registerGroup(group);
    }

    public static boolean getNewGame(String group) {
        if(isRegisteredGroup(group)) {
            try {
                PreparedStatement ps = MySQL.getStatement("SELECT * FROM server WHERE server= ?");
                ps.setString(1,group);
                ResultSet rs = ps.executeQuery();
                boolean newgame = Boolean.valueOf(rs.getString("newgame"));
                rs.close();
                ps.close();
                return newgame;
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        registerGroup(group);
        return false;
    }

    public static void setNewGame(String group, boolean newgame) {
        if(isRegisteredGroup(group)) {
            try {
                PreparedStatement ps = MySQL.getStatement("UPDATE newgame= ? FROM server WHERE server= ?");
                ps.setString(1,String.valueOf(newgame));
                ps.setString(2,group);
                ps.executeUpdate();
                ps.close();
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        registerGroup(group);
    }

}
