/**
 */
package hW5;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rental</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hW5.Rental#getDaysRented <em>Days Rented</em>}</li>
 *   <li>{@link hW5.Rental#getMovieRental <em>Movie Rental</em>}</li>
 * </ul>
 *
 * @see hW5.HW5Package#getRental()
 * @model
 * @generated
 */
public interface Rental extends EObject {
	/**
	 * Returns the value of the '<em><b>Days Rented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Days Rented</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Days Rented</em>' attribute.
	 * @see #setDaysRented(int)
	 * @see hW5.HW5Package#getRental_DaysRented()
	 * @model
	 * @generated
	 */
	int getDaysRented();

	/**
	 * Sets the value of the '{@link hW5.Rental#getDaysRented <em>Days Rented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Days Rented</em>' attribute.
	 * @see #getDaysRented()
	 * @generated
	 */
	void setDaysRented(int value);

	/**
	 * Returns the value of the '<em><b>Movie Rental</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Movie Rental</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movie Rental</em>' reference.
	 * @see #setMovieRental(Movie)
	 * @see hW5.HW5Package#getRental_MovieRental()
	 * @model required="true"
	 * @generated
	 */
	Movie getMovieRental();

	/**
	 * Sets the value of the '{@link hW5.Rental#getMovieRental <em>Movie Rental</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Movie Rental</em>' reference.
	 * @see #getMovieRental()
	 * @generated
	 */
	void setMovieRental(Movie value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	double getCharge();

} // Rental
