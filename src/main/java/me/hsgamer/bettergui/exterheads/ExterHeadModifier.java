package me.hsgamer.bettergui.exterheads;

import me.hsgamer.hscore.bukkit.item.ItemModifier;
import me.hsgamer.hscore.common.interfaces.StringReplacer;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.UUID;

public abstract class ExterHeadModifier implements ItemModifier {
    private String name = "";

    protected abstract ItemStack getHead(String id);

    protected abstract String getHeadId(ItemStack itemStack);

    @Override
    public ItemStack modify(ItemStack original, UUID uuid, Map<String, StringReplacer> stringReplacerMap) {
        String replaced = StringReplacer.replace(name, uuid, stringReplacerMap.values());
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
    public void loadFromItemStack(ItemStack itemStack) {
        String id = getHeadId(itemStack);
        if (id != null) {
            this.name = id;
        }
    }

    @Override
    public boolean compareWithItemStack(ItemStack itemStack, UUID uuid, Map<String, StringReplacer> stringReplacerMap) {
        String replaced = StringReplacer.replace(name, uuid, stringReplacerMap.values());
        String headId = getHeadId(itemStack);
        return headId != null && headId.equals(replaced);
    }
}
