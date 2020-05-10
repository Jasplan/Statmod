package me.jasplan.stats;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;


public class Events implements Listener {



    @EventHandler//Create scoreboards for players on join
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Scoreboard.scoreboardCreate(player);





        Bukkit.broadcastMessage("Welcome " + player.getName());


        //create mySQL Table / add player to database

        if(!Database.playerExists(player.getUniqueId())){//check if player exists in database
            Stats.log.info("[Stats] Player: " + player.getName() + " NOT found in database, adding now.");
            Database.createPlayer(player.getUniqueId(), player);
        }
        else{
            Stats.log.info("[Stats] Player: " + player.getName() + " found in database.");
        }


    }


    @EventHandler
    public void onKillMob(EntityDeathEvent event){

        String mob = event.getEntityType().toString();
        Entity killer = event.getEntity().getKiller();
        if(killer instanceof Player){
            UUID uuid = killer.getUniqueId();
            if(mob.equals("SKELETON") || mob.equals("ZOMBIE") || mob.equals("SPIDER") || mob.equals("CAVE_SPIDER") ||
                    mob.equals("BLAZE") || mob.equals("ENDERMAN") || mob.equals("SLIME") || mob.equals("CREEPER") ||
                    mob.equals("PIG_ZOMBIE") || mob.equals("MAGMA_CUBE") || mob.equals("SILVERFISH") ||
                    mob.equals("WITCH") || mob.equals("ENDERMITE")){
                //update database
                Database.setMobKills(uuid, (Database.getMobKills(uuid) + 1));


            }


        }

    }

    @EventHandler
    public void onKillPlayer(PlayerDeathEvent event){
        Entity killer = event.getEntity().getKiller();
        if(killer instanceof Player){

            UUID killerUuid = killer.getUniqueId();
            UUID playerUuid = event.getEntity().getPlayer().getUniqueId();
            //set player deaths
            int deaths = Database.getDeaths(playerUuid);
            Database.setDeaths(playerUuid, (deaths + 1));
            //set killer player_kills
            int kills = Database.getPlayerKills(killerUuid);
            Database.setPlayerKills(killerUuid, (kills +1));

        }
    }

}
