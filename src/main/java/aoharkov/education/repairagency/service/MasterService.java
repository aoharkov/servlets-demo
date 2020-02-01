package aoharkov.education.repairagency.service;

public interface MasterService extends RegisteredUserService {

    void processOrder(Integer orderId);

    void updateRoleOfUserWithId(Integer id);
}
