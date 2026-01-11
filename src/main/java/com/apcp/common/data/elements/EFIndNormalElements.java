package com.apcp.common.data.elements;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.common.data.GTElements;

public class EFIndNormalElements {
    public static Element Originium;

    public static void init(){
        Originium = GTElements.createAndRegister(1223,1223,-1,null,"Originium","◈",false);
    }
}
