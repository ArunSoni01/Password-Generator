import java.util.Scanner;

public class PasswordGenerator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Password Generator ===");

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUppercase = scanner.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean includeLowercase = scanner.nextBoolean();

        System.out.print("Include digits? (true/false): ");
        boolean includeDigits = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean includeSpecialChars = scanner.nextBoolean();

        // Set user input into config
        PasswordConfig config = new PasswordConfig();
        config.setLength(length);
        config.setIncludeUppercase(includeUppercase);
        config.setIncludeLowercase(includeLowercase);
        config.setIncludeDigits(includeDigits);
        config.setIncludeSpecialChars(includeSpecialChars);

        // Create password generator service
        PasswordService passwordService = new PasswordService(config);

        try {
            String password = passwordService.generatePassword();
            System.out.println("Generated Password: " + password);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}