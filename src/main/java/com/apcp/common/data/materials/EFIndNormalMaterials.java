package com.apcp.common.data.materials;

import com.apcp.EFIndMod;
import com.apcp.common.data.elements.EFIndNormalElements;
import com.apcp.util.FormulaSymbol;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.common.data.GTElements;
import com.gregtechceu.gtceu.common.data.GTMaterialBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import lombok.Setter;
import net.minecraft.resources.ResourceLocation;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EFIndNormalMaterials {
    public static class MaterialComponent{
        public FormulaSymbol formula;
        public Material material;
        public MaterialComponent(FormulaSymbol v_formula){
            formula = v_formula;
        }
        public MaterialComponent(Material v_material){
            setMaterial(v_material);
        }

        public void setMaterial(Material v_material){
            material = v_material;
            formula = new FormulaSymbol(material);
        }
    }

    /**
     * Exactly, you should call {@code formula() } first
     */
    public static class MaterialBuilder extends Material.Builder{
        public MaterialBuilder(ResourceLocation resourceLocation) {
            super(resourceLocation);
        }

        public MaterialBuilder formula(FormulaSymbol v_formula) {
            formula(v_formula.getValue());
            return this;
        }

        public MaterialBuilder formula(FormulaSymbol v_formula, boolean formatting){
            formula(v_formula.getValue(),formatting);
            return this;
        }
    }


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
    public static MaterialComponent ActiveOriginium;
    public static MaterialComponent ComplexOpticalCrystal;
    public static MaterialComponent OpticalOriginiumCrystal;

    public static void init(){
        ActiveOriginium = new MaterialComponent(
                new MaterialBuilder(EFIndMod.id("active_originium"))
                        .ore()
                        .liquid(new FluidBuilder().temperature(1223))
                        .gem()
                        .color(0x111111)
                        .iconSet(MaterialIconSet.GEM_HORIZONTAL)
                        .flags(GENERATE_FRAME,GENERATE_ROD,GENERATE_LONG_ROD)
                        .element(EFIndNormalElements.Originium.element)
                        .buildAndRegister());

        Consumer<Material> ignoredOre = material -> {
            // May be useful ?
            TagPrefix.oreRedGranite.setIgnored(material);
            TagPrefix.oreMarble.setIgnored(material);
        };

        ignoredOre.accept(ActiveOriginium.material);

        ComplexOpticalCrystal = new MaterialComponent(
                new MaterialBuilder(EFIndMod.id("complex_optical_crystal"))
                        .formula(new FormulaSymbol(SiliconDioxide).Mul(64))
                        .gem()
                        .dust()
                        .color(0xeeeeee)
                        .iconSet(MaterialIconSet.GEM_HORIZONTAL)
//                        .componentStacks(new MaterialStack(Silicon,1),new MaterialStack(Oxygen,2))
                        .buildAndRegister());

        OpticalOriginiumCrystal = new  MaterialComponent(
                new MaterialBuilder(EFIndMod.id("optical_originium_crystal"))
                        .formula(new FormulaSymbol().Component(ActiveOriginium.formula,12).Component(ComplexOpticalCrystal.formula,23))
                        .gem()
                        .dust()
                        .color(0xffffff)
                        .iconSet(MaterialIconSet.GEM_VERTICAL)
//                        .componentStacks(new MaterialStack(ActiveOriginium,12),new MaterialStack(ComplexOpticalCrystal,23))
                        .buildAndRegister());

    }
}
