package classeMetier;

public class Gestionnaire extends Utilisateur{


    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    private int matricule;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    public Gestionnaire(String nom, String prenom,int mat,String pwd) {
        super(nom, prenom, TypeUtilisateur.Gestionnaire);
        setMatricule(mat);
        setPassword(pwd);
    }
}
