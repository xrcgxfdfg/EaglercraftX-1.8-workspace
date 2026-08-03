package me.eldodebug.soar.management.mods;

import me.eldodebug.soar.Glide;
import me.eldodebug.soar.management.notification.NotificationType;
import me.eldodebug.soar.utils.ServerUtils;

public class RestrictedMod {

    String currentServerIP = "";
    public Boolean shouldCheck = true;

    public boolean checkAllowed(Mod m) {
        if (shouldCheck) {
            // Remote blacklist checks are disabled in the Eaglercraft port.
        }
        m.setAllowed(true);
        return true;
    }

    public void joinServer(String ip) {
        // Remote blacklist checks are disabled in the Eaglercraft port.
    }

    public void joinWorld(){
        this.currentServerIP = ServerUtils.getServerIP();
        for(Mod m : Glide.getInstance().getModManager().getMods()){
            if(!checkAllowed(m) && m.isToggled()){
                m.setToggled(false);
                Glide.getInstance().getNotificationManager().post(m.getName(),  "Disabled due to serverside blacklist" , NotificationType.INFO);
            }
        }
    }

}
