import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	// Test boundary checks
    @Test
    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("!")); // Assuming '!' is the lowest in range
        assertFalse(CryptoManager.isStringInBounds("a")); // Assuming lowercase 'a' is out of range
        assertTrue(CryptoManager.isStringInBounds("_")); // Assuming '_' is the highest in range
        assertFalse(CryptoManager.isStringInBounds("`")); // Assuming '`' is out of range
    }

    // Test Caesar Cipher Encryption and Decryption
    @Test
    public void testCaesarCipher() {
        String plaintext = "HELLO WORLD";
        int key = 5;
        String encrypted = CryptoManager.caesarEncryption(plaintext, key);
        assertEquals(plaintext, CryptoManager.caesarDecryption(encrypted, key));
    }

    // Test encrypting and decrypting an empty string
    @Test
    public void testCaesarCipherWithEmptyString() {
        String empty = "";
        int key = 10;
        assertEquals(empty, CryptoManager.caesarDecryption(CryptoManager.caesarEncryption(empty, key), key));
    }

    // Test encryption with extreme key values
    @Test
    public void testCaesarCipherWithExtremeKeyValues() {
        String text = "HELLO WORLD";
        int key = 999; // large positive key
        assertEquals(text, CryptoManager.caesarDecryption(CryptoManager.caesarEncryption(text, key), key));
        
        int negativeKey = -999; // large negative key
        assertEquals(text, CryptoManager.caesarDecryption(CryptoManager.caesarEncryption(text, negativeKey), negativeKey));
    }

    // Test Bellaso Cipher Encryption and Decryption
    @Test
    public void testBellasoCipher() {
        String plaintext = "HELLO WORLD";
        String bellasoStr = "CRYPTO";
        String encrypted = CryptoManager.bellasoEncryption(plaintext, bellasoStr);
        assertEquals(plaintext, CryptoManager.bellasoDecryption(encrypted, bellasoStr));
    }

    // Test encrypting and decrypting with an empty string and empty key
    @Test
    public void testBellasoCipherWithEmptyString() {
        String empty = "";
        String bellasoStr = "";
        assertEquals(empty, CryptoManager.bellasoDecryption(CryptoManager.bellasoEncryption(empty, bellasoStr), bellasoStr));
    }

    // Test Bellaso Cipher with mismatched lengths
    @Test
    public void testBellasoCipherWithLongKey() {
        String plaintext = "SHORT";
        String longBellasoStr = "VERYLONGKEYTHATREPEATS";
        String encrypted = CryptoManager.bellasoEncryption(plaintext, longBellasoStr);
        assertEquals(plaintext, CryptoManager.bellasoDecryption(encrypted, longBellasoStr));
    }

}
