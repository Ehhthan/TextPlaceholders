package com.plexiate.textplaceholders;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;


public class TextPlaceholdersExpansion extends PlaceholderExpansion {

    @Override
    public String getIdentifier() {
        return TextPlaceholders.plugin.getConfig().getString("placeholder-prefix");
    }

    @Override
    public String getAuthor() {
        return "Sek";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier){
        if(player == null){
            return "";
        }
        if (TextPlaceholders.plugin.getPlaceholders().contains(identifier)) {
            String ph = TextPlaceholders.plugin.getConfig().getString("placeholders." + identifier);
            ph = PlaceholderAPI.setPlaceholders(player, ph);
            return ph;
        }
        return null;
    }
}
