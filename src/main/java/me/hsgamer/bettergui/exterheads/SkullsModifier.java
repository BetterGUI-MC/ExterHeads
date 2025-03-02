package me.hsgamer.bettergui.exterheads;

import ca.tweetzy.skulls.Skulls;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class SkullsModifier extends ExterHeadModifier {
    @Override
    protected ItemStack getHead(@Nullable UUID uuid, String id) {
        try {
            int headId = Integer.parseInt(id);
            return Skulls.getAPI().getSkullItem(headId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected String getHeadId(@Nullable UUID uuid, ItemStack itemStack) {
        return "";
    }
}
