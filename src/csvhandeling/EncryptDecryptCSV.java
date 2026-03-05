package csvhandeling;
import java.util.Base64;

/*
 * Program Name : EncryptDecryptCSV
 * Description  : Encrypts and decrypts sensitive CSV fields.
 * Input        : Salary / Email
 * Output       : Encrypted and decrypted values
 */
public class EncryptDecryptCSV {

    // Method to encrypt data
    public static String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    // Method to decrypt data
    public static String decrypt(String data) {
        return new String(Base64.getDecoder().decode(data));
    }

    public static void main(String[] args) {

        String salary = "50000";

        // Encrypt salary
        String encrypted = encrypt(salary);
        System.out.println("Encrypted Salary: " + encrypted);

        // Decrypt salary
        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted Salary: " + decrypted);
    }
}
