package com.apcp.util;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;

public class FormulaSymbol {
    public StringBuilder builder;
    public FormulaSymbol(){
        builder = new StringBuilder();
    }
    public FormulaSymbol(String v_symbol){
        builder = new StringBuilder();
        builder.append(v_symbol);
    }
    public FormulaSymbol(Material material){
        builder = new StringBuilder();
        builder.append(material.getChemicalFormula());
    }
    public FormulaSymbol(Element element){
        builder = new StringBuilder();
        builder.append(element.symbol());
    }

    public FormulaSymbol Component(FormulaSymbol formula){
        builder.append(formula.builder);
        return this;
    }
    public FormulaSymbol Component(FormulaSymbol formula, int times){
        builder.append("(");
        builder.append(formula.builder);
        builder.append(")");
        if(times>0) {
            builder.append(times);
        }
        return this;
    }


    public FormulaSymbol Add(FormulaSymbol v_formula){
        return new FormulaSymbol().Component(this).Component(v_formula);
    }

    public FormulaSymbol Mul(int times){
        return new FormulaSymbol().Component(this, times);
    }

    public String getValue(){
        return builder.toString();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
