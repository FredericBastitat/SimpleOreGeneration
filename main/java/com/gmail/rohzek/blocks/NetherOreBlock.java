package com.gmail.rohzek.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Team;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Allows you to change things about ALL of the Nether ores specifically
 * @author Rohzek
 *
 */
public class NetherOreBlock extends GenericBlock
{
	private static int aggroRange = 32;
	
	public NetherOreBlock(String unlocalizedName)
	{
		super(unlocalizedName, Material.ROCK, 3f, 15f);
		
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this == SGOres.netherCoalOre ? Items.COAL :
        	   this == SGOres.netherDiamondOre ? Items.DIAMOND :
        	   this == SGOres.netherEmeraldOre ? Items.EMERALD :
        	   this == SGOres.netherLapisOre ? Items.DYE : 
        	   this == SGOres.netherRedstoneOre ? Items.REDSTONE :
        	   Item.getItemFromBlock(this);
    }
	
	@Override
	public int quantityDropped(Random random)
    {
		return  this == SGOres.netherCoalOre ? 1 + random.nextInt(2) :
     	   		this == SGOres.netherLapisOre ? 1 + random.nextInt(8) : 
     	   		this == SGOres.netherRedstoneOre ? 1 + random.nextInt(5) :
     	   		1;
    }
	
	@Override
	public int damageDropped(IBlockState state)
    {
        return this == SGOres.netherLapisOre ? EnumDyeColor.BLUE.getDyeDamage() : 0;
    }
}
