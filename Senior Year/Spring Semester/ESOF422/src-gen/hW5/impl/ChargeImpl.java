/**
 */
package hW5.impl;

import hW5.Charge;
import hW5.HW5Package;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Charge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hW5.impl.ChargeImpl#getChVal <em>Ch Val</em>}</li>
 *   <li>{@link hW5.impl.ChargeImpl#getChT <em>Ch T</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChargeImpl extends MinimalEObjectImpl.Container implements Charge {
	/**
	 * The default value of the '{@link #getChVal() <em>Ch Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChVal()
	 * @generated
	 * @ordered
	 */
	protected static final double CH_VAL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getChVal() <em>Ch Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChVal()
	 * @generated
	 * @ordered
	 */
	protected double chVal = CH_VAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getChT() <em>Ch T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChT()
	 * @generated
	 * @ordered
	 */
	protected static final String CH_T_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChT() <em>Ch T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChT()
	 * @generated
	 * @ordered
	 */
	protected String chT = CH_T_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChargeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HW5Package.Literals.CHARGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getChVal() {
		return chVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChVal(double newChVal) {
		double oldChVal = chVal;
		chVal = newChVal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HW5Package.CHARGE__CH_VAL, oldChVal, chVal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChT() {
		return chT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChT(String newChT) {
		String oldChT = chT;
		chT = newChT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HW5Package.CHARGE__CH_T, oldChT, chT));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case HW5Package.CHARGE__CH_VAL:
			return getChVal();
		case HW5Package.CHARGE__CH_T:
			return getChT();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case HW5Package.CHARGE__CH_VAL:
			setChVal((Double) newValue);
			return;
		case HW5Package.CHARGE__CH_T:
			setChT((String) newValue);
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
		case HW5Package.CHARGE__CH_VAL:
			setChVal(CH_VAL_EDEFAULT);
			return;
		case HW5Package.CHARGE__CH_T:
			setChT(CH_T_EDEFAULT);
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
		case HW5Package.CHARGE__CH_VAL:
			return chVal != CH_VAL_EDEFAULT;
		case HW5Package.CHARGE__CH_T:
			return CH_T_EDEFAULT == null ? chT != null : !CH_T_EDEFAULT.equals(chT);
		}
		return super.eIsSet(featureID);
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
		result.append(" (chVal: ");
		result.append(chVal);
		result.append(", chT: ");
		result.append(chT);
		result.append(')');
		return result.toString();
	}

} //ChargeImpl
