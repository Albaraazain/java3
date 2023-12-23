import java.util.Date;

/**
 * This class represents a gold customer in the property management system.
 *
 * @author Albaraa
 * @version 1.0
 */
public class GoldCustomer extends Customer {
    private int goldLevel;

    /**
     * Constructs a gold customer with user information, a preferred payment method, and a gold level.
     *
     * @param userId               The unique ID of the customer.
     * @param dateOfBirth          The date of birth of the customer.
     * @param firstName            The first name of the customer.
     * @param lastName             The last name of the customer.
     * @param registrationDate     The date of customer registration.
     * @param preferredPaymentMethod The preferred payment method of the customer.
     * @param goldLevel            The gold level of the customer (1 to 3).
     */
    public GoldCustomer(int userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate, String preferredPaymentMethod, int goldLevel) {
        super(userId, dateOfBirth, firstName, lastName, registrationDate, preferredPaymentMethod);
        this.goldLevel = goldLevel;
    }

    /**
     * Get the gold level of the customer.
     *
     * @return The gold level (1 to 3).
     */
    public int getGoldLevel() {
        return goldLevel;
    }

    /**
     * Set the gold level of the customer.
     *
     * @param goldLevel The gold level to set (1 to 3).
     */
    public void setGoldLevel(int goldLevel) {
        this.goldLevel = goldLevel;
    }

    /**
     * Calculate the discount percentage for a gold customer based on their gold level.
     *
     * @return The discount percentage for the customer.
     */
    @Override
    public double getDiscountForUser() {
        // Assuming the gold level is between 1 and 3, and each level corresponds to that percentage of discount.
        return goldLevel;
    }

    @Override
    public String toString() {
        return super.toString() + "Gold Level: " + goldLevel + "\n";
    }
}
