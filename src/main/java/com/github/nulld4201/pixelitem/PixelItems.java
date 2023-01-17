package com.github.nulld4201.pixelitem;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MapMeta;

public enum PixelItems {
    TURTLE_MAP(Material.PAPER, "거북이 지도", ChatColor.DARK_GREEN, 1, true, false),
    TREE_COMPASS(Material.COMPASS, "드루이드 나침반", ChatColor.GREEN, 1, true, false),
    SACRIFICE_SWORD(Material.GOLDEN_SWORD, "제사용 칼", ChatColor.YELLOW, 1, true, false),
    BLOOD(Material.RED_DYE, "피", ChatColor.DARK_RED, 1, true, false),
    BLOOD_BOWL(Material.BEETROOT_SOUP, "피가 담긴 그릇", ChatColor.DARK_RED, 1, true, false),
    SOUL_BOOK(Material.BOOK, "영혼이 담긴 책", ChatColor.AQUA, 1, true, false),
    SOUL_LANTERN(Material.HEART_OF_THE_SEA, "영혼이 담긴 랜턴", ChatColor.DARK_AQUA, 1, true, false),
    ICE_HEART(Material.HEART_OF_THE_SEA, "얼어붙은 심장", ChatColor.AQUA, 2, true, false),
    VIKING_COMPASS(Material.COMPASS, "바이킹 나침반", ChatColor.BLUE, 2, true, false),
    BAT_TOOTH(Material.IRON_NUGGET, "박쥐의 송곳니", ChatColor.GRAY, 1, true, false),
    THIRSTY_DAGGER(Material.IRON_SWORD, "목마른 단검", ChatColor.WHITE, 1, true, false),
    BLOOD_BOTTLE(Material.POTION, "피가 담긴 병", ChatColor.DARK_RED, 1, true, false),
    BAT_MAP(Material.PAPER, "박쥐 지도", ChatColor.RED, 2, true, false),
    STRANGE_STEW(Material.MUSHROOM_STEW, "알 수 없는 스튜", ChatColor.DARK_PURPLE, 1, true, false),
    CERBERUS_KEY(Material.BLAZE_ROD, "케르베로스 열쇠", ChatColor.GOLD, 1, true, false),
    EYE_OF_HELL(Material.ENDER_EYE, "지옥의 눈", ChatColor.DARK_RED, 1, true, false),
    UNKNOWN_PAPER(Material.PAPER, "알 수 없는 종이", ChatColor.WHITE, 3, true, false),
    BLACK_LEATHER(Material.LEATHER, "검은 가죽", ChatColor.GRAY, 1, true, false),
    BLACK_BOOK(Material.BOOK, "검은 서적", ChatColor.GRAY, 2, true, false),
    HOGRIDER_AXE(Material.COMPASS, "호그라이더의 도끼", ChatColor.YELLOW, 1, true, false);

    private final Material itemMaterial;
    private final String itemDisplayName;
    private final ChatColor itemDisplayName_Color;
    private final int itemCustomModelData;

    private final boolean itemDisplayName_Bold;
    private final boolean itemDisplayName_Obfuscated;

    PixelItems(Material itemMaterial, String itemDisplayName, ChatColor itemDisplayName_Color, int itemCustomModelData, boolean itemDisplayName_Bold, boolean itemDisplayName_Obfuscated) {
        this.itemMaterial = itemMaterial;
        this.itemDisplayName = itemDisplayName;
        this.itemDisplayName_Color = itemDisplayName_Color;
        this.itemCustomModelData = itemCustomModelData;
        this.itemDisplayName_Bold = itemDisplayName_Bold;
        this.itemDisplayName_Obfuscated = itemDisplayName_Obfuscated;
    }

    public Material getItemMaterial() {
        return this.itemMaterial;
    }
    public String getItemDisplayName() {
        return this.itemDisplayName;
    }
    public ChatColor getItemDisplayName_Color() {
        return this.itemDisplayName_Color;
    }
    public int getItemCustomModelData() {
        return this.itemCustomModelData;
    }
    public boolean getItemDisplayName_Bold() {
        return this.itemDisplayName_Bold;
    }
    public boolean getItemDisplayName_Obfuscated() {
        return this.itemDisplayName_Obfuscated;
    }

    public ItemStack getItemStack() {
        ItemStack itemStack = new ItemStack(itemMaterial, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String displayName = itemDisplayName;
        if (itemDisplayName_Bold) displayName = ChatColor.BOLD + displayName;
        if (itemDisplayName_Obfuscated) displayName = ChatColor.MAGIC+ displayName;
        displayName = itemDisplayName_Color + displayName;
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_DYE);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName(displayName);
        itemMeta.setCustomModelData(itemCustomModelData);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public void setCompassTarget(ItemStack itemStack, World world, float x, float y, float z) {
        setCompassTarget(itemStack, world, x, y, z, 0, 0);
    }

    public void setCompassTarget(ItemStack itemStack, World world, float x, float y, float z, float yaw, float pitch) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta instanceof CompassMeta) {
            CompassMeta compassMeta = (CompassMeta) itemMeta;
            compassMeta.setLodestoneTracked(false);
            compassMeta.setLodestone(new Location(world, x, y, z, yaw, pitch));
            itemStack.setItemMeta(compassMeta);
        }
    }
}
