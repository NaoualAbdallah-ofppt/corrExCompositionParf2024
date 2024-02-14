package aa.bb.correxcompositionparf;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

public class Parfum extends Composition
{
    private String natureEmballage;
    private Date dateLancement;
    private static ArrayList<Parfum> lstParfums;

    public Parfum(String code, String nom, float prixV, String natureEmballage, Date dateLancement)
            throws Exception {
        super(code, nom, prixV);

        this.natureEmballage = natureEmballage;
        this.dateLancement = dateLancement;
    }

    @Override
    public double tva() {
        return 0.2;
    }
    public void addParfum()
    {lstParfums.add(this);
    }
    public int getNombreParfums()
    {
        return lstParfums.size();
    }
public void trierLstProduits()
{
    //Les classer en les copiant dans un treemap
    TreeMap<String,Produit> lstTmp= new TreeMap<>(lstProduits);
    //Les recopier dans la liste des produits
    lstProduits=new HashMap<>(lstTmp);
}

    //implementation 'com.google.code.gson:gson:2.8.8'
    //dans gradle
public static  void serialiser()
{
//convertir ma chaine en données JSON
    Gson gson = new Gson();
    String maChaine = gson.toJson(lstParfums);
    // Écrire le JSON dans un fichier
    try
    {
        FileWriter writer = new FileWriter("file.json");
        writer.write(maChaine);
       writer.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


public static void deserialiser () throws IOException {

        // Lire le contenu du fichier JSON dans une chaîne
        byte[] bytes = Files.readAllBytes(Paths.get("file.json"));

        // Convertir les bytes en une chaîne de caractères
        String maChaine = new String(bytes);

        // Désérialiser la chaîne JSON en ArrayList<T>
        Gson gson = new Gson();
    Type type = new TypeToken<ArrayList<Produit>>(){}.getType();
        lstParfums=  gson.fromJson(maChaine,type);



    }

}


