package net.witcherchan.inbetween.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.witcherchan.inbetween.InBetween;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InBetween.MOD_ID);

    public static final RegistryObject<Item> RAW_NICOL = ITEMS.register("raw_nicol",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NICOL_INGOT = ITEMS.register("nicol_ingot",
                () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FRAGANITE = ITEMS.register("fraganite",
                () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }


}
