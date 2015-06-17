package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 * @author John G
 *
 */
public class IhmChoixFacteur extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = -8158475165418086687L;

    /**
     * Le fenetre "conteneur" de l'IHM
     */
    private JDialog window;

    /**
     * Spinner numérique pour choisir le facteur
     */
    private JSpinner spinnerFacteur;

    /**
     * Label du champ numérique
     */
    private JLabel labelChampIn;

    /**
     * Panel contenant le label
     */
    private JPanel panelLabel;

    /**
     * Panel contenant le champ numérique
     */
    private JPanel panelFacteur;

    /**
     * Bouton de validation
     */
    private JButton button;

    /**
     * Le facteur de multiplication de la taille des roues
     */
    private double facteur;

    /**
     * Constructeur
     */
    public IhmChoixFacteur() {
	facteur = new Integer(0);
	// Création du conteneur principal
	initConteneur();
	// Initialisation du panel contenant les objets graphiques
	initLabel();
	// Initialisation du champ numérique
	initSpinner();
	// Initialisation du bouton
	initButton();
	// Affichage de la fenetre
	window.pack();
    }

    /**
     * Initialise le conteneur
     */
    private void initConteneur() {
	window = new JDialog();
	window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	window.setSize(225, 140);
	// permet de "freezer" le programme tant que la fenêtre est ouverte
	window.setModal(true);
    }

    /**
     * Initialise le JLabel de l'IHM
     */
    private void initLabel() {
	// JPanel du Label
	panelLabel = new JPanel();
	panelLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	// JLabel du champ d'entrée
	labelChampIn = new JLabel(
	        "Entrez un facteur de modification");
	labelChampIn.setHorizontalAlignment(SwingConstants.CENTER);
	panelLabel.add(labelChampIn);
	// Ajout du JPanel de la mesure d'entrée au conteneur principal
	window.getContentPane().add(panelLabel, BorderLayout.NORTH);
    }

    /**
     * Initialise le JSpinner
     */
    private void initSpinner() {
	double min = 0.5;
	double value = 0.5;
	double max = 5.0;
	double stepSize = 0.1;
	spinnerFacteur = new JSpinner(new SpinnerNumberModel(value, min, max, stepSize));
	// Disable keyboard edits in the spinner
	JFormattedTextField tf = ((JSpinner.DefaultEditor) spinnerFacteur.getEditor()).getTextField();
	tf.setEditable(false);
	tf.setBackground(Color.white);
	// Double Format
	JSpinner.NumberEditor editor = (JSpinner.NumberEditor) spinnerFacteur.getEditor();
	DecimalFormat format = editor.getFormat();
	format.setMinimumFractionDigits(1);
	// JPanel
	panelFacteur = new JPanel();
	panelFacteur.setLayout(new FlowLayout(FlowLayout.CENTER));
	// Ajout du champ
	panelFacteur.add(spinnerFacteur);
	// Ajout au conteneur
	window.getContentPane().add(panelFacteur, BorderLayout.CENTER);
    }

    /**
     * Initialise le bouton de l'IHM
     */
    private void initButton() {
	// Creation du bouton
	button = new JButton("Valider");
	// Définition des actions
	button.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
		facteur = (Double) spinnerFacteur.getValue();
		window.dispose();
	    }
	});
	// Ajout au conteneur
	window.getContentPane().add(button, BorderLayout.SOUTH);
    }

    /**
     * @return le facteur choisi dans l'IHM
     */
    public double getFactor() {
	return facteur;
    }

    /**
     * Rend l'IHM visible
     */
    @Override
    public void setVisible(boolean b) {
	window.setVisible(b);
    }
}
