package com.lothrazar.glasscutter;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;

public class GlassCutter extends Item {

  public GlassCutter(Properties properties) {
    super(properties);
  }

  @Override
  public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
    if (!worldIn.isRemote) {
      stack.damageItem(1, entityLiving, (p) -> {
        p.sendBreakAnimation(EquipmentSlotType.MAINHAND);
      });
    }
    return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
  }

  @Override
  public boolean canHarvestBlock(BlockState blockIn) {
    return blockIn.isIn(Tags.Blocks.GLASS)
        || blockIn.isIn(Tags.Blocks.GLASS_PANES);
  }

  @Override
  public float getDestroySpeed(ItemStack stack, BlockState state) {
    return state.getBlock().isIn(Tags.Blocks.GLASS)
        || state.getBlock().isIn(Tags.Blocks.GLASS_PANES) ? 15.0F : super.getDestroySpeed(stack, state);
  }

  @Override
  public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
    stack.addEnchantment(Enchantments.SILK_TOUCH, 1);
  }
}
