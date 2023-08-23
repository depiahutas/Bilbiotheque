package classeMetier.bibliotheque;

import classeMetier.livre.*;

import java.util.ArrayList;

public class Bibliotheque {
    public static ArrayList<Livre> listLivre = new ArrayList<Livre>();
    public static BibliothequeStock stock = new BibliothequeStock();


    private static ArrayList<BD> listBD = new ArrayList<BD>(stock.getListBD());
    private static ArrayList<Roman> listRoman = new ArrayList<Roman>(stock.getListRoman());
    //private static ArrayList<Emprunt> listEmprunt = new ArrayList<Emprunt>();

    public static ArrayList<BD> getListBD() {
        return listBD;
    }

    public static ArrayList<Roman> getListRoman() {
        return listRoman;
    }
}
