package classeMetier.livre;

import java.util.Comparator;

public class BD extends Livre{
    private String collection;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public BD(String auteur, String titre,String collection,Boolean dispo) {
        super(auteur, titre,dispo);
        this.setCollection(collection);
    }



}
