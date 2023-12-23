/**
 * This class represents a full property in the property management system.
 *
 * @author Albaraa
 * @version 1.0
 */
public class FullProperty extends Property {
    private double size; // Size in square meters

    /**
     * Constructs a full property with complete information.
     *
     * @param propertyId   The unique ID of the property.
     * @param noBedRooms   The number of bedrooms in the property.
     * @param noRooms      The total number of rooms in the property.
     * @param city         The city where the property is located.
     * @param size         The size of the property in square meters.
     * @param pricePerDay The base price per day for renting the property.
     * @param host         The host of the property.
     */
    public FullProperty(int propertyId, int noBedRooms, int noRooms, String city, double size, double pricePerDay, Host host) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay, host);
        this.size = size;
    }

    /**
     * Constructs a full property with basic information and no host.
     *
     * @param propertyId   The unique ID of the property.
     * @param noBedRooms   The number of bedrooms in the property.
     * @param noRooms      The total number of rooms in the property.
     * @param city         The city where the property is located.
     * @param size         The size of the property in square meters.
     * @param pricePerDay The base price per day for renting the property.
     */
    public FullProperty(int propertyId, int noBedRooms, int noRooms, String city, double size, double pricePerDay) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay);
        this.size = size;
    }

    /**
     * Get the size of the property in square meters.
     *
     * @return The property size.
     */
    public double getSize() {
        return size;
    }

    /**
     * Set the size of the property in square meters.
     *
     * @param size The property size to set.
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Calculate the price per day for renting the full property, including tax based on property size.
     *
     * @return The calculated price per day.
     */
    @Override
    public double calculatePricePerDay() {
        double taxRate;
        if (size <= 200) {
            taxRate = 0.01; // 1% tax
        } else if (size <= 300) {
            taxRate = 0.03; // 3% tax
        } else {
            taxRate = 0.04; // 4% tax
        }

        return getPricePerDay() * (1 + taxRate);
    }

    /**
     * Compare FullProperty objects based on their calculated price per day.
     *
     * @param otherProperty The property to compare to.
     * @return A positive integer if this property is greater, a negative integer if it's smaller, or 0 if they are equal.
     */
    @Override
    public int compareTo(Property otherProperty) {
        return Double.compare(this.calculatePricePerDay(), otherProperty.calculatePricePerDay());
    }

    /**
     * Get a string representation of the FullProperty.
     *
     * @return A string representing the FullProperty object.
     */
    @Override
    public String toString() {
        return "FullProperty{" +
                "propertyId=" + getPropertyId() +
                ", noBedRooms=" + getNoBedRooms() +
                ", noRooms=" + getNoRooms() +
                ", city='" + getCity() + '\'' +
                ", size=" + size +
                ", pricePerDay=" + getPricePerDay() +
                ", inspection=" + getInspection().toString() +
                '}';
    }
}
