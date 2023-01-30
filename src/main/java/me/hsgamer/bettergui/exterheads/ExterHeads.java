package me.hsgamer.bettergui.exterheads;

import me.hsgamer.bettergui.builder.ItemModifierBuilder;
import me.hsgamer.hscore.bukkit.addon.PluginAddon;
import org.bukkit.Bukkit;

public final class ExterHeads extends PluginAddon {
    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().isPluginEnabled("HeadDatabase")) {
            ItemModifierBuilder.INSTANCE.register(HeadDatabaseModifier::new, "head-database", "head-db", "hdb");
        }
    }
}
