package classeMetier.bibliotheque;

import classeMetier.livre.Livre;

public class Roman extends Livre {

    private int ISBN;
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public Roman(String auteur, String titre, int isbn) {
        super(auteur, titre);
        setISBN(isbn);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
