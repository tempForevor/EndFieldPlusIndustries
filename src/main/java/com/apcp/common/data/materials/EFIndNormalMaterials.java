package com.apcp.common.data.materials;

import com.apcp.EFIndMod;
import com.apcp.common.data.elements.EFIndNormalElements;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.common.data.GTMaterialBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import java.util.Collections;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EFIndNormalMaterials {
//    Aluminium = new Material.Builder(GTCEu.id("aluminium"))
//            .ingot()
//                .liquid(new FluidBuilder().temperature(933))
//            .ore()
//                .color(0x7db9d8).secondaryColor(0x756ac9c)
//                .appendFlags(EXT2_METAL, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_RING, GENERATE_FRAME,
//                             GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FINE_WIRE)
//                .element(GTElements.Al)
//                .toolStats(ToolProperty.Builder.of(6.0F, 7.5F, 768, 2)
//                        .enchantability(14).build())
//            .rotorStats(100, 140, 2.0f, 128)
//                .cableProperties(V[EV], 1, 1)
//                .fluidPipeProperties(1166, 100, true)
//                .blast(1700, GasTier.LOW)
//                .buildAndRegister();
    public static Material ActiveOriginium;
    public static Material ComplexOpticalCrystal;
    public static Material OpticalOriginiumCrystal;

    public static void init(){
        ActiveOriginium =
                new Material.Builder(EFIndMod.id("active_originium"))
                        .liquid(new FluidBuilder().temperature(1223))
                        .ore()
                        .color(0x000000).secondaryColor(0x111111)
                        .flags(GENERATE_FRAME,GENERATE_ROD,GENERATE_LONG_ROD)
                        .element(EFIndNormalElements.Originium)
                        .gem()
                        .iconSet(MaterialIconSet.GEM_HORIZONTAL)
                        .langValue("Active Originium")
                        .buildAndRegister();

        // May be useful ?
        TagPrefix.oreRedGranite.setIgnored(ActiveOriginium);

        ComplexOpticalCrystal =
                new Material.Builder(EFIndMod.id("complex_optical_crystal"))
                        .gem()
                        .dust()
                        .color(0xffffff).secondaryColor(0xeeeeee)
                        .iconSet(MaterialIconSet.GEM_HORIZONTAL)
                        .componentStacks(new MaterialStack(Silicon,1),new MaterialStack(Oxygen,2))
                        .langValue("Complex Optical Crystal")
                        .buildAndRegister();

        OpticalOriginiumCrystal =
                new Material.Builder(EFIndMod.id("optical_originium_crystal"))
                        .gem()
                        .dust()
                        .color(0xffffff)
                        .iconSet(MaterialIconSet.GEM_VERTICAL)
                        .componentStacks(new MaterialStack(ActiveOriginium,12),new MaterialStack(ComplexOpticalCrystal,23))
                        .langValue("Optical Originium Crystal")
                        .buildAndRegister();

    }
}
