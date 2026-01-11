package com.apcp.api.registry;

import com.apcp.EFIndMod;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

public class EFIGTRegistration extends GTRegistrate {
    public static EFIGTRegistration REGISTRATE = new EFIGTRegistration();

    protected EFIGTRegistration() {
        super(EFIndMod.MOD_ID);
    }

}
