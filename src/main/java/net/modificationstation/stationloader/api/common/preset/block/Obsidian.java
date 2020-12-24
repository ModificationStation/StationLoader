package net.modificationstation.stationloader.api.common.preset.block;

import net.minecraft.block.BlockSounds;
import net.modificationstation.stationloader.api.common.block.BlockRegistry;
import net.modificationstation.stationloader.api.common.registry.Identifier;

public class Obsidian extends net.minecraft.block.Obsidian {
    
    public Obsidian(Identifier identifier, int j) {
        this(BlockRegistry.INSTANCE.getNextSerializedID(), j);
        BlockRegistry.INSTANCE.registerValue(identifier, this);
    }
    
    public Obsidian(int i, int j) {
        super(i, j);
    }

    @Override
    public Obsidian disableNotifyOnMetaDataChange() {
        return (Obsidian) super.disableNotifyOnMetaDataChange();
    }

    @Override
    public Obsidian sounds(BlockSounds sounds) {
        return (Obsidian) super.sounds(sounds);
    }

    @Override
    public Obsidian setLightOpacity(int i) {
        return (Obsidian) super.setLightOpacity(i);
    }

    @Override
    public Obsidian setLightEmittance(float f) {
        return (Obsidian) super.setLightEmittance(f);
    }

    @Override
    public Obsidian setBlastResistance(float resistance) {
        return (Obsidian) super.setBlastResistance(resistance);
    }

    @Override
    public Obsidian setHardness(float hardness) {
        return (Obsidian) super.setHardness(hardness);
    }

    @Override
    public Obsidian setUnbreakable() {
        return (Obsidian) super.setUnbreakable();
    }
}
