package me.hsgamer.bettergui.exterheads;

import org.bukkit.inventory.ItemStack;
import tsp.headdb.core.api.HeadAPI;

import java.util.UUID;

public class TSPHeadNameModifier extends ExterHeadModifier {
    @Override
    protected ItemStack getHead(UUID uuid, String id) {
        if (uuid == null) {
            return null;
        }
        return HeadAPI.getHeadByExactName(id, true).map(head -> head.getItem(uuid)).orElse(null);
    }

    @Override
    protected String getHeadId(UUID uuid, ItemStack itemStack) {
        return null;
    }
}
