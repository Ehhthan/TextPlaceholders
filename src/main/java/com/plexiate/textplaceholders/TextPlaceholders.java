package com.plexiate.textplaceholders;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Set;

public final class TextPlaceholders extends JavaPlugin {

    public static TextPlaceholders plugin;

    private Set<String> placeholders;


    @Override
    public void onEnable() {
        plugin = this;
        plugin.saveDefaultConfig();
        loadPlaceholders();
        new TextPlaceholdersExpansion().register();
        this.getCommand("textplaceholders").setExecutor(new MainCommand());
    }

    public void loadPlaceholders() {
        placeholders = getConfig().getConfigurationSection("placeholders").getKeys(false);
    }
    public Set<String> getPlaceholders() {
        return placeholders;
    }
}
