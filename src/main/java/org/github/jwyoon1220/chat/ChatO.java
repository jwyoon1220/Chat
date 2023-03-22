package org.github.jwyoon1220.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ChatO extends JavaPlugin implements Listener {
    private ChatDataReader chatDataReader;
    @Override
    public void onEnable() {
        chatDataReader = new ChatDataReader();
        getCommand("chat").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("chat") && args.length > 0 && args[0].equalsIgnoreCase("log")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "플레이어만 쓸수있다");
                return true;
            }

            Player player = (Player) sender;
            List<String> chatData = chatDataReader.readChatData("chatdata.txt");
            for (String chatMessage : chatData) {
                player.sendMessage(ChatColor.WHITE + chatMessage);
            }

            return true;
        }
        return false;
    }

        @Override
        public void onDisable() {
            // Plugin shutdown logic
        }







}