import Impl.ImplChangeTireSize;
import Itf.ItfChangeTireSize;

public class Principale {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ItfChangeTireSize tireSizeChanger = new ImplChangeTireSize();
	System.out.println("changement de la taille des roues");
	System.out.println("en entrée : 2");
	System.out.println("multiplié par 0.5");
	System.out.println(tireSizeChanger.changeTireSize(2.0));
	/**
	 * Lancement de l'application
	 */
    }
}
