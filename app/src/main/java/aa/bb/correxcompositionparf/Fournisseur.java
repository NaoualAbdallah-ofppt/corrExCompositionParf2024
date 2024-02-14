package aa.bb.correxcompositionparf;
public class Fournisseur {
 int num;
private String raisonSociale;
private String telephone;
private  String adresse;
private static  int nbrFournisseurs =0;
    public Fournisseur() {
        nbrFournisseurs++;
    }

    public Fournisseur(int num, String raisonSociale, String telephone, String adresse) {
        this.num = num;
        this.raisonSociale = raisonSociale;
        this.telephone = telephone;
        this.adresse = adresse;
        nbrFournisseurs++;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Fournisseur f = (Fournisseur) obj;
        return num == f.num && f.raisonSociale.equals(raisonSociale) && f.telephone.equals(telephone) && f.adresse.equals(adresse);
    }

    @Override
    public String toString() {
        return "num=" + num +
                ", raisonSociale='" + raisonSociale + '\'' +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'';
    }
    public static  int getNbrFournisseurs()
    {
        return nbrFournisseurs;
    }
    //destructeur
    public void finalize()
    {
        nbrFournisseurs--;
    }
}
