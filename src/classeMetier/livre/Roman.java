package classeMetier.livre;

import classeMetier.livre.Livre;

public class Roman extends Livre {

    private int ISBN;
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public Roman(String auteur, String titre, int isbn,Boolean dispo) {
        super(auteur, titre, dispo);
        setISBN(isbn);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
