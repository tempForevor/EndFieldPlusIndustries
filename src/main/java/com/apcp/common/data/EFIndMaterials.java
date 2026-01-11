package com.apcp.common.data;

import com.apcp.common.data.materials.EFIndExtendMaterials;
import com.apcp.common.data.materials.EFIndNormalMaterials;

public class EFIndMaterials {
    public static void init(){
        EFIndNormalMaterials.init();
    }

    public static void modify(){
        EFIndExtendMaterials.init();
    }
}
