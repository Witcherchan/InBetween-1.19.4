package net.witcherchan.inbetween.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.witcherchan.inbetween.InBetween;
import net.witcherchan.inbetween.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, InBetween.MOD_ID);

    public static final RegistryObject<Block> FRAGANITE_ORE = registerBlock("fraganite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FRAGANITE_BLOCK = registerBlock("fraganite_block",
                () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                        .strength(4f)
                        .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICOL_ORE = registerBlock("nicol_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_NICOL_BLOCK = registerBlock("raw_nicol_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICOL_BLOCK = registerBlock("nicol_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHADOW_STONE = registerBlock("shadow_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHADOW_COBBLESTONE = registerBlock("shadow_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SMOOTH_SHADOW_STONE = registerBlock("smooth_shadow_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHADOW_STONE_BRICKS = registerBlock("shadow_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CRACKED_SHADOW_STONE_BRICKS = registerBlock("cracked_shadow_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CHISELED_SHADOW_STONE_BRICKS = registerBlock("chiseled_shadow_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()));

    private static <T extends  Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

}
