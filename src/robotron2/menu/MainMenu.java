package robotron2.menu;

import com.osreboot.ridhvl2.menu.HvlMenu;
import com.osreboot.ridhvl2.menu.component.HvlArranger;
import com.osreboot.ridhvl2.menu.component.HvlButtonLabeled;
import com.osreboot.ridhvl2.menu.component.HvlSpacer;

import robotron2.RoomGenerator;
import robotron2.Main;
import robotron2.Player;

public class MainMenu {

	public static final int SPACER_SIZE = 40;
	
	public static void initialize(Player player) {
		MenuManager.main = new HvlArranger(false, 0.5f, 0.5f);
		MenuManager.main.add(HvlButtonLabeled.fromDefault().text("Start 1P").align(0.5f, 0.5f).offsetY(4).clicked((button) -> {
			HvlMenu.set(MenuManager.game);
			RoomGenerator.reset(player);
		}));
		MenuManager.main.add(new HvlSpacer(SPACER_SIZE));
		MenuManager.main.add(HvlButtonLabeled.fromDefault().text("Start 2P").align(0.5f, 0.5f).offsetY(4).clicked((button) -> {
			Main.newest().setExiting();
		}));
		MenuManager.main.add(new HvlSpacer(SPACER_SIZE));
		MenuManager.main.add(HvlButtonLabeled.fromDefault().text("Settings").align(0.5f, 0.5f).offsetY(4).clicked((button) -> {
			HvlMenu.set(MenuManager.settings);
		}));
		MenuManager.main.add(new HvlSpacer(SPACER_SIZE));
		MenuManager.main.add(HvlButtonLabeled.fromDefault().text("Credits").align(0.5f, 0.5f).offsetY(4).clicked((button) -> {
			Main.newest().setExiting();
		}));
		MenuManager.main.add(new HvlSpacer(SPACER_SIZE));
		MenuManager.main.add(HvlButtonLabeled.fromDefault().text("Exit Game").align(0.5f, 0.5f).offsetY(4).clicked((button) -> {
			Main.newest().setExiting();
		}));
	}

}
