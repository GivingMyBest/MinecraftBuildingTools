package de.givingmybest09.buidlingtools.Item;

import de.givingmybest09.buidlingtools.Buidlingtools;
import de.givingmybest09.buidlingtools.Item.Custom.LineWand;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Buidlingtools.MODID);


    public static final RegistryObject<Item> LINE_WAND = ITEMS.register("line_wand",
            () -> new LineWand(new Item.Properties().defaultDurability(312)));
}
