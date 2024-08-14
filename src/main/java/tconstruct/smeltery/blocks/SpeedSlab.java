package tconstruct.smeltery.blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import tconstruct.blocks.SlabBase;
import tconstruct.library.TConstructRegistry;
import tconstruct.smeltery.TinkerSmeltery;

public class SpeedSlab extends SlabBase {

    public SpeedSlab() {
        super(Material.rock);
        this.setCreativeTab(TConstructRegistry.blockTab);
        setHardness(3F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {}

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        meta = meta % 8;
        return TinkerSmeltery.speedBlock.getIcon(side, meta);
    }

    @Override
    public void getSubBlocks(Item b, CreativeTabs tab, List<ItemStack> list) {
        for (int iter = 0; iter < 7; iter++) {
            list.add(new ItemStack(b, 1, iter));
        }
    }

    @Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        SpeedBlock.applyBrownstoneSpeed(world, x, y, z, entity);
    }
}
