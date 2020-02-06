package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Role;
import aoharkov.education.repairagency.domain.User;

public interface AdminService {

    Page<User> findAllUsers(int page, int itemsPerPage);

    void setRoleToUser(Role role, Integer id);
}
