package me.jasplan.stats;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(command.getName().equals("stats") || command.getName().equals("stat")){


                if(args.length == 3) {
                    switch (args[0].toLowerCase()) {
                        case "set":
                            switch (args[1].toLowerCase()){
                                case "money":
                                    try{
                                        int amount = Integer.parseInt(args[2]);
                                        Database.setMoney(player.getUniqueId(), amount);
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Money for: " + player.getName());
                                    }catch (Exception e){
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                        break;
                                    }
                                    break;
                                case "power":
                                    try{
                                        int amount = Integer.parseInt(args[2]);
                                        Database.setPower(player.getUniqueId(), amount);
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Power for: " + player.getName());
                                    }catch (Exception e){
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                        break;
                                    }
                                    break;
                                case "mobkills":
                                case "mob_kills":
                                    try{
                                        int amount = Integer.parseInt(args[2]);
                                        Database.setMobKills(player.getUniqueId(), amount);
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Mob_kills for: " + player.getName());
                                    }catch (Exception e){
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                        break;
                                    }
                                    break;
                                case "playerkills":
                                case "player_kills":
                                    try{
                                        int amount = Integer.parseInt(args[2]);
                                        Database.setPlayerKills(player.getUniqueId(), amount);
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Player_kills for: " + player.getName());
                                    }catch (Exception e){
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                        break;
                                    }
                                    break;
                                case "exp":
                                case "xp":
                                    try{
                                        int amount = Integer.parseInt(args[2]);
                                        Database.setExp(player.getUniqueId(), amount);
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Exp for: " + player.getName());
                                    }catch (Exception e){
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                        break;
                                    }
                                    break;
                                case "deaths":
                                case "death":
                                    try{
                                        int amount = Integer.parseInt(args[2]);
                                        Database.setDeaths(player.getUniqueId(), amount);
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Deaths for: " + player.getName());
                                    }catch (Exception e){
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                        break;
                                    }
                                    break;

                            }
                            break;
                        case "get":

                            boolean playerFound = false;
                            UUID targetUuid = null;
                            Player targetPlayer = null;
                            try{
                                targetPlayer = Bukkit.getPlayer(args[2]);
                                playerFound = true;
                            }catch (Exception e){
                                playerFound = false;
                            }
                            if(playerFound) {
                                targetUuid = targetPlayer.getUniqueId();
                                switch (args[1].toLowerCase()) {
                                    case "money":
                                        try {

                                            int amount = Database.getMoney(targetUuid);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + targetPlayer.getName() + " Has " + amount + " Money");
                                        } catch (Exception e) {
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                            break;
                                        }
                                        break;
                                    case "power":
                                        try {

                                            int amount = Database.getPower(targetUuid);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + targetPlayer.getName() + " Has " + amount + " Power.");
                                        } catch (Exception e) {
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                            break;
                                        }
                                        break;
                                    case "mobkills":
                                    case "mob_kills":
                                        try {

                                            int amount = Database.getMobKills(targetUuid);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + targetPlayer.getName() + " Has " + amount + " Mob_kills.");
                                        } catch (Exception e) {
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                            break;
                                        }
                                        break;
                                    case "playerkills":
                                    case "player_kills":
                                        try {

                                            int amount = Database.getPlayerKills(targetUuid);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + targetPlayer.getName() + " Has " + amount + " Player_kills.");
                                        } catch (Exception e) {
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                            break;
                                        }
                                        break;
                                    case "exp":
                                    case "xp":
                                        try {

                                            int amount = Database.getExp(targetUuid);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + targetPlayer.getName() + " Has " + amount + " Exp.");
                                        } catch (Exception e) {
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "ERROR: Player not found or NullException.");
                                            break;
                                        }
                                        break;
                                    case "deaths":
                                    case "death":
                                        try {

                                            int amount = Database.getDeaths(targetUuid);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + targetPlayer.getName() + " Has " + amount + " Deaths.");
                                        } catch (Exception e) {
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "ERROR: Player not found or NullException.");
                                            break;
                                        }
                                        break;

                                }
                            }

                            break;
                        default:
                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "Not a valid command.");
                            break;
                    }
                }else{

                }


                if(args.length == 4) {//if 4 args (if sender specifies target)
                    boolean playerFound = false;
                    UUID targetUuid = null;
                    Player targetPlayer = null;
                    try{
                        targetPlayer = Bukkit.getPlayer(args[2]);
                        playerFound = true;
                    }catch (Exception e){
                        playerFound = false;
                    }

                    if(playerFound) {
                        targetUuid = targetPlayer.getUniqueId();
                        switch (args[0].toLowerCase()) {
                            case "set":
                                switch (args[1].toLowerCase()) {
                                    case "money":
                                        try {
                                            int amount = Integer.parseInt(args[3]);


                                            Database.setMoney(targetUuid, amount);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Money for: " + targetPlayer.getName());
                                        } catch (Exception e) {
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                            break;
                                        }
                                        break;
                                    case "power":
                                        try {
                                            int amount = Integer.parseInt(args[3]);
                                            Database.setPower(targetUuid, amount);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Power for: " + targetPlayer.getName());
                                        } catch (Exception e) {
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                            break;
                                        }
                                        break;
                                    case "mobkills":
                                    case "mob_kills":
                                        try {
                                            int amount = Integer.parseInt(args[3]);
                                            Database.setMobKills(targetUuid, amount);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Mob_kills for: " + targetPlayer.getName());
                                        } catch (Exception e) {
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                            break;
                                        }
                                        break;
                                    case "playerkills":
                                    case "player_kills":
                                        try {
                                            int amount = Integer.parseInt(args[3]);
                                            Database.setPlayerKills(targetUuid, amount);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Player_kills for: " + targetPlayer.getName());
                                        } catch (Exception e) {
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                            break;
                                        }
                                        break;
                                    case "exp":
                                    case "xp":
                                        try {
                                            int amount = Integer.parseInt(args[3]);
                                            Database.setExp(targetUuid, amount);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Exp for: " + targetPlayer.getName());
                                        } catch (Exception e) {
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                            break;
                                        }
                                        break;
                                    case "deaths":
                                    case "death":
                                        try{
                                            int amount = Integer.parseInt(args[2]);
                                            Database.setDeaths(player.getUniqueId(), amount);
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Database updated Deaths for: " + player.getName());
                                        }catch (Exception e){
                                            player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You must input a number.");
                                            break;
                                        }
                                        break;


                                }
                                break;
                            case "get":

                                player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "Too many arguments.");

                                break;
                            default:
                                player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "Not a valid command.");
                                break;
                        }
                    }
                }else{

                }


            }//If command is /stats

            if(command.getName().equals("pay")){

                if(args.length == 2){
                    try {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(Database.playerExists(target.getUniqueId())){
                            try {
                                int payAmount = Integer.parseInt(args[1]);
                                int playerBal = Database.getMoney(player.getUniqueId());
                                int targetBal = Database.getMoney(target.getUniqueId());
                                if(playerBal >= payAmount){
                                    if(payAmount < 0){
                                        player.kickPlayer("Swiper no swiping!.");
                                    }else {
                                        Database.setMoney(target.getUniqueId(), (targetBal + payAmount));//add money to target
                                        Database.setMoney(player.getUniqueId(), (playerBal - payAmount));//take away target from player
                                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.GREEN + "Transaction complete");
                                    }
                                }else{
                                    player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "You cannot afford this payment.");
                                }

                            }catch(Exception e){
                                player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "Invalid format. /pay <player> <amount>");
                            }
                        }
                    }catch(Exception e){
                        player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "Player not found");
                    }


                }else{
                    player.sendMessage(ChatColor.YELLOW + "[Stats] " + ChatColor.RED + "Invalid format. /pay <player> <amount>");
                }
            }


            
        }

        return false;
    }

}
