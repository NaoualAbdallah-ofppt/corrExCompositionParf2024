package aa.bb.correxcompositionparf;

import java.util.HashMap;

public class Produit
        implements Iidentification, Comparable
{
    private String code;
    private String designation;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    @Override
    public String identifier() {
        return "Fournisseur :" + designation ;
    }

    @Override
    public int compareTo(Object o) {
        if (o==null){
            return 0;}
        Produit p =(Produit) o;
        return p.code.compareTo(code);
    }
}
