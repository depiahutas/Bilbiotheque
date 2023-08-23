package frame;

import classeMetier.bibliotheque.*;
import classeMetier.livre.BD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{

    private JPanel formBiblio;
    private JPanel FormEmprunt;
    private JTextField textField1;
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
                JOptionPane.showMessageDialog(null,"recherche");
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
                                TitreCbx.addItem(bd.getTitre());
                                AreaAuteur.setText(bd.getAuteur());
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
                                AreaTitre.setText(roman.getTitre());
                                AreaAuteur.setText(roman.getAuteur());
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


    }

}
