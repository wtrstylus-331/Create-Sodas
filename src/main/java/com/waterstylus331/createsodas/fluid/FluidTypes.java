package com.waterstylus331.createsodas.fluid;

import com.waterstylus331.createsodas.CreateSodas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class FluidTypes {
    public static final ResourceLocation STILL = new ResourceLocation("block/water_still");
    public static final ResourceLocation FLOW = new ResourceLocation("block/water_flow");
    public static final ResourceLocation IN_ROOTBEER = new ResourceLocation(CreateSodas.MODID,"fluid/in_root_beer");
    public static final ResourceLocation IN_DR_PEPPER = new ResourceLocation(CreateSodas.MODID,"fluid/in_dr_pepper");
    public static final ResourceLocation GINGER_ALE_STILL = new ResourceLocation(CreateSodas.MODID, "block/ginger_ale_still");
    public static final ResourceLocation GINGER_ALE_FLOW = new ResourceLocation(CreateSodas.MODID, "block/ginger_ale_flow");
    public static final ResourceLocation IN_GINGER_ALE = new ResourceLocation(CreateSodas.MODID,"fluid/in_ginger_ale");

    // todo - add more fluid types
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, CreateSodas.MODID);

    public static final RegistryObject<FluidType> ROOT_BEER_FLUID_TYPE = register("root_beer_fluid",
            STILL, FLOW, IN_ROOTBEER, 0xFF2B1501, new Vector3f(43f / 255f, 21f / 255f, 1f / 255f),
            FluidType.Properties.create().lightLevel(2).density(5).viscosity(2).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK).canDrown(true).canSwim(true).supportsBoating(false));

    public static final RegistryObject<FluidType> DR_PEPPER_FLUID_TYPE = register("dr_pepper_fluid",
            STILL, FLOW, IN_DR_PEPPER, 0xFF2B0101, new Vector3f(43f / 255f, 1f / 255f, 1f / 255f),
            FluidType.Properties.create().lightLevel(2).density(5).viscosity(2).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK).canDrown(true).canSwim(true).supportsBoating(false));

    public static final RegistryObject<FluidType> GINGER_ALE_FLUID_TYPE = register("ginger_ale_fluid",
            GINGER_ALE_STILL, GINGER_ALE_FLOW, IN_GINGER_ALE, 0x99BA8C48, new Vector3f(186f / 255f, 140f / 255f, 72f / 255f),
            FluidType.Properties.create().lightLevel(2).density(5).viscosity(2).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK).canDrown(true).canSwim(true).supportsBoating(false));

    private static RegistryObject<FluidType> register
            (String name, ResourceLocation still, ResourceLocation flow, ResourceLocation overlay, int tintColor, Vector3f rgb, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new StockFluidType(still, flow, overlay,
                tintColor, rgb, properties));
    }

    public static void register(IEventBus bus) {
        FLUID_TYPES.register(bus);
    }
}
