

public class EventReservationSystem {

    public static void main(String[] args) {
        EventReservationSystem system = new EventReservationSystem();
        
        // Example test cases
        String bookingCode = "Event_123";
        String password = "P@ssw0rd";
        
        System.out.println(system.makeReservation(bookingCode, password));
        
        // Test with invalid inputs
        System.out.println(system.makeReservation("InvalidCode", password));
        System.out.println(system.makeReservation(bookingCode, "pass"));
        System.out.println(system.makeReservation(bookingCode, "Password123!"));
    }

    // Method to check the format of the booking code
    public boolean checkBookingCode(String code) {
        if (code == null || code.length() > 12) {
            return false;
        }
        return code.contains("_");
    }

    // Method to check the complexity of the password
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;
        }

        return hasUpperCase && hasDigit && hasSpecialChar;
    }

    // Method to make a reservation based on booking code and password
    public String makeReservation(String bookingCode, String password) {
        if (!checkBookingCode(bookingCode)) {
            return "Booking code is incorrectly formatted.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet the complexity requirements.";
        }
        return "Reservation successfully made!";
    }
}
