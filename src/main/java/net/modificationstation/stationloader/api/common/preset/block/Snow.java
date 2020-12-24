package net.modificationstation.stationloader.api.common.preset.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationloader.api.common.block.BlockRegistry;
import net.modificationstation.stationloader.api.common.registry.Identifier;

public class Snow extends net.minecraft.block.Snow {
    
    public Snow(Identifier identifier, int texUVStart) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), texUVStart);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public Snow(int id, int texUVStart) {
        super(id, texUVStart);
    }

    @Override
    public Snow disableNotifyOnMetaDataChange() {
        return (Snow) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public Snow sounds(BlockSounds sounds) {
        return (Snow) super.sounds(sounds);
    }

    @Override
    public Snow setLightOpacity(int i) {
        return (Snow) super.setLightOpacity(i);
    }

    @Override
    public Snow setLightEmittance(float f) {
        return (Snow) super.setLightEmittance(f);
    }

    @Override
    public Snow setBlastResistance(float resistance) {
        return (Snow) super.setBlastResistance(resistance);
    }

    @Override
    public Snow setHardness(float hardness) {
        return (Snow) super.setHardness(hardness);
    }

    @Override
    public Snow setUnbreakable() {
        return (Snow) super.setUnbreakable();
    }
}
