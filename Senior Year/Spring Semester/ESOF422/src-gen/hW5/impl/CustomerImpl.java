/**
 */
package hW5.impl;

import hW5.Charge;
import hW5.Customer;
import hW5.HW5Package;
import hW5.Rental;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hW5.impl.CustomerImpl#getName <em>Name</em>}</li>
 *   <li>{@link hW5.impl.CustomerImpl#getNumRen <em>Num Ren</em>}</li>
 *   <li>{@link hW5.impl.CustomerImpl#getTotalCharges <em>Total Charges</em>}</li>
 *   <li>{@link hW5.impl.CustomerImpl#getRental <em>Rental</em>}</li>
 *   <li>{@link hW5.impl.CustomerImpl#getCharge <em>Charge</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CustomerImpl extends MinimalEObjectImpl.Container implements Customer {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumRen() <em>Num Ren</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumRen()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_REN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumRen() <em>Num Ren</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumRen()
	 * @generated
	 * @ordered
	 */
	protected int numRen = NUM_REN_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalCharges() <em>Total Charges</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalCharges()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_CHARGES_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalCharges() <em>Total Charges</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalCharges()
	 * @generated
	 * @ordered
	 */
	protected double totalCharges = TOTAL_CHARGES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRental() <em>Rental</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRental()
	 * @generated
	 * @ordered
	 */
	protected EList<Rental> rental;

	/**
	 * The cached value of the '{@link #getCharge() <em>Charge</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharge()
	 * @generated
	 * @ordered
	 */
	protected EList<Charge> charge;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HW5Package.Literals.CUSTOMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HW5Package.CUSTOMER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumRen() {
		return numRen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumRen(int newNumRen) {
		int oldNumRen = numRen;
		numRen = newNumRen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HW5Package.CUSTOMER__NUM_REN, oldNumRen, numRen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalCharges() {
		return totalCharges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalCharges(double newTotalCharges) {
		double oldTotalCharges = totalCharges;
		totalCharges = newTotalCharges;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HW5Package.CUSTOMER__TOTAL_CHARGES, oldTotalCharges,
					totalCharges));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rental> getRental() {
		if (rental == null) {
			rental = new EObjectResolvingEList<Rental>(Rental.class, this, HW5Package.CUSTOMER__RENTAL);
		}
		return rental;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Charge> getCharge() {
		if (charge == null) {
			charge = new EObjectResolvingEList<Charge>(Charge.class, this, HW5Package.CUSTOMER__CHARGE);
		}
		return charge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	public void addRental(Rental rental) {
		if (this.rental == null) {
			this.rental = new EObjectResolvingEList<Rental>(Rental.class, this, HW5Package.CUSTOMER__RENTAL);
		}
		this.rental.add(rental);
		this.numRen++;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void statement() {
		System.out.println("Customer: " + this.getName());
		System.out.println("Number of Customer Rentals: " + this.getNumRen());
		double totalboi = 0.0;
		for(int i = 0 ; i < this.numRen; i++) {
			String movieTitle = this.rental.get(i).getMovieRental().getTitle();
			int daysRented = this.rental.get(i).getDaysRented();
			double total = this.rental.get(i).getCharge();
			totalboi += total;
			System.out.println("Rented: " + movieTitle + ", for  " + daysRented + " days, totaling to $" + total);
		}
		System.out.println("Final total is: " + totalboi);
		//yeet
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case HW5Package.CUSTOMER__NAME:
			return getName();
		case HW5Package.CUSTOMER__NUM_REN:
			return getNumRen();
		case HW5Package.CUSTOMER__TOTAL_CHARGES:
			return getTotalCharges();
		case HW5Package.CUSTOMER__RENTAL:
			return getRental();
		case HW5Package.CUSTOMER__CHARGE:
			return getCharge();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case HW5Package.CUSTOMER__NAME:
			setName((String) newValue);
			return;
		case HW5Package.CUSTOMER__NUM_REN:
			setNumRen((Integer) newValue);
			return;
		case HW5Package.CUSTOMER__TOTAL_CHARGES:
			setTotalCharges((Double) newValue);
			return;
		case HW5Package.CUSTOMER__RENTAL:
			getRental().clear();
			getRental().addAll((Collection<? extends Rental>) newValue);
			return;
		case HW5Package.CUSTOMER__CHARGE:
			getCharge().clear();
			getCharge().addAll((Collection<? extends Charge>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case HW5Package.CUSTOMER__NAME:
			setName(NAME_EDEFAULT);
			return;
		case HW5Package.CUSTOMER__NUM_REN:
			setNumRen(NUM_REN_EDEFAULT);
			return;
		case HW5Package.CUSTOMER__TOTAL_CHARGES:
			setTotalCharges(TOTAL_CHARGES_EDEFAULT);
			return;
		case HW5Package.CUSTOMER__RENTAL:
			getRental().clear();
			return;
		case HW5Package.CUSTOMER__CHARGE:
			getCharge().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case HW5Package.CUSTOMER__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case HW5Package.CUSTOMER__NUM_REN:
			return numRen != NUM_REN_EDEFAULT;
		case HW5Package.CUSTOMER__TOTAL_CHARGES:
			return totalCharges != TOTAL_CHARGES_EDEFAULT;
		case HW5Package.CUSTOMER__RENTAL:
			return rental != null && !rental.isEmpty();
		case HW5Package.CUSTOMER__CHARGE:
			return charge != null && !charge.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case HW5Package.CUSTOMER___ADD_RENTAL__RENTAL:
			addRental((Rental) arguments.get(0));
			return null;
		case HW5Package.CUSTOMER___STATEMENT:
			statement();
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", numRen: ");
		result.append(numRen);
		result.append(", totalCharges: ");
		result.append(totalCharges);
		result.append(')');
		return result.toString();
	}

} //CustomerImpl
