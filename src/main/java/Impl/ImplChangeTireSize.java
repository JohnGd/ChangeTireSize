package Impl;

import ihm.CustomFrame;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import Itf.ItfChangeTireSize;

/**
 * @author John G
 *
 */
/**
 * @author John G
 *
 */
/**
 * @author John G
 *
 */
/**
 * @author John G
 *
 */
public class ImplChangeTireSize implements ItfChangeTireSize {

    /**
     * Le facteur de multiplication renvoyé par l'IHM
     */
    private Integer changeFactor;

    /**
     * L'IHM
     */
    private CustomFrame frame;

    /**
     * Initialise le facteur de multiplication à partir de l'IHM
     */
    private void setFactor() {
	try {
	    // Lance l'IHM
	    EventQueue.invokeAndWait(new Runnable() {

		public void run() {
		    frame = new CustomFrame();
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

    /*
     * (non-Javadoc)
     * @see Itf.ItfChangeTireSize#changeTireSize(java.lang.Double)
     */
    public Double changeTireSize(Double tireSize) {
	setFactor();
	return tireSize * changeFactor.intValue();
    }
}
