package frame;

import classeMetier.Gestionnaire;
import classeMetier.TypeUtilisateur;
import classeMetier.Utilisateur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Connexion extends JFrame {

    private JPanel Connexion;
    private JButton gestionnaireButton;
    private JButton clientButton;


    public Connexion() {

        /* fenetre de connexion
        // determinant les actions pouvant etre effectué dans la
        // fenetre suivante
        */

        //Création d'un superUser pour test
        Gestionnaire superUser = new Gestionnaire("Toto", "toto", 1, "toto");

        ArrayList<Gestionnaire> listGest = new ArrayList<>();
        listGest.add(superUser);


        //event
        gestionnaireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                JLabel label = new JLabel("Mot de passe :");
                JPasswordField pass = new JPasswordField(20);
                panel.add(label);
                panel.add(pass);
                String[] options = new String[]{"Annuler", "OK"};
                int option = JOptionPane.showOptionDialog(null, panel, "Connexion",
                        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options[1]);
                if (option == 1) // pressing OK button
                {
                    char[] password = pass.getPassword();
                    for (Gestionnaire i : listGest) {
                        if (i.getPassword().equals(new String(password))) {
                            JOptionPane.showMessageDialog(null, i.toString());
                            setVisible(false);
                            Menu m = new Menu();
                        }
                    }
                }
            }
        });
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //affichage de la fenetre
        setContentPane(Connexion);
        setTitle("Welcome");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }


    //main a metre dans le controller
    public static void main(String[] args) {

        frame.Connexion connexion = new Connexion();

    }

}
