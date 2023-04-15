package net.witcherchan.inbetween;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.witcherchan.inbetween.block.ModBlocks;
import net.witcherchan.inbetween.item.ModCreativeModeTabs;
import net.witcherchan.inbetween.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(InBetween.MOD_ID)
public class InBetween
{

    //VERY IMPORTANT COMMENT
    public static final String MOD_ID = "inbetween";
    private static final Logger LOGGER = LogUtils.getLogger();

    public InBetween()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent  event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if(event.getTab() == ModCreativeModeTabs.INBETWEEN_TAB)
        {
            event.accept(ModItems.RAW_NICOL);
            event.accept(ModItems.NICOL_INGOT);
            event.accept(ModBlocks.NICOL_BLOCK);
            event.accept(ModBlocks.RAW_NICOL_BLOCK);
            event.accept(ModBlocks.NICOL_ORE);

            event.accept(ModItems.FRAGANITE);
            event.accept(ModBlocks.FRAGANITE_BLOCK);
            event.accept(ModBlocks.FRAGANITE_ORE);

            event.accept(ModBlocks.SHADOW_STONE);
            event.accept(ModBlocks.SHADOW_COBBLESTONE);
            event.accept(ModBlocks.SMOOTH_SHADOW_STONE);
            event.accept(ModBlocks.CRACKED_SHADOW_STONE_BRICKS);
            event.accept(ModBlocks.SHADOW_STONE_BRICKS);
            event.accept(ModBlocks.CHISELED_SHADOW_STONE_BRICKS);

        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
