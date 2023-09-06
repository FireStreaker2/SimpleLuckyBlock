package firestreaker2.simple.lucky.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
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
      player.sendMessage(Text.of("your lucky number is: " + amount), false);
    }

    super.onBreak(world, pos, state, player);
  }
}
