package net.modificationstation.stationloader.api.common.preset.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationloader.api.common.block.BlockRegistry;
import net.modificationstation.stationloader.api.common.registry.Identifier;

public class RedstoneOre extends net.minecraft.block.RedstoneOre {
    
    public RedstoneOre(Identifier identifier, int j, boolean isLit) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j, isLit);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public RedstoneOre(int i, int j, boolean isLit) {
        super(i, j, isLit);
    }

    @Override
    public RedstoneOre disableNotifyOnMetaDataChange() {
        return (RedstoneOre) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public RedstoneOre sounds(BlockSounds sounds) {
        return (RedstoneOre) super.sounds(sounds);
    }

    @Override
    public RedstoneOre setLightOpacity(int i) {
        return (RedstoneOre) super.setLightOpacity(i);
    }

    @Override
    public RedstoneOre setLightEmittance(float f) {
        return (RedstoneOre) super.setLightEmittance(f);
    }

    @Override
    public RedstoneOre setBlastResistance(float resistance) {
        return (RedstoneOre) super.setBlastResistance(resistance);
    }

    @Override
    public RedstoneOre setHardness(float hardness) {
        return (RedstoneOre) super.setHardness(hardness);
    }

    @Override
    public RedstoneOre setUnbreakable() {
        return (RedstoneOre) super.setUnbreakable();
    }
}
