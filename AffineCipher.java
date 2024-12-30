import java.util.Scanner;

public class AffineCipher {

    // Method to encrypt the text
    public static String encrypt(String plaintext, int a, int b) {
        StringBuilder cipherText = new StringBuilder();

        for (char character : plaintext.toUpperCase().toCharArray()) {
            if (Character.isLetter(character)) { // Check if the character is a letter
                int x = character - 'A'; // Convert character to 0-25 range
                int y = (a * x + b) % 26; // Apply the Affine transformation
                cipherText.append((char) (y + 'A')); // Convert back to a character
            } else {
                cipherText.append(character); // Keep non-alphabetic characters unchanged
            }
        }
        return cipherText.toString();
    }

    // Method to decrypt the text
    public static String decrypt(String cipherText, int a, int b) {
        StringBuilder plainText = new StringBuilder();

        // Calculate modular multiplicative inverse of `a` modulo 26
        int aInverse = modInverse(a, 26);

        for (char character : cipherText.toUpperCase().toCharArray()) {
            if (Character.isLetter(character)) { // Check if the character is a letter
                int y = character - 'A'; // Convert character to 0-25 range
                int x = (aInverse * (y - b + 26)) % 26; // Apply the inverse transformation
                plainText.append((char) (x + 'A')); // Convert back to a character
            } else {
                plainText.append(character); // Keep non-alphabetic characters unchanged
            }
        }
        return plainText.toString();
    }

    // Helper method to calculate modular multiplicative inverse
    public static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        throw new IllegalArgumentException("Multiplicative inverse for the given key does not exist.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Affine Cipher Implementation");

        System.out.println("Enter the text to encrypt:");
        String plaintext = scanner.nextLine();

        System.out.println("Enter the key 'a' (must be coprime with 26):");
        int a = scanner.nextInt();

        System.out.println("Enter the key 'b' (any integer):");
        int b = scanner.nextInt();

        try {
            String encryptedText = encrypt(plaintext, a, b);
            System.out.println("Encrypted text: " + encryptedText);

            String decryptedText = decrypt(encryptedText, a, b);
            System.out.println("Decrypted text: " + decryptedText);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
