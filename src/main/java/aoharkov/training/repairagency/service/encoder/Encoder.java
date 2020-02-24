package aoharkov.training.repairagency.service.encoder;

public interface Encoder {

    String encode(String password);

    boolean check(String password, String hashedPassword);
}
