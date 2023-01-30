package me.hsgamer.bettergui.exterheads;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.inventory.ItemStack;

public class HeadDatabaseModifier extends ExterHeadModifier {
    private final HeadDatabaseAPI headDatabaseAPI = new HeadDatabaseAPI();

    @Override
    public String getName() {
        return "head-database";
    }

    @Override
    protected ItemStack getHead(String id) {
        return headDatabaseAPI.getItemHead(id);
    }

    @Override
    protected String getHeadId(ItemStack itemStack) {
        return headDatabaseAPI.getItemID(itemStack);
    }
}
