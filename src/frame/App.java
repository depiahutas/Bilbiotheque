package frame;

import classeMetier.TypeUtilisateur;
import classeMetier.Utilisateur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{

    private JPanel Connexion;
    private JButton gestionnaireButton;
    private JButton clientButton;



    public App() {


        gestionnaireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String j=JOptionPane.showInputDialog("Mot de passe :");
                if (j.equals("toto")) {
                    Utilisateur user = new Utilisateur("Toto", "toto", "toto@mail.fr", TypeUtilisateur.Gestionnaire);
                    JOptionPane.showMessageDialog(null, user.toString());
                }
                else{
                    JOptionPane.showMessageDialog(null,"mot de passe incorrect");
                }
            }
        });
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setContentPane(Connexion);
        setTitle("Welcome");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

        public static void main(String[] args){

        App app = new App();

        }

}
