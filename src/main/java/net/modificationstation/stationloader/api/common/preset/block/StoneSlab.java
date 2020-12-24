package net.modificationstation.stationloader.api.common.preset.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationloader.api.common.block.BlockRegistry;
import net.modificationstation.stationloader.api.common.registry.Identifier;

public class StoneSlab extends net.minecraft.block.StoneSlab {
    
    public StoneSlab(Identifier identifier, boolean flag) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), flag);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public StoneSlab(int i, boolean flag) {
        super(i, flag);
    }

    @Override
    public StoneSlab disableNotifyOnMetaDataChange() {
        return (StoneSlab) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public StoneSlab sounds(BlockSounds sounds) {
        return (StoneSlab) super.sounds(sounds);
    }

    @Override
    public StoneSlab setLightOpacity(int i) {
        return (StoneSlab) super.setLightOpacity(i);
    }

    @Override
    public StoneSlab setLightEmittance(float f) {
        return (StoneSlab) super.setLightEmittance(f);
    }

    @Override
    public StoneSlab setBlastResistance(float resistance) {
        return (StoneSlab) super.setBlastResistance(resistance);
    }

    @Override
    public StoneSlab setHardness(float hardness) {
        return (StoneSlab) super.setHardness(hardness);
    }

    @Override
    public StoneSlab setUnbreakable() {
        return (StoneSlab) super.setUnbreakable();
    }
}
