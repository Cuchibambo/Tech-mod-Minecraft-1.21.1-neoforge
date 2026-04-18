package com.cuchibambo.techmod.item;

import com.cuchibambo.techmod.Techmod;
import com.cuchibambo.techmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Techmod.MODID);

    public static final Supplier<CreativeModeTab> TECHMOD_TAB = CREATIVE_MODE_TAB.register("techmod_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> new ItemStack(ModItems.THALLIUM_SHARD.get()))
                    .title(Component.translatable("creativetab.techmod.techmod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.THALLIUM_SHARD);
                        output.accept(ModBlocks.THALLIUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_THALLIUM_ORE);
                        output.accept(ModBlocks.THALLIUM_BLOCK);
                        output.accept(ModBlocks.THALLIUM_LAMP);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.THALLIUM_SWORD);
                        output.accept(ModItems.THALLIUM_PICKAXE);
                        output.accept(ModItems.THALLIUM_AXE);
                        output.accept(ModItems.THALLIUM_SHOVEL);
                        output.accept(ModItems.THALLIUM_HOE);
                        output.accept(ModItems.THALLIUM_HAMMER);
                        output.accept(ModItems.THALLIUM_HELMET);
                        output.accept(ModItems.THALLIUM_CHESTPLATE);
                        output.accept(ModItems.THALLIUM_LEGGINGS);
                        output.accept(ModItems.THALLIUM_BOOTS);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                        output.accept(ModItems.THALLIUM_APPLE);
                        output.accept(ModItems.SUPERDENSE_THALLIUM);
                        output.accept(ModItems.IRON_DUST);
                        output.accept(ModBlocks.GREEN_BLOCK);
                        output.accept(ModBlocks.GREEN_BUTTON);
                        output.accept(ModBlocks.GREEN_DOOR);
                        output.accept(ModBlocks.GREEN_FENCE);
                        output.accept(ModBlocks.GREEN_SLAB);
                        output.accept(ModBlocks.GREEN_STAIRS);
                        output.accept(ModBlocks.GREEN_FENCE_GATE);
                        output.accept(ModBlocks.GREEN_PRESSURE_PLATE);
                        output.accept(ModBlocks.GREEN_WALL);
                        output.accept(ModBlocks.GREEN_TRAPDOOR);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
