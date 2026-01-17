package com.apcp.data.recipes.gregtech;

import com.apcp.EFIndMod;
import com.apcp.common.data.materials.EFIndNormalMaterials;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.data.recipe.misc.AssemblerRecipeLoader;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;

import java.util.function.Consumer;

public class EFIndGTRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.LARGE_CHEMICAL_RECIPES.recipeBuilder(EFIndMod.id("generate_complex_optical_crystal"))
                .inputItems(TagPrefix.dust,GTMaterials.Silicon,64)
                .inputFluids(GTMaterials.Oxygen.getFluid(128))
                .inputItems(TagPrefix.dust,GTMaterials.SiliconDioxide,128)
                .notConsumable(TagPrefix.dust,GTMaterials.NetherStar,1)
                .outputItems(TagPrefix.dust,EFIndNormalMaterials.ComplexOpticalCrystal,1)
                .outputItems(TagPrefix.dust,GTMaterials.SiliconDioxide,16)
                .EUt(GTValues.VEX[GTValues.UV],23)
                .duration(12)
                .save(provider);

        GTRecipeTypes.LARGE_CHEMICAL_RECIPES.recipeBuilder(EFIndMod.id("generate_optical_originium_crystal"))
                .inputItems(TagPrefix.dust,EFIndNormalMaterials.ComplexOpticalCrystal,23)
                .inputItems(TagPrefix.dust,EFIndNormalMaterials.ActiveOriginium,12)
                .inputFluids(GTMaterials.NetherStar.getFluid(128))
                .outputItems(TagPrefix.dust,EFIndNormalMaterials.OpticalOriginiumCrystal,1)
                .EUt(GTValues.VEX[GTValues.UV],23)
                .duration(12)
                .save(provider);
    }
}
