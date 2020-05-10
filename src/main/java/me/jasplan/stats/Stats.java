package me.jasplan.stats;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;
import java.util.logging.Logger;

public final class Stats extends JavaPlugin {

    //mySql variables
    private Connection connection;
    public String host, database, username, password, table;
    public int port;
    //Other variables



    public static Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        // Plugin startup logic
        //SQL stuff start
        loadConfig(); //get mySql parameters from config file
        mysqlSetup(); //connect to mySql
        //SQL stuff stop

        getServer().getPluginManager().registerEvents(new Events(), this);
        getCommand("stats").setExecutor(new Commands());
        getCommand("pay").setExecutor(new Commands());

        log.info("[StatMod] StatMod ENABLED");

        new BukkitRunnable() {
            @Override
            public void run() {//start loop of updating scoreboards in a second runnable

                Bukkit.getOnlinePlayers().forEach(player -> {
                    UUID uuid = player.getUniqueId();
                    // TODO
                    if(Database.playerExists(uuid)) {
                        Scoreboard.scoreboardUpdate(uuid);
                    }
                });
            }
        }.runTaskTimer(this, 0, 20);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("[StatMod] StatMod DISABLED");


    }








    /*

    MYSQL BELOW

     */
    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void mysqlSetup(){
        host = this.getConfig().getString("host");
        port = this.getConfig().getInt("port");
        database = this.getConfig().getString("database");
        username = this.getConfig().getString("username");
        password = this.getConfig().getString("password");
        table = this.getConfig().getString("table");

        try{

            synchronized (this){
                if(getConnection() != null && !getConnection().isClosed()){
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver"); //this accesses Driver in jdbc.
                setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/"  //connect to mySQL database
                        + this.database, this.username, this.password));

                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Stats] MYSQL CONNECTED");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


}
