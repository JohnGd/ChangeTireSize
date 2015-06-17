package impl;

import ihm.IhmChoixFacteur;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.pmr.interfaces.IAction;
import org.pmr.interfaces.IComposantGraphique;

/**
 * @author John G
 *
 */
public class ImplChangeTireSize implements IAction {

    /**
     * Le facteur de multiplication renvoyé par l'IHM
     */
    private Integer changeFactor;

    /**
     * L'IHM
     */
    private IhmChoixFacteur frame;

    /**
     * Initialise le facteur de multiplication à partir de l'IHM
     */
    private void setFactor() {
	try {
	    // Lance l'IHM
	    EventQueue.invokeAndWait(new Runnable() {

		public void run() {
		    frame = new IhmChoixFacteur();
		    frame.setVisible(true);
		}
	    });
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	changeFactor = frame.getFactor();
	System.out.println(changeFactor);
    }

    public String getNom() {
	// TODO Auto-generated method stub
	return null;
    }

    public void setNom(String nom) {
	// TODO Auto-generated method stub
    }

    public String getDescription() {
	// TODO Auto-generated method stub
	return null;
    }

    public void setDescription(String description) {
	// TODO Auto-generated method stub
    }

    public String getIDAction() {
	// TODO Auto-generated method stub
	return null;
    }

    public void performAction(IComposantGraphique victime) {
	setFactor();
	double rayonActuel = victime.getRayon();
	double newRayon = rayonActuel * changeFactor;
	victime.setRayon(newRayon);
    }

    public List<Class<?>> getTargets() {
	// TODO Auto-generated method stub
	return null;
    }
}
