package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.domain.Role;
import aoharkov.education.repairagency.domain.User;

import java.util.List;

public interface AdminService {

    List<User> findAllUsers(int page, int itemsPerPage);

    void setRoleToUser(User user, Role role);
}
