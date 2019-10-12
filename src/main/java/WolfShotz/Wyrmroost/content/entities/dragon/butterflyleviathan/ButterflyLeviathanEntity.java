package WolfShotz.Wyrmroost.content.entities.dragon.butterflyleviathan;

import WolfShotz.Wyrmroost.content.entities.dragon.AbstractDragonEntity;
import com.github.alexthe666.citadel.animation.Animation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ButterflyLeviathanEntity extends AbstractDragonEntity
{
    public ButterflyLeviathanEntity(EntityType<? extends ButterflyLeviathanEntity> blevi, World world) {
        super(blevi, world);
    }
    
    // ================================
    //           Entity NBT
    // ================================
    
    @Override
    protected void registerData() {
        super.registerData();
        
        dataManager.register(VARIANT, rand.nextInt(2));
    }
    
    @Override
    public void writeAdditional(CompoundNBT nbt) {
        super.writeAdditional(nbt);
    
        nbt.putInt("variant", getVariant());
    }
    
    @Override
    public void readAdditional(CompoundNBT nbt) {
        super.readAdditional(nbt);
        
        setVariant(nbt.getInt("variant"));
    }
    
    // =================================
    
    @Override
    public boolean processInteract(PlayerEntity player, Hand hand, ItemStack stack) {
        if (super.processInteract(player, hand, stack)) return true;
        
        return false;
    }
    
    @Override
    public boolean canFly() { return false; }
    
    @Override
    public boolean canBeRiddenInWater(Entity rider) { return true; }
    
    /**
     * Array Containing all of the dragons food items
     */
    @Override
    protected Item[] getFoodItems() { return new Item[] {Items.SEAGRASS}; }
    
    @Override
    public Animation[] getAnimations() { return new Animation[] {NO_ANIMATION}; }
}
