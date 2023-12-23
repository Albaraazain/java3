import java.util.Date;

/**
 * Represents a booking for a property by a user.
 *
 * @author Albaraa
 * @version 1.0
 */
public class Booking {
    private User user;
    private Property property;
    private Date startDate;
    private Date endDate;
    private boolean isPaid;

    /**
     * Constructs a booking with complete information.
     *
     * @param user     The user making the booking.
     * @param property The property being booked.
     * @param startDate The start date of the booking.
     * @param endDate   The end date of the booking.
     * @param isPaid    Indicates whether the booking is paid.
     */
    public Booking(User user, Property property, Date startDate, Date endDate, boolean isPaid) {
        this.user = user;
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPaid = isPaid;
    }

    /**
     * Constructs a booking with minimal information and unpaid status.
     *
     * @param user     The user making the booking.
     * @param property The property being booked.
     * @param startDate The start date of the booking.
     * @param endDate   The end date of the booking.
     */
    public Booking(User user, Property property, Date startDate, Date endDate) {
        this(user, property, startDate, endDate, false);
    }

    /**
     * Gets the user associated with the booking.
     *
     * @return The user making the booking.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with the booking.
     *
     * @param user The user making the booking.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the property being booked.
     *
     * @return The property being booked.
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Sets the property being booked.
     *
     * @param property The property being booked.
     */
    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * Gets the start date of the booking.
     *
     * @return The start date of the booking.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the booking.
     *
     * @param startDate The start date of the booking.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date of the booking.
     *
     * @return The end date of the booking.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the booking.
     *
     * @param endDate The end date of the booking.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Checks if the booking is paid.
     *
     * @return true if the booking is paid; otherwise, false.
     */
    public boolean isPaid() {
        return isPaid;
    }

    /**
     * Sets the payment status of the booking.
     *
     * @param isPaid Indicates whether the booking is paid.
     */
    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    /**
     * Calculates the total cost of the booking based on the property's price per day.
     *
     * @return The total cost of the booking.
     */
    public double totalCost() {
        long duration = endDate.getTime() - startDate.getTime();
        long days = duration / (24 * 60 * 60 * 1000);
        return property.calculatePricePerDay() * days;
    }

    /**
     * Provides a string representation of the Booking object.
     *
     * @return A string representation of the Booking object.
     */
    @Override
    public String toString() {
        return "Booking{" +
                "user=" + user +
                ", property=" + property +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isPaid=" + isPaid +
                '}';
    }
}
