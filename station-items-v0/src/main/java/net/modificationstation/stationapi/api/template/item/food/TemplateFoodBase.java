package net.modificationstation.stationapi.api.template.item.food;

import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ItemRegistry;
import net.modificationstation.stationapi.api.template.item.ItemTemplate;

public class TemplateFoodBase extends net.minecraft.item.food.FoodBase implements ItemTemplate<TemplateFoodBase> {
    
    public TemplateFoodBase(Identifier identifier, int healAmount, boolean isWolfFood) {
        this(ItemRegistry.INSTANCE.getNextSerialID(), healAmount, isWolfFood);
        ItemRegistry.INSTANCE.register(identifier, this);
    }
    
    public TemplateFoodBase(int id, int healAmount, boolean isWolfFood) {
        super(id, healAmount, isWolfFood);
    }

    @Override
    public TemplateFoodBase setTexturePosition(int texturePosition) {
        return (TemplateFoodBase) super.setTexturePosition(texturePosition);
    }

    @Override
    public TemplateFoodBase setMaxStackSize(int newMaxStackSize) {
        return (TemplateFoodBase) super.setMaxStackSize(newMaxStackSize);
    }

    @Override
    public TemplateFoodBase setTexturePosition(int x, int y) {
        return (TemplateFoodBase) super.setTexturePosition(x, y);
    }

    @Override
    public TemplateFoodBase setHasSubItems(boolean hasSubItems) {
        return (TemplateFoodBase) super.setHasSubItems(hasSubItems);
    }

    @Override
    public TemplateFoodBase setDurability(int durability) {
        return (TemplateFoodBase) super.setDurability(durability);
    }

    @Override
    public TemplateFoodBase setRendered3d() {
        return (TemplateFoodBase) super.setRendered3d();
    }

    @Override
    public TemplateFoodBase setTranslationKey(String newName) {
        return (TemplateFoodBase) super.setTranslationKey(newName);
    }

    @Override
    public TemplateFoodBase setContainerItem(net.minecraft.item.ItemBase itemType) {
        return (TemplateFoodBase) super.setContainerItem(itemType);
    }
}
