package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.domain.User;

public interface AdminService {

    Page<User> findAllUsers(int page, int itemsPerPage);

    void setRoleToUser(User user, Role role);
}
