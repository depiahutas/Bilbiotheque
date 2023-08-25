package frame;

import classeMetier.bibliotheque.*;
import classeMetier.livre.BD;
import classeMetier.livre.Livre;
import classeMetier.livre.Roman;
import classeMetier.personne.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static classeMetier.util.Input.VerifMail;
import static classeMetier.util.Input.VerifStringNoInt;

public class Menu extends JFrame{

    private JPanel formBiblio;
    private JPanel FormEmprunt;
    private JTextField AreaNom;
    private JComboBox Typecbx;
    private JLabel typeLivre;
    private JComboBox TitreCbx;
    private JTextField AreaTitre;
    private JPanel FormRendu;
    private JTextField AreaAuteur;
    private JLabel LabelAuteur;
    private JLabel LabelTitre;
    private JTextField AreaISBN;
    private JButton BtnValider;
    private JLabel ErreurTitre;
    private JTextField AreaPrenom;
    private JTextField AreaMail;
    private JLabel ErreurNom;
    private JLabel ErreurPrenom;
    private JLabel ErreurMail;
    private JLabel ErreurDispo;
    private JPanel FormRecherche;
    private JPanel FormAjout;
    private JPanel FormListEmprunt;
    private JTable TableLivre;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JPanel panelTest;

    Menu(){
        setContentPane(formBiblio);




        //Creation du menu
        JMenuBar mbar = new JMenuBar();
        JMenu m1 = new JMenu("Gestion");


        JMenuItem empruntbtn = new JMenuItem("Emprunt");
        JMenuItem rendubtn = new JMenuItem("Rendu");
        JMenuItem listbtn = new JMenuItem("Liste emprunt");

        JMenu m2 = new JMenu("Livre");

        JMenuItem recherchebtn = new JMenuItem("recherche");
        JMenuItem ajoutbtn = new JMenuItem("ajout");

        m1.add(empruntbtn);
        m1.add(rendubtn);
        m1.add(listbtn);
        m2.add(recherchebtn);
        m2.add(ajoutbtn);

        mbar.add(m1);
        mbar.add(m2);



        //event

        //affichage du panel Emprunt
        // permet de créer un nouvel emprunt pour un livre disponible
        empruntbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(FormEmprunt);
                setSize(new Dimension(700,350));
                FormEmprunt.setVisible(true);
                Typecbx.setSelectedIndex(0);
                AreaAuteur.setText("");
                AreaTitre.setText("");
                AreaISBN.setText("");
                ErreurNom.setVisible(false);
                ErreurPrenom.setVisible(false);
                ErreurMail.setVisible(false);
                ErreurTitre.setVisible(false);
            }
        });

        rendubtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(FormRendu);
            }
        });

        listbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Affichage de tous les emprunts");
            }
        });

        recherchebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setContentPane(FormRecherche);


                DefaultTableModel model = new DefaultTableModel();


                model.addColumn("Auteur");
                model.addColumn("Titre");
                model.addColumn("Collection/ISBN");
                model.addColumn("Dispo");

                TableLivre.setModel(model);

                DefaultTableModel model1=(DefaultTableModel) TableLivre.getModel();
                model1.addRow(new Object[]{"Auteur","Titre","Collection/ISBN","Disponibilité"});
                for (BD bd : Bibliotheque.getListBD()) {
                    model1.addRow(new Object[]{bd.getAuteur(), bd.getTitre(), bd.getCollection(), bd.getDispo()});
                }

                for (Roman roman: Bibliotheque.getListRoman()){
                    model1.addRow(new Object[]{roman.getAuteur(),roman.getTitre(),roman.getISBN(),roman.getDispo()});
                }

                TableLivre.getColumnModel().getColumn(0).setPreferredWidth(130);
                TableLivre.getColumnModel().getColumn(1).setPreferredWidth(500);
                TableLivre.getColumnModel().getColumn(2).setPreferredWidth(175);
                TableLivre.getColumnModel().getColumn(3).setPreferredWidth(100);
                TableLivre.setVisible(true);
                TableLivre.setPreferredSize(new Dimension(500,300));
                FormRecherche.add(TableLivre);
            }
        });

        ajoutbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"ajout");
            }
        });

        //changement du label ISBN/Collection en fonction de l'élément choisit
        Typecbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

        //si le livre est un roman alors demande le numéro ISBN du livre
        //une fois ISBN rempli affiche les informations du roman (rendu impossible a editer)
        if (Typecbx.getSelectedItem().equals("Roman")){
            typeLivre.setText("ISBN:");
            AreaISBN.setText("");
            AreaTitre.setEditable(false);
            TitreCbx.setVisible(false);
            AreaAuteur.setEditable(false);
            AreaTitre.setVisible(true);
        }
        //si le livre est une BD alors affiche la liste complete des BD dans la bibliotheque
        else {
            typeLivre.setText("Collection:");
            AreaTitre.setText("");
            AreaISBN.setText("");
            AreaAuteur.setText("");
            TitreCbx.removeAllItems();
            for(BD bd: Bibliotheque.getListBD()){
                TitreCbx.addItem(bd.getTitre());
            }
            TitreCbx.setSelectedIndex(-1);
            LabelTitre.setVisible(true);
            TitreCbx.setVisible(true);
            AreaTitre.setVisible(false);
        }
            }
        });

        //n'affiche que les BD de la collection souhaité
        AreaISBN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!AreaISBN.getText().equals(null)){

                    if(AreaISBN.getText().isEmpty()) {
                            AreaAuteur.setText("");
                            TitreCbx.removeAllItems();
                            ErreurTitre.setVisible(false);
                        for (BD bd : Bibliotheque.getListBD()) {
                            TitreCbx.addItem(bd.getTitre());
                        }
                        TitreCbx.setSelectedIndex(-1);
                    }
                    else if(Typecbx.getSelectedItem().equals("BD")) {
                        TitreCbx.removeAllItems();
                        ErreurTitre.setVisible(false);
                        for (BD bd : Bibliotheque.getListBD()) {
                            if (bd.getCollection().equalsIgnoreCase(AreaISBN.getText())) {
                                if (bd.getDispo()) {
                                    TitreCbx.addItem(bd.getTitre());
                                    ErreurDispo.setVisible(false);
                                }
                                else {
                                    ErreurDispo.setText("Indisponible");
                                    ErreurDispo.setVisible(true);
                                }
                            }
                            TitreCbx.setSelectedIndex(-1);
                        }
                        if(TitreCbx.getItemCount()<1){
                            ErreurTitre.setText("Aucune BD trouvé");
                            ErreurTitre.setVisible(true);
                            ErreurTitre.setForeground(Color.RED);
                        }

                    } else if (Typecbx.getSelectedItem().equals("Roman")) {
                        for (Roman roman: Bibliotheque.getListRoman()){
                            if (roman.getISBN()==Integer.parseInt(AreaISBN.getText())){
                                if (roman.getDispo()){
                                AreaTitre.setText(roman.getTitre());
                                AreaAuteur.setText(roman.getAuteur());
                                ErreurDispo.setVisible(false);
                                }
                                else {
                                    ErreurDispo.setText("Indisponible");
                                    ErreurDispo.setVisible(true);
                                }
                            }
                        }
                        if(AreaTitre.getText().isEmpty()){
                            ErreurTitre.setText("Pas de roman trouvé");
                            ErreurTitre.setVisible(true);
                            ErreurTitre.setForeground(Color.RED);
                        }
                        else{
                            ErreurTitre.setVisible(false);
                        }
                    }
                }

            }
        });


        //affichage de la fenetre
        setJMenuBar(mbar);
        setSize(700,350);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        BtnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     try{
                         //Verification client dans "BDD"/liste des clients
                         Client client=null;
                         Livre livre =null;
                         boolean add=true;

                         if (!VerifStringNoInt(AreaNom.getText()) || AreaNom.getText().isEmpty()) {
                             ErreurNom.setVisible(true);
                         } else if (!VerifStringNoInt(AreaPrenom.getText()) || AreaPrenom.getText().isEmpty()) {

                             ErreurNom.setVisible(false);
                             ErreurPrenom.setVisible(true);
                         } else if (!VerifMail(AreaMail.getText()) || AreaMail.getText().isEmpty()){

                             ErreurPrenom.setVisible(false);
                             ErreurMail.setVisible(true);
                         }
                         else {
                             ErreurPrenom.setVisible(false);
                             ErreurNom.setVisible(false);
                             ErreurMail.setVisible(false);
                             System.out.println(VerifMail(AreaMail.getText()));

                             for (Client c : Bibliotheque.getListClient()) {
                                 if (c.getNom().equals(AreaNom.getText()) && c.getPrenom().equals(AreaPrenom.getText()) && c.getMail().equals(AreaMail.getText())) {
                                     add = false;
                                     client = c;
                                 }
                             }
                             if (add) {
                                 client = new Client(AreaNom.getText(), AreaPrenom.getText(), AreaMail.getText());
                                 Bibliotheque.getListClient().add(client);
                             }

                             if (Typecbx.getSelectedItem().equals("BD")) {
                                 for (BD l : Bibliotheque.getListBD()) {
                                     if (l.getAuteur().equals(AreaAuteur.getText()) && l.getTitre().equals(TitreCbx.getSelectedItem())) {
                                         livre = l;
                                         l.setDispo(false);
                                     }
                                 }
                             } else if (Typecbx.getSelectedItem().equals("Roman")) {
                                    for (Roman r:Bibliotheque.getListRoman()){
                                        if (r.getISBN()==Integer.parseInt(AreaISBN.getText())){
                                            livre=r;
                                            livre.setDispo(false);
                                        }
                                    }
                             }

                             //Ajout de l'emprunt dans la "BDD"/liste d'emprunt
                             Bibliotheque.getListEmprunt().add(new Emprunt(client, livre));

                         }
                     }catch (Exception ignored){

                     }
                 }

        });

        TitreCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(BD bd: Bibliotheque.getListBD()){
                    if (bd.getTitre().equals(TitreCbx.getSelectedItem())){
                        AreaAuteur.setText(bd.getAuteur());
                    }
                }
            }
        });


    }

}
