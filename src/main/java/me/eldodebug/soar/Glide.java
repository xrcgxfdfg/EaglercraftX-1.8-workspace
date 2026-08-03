package me.eldodebug.soar;

import me.eldodebug.soar.gui.mainmenu.GuiGlideMainMenu;
import me.eldodebug.soar.gui.modmenu.GuiModMenu;
import me.eldodebug.soar.logger.GlideLogger;
import me.eldodebug.soar.management.cape.CapeManager;
import me.eldodebug.soar.management.color.ColorManager;
import me.eldodebug.soar.management.command.CommandManager;
import me.eldodebug.soar.management.event.EventManager;
import me.eldodebug.soar.management.file.FileManager;
import me.eldodebug.soar.management.language.LanguageManager;
import me.eldodebug.soar.management.mods.ModManager;
import me.eldodebug.soar.management.mods.impl.InternalSettingsMod;
import me.eldodebug.soar.management.nanovg.NanoVGManager;
import me.eldodebug.soar.management.notification.NotificationManager;
import me.eldodebug.soar.management.profile.ProfileManager;
import me.eldodebug.soar.management.quickplay.QuickPlayManager;
import me.eldodebug.soar.management.screenshot.ScreenshotManager;
import me.eldodebug.soar.management.security.SecurityFeatureManager;
import me.eldodebug.soar.management.waypoint.WaypointManager;
import me.eldodebug.soar.ui.ClickEffects;
import me.eldodebug.soar.utils.OptifineUtils;
import net.lax1dude.eaglercraft.v1_8.internal.vfs2.VFile2;
import net.minecraft.client.Minecraft;

public class Glide {

	private static Glide instance = new Glide();
	private Minecraft mc = Minecraft.getMinecraft();
	private boolean updateNeeded, soar8Released;
	private String name, version;
	private int verIdentifier;
	
	private NanoVGManager nanoVGManager;
	private FileManager fileManager;
	private LanguageManager languageManager;
	private EventManager eventManager;
	private ModManager modManager;
	private CapeManager capeManager;
	private ColorManager colorManager;
	private ProfileManager profileManager;
	private CommandManager commandManager;
	private ScreenshotManager screenshotManager;
	private NotificationManager notificationManager;
	private SecurityFeatureManager securityFeatureManager;
	private QuickPlayManager quickPlayManager;
    private WaypointManager waypointManager;
	private GuiModMenu modMenu;
	private GuiGlideMainMenu mainMenu;
	private long launchTime;
	private VFile2 firstLoginFile;
	private ClickEffects clickEffects;
	
	public Glide() {
		name = "Glide";
		version = "7.2";
		verIdentifier = 7201;
	}
	
	public void start() {
		try {
			OptifineUtils.disableFastRender();
		} catch(Exception ignored) {}
		fileManager = new FileManager();
		firstLoginFile = new VFile2(fileManager.getCacheDir(), "first.tmp");
		languageManager = new LanguageManager();
		eventManager = new EventManager();
		modManager = new ModManager();
		
		modManager.init();
		
		capeManager = new CapeManager();
		colorManager = new ColorManager();
		profileManager = new ProfileManager();

		modMenu = new GuiModMenu();
		mainMenu = new GuiGlideMainMenu();
		launchTime = System.currentTimeMillis();

		commandManager = new CommandManager();
		screenshotManager = new ScreenshotManager();
		notificationManager = new NotificationManager();
		securityFeatureManager = new SecurityFeatureManager();
		quickPlayManager = new QuickPlayManager();
		waypointManager = new WaypointManager();

		eventManager.register(new GlideHandler());

		InternalSettingsMod.getInstance().setToggled(true);
		clickEffects = new ClickEffects();
		mc.updateDisplay();
	}
	
	public void stop() {
		profileManager.save();
	}
	
	public static Glide getInstance() {
		return instance;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {return version;}

	public int getVersionIdentifier() {return verIdentifier;}

	public FileManager getFileManager() {
		return fileManager;
	}

	public ModManager getModManager() {
		return modManager;
	}

	public LanguageManager getLanguageManager() {
		return languageManager;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public NanoVGManager getNanoVGManager() {
		return nanoVGManager;
	}

	public ColorManager getColorManager() {
		return colorManager;
	}

	public ProfileManager getProfileManager() {
		return profileManager;
	}

	public CapeManager getCapeManager() {
		return capeManager;
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public ScreenshotManager getScreenshotManager() {
		return screenshotManager;
	}

	public void setNanoVGManager(NanoVGManager nanoVGManager) {
		this.nanoVGManager = nanoVGManager;
	}

	public NotificationManager getNotificationManager() {
		return notificationManager;
	}

	public SecurityFeatureManager getSecurityFeatureManager() {
		return securityFeatureManager;
	}

	public QuickPlayManager getQuickPlayManager() {
		return quickPlayManager;
	}

	public WaypointManager getWaypointManager() {
		return waypointManager;
	}

	public GuiModMenu getModMenu() {
		return modMenu;
	}

	public GuiGlideMainMenu getMainMenu() {
		return mainMenu;
	}

	public long getLaunchTime() {
		return launchTime;
	}

	public void createFirstLoginFile() {
		Glide.getInstance().getFileManager().createFile(firstLoginFile);
	}

	public boolean isFirstLogin() {return !firstLoginFile.exists();}

	public void setUpdateNeeded(boolean in) {updateNeeded = in;}
	public boolean getUpdateNeeded() {return updateNeeded;}

	public void setSoar8Released(boolean in) {soar8Released = in;}
	public boolean getSoar8Released() {return soar8Released;}

	public ClickEffects getClickEffects() {return clickEffects;}
}
