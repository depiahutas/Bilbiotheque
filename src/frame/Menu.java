package frame;

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

    Menu(){
        setContentPane(formBiblio);




        //Creation du menu
        JMenuBar mbar = new JMenuBar();
        JMenu m1 = new JMenu("Gestion");


        JMenuItem e1 = new JMenuItem("Emprunt");
        JMenuItem e2 = new JMenuItem("Rendu");
        JMenuItem e3 = new JMenuItem("Liste emprunt");

        JMenu m2 = new JMenu("Livre");

        JMenuItem e4 = new JMenuItem("recherche");
        JMenuItem e5 = new JMenuItem("ajout");

        m1.add(e1);
        m1.add(e2);
        m1.add(e3);
        m2.add(e4);
        m2.add(e5);

        mbar.add(m1);
        mbar.add(m2);

        //event

        e1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(FormEmprunt);
                setSize(new Dimension(500,300));
                FormEmprunt.setVisible(true);
            }
        });

        e2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Rendu");
            }
        });

        e3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Affichage de tous les emprunts");
            }
        });

        e4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"recherche");
            }
        });

        e5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"ajout");
            }
        });

        //changement du label ISBN/Collection en fonction de l'élément choisit
        Typecbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

        if (Typecbx.getSelectedItem().equals("Roman")){
            typeLivre.setText("ISBN:");
            AreaTitre.setVisible(true);
            TitreCbx.setVisible(false);
        }
        else {
            typeLivre.setText("Collection:");
//            for(BD bd:listBD){
//                TitreCbx.addItem(bd.getTitre());
//            }
            TitreCbx.setVisible(true);
            AreaTitre.setVisible(false);
        }
            }
        });


        //affichage de la fenetre
        setJMenuBar(mbar);
        setSize(300,300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

}
