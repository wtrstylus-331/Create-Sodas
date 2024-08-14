package com.waterstylus331.createsodas.block;

import com.waterstylus331.createsodas.CreateSodas;
import com.waterstylus331.createsodas.block.crops.GingerCropBlock;
import com.waterstylus331.createsodas.block.crops.SassafrasCropBlock;
import com.waterstylus331.createsodas.fluid.ModFluids;
import com.waterstylus331.createsodas.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateSodas.MODID);

    public static final RegistryObject<DropExperienceBlock> BAUXITE_ORE = registerBlock("bauxite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));

    public static final RegistryObject<DropExperienceBlock> DEEPSLATE_BAUXITE_ORE = registerBlock("deepslate_bauxite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));

    public static final RegistryObject<Block> RAW_BAUXITE_BLOCK = registerBlock("raw_bauxite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SASSAFRAS_PLANT = BLOCKS.register("sassafras_crop",
            () -> new SassafrasCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> GINGER_PLANT = BLOCKS.register("ginger_crop",
            () -> new GingerCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<LiquidBlock> ROOT_BEER_BLOCK = registerBlock("root_beer_block",
            () -> new LiquidBlock(ModFluids.SOURCE_ROOTBEER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> DR_PEPPER_BLOCK = registerBlock("dr_pepper_block",
            () -> new LiquidBlock(ModFluids.SOURCE_DR_PEPPER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> GINGER_ALE_BLOCK = registerBlock("ginger_ale_block",
            () -> new LiquidBlock(ModFluids.SOURCE_GINGER_ALE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
