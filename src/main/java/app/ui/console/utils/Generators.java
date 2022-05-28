package app.ui.console.utils;

import java.security.SecureRandom;

public class Generators {
    /**
     * Generates an Employee ID
     * @return Employee ID
     */
    public static String generateEmployeeID()
    {
        int len = 8;
        final String chars = "0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
    /**
     * Generates a random password
     * @return password
     */
    public static String generateRandomPassword()
    {
        int len = 7;
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        //special characters: !@#$%^&*
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

}
