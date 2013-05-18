package me.C0nsole.Track;




import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;





public class Track extends JavaPlugin {

	
	
	
	
    @Override
    public void onDisable() {
        System.out.println("[Track] v1.0 has been disabled.");
    }
 
    
    
    
    
    @Override
    public void onEnable() {
        System.out.println("[Track] v1.0 has been enabled.");
    }
    
    
    
    
    
	@Override
	   public boolean onCommand(CommandSender sender1, Command cmd, String commandlabel, String [] args){
		Player player = (Player) sender1;
		if(commandlabel.equalsIgnoreCase("track")){
			if(player.hasPermission("track.track")){
				if(args.length == 0){
					Player sender = null;
					if(sender1 instanceof Player){
					
					sender = (Player) sender1;
						
					List<Player> list = new ArrayList<Player>();
					 
					Location source = sender.getLocation();
					 
					for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.getLocation().distance(source) < 1000) {
					list.add(p);
					}
					}
					 
					StringBuilder b = new StringBuilder().append(ChatColor.DARK_GRAY + "Nearby Players (1000 Radius): ");
					 
					for (Player p : list) {
					if (p != null && p.isOnline()) {
					Location l = p.getLocation();
					b.append(ChatColor.GRAY).append(p.getName()).append("{").append(l.getBlockX()).append(", ").append(l.getBlockZ()).append("}, ");
					}
					}
					 
					if (!list.isEmpty()) {
					sender.sendMessage(b.toString());
					} else {
					sender.sendMessage("No nearby players.");
					}
					 
					list.clear();
					list = null;
					}
				}
				else if(args.length == 1){
					if(args[0].equalsIgnoreCase("plus")){
						if(player.hasPermission("track.plus")){
						Player sender = null;
						if(sender1 instanceof Player){
						
						sender = (Player) sender1;
							
						List<Player> list = new ArrayList<Player>();
						 
						Location source = sender.getLocation();
						 
						for (Player p : Bukkit.getOnlinePlayers()) {
						if (p.getLocation().distance(source) < 2000) {
						list.add(p);
						}
						}
						 
						StringBuilder b = new StringBuilder().append(ChatColor.DARK_GRAY + "Nearby Players (2000 Radius): ");
						 
						for (Player p : list) {
						if (p != null && p.isOnline()) {
						Location l = p.getLocation();
						b.append(ChatColor.GRAY).append(p.getName()).append("{").append(l.getBlockX()).append(", ").append(l.getBlockZ()).append("}, ");
						}
						}
						 
						if (!list.isEmpty()) {
						sender.sendMessage(b.toString());
						} else {
						sender.sendMessage("No nearby players.");
						}
						 
						list.clear();
						list = null;
						}
						}
					}
					else{
						player.sendMessage(ChatColor.RED + "Incorrect usage!");
					}
				}
			}
		}
		return false;
	}
}
