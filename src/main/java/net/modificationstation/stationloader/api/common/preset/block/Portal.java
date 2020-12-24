package net.modificationstation.stationloader.api.common.preset.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationloader.api.common.block.BlockRegistry;
import net.modificationstation.stationloader.api.common.registry.Identifier;

public class Portal extends net.minecraft.block.Portal {

    public Portal(Identifier identifier, int j) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }

    public Portal(int i, int j) {
        super(i, j);
    }

    @Override
    public Portal disableNotifyOnMetaDataChange() {
        return (Portal) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public Portal sounds(BlockSounds sounds) {
        return (Portal) super.sounds(sounds);
    }

    @Override
    public Portal setLightOpacity(int i) {
        return (Portal) super.setLightOpacity(i);
    }

    @Override
    public Portal setLightEmittance(float f) {
        return (Portal) super.setLightEmittance(f);
    }

    @Override
    public Portal setBlastResistance(float resistance) {
        return (Portal) super.setBlastResistance(resistance);
    }

    @Override
    public Portal setHardness(float hardness) {
        return (Portal) super.setHardness(hardness);
    }

    @Override
    public Portal setUnbreakable() {
        return (Portal) super.setUnbreakable();
    }
}
