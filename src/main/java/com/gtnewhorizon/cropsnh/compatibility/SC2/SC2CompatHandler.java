package com.gtnewhorizon.cropsnh.compatibility.SC2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

//import com.gtnewhorizon.cropsnh.utility.LogHelper;
import com.gtnewhorizon.cropsnh.utility.ModUtils;

import vswe.stevescarts.ModuleData.ModuleData;
import vswe.stevescarts.ModuleData.ModuleDataGroup;

public class SC2CompatHandler {

    public static void onInit() {
        if (!ModUtils.StevesCarts2.isModLoaded()) return;
         HashMap<Byte, ModuleData> moduleList = ModuleData.getList();
        ModuleData netherwartModule = moduleList.get((byte)58); // 58 id of Crop: Netherwart
        try {
            Field reqField = ModuleData.class.getDeclaredField("requirement");
            reqField.setAccessible(true);
            ArrayList<ModuleDataGroup> requirements = (ArrayList<ModuleDataGroup>) reqField.get(netherwartModule);
            ModuleData cropsnhmodule = new ModuleData(104, "Crop: CropsNH", ModuleCropsNH.class, 55);
            reqField.set(cropsnhmodule, requirements);

        } catch (Exception e) {
        }
    }
}
