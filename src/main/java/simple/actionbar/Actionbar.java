package simple.actionbar;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.text.DecimalFormat;


public final class Actionbar extends JavaPlugin  {

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Yeah boiiii");
        new Statusplayer().runTaskTimer(this, 0, 25);
    }

    @Override
    public void onDisable() {
    }

    public static class Statusplayer extends BukkitRunnable {
        @Override
        public void run() {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if(player != null) {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.RED + "" + new DecimalFormat("#").format(player.getHealth()) + "/" + ChatColor.RED + new DecimalFormat("#").format(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()) + " ❤ Health"
                            + ChatColor.WHITE + " | " + ChatColor.GREEN + new DecimalFormat("#").format(player.getAttribute(Attribute.GENERIC_ARMOR).getValue()) + " ❈ Defence" ));




                }

            }
        }
    }

}
