/**
 */
package hW5;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Movie</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hW5.Movie#getTitle <em>Title</em>}</li>
 *   <li>{@link hW5.Movie#getPriceCode <em>Price Code</em>}</li>
 * </ul>
 *
 * @see hW5.HW5Package#getMovie()
 * @model
 * @generated
 */
public interface Movie extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see hW5.HW5Package#getMovie_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link hW5.Movie#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Price Code</b></em>' attribute.
	 * The literals are from the enumeration {@link hW5.PriceCode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Price Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Price Code</em>' attribute.
	 * @see hW5.PriceCode
	 * @see #setPriceCode(PriceCode)
	 * @see hW5.HW5Package#getMovie_PriceCode()
	 * @model
	 * @generated
	 */
	PriceCode getPriceCode();

	/**
	 * Sets the value of the '{@link hW5.Movie#getPriceCode <em>Price Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Price Code</em>' attribute.
	 * @see hW5.PriceCode
	 * @see #getPriceCode()
	 * @generated
	 */
	void setPriceCode(PriceCode value);

} // Movie
