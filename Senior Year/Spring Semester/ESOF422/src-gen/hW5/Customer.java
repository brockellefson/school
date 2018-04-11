/**
 */
package hW5;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hW5.Customer#getName <em>Name</em>}</li>
 *   <li>{@link hW5.Customer#getNumRen <em>Num Ren</em>}</li>
 *   <li>{@link hW5.Customer#getTotalCharges <em>Total Charges</em>}</li>
 *   <li>{@link hW5.Customer#getRental <em>Rental</em>}</li>
 *   <li>{@link hW5.Customer#getCharge <em>Charge</em>}</li>
 * </ul>
 *
 * @see hW5.HW5Package#getCustomer()
 * @model
 * @generated
 */
public interface Customer extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see hW5.HW5Package#getCustomer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hW5.Customer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Num Ren</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Ren</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Ren</em>' attribute.
	 * @see #setNumRen(int)
	 * @see hW5.HW5Package#getCustomer_NumRen()
	 * @model
	 * @generated
	 */
	int getNumRen();

	/**
	 * Sets the value of the '{@link hW5.Customer#getNumRen <em>Num Ren</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Ren</em>' attribute.
	 * @see #getNumRen()
	 * @generated
	 */
	void setNumRen(int value);

	/**
	 * Returns the value of the '<em><b>Total Charges</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Charges</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Charges</em>' attribute.
	 * @see #setTotalCharges(double)
	 * @see hW5.HW5Package#getCustomer_TotalCharges()
	 * @model
	 * @generated
	 */
	double getTotalCharges();

	/**
	 * Sets the value of the '{@link hW5.Customer#getTotalCharges <em>Total Charges</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Charges</em>' attribute.
	 * @see #getTotalCharges()
	 * @generated
	 */
	void setTotalCharges(double value);

	/**
	 * Returns the value of the '<em><b>Rental</b></em>' reference list.
	 * The list contents are of type {@link hW5.Rental}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rental</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rental</em>' reference list.
	 * @see hW5.HW5Package#getCustomer_Rental()
	 * @model required="true"
	 * @generated
	 */
	EList<Rental> getRental();

	/**
	 * Returns the value of the '<em><b>Charge</b></em>' reference list.
	 * The list contents are of type {@link hW5.Charge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Charge</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Charge</em>' reference list.
	 * @see hW5.HW5Package#getCustomer_Charge()
	 * @model required="true"
	 * @generated
	 */
	EList<Charge> getCharge();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addRental(Rental rental);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void statement();

} // Customer
