package me.eldodebug.soar.management.file;

import me.eldodebug.soar.Glide;
import me.eldodebug.soar.logger.GlideLogger;
import net.lax1dude.eaglercraft.v1_8.internal.vfs2.VFile2;

public class FileManager {

	private VFile2 glideDir, profileDir, cacheDir, screenshotDir, soarDir, customCapeDir, capeCacheDir;
	private boolean migrationSuccess = false;
	
	public FileManager() {
		glideDir = new VFile2("glide");
		soarDir = new VFile2("soar");
		profileDir = new VFile2(glideDir, "profile");
		cacheDir = new VFile2(glideDir, "cache");
		screenshotDir = new VFile2(glideDir, "screenshots");
		customCapeDir = new VFile2(cacheDir, "custom-cape");
		capeCacheDir = new VFile2(cacheDir, "cape");

		try {
			if(!glideDir.exists()) {
				if(soarDir.exists()) {
					migrationSuccess = soarDir.renameTo(glideDir);
					if(!migrationSuccess) {
						createDir(glideDir);
					}
				} else {
					createDir(glideDir);
				}
			}

			if(!profileDir.exists()) createDir(profileDir);
			if(!cacheDir.exists()) createDir(cacheDir);
			if(!screenshotDir.exists()) createDir(screenshotDir);
			if(!customCapeDir.exists()) createDir(customCapeDir);
			if(!capeCacheDir.exists()) createDir(capeCacheDir);

			createVersionFile();
		} catch (Exception e) {
			GlideLogger.error("Something has gone very wrong while trying to create the glide folder which may result in crashes later", e);
		}
	}
	
	private void createVersionFile() {
		VFile2 versionDir = new VFile2(cacheDir, "version");
		createDir(versionDir);
		createFile(new VFile2(versionDir, Glide.getInstance().getVersionIdentifier() + ".tmp"));
	}
	
	public void createDir(VFile2 file) {
		try {
			if(!file.exists()) {
				file.setAllBytes(new byte[0]);
			}
		} catch (Exception e) {
			GlideLogger.error("Failed to create directory " + file, e);
		}
	}
	
	public void createFile(VFile2 file) {
		try {
			if(!file.exists()) {
				file.setAllBytes(new byte[0]);
			}
		} catch (Exception e) {
			GlideLogger.error("Failed to create file " + file, e);
		}
	}

	public VFile2 getScreenshotDir() {
		return screenshotDir;
	}

	public VFile2 getGlideDir() {
		return glideDir;
	}

	public VFile2 getProfileDir() {
		return profileDir;
	}

	public VFile2 getCacheDir() {
		return cacheDir;
	}

	public VFile2 getCustomCapeDir() {
		return customCapeDir;
	}

	public VFile2 getCapeCacheDir() {
		return capeCacheDir;
	}

}
