import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents a user in the property management system.
 *
 * @author Albaraa
 * @version 1.0
 */
public abstract class User {
    private int userId;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private Date registrationDate;
    private ArrayList<Booking> bookings = new ArrayList<>();

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Constructor with user information.
     *
     * @param userId           The unique ID of the user.
     * @param dateOfBirth      The date of birth of the user.
     * @param firstName        The first name of the user.
     * @param lastName         The last name of the user.
     * @param registrationDate The date of user registration.
     */
    public User(int userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate) {
        this.userId = userId;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
    }

    /**
     * Get the unique ID of the user.
     *
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the unique ID of the user.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get the list of bookings associated with this user.
     *
     * @return The list of bookings.
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * Get the date of birth of the user.
     *
     * @return The date of birth.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set the date of birth of the user.
     *
     * @param dateOfBirth The date of birth to set.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get the first name of the user.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the user.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the user.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the user.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the date of user registration.
     *
     * @return The registration date.
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Set the date of user registration.
     *
     * @param registrationDate The registration date to set.
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Add a booking to the user's list of bookings.
     *
     * @param newBooking The booking to add.
     */
    public void addBooking(Booking newBooking) {
        bookings.add(newBooking);
    }
}