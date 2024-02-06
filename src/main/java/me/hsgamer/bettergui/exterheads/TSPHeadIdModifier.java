package me.hsgamer.bettergui.exterheads;

import org.bukkit.inventory.ItemStack;
import tsp.headdb.core.api.HeadAPI;

import java.util.UUID;

public class TSPHeadIdModifier extends ExterHeadModifier {
    @Override
    protected ItemStack getHead(UUID uuid, String id) {
        if (uuid == null) {
            return null;
        }
        try {
            int headId = Integer.parseInt(id);
            return HeadAPI.getHeadById(headId).map(head -> head.getItem(uuid)).orElse(null);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    protected String getHeadId(UUID uuid, ItemStack itemStack) {
        return null;
    }
}
