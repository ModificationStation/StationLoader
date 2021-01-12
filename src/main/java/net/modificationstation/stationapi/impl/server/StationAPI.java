package net.modificationstation.stationapi.impl.server;

import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.client.resource.language.TranslationStorage;
import net.modificationstation.stationapi.api.common.event.EventRegistry;
import net.modificationstation.stationapi.api.common.event.recipe.RecipeRegister;
import net.modificationstation.stationapi.api.common.packet.StationHandshake;
import net.modificationstation.stationapi.api.common.recipe.JsonRecipeParserRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.api.common.registry.ModID;
import net.modificationstation.stationapi.api.server.event.network.HandleLogin;
import net.modificationstation.stationapi.api.server.event.network.PlayerLogin;
import net.modificationstation.stationapi.api.server.event.network.TrackEntity;
import net.modificationstation.stationapi.impl.server.entity.player.PlayerHelper;
import net.modificationstation.stationapi.impl.server.packet.PacketHelper;

import java.util.Map;

/**
 * The server side StationAPI entrypoint. Used for server side initialization.
 * @author mine_diver
 */
public class StationAPI extends net.modificationstation.stationapi.impl.common.StationAPI {

    /**
     * Performs server side API initialization.
     */
    @Override
    public void setupAPI() {
        super.setupAPI();
        getLogger().info("Setting up PlayerHelper...");
        net.modificationstation.stationapi.api.common.entity.player.PlayerHelper.INSTANCE.setHandler(new PlayerHelper());
        getLogger().info("Setting up PacketHelper...");
        net.modificationstation.stationapi.api.common.packet.PacketHelper.INSTANCE.setHandler(new PacketHelper());
        getLogger().info("Setting up HandleLogin...");
        HandleLogin.EVENT.register((pendingConnection, arg) -> {
            if (!getModsToVerifyOnClient().isEmpty()) {
                StationHandshake handshake = (StationHandshake) arg;
                String stationAPI = handshake.getStationAPI();
                String version = handshake.getVersion();
                ModID modID = getModID();
                String serverStationAPI = modID.toString();
                String serverStationVersion = modID.getVersion().getFriendlyString();
                TranslationStorage translationStorage = TranslationStorage.getInstance();
                if (stationAPI == null || version == null || !stationAPI.equals(serverStationAPI)) {
                    pendingConnection.drop(translationStorage.translate("disconnect.stationapi:missing_station"));
                    return;
                } else if (!version.equals(serverStationVersion)) {
                    pendingConnection.drop(translationStorage.translate("disconnect.stationapi:station_version_mismatch", serverStationVersion, version));
                    return;
                }
                Map<String, String> clientMods = handshake.getMods();
                String modid;
                String clientVersion;
                String serverVersion;
                for (ModContainer serverMod : getModsToVerifyOnClient()) {
                    ModMetadata modMetadata = serverMod.getMetadata();
                    modid = modMetadata.getId();
                    serverVersion = modMetadata.getVersion().getFriendlyString();
                    if (clientMods.containsKey(modid)) {
                        clientVersion = clientMods.get(modid);
                        if (clientVersion == null || !clientVersion.equals(serverVersion)) {
                            pendingConnection.drop(translationStorage.translate("disconnect.stationapi:mod_version_mismatch", modMetadata.getName(), modid, serverVersion, clientVersion == null ? "null" : clientVersion));
                            return;
                        }
                    } else {
                        pendingConnection.drop(translationStorage.translate("disconnect.stationapi:missing_mod", modMetadata.getName(), modid, serverVersion));
                        return;
                    }
                }
            }
        });
    }

    /**
     * Registers server side events.
     * @param eventRegistry the event registry used to initialize event listeners through fabric.mod.json entrypoints.
     * @param jsonRecipeParserRegistry the JSON recipe parser registry that holds all JSON recipe parsers to automatically run when {@link RecipeRegister} event is called with a proper identifier.
     * @param modID current mod's ModID.
     */
    @Override
    public void preInit(EventRegistry eventRegistry, JsonRecipeParserRegistry jsonRecipeParserRegistry, ModID modID) {
        super.preInit(eventRegistry, jsonRecipeParserRegistry, modID);
        eventRegistry.registerValue(Identifier.of(modID, "handle_login"), HandleLogin.EVENT);
        eventRegistry.registerValue(Identifier.of(modID, "player_login"), PlayerLogin.EVENT);
        eventRegistry.registerValue(Identifier.of(modID, "track_entity"), TrackEntity.EVENT);
    }
}
