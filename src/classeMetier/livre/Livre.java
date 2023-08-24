package classeMetier.livre;

import java.util.Comparator;

public abstract class Livre {

    private String auteur;
    private String titre;
    private Boolean dispo;

    public Livre(String auteur, String titre,Boolean dispo) {
        this.auteur = auteur;
        this.titre = titre;
        this.dispo=dispo;
    }

    public  String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Boolean getDispo() {
        return dispo;
    }

    public void setDispo(Boolean dispo) {
        this.dispo = dispo;
    }

    public static Comparator<Livre> livreTitreComparator = new Comparator<Livre>() {
        @Override
        public int compare(Livre o1,Livre o2) {
            String o1Titre = o1.getTitre().toUpperCase();
            String o2Titre = o2.getTitre().toUpperCase();
            return o1Titre.compareTo(o2Titre);
        }
    };
}
