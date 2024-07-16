package me.hsgamer.bettergui.exterheads;

import me.hsgamer.hscore.common.StringReplacer;
import me.hsgamer.hscore.minecraft.item.ItemComparator;
import me.hsgamer.hscore.minecraft.item.ItemModifier;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class ExterHeadModifier implements ItemModifier<ItemStack>, ItemComparator<ItemStack> {
    private String name = "";

    protected abstract ItemStack getHead(@Nullable UUID uuid, String id);

    protected abstract String getHeadId(@Nullable UUID uuid, ItemStack itemStack);

    @Override
    public @NotNull ItemStack modify(@NotNull ItemStack original, UUID uuid, @NotNull StringReplacer stringReplacer) {
        String replaced = stringReplacer.replaceOrOriginal(name, uuid);
        ItemStack newItemStack = getHead(uuid, replaced);
        return newItemStack == null ? original : newItemStack;
    }

    @Override
    public Object toObject() {
        return name;
    }

    @Override
    public void loadFromObject(Object object) {
        this.name = String.valueOf(object);
    }

    @Override
    public boolean loadFromItem(ItemStack itemStack) {
        String id = getHeadId(null, itemStack);
        if (id != null) {
            this.name = id;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean compare(@NotNull ItemStack itemStack, UUID uuid, @NotNull StringReplacer stringReplacer) {
        String replaced = stringReplacer.replaceOrOriginal(name, uuid);
        String headId = getHeadId(uuid, itemStack);
        return headId != null && headId.equals(replaced);
    }
}
