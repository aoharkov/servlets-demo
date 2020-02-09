package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.domain.User;

import java.util.List;

public interface AdminService {

    List<User> findAllUsers(int page, int itemsPerPage);

    void setRoleToUser(User user, Role role);
}
