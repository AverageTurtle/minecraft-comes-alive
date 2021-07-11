package mca.core.minecraft;

import mca.core.MCA;
import mca.enums.Gender;
import mca.items.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface ItemsMCA {
    Item EGG_MALE = register("egg_male", new SpawnEggItem(Gender.MALE, baseProps()));
    Item EGG_FEMALE = register("egg_female", new SpawnEggItem(Gender.FEMALE, baseProps()));
    Item BABY_BOY = register("baby_boy", new BabyItem(baseProps()));
    Item BABY_GIRL = register("baby_girl", new BabyItem(baseProps()));

    Item WEDDING_RING = register("wedding_ring", new WeddingRingItem(unstackableProps()));
    Item WEDDING_RING_RG = register("wedding_ring_rg", new WeddingRingRGItem(unstackableProps()));
    Item ENGAGEMENT_RING = register("engagement_ring", new EngagementRingItem(unstackableProps()));
    Item ENGAGEMENT_RING_RG = register("engagement_ring_rg", new EngagementRingRGItem(unstackableProps()));
    Item MATCHMAKERS_RING = register("matchmakers_ring", new MatchmakersRingItem(baseProps().maxCount(2)));

    Item VILLAGER_EDITOR = register("villager_editor", new Item(baseProps()));
    Item STAFF_OF_LIFE = register("staff_of_life", new StaffOfLifeItem(baseProps().maxDamage(5)));
    Item WHISTLE = register("whistle", new WhistleItem(baseProps()));
    Item BLUEPRINT = register("blueprint", new BlueprintItem(baseProps()));

    Item BOOK_ROSE_GOLD = register("book_rose_gold", new Item(baseProps()));
    Item BOOK_DEATH = register("book_death", new Item(baseProps()));
    Item BOOK_ROMANCE = register("book_romance", new Item(baseProps()));
    Item BOOK_FAMILY = register("book_family", new Item(baseProps()));
    Item BOOK_INFECTION = register("book_infection", new Item(baseProps()));

    Item GOLD_DUST = register("gold_dust", new Item(baseProps()));
    Item ROSE_GOLD_DUST = register("rose_gold_dust", new Item(baseProps()));
    Item ROSE_GOLD_INGOT = register("rose_gold_ingot", new Item(baseProps()));

    Item ROSE_GOLD_BLOCK = register("rose_gold_block", new BlockItem(BlocksMCA.ROSE_GOLD_BLOCK, baseProps()));
    Item ROSE_GOLD_ORE = register("rose_gold_ore", new BlockItem(BlocksMCA.ROSE_GOLD_ORE, baseProps()));

    static void bootstrap() {
        TagsMCA.Blocks.bootstrap();
        RecipesMCA.bootstrap();
    }

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MCA.MOD_ID, name), item);
    }

    private static Item.Settings baseProps() {
        return new Item.Settings().group(ItemGroupMCA.MCA_GROUP);
    }

    private static Item.Settings unstackableProps() {
        return baseProps().maxCount(1);
    }
}