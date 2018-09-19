/**
 */
package hW5.impl;

import hW5.HW5Package;
import hW5.Movie;
import hW5.PriceCode;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Movie</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hW5.impl.MovieImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link hW5.impl.MovieImpl#getPriceCode <em>Price Code</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MovieImpl extends MinimalEObjectImpl.Container implements Movie {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriceCode() <em>Price Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriceCode()
	 * @generated
	 * @ordered
	 */
	protected static final PriceCode PRICE_CODE_EDEFAULT = PriceCode.REGULAR;

	/**
	 * The cached value of the '{@link #getPriceCode() <em>Price Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriceCode()
	 * @generated
	 * @ordered
	 */
	protected PriceCode priceCode = PRICE_CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovieImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HW5Package.Literals.MOVIE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HW5Package.MOVIE__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriceCode getPriceCode() {
		return priceCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriceCode(PriceCode newPriceCode) {
		PriceCode oldPriceCode = priceCode;
		priceCode = newPriceCode == null ? PRICE_CODE_EDEFAULT : newPriceCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HW5Package.MOVIE__PRICE_CODE, oldPriceCode,
					priceCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case HW5Package.MOVIE__TITLE:
			return getTitle();
		case HW5Package.MOVIE__PRICE_CODE:
			return getPriceCode();
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
		case HW5Package.MOVIE__TITLE:
			setTitle((String) newValue);
			return;
		case HW5Package.MOVIE__PRICE_CODE:
			setPriceCode((PriceCode) newValue);
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
		case HW5Package.MOVIE__TITLE:
			setTitle(TITLE_EDEFAULT);
			return;
		case HW5Package.MOVIE__PRICE_CODE:
			setPriceCode(PRICE_CODE_EDEFAULT);
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
		case HW5Package.MOVIE__TITLE:
			return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
		case HW5Package.MOVIE__PRICE_CODE:
			return priceCode != PRICE_CODE_EDEFAULT;
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
		result.append(" (title: ");
		result.append(title);
		result.append(", priceCode: ");
		result.append(priceCode);
		result.append(')');
		return result.toString();
	}

} //MovieImpl
