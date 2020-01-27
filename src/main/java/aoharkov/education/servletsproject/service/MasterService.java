package aoharkov.education.servletsproject.service;

public interface MasterService extends UserService {

    void processOrder(Integer orderId);
}
