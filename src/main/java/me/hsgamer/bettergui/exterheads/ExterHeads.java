package me.hsgamer.bettergui.exterheads;

import me.hsgamer.bettergui.builder.ItemModifierBuilder;
import me.hsgamer.hscore.expansion.common.Expansion;
import org.bukkit.Bukkit;

public final class ExterHeads implements Expansion {
    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().isPluginEnabled("HeadDatabase")) {
            ItemModifierBuilder.INSTANCE.register(HeadDatabaseModifier::new, "head-database", "head-db", "hdb");
        }
        if (Bukkit.getPluginManager().isPluginEnabled("HeadDB")) {
            ItemModifierBuilder.INSTANCE.register(TSPHeadIdModifier::new, "tsp-head");
            ItemModifierBuilder.INSTANCE.register(TSPHeadNameModifier::new, "tsp-head-name");
        }
    }
}
