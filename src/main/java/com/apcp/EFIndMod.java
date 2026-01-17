package com.apcp;

import com.apcp.api.registry.EFIGTRegistration;
import com.apcp.common.data.EFIndMaterials;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.sound.SoundEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.GenericEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.javafmlmod.FMLModContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;

@SuppressWarnings("removal")
@Mod(EFIndMod.MOD_ID)
public final class EFIndMod {
    public static final String MOD_ID = "endfieldind";
    public static final String ModName = "End Field Ind Mod";
    public static Logger LOGGER = LogManager.getLogger(ModName);

    @SuppressWarnings("removal")
    public EFIndMod() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like registries and resources) may still be uninitialized.
        // Proceed with mild caution.
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.register(this);
        EFIGTRegistration.REGISTRATE.registerEventListeners(eventBus);

//        eventBus.addGenericListener(GTRecipeType::class.java) { _: GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> ->
//            GTLAddRecipesTypes.init()
//        }
//        modEventBus.addGenericListener(MachineDefinition::class.java) { _: GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> ->
//            GTLAddMachines.init()
//        }
//        eventBus.addListener(this::commonSetup);
//        eventBus.addListener(this::clientSetup);
//
//        eventBus.addListener(this::addMaterialRegistries);
//        eventBus.addListener(this::addMaterials);
//        eventBus.addListener(this::modifyMaterials);
        
        eventBus.addGenericListener(GTRecipeType.class,this::registerGTRecipeTypes);
        eventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
        eventBus.addGenericListener(SoundEntry.class, this::registerSounds);
    }

    /**
     * Create a ResourceLocation in the format "modid:path"
     *
     * @param path
     * @return ResourceLocation with the namespace of your mod
     */
    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }


    @SubscribeEvent
    public void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Registering End Field Industries Plus...");
        });
    }

    @SubscribeEvent
    private void clientSetup(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    private void addMaterialRegistries(MaterialRegistryEvent event) {
        GTCEuAPI.materialManager.createRegistry(MOD_ID);
    }

    @SubscribeEvent
    private void addMaterials(MaterialEvent event) {
        EFIndMaterials.init();
    }

    @SubscribeEvent
    private void modifyMaterials(PostMaterialEvent event) {
        EFIndMaterials.modify();
    }

    private void registerSounds(GTCEuAPI.RegisterEvent<ResourceLocation,SoundEntry> event) {

    }

    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation,MachineDefinition> event) {

    }

    public void registerGTRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation,GTRecipeType> event) {

    }
}
