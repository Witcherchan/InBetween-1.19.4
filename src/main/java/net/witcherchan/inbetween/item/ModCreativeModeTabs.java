package net.witcherchan.inbetween.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.witcherchan.inbetween.InBetween;


@Mod.EventBusSubscriber(modid = InBetween.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab INBETWEEN_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        INBETWEEN_TAB = event.registerCreativeModeTab(new ResourceLocation(InBetween.MOD_ID, "inbetween_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.FRAGANITE.get()))
                        .title(Component.translatable("creativemodetab:inbetween_tab")));
    }

}