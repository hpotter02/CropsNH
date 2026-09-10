package com.gtnewhorizon.cropsnh.compatibility.SC2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import vswe.stevescarts.ModuleData.ModuleData;
import vswe.stevescarts.ModuleData.ModuleDataGroup;
//import vswe.stevescarts.Items.ModItems;
import vswe.stevescarts.Modules.ModuleBase;

public class CropsNHModuleData extends ModuleData {

    public static ArrayList<ModuleData> moduleListCustom = new ArrayList<>();

    public CropsNHModuleData(int id, String name, Class<? extends ModuleBase> moduleClass, int modularCost) {
        super(id, name, moduleClass, modularCost);
	}

    public static void loadCropsNH() {
        HashMap<Byte, ModuleData> moduleList = ModuleData.getList();
            ModuleData netherwartModule = moduleList.get((byte)58); // 58 id of Crop: Netherwart
            try {
                Field reqField = ModuleData.class.getDeclaredField("requirement");
                reqField.setAccessible(true);
                ArrayList<ModuleDataGroup> requirements = (ArrayList<ModuleDataGroup>) reqField.get(netherwartModule);
                ModuleData cropsnhmodule = new ModuleData(104, "Crop: CropsNH", ModuleCropsNH.class, 55);
                reqField.set(cropsnhmodule, requirements);
                //moduleListCustom.add(cropsnhmodule);
                //HashMap<Byte, Boolean> ValidModules = (HashMap<Byte, Boolean>) ModItems.class.getDeclaredField("validModules").get(ModItems.class);
                //ValidModules.put((byte)104, true);
                //ValidModules.put((byte)103, false);
                //GameRegistry.registerCustomItemStack(cropsnhmodule.getUnlocalizedName(), cropsnhmodule.getItemStack());
            } catch (Exception e) {
                //LogHelper.info(e.toString());
                //LogHelper.printStackTrace(e);
            }
        
    }
}
