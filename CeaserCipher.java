import java.util.Scanner;

public class CeaserCipher {
    // Method to encrypt the text
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26; // Ensure shift is within the range of 0-25

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) { // Check if the character is a letter
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char encryptedChar = (char) ((character - base + shift + 26) % 26 + base);
                result.append(encryptedChar);
            } else {
                result.append(character); // Append non-alphabetic characters as is
            }
        }
        return result.toString();
    }

    // Method to decrypt the text
    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift); // Decryption is the inverse of encryption
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Caesar Cipher Implementation");
        System.out.println("Enter the text to encrypt:");
        String plainText = scanner.nextLine();

        System.out.println("Enter the shift key (integer):");
        int shift = scanner.nextInt();

        String encryptedText = encrypt(plainText, shift);
        System.out.println("Encrypted text: " + encryptedText);

        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }
}
