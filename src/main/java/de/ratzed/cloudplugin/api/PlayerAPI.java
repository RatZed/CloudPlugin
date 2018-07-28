package de.ratzed.cloudplugin.api;

import de.ratzed.cloudplugin.mysql.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerAPI {


    static String name;
    static String uuid;


    public void register(String name, String uuid) {
        if(!isRegistered(uuid)) {
            PreparedStatement ps = MySQL.getStatement("INSERT INTO player (name, uuid, language, silenthub, layout, visibility, coins) VALUES (?,?,?,?,?,?,?)");
            try {
                ps.setString(1, name);
                ps.setString(2, uuid);
                ps.setString(3, "english");
                ps.setString(4, String.valueOf(false));
                ps.setInt(5, 15);
                ps.setInt(6, 0);
                ps.setInt(7, 0);
                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean isRegistered(String uuid) {

        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM player WHERE uuid= ?");

            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            boolean user = rs.next();
            rs.close();
            ps.close();
            return user;

        }catch(Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public void updateName(String name, String uuid) {

        if(isRegistered(uuid)) {

            if(hasNameChange(uuid,name)) {

                try {

                    PreparedStatement ps = MySQL.getStatement("UPDATE player=? FROM player WHERE uuid= ?");

                    ps.setString(1,name);
                    ps.setString(2,uuid);
                    ps.executeUpdate();
                    ps.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
        register(name,uuid);
    }

    public boolean hasNameChange(String uuid,String name) {
        if (isRegistered(uuid)) {
            try {

                PreparedStatement ps = MySQL.getStatement("SELECT * FROM player WHERE uuid= ?");

                ps.setString(1, uuid);
                ResultSet rs = ps.executeQuery();

                String user = rs.getString("player");

                if (user.equals(name)) {
                    return false;
                }

                rs.close();
                ps.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name,uuid);
        return true;
    }

    public String getLanguage(String name,String uuid) {

        if(isRegistered(uuid)) {

            try {

                PreparedStatement ps = MySQL.getStatement("SELECT * FROM player WHERE uuid= ?");

                ps.setString(1,uuid);
                ResultSet rs = ps.executeQuery();
                String language = rs.getString("language");
                rs.close();
                ps.close();

                return language;

            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name,uuid);
        return "english";
    }

    public void setLanguage(String uuid,String name, String lang) {

        if(isRegistered(uuid)) {

            try {

                PreparedStatement ps = MySQL.getStatement("UPDATE language= ? FROM player WHERE uuid= ?");

                ps.setString(1,lang);
                ps.setString(2,uuid);
                ps.executeUpdate();
                ps.close();

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name, uuid);
    }

    public boolean getSilentHub(String name,String uuid) {

        if(isRegistered(uuid)) {

            try {

                PreparedStatement ps = MySQL.getStatement("SELECT * FROM player WHERE uuid= ?");

                ps.setString(1,uuid);
                ResultSet rs = ps.executeQuery();
                boolean silent = Boolean.valueOf(rs.getString("silenthub"));
                rs.close();
                ps.close();

                return silent;
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name,uuid);
        return false;
    }

    public void setSilentHub(String name,String uuid, boolean silent) {

        if(isRegistered(uuid)) {

            try {

                PreparedStatement ps = MySQL.getStatement("UPDATE silenthub= ? FROM player WHERE uuid= ?");

                ps.setString(1,String.valueOf(silent));
                ps.setString(2,uuid);
                ps.executeUpdate();
                ps.close();

            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name,uuid);
    }

    public int getlayout(String name,String uuid) {

        if(isRegistered(uuid)) {

            try {

                PreparedStatement ps = MySQL.getStatement("SELECT * FROM player WHERE uuid= ?");

                ps.setString(1,uuid);
                ResultSet rs = ps.executeQuery();
                int layout = rs.getInt("layout");
                rs.close();
                ps.close();

                return layout;
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name,uuid);
        return 15;
    }

    public void setLayout(String name,String uuid, int layout) {

        if(isRegistered(uuid)) {

            try {

                PreparedStatement ps = MySQL.getStatement("UPDATE layout= ? FROM player WHERE uuid= ?");

                ps.setInt(1,layout);
                ps.setString(2,uuid);
                ps.executeUpdate();
                ps.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name,uuid);
    }

    public int getVisibility(String name ,String uuid) {

        if(isRegistered(uuid)) {

            try {

                PreparedStatement ps = MySQL.getStatement("SELECT * FROM player WHERE uuid= ?");

                ps.setString(1,uuid);
                ResultSet rs = ps.executeQuery();
                int visibility = rs.getInt("visibility");
                rs.close();
                ps.close();

                return visibility;
            }catch(Exception ex) {
                ex.printStackTrace();
            }

        }
        register(name,uuid);
        return 0;
    }

    public void setVisibility(String name,String uuid, int visibility) {

        if(isRegistered(uuid)) {

            try {

                PreparedStatement ps = MySQL.getStatement("UPDATE visibility= ? FROM player WHERE uuid= ?");

                ps.setInt(1,visibility);
                ps.setString(2,uuid);
                ps.executeUpdate();
                ps.close();

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name,uuid);
    }

    public int getCoins(String name,String uuid) {

        if(isRegistered(uuid)) {

            try {

                PreparedStatement ps = MySQL.getStatement("SELECT * FROM player WHERE uuid= ?");
                ps.setString(1,uuid);
                ResultSet rs = ps.executeQuery();
                int coins = rs.getInt("coins");
                rs.close();
                ps.close();
                return coins;
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name,uuid);
        return 0;
    }

    public void addCoins(String name, String uuid, int coins) {
        if(isRegistered(uuid)) {
            try {

                PreparedStatement ps = MySQL.getStatement("UPDATE coins FROM player WHERE uuid=?");
                ps.setInt(1,getCoins(name,uuid) + coins);
                ps.setString(2,uuid);
                ps.executeUpdate();
                ps.close();

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name,uuid);

    }

    public void setCoins(String name,String uuid, int coins) {
        if(isRegistered(uuid)) {

            try {

                PreparedStatement ps = MySQL.getStatement("UPDATE coins FROM player WHERE uuid=?");
                ps.setInt(1,coins);
                ps.setString(2,uuid);
                ps.executeUpdate();
                ps.close();

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name,uuid);

    }

    public void removeCoins(String name,String uuid, int coins) {
        if(isRegistered(uuid)) {

            try {

                PreparedStatement ps = MySQL.getStatement("UPDATE coins FROM player WHERE uuid=?");
                ps.setInt(1,getCoins(name,uuid) - coins);
                ps.setString(2,uuid);
                ps.executeUpdate();
                ps.close();

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        register(name,uuid);

    }
}
