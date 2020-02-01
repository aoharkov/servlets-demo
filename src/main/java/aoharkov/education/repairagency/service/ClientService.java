package aoharkov.education.repairagency.service;

public interface ClientService extends RegisteredUserService {

    void makeRequest();

    void leaveFeedback(Integer requestId);
}
