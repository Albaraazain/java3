/**
 * This class represents a shared property in the property management system.
 *
 * @author Albaraa
 * @version 1.0
 */
public class SharedProperty extends Property {

    /**
     * Constructs a shared property with complete information.
     *
     * @param propertyId   The unique ID of the property.
     * @param noBedRooms   The number of bedrooms in the property.
     * @param noRooms      The total number of rooms in the property.
     * @param city         The city where the property is located.
     * @param pricePerDay The base price per day for renting the property.
     * @param host         The host of the property.
     */
    public SharedProperty(int propertyId, int noBedRooms, int noRooms, String city, double pricePerDay, Host host) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay, host);
    }

    /**
     * Constructs a shared property with basic information and no host.
     *
     * @param propertyId   The unique ID of the property.
     * @param noBedRooms   The number of bedrooms in the property.
     * @param noRooms      The total number of rooms in the property.
     * @param city         The city where the property is located.
     * @param pricePerDay The base price per day for renting the property.
     */
    public SharedProperty(int propertyId, int noBedRooms, int noRooms, String city, double pricePerDay) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay);
    }

    /**
     * Calculate the price per day for renting the shared property, dividing the base price by the number of bedrooms.
     *
     * @return The calculated price per day.
     */
    @Override
    public double calculatePricePerDay() {
        return getPricePerDay() / getNoBedRooms();
    }

    /**
     * Compare SharedProperty objects based on their calculated price per day.
     *
     * @param otherProperty The property to compare to.
     * @return A positive integer if this property is greater, a negative integer if it's smaller, or 0 if they are equal.
     */
    @Override
    public int compareTo(Property otherProperty) {
        return Double.compare(this.calculatePricePerDay(), otherProperty.calculatePricePerDay());
    }

    /**
     * Get a string representation of the SharedProperty.
     *
     * @return A string representing the SharedProperty object.
     */
    @Override
    public String toString() {
        return "SharedProperty{" +
                "propertyId=" + getPropertyId() +
                ", noBedRooms=" + getNoBedRooms() +
                ", noRooms=" + getNoRooms() +
                ", city='" + getCity() + '\'' +
                ", pricePerDay=" + getPricePerDay() +
                ", inspection=" + getInspection().toString() +
                '}';
    }
}
