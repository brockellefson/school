/**
 */
package hW5;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Charge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hW5.Charge#getChVal <em>Ch Val</em>}</li>
 *   <li>{@link hW5.Charge#getChT <em>Ch T</em>}</li>
 * </ul>
 *
 * @see hW5.HW5Package#getCharge()
 * @model
 * @generated
 */
public interface Charge extends EObject {
	/**
	 * Returns the value of the '<em><b>Ch Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ch Val</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ch Val</em>' attribute.
	 * @see #setChVal(double)
	 * @see hW5.HW5Package#getCharge_ChVal()
	 * @model
	 * @generated
	 */
	double getChVal();

	/**
	 * Sets the value of the '{@link hW5.Charge#getChVal <em>Ch Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ch Val</em>' attribute.
	 * @see #getChVal()
	 * @generated
	 */
	void setChVal(double value);

	/**
	 * Returns the value of the '<em><b>Ch T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ch T</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ch T</em>' attribute.
	 * @see #setChT(String)
	 * @see hW5.HW5Package#getCharge_ChT()
	 * @model
	 * @generated
	 */
	String getChT();

	/**
	 * Sets the value of the '{@link hW5.Charge#getChT <em>Ch T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ch T</em>' attribute.
	 * @see #getChT()
	 * @generated
	 */
	void setChT(String value);

} // Charge
