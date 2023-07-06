package de.givingmybest09.buidlingtools.Item.Custom;

import com.ibm.icu.impl.coll.UVector32;
import de.givingmybest09.buidlingtools.Buidlingtools;
import de.givingmybest09.buidlingtools.Util.Math.Vector3;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class LineWand extends Item {

    BlockPos pos1;
    BlockPos pos2;
    public LineWand(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if(player.isCrouching()){
            pos2 = context.getClickedPos();

            Buidlingtools.LOGGER.info("pos2: " + pos2);
        }else{
            pos1 = context.getClickedPos();
            Buidlingtools.LOGGER.info("pos1: " + pos1);
        }


        return super.useOn(context);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        if(pos1 != null && pos2 != null){
            Vector3 dir = new Vector3(pos2.getX() - pos1.getX(), pos2.getY() - pos1.getY(), pos2.getZ() - pos1.getZ());
            dir.normalize();
            Buidlingtools.LOGGER.info(dir.x + " " + dir.y + " " + dir.z);

            Vector3 curPos = new Vector3(pos1.getX(), pos1.getY(), pos1.getZ());


            for (int i = 0; i < Vector3.getDistance(pos1, pos2); i++) {
                if(entity.getCommandSenderWorld().getBlockState(curPos.toBlockPos()) == Blocks.AIR.defaultBlockState()){
                    entity.getCommandSenderWorld().setBlock(curPos.toBlockPos(), Blocks.STONE.defaultBlockState(), 1);
                }

                curPos = curPos.add(dir);

            }
        }



        return super.onEntitySwing(stack, entity);
    }
}
