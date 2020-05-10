package me.jasplan.stats;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Database {




    public static Stats plugin = Stats.getPlugin(Stats.class);

    public static boolean playerExists(UUID uuid){ //check if player UUID exists in database return true if thats the case
        try {
            PreparedStatement statement = plugin.getConnection().prepareStatement("SELECT * FROM " + plugin.table + " WHERE UUID=?");
            statement.setString(1, uuid.toString());

            ResultSet results = statement.executeQuery();
            if(results.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void createPlayer(final UUID uuid, Player player){
        try{
            PreparedStatement statement = plugin.getConnection().prepareStatement("SELECT * FROM " + plugin.table + " WHERE UUID=?");
            statement.setString(1, uuid.toString());

            ResultSet results = statement.executeQuery();
            results.next();
            if(!(playerExists(uuid))){//if player exists
                PreparedStatement insert = plugin.getConnection().prepareStatement("INSERT INTO " + plugin.table + " (UUID,NAME,MONEY,POWER,MOB_KILLS,PLAYER_KILLS,EXP,DEATHS,RESERVED3,RESERVED4) VALUE (?,?,?,?,?,?,?,?,?,?)");
                insert.setString(1, uuid.toString());
                insert.setString(2, player.getName());
                insert.setInt(3, 0); //get stats from the right place instead of a set number
                insert.setInt(4, 0);
                insert.setInt(5, 0);
                insert.setInt(6, 0);
                insert.setInt(7, 0);
                insert.setInt(8, 0);
                insert.setInt(9, 0);
                insert.setInt(10, 0);
                insert.executeUpdate();

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }



    public static int getMoney(final UUID uuid){//get money from database
            int money = 0;



            try {
                if(playerExists(uuid)) {

                    PreparedStatement statement = plugin.getConnection().prepareStatement("SELECT MONEY FROM " + plugin.table + " WHERE UUID = '" + uuid.toString() + "'");

                    ResultSet results = statement.executeQuery();
                    while(results.next()) {
                        money = results.getInt("MONEY");
                    }
                }else{
                    Stats.log.info("[Stats] getMoney fail, player not found in database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return money;
        }

        public static void setMoney(final UUID uuid, Integer money){

            try {
                if(playerExists(uuid)) {

                    PreparedStatement statement = plugin.getConnection().prepareStatement("UPDATE "+ plugin.table +" SET MONEY = " + money + " WHERE UUID = '" + uuid +"'");

                    statement.executeUpdate();

                }else{
                    Stats.log.info("[Stats] setMoney fail, player not found in database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        public static int getPower(final UUID uuid){
            int power = 0;



            try {
                if(playerExists(uuid)) {

                    PreparedStatement statement = plugin.getConnection().prepareStatement("SELECT POWER FROM " + plugin.table + " WHERE UUID = '" + uuid.toString() + "'");

                    ResultSet results = statement.executeQuery();
                    while(results.next()) {
                        power = results.getInt("POWER");
                    }
                }else{
                    Stats.log.info("[Stats] getPower fail, player not found in database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return power;
        }

        public static void setPower(final UUID uuid, Integer power){

            try {
                if(playerExists(uuid)) {

                    PreparedStatement statement = plugin.getConnection().prepareStatement("UPDATE "+ plugin.table +" SET POWER = " + power + " WHERE UUID = '" + uuid +"'");

                    statement.executeUpdate();

                }else{
                    Stats.log.info("[Stats] setPower fail, player not found in database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        public static int getMobKills(final UUID uuid){//get money from database
            int mobKills = 0;



            try {
                if(playerExists(uuid)) {

                    PreparedStatement statement = plugin.getConnection().prepareStatement("SELECT MOB_KILLS FROM " + plugin.table + " WHERE UUID = '" + uuid.toString() + "'");

                    ResultSet results = statement.executeQuery();
                    while(results.next()) {
                        mobKills = results.getInt("MOB_KILLS");
                    }
                }else{
                    Stats.log.info("[Stats] getMobKills fail, player not found in database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return mobKills;
        }

        public static void setMobKills(final UUID uuid, Integer mobKills){

            try {
                if(playerExists(uuid)) {

                    PreparedStatement statement = plugin.getConnection().prepareStatement("UPDATE "+ plugin.table +" SET MOB_KILLS = " + mobKills + " WHERE UUID = '" + uuid +"'");

                    statement.executeUpdate();

                }else{
                    Stats.log.info("[Stats] setMobKills fail, player not found in database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        public static int getPlayerKills(final UUID uuid){//get money from database
            int playerKills = 0;



            try {
                if(playerExists(uuid)) {

                    PreparedStatement statement = plugin.getConnection().prepareStatement("SELECT PLAYER_KILLS FROM " + plugin.table + " WHERE UUID = '" + uuid.toString() + "'");

                    ResultSet results = statement.executeQuery();
                    while(results.next()) {
                        playerKills = results.getInt("PLAYER_KILLS");
                    }
                }else{
                    Stats.log.info("[Stats] getPlayerKills fail, player not found in database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return playerKills;
        }

        public static void setPlayerKills(final UUID uuid, Integer playerKills){

            try {
                if(playerExists(uuid)) {

                    PreparedStatement statement = plugin.getConnection().prepareStatement("UPDATE "+ plugin.table +" SET PLAYER_KILLS = " + playerKills + " WHERE UUID = '" + uuid +"'");

                    statement.executeUpdate();

                }else{
                    Stats.log.info("[Stats] setPlayerKills fail, player not found in database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        public static int getExp(final UUID uuid){
            int exp = 0;



            try {
                if(playerExists(uuid)) {

                    PreparedStatement statement = plugin.getConnection().prepareStatement("SELECT EXP FROM " + plugin.table + " WHERE UUID = '" + uuid.toString() + "'");

                    ResultSet results = statement.executeQuery();
                    while(results.next()) {
                        exp = results.getInt("EXP");
                    }
                }else{
                    Stats.log.info("[Stats] getExp fail, player not found in database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return exp;
        }

        public static void setExp(final UUID uuid, Integer exp){

            try {
                if(playerExists(uuid)) {

                    PreparedStatement statement = plugin.getConnection().prepareStatement("UPDATE "+ plugin.table +" SET EXP = " + exp + " WHERE UUID = '" + uuid +"'");

                    statement.executeUpdate();

                }else{
                    Stats.log.info("[Stats] setExp fail, player not found in database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        public static int getDeaths(final UUID uuid){//get money from database
            int deaths = 0;



            try {
                if(playerExists(uuid)) {

                    PreparedStatement statement = plugin.getConnection().prepareStatement("SELECT DEATHS FROM " + plugin.table + " WHERE UUID = '" + uuid.toString() + "'");

                    ResultSet results = statement.executeQuery();
                    while(results.next()) {
                        deaths = results.getInt("DEATHS");
                    }
                }else{
                    Stats.log.info("[Stats] getDeaths fail, player not found in database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return deaths;
        }

        public static void setDeaths(final UUID uuid, Integer deaths){

        try {
            if(playerExists(uuid)) {

                PreparedStatement statement = plugin.getConnection().prepareStatement("UPDATE "+ plugin.table +" SET DEATHS = " + deaths + " WHERE UUID = '" + uuid +"'");

                statement.executeUpdate();

            }else{
                Stats.log.info("[Stats] setDeaths fail, player not found in database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}