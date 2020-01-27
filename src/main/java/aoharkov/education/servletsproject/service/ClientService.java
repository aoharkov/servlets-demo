package aoharkov.education.servletsproject.service;

public interface ClientService extends UserService {

    void makeRequest();

    void leaveFeedback(Integer requestId);
}
