package me.hsgamer.bettergui.exterheads;

import me.hsgamer.hscore.common.StringReplacer;
import me.hsgamer.hscore.minecraft.item.ItemComparator;
import me.hsgamer.hscore.minecraft.item.ItemModifier;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

public abstract class ExterHeadModifier implements ItemModifier<ItemStack>, ItemComparator<ItemStack> {
    private String name = "";

    protected abstract ItemStack getHead(String id);

    protected abstract String getHeadId(ItemStack itemStack);

    @Override
    public @NotNull ItemStack modify(@NotNull ItemStack original, UUID uuid, @NotNull Collection<StringReplacer> stringReplacers) {
        String replaced = StringReplacer.replace(name, uuid, stringReplacers);
        ItemStack newItemStack = getHead(replaced);
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
        String id = getHeadId(itemStack);
        if (id != null) {
            this.name = id;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean compare(@NotNull ItemStack itemStack, UUID uuid, @NotNull Collection<StringReplacer> stringReplacers) {
        String replaced = StringReplacer.replace(name, uuid, stringReplacers);
        String headId = getHeadId(itemStack);
        return headId != null && headId.equals(replaced);
    }
}
