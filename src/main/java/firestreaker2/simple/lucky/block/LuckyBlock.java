package firestreaker2.simple.lucky.block;

import java.util.Random;

import com.google.common.collect.Iterables;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LuckyBlock extends Block {
  public LuckyBlock(Settings settings) {
    super(settings);
  }

  @Override
  public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
    if (!world.isClient) {
      Random random = new Random();
      int amount = random.nextInt(64);

      Iterable<Identifier> ids = Registries.ITEM.getIds();
      Identifier[] idArray = Iterables.toArray(ids, Identifier.class);
      int index = random.nextInt(idArray.length);
      Item item = Registries.ITEM.get(idArray[index]);

      ItemStack items = new ItemStack(item, amount);

      if (!player.getInventory().insertStack(items)) {
        player.dropItem(items, false);
      }
    }

    super.onBreak(world, pos, state, player);
  }
}
