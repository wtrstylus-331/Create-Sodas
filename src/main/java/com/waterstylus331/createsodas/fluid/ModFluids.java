package com.waterstylus331.createsodas.fluid;

import com.waterstylus331.createsodas.CreateSodas;
import com.waterstylus331.createsodas.block.ModBlocks;
import com.waterstylus331.createsodas.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, CreateSodas.MODID);

    // todo - add more fluids
    public static final RegistryObject<FlowingFluid> SOURCE_ROOTBEER = FLUIDS.register("root_beer",
            () -> new ForgeFlowingFluid.Source(ModFluids.ROOT_BEER_PROPS));

    public static final RegistryObject<FlowingFluid> FLOWING_ROOT_BEER = FLUIDS.register("flowing_root_beer",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.ROOT_BEER_PROPS));

    public static final RegistryObject<FlowingFluid> SOURCE_DR_PEPPER = FLUIDS.register("dr_pepper",
            () -> new ForgeFlowingFluid.Source(ModFluids.DR_PEPPER_PROPS));

    public static final RegistryObject<FlowingFluid> FLOWING_DR_PEPPER = FLUIDS.register("flowing_dr_pepper",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.DR_PEPPER_PROPS));

    public static final RegistryObject<FlowingFluid> SOURCE_GINGER_ALE = FLUIDS.register("ginger_ale",
            () -> new ForgeFlowingFluid.Source(ModFluids.GINGER_ALE_PROPS));

    public static final RegistryObject<FlowingFluid> FLOWING_GINGER_ALE = FLUIDS.register("flowing_ginger_ale",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.GINGER_ALE_PROPS));

    public static final ForgeFlowingFluid.Properties ROOT_BEER_PROPS = new ForgeFlowingFluid.Properties(
            FluidTypes.ROOT_BEER_FLUID_TYPE, SOURCE_ROOTBEER, FLOWING_ROOT_BEER)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2)
            .block(ModBlocks.ROOT_BEER_BLOCK)
            .bucket(ModItems.ROOT_BEER_BUCKET);

    public static final ForgeFlowingFluid.Properties DR_PEPPER_PROPS = new ForgeFlowingFluid.Properties(
            FluidTypes.DR_PEPPER_FLUID_TYPE, SOURCE_DR_PEPPER, FLOWING_DR_PEPPER)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2)
            .block(ModBlocks.DR_PEPPER_BLOCK)
            .bucket(ModItems.DR_PEPPER_BUCKET);

    public static final ForgeFlowingFluid.Properties GINGER_ALE_PROPS = new ForgeFlowingFluid.Properties(
            FluidTypes.GINGER_ALE_FLUID_TYPE, SOURCE_GINGER_ALE, FLOWING_GINGER_ALE)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2)
            .block(ModBlocks.GINGER_ALE_BLOCK)
            .bucket(ModItems.GINGER_ALE_BUCKET);

    public static void register(IEventBus bus) {
        FLUIDS.register(bus);
    }
}
