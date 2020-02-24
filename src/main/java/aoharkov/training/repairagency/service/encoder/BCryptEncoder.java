package aoharkov.training.repairagency.service.encoder;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptEncoder implements Encoder {

    @Override
    public String encode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean check(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
