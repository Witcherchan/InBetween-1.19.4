package net.witcherchan.inbetween.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.witcherchan.inbetween.InBetween;
import net.witcherchan.inbetween.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, InBetween.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FRAGANITE_BLOCK);
        blockWithItem(ModBlocks.FRAGANITE_ORE);

        blockWithItem(ModBlocks.NICOL_BLOCK);
        blockWithItem(ModBlocks.RAW_NICOL_BLOCK);
        blockWithItem(ModBlocks.NICOL_ORE);

        blockWithItem(ModBlocks.SHADOW_COBBLESTONE);
        blockWithItem(ModBlocks.SHADOW_STONE);
        blockWithItem(ModBlocks.SHADOW_STONE_BRICKS);
        blockWithItem(ModBlocks.CRACKED_SHADOW_STONE_BRICKS);
        blockWithItem(ModBlocks.CHISELED_SHADOW_STONE_BRICKS);
        blockWithItem(ModBlocks.SMOOTH_SHADOW_STONE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
