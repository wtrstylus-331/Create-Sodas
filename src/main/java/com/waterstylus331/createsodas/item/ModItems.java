package com.waterstylus331.createsodas.item;

import com.waterstylus331.createsodas.CreateSodas;
import com.waterstylus331.createsodas.fluid.ModFluids;
import com.waterstylus331.createsodas.item.drinks.*;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateSodas.MODID);

    public static final RegistryObject<Item> RAW_BAUXITE = ITEMS.register("raw_bauxite",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> ALUMINUM_SHEET = ITEMS.register("aluminum_sheet",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> EMPTY_CAN = ITEMS.register("empty_can",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> EMPTY_UNPRINTED_CAN = ITEMS.register("empty_unprinted_can",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> EMPTY_ROOT_BEER = ITEMS.register("empty_root_beer",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> ROOT_BEER = ITEMS.register("root_beer",
            () -> new RootBeerItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> ROOT_BEER_BUCKET = ITEMS.register("root_beer_bucket",
            () -> new BucketItem(ModFluids.SOURCE_ROOTBEER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> EMPTY_DRPEPPER = ITEMS.register("empty_dr_pepper",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> DRPEPPER = ITEMS.register("dr_pepper",
            () -> new DrPepperItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> DR_PEPPER_BUCKET = ITEMS.register("dr_pepper_bucket",
            () -> new BucketItem(ModFluids.SOURCE_DR_PEPPER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
