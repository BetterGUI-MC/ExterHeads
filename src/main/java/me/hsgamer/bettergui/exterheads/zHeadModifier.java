package me.hsgamer.bettergui.exterheads;

import fr.maxlego08.head.api.HeadManager;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class zHeadModifier extends ExterHeadModifier {
    private final HeadManager headManager = Bukkit.getServicesManager().load(HeadManager.class);

    @Override
    protected ItemStack getHead(@Nullable UUID uuid, String id) {
        return headManager.createItemStack(id);
    }

    @Override
    protected String getHeadId(@Nullable UUID uuid, ItemStack itemStack) {
        return null;
    }
}
