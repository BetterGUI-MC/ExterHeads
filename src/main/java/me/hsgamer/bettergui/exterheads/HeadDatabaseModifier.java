package me.hsgamer.bettergui.exterheads;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class HeadDatabaseModifier extends ExterHeadModifier {
    private final HeadDatabaseAPI headDatabaseAPI = new HeadDatabaseAPI();

    @Override
    protected ItemStack getHead(UUID uuid, String id) {
        return headDatabaseAPI.getItemHead(id);
    }

    @Override
    protected String getHeadId(UUID uuid, ItemStack itemStack) {
        return headDatabaseAPI.getItemID(itemStack);
    }
}
