package impl;

import ihm.IhmChoixFacteur;
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
    private double changeFactor;

    /**
     * L'IHM
     */
    private IhmChoixFacteur frame;

    /**
     * Le nom de l'action
     */
    private String nom;

    /**
     * La description de l'action
     */
    private String description;

    /**
     * L'identifiant de l'action
     */
    private String actionId;

    /**
     * La classe ciblée par la modification du plugin
     */
    private String targetedClass;

    /*
     * (non-Javadoc)
     * @see org.pmr.interfaces.IAction#getNom()
     */
    @Override
    public String getNom() {
	return this.nom;
    }

    /*
     * (non-Javadoc)
     * @see org.pmr.interfaces.IAction#setNom(java.lang.String)
     */
    @Override
    public void setNom(String nom) {
	this.nom = nom;
    }

    /*
     * (non-Javadoc)
     * @see org.pmr.interfaces.IAction#getDescription()
     */
    @Override
    public String getDescription() {
	return this.description;
    }

    /*
     * (non-Javadoc)
     * @see org.pmr.interfaces.IAction#setDescription(java.lang.String)
     */
    @Override
    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * (non-Javadoc)
     * @see org.pmr.interfaces.IAction#getIDAction()
     */
    @Override
    public String getIDAction() {
	return this.actionId;
    }

    /*
     * (non-Javadoc)
     * @see org.pmr.interfaces.IAction#performAction(org.pmr.interfaces.IComposantGraphique)
     */
    @Override
    public void performAction(IComposantGraphique victime) {
	frame = new IhmChoixFacteur();
	frame.setVisible(true);
	changeFactor = frame.getFactor();
	double rayonActuel = victime.getRayon();
	double newRayon = rayonActuel * changeFactor;
	victime.setRayon(newRayon);
    }

    /*
     * (non-Javadoc)
     * @see org.pmr.interfaces.IAction#setIDAction(java.lang.String)
     */
    @Override
    public void setIDAction(String idAction) {
	this.actionId = idAction;
    }

    /*
     * (non-Javadoc)
     * @see org.pmr.interfaces.IAction#getTargetedComponent()
     */
    @Override
    public String getTargetedComponent() {
	return this.targetedClass;
    }

    /*
     * (non-Javadoc)
     * @see org.pmr.interfaces.IAction#setTargetedComponent(java.lang.Class)
     */
    @Override
    public void setTargetedComponent(String clazz) {
	this.targetedClass = clazz;
    }
}
