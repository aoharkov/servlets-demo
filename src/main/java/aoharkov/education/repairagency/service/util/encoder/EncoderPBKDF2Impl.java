package aoharkov.education.repairagency.service.util.encoder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class EncoderPBKDF2Impl implements Encoder {
    private static final Logger LOGGER = LogManager.getLogger(EncoderPBKDF2Impl.class);

    private static final int LENGTH_OF_SALT = 16;
    private static final int ITERATION_COUNT = 65536;
    private static final int KEY_LENGTH = 128;
    private static final String DEFAULT_VALUE_FOR_HASH = "********";
    private static final String PBKDF2_ALGORITHM_NAME = "PBKDF2WithHmacSHA1";
    private SecretKeyFactory hashFactory;

    public EncoderPBKDF2Impl() {
        try {
            hashFactory = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM_NAME);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public String encode(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[LENGTH_OF_SALT];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
        byte[] hash = DEFAULT_VALUE_FOR_HASH.getBytes();
        try {
            hash = hashFactory.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException e) {
            LOGGER.error(e.getMessage());
        }
        return String.valueOf(hash);
    }
}
