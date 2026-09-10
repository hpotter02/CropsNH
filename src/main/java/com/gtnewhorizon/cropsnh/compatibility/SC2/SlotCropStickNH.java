package com.gtnewhorizon.cropsnh.compatibility.SC2;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import com.gtnewhorizon.cropsnh.items.blocks.ItemCropSticks;

import vswe.stevescarts.Slots.SlotBase;

public class SlotCropStickNH extends SlotBase {

    public SlotCropStickNH(IInventory iinventory, int i, int j, int k) {
        super(iinventory, i, j, k);
    }

    public boolean isItemValid(ItemStack itemstack) {
        return itemstack.getItem() instanceof ItemCropSticks;
    }
}
