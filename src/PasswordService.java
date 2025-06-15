import java.security.SecureRandom;

public class PasswordService {
    private final PasswordConfig config;
    private final SecureRandom random = new SecureRandom();

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIALS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    public PasswordService(PasswordConfig config) {
        this.config = config;
    }

    public String generatePassword() {
        StringBuilder characterPool = new StringBuilder();

        if (config.isIncludeUppercase()) {
            characterPool.append(UPPERCASE);
        }
        if (config.isIncludeLowercase()) {
            characterPool.append(LOWERCASE);
        }
        if (config.isIncludeDigits()) {
            characterPool.append(DIGITS);
        }
        if (config.isIncludeSpecialChars()) {
            characterPool.append(SPECIALS);
        }

        if (characterPool.length() == 0) {
            throw new IllegalStateException("No character sets selected. Please select at least one character type.");
        }

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < config.getLength(); i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}