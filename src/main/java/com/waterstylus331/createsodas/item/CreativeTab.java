package com.waterstylus331.createsodas.item;

import com.waterstylus331.createsodas.CreateSodas;
import com.waterstylus331.createsodas.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateSodas.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = TABS.register("mod_tab",
            () -> CreativeModeTab.builder().title(Component.translatable("creativetab.mod_tab"))
                    .icon(() -> new ItemStack(ModItems.ROOT_BEER.get()))
                    .displayItems((pParameter, pOutput) -> {
                        pOutput.accept(new ItemStack(ModItems.RAW_BAUXITE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.BAUXITE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.DEEPSLATE_BAUXITE_ORE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.RAW_BAUXITE_BLOCK.get()));
                        pOutput.accept(new ItemStack(ModItems.RAW_ALUMINUM.get()));
                        pOutput.accept(new ItemStack(ModItems.ALUMINUM_INGOT.get()));
                        pOutput.accept(new ItemStack(ModItems.ALUMINUM_SHEET.get()));

                        pOutput.accept(new ItemStack(ModItems.EMPTY_CAN.get()));
                        pOutput.accept(new ItemStack(ModItems.EMPTY_UNPRINTED_CAN.get()));
                        pOutput.accept(new ItemStack(ModItems.ROOT_BEER.get()));
                        pOutput.accept(new ItemStack(ModItems.EMPTY_ROOT_BEER.get()));
                        pOutput.accept(new ItemStack(ModItems.DRPEPPER.get()));
                        pOutput.accept(new ItemStack(ModItems.EMPTY_DRPEPPER.get()));
                    })
                    .build());

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
