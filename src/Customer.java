import java.util.Date;

/**
 * This class represents a customer in the property management system.
 *
 * @author Albaraa
 * @version 1.0
 */
public abstract class Customer extends User {
    private String preferredPaymentMethod;

    /**
     * Constructs a customer with user information and a preferred payment method.
     *
     * @param userId               The unique ID of the customer.
     * @param dateOfBirth          The date of birth of the customer.
     * @param firstName            The first name of the customer.
     * @param lastName             The last name of the customer.
     * @param registrationDate     The date of customer registration.
     * @param preferredPaymentMethod The preferred payment method of the customer.
     */
    public Customer(int userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod) {
        super(userId, dateOfBirth, firstName, lastName, registrationDate);
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    /**
     * Get the preferred payment method of the customer.
     *
     * @return The preferred payment method.
     */
    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    /**
     * Set the preferred payment method of the customer.
     *
     * @param preferredPaymentMethod The preferred payment method to set.
     */
    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    /**
     * Abstract method to get the discount for the customer.
     *
     * @return The discount percentage for the customer.
     */
    public abstract double getDiscountForUser();

    @Override
    public String toString() {
        // Assuming that the User class also has a toString implementation
        return super.toString() + "Preferred Payment Method: " + preferredPaymentMethod + "\n";
    }
}
