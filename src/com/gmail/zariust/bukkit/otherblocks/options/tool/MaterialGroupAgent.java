package com.gmail.zariust.bukkit.otherblocks.options.tool;

import java.util.List;

import org.bukkit.Material;

import com.gmail.zariust.bukkit.common.MaterialGroup;
import com.gmail.zariust.bukkit.otherblocks.drops.AbstractDrop;
import com.gmail.zariust.bukkit.otherblocks.options.ConfigOnly;
import com.gmail.zariust.bukkit.otherblocks.options.drop.ItemType;

@ConfigOnly(PlayerAgent.class)
public class MaterialGroupAgent implements Agent {
	private MaterialGroup group;
	public MaterialGroupAgent(MaterialGroup g) {
		group = g;
	}
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof MaterialGroupAgent)) return false;
		return group == ((MaterialGroupAgent) other).group;
	}
	@Override
	public boolean matches(Agent other) {
		if(!(other instanceof PlayerAgent)) return false;
		return group.contains(((PlayerAgent) other).getMaterial());
	}
	@Override
	public int hashCode() {
		return AbstractDrop.hashCode(ItemType.PLAYER, 0, group.hashCode());
	}
	public List<Material> getMaterials() {
		return group.materials();
	}
	@Override
	public ItemType getType() {
		return ItemType.PLAYER;
	}
	@Override public void damage(int amount) {}
	@Override public void damageTool(short amount) {}
	@Override public void damageTool() {}
}