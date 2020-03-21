package com.lothrazar.glasscutter;

import com.lothrazar.glasscutter.setup.ClientProxy;
import com.lothrazar.glasscutter.setup.IProxy;
import com.lothrazar.glasscutter.setup.ServerProxy;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(GlassMod.MODID)
public class GlassMod {

  public static final String MODID = "glasscutter";
  public static final IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

  public GlassMod() {}

  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEvents {

    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> event) {
      Item.Properties properties = new Item.Properties().group(ItemGroup.TOOLS);// tab group
      IForgeRegistry<Item> r = event.getRegistry();
      // create a static registry using static variables annoated with  net.minecraftforge.registries.ObjectHolder
      r.register(new GlassCutter(properties).setRegistryName(MODID));
    }
  }
}
