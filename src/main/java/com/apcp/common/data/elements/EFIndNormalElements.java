package com.apcp.common.data.elements;

import com.apcp.util.FormulaSymbol;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.common.data.GTElements;

public class EFIndNormalElements {
    public static class ElementComponent{
        public FormulaSymbol formula;
        public Element element;
        public ElementComponent(FormulaSymbol v_formula){
            formula = v_formula;
        }
        public void createAndRegister(long protons, long neutrons, long halfLifeSeconds, String decayTo,
                                      String name, boolean isIsotope) {
            element = GTElements.createAndRegister(protons, neutrons, halfLifeSeconds, decayTo, name, formula.getValue(), isIsotope);
        }
    }

    public static ElementComponent Originium = new ElementComponent(new FormulaSymbol("◈"));


    public static void init(){
        Originium.createAndRegister(1223,1223,-1,null,"Originium",false);
    }
}
