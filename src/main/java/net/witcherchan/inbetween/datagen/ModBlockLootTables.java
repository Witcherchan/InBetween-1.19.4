package net.witcherchan.inbetween.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.witcherchan.inbetween.block.ModBlocks;
import net.witcherchan.inbetween.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.RAW_NICOL_BLOCK.get());
        dropSelf(ModBlocks.NICOL_BLOCK.get());
        dropSelf(ModBlocks.FRAGANITE_BLOCK.get());
        dropSelf(ModBlocks.SHADOW_COBBLESTONE.get());

        add(ModBlocks.FRAGANITE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.FRAGANITE_ORE.get(), ModItems.FRAGANITE.get()));
        add(ModBlocks.NICOL_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NICOL_ORE.get(), ModItems.RAW_NICOL.get()));

        otherWhenSilkTouch(ModBlocks.SHADOW_STONE.get(),ModBlocks.SHADOW_COBBLESTONE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
