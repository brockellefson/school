/**
 */
package hW5.impl;

import hW5.HW5Package;
import hW5.Movie;
import hW5.PriceCode;
import hW5.Rental;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rental</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hW5.impl.RentalImpl#getDaysRented <em>Days Rented</em>}</li>
 *   <li>{@link hW5.impl.RentalImpl#getMovieRental <em>Movie Rental</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RentalImpl extends MinimalEObjectImpl.Container implements Rental {
	/**
	 * The default value of the '{@link #getDaysRented() <em>Days Rented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDaysRented()
	 * @generated
	 * @ordered
	 */
	protected static final int DAYS_RENTED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDaysRented() <em>Days Rented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDaysRented()
	 * @generated
	 * @ordered
	 */
	protected int daysRented = DAYS_RENTED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMovieRental() <em>Movie Rental</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovieRental()
	 * @generated
	 * @ordered
	 */
	protected Movie movieRental;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RentalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HW5Package.Literals.RENTAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDaysRented() {
		return daysRented;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDaysRented(int newDaysRented) {
		int oldDaysRented = daysRented;
		daysRented = newDaysRented;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HW5Package.RENTAL__DAYS_RENTED, oldDaysRented,
					daysRented));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Movie getMovieRental() {
		if (movieRental != null && movieRental.eIsProxy()) {
			InternalEObject oldMovieRental = (InternalEObject) movieRental;
			movieRental = (Movie) eResolveProxy(oldMovieRental);
			if (movieRental != oldMovieRental) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HW5Package.RENTAL__MOVIE_RENTAL,
							oldMovieRental, movieRental));
			}
		}
		return movieRental;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Movie basicGetMovieRental() {
		return movieRental;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMovieRental(Movie newMovieRental) {
		Movie oldMovieRental = movieRental;
		movieRental = newMovieRental;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HW5Package.RENTAL__MOVIE_RENTAL, oldMovieRental,
					movieRental));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCharge() {
		PriceCode priceCode = this.movieRental.getPriceCode();
		
		if (priceCode == PriceCode.REGULAR) {
			if (this.daysRented > 2) {
				return 2.0 + (this.daysRented - 2) * 1.5;
			}
			return 2.0 * this.daysRented;
		}
		else if (priceCode == PriceCode.FAMILY) {
			if (this.daysRented > 3) {
				return 3.0 + (this.daysRented - 3) * 1.5;
			}
			return 1.5 * this.daysRented;
		}
		else if (priceCode == PriceCode.NEW_RELEASE)
			return 3.0 * this.daysRented;
		return 0.0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case HW5Package.RENTAL__DAYS_RENTED:
			return getDaysRented();
		case HW5Package.RENTAL__MOVIE_RENTAL:
			if (resolve)
				return getMovieRental();
			return basicGetMovieRental();
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
		case HW5Package.RENTAL__DAYS_RENTED:
			setDaysRented((Integer) newValue);
			return;
		case HW5Package.RENTAL__MOVIE_RENTAL:
			setMovieRental((Movie) newValue);
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
		case HW5Package.RENTAL__DAYS_RENTED:
			setDaysRented(DAYS_RENTED_EDEFAULT);
			return;
		case HW5Package.RENTAL__MOVIE_RENTAL:
			setMovieRental((Movie) null);
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
		case HW5Package.RENTAL__DAYS_RENTED:
			return daysRented != DAYS_RENTED_EDEFAULT;
		case HW5Package.RENTAL__MOVIE_RENTAL:
			return movieRental != null;
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
		case HW5Package.RENTAL___GET_CHARGE:
			return getCharge();
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
		result.append(" (daysRented: ");
		result.append(daysRented);
		result.append(')');
		return result.toString();
	}

} //RentalImpl
