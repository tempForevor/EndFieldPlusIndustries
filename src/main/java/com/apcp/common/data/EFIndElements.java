package com.apcp.common.data;

import com.apcp.common.data.elements.EFIndExtendElements;
import com.apcp.common.data.elements.EFIndNormalElements;

public class EFIndElements {
    public static void init(){
        EFIndNormalElements.init();
        modify(); // TODO: check where it is needed;
    }

    public static void modify(){
        EFIndExtendElements.init();
    }
}
