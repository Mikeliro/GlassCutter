package com.lothrazar.glasscutter;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GlassCutter extends Item {

  public GlassCutter(Properties properties) {
    super(properties.maxStackSize(1).maxDamage(400));
  }

  @Override
  public boolean canHarvestBlock(BlockState blockIn) {
    return blockIn.isIn(GLASS);
  }

  public static Tag<Block> GLASS = new BlockTags.Wrapper(new ResourceLocation("forge:glass"));

  @Override
  public float getDestroySpeed(ItemStack stack, BlockState state) {
    return state.getBlock().isIn(GLASS) ? 15.0F : super.getDestroySpeed(stack, state);
  }

  @Override
  public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
    stack.addEnchantment(Enchantments.SILK_TOUCH, 1);
  }
}
