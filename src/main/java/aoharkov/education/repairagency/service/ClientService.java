package aoharkov.education.repairagency.service;

public interface ClientService extends UserService {

    void makeRequest();

    void leaveFeedback(Integer requestId);
}
