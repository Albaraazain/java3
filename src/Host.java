import java.util.Date;

/**
 * This class represents a host in the property management system.
 *
 * @author Your Name
 * @version 1.0
 */
public class Host extends User {
    private double taxNumber;

    /**
     * Constructs a host with user information and a tax number.
     *
     * @param userId           The unique ID of the host.
     * @param dateOfBirth      The date of birth of the host.
     * @param firstName        The first name of the host.
     * @param lastName         The last name of the host.
     * @param registrationDate The date of host registration.
     * @param taxNumber        The tax number of the host.
     */
    public Host(int userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate, double taxNumber) {
        super(userId, dateOfBirth, firstName, lastName, registrationDate);
        this.taxNumber = taxNumber;
    }

    /**
     * Get the tax number of the host.
     *
     * @return The tax number.
     */
    public double getTaxNumber() {
        return taxNumber;
    }

    /**
     * Set the tax number of the host.
     *
     * @param taxNumber The tax number to set.
     */
    public void setTaxNumber(double taxNumber) {
        this.taxNumber = taxNumber;
    }
}
