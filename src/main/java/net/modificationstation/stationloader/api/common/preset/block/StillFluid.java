package net.modificationstation.stationloader.api.common.preset.block;

import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.modificationstation.stationloader.api.common.block.BlockRegistry;
import net.modificationstation.stationloader.api.common.registry.Identifier;

public class StillFluid extends net.minecraft.block.StillFluid {
    
    public StillFluid(Identifier identifier, Material arg) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), arg);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public StillFluid(int i, Material arg) {
        super(i, arg);
    }

    @Override
    public StillFluid disableNotifyOnMetaDataChange() {
        return (StillFluid) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public StillFluid sounds(BlockSounds sounds) {
        return (StillFluid) super.sounds(sounds);
    }

    @Override
    public StillFluid setLightOpacity(int i) {
        return (StillFluid) super.setLightOpacity(i);
    }

    @Override
    public StillFluid setLightEmittance(float f) {
        return (StillFluid) super.setLightEmittance(f);
    }

    @Override
    public StillFluid setBlastResistance(float resistance) {
        return (StillFluid) super.setBlastResistance(resistance);
    }

    @Override
    public StillFluid setHardness(float hardness) {
        return (StillFluid) super.setHardness(hardness);
    }

    @Override
    public StillFluid setUnbreakable() {
        return (StillFluid) super.setUnbreakable();
    }
}
