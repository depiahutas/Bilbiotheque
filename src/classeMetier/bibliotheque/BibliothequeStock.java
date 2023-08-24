package classeMetier.bibliotheque;

import classeMetier.livre.*;

import java.util.ArrayList;

public class BibliothequeStock {
    private static ArrayList<Livre> listLivre = new ArrayList<Livre>();
    private static ArrayList<BD> listBD = new ArrayList<BD>();
    private static ArrayList<Roman> listRoman = new ArrayList<Roman>();

    public ArrayList<Livre> getListLivre() {
        return listLivre;
    }

    public  ArrayList<BD> getListBD() {
        return listBD;
    }

    public ArrayList<Roman> getListRoman() {
        return listRoman;
    }

    static Roman roman1 = new Roman("Agatha Christie", "Le crime de l'orient-Express", 1,true);
    static Roman roman2 = new Roman("Stephen King", "Shining", 2,true);
    static Roman roman3 = new Roman("Jules Verne", "Voyage au centre de la terre", 3,true);
    static Roman roman4 = new Roman("Andrzej Sapkowski", "The witcher", 4,true);
    static Roman roman5 = new Roman("Barbey d'Aurevilly", "Les Diaboliques", 5,true);

    static BD bd1=new BD("Patrick Sobral","Tome 1 : La pierre de Jovénia ","Les légendaires",true);
    static BD bd2=new BD("Jean-Claude Fournier","Tome 1 : Quatre aventures de Spirou et Fantasio","Spirou et Fantasio",true);
    static BD bd3=new BD("René Goscinny","Tome 1 : Astérix le Gaulois","Astérix",true);
    static BD bd4=new BD("Zep","Tome 1 : Dieu, le sexe et les bretelles","Titeuf",true);


    public BibliothequeStock() {
        listRoman.add(roman1);
        listRoman.add(roman2);
        listRoman.add(roman3);
        listRoman.add(roman4);
        listRoman.add(roman5);

        listBD.add(bd1);
        listBD.add(bd2);
        listBD.add(bd3);
        listBD.add(bd4);

        listBD.sort(BD.livreTitreComparator);

        listRoman.sort(Roman.livreTitreComparator);

        listLivre.addAll(listBD);
        listLivre.addAll(listRoman);
    }
}
