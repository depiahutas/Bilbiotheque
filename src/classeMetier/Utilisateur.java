package classeMetier;

public abstract class Utilisateur {
    private String nom;
    private String prenom;
    private TypeUtilisateur typeUtilisateur;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public TypeUtilisateur getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Utilisateur(String nom, String prenom, TypeUtilisateur typeUtilisateur) {
        this.nom = nom;
        this.prenom = prenom;
        this.typeUtilisateur = typeUtilisateur;
    }

    @Override
    public String toString() {
        return "Utilisateur: " +
                "nom: " + nom +
                ", prenom: " + prenom +
                ", " + typeUtilisateur
                ;
    }
}
