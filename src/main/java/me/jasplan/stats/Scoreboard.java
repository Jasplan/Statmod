package me.jasplan.stats;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.UUID;

public class Scoreboard {

    public static ScoreboardManager manager = Bukkit.getScoreboardManager();
    static org.bukkit.scoreboard.Scoreboard sideBoard;
    static Objective sideObjective;

    static Score moneyScore,powerScore,mobKillScore,playerKillScore,expScore,deathScore;

    public static void scoreboardCreate(Player player){

        assert manager != null;
        //create sideboard
        sideBoard = manager.getNewScoreboard();//create scoreboard
        sideObjective = sideBoard.registerNewObjective("Stats", "dummy", ChatColor.BLUE + "||--" + player.getDisplayName() + "--||"); //build scoreboard
        sideObjective.setDisplaySlot(DisplaySlot.SIDEBAR);//set location of scoreboard
        moneyScore = sideObjective.getScore(ChatColor.GOLD + "Money: $" + ChatColor.GREEN + Database.getMoney(player.getUniqueId()));//set score 1
        powerScore = sideObjective.getScore(ChatColor.GOLD + "Power: " + ChatColor.GREEN + Database.getPower(player.getUniqueId()) );//set score 2
        mobKillScore = sideObjective.getScore(ChatColor.GOLD + "Mob Kills: " + ChatColor.GREEN + Database.getMobKills(player.getUniqueId()));//set score 3
        playerKillScore = sideObjective.getScore((ChatColor.GOLD + "Player Kills: " + ChatColor.GREEN + Database.getPlayerKills(player.getUniqueId())));//set score 4
        expScore = sideObjective.getScore((ChatColor.GOLD + "Exp: " + ChatColor.GREEN + Database.getExp(player.getUniqueId())));//set score 5
        deathScore = sideObjective.getScore((ChatColor.GOLD + "Deaths: " + ChatColor.GREEN + Database.getDeaths(player.getUniqueId())));//set score 6

        moneyScore.setScore(9);//set location of score
        powerScore.setScore(8);
        mobKillScore.setScore(7);
        playerKillScore.setScore(6);
        expScore.setScore(5);
        deathScore.setScore(4);

        player.setScoreboard(sideBoard);//make board visible to player

    }

    public static void scoreboardUpdate(UUID uuid){

        Player player = Bukkit.getPlayer(uuid);
        assert manager != null;
        //create sideboard
        sideBoard = manager.getNewScoreboard();//create scoreboard
        sideObjective = sideBoard.registerNewObjective("Stats", "dummy", ChatColor.BLUE + "||--" + player.getDisplayName() + "--||"); //build scoreboard
        sideObjective.setDisplaySlot(DisplaySlot.SIDEBAR);//set location of scoreboard
        moneyScore = sideObjective.getScore(ChatColor.GOLD + "Money: $" + ChatColor.GREEN + Database.getMoney(player.getUniqueId()));//set score 1
        powerScore = sideObjective.getScore(ChatColor.GOLD + "Power: " + ChatColor.GREEN + Database.getPower(player.getUniqueId()) );//set score 2
        mobKillScore = sideObjective.getScore(ChatColor.GOLD + "Mob Kills: " + ChatColor.GREEN + Database.getMobKills(player.getUniqueId()));//set score 3
        playerKillScore = sideObjective.getScore((ChatColor.GOLD + "Player Kills: " + ChatColor.GREEN + Database.getPlayerKills(player.getUniqueId())));//set score 4
        expScore = sideObjective.getScore((ChatColor.GOLD + "Exp: " + ChatColor.GREEN + Database.getExp(player.getUniqueId())));//set score 5
        deathScore = sideObjective.getScore((ChatColor.GOLD + "Deaths: " + ChatColor.GREEN + Database.getDeaths(player.getUniqueId())));//set score 6

        moneyScore.setScore(9);//set location of score
        powerScore.setScore(8);
        mobKillScore.setScore(7);
        playerKillScore.setScore(6);
        expScore.setScore(5);
        deathScore.setScore(4);

        player.setScoreboard(sideBoard);//make board visible to player


    }

}
