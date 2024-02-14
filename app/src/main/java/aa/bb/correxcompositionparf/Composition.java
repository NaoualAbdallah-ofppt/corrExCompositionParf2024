package aa.bb.correxcompositionparf;

import java.util.HashMap;
public abstract class Composition {
    protected String code;
    protected String nom;
    protected float prixV;
    protected int qteS;
    protected Fournisseur four;
    protected HashMap<String,Produit> lstProduits = new HashMap<String, Produit>();


    public Composition() {
    }

    public Composition(String code,String nom, float prixV)
    throws Exception{
        if (prixV<0) {
            throw new Exception("Le prix de vente doit être positif");
        }
        this.code=code;
        this.nom = nom;
        this.prixV = prixV;
        qteS=0;
    }

    public Composition(String code, String nom, float prixV, Fournisseur four)
    throws Exception{

        if (prixV<0) {
            throw new Exception("Le prix de vente doit être positif");
        }
        this.code=code;
        this.nom = nom;
        this.prixV = prixV;
        this.four = four;
        qteS=0;
    }
    public Composition( String code, String nom,Fournisseur four, HashMap<String,Produit> lstPro) {
        this.code=code;
        this.nom = nom;
        this.prixV = prixV;
        this.four = four;
        this.lstProduits=lstPro;
        qteS=0;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrixV() {
        return prixV;
    }

    public void setPrixV(float prixV)
    throws Exception{
        if (prixV<0) {
            throw new Exception("Le prix de vente doit être positif");
        }

        this.prixV = prixV;
    }

    public int getQteS() {
        return qteS;
    }


    public Fournisseur getFour() {
        return four;
    }

    public void setFour(Fournisseur four) {
        this.four = four;
    }
    public abstract   double tva();
    public  void ajouterProduit(Produit P)
            throws Exception
    {
        if (lstProduits.containsKey(P.getCode()))
        {
            throw  new Exception("Code produit déjà existant");
        }
        lstProduits.put(P.getCode(),P);
    }
    public void eliminerProduit(String code)
            throws Exception
    {
        if (!lstProduits.containsKey(code))
        {
            throw  new Exception("Code produit non existant");
        }
        lstProduits.remove(code);

    }
    public void modifierProduit(Produit newP)
            throws Exception
    {
        if (!lstProduits.containsKey(newP.getCode()))
        {
            throw  new Exception("Code produit non existant");
        }
        //L'ancien produit sera éclasé et remplacé par les nouvelles informations
        lstProduits.put(newP.getCode(), newP);

    }
    public Produit rechercherProduit(String code)
            throws Exception
    {
        if (!lstProduits.containsKey(code))
        {
            return  null;
        }

        //L'ancien produit sera éclasé et remplacé par les nouvelles informations
        return lstProduits.get(code);

    }
public  HashMap<String,Produit> getConstitution()
{
    return lstProduits;
}
public  void actualiserStock(int qte, String typeOperation)
throws Exception{


        if (!typeOperation.toUpperCase().equals("ACHAT") && !typeOperation.toUpperCase().equals("VENTE") ){
            throw new Exception("Achat ou vente pour le type");
        }
        if (typeOperation.toUpperCase().equals("ACHAT"))
        {    qteS+=qte;}
        else
        {
            qteS-=qte;}

}

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Composition c = (Composition) obj;
        return c.nom == nom && c.four.equals(four) ;
    }

}
