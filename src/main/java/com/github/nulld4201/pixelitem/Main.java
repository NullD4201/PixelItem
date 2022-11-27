package com.github.nulld4201.pixelitem;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;

import static com.github.nulld4201.pixelitem.PixelItems.*;

public final class Main extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("pai").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player currentPlayer = (Player) sender;
        Inventory pai = Bukkit.createInventory(null, 54, "§4Pixel Adventure Items");
        pai.setItem(0, TURTLE_MAP.getItemStack());
        pai.setItem(1, TREE_COMPASS.getItemStack());
        pai.setItem(2, SACRIFICE_SWORD.getItemStack());
        pai.setItem(3, BLOOD.getItemStack());
        pai.setItem(4, BLOOD_BOWL.getItemStack());
        pai.setItem(5, SOUL_BOOK.getItemStack());
        pai.setItem(6, SOUL_LANTERN.getItemStack());
        pai.setItem(7, ICE_HEART.getItemStack());
        pai.setItem(8, VIKING_COMPASS.getItemStack());
        pai.setItem(9, BAT_TOOTH.getItemStack());
        pai.setItem(10, THIRSTY_DAGGER.getItemStack());

        ItemStack blood_bottle = BLOOD_BOTTLE.getItemStack();
        PotionMeta blood_bottle_meta = (PotionMeta) blood_bottle.getItemMeta();
        blood_bottle_meta.setColor(Color.RED);
        blood_bottle.setItemMeta(blood_bottle_meta);
        pai.setItem(11, blood_bottle);

        pai.setItem(12, BAT_MAP.getItemStack());
        pai.setItem(13, STRANGE_STEW.getItemStack());
        pai.setItem(14, CERBERUS_KEY.getItemStack());
        pai.setItem(15, EYE_OF_HELL.getItemStack());

        if (label.equalsIgnoreCase("pai") && currentPlayer.isOp()) {
            currentPlayer.openInventory(pai);
        }

        return false;
    }
}
