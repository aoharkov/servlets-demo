package aoharkov.education.repairagency.service;

public interface ManagerService extends RegisteredUserService {

    void transformRequestIntoOrder(Integer requestId);

    void transformRequestIntoRefusal(Integer requestId);
}
