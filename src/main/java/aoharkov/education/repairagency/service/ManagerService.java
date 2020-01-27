package aoharkov.education.repairagency.service;

public interface ManagerService extends UserService {

    void transformRequestIntoOrder(Integer requestId);

    void transformRequestIntoRefusal(Integer requestId);
}
