package me.hsgamer.bettergui.exterheads;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import me.hsgamer.hscore.bukkit.item.ItemModifier;
import me.hsgamer.hscore.common.interfaces.StringReplacer;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.UUID;

public class HeadDatabaseModifier implements ItemModifier {
    private final HeadDatabaseAPI headDatabaseAPI = new HeadDatabaseAPI();
    private String name = "";

    @Override
    public String getName() {
        return "head-database";
    }

    @Override
    public ItemStack modify(ItemStack original, UUID uuid, Map<String, StringReplacer> stringReplacerMap) {
        String replaced = StringReplacer.replace(name, uuid, stringReplacerMap.values());
        ItemStack newItemStack = headDatabaseAPI.getItemHead(replaced);
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
        String id = headDatabaseAPI.getItemID(itemStack);
        if (id != null) {
            this.name = id;
        }
    }

    @Override
    public boolean compareWithItemStack(ItemStack itemStack, UUID uuid, Map<String, StringReplacer> stringReplacerMap) {
        String replaced = StringReplacer.replace(name, uuid, stringReplacerMap.values());
        String headId = headDatabaseAPI.getItemID(itemStack);
        return headId != null && headId.equals(replaced);
    }
}
