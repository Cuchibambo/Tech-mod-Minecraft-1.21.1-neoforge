package com.cuchibambo.techmod.block;

import com.cuchibambo.techmod.Techmod;
import com.cuchibambo.techmod.block.custom.MagicBlock;
import com.cuchibambo.techmod.block.custom.ThalliumLampBlock;
import com.cuchibambo.techmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Techmod.MODID);

    public static final DeferredBlock<Block> GREEN_BLOCK = registerBlock("green_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> THALLIUM_ORE = registerBlock("thallium_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_THALLIUM_ORE = registerBlock("deepslate_thallium_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> THALLIUM_BLOCK = registerBlock("thallium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));

    public static final DeferredBlock<StairBlock> GREEN_STAIRS = registerBlock("green_stairs",
            () -> new StairBlock(ModBlocks.GREEN_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<SlabBlock> GREEN_SLAB = registerBlock("green_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> GREEN_PRESSURE_PLATE = registerBlock("green_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<ButtonBlock> GREEN_BUTTON = registerBlock("green_button",
            () -> new ButtonBlock(BlockSetType.STONE,4,
                    BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<FenceBlock> GREEN_FENCE = registerBlock("green_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<FenceGateBlock> GREEN_FENCE_GATE = registerBlock("green_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<WallBlock> GREEN_WALL = registerBlock("green_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> GREEN_DOOR = registerBlock("green_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<TrapDoorBlock> GREEN_TRAPDOOR = registerBlock("green_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<Block> THALLIUM_LAMP = registerBlock("thallium_lamp",
            () -> new ThalliumLampBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.GLASS).requiresCorrectToolForDrops().lightLevel(state -> state.getValue(ThalliumLampBlock.ISLIT) ? 15: 0)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
