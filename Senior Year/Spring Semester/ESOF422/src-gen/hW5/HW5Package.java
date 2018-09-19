/**
 */
package hW5;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hW5.HW5Factory
 * @model kind="package"
 * @generated
 */
public interface HW5Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "hW5";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/hW5";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hW5";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HW5Package eINSTANCE = hW5.impl.HW5PackageImpl.init();

	/**
	 * The meta object id for the '{@link hW5.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hW5.impl.CustomerImpl
	 * @see hW5.impl.HW5PackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Num Ren</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__NUM_REN = 1;

	/**
	 * The feature id for the '<em><b>Total Charges</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__TOTAL_CHARGES = 2;

	/**
	 * The feature id for the '<em><b>Rental</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__RENTAL = 3;

	/**
	 * The feature id for the '<em><b>Charge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__CHARGE = 4;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Add Rental</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER___ADD_RENTAL__RENTAL = 0;

	/**
	 * The operation id for the '<em>Statement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER___STATEMENT = 1;

	/**
	 * The number of operations of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link hW5.impl.RentalImpl <em>Rental</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hW5.impl.RentalImpl
	 * @see hW5.impl.HW5PackageImpl#getRental()
	 * @generated
	 */
	int RENTAL = 1;

	/**
	 * The feature id for the '<em><b>Days Rented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENTAL__DAYS_RENTED = 0;

	/**
	 * The feature id for the '<em><b>Movie Rental</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENTAL__MOVIE_RENTAL = 1;

	/**
	 * The number of structural features of the '<em>Rental</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENTAL_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Charge</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENTAL___GET_CHARGE = 0;

	/**
	 * The number of operations of the '<em>Rental</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENTAL_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link hW5.impl.MovieImpl <em>Movie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hW5.impl.MovieImpl
	 * @see hW5.impl.HW5PackageImpl#getMovie()
	 * @generated
	 */
	int MOVIE = 2;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Price Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__PRICE_CODE = 1;

	/**
	 * The number of structural features of the '<em>Movie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Movie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hW5.impl.ChargeImpl <em>Charge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hW5.impl.ChargeImpl
	 * @see hW5.impl.HW5PackageImpl#getCharge()
	 * @generated
	 */
	int CHARGE = 3;

	/**
	 * The feature id for the '<em><b>Ch Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARGE__CH_VAL = 0;

	/**
	 * The feature id for the '<em><b>Ch T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARGE__CH_T = 1;

	/**
	 * The number of structural features of the '<em>Charge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARGE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Charge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hW5.PriceCode <em>Price Code</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hW5.PriceCode
	 * @see hW5.impl.HW5PackageImpl#getPriceCode()
	 * @generated
	 */
	int PRICE_CODE = 4;

	/**
	 * Returns the meta object for class '{@link hW5.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see hW5.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the attribute '{@link hW5.Customer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hW5.Customer#getName()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Name();

	/**
	 * Returns the meta object for the attribute '{@link hW5.Customer#getNumRen <em>Num Ren</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Ren</em>'.
	 * @see hW5.Customer#getNumRen()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_NumRen();

	/**
	 * Returns the meta object for the attribute '{@link hW5.Customer#getTotalCharges <em>Total Charges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Charges</em>'.
	 * @see hW5.Customer#getTotalCharges()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_TotalCharges();

	/**
	 * Returns the meta object for the reference list '{@link hW5.Customer#getRental <em>Rental</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rental</em>'.
	 * @see hW5.Customer#getRental()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Rental();

	/**
	 * Returns the meta object for the reference list '{@link hW5.Customer#getCharge <em>Charge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Charge</em>'.
	 * @see hW5.Customer#getCharge()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Charge();

	/**
	 * Returns the meta object for the '{@link hW5.Customer#addRental(hW5.Rental) <em>Add Rental</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Rental</em>' operation.
	 * @see hW5.Customer#addRental(hW5.Rental)
	 * @generated
	 */
	EOperation getCustomer__AddRental__Rental();

	/**
	 * Returns the meta object for the '{@link hW5.Customer#statement() <em>Statement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Statement</em>' operation.
	 * @see hW5.Customer#statement()
	 * @generated
	 */
	EOperation getCustomer__Statement();

	/**
	 * Returns the meta object for class '{@link hW5.Rental <em>Rental</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rental</em>'.
	 * @see hW5.Rental
	 * @generated
	 */
	EClass getRental();

	/**
	 * Returns the meta object for the attribute '{@link hW5.Rental#getDaysRented <em>Days Rented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Days Rented</em>'.
	 * @see hW5.Rental#getDaysRented()
	 * @see #getRental()
	 * @generated
	 */
	EAttribute getRental_DaysRented();

	/**
	 * Returns the meta object for the reference '{@link hW5.Rental#getMovieRental <em>Movie Rental</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Movie Rental</em>'.
	 * @see hW5.Rental#getMovieRental()
	 * @see #getRental()
	 * @generated
	 */
	EReference getRental_MovieRental();

	/**
	 * Returns the meta object for the '{@link hW5.Rental#getCharge() <em>Get Charge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Charge</em>' operation.
	 * @see hW5.Rental#getCharge()
	 * @generated
	 */
	EOperation getRental__GetCharge();

	/**
	 * Returns the meta object for class '{@link hW5.Movie <em>Movie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Movie</em>'.
	 * @see hW5.Movie
	 * @generated
	 */
	EClass getMovie();

	/**
	 * Returns the meta object for the attribute '{@link hW5.Movie#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see hW5.Movie#getTitle()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Title();

	/**
	 * Returns the meta object for the attribute '{@link hW5.Movie#getPriceCode <em>Price Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Price Code</em>'.
	 * @see hW5.Movie#getPriceCode()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_PriceCode();

	/**
	 * Returns the meta object for class '{@link hW5.Charge <em>Charge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Charge</em>'.
	 * @see hW5.Charge
	 * @generated
	 */
	EClass getCharge();

	/**
	 * Returns the meta object for the attribute '{@link hW5.Charge#getChVal <em>Ch Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ch Val</em>'.
	 * @see hW5.Charge#getChVal()
	 * @see #getCharge()
	 * @generated
	 */
	EAttribute getCharge_ChVal();

	/**
	 * Returns the meta object for the attribute '{@link hW5.Charge#getChT <em>Ch T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ch T</em>'.
	 * @see hW5.Charge#getChT()
	 * @see #getCharge()
	 * @generated
	 */
	EAttribute getCharge_ChT();

	/**
	 * Returns the meta object for enum '{@link hW5.PriceCode <em>Price Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Price Code</em>'.
	 * @see hW5.PriceCode
	 * @generated
	 */
	EEnum getPriceCode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HW5Factory getHW5Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hW5.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hW5.impl.CustomerImpl
		 * @see hW5.impl.HW5PackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__NAME = eINSTANCE.getCustomer_Name();

		/**
		 * The meta object literal for the '<em><b>Num Ren</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__NUM_REN = eINSTANCE.getCustomer_NumRen();

		/**
		 * The meta object literal for the '<em><b>Total Charges</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__TOTAL_CHARGES = eINSTANCE.getCustomer_TotalCharges();

		/**
		 * The meta object literal for the '<em><b>Rental</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER__RENTAL = eINSTANCE.getCustomer_Rental();

		/**
		 * The meta object literal for the '<em><b>Charge</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER__CHARGE = eINSTANCE.getCustomer_Charge();

		/**
		 * The meta object literal for the '<em><b>Add Rental</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CUSTOMER___ADD_RENTAL__RENTAL = eINSTANCE.getCustomer__AddRental__Rental();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CUSTOMER___STATEMENT = eINSTANCE.getCustomer__Statement();

		/**
		 * The meta object literal for the '{@link hW5.impl.RentalImpl <em>Rental</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hW5.impl.RentalImpl
		 * @see hW5.impl.HW5PackageImpl#getRental()
		 * @generated
		 */
		EClass RENTAL = eINSTANCE.getRental();

		/**
		 * The meta object literal for the '<em><b>Days Rented</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RENTAL__DAYS_RENTED = eINSTANCE.getRental_DaysRented();

		/**
		 * The meta object literal for the '<em><b>Movie Rental</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENTAL__MOVIE_RENTAL = eINSTANCE.getRental_MovieRental();

		/**
		 * The meta object literal for the '<em><b>Get Charge</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RENTAL___GET_CHARGE = eINSTANCE.getRental__GetCharge();

		/**
		 * The meta object literal for the '{@link hW5.impl.MovieImpl <em>Movie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hW5.impl.MovieImpl
		 * @see hW5.impl.HW5PackageImpl#getMovie()
		 * @generated
		 */
		EClass MOVIE = eINSTANCE.getMovie();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__TITLE = eINSTANCE.getMovie_Title();

		/**
		 * The meta object literal for the '<em><b>Price Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__PRICE_CODE = eINSTANCE.getMovie_PriceCode();

		/**
		 * The meta object literal for the '{@link hW5.impl.ChargeImpl <em>Charge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hW5.impl.ChargeImpl
		 * @see hW5.impl.HW5PackageImpl#getCharge()
		 * @generated
		 */
		EClass CHARGE = eINSTANCE.getCharge();

		/**
		 * The meta object literal for the '<em><b>Ch Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHARGE__CH_VAL = eINSTANCE.getCharge_ChVal();

		/**
		 * The meta object literal for the '<em><b>Ch T</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHARGE__CH_T = eINSTANCE.getCharge_ChT();

		/**
		 * The meta object literal for the '{@link hW5.PriceCode <em>Price Code</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hW5.PriceCode
		 * @see hW5.impl.HW5PackageImpl#getPriceCode()
		 * @generated
		 */
		EEnum PRICE_CODE = eINSTANCE.getPriceCode();

	}

} //HW5Package
