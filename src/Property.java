import java.util.Date;
import java.util.HashMap;

/**
 * This abstract class represents a property in the property management system.
 *
 * @author Albaraa
 * @version 1.0
 */
public abstract class Property implements PropertyPrice, Comparable<Property> {
    private int propertyId;
    private int noBedRooms;
    private int noRooms;
    private String city;
    private double pricePerDay;
    private HashMap<Date, String> inspection;

    /**
     * Constructs a property with basic information and a host.
     *
     * @param propertyId   The unique ID of the property.
     * @param noBedRooms   The number of bedrooms in the property.
     * @param noRooms      The total number of rooms in the property.
     * @param city         The city where the property is located.
     * @param pricePerDay The base price per day for renting the property.
     * @param host         The host of the property.
     */
    public Property(int propertyId, int noBedRooms, int noRooms, String city, double pricePerDay, Host host) {
        this.propertyId = propertyId;
        this.noBedRooms = noBedRooms;
        this.noRooms = noRooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.inspection = new HashMap<>();
    }

    /**
     * Constructs a property with basic information and no host.
     *
     * @param propertyId The unique ID of the property.
     * @param noBedRooms The number of bedrooms in the property.
     * @param noRooms    The total number of rooms in the property.
     * @param city       The city where the property is located.
     */
    public Property(int propertyId, int noBedRooms, int noRooms, String city) {
        this.propertyId = propertyId;
        this.noBedRooms = noBedRooms;
        this.noRooms = noRooms;
        this.city = city;
        this.inspection = new HashMap<>();
    }

    public Property(int propertyId, int noBedRooms, int noRooms, String city, double pricePerDay) {
        this(propertyId, noBedRooms, noRooms, city);
        this.pricePerDay = pricePerDay;
    }

    /**
     * Get the unique ID of the property.
     *
     * @return The property ID.
     */
    public int getPropertyId() {
        return propertyId;
    }

    /**
     * Set the unique ID of the property.
     *
     * @param propertyId The property ID to set.
     */
    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * Get the number of bedrooms in the property.
     *
     * @return The number of bedrooms.
     */
    public int getNoBedRooms() {
        return noBedRooms;
    }

    /**
     * Set the number of bedrooms in the property.
     *
     * @param noBedRooms The number of bedrooms to set.
     */
    public void setNoBedRooms(int noBedRooms) {
        this.noBedRooms = noBedRooms;
    }

    /**
     * Get the total number of rooms in the property.
     *
     * @return The total number of rooms.
     */
    public int getNoRooms() {
        return noRooms;
    }

    /**
     * Set the total number of rooms in the property.
     *
     * @param noRooms The total number of rooms to set.
     */
    public void setNoRooms(int noRooms) {
        this.noRooms = noRooms;
    }

    /**
     * Get the city where the property is located.
     *
     * @return The city name.
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city where the property is located.
     *
     * @param city The city name to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the price per day for renting the property.
     *
     * @return The price per day.
     */
    public double getPricePerDay() {
        return pricePerDay;
    }

    /**
     * Set the price per day for renting the property.
     *
     * @param pricePerDay The price per day to set.
     */
    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    /**
     * Get the inspection records for the property.
     *
     * @return A HashMap containing inspection records with dates as keys and descriptions as values.
     */
    public HashMap<Date, String> getInspection() {
        return inspection;
    }

    /**
     * Set the inspection records for the property.
     *
     * @param inspection A HashMap containing inspection records with dates as keys and descriptions as values.
     */
    public void setInspection(HashMap<Date, String> inspection) {
        this.inspection = inspection;
    }

    /**
     * Implement the calculatePricePerDay method from the PropertyPrice interface.
     *
     * @return The calculated price per day.
     */
    @Override
    public abstract double calculatePricePerDay();

    /**
     * Abstract compareTo method as per Comparable interface.
     *
     * @param otherProperty The property to compare to.
     * @return A positive integer if this property is greater, a negative integer if it's smaller, or 0 if they are equal.
     */
    @Override
    public abstract int compareTo(Property otherProperty);

    @Override
    public String toString() {
        return "Property ID: " + propertyId + ", No. of Bedrooms: " + noBedRooms +
                ", No. of Rooms: " + noRooms + ", City: " + city + "\n";
    }
}
