package classeMetier.personne;

public class Client extends Utilisateur {

    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Client(String nom, String prenom, String mail) {
        super(nom, prenom, TypeUtilisateur.Client);
        setMail(mail);
    }
}
