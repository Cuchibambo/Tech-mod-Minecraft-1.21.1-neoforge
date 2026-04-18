package com.cuchibambo.techmod.item;

import com.cuchibambo.techmod.Techmod;
import com.cuchibambo.techmod.item.custom.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Techmod.MODID);

    public static final DeferredItem<Item> IRON_DUST = ITEMS.register("iron_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> THALLIUM_SHARD = ITEMS.register("thallium_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> THALLIUM_APPLE = ITEMS.register("thallium_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.THALLIUM_APPLE)));

    public static final DeferredItem<Item> SUPERDENSE_THALLIUM = ITEMS.register("superdense_thallium",
            () -> new FuelItem(new Item.Properties(),16000) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.techmod.superdense_thallium"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<SwordItem> THALLIUM_SWORD = ITEMS.register("thallium_sword",
            () -> new SwordItem(ModToolTiers.THALLIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.THALLIUM, 3, -2.4f))));

    public static final DeferredItem<AxeItem> THALLIUM_AXE = ITEMS.register("thallium_axe",
            () -> new AxeItem(ModToolTiers.THALLIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.THALLIUM, 5, -3f))));

    public static final DeferredItem<PickaxeItem> THALLIUM_PICKAXE = ITEMS.register("thallium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.THALLIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.THALLIUM, 1, -2.8f))));

    public static final DeferredItem<ShovelItem> THALLIUM_SHOVEL = ITEMS.register("thallium_shovel",
            () -> new ShovelItem(ModToolTiers.THALLIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.THALLIUM, 1.5f, -3f))));

    public static final DeferredItem<HoeItem> THALLIUM_HOE = ITEMS.register("thallium_hoe",
            () -> new HoeItem(ModToolTiers.THALLIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.THALLIUM, -3, 0f))));

    public static final DeferredItem<HammerItem> THALLIUM_HAMMER = ITEMS.register("thallium_hammer",
            () -> new HammerItem(ModToolTiers.THALLIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.THALLIUM, 3, -3f))));

    public static final DeferredItem<ArmorItem> THALLIUM_HELMET = ITEMS.register("thallium_helmet",
            () -> new ArmorItem(ModArmorMaterials.THALLIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));

    public static final DeferredItem<ArmorItem> THALLIUM_CHESTPLATE = ITEMS.register("thallium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.THALLIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));

    public static final DeferredItem<ArmorItem> THALLIUM_LEGGINGS = ITEMS.register("thallium_leggings",
            () -> new ArmorItem(ModArmorMaterials.THALLIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));

    public static final DeferredItem<ArmorItem> THALLIUM_BOOTS = ITEMS.register("thallium_boots",
            () -> new ArmorItem(ModArmorMaterials.THALLIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
