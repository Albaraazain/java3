import java.util.Date;
import java.util.Calendar;

/**
 * This class represents a standard customer in the property management system.
 *
 * @author Albaraa
 * @version 1.0
 */
public class StandardCustomer extends Customer {

    /**
     * Constructs a standard customer with user information and a preferred payment method.
     *
     * @param userId               The unique ID of the customer.
     * @param dateOfBirth          The date of birth of the customer.
     * @param firstName            The first name of the customer.
     * @param lastName             The last name of the customer.
     * @param registrationDate     The date of customer registration.
     * @param preferredPaymentMethod The preferred payment method of the customer.
     */
    public StandardCustomer(int userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod) {
        super(userId, dateOfBirth, firstName, lastName, registrationDate, preferredPaymentMethod);
    }

    /**
     * Calculate the discount percentage for a standard customer based on registration years.
     *
     * @return The discount percentage for the customer.
     */
    @Override
    public double getDiscountForUser() {
        Calendar current = Calendar.getInstance();
        Calendar registration = Calendar.getInstance();
        registration.setTime(getRegistrationDate());

        int yearsBetween = current.get(Calendar.YEAR) - registration.get(Calendar.YEAR);
        if (registration.get(Calendar.DAY_OF_YEAR) > current.get(Calendar.DAY_OF_YEAR)) {
            yearsBetween--;
        }

        // If registered for 10 or more years, they get a 2% discount.
        if (yearsBetween >= 10) {
            return 2.0;
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
