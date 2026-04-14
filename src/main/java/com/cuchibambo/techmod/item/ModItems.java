package com.cuchibambo.techmod.item;

import com.cuchibambo.techmod.Techmod;
import com.cuchibambo.techmod.item.custom.ChiselItem;
import com.cuchibambo.techmod.item.custom.FuelItem;
import com.cuchibambo.techmod.item.custom.ModFoodProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
