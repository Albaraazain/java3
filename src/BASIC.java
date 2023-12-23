/**
 * @version JDK 20.0.2
 * @author albaraa zeinoglu
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * The BASIC (Bed And breakfaSt In Cyprus) application class.
 * This class provides the command-line interface for managing users,
 * properties, and bookings within a bed and breakfast system.
 */
public class BASIC {

    /**
     * List of users registered in the system.
     */
    public ArrayList<User> users;

    /**
     * List of properties available in the system.
     */
    public ArrayList<Property> properties;


    /**
     * Constructs a new instance of the BASIC application with empty lists of users and properties.
     */
    public BASIC() {
        this.users = new ArrayList<>();
        this.properties = new ArrayList<>();
    }

    /**
     * Starts the main menu loop of the application.
     */
    public void menu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                displayMenu();
                choice = scanner.nextInt();
                processMenuChoice(choice, scanner);
            } while (choice != 15);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n----- BASIC Application Menu -----");
        System.out.println("1. Add User");
        System.out.println("2. Delete User");
        System.out.println("3. Get User Details");
        System.out.println("4. Add Property");
        System.out.println("5. Delete Property");
        System.out.println("6. Get Property Details");
        System.out.println("7. Add Booking");
        System.out.println("8. Get User Booking");
        System.out.println("9. Get Booking Cost");
        System.out.println("10. Get User Discount");
        System.out.println("11. Add Inspection to Property");
        System.out.println("12. Compare Property Prices Per Day");
        System.out.println("13. List Users");
        System.out.println("14. List Properties");
        System.out.println("15. Exit");
        System.out.print("Enter your choice: ");
    }
    /**
     * Processes the user's choice from the main menu.
     *
     * @param choice  The user's menu choice.
     * @param scanner The Scanner object for handling console input.
     */
    private void processMenuChoice(int choice, Scanner scanner) {
        // Switch statement to handle menu choices...
        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                System.out.print("Enter User ID to delete: ");
                int userIdToDelete = scanner.nextInt();
                deleteUser(userIdToDelete);
                break;
            case 3:
                System.out.print("Enter User ID to get details: ");
                int userIdToGetDetails = scanner.nextInt();
                getUserDetails(userIdToGetDetails);
                break;
            case 4:
                addProperty();
                break;
            case 5:
                System.out.print("Enter Property ID to delete: ");
                int propertyIdToDelete = scanner.nextInt();
                deleteProperty(propertyIdToDelete);
                break;
            case 6:
                System.out.print("Enter Property ID to get details: ");
                int propertyIdToGetDetails = scanner.nextInt();
                getPropertyDetails(propertyIdToGetDetails);
                break;
            case 7:
                addBooking();
                break;
            case 8:
                System.out.print("Enter User ID to get bookings: ");
                int userIdForBookingDetails = scanner.nextInt();
                getUserBooking(userIdForBookingDetails);
                break;
            case 9:
                System.out.print("Enter User ID to get booking cost: ");
                int userIdForCost = scanner.nextInt();
                System.out.print("Enter Property ID to get booking cost: ");
                int propertyIdForCost = scanner.nextInt();
                getBookingCost(userIdForCost, propertyIdForCost);
                break;
            case 10:
                listUsers();
                break;
            case 11:
                listProperties();
                break;
            case 12:
                exit();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    /**
     * Ends the application and exits the program.
     */
    public void exit() {
        System.out.println("Exiting the application. Thank you for using BASIC!");
        System.exit(0);
    }


//    ****************************************** METHODS ***************************************************************


    /**
     * Adds a new user to the list of users in the application.
     * Prompts the user for user information, including User ID, type, first name,
     * last name, date of birth, and registration date. Validates input and checks for
     * duplicate User IDs before adding the user. The user type determines whether a
     * Host, Standard Customer, or Gold Customer is created.
     *
     * @throws InputMismatchException if the input format is incorrect.
     */
    public void addUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (getUserById(userId) != null) {
            System.out.println("A user with this ID already exists. Please use a unique ID.");
            return;
        }

        System.out.print("Enter Type (host/standard/gold): ");
        String userType = scanner.nextLine().trim().toLowerCase();

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Date of Birth in format (dd/MM/yyyy): ");
        String dateOfBirthStr = scanner.nextLine();

        System.out.print("Enter Registration Date in format (dd/MM/yyyy): ");
        String registrationDateStr = scanner.nextLine();

        Date dateOfBirth = parseDate(dateOfBirthStr);
        Date registrationDate = parseDate(registrationDateStr);

        if (dateOfBirth == null || registrationDate == null) {
            System.out.println("Invalid Date format for Date of Birth or Registration Date.");
            return;
        }

        User newUser = null;
        switch (userType) {
            case "host":
                newUser = createHost(scanner, userId, firstName, lastName, dateOfBirth, registrationDate);
                break;
            case "standard":
                newUser = createStandardCustomer(scanner, userId, firstName, lastName, dateOfBirth, registrationDate);
                break;
            case "gold":
                newUser = createGoldCustomer(scanner, userId, firstName, lastName, dateOfBirth, registrationDate);
                break;
            default:
                System.out.println("Invalid user type specified.");
                return;
        }

        if (newUser != null) {
            users.add(newUser);
            System.out.println("User added successfully: " + newUser);
        }
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }


    private Host createHost(Scanner scanner, int userId, String firstName, String lastName, Date dateOfBirth, Date registrationDate) {
        // Assume we collect the tax number here
        System.out.print("Enter tax number: ");
        double taxNumber = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        return new Host(userId, dateOfBirth, firstName, lastName, registrationDate, taxNumber);
    }

    private StandardCustomer createStandardCustomer(Scanner scanner, int userId, String firstName, String lastName, Date dateOfBirth, Date registrationDate) {
        // Assume we collect the preferred payment method here
        System.out.print("Enter preferred payment method: ");
        String paymentMethod = scanner.nextLine();
        return new StandardCustomer(userId, dateOfBirth, firstName, lastName, registrationDate,paymentMethod);
    }

    private GoldCustomer createGoldCustomer(Scanner scanner, int userId, String firstName, String lastName, Date dateOfBirth, Date registrationDate) {
        // Assume we collect the preferred payment method and gold level here
        System.out.print("Enter preferred payment method: ");
        String paymentMethod = scanner.nextLine();
        System.out.print("Enter gold level (1-3): ");
        int goldLevel = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (goldLevel < 1 || goldLevel > 3) {
            System.out.println("Invalid gold level. Must be between 1 and 3.");
            return null;
        }
        return new GoldCustomer(userId, dateOfBirth, firstName, lastName, registrationDate,paymentMethod, goldLevel);
    }


    /**
     * Retrieves a user by their unique ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return The User object with the specified ID, or null if not found.
     */
    private User getUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null; // User not found
    }

    /**
     * Retrieves a property by its unique ID.
     *
     * @param propertyId The unique ID of the property to retrieve.
     * @return The Property object if found, or null if no property with the given ID exists.
     */
    private Property getPropertyById(int propertyId) {
        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                return property;
            }
        }
        return null; // Property not found
    }

    /**
     * Deletes a user from the BASIC system based on the user ID.
     *
     * @param userId The unique ID of the user to be deleted.
     */
    public void deleteUser(int userId) {
        User user = getUserById(userId);
        if (user != null) {
            users.remove(user);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    /**
     * Retrieves and displays the details of a user given their unique ID.
     *
     * @param userId The unique ID of the user whose details are to be displayed.
     */
    public void getUserDetails(int userId) {
        User foundUser = null;
        for (User user : users) {
            if (user.getUserId() == userId) {
                foundUser = user;
                break;
            }
        }
        if (foundUser != null) {
            System.out.println(foundUser);
        } else {
            System.out.println("User not found.");
        }
    }

    /**
     * Displays the details of a property given its unique ID.
     *
     * @param propertyId The unique ID of the property whose details are to be displayed.
     */
    public void getPropertyDetails(int propertyId) {
        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                System.out.println(property);  // This will use the toString() method of the Property class
                return;
            }
        }
        System.out.println("Property with given ID not found.");
    }

    /**
     * Adds a new property to the list of properties in the application.
     * Prompts the user for property information, including Property ID, type, number
     * of bedrooms, number of rooms, city, price per day, and the host's user ID.
     * Validates input and checks for duplicate Property IDs before adding the property.
     * The property type determines whether a SharedProperty or FullProperty is created.
     *
     * @throws InputMismatchException if the input format is incorrect.
     */
    public void addProperty() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Property ID: ");
        int propertyId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (getPropertyById(propertyId) != null) {
            System.out.println("A property with this ID already exists. Please use a unique ID.");
            return;
        }

        System.out.print("Enter type of property (shared/full): ");
        String propertyType = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter number of bedrooms: ");
        int noBedRooms = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter number of rooms: ");
        int noRooms = scanner.nextInt();

        scanner.nextLine(); // Consume newline

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter price per day: ");
        double pricePerDay = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter host user ID: ");
        int hostUserId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Host host = (Host) getUserById(hostUserId);
        if (host == null) {
            System.out.println("Host with user ID " + hostUserId + " does not exist. Please create the host first.");
            return;
        }

        Property newProperty;
        switch (propertyType) {
            case "shared":
                newProperty = new SharedProperty(propertyId, noBedRooms, noRooms, city, pricePerDay,host);
                break;
            case "full":
                System.out.print("Enter the size of the house in square meters: ");
                double size = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                newProperty = new FullProperty(propertyId, noBedRooms, noRooms, city, size, pricePerDay, host);
                break;
            default:
                System.out.println("Invalid property type specified. Please enter 'shared' or 'full'.");
                return;
        }

        properties.add(newProperty);
        System.out.println("Property added successfully: " + newProperty);
    }


    /**
     * Deletes a property from the BASIC system based on the property ID.
     *
     * @param propertyId The unique ID of the property to be deleted.
     */
    public void deleteProperty(int propertyId) {
        Property property = getPropertyById(propertyId);
        if (property != null) {
            properties.remove(property);
            System.out.println("Property deleted successfully.");
        } else {
            System.out.println("Property not found.");
        }
    }

    public void addBooking() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID for booking: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        User user = getUserById(userId);
        if (user == null) {
            System.out.println("User ID " + userId + " does not exist.");
            return;
        }

        System.out.print("Enter Property ID for booking: ");
        int propertyId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Property property = getPropertyById(propertyId);
        if (property == null) {
            System.out.println("Property ID " + propertyId + " does not exist.");
            return;
        }

        System.out.print("Enter booking start date (dd/MM/yyyy): ");
        String startDateStr = scanner.nextLine();
        Date startDate = parseDate(startDateStr);
        if (startDate == null) {
            System.out.println("Invalid start date format.");
            return;
        }

        System.out.print("Enter booking end date (dd/MM/yyyy): ");
        String endDateStr = scanner.nextLine();
        Date endDate = parseDate(endDateStr);
        if (endDate == null) {
            System.out.println("Invalid end date format.");
            return;
        }

        if (startDate.after(endDate)) {
            System.out.println("Start date must be before end date.");
            return;
        }

        Booking newBooking = new Booking(user, property, startDate, endDate, false);
        // Assuming User class has a method to add a booking to its booking list
        user.addBooking(newBooking);

        System.out.println("Booking added successfully.");
    }

    /**
     * Calculates and displays the cost of a booking for a given user ID and property ID.
     *
     * @param userId     The ID of the user who made the booking.
     * @param propertyId The ID of the property that was booked.
     */
    public void getBookingCost(int userId, int propertyId) {
        User user = getUserById(userId);
        if (user != null) {
            for (Booking booking : user.getBookings()) {
                if (booking.getProperty().getPropertyId() == propertyId) {
                    System.out.println("Booking cost for user ID " + userId + " and property ID " + propertyId + " is: " + booking.totalCost());
                    return;
                }
            }
        }
        System.out.println("No booking found for user ID " + userId + " and property ID " + propertyId);
    }

    /**
     * Retrieves and displays the bookings for a given user ID.
     *
     * @param userId The ID of the user whose bookings are to be displayed.
     */
    public void getUserBooking(int userId) {
        User user = getUserById(userId);
        if (user != null && !user.getBookings().isEmpty()) {
            System.out.println("Bookings for user ID " + userId + ":");
            for (Booking booking : user.getBookings()) {
                System.out.println(booking);
            }
        } else {
            System.out.println("No bookings found for user ID " + userId);
        }
    }

    /**
     * Lists all the users registered in the BASIC system.
     */
    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("There are no users to display.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    /**
     * Lists all the properties available in the BASIC system.
     */
    public void listProperties() {
        if (properties.isEmpty()) {
            System.out.println("There are no properties to display.");
        } else {
            for (Property property : properties) {
                System.out.println(property);
            }
        }
    }

    public double getDiscountForUser(int userId) {
        User user = getUserById(userId);
        if (user == null) {
            // Consider logging this error as well
            System.out.println("User with ID " + userId + " does not exist.");
            return 0.0;
        }

        if (user instanceof GoldCustomer) {
            GoldCustomer goldCustomer = (GoldCustomer) user;
            return goldCustomer.getDiscountForUser(); // Use the method from GoldCustomer
        } else if (user instanceof StandardCustomer) {
            StandardCustomer standardCustomer = (StandardCustomer) user;
            return standardCustomer.getDiscountForUser(); // Use the method from StandardCustomer
        } else {
            return 0.0; // No discount for other types of users
        }
    }

    public void addInspectionToProperty(int propertyId, String inspectionReport) {
        Property property = getPropertyById(propertyId);
        if (property == null) {
            System.out.println("Property with ID " + propertyId + " does not exist.");
            return;
        }

        // Get the current date without time
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date inspectionDate = calendar.getTime();

        // Add the inspection report to the property's inspection HashMap
        // If there's already an inspection for today, it will be replaced
        property.getInspection().put(inspectionDate, inspectionReport);

        System.out.println("Inspection added for property ID " + propertyId + " on " + inspectionDate + ": " + inspectionReport);
    }

    public void comparePropertyPricesPerDay(int propertyId1, int propertyId2) {
        Property property1 = getPropertyById(propertyId1);
        Property property2 = getPropertyById(propertyId2);

        if (property1 == null || property2 == null) {
            if (property1 == null) {
                System.out.println("Property with ID " + propertyId1 + " does not exist.");
            }
            if (property2 == null) {
                System.out.println("Property with ID " + propertyId2 + " does not exist.");
            }
            return;
        }

        // After implemented the Comparable interface
        int comparisonResult = property1.compareTo(property2);

        if (comparisonResult < 0) {
            System.out.println("Property ID " + propertyId1 + " is cheaper.");
        } else if (comparisonResult > 0) {
            System.out.println("Property ID " + propertyId2 + " is cheaper.");
        } else {
            System.out.println("Both properties have the same price!");
        }
    }



    /**
     * The entry point of the BASIC application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        BASIC basic = new BASIC();
        PopulateData.populate(basic);

        basic.menu();
    }
}
