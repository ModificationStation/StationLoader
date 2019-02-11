package net.modificationstation.stationloader.common;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StationLoader {
	public static boolean addMod(Class<?> mod){
		if(!loadedMods.contains(mod)){
			loadedMods.add(mod);
			return true;
		}
		return false;
	}
	
    public static void addEventListener(Class<?> clazz) {
        if (!eventBusSubscriptors.contains(clazz)) {
            LOGGER.info("Added EventListener");
            eventBusSubscriptors.add(clazz);
        }
    }
    public static final String VERISON = "0.0.1";
	public static Logger LOGGER = Logger.getLogger("StationLoader");
	public static List<Class<?>> loadedMods = new ArrayList<Class<?>>();
	public static List<Class<?>> eventBusSubscriptors = new ArrayList<Class<?>>(); 
}