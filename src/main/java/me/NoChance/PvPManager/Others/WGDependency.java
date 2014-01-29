package me.NoChance.PvPManager.Others;

import me.NoChance.PvPManager.PvPManager;
import me.NoChance.PvPManager.Utils.Utils;

import org.bukkit.Location;
import org.bukkit.World;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag.State;

public class WGDependency {

	private WorldGuardPlugin wg;

	public WGDependency(PvPManager plugin) {
		if (Utils.isWGEnabled()) {
			wg = (WorldGuardPlugin) plugin.getServer().getPluginManager().getPlugin("WorldGuard");
			plugin.getLogger().info("WorldGuard Found! Enabling WorldGuard Support");
		}
	}

	public boolean hasWGPvPFlag(World world, Location loc) {
		if (Utils.isWGEnabled()) {
			ApplicableRegionSet set = wg.getRegionManager(world).getApplicableRegions(loc);
			if (set.getFlag(DefaultFlag.PVP) != null) {
				if (set.getFlag(DefaultFlag.PVP).equals(State.ALLOW))
					return true;
			}
		}
		return false;
	}

}
