package com.cuchibambo.techmod.item.custom;

import com.cuchibambo.techmod.component.ModDataComponents;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.MOSSY_COBBLESTONE, Blocks.MOSSY_STONE_BRICKS,
                    Blocks.TUFF, Blocks.TUFF_BRICKS,
                    Blocks.CLAY, Blocks.BRICKS,
                    Blocks.PACKED_MUD, Blocks.MUD_BRICKS,
                    Blocks.NETHERRACK, Blocks.NETHER_BRICKS,
                    Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS,
                    Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS
            );
    private static final Map<Block, Block> UNCHISEL_MAP =
            Map.of(
                    Blocks.STONE_BRICKS, Blocks.STONE,
                    Blocks.END_STONE_BRICKS, Blocks.END_STONE,
                    Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE,
                    Blocks.MOSSY_STONE_BRICKS, Blocks.MOSSY_COBBLESTONE,
                    Blocks.TUFF_BRICKS, Blocks.TUFF,
                    Blocks.BRICKS, Blocks.CLAY,
                    Blocks.MUD_BRICKS, Blocks.PACKED_MUD,
                    Blocks.NETHER_BRICKS, Blocks.NETHERRACK,
                    Blocks.QUARTZ_BRICKS, Blocks.QUARTZ_BLOCK,
                    Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE
            );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        assert context.getPlayer() != null;
        if (!context.getPlayer().isCrouching()) {
            if (CHISEL_MAP.containsKey(clickedBlock)) {
                if (!level.isClientSide()) {
                    level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                    context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                            item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                    level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);

                    context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
                }
                return InteractionResult.SUCCESS;
            }
        } else {
            if (UNCHISEL_MAP.containsKey(clickedBlock)) {
                if (!level.isClientSide()) {
                    level.setBlockAndUpdate(context.getClickedPos(), UNCHISEL_MAP.get(clickedBlock).defaultBlockState());

                    context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                            item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                    level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);

                    context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
                }
                return InteractionResult.SUCCESS;
            }
        }
        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.techmod.chisel.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.techmod.chisel.shift_up"));
        }

        if (stack.get(ModDataComponents.COORDINATES) != null) {
            tooltipComponents.add(Component.literal("§7Last block changed at: " + stack.get(ModDataComponents.COORDINATES).getX() + ", " + stack.get(ModDataComponents.COORDINATES).getY()+ ", " + stack.get(ModDataComponents.COORDINATES).getZ()));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
