import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class PopulateData {

    public static void populate(BASIC basicApp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Create users
        try {
            Date registrationDate = sdf.parse("01/01/2010"); // A fixed registration date for example

            GoldCustomer user1 = new GoldCustomer(1, sdf.parse("15/06/1985"), "John", "Doe", registrationDate, "Credit Card", 2);
            StandardCustomer user2 = new StandardCustomer(2, sdf.parse("22/09/1990"), "Jane", "Smith", registrationDate, "PayPal");
            Host user3 = new Host(3, sdf.parse("30/12/1975"), "Bob", "Brown", registrationDate, 123456789);

            // Add users to the BASIC application
            basicApp.users.add(user1);
            basicApp.users.add(user2);
            basicApp.users.add(user3);

            // Create properties and set hosts for properties
            Property property1 = new SharedProperty(1, 2, 4, "Nicosia", 100.0, user3);
            Property property2 = new FullProperty(2, 3, 5, "Limassol", 150.0, 250, user3);
            Property property3 = new SharedProperty(3, 1, 3, "Paphos", 80.0, user3);

            // Add properties to the BASIC application
            basicApp.properties.add(property1);
            basicApp.properties.add(property2);
            basicApp.properties.add(property3);

            // Create bookings
            Date startDate = sdf.parse("10/10/2023");
            Date endDate = sdf.parse("20/10/2023");

            Booking booking1 = new Booking(user1, property1, startDate, endDate, true);
            Booking booking2 = new Booking(user2, property2, startDate, endDate, true);
            Booking booking3 = new Booking(user3, property3, startDate, endDate, true);

            // Add bookings to users
            user1.addBooking(booking1);
            user2.addBooking(booking2);
            user3.addBooking(booking3);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly in production code
        }
    }
}
