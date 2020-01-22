package me.NoChance.PvPManager.Managers;

import java.util.HashMap;
import java.util.Map;

import me.NoChance.PvPManager.PvPlayer;
import me.NoChance.PvPManager.Settings.Settings;
import me.NoChance.PvPManager.Utils.ProgressBar;

public class DisplayManager {

	private final Map<Integer, ProgressBar> actionBars = new HashMap<>();

	public DisplayManager() {
		if (!Settings.getActionBarMessage().isEmpty()) {
			for (int i = 0; i < Settings.getTimeInCombat() + 1; i++) {
				actionBars.put(i, new ProgressBar(Settings.getActionBarMessage(), Settings.getActionBarBars(), Settings.getTimeInCombat(), Settings.getActionBarSymbol(), i));
			}
		}
	}

	public void showProgress(final PvPlayer p, final double timePassed) {
		p.sendActionBar(actionBars.get((int) (timePassed + 0.5)).getMessage());
	}

}
