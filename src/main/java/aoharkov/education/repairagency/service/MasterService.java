package aoharkov.education.repairagency.service;

public interface MasterService extends UserService {

    void processOrder(Integer orderId);
}
