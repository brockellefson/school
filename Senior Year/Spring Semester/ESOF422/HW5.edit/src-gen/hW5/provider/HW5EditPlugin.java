/**
 */
package hW5.provider;
import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import hW5.Customer;
import hW5.Movie;
import hW5.PriceCode;
import hW5.Rental;
import hW5.impl.CustomerImpl;
import hW5.impl.MovieImpl;
import hW5.impl.RentalImpl;

/**
 * This is the central singleton for the HW5 edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class HW5EditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final HW5EditPlugin INSTANCE = new HW5EditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HW5EditPlugin() {
		super(new ResourceLocator[] {});
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
		
	
	}
	
	public static void main(String[] args) {
		Movie bladeRunner =	 new MovieImpl(); 
		bladeRunner.setTitle("Blade Runner");
		bladeRunner.setPriceCode(PriceCode.REGULAR);
		
		Movie saw =	 new MovieImpl(); 
		saw.setTitle("SAW");
		saw.setPriceCode(PriceCode.FAMILY);
		
		Movie blackpanther = new MovieImpl(); 
		blackpanther.setTitle("Black Panther");
		blackpanther.setPriceCode(PriceCode.NEW_RELEASE);
		
		Customer brock = new CustomerImpl();
		brock.setName("Brock");
		Rental brockrental = new RentalImpl();
		brockrental.setMovieRental(bladeRunner);
		brockrental.setDaysRented(5);
		
		brock.addRental(brockrental);
		
		brock.statement();
		
		Customer liz = new CustomerImpl();
		liz.setName("liz");
		Rental lizrental = new RentalImpl();
		lizrental.setMovieRental(saw);
		lizrental.setDaysRented(1);
		
		liz.addRental(brockrental);
		liz.addRental(lizrental);

		Rental lizrentalthesequel = new RentalImpl();
		lizrentalthesequel.setMovieRental(blackpanther);
		lizrentalthesequel.setDaysRented(10);
		
		liz.addRental(lizrentalthesequel);
		
		liz.statement();
		
		
	}

}
