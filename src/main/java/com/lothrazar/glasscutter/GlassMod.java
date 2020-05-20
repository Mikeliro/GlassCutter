package com.lothrazar.glasscutter;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(GlassMod.MODID)
public class GlassMod {

  public static final String MODID = "glasscutter";

  public GlassMod() {}

  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEvents {

    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> event) {
      Item.Properties properties = new Item.Properties().group(ItemGroup.TOOLS);// tab group
      IForgeRegistry<Item> r = event.getRegistry();
      //normal is same durability as shears
      r.register(new GlassCutter(properties.maxStackSize(1).maxDamage(238)).setRegistryName(MODID));
      properties = new Item.Properties().group(ItemGroup.TOOLS);// tab group
      //same damage as diamond pickaxe
      r.register(new GlassCutter(properties.maxStackSize(1).maxDamage(1561)).setRegistryName("glasscutter_strong"));
    }
  }
}
