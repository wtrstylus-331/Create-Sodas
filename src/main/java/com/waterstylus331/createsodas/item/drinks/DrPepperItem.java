package com.waterstylus331.createsodas.item.drinks;

import com.waterstylus331.createsodas.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class DrPepperItem extends HoneyBottleItem {
    public DrPepperItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(1f)
                .build()));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public boolean isEdible() {
        return true;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide()) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1));

            /* prankster gangster gaming
            for (int i = 0; i < 25; i++) {
                LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(level);
                bolt.setPos(livingEntity.position().x, livingEntity.position().y,livingEntity.position().z);
                bolt.setDamage(50);

                level.addFreshEntity(bolt);
            }

             */
        }

        if (livingEntity instanceof Player player) {
            player.getFoodData().eat(this, itemStack);

            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);

                if (itemStack.isEmpty()) {
                    return new ItemStack(ModItems.EMPTY_DRPEPPER.get());
                } else {
                    ItemStack emptyCan = new ItemStack(ModItems.EMPTY_DRPEPPER.get());
                    if (!player.getInventory().add(emptyCan)) {
                        player.drop(emptyCan, false);
                    }
                }
            }
        }

        return itemStack.isEmpty() ? new ItemStack(ModItems.EMPTY_DRPEPPER.get()) : itemStack;
    }
}
