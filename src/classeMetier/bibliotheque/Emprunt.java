package classeMetier.bibliotheque;

import classeMetier.livre.Livre;
import classeMetier.personne.Client;

public class Emprunt {
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    private Client client;
    private Livre livre;
    public Emprunt(Client client, Livre livre) {
        this.client = client;
        setLivre(livre);
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "client=" + client +
                ", livre=" + livre +
                '}';
    }
}

