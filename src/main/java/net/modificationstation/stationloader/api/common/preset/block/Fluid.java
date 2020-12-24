package net.modificationstation.stationloader.api.common.preset.block;

import net.minecraft.block.BlockSounds;
import net.minecraft.block.material.Material;
import net.modificationstation.stationloader.api.common.block.BlockRegistry;
import net.modificationstation.stationloader.api.common.registry.Identifier;

public class Fluid extends net.minecraft.block.Fluid {

    public Fluid(Identifier identifier, Material arg) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), arg);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }

    public Fluid(int i, Material arg) {
        super(i, arg);
    }

    @Override
    public Fluid disableNotifyOnMetaDataChange() {
        return (Fluid) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public Fluid sounds(BlockSounds sounds) {
        return (Fluid) super.sounds(sounds);
    }

    @Override
    public Fluid setLightOpacity(int i) {
        return (Fluid) super.setLightOpacity(i);
    }

    @Override
    public Fluid setLightEmittance(float f) {
        return (Fluid) super.setLightEmittance(f);
    }

    @Override
    public Fluid setBlastResistance(float resistance) {
        return (Fluid) super.setBlastResistance(resistance);
    }

    @Override
    public Fluid setHardness(float hardness) {
        return (Fluid) super.setHardness(hardness);
    }

    @Override
    public Fluid setUnbreakable() {
        return (Fluid) super.setUnbreakable();
    }
}
